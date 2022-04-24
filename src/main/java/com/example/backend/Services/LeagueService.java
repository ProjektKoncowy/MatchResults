package com.example.backend.Services;

import com.example.backend.Client.LeagueTransferMarketClient;
import com.example.backend.Model.League;
import com.example.backend.Repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueService {
    private final LeagueTransferMarketClient leagueTransferMarketClient;
    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueTransferMarketClient leagueTransferMarketClient, LeagueRepository leagueRepository) {
        this.leagueTransferMarketClient = leagueTransferMarketClient;
        this.leagueRepository = leagueRepository;
    }

    public List<League> updateLeagueInDatabase(String competition_id , String year) {
        List<League> allLeagueToSave = leagueTransferMarketClient.getLeague(competition_id,year);
        return leagueRepository.saveAll(allLeagueToSave);
    }
    public List<League> showLeagueTable(String competition_id) {
            List<League> leagueTable = leagueRepository.findAll()
                    .stream()
                    .filter(league -> league.getLeague_id().equals(competition_id) )
                    .collect(Collectors.toList());
            return leagueTable;
    }
}
