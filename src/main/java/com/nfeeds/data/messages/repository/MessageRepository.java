package com.nfeeds.data.messages.repository;

import com.nfeeds.data.messages.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    @RestResource(path = "topic", rel = "byTopic")
    List<Message> findByTopicId(@Param("id") String topic_id);

}
