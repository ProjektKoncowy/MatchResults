package com.example.backend;

import com.example.backend.Client.FootballWebPagesClient;
import com.example.backend.Client.FootballWebPagesResponseMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {

//        FootballWebPagesResponseMapper footballWebPagesResponseMapper = new FootballWebPagesResponseMapper();
//        ObjectMapper objectMapper = new ObjectMapper();
//        FootballWebPagesClient footballWebPagesClient = new FootballWebPagesClient(footballWebPagesResponseMapper, objectMapper);
//        footballWebPagesClient.getLeague(1);
        SpringApplication.run(BackendApplication.class, args);
    }

}
