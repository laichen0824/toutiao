package com.nowcoder.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nowcoder.mapper.CommentMapper;
import com.nowcoder.mapper.LoginTicketMapper;
import com.nowcoder.mapper.NewsMapper;
import com.nowcoder.mapper.UserMapper;
import com.nowcoder.model.LoginTicket;
import com.nowcoder.model.User;
import com.nowcoder.util.ToutiaoUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private LoginTicketMapper loginTicketMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private NewsMapper newsMapper;

    public int deleteUser(Integer id) {
        // 删除资讯
        newsMapper.deleteByUserId(id);

        // 删除评论
        commentMapper.deleteByUserId(id);

        User user = new User();
        user.setId(id);
        user.setIsDelete(1);
        return userMapper.update(user);
    }

    public Map<String, Object> register(String username, String password) {
        Map<String, Object> map = new HashMap<>(16);
        if (StringUtils.isBlank(username)) {
            map.put("msgname", "用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)) {
            map.put("msgpwd", "密码不能为空");
            return map;
        }

        User user = userMapper.getByName(username);

        if (user != null) {
            map.put("msgname", "用户名已经被注册");
            return map;
        }

        // 密码强度
        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        String head = String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000));
        user.setHeadUrl(head);
        user.setPassword(ToutiaoUtil.MD5(password + user.getSalt()));
        user.setUserRole(0);
        user.setIsDelete(0);
        user.setCreateDate(new Date());
        userMapper.insert(user);

        // 登陆
        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }


    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>(16);
        if (StringUtils.isBlank(username)) {
            map.put("msgname", "用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)) {
            map.put("msgpwd", "密码不能为空");
            return map;
        }

        User user = userMapper.getByName(username);

        if (user == null) {
            map.put("msgname", "用户不存在或被删除");
            return map;
        }

        if (!ToutiaoUtil.MD5(password + user.getSalt()).equals(user.getPassword())) {
            map.put("msgpwd", "密码不正确");
            return map;
        }

        map.put("userId", user.getId());

        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }

    private String addLoginTicket(int userId) {
        LoginTicket ticket = new LoginTicket();
        ticket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000 * 3600 * 24);
        ticket.setExpired(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketMapper.insert(ticket);
        return ticket.getTicket();
    }

    public User getUser(int id) {
        return userMapper.getById(id);
    }

    public void logout(String ticket) {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setTicket(ticket);
        loginTicket.setStatus(1);
        loginTicketMapper.update(loginTicket);
    }

    public void updateImg(User user) {
        userMapper.update(user);
    }

    public Map<String, Object> queryUserList(String name, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        if (StringUtils.isNotBlank(name)) {
            name = "'%" + name + "%'";
        } else {
            name = null;
        }
        List<User> users = userMapper.getUserList(name);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        Map<String, Object> map = new HashMap<>();
        map.put("data", users);
        map.put("count", pageInfo.getTotal());
        map.put("code", "");
        map.put("msg", "");
        return map;
    }


}
