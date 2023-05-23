package com.blackarealab.tryoutwebflux.components;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import reactor.core.scheduler.Schedulers;

@Service
public class Consumer {
    private final Producer producer;

    public Consumer(Producer producer) {
        this.producer = producer;
    }

    @PostConstruct
    public void consumeData() {
        producer.produceData()
                .onBackpressureBuffer()
                .doOnNext(this::logReceive)
                .publishOn(Schedulers.newSingle("consumer-thread"))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(value -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    logConsume(value);
                });
    }

    private void logConsume(Long value) {
        System.out.printf("Consumed event %d on thread %s%n", value, Thread.currentThread().getName());
    }

    private void logReceive(Long value) {
        System.out.printf("Received event %d on thread %s%n", value, Thread.currentThread().getName());
    }
}
