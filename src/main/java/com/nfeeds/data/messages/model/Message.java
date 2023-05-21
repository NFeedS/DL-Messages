package com.nfeeds.data.messages.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message {

    /** Incrementally auto-generated number that identifies a message uniquely. */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    /** The identifier of the topic that the message is related to. */
    @Column(nullable = false)
    private String topicId;

    /** Arbitrary string with the content of the message. */
    @Column(nullable = false)
    private String content;

    /** Type of message, define how the system will treat it. */
    @Column(nullable = false)
    private String type;
}
