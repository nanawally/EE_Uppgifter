package org.nanawally.lecture2uppgifter.uppgift4567;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DuckController {

    private final DuckService duckService;

    @Autowired
    public DuckController(@Qualifier("defaultDuckService") DuckService duckService) {
        this.duckService = duckService;
    }

    @GetMapping
    public Mono<ResponseEntity<Duck>> getDuck(
            @RequestParam String message,
            @RequestParam String url
    ) {
        return duckService.getDuck(message, url)
                .map(duck -> ResponseEntity.ok().body(duck))
                .switchIfEmpty(Mono.just(
                        ResponseEntity.badRequest().build()
                ));
    }

}
