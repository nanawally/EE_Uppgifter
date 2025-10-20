package com.nanawally.lektion_4_uppgifter.message;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("messages")
public record Message(
        Long id,
        String message,
        @Column LocalDateTime createdAt,
        @Column boolean pinned
) {
}
