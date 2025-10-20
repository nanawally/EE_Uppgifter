package com.nanawally.lektion_4_uppgifter.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Mono<Message> createMessage(Message message) {
        Message entity = new Message(
                null,
                message.message(), // or message.getMessage() depending on your getter
                LocalDateTime.now(),
                false
        );
        logger.info("New message was created");

        return messageRepository.save(entity);
    }
}
