package com.example.backend.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@NoArgsConstructor
@Entity
@Data
public class Match {
    @Id
    private Long id;
    private String competitionName;
    private String homeClubName;
    private String awayClubName;
    private String result;
    private Date matchDate;
    private String matchTime;
    private String state;
    private String lastUpdate;


}
