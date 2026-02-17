package com.cts.order;
import reactor.core.publisher.Flux;

public class ErrorHandlingDemo {

    public static void main(String[] args) {

        Flux<Integer> orders = Flux.just(1, 2, 0, 3);

        System.out.println("\n--- onErrorResume ---");
        orders.map(n -> 10 / n)
              .onErrorResume(e -> Flux.just(-1))
              .subscribe(System.out::println);

        System.out.println("\n--- onErrorContinue ---");
        orders.map(n -> 10 / n)
              .onErrorContinue((e, val) ->
                      System.out.println("Skipping bad order: " + val))
              .subscribe(System.out::println);

        System.out.println("\n--- retry ---");
        orders.map(n -> {
                    if (n == 0) throw new RuntimeException("Kitchen Failure!");
                    return n;
              })
              .retry(2)
              .subscribe(
                      System.out::println,
                      e -> System.out.println("Failed after retries")
              );
    }
}
