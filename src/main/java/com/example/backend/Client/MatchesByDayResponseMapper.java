package com.example.backend.Client;

import com.example.backend.Model.Match;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MatchesByDayResponseMapper {

    public List<Match> getMatches(MatchesByDayResponse.Root response) {
        List<Match> matchList = new ArrayList<>();
        List<ArrayList<MatchesByDayResponse.Match>> matchInLeague = new ArrayList<>();
        try{
            ArrayList<MatchesByDayResponse.Match> cl = response.getLiveMatches().getCl();
            if(!cl.isEmpty()){
                matchInLeague.add(cl);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            ArrayList<MatchesByDayResponse.Match> el = response.getLiveMatches().getEl();
            if(!el.isEmpty()) {
                matchInLeague.add(el);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            ArrayList<MatchesByDayResponse.Match> ucol = response.getLiveMatches().getUcol();
            if(!ucol.isEmpty()) {
                matchInLeague.add(ucol);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            ArrayList<MatchesByDayResponse.Match> pl1s = response.getLiveMatches().getPL1();
            if(!pl1s.isEmpty()) {
                matchInLeague.add(pl1s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            ArrayList<MatchesByDayResponse.Match> gb1s = response.getLiveMatches().getGB1();
            if(!gb1s.isEmpty()) {
                matchInLeague.add(gb1s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            ArrayList<MatchesByDayResponse.Match> es1 = response.getLiveMatches().getES1();
            if(!es1.isEmpty()) {
                matchInLeague.add(es1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            ArrayList<MatchesByDayResponse.Match> it1 = response.getLiveMatches().getIT1();
            if(!it1.isEmpty()) {
                matchInLeague.add(it1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            ArrayList<MatchesByDayResponse.Match> fr1 = response.getLiveMatches().getFR1();
            if(!fr1.isEmpty()) {
                matchInLeague.add(fr1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            ArrayList<MatchesByDayResponse.Match> l1 = response.getLiveMatches().getL1();
            if(!l1.isEmpty()) {
                matchInLeague.add(l1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            ArrayList<MatchesByDayResponse.Match>  nl1= response.getLiveMatches().getNL1();
            if(!nl1.isEmpty()) {
                matchInLeague.add(nl1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            for (ArrayList<MatchesByDayResponse.Match> matchTest:matchInLeague){
                matchTest.forEach(x -> {
                    Match match = new Match();
                    match.setId(Long.parseLong(x.getId()));
                    match.setCompetitionName(x.getCompetitionName());
                    match.setHomeClubName(x.getHomeClubName());
                    match.setAwayClubName(x.getAwayClubName());
                    match.setResult(x.getResult());
                    match.setMatchDate(x.getMatchDate());
                    match.setMatchTime(x.getMatchTime());
                    matchList.add(match);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matchList;
    }
}
