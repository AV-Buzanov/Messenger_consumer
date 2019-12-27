package com.test.consumer.service;

import com.test.consumer.entity.MyMessage;
import com.test.consumer.repository.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class MessageService implements IMessageService{
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Collection<MyMessage> findAll() {
        return messageRepository.findAll();
    }

    public MyMessage findOne(final String id) throws Exception {
        if (id == null || id.isEmpty()) throw new Exception("Id can't by empty or null");
        return messageRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(final MyMessage myMessage) throws Exception {
        if (myMessage == null || myMessage.getId() == null || myMessage.getId().isEmpty())
            throw new Exception("Argument can't be empty or null");
        messageRepository.saveAndFlush(myMessage);
    }

    @Transactional
    public void delete(final String id) throws Exception {
        if (id == null || id.isEmpty()) throw new Exception("Id can't by empty or null");
        messageRepository.deleteById(id);
    }

}
