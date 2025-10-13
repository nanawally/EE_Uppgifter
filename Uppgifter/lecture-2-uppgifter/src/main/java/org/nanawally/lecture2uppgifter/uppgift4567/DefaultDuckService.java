package org.nanawally.lecture2uppgifter.uppgift4567;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DefaultDuckService implements DuckService {

    private final WebClient webClient;
    // Why not private final DuckWebClientConfig duckWebClientConfig;?

    @Autowired
    public DefaultDuckService(WebClient webClient) { // IoC Bean goes here from DuckWebClientConfig
        this.webClient = webClient;
    }

    @Override
    public Mono<Duck> getDuck(String message, String url) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/getduck")
                        .queryParam("message", message)
                        .queryParam("url", url)
                        .build()
                )
                .retrieve()
                .onStatus(
                        httpStatusCode -> httpStatusCode.is4xxClientError(),
                        clientResponse -> Mono.error(new RuntimeException("Not found"))
                )
                .onStatus(
                        httpStatusCode -> httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("Server error"))
                )
                .bodyToMono(Duck.class); // Async support. Mono required for async
    }
}
