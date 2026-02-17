package com.cts.order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class DeliveryService {

    public static void main(String[] args) throws InterruptedException {

        Flux<Long> preparedOrders = Flux.range(1, 5)   // ✅ Orders 1 → 5
                                        .map(Integer::longValue);

        preparedOrders
            .concatMap(DeliveryService::assignRider)   // Sequential assignment
            .subscribe(status ->
                    System.out.println("🛵 " + status)
            );

        Thread.sleep(6000); // Enough time for 5 × 1 sec delays
    }

    static Mono<String> assignRider(Long orderId) {
        return Mono.just("Rider Assigned for Order #" + orderId)
                   .delayElement(Duration.ofSeconds(1));
    }
}
