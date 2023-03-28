package com.example.ipl.Model;

import com.example.ipl.Enum.BatOrBall;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Elect {
    @Id
    private String electId;
    private String teamName;
    private String loseTeamName;
    private BatOrBall batOrBall;
}
