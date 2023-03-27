package com.example.ipl.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Bowler extends Player{

    @Id
    String bowlerId;
    Integer wickets;
    Integer bowlrate;
}
