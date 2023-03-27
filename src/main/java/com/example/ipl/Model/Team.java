package com.example.ipl.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    String teamId;
    String teamName;
    List<String> batsman;
    List<String> bowler;
}
