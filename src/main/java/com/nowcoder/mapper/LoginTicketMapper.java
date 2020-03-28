package com.nowcoder.mapper;

import com.nowcoder.model.LoginTicket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginTicketMapper {

    int insert(LoginTicket record);

    LoginTicket getById(@Param("id") Integer id);

    int update(LoginTicket record);

    LoginTicket getByTicket(@Param("ticket") String ticket);
}