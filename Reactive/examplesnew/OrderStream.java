package com.cts.order;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class OrderStream {

    public static void main(String[] args) throws InterruptedException {

        Flux<Long> orders =
                Flux.interval(Duration.ofSeconds(1))// Every second
                    .map(i -> i + 1)
                    .take(5); // Only 5 orders

        orders.subscribe(orderId ->
                System.out.println("🛒 New Order Received: #" + orderId)
        );

        Thread.sleep(6000);
    }
}
