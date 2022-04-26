package com.example.backend;

import com.example.backend.Client.LeagueTransferMarketResponseMapper;
import com.example.backend.Client.MatchesByDayResponseMapper;
import com.example.backend.Client.TransferMarketClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);

    }

}
