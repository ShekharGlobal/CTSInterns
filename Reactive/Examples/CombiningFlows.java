package com.cts.order;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class CombiningFlows {

    public static void main(String[] args) throws InterruptedException {

        Flux<String> food =
                Flux.just("Burger Ready", "Pizza Ready")
                    .delayElements(Duration.ofMillis(300));

        Flux<String> drinks =
                Flux.just("Coke Ready", "Juice Ready")
                    .delayElements(Duration.ofMillis(500));

        System.out.println("\n--- MERGE (Parallel Events) ---");
        Flux.merge(food, drinks)
            .subscribe(System.out::println);

        Thread.sleep(1500);

        System.out.println("\n--- ZIP (Paired Items) ---");
        Flux.zip(food, drinks, (f, d) -> f + " + " + d)
            .subscribe(System.out::println);

        Thread.sleep(1500);

        System.out.println("\n--- CONCAT (Sequential Streams) ---");
        Flux.concat(food, drinks)
            .subscribe(System.out::println);

        Thread.sleep(1500);
    }
}
