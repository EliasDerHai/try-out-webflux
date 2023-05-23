package com.blackarealab.tryoutwebflux.components;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class Producer {
    private final AtomicLong counter = new AtomicLong(0);

    public Flux<Long> produceData() {
        return Flux.interval(Duration.ofSeconds(1))
                .doOnNext(this::logProduce);
    }


    private void logProduce(Long value) {
        System.out.printf("Produced event %d on thread %s%n", value, Thread.currentThread().getName());
    }
}
