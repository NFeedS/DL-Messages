package com.nfeeds.data.messages.controller;

import com.nfeeds.data.messages.model.Message;
import com.nfeeds.data.messages.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/messages")
public class MessagesController {
        private final MessageRepository messageRepository;
        
        @PostMapping("/")
        public Message createMessage(@RequestBody Message body) {
                log.debug(this.getClass().getSimpleName() + " - createMessage");
                return messageRepository.save(body);
        }

        
        @GetMapping("/{id}")
        public Message getMessage(@PathVariable("id") Integer message_id) {
                log.debug(this.getClass().getSimpleName() + " - getMessage");
                return messageRepository.findById(message_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found"));
        }
        
        
        @GetMapping("/topic/{id}")
        public List<Message> getMessageByTopic(@PathVariable("id") String topic_id) {
                log.debug(this.getClass().getSimpleName() + " - getMessageByTopic");
                return messageRepository.findByTopicId(topic_id);
        }

        
        @GetMapping("/")
        public List<Message> getMessages() {
                log.debug(this.getClass().getSimpleName() + " - getMessages");
                return messageRepository.findAll();
        }

        
        @PutMapping("/{id}")
        public void updateMessage(@RequestBody Message body, @PathVariable("id") Integer message_id) {
                log.debug(this.getClass().getSimpleName() + " - getMessages");
                var message = messageRepository.findById(message_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message to update not found"))
                message.setContent(body.getContent());
                message.setType(body.getType());
                message.setTopicId(body.getTopicId());
                messageRepository.save(message);
        }
        
        
        @DeleteMapping("/{id}")
        public void deleteMessage(@PathVariable("id") Integer message_id){
                log.debug(this.getClass().getSimpleName() + " - deleteMessage");
                messageRepository.deleteById(message_id);
        }
}