package com.example.backend.Client;

import com.example.backend.Model.League;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class LiveScoreResponseMapper {

    League asLeague(LiveScoreResponse.Table singleTable){

        League league = new League();
        league.setLastUpdateDate(LocalDateTime.now().toString());
        league.setLeague_id(Integer.parseInt(singleTable.getLeague_id()));
        league.setSeason_id(Integer.parseInt(singleTable.getLeague_id()));
        league.setTeamName(singleTable.getName());
        league.setRankInTable(Integer.parseInt(singleTable.getRank()));
        league.setPoints(Integer.parseInt(singleTable.getPoints()));
        league.setMatches(Integer.parseInt(singleTable.getMatches()));
        league.setGoal_diff(Integer.parseInt(singleTable.getGoal_diff()));
        league.setGoals_scored(Integer.parseInt(singleTable.getGoals_scored()));
        league.setGoals_conceded(Integer.parseInt(singleTable.getGoals_conceded()));
        league.setLost(Integer.parseInt(singleTable.getLost()));
        league.setDrawn(Integer.parseInt(singleTable.getDrawn()));
        league.setWon(Integer.parseInt(singleTable.getWon()));
        league.setCompetition_id(Integer.parseInt(singleTable.getCompetition_id()));

        return league;
    }
}
