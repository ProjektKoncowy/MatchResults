package com.example.backend.Client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
public class FootballWebPagesResponse {

    private AllMatches allMatches;
    private HomeMatches homeMatches;
    private AwayMatches awayMatches;
    private Team team;
    private Competition competition;
    private LeagueTable leagueTable;
    private Root root;

    @Data
    public static class AllMatches {
        public int lost;
        public int against;
        @JsonProperty("goal-difference")
        public int goalDifference;
        public int won;
        @JsonProperty("for")
        public int myfor;
        public int drawn;
        public int played;
    }

    @Data
    public static class HomeMatches {
        public int lost;
        public int against;
        public int won;
        @JsonProperty("for")
        public int myfor;
        public int drawn;
        public int played;
    }

    @Data
    public static class AwayMatches {
        public int lost;
        public int against;
        public int won;
        @JsonProperty("for")
        public int myfor;
        public int drawn;
        public int played;
    }

    @Data
    public static class Team {
        @JsonProperty("all-matches")
        public AllMatches allMatches;
        public String zone;
        public String name;
        @JsonProperty("home-matches")
        public HomeMatches homeMatches;
        @JsonProperty("away-matches")
        public AwayMatches awayMatches;
        public int id;
        public int position;
        @JsonProperty("total-points")
        public int totalPoints;
    }

    @Data
    public static class Competition {
        public String name;
        public int id;
    }

    @Data
    public static  class LeagueTable {
        public ArrayList<Team> teams;
        public String description;
        public Competition competition;
    }


    @Data
    public static class Root {
        @JsonProperty("league-table")
        public LeagueTable leagueTable;
    }
}
