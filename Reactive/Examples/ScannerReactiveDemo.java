package com.cts.reactive;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Scanner;

public class ScannerReactiveDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /* -----------------------------------------
         * 1️Mono Example — Single Input
         * ----------------------------------------- */

        System.out.print("Enter order amount: ");
        int amount = scanner.nextInt();

        Mono<Integer> paymentMono = Mono.just(amount);

        paymentMono.subscribe(
                value -> System.out.println(" Processing payment: ₹" + value),
                error -> System.out.println(" Error: " + error.getMessage()),
                () -> System.out.println("Payment Completed\n")
        );

        /* -----------------------------------------
         * 2️ Flux Example — Multiple Inputs
         * ----------------------------------------- */

        System.out.print("How many tracking updates? ");
        int count = scanner.nextInt();
        scanner.nextLine(); 
        Flux<String> trackingFlux = Flux.create(emitter -> {

            for (int i = 1; i <= count; i++) {
                System.out.print("Enter update " + i + ": ");
                String update = scanner.nextLine();
                emitter.next(update);
            }

            emitter.complete();
        });

        trackingFlux.subscribe(
                update -> System.out.println("Update Received: " + update),
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println(" Tracking Completed")
        );
    }
}
