package com.cts.order;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class CombiningFlows {

    public static void main(String[] args) throws InterruptedException {

        Flux<String> food = Flux.just("Burger", "Pizza", "Pasta", "Fries")
                .delayElements(randomDelay())
                .map(item -> "🍔 " + item + " Ready");

        Flux<String> drinks = Flux.just("Coke", "Juice", "Coffee", "Shake")
                .delayElements(randomDelay())
                .map(item -> "🥤 " + item + " Ready");

        System.out.println("\n--- MERGE (Kitchen + Bar Parallel) ---");
        Flux.merge(food, drinks)
                .subscribe(System.out::println);

        Thread.sleep(3000);

        System.out.println("\n--- ZIP (Combo Orders) ---");
        Flux.zip(food, drinks, (f, d) -> "✅ Combo: " + f + " + " + d)
                .subscribe(System.out::println);

        Thread.sleep(3000);

        System.out.println("\n--- CONCAT (Food First, Drinks Next) ---");
        Flux.concat(food, drinks)
                .subscribe(System.out::println);

        Thread.sleep(4000);
    }

    // ✅ Random delay generator (Realistic behavior)
    static Duration randomDelay() {
        int millis = ThreadLocalRandom.current().nextInt(200, 700);
        return Duration.ofMillis(millis);
    }
}
