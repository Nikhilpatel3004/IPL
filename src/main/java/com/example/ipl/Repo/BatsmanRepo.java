package com.example.ipl.Repo;

import com.example.ipl.Model.Batsman;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BatsmanRepo extends MongoRepository<Batsman,String> {
}
