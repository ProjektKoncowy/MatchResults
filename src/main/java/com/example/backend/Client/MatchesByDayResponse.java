package com.example.backend.Client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class MatchesByDayResponse {


    @Data
    public static class Share {
        public String title;
        public String url;
        public String description;
    }

    @Data
    public static class ResultObject {
        public String result;
        public String goalsHome;
        public String goalsAway;
        public String minute;
        public String state;
        public int destinationValue;
        public String destinationDescription;
    }


    @Data
    public static class Sort {
        public String competitionID;
        public String competitionName;
        public String competitionImage;
        public String tournamentFlag;
        public int sort;
        public int playNow;
        public int liveMatches;
    }

    @Data
    public static class LiveMatches {
        @JsonProperty("CL")
        public ArrayList<Match> cl;
        @JsonProperty("EL")
        public ArrayList<Match> el;
        @JsonProperty("UCOL")
        public ArrayList<Match> ucol;
        @JsonProperty("L1")
        public ArrayList<Match> l1;
        @JsonProperty("L2")
        public ArrayList<Match> l2;
        @JsonProperty("GB1")
        public ArrayList<Match> gB1;
        @JsonProperty("L3")
        public ArrayList<Match> l3;
        @JsonProperty("ES1")
        public ArrayList<Match> eS1;
        @JsonProperty("IT1")
        public ArrayList<Match> iT1;
        @JsonProperty("FR1")
        public ArrayList<Match> fR1;
        @JsonProperty("TR1")
        public ArrayList<Match> tR1;
        @JsonProperty("RLN4")
        public ArrayList<Match> rLN4;
        @JsonProperty("RLW3")
        public ArrayList<Match> rLW3;
        @JsonProperty("RLSW")
        public ArrayList<Match> rLSW;
        @JsonProperty("C1")
        public ArrayList<Match> c1;
        @JsonProperty("A1")
        public ArrayList<Match> a1;
        @JsonProperty("C2")
        public ArrayList<Match> c2;
        @JsonProperty("NL1")
        public ArrayList<Match> nL1;
        @JsonProperty("PO1")
        public ArrayList<Match> pO1;
        @JsonProperty("RU1")
        public ArrayList<Match> rU1;
        @JsonProperty("PL1")
        public ArrayList<Match> pL1;
        @JsonProperty("MLS1")
        public ArrayList<Match> mLS1;
        @JsonProperty("A2")
        public ArrayList<Match> a2;
        @JsonProperty("ES2")
        public ArrayList<Match> eS2;


        public ArrayList<Sort> sort;
    }

    @Data
    public static class Root {
        public Share share;
        public int totalMatches;
        public LiveMatches liveMatches;
    }

    @Data
    public static class Match {
        public String id;
        public Object scoreradarID;
        public String competitionID;
        public String competitionName;
        public String competitionImage;
        public String tournamentFlag;
        public Object round;
        public String group;
        public String matchDay;
        public String matchDate;
        public String fullMatchDate;
        public String matchTime;
        public int timestamp;
        public String homeClubID;
        public String homeClubName;
        public String homeClubImage;
        public String awayClubID;
        public String awayClubName;
        public String awayClubImage;
        public String result;
        public boolean postponed;
        public String nextRound;
        public ResultObject resultObject;
    }
}
