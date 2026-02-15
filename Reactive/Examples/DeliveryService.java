package com.cts.order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class DeliveryService {

    public static void main(String[] args) throws InterruptedException {

        Flux<Long> preparedOrders = Flux.just(1L, 2L, 3L);

        preparedOrders.concatMap(DeliveryService::assignRider)
                      .subscribe(status ->
                              System.out.println("🛵 " + status)
                      );

        Thread.sleep(4000);
    }

    static Mono<String> assignRider(Long orderId) {
        return Mono.just("Rider Assigned for Order #" + orderId)
                   .delayElement(Duration.ofSeconds(1));
    }
}
