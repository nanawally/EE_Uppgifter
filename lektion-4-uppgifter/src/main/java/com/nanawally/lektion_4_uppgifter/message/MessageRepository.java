package com.nanawally.lektion_4_uppgifter.message;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends R2dbcRepository<Message, Long> {
}
