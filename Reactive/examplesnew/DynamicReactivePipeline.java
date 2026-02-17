package com.cts.order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class DynamicReactivePipeline {

    public static void main(String[] args) throws InterruptedException {

        Flux<Long> orders = Flux.range(1, 5)
                                .map(Integer::longValue)
                                .delayElements(Duration.ofSeconds(1));

        orders
            .concatMap(orderId -> processOrder(orderId)   // Sequential orders
                .onErrorResume(e -> {
                    log(" Order Failed", orderId);
                    return Flux.just(" Issue with Order #" + orderId + " → " + e.getMessage());
                })
            )
            .subscribe(System.out::println);

        Thread.sleep(20000); // Keep JVM alive for async demo
    }

    // ---------------- FULL ORDER PIPELINE ----------------
    static Flux<String> processOrder(Long orderId) {

        return Mono.just(orderId)
                .doOnNext(id -> log("🛒 Order Received", id))

                // Mono → Mono chaining → use flatMap 
                .flatMap(DynamicReactivePipeline::kitchenService)
                .flatMap(DynamicReactivePipeline::deliveryService)

                // Mono → Flux → use flatMapMany ✅
                .flatMapMany(DynamicReactivePipeline::trackingService);
    }

    // ---------------- Kitchen ----------------
    static Mono<Long> kitchenService(Long orderId) {

        int prepTime = randomBetween(1, 3);

        // Random failure simulation
        if (randomBetween(1, 10) > 7) {
            return Mono.delay(Duration.ofSeconds(prepTime))
                       .flatMap(t -> Mono.error(new RuntimeException("Kitchen Error")));
        }

        return Mono.just(orderId)
                   .delayElement(Duration.ofSeconds(prepTime))
                   .doOnNext(id -> log("👨‍🍳 Food Prepared (" + prepTime + "s)", id));
    }

    // ---------------- Delivery ----------------
    static Mono<Long> deliveryService(Long orderId) {

        int assignTime = randomBetween(1, 2);

        return Mono.just(orderId)
                   .delayElement(Duration.ofSeconds(assignTime))
                   .doOnNext(id -> log("🛵 Rider Assigned (" + assignTime + "s)", id));
    }

    // ---------------- Tracking ----------------
    static Flux<String> trackingService(Long orderId) {

        return Flux.just(
                " Order #" + orderId + " Confirmed",
                " Order #" + orderId + " Cooking",
                " Order #" + orderId + " Out for Delivery",
                "Order #" + orderId + " Delivered"
        ).delayElements(Duration.ofMillis(randomBetween(300, 700)));
    }

    // ---------------- Helpers ----------------
    static int randomBetween(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    static void log(String stage, Long id) {
        System.out.println(stage + " → Order #" + id);
    }
}
