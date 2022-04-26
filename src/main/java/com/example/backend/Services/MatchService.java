package com.example.backend.Services;

import com.example.backend.Client.TransferMarketClient;
import com.example.backend.Model.Match;
import com.example.backend.Repository.LeagueRepository;
import com.example.backend.Repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private final TransferMarketClient transferMarketClient;
    private final MatchRepository matchRepository;

    public MatchService(TransferMarketClient transferMarketClient, MatchRepository matchRepository) {
        this.transferMarketClient = transferMarketClient;
        this.matchRepository = matchRepository;
    }

    public List<Match> updateMatchesInDatabase(String date) {
        List<Match> allMatchToSave = transferMarketClient.getMatchesByDay(date);
        return matchRepository.saveAll(allMatchToSave);
    }

    public List<Match> showAllMatches() {
        List<Match> allMatches = matchRepository.findAll();
        return allMatches;
    }

}
