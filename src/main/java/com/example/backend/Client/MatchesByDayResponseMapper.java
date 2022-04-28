package com.example.backend.Client;

import com.example.backend.Model.Match;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
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
            if(e.getClass().equals(NullPointerException.class)){
                System.out.println("No matches in Champions league");
            }else {
                e.printStackTrace();
            }
        }
        try{
            ArrayList<MatchesByDayResponse.Match> el = response.getLiveMatches().getEl();
            if(!el.isEmpty()) {
                matchInLeague.add(el);
            }
        }catch (Exception e){
            if(e.getClass().equals(NullPointerException.class)){
                System.out.println("No matches in Europe league");
            }else {
                e.printStackTrace();
            }
        }
        try{
            ArrayList<MatchesByDayResponse.Match> ucol = response.getLiveMatches().getUcol();
            if(!ucol.isEmpty()) {
                matchInLeague.add(ucol);
            }
        }catch (Exception e){
            if(e.getClass().equals(NullPointerException.class)){
                System.out.println("No matches in Uefa conference league");
            }else {
                e.printStackTrace();
            }
        }
        try{
            ArrayList<MatchesByDayResponse.Match> pl1s = response.getLiveMatches().getPL1();
            if(!pl1s.isEmpty()) {
                matchInLeague.add(pl1s);
            }
        }catch (Exception e){
            if(e.getClass().equals(NullPointerException.class)){
                System.out.println("No matches in PL1");
            }else {
                e.printStackTrace();
            }
        }
        try{
            ArrayList<MatchesByDayResponse.Match> gb1s = response.getLiveMatches().getGB1();
            if(!gb1s.isEmpty()) {
                matchInLeague.add(gb1s);
            }
        }catch (Exception e){
            if(e.getClass().equals(NullPointerException.class)){
                System.out.println("No matches in GB1");
            }else {
                e.printStackTrace();
            }
        }
        try{
            ArrayList<MatchesByDayResponse.Match> es1 = response.getLiveMatches().getES1();
            if(!es1.isEmpty()) {
                matchInLeague.add(es1);
            }
        }catch (Exception e){
            if(e.getClass().equals(NullPointerException.class)){
                System.out.println("No matches in ES1");
            }else {
                e.printStackTrace();
            }
        }
        try{
            ArrayList<MatchesByDayResponse.Match> it1 = response.getLiveMatches().getIT1();
            if(!it1.isEmpty()) {
                matchInLeague.add(it1);
            }
        }catch (Exception e){
            if(e.getClass().equals(NullPointerException.class)){
                System.out.println("No matches in IT1");
            }else {
                e.printStackTrace();
            }
        }
        try{
            ArrayList<MatchesByDayResponse.Match> fr1 = response.getLiveMatches().getFR1();
            if(!fr1.isEmpty()) {
                matchInLeague.add(fr1);
            }
        }catch (Exception e){
            if(e.getClass().equals(NullPointerException.class)){
                System.out.println("No matches in FR1");
            }else {
                e.printStackTrace();
            }
        }
        try{
            ArrayList<MatchesByDayResponse.Match> l1 = response.getLiveMatches().getL1();
            if(!l1.isEmpty()) {
                matchInLeague.add(l1);
            }
        }catch (Exception e){
            if(e.getClass().equals(NullPointerException.class)){
                System.out.println("No matches in L1");
            }else {
                e.printStackTrace();
            }
        }
        try{
            ArrayList<MatchesByDayResponse.Match>  nl1= response.getLiveMatches().getNL1();
            if(!nl1.isEmpty()) {
                matchInLeague.add(nl1);
            }
        }catch (Exception e){
            if(e.getClass().equals(NullPointerException.class)){
                System.out.println("No matches in NL1");
            }else {
                e.printStackTrace();
            }
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
                    match.setState(x.getResultObject().getState());
                    match.setLastUpdate(LocalDateTime.now().getYear() + "-" + LocalDateTime.now().getMonth() + "-" + LocalDateTime.now().getDayOfMonth() + "  " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
                    matchList.add(match);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matchList;
    }
}
