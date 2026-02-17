package com.cts.order;

import reactor.core.publisher.Flux;
import java.time.Duration;

public class TrackingService {

    public static void main(String[] args) throws InterruptedException {

        Flux<Long> orders = Flux.range(1, 5)   // Orders 1 → 5
                                .map(Integer::longValue);

        orders
            .concatMap(TrackingService::trackingUpdates) // One-by-one
            .subscribe(System.out::println);

        Thread.sleep(15000); // Keep JVM alive
    }

    static Flux<String> trackingUpdates(Long orderId) {
        return Flux.just(
                "📦 Order #" + orderId + " Confirmed",
                "📦 Order #" + orderId + " Preparing Ingredients",
                "📦 Order #" + orderId + " Cooking",
                "📦 Order #" + orderId + " Out for Delivery",
                "📦 Order #" + orderId + " Delivered"
        ).delayElements(Duration.ofMillis(500));
    }
}
