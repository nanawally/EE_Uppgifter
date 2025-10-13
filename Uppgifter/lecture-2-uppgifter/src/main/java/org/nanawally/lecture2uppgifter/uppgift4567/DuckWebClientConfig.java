package org.nanawally.lecture2uppgifter.uppgift4567;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration // This is a config bc we want a Bean inside the class
public class DuckWebClientConfig {

    // WebClient is the modern alternative to RestTemplate
    // Problem w RestTemplate: Synchronous, deprecated

    @Bean ("webClientDuckBuilder") // Bean name
    public WebClient webClientDuckBuilder (WebClient.Builder builder) {
        return builder
                .baseUrl("https://random-d.uk/api/v2/random")
                .build();
    }

}
