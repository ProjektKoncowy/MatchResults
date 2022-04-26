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
@RequestMapping(value = "/league", produces = {MediaType.APPLICATION_JSON_VALUE})
public class LeagueController {


    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/updateLeagueTable/{competition_id}_{year}")
    public ResponseEntity<League>  updateLeagueTable(@PathVariable String competition_id , @PathVariable String year) {
        List<League> leagueList = leagueService.updateLeagueInDatabase(competition_id, year);
        if (!leagueList.isEmpty()) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{competition_id}")
    public ResponseEntity<League> showLeagueTable(@PathVariable String competition_id) {
        List<League> leagueList = leagueService.showLeagueTable(competition_id);
        if (!leagueList.isEmpty()) {
            return new ResponseEntity(leagueList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
