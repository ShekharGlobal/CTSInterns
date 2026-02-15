package com.cts.order;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class TrackingService {

    public static void main(String[] args) throws InterruptedException {

        Flux<String> trackingUpdates =
                Flux.just(
                        "Order Confirmed",
                        "Preparing Food",
                        "Out for Delivery",
                        "Delivered"
                ).delayElements(Duration.ofSeconds(1));

        trackingUpdates.subscribe(update ->
                System.out.println("📦 " + update)
        );

        Thread.sleep(5000);
    }
}
