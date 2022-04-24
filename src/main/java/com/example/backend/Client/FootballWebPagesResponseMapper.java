package com.example.backend.Client;

import com.example.backend.Model.League;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class FootballWebPagesResponseMapper {

    List<League> asLeague(FootballWebPagesResponse.Root response) {
        List<League> fullLeague = new ArrayList<>();

        for(FootballWebPagesResponse.Team team:response.getLeagueTable().getTeams() ){
            League league = new League();
            league.setLastUpdateDate(LocalDateTime.now().toString());
            league.setLeague_id(response.getLeagueTable().getCompetition().getId());
            league.setTeamName(team.getName());
            league.setRankInTable(team.getPosition());
            league.setPoints(team.getTotalPoints());
            league.setMatches(team.getAwayMatches().getPlayed());
            league.setGoal_diff(team.getAllMatches().getGoalDifference());
            league.setLost(team.getAllMatches().getLost());
            league.setDrawn(team.getAllMatches().getDrawn());
            league.setWon(team.getAllMatches().getWon());
            fullLeague.add(league);
        }
        return fullLeague;
    }
}
