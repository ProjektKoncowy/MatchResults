package com.example.backend;

import com.example.backend.Client.LiveScoreClient;
import com.example.backend.Client.LiveScoreResponseMapper;
import com.example.backend.Model.League;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(BackendApplication.class, args);
    }

}
