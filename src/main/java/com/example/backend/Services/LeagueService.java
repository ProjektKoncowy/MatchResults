package com.example.backend.Services;

import com.example.backend.Client.TransferMarketClient;
import com.example.backend.Model.League;
import com.example.backend.Repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueService {
    private final TransferMarketClient transferMarketClient;
    private final LeagueRepository leagueRepository;

    public LeagueService(TransferMarketClient transferMarketClient, LeagueRepository leagueRepository) {
        this.transferMarketClient = transferMarketClient;
        this.leagueRepository = leagueRepository;
    }

    public List<League> updateLeagueInDatabase(String competition_id , String year) {
        List<League> allLeagueToSave = transferMarketClient.getLeague(competition_id,year);
        return leagueRepository.saveAll(allLeagueToSave);
    }
    public List<League> showLeagueTable(String competition_id) {
        if(competition_id.length()>2){
            List<League> leagueTable = leagueRepository.findAll()
                    .stream()
                    .filter(league -> league.getLeague_id().equals(competition_id) )
                    .collect(Collectors.toList());
            return leagueTable;
        }else {
            String newCompetition_id="/"+competition_id;
            List<League> leagueTable = leagueRepository.findAll()
                    .stream()
                    .filter(league -> league.getLeague_id().equals(newCompetition_id) )
                    .collect(Collectors.toList());
            return leagueTable;
        }

    }
}
