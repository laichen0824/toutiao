package com.nowcoder.mapper;

import com.nowcoder.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CommentMapper {

    int insert(Comment record);

    Comment getById(Integer id);

    int update(Comment record);

    List<Comment> getByEntity(@Param("entityId") int entityId, @Param("entityType") int entityType);

    int getCount(@Param("entityId") int entityId, @Param("entityType") int entityType);

    int deleteByNewsId(@Param("entityId") int entityId);

    List<Map<String, Object>> getAllComment(@Param("name") String name);

    int deleteByUserId(@Param("userId") int userId);

}