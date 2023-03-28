package com.example.ipl.Repo;

import com.example.ipl.Model.Elect;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ElectRepo extends MongoRepository<Elect,String> {

}
