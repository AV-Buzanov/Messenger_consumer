package com.test.consumer.entity;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "app_message")
public class MyMessage {

    @Id
    private String id;

    private String text;

    private Timestamp timestamp;

    public MyMessage() {
    }

    public MyMessage(final TextMessage message) throws JMSException {
        this.id = message.getJMSMessageID();
        this.text = message.getText();
        this.timestamp = new Timestamp(message.getJMSTimestamp());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
