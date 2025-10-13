package org.nanawally.lecture2uppgifter.uppgift4567;

import reactor.core.publisher.Mono;

public interface DuckService {

    // Webflux
    Mono<Duck> getDuck (String message, String url);

}
