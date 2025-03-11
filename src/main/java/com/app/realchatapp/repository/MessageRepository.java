package com.app.realchatapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.realchatapp.entity.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByOrderByTimestampAsc();
}