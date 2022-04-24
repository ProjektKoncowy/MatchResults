package com.example.backend.Services;

import com.example.backend.Client.FootballWebPagesClient;
import com.example.backend.Client.LiveScoreClient;
import com.example.backend.Model.League;
import com.example.backend.Repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueService {
    private final FootballWebPagesClient footballWebPagesClient;
    private final LeagueRepository leagueRepository;

    public LeagueService(FootballWebPagesClient footballWebPagesClient, LeagueRepository leagueRepository) {
        this.footballWebPagesClient = footballWebPagesClient;
        this.leagueRepository = leagueRepository;
    }

    public List<League> updateLeagueInDatabase(Integer competition_id) {
        List<League> allLeagueToSave = footballWebPagesClient.getLeague(competition_id);
        return leagueRepository.saveAll(allLeagueToSave);
    }
    public List<League> showLeagueTable(Integer competition_id) {
        List<League> leagueTable = leagueRepository.findAll()
                .stream()
                .filter(league -> league.getLeague_id() == competition_id)
                .collect(Collectors.toList());
        return leagueTable;
    }
}
