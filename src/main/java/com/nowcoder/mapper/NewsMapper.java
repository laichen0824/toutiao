package com.nowcoder.mapper;

import com.nowcoder.model.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface NewsMapper {

    int insert(News record);

    News getById(Integer id);

    int update(News record);

    int updateCommentCount(@Param("id") int id, @Param("count") int count);

    int updateLikeCount(@Param("id") int id, @Param("count") int count);

    List<News> getNewsList(@Param("userId") int userId,
                           @Param("offset") int offset,
                           @Param("limit") int limit);

    List<Map<String, Object>> getAllNews(@Param("name") String name);

    int deleteByUserId(@Param("userId") int userId);
}