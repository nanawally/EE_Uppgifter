package org.nanawally.lecture2uppgifter.uppgift4567;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface DuckService {

    Mono<Duck> getDuck (String message, String url);

}
