package com.example.ipl.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Batsman extends Player{
    @Id
    String batsmanId;
}
