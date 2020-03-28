package com.nowcoder.service;

import com.nowcoder.mapper.MessageMapper;
import com.nowcoder.model.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MessageService {

    @Resource
    MessageMapper messageMapper;

    public int addMessage(Message message) {
        return messageMapper.insert(message);
    }

    public List<Message> getConversationDetail(int userId, int offset, int limit) {
        return messageMapper.getMessageList(userId, offset, limit);
    }

    public List<Message> getConversationList(int userId, int offset, int limit) {
        return messageMapper.getMessageList(userId, offset, limit);
    }

    public int getUnreadCount(int userId) {
        return messageMapper.getMessageCount(userId, 0);
    }
    public int getAllCount(int userId) {
        return messageMapper.getMessageCount(userId, null);
    }

    public void read(){
        messageMapper.read();
    }

    public int deleteMessage(int id) {
        Message message = new Message();
        message.setId(id);
        message.setIsDelete(1);
        return messageMapper.update(message);
    }
}
