package com.example.backend.Client;

import com.example.backend.Model.League;
import com.example.backend.Model.Match;
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

@RequiredArgsConstructor
@Component
public class TransferMarketClient {

    private static final String URL = "https://transfermarket.p.rapidapi.com/competitions/get-table?id=%s&seasonID=%s";
    private static final String HeaderHostName = "X-RapidAPI-Host";
    private static final String HeaderHostValue = "transfermarket.p.rapidapi.com";
    private static final String HeaderKeyName = "X-RapidAPI-Key";
    private static final String HeaderKeyValue = "39c3c89896mshca4be26bf496becp12a397jsn37492ce3736f";

    private final LeagueTransferMarketResponseMapper leagueTransferMarketResponseMapper;
    private final ObjectMapper objectMapper;

    public List<League> getLeague(String competition_id, String year) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(URL, competition_id, year)))
                .header(HeaderHostName, HeaderHostValue)
                .header(HeaderKeyName, HeaderKeyValue)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String responseBody = response.body();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            LeagueTransferMarketResponse.Root readValue = objectMapper.readValue(responseBody, LeagueTransferMarketResponse.Root.class);
            List<League> leagueList = leagueTransferMarketResponseMapper.asLeague(readValue);
            return leagueList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    private static final String URL_MATCH_BY_DAY = "https://transfermarket.p.rapidapi.com/matches/list-by-date?date=%s";
    private final MatchesByDayResponseMapper matchesByDayResponseMapper;

    public void getMatchesByDay(String date) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(URL_MATCH_BY_DAY, date)))
                .header(HeaderHostName, HeaderHostValue)
                .header(HeaderKeyName, HeaderKeyValue)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println(responseBody);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            MatchesByDayResponse.Root readValue = objectMapper.readValue(responseBody, MatchesByDayResponse.Root.class);
            List<Match> matches = matchesByDayResponseMapper.getMatches(readValue);
            System.out.println(matches);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
