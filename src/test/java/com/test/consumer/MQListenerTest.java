package com.test.consumer;

import com.test.consumer.entity.MyMessage;
import com.test.consumer.listener.MQListener;
import com.test.consumer.repository.MessageRepository;
import com.test.consumer.service.IMessageService;
import com.test.consumer.service.MessageService;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.Enumeration;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MQListenerTest {

    @Autowired
    private MQListener mqListener;
    @MockBean
    private IMessageService messageService;

    @Test
    public void sendMessage() throws Exception {
        mqListener.processMessage(new ActiveMQTextMessage());
        verify(messageService, only()).save(Mockito.any(MyMessage.class));
    }
}
