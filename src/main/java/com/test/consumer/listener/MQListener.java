package com.test.consumer.listener;

import com.test.consumer.entity.MyMessage;
import com.test.consumer.service.MessageService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class MQListener {
    private final MessageService messageService;

    public MQListener(MessageService messageService) {
        this.messageService = messageService;
    }

    @JmsListener(destination = "${spring.activemq.queue}")
    public void processMessage(final TextMessage message) throws Exception {
        messageService.save(new MyMessage(message));
    }
}
