package com.example.ipl.Service;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.ipl.Model.Batsman;
import com.example.ipl.Model.Bowler;
import com.example.ipl.Model.Player;
import com.example.ipl.Repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

//     private <T> Stream<T> getplayer(String propty,Integer numberofplayer){
//         Sort sort = Sort.by(Sort.Direction.ASC,propty);
//         Query query = new Query();
//         query.with(sort);
//         //How to write Generic query
//         Stream<Batsman> batsman = mongoTemplate.find(query,).stream().limit(numberofplayer);
//
//     }
    public List<String> getPlaying11(String TeamName){
        Sort sort_bat = Sort.by(Sort.Direction.DESC,"batrate");
        Query query_bat = new Query();
        query_bat.with(sort_bat);
        query_bat.addCriteria(Criteria.where("teamName").is(TeamName));
        List<String> Batsman = mongoTemplate.find(query_bat, Batsman.class).stream().limit(6).map(a -> a.getBatsmanId()).collect(Collectors.toList());


        Sort sort_bowl = Sort.by(Sort.Direction.DESC,"bowlrate");
        Query query_bowl = new Query();
        query_bowl.with(sort_bowl);
        query_bowl.addCriteria(Criteria.where("teamName").is(TeamName));
        List<String> Bowler= mongoTemplate.find(query_bat, Bowler.class).stream().limit(5).map(a -> a.getBowlerId()).collect(Collectors.toList());

        Batsman.addAll(Bowler);

        return Batsman;
    }

}
