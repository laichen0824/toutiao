package com.nowcoder.mapper;

import com.nowcoder.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {

    int insert(Message record);

    Message getById(Integer id);

    int update(Message record);

    List<Message> getMessageList(@Param("userId") int userId,
                                 @Param("offset") int offset,
                                 @Param("limit") int limit);

    int getMessageCount(@Param("userId") int userId,
                        @Param("read") Integer read);

    int read();
}