package com.example.ipl.DTO;

import com.example.ipl.Enum.BatOrBall;
import com.example.ipl.Enum.Toss;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElectDTO {
    private String tossWinnerTeamName;
    private String tossLoseTeamName;
    private BatOrBall elect;
}
