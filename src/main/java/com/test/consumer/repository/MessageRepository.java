package com.test.consumer.repository;

import com.test.consumer.entity.MyMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MyMessage, String> {
}