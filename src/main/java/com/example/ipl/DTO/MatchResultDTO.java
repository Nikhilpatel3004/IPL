package com.example.ipl.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchResultDTO {
    private String Team1;
    private String Team2;
    private Integer firstInningRun;
    private Integer secondInningRun;
    private String winnerTeam ;
}
