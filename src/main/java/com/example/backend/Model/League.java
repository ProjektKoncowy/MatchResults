package com.example.backend.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Data
public class League {
    @Id
    public String name;
    private LocalDateTime lastUpdateDate;
    private Integer league_id;
    private Integer season_id;
    private Integer rankInTable;
    private Integer points;
    private Integer matches;
    private Integer goal_diff;
    private Integer goals_scored;
    private Integer goals_conceded;
    private Integer lost;
    private Integer drawn;
    private Integer won;
    public Integer competition_id;

}
