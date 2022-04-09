package com.example.backend.Client;

import lombok.Data;

import java.util.ArrayList;

@Data
public class LiveScoreResponse {

    private Data data;
    private Table table;
    private Root root;
@lombok.Data
    public class Data{
        public ArrayList<Table> table;
    }

@lombok.Data
    public static class Table{
        public String league_id;
        public String season_id;
        public String name;
        public String rank;
        public String points;
        public String matches;
        public String goal_diff;
        public String goals_scored;
        public String goals_conceded;
        public String lost;
        public String drawn;
        public String won;
        public String team_id;
        public String competition_id;
        public String group_id;
        public String group_name;
        public String stage_name;
        public String stage_id;
    }
@lombok.Data
    public class Root{

     public boolean success;
        public Data data;
    }
}
