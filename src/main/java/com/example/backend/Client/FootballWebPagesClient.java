package com.example.backend.Client;

import com.example.backend.Model.League;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class FootballWebPagesClient {
    private static final String URL = "https://football-web-pages1.p.rapidapi.com/league-table.json?comp=";
    private static final String HeaderHostName = "X-RapidAPI-Host";
    private static final String HeaderHostValue = "football-web-pages1.p.rapidapi.com";
    private static final String HeaderKeyName = "X-RapidAPI-Key";
    private static final String HeaderKeyValue = "39c3c89896mshca4be26bf496becp12a397jsn37492ce3736f";

    private final FootballWebPagesResponseMapper footballWebPagesResponseMapper;
    private final ObjectMapper objectMapper;


    public List<League> getLeague(Integer competition_id) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL+competition_id))
                .header(HeaderHostName, HeaderHostValue)
                .header(HeaderKeyName, HeaderKeyValue)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.body());
            String responseBody = response.body();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            FootballWebPagesResponse.Root footballWebPagesResponse= objectMapper.readValue(responseBody, FootballWebPagesResponse.Root.class);
            List<League> leagueList = footballWebPagesResponseMapper.asLeague(footballWebPagesResponse);

//            System.out.println(leagueList);
            return leagueList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }

    }
}
