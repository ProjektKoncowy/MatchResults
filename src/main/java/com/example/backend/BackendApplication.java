package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {

//        TransferMarketClient transferMarketClient = new TransferMarketClient();
//        transferMarketClient.getLeague("PL1","2022");
        SpringApplication.run(BackendApplication.class, args);
    }

}
