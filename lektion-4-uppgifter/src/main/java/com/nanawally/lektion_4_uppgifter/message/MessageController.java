package com.nanawally.lektion_4_uppgifter.message;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/message")
@RestController
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public Mono<ResponseEntity<Message>> createMessage(@Valid @RequestBody Message message) {
        return messageService.createMessage(message)
                .map(savedMessage -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(savedMessage));
    }

}
