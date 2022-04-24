package com.example.backend.Client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
@Data
public class TransferMarketResponse {

    private Share share;
    private Table table;
    private Legend legend;
    private Root root;
    @Data
    public static class Share{
        public String title;
        public String url;
        public String description;
    }
    @Data
    public static class Table{
        public String id;
        public Object group;
        public int rank;
        public int oldRank;
        public String clubName;
        public String clubImage;
        public int points;
        public int goals;
        public int goalsConceded;
        public int goalDifference;
        public int matches;
        public int wins;
        public int losses;
        public int draw;
        public String markID;
        public String markClass;
        public String markColor;
        public String markDescription;
    }
    @Data
    public static class Legend{
        public String id;
        public String description;
        @JsonProperty("class")
        public String myclass;
        public String color;
    }
    @Data
    public static class Root{
        public Share share;
        public ArrayList<Table> table;
        public ArrayList<Legend> legend;
    }

}
