package com.nowcoder.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nowcoder.dao.CommentDAO;
import com.nowcoder.dao.UserMapper;
import com.nowcoder.model.Comment;
import com.nowcoder.model.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CommentService {
    @Resource
    private CommentDAO commentDAO;
    @Resource
    private UserMapper userMapper;

    public List<Comment> getCommentsByEntity(int entityId, int entityType) {
        return commentDAO.selectByEntity(entityId, entityType);
    }

    public int addComment(Comment comment) {
        return commentDAO.addComment(comment);
    }

    public int getCommentCount(int entityId, int entityType) {
        return commentDAO.getCommentCount(entityId, entityType);
    }

    public void deleteComment(int entityId, int entityType) {
        commentDAO.updateStatus(entityId, entityType, 1);
    }

    public Map<String,Object> queryComment(String name, Integer pageNumber, Integer pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        if(StringUtils.isNotBlank(name)){
            name = "'%" + name + "%'";
        } else {
            name = null;
        }
        List<Comment> users = userMapper.queryComment(new Comment(name));
        PageInfo<Comment> pageInfo = new PageInfo<>(users);
        Map<String,Object> map = new HashMap<>();
        map.put("data",users);
        map.put("count",pageInfo.getTotal());
        map.put("code","");
        map.put("msg","");
        return map;
    }
    public int deleteComment(int id){
       return commentDAO.deleteComment(id);
    }
}
