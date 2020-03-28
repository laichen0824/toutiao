package com.nowcoder.mapper;

import com.nowcoder.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {

    int insert(User record);

    User getById(@Param("id") Integer id);

    int update(User record);

    User getByName(@Param("name") String name);

    List<User> getUserList(@Param("name") String name);
}