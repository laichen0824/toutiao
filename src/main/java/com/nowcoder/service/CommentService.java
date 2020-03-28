package com.nowcoder.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nowcoder.mapper.CommentMapper;
import com.nowcoder.model.Comment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


@Service
public class CommentService {

    @Resource
    private CommentMapper commentMapper;


    public List<Comment> getCommentsByEntity(int entityId, int entityType) {
        return commentMapper.getByEntity(entityId, entityType);
    }

    public int addComment(Comment comment) {
        return commentMapper.insert(comment);
    }

    public int getCommentCount(int entityId, int entityType) {
        return commentMapper.getCount(entityId, entityType);
    }

    public Map<String, Object> queryComment(String name, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        if (StringUtils.isNotBlank(name)) {
            name = "'%" + name + "%'";
        } else {
            name = null;
        }
        List<Map<String, Object>> comments = commentMapper.getAllComment(name);

        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(comments);
        Map<String, Object> map = new HashMap<>();
        map.put("data", comments);
        map.put("count", pageInfo.getTotal());
        map.put("code", "");
        map.put("msg", "");
        return map;
    }

    public int deleteComment(int id) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setIsDelete(1);
        return commentMapper.update(comment);
    }
}
