package com.cts.order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class KitchenService {

    public static void main(String[] args) throws InterruptedException {

        Flux<Long> orders = Flux.interval(Duration.ofMillis(500))
                                .map(i -> i + 1)   // ✅ Start from 1 instead of 0
                                .take(5);

        orders
            .flatMap(KitchenService::prepareFood)
            .subscribe(result ->
                    System.out.println("👨‍🍳 " + result)
            );

        Thread.sleep(4000);
    }

    static Mono<String> prepareFood(Long orderId) {
        return Mono.just("Order #" + orderId + " Prepared")
                   .delayElement(Duration.ofSeconds(1));
    }
}
