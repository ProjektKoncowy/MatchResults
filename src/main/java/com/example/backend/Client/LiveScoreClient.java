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

@RequiredArgsConstructor
@Component
public class LiveScoreClient {
    private static final String URL = "https://livescore-api.com/api-client/leagues/table.json?competition_id=%s&key=%s&secret=%s";
    private static final String KEY = "XBuc8uevYOOyY5gG";
    private static final String SECRET = "4Bn2VurqMyFCGssE3WQbr4HpTwYSBfyG";
    private final LiveScoreResponseMapper liveScoreResponseMapper;
    private final ObjectMapper objectMapper;


    public List<League> getLeague(Integer competition_id) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(String.format(URL, competition_id, KEY, SECRET)))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            LiveScoreResponse liveScoreResponse = objectMapper.readValue(responseBody, LiveScoreResponse.class);
            List<League> leagueList = liveScoreResponse.getData().getTable()
                    .stream()
                    .map(liveScoreResponseMapper::asLeague)
                    .collect(Collectors.toList());
            return leagueList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }

    }

}
