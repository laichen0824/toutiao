package com.nowcoder.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class MailSender implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    private JavaMailSender mailSender;

    public boolean sendWithHTMLTemplate(String to, String subject, Map<String, Object> model) {
        try {

            return true;
        } catch (Exception e) {
            logger.error("发送邮件失败" + e.getMessage());
            return false;
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
