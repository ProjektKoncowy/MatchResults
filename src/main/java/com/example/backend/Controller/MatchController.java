package com.example.backend.Controller;

import com.example.backend.Model.League;
import com.example.backend.Model.Match;
import com.example.backend.Services.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/matches", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/{date}")
    public ResponseEntity<Match> updateMatches(@PathVariable String date) {
        List<Match> matchList = matchService.updateMatchesInDatabase(date);
        if (!matchList.isEmpty()) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<Match> showAllMatches() {
        List<Match> matchList = matchService.showAllMatches();
        if (!matchList.isEmpty()) {
            return new ResponseEntity(matchList,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
