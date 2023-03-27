package com.example.ipl.Repo;

import com.example.ipl.Model.Bowler;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BowlerRepo extends MongoRepository<Bowler,String> {
}
