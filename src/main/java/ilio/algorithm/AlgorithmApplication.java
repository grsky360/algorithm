package ilio.algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AlgorithmApplication.class, args);
    }

    @Autowired private AlgorithmApplication application;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(application);
        System.exit(0);
    }
}
