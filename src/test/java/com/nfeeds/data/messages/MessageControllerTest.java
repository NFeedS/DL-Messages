package com.nfeeds.data.messages;

import com.nfeeds.data.messages.controller.MessagesController;
import com.nfeeds.data.messages.model.Message;
import com.nfeeds.data.messages.repository.MessageRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MessageControllerTest {

    @Mock
    private MessageRepository messageRepository;
    @InjectMocks
    private MessagesController messagesController;

    private Message message1 = new Message(1,"topic1","content1","type1");
    private Message message2 = new Message(2,"topic2","content2","type2");
    private Message message3 = new Message(3,"topic3","content3","type3");
    private List<Message> messageList;

    @BeforeEach
    public void setup() {
        messageList = Arrays.asList(message1,message2,message3);
        when(messageRepository.findByTopicId()).
    }
}
