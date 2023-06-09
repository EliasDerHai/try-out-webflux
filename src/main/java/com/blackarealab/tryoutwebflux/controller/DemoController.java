package com.blackarealab.tryoutwebflux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class DemoController {

    @GetMapping("/numbers")
    public Flux<Integer> returnNumbers() {
        return Flux.just(1, 2, 3, 4, 5);
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Long> returnStream() {
        return Flux.interval(Duration.ofMillis(100));
    }
}