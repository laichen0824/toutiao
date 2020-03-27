package com.nowcoder.dao;

import com.nowcoder.model.Comment;
import com.nowcoder.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> queryUserList(@Param("name") String name);

    List<Comment> queryComment(Comment comment);
}
