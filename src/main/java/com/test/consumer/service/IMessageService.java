package com.test.consumer.service;

import com.test.consumer.entity.MyMessage;

import java.util.Collection;

public interface IMessageService {

    Collection<MyMessage> findAll();

    MyMessage findOne(final String id) throws Exception;

    void save(final MyMessage myMessage) throws Exception;

    void delete(final String id) throws Exception;
}
