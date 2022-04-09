package com.example.backend.Controller;

import com.example.backend.Model.League;
import com.example.backend.Repository.LeagueRepository;
import com.example.backend.Services.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/league" , produces = {MediaType.APPLICATION_JSON_VALUE})
public class LeagueController {

    private final LeagueRepository leagueRepository;
    private final LeagueService leagueService;

    public LeagueController(LeagueRepository leagueRepository, LeagueService leagueService) {
        this.leagueRepository = leagueRepository;
        this.leagueService = leagueService;
    }

    @GetMapping("/updateLeagueTable/{competition_id}")
    public void updateLeagueTable(@PathVariable Integer competition_id){
        leagueService.updateLeagueInDatabase(competition_id);
    }

    @GetMapping("/{competition_id}")
            public ResponseEntity<League> showLeagueTable(@PathVariable Integer competition_id){
        List<League> leagueList = leagueRepository.findAll()
                .stream()
                .filter(league -> league.competition_id == competition_id)
                .collect(Collectors.toList());
        if(!leagueList.isEmpty()){
            return new ResponseEntity(leagueList,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
