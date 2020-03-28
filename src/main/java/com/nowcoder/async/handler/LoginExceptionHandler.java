package com.nowcoder.async.handler;

import com.nowcoder.async.EventHandler;
import com.nowcoder.async.EventModel;
import com.nowcoder.async.EventType;
import com.nowcoder.model.Message;
import com.nowcoder.service.MessageService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;


@Component
public class LoginExceptionHandler implements EventHandler {

    @Resource
    MessageService messageService;

    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void doHandle(EventModel model) {
        // 判断是否有异常登陆
        Message message = new Message();
        message.setToId(model.getActorId());
        message.setContent("你上次的登陆ip异常");
        message.setFromId(3);
        message.setCreatedDate(new Date());
        message.setConversationId(model.getActorId() + "_" + 3);
        messageService.addMessage(message);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("happyjava@foxmail.com");
        msg.setTo("1015030682@qq.com");
        msg.setSubject("登录异常");
        msg.setText(model.getExt("username") + "登录异常");
        // javaMailSender.send(msg);

    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LOGIN);
    }
}
