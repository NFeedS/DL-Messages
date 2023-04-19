package com.nfeeds.data.messages.repository;

import com.nfeeds.data.messages.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * <p> Interface used by Spring Data Rest to create CRUD endpoints over the User table. </p>
 * <p> The base endpoints generated will have the form: </p>
 * <code>
 * <p><i> GET|POST : {basePath}/messages </i></p>
 * <p><i> GET|POST|PUT|DELETE : {basePath}/messages/{id} </i></p>
 * </code>
 * <p>(plus the /profile and OPTIONS endpoint to get the endpoints metadata and options) </p>
 * <p>
 * <p> Additional endpoint will be created based on the query functions of the interface: </p>
 * <code><p><i> GET : {basePath}/messages/search/{specified_path|function_name}?{parameters} </i></p></code>
 * <p>
 * <p> The response of the endpoint will follow HATEOAS specifications. </p>
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {

    /**
     * <p> Search all the messages belonging to a certain topic.</p>
     * <code><p><i> GET : {basePath}/messages/search/topic?id={topic_id} </i></p></code>
     * <p>
     * @param topic_id The id of the topic of the messages searched.
     * @return The list of messages that belong to the topic indicated by topic_id.
     */
    @RestResource(path = "topic", rel = "byTopic")
    List<Message> findByTopicId(@Param("id") String topic_id);
}
