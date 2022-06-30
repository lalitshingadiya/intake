package com.ecw.intake;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication
public class IntakeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(IntakeApplication.class, args);
    }

    //@Bean
    public Consumer<FastPassToll> readTollCharge(){
        return value -> {
            System.out.println("received message for customer " + value.getFastPassId() + " at " + value.getStationId() + " amount to " + value.getAmountPaid());
        };
    }

    @Bean
    public Function<FastPassToll,FastPassToll> processTollCharge(){
        return value -> {
            System.out.println("Processing message");
            value.setStatus("processed");
            return value;
        };
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Listening for messages...");

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
    }
}
