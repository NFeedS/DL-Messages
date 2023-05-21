package com.nfeeds.data.messages.repository;

import com.nfeeds.data.messages.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query("select m from Message m where m.topicId = :id")
    List<Message> findByTopicId(@Param("id") String topic_id);
}
