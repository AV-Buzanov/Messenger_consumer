package com.test.consumer;

import com.test.consumer.entity.MyMessage;
import com.test.consumer.service.MessageService;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test(expected = Exception.class)
    public void sendMessageNullTest() throws Exception {
        messageService.save(null);
    }

    @Test(expected = Exception.class)
    public void sendMessageNullIdTest() throws Exception {
        final MyMessage myMessage = new MyMessage(getMessage());
        myMessage.setId(null);
        messageService.save(myMessage);
    }

    @Test
    public void sendMessageTest() throws Exception {
        final MyMessage myMessage = new MyMessage(getMessage());
        messageService.save(myMessage);
        final MyMessage testMessage = messageService.findOne(myMessage.getId());
        Assert.assertNotNull(testMessage);
        Assert.assertEquals(testMessage.getText(), myMessage.getText());
        Assert.assertEquals(testMessage.getTimestamp(), myMessage.getTimestamp());
    }

    private TextMessage getMessage() throws JMSException {
        final TextMessage textMessage = new ActiveMQTextMessage();
        textMessage.setText("Message");
        textMessage.setJMSMessageID("id_1");
        textMessage.setJMSTimestamp(System.currentTimeMillis());
        return textMessage;
    }
}
