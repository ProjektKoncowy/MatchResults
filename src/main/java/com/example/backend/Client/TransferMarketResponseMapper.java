package com.example.backend.Client;

import com.example.backend.Model.League;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class TransferMarketResponseMapper {
    List<League> asLeague(TransferMarketResponse.Root response) {
        List<League> fullLeague = new ArrayList<>();

        for(TransferMarketResponse.Table team:response.getTable()){
            League league = new League();
            league.setLastUpdateDate(LocalDateTime.now().getYear()+"-"+LocalDateTime.now().getMonth()+"-"+LocalDateTime.now().getDayOfMonth()+"__"+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
            String url = response.getShare().getUrl();
            league.setLeague_id(url.substring(url.length()-3,url.length()));
            league.setTeamName(team.getClubName());
            league.setRankInTable(team.getRank());
            league.setPoints(team.getPoints());
            league.setMatches(team.getMatches());
            league.setLost(team.getLosses());
            league.setDrawn(team.getDraw());
            league.setWon(team.getWins());
            league.setGoal_diff(team.getGoalDifference());
            league.setGoals_scored(team.getGoals());
            league.setGoals_conceded(team.getGoalsConceded());
            fullLeague.add(league);
        }
        return fullLeague;
    }
}
