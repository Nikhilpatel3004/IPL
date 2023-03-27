package com.example.ipl.Repo;

import com.example.ipl.Model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepo extends MongoRepository<Team,String> {


    Team findByTeamName(String teamName);
}
