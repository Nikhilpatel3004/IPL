package com.example.ipl.Service;

import com.example.ipl.Model.Batsman;
import com.example.ipl.Model.Bowler;
import com.example.ipl.Model.Player;
import com.example.ipl.Model.Team;
import com.example.ipl.Repo.BatsmanRepo;
import com.example.ipl.Repo.BowlerRepo;
import com.example.ipl.Repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.TimeZone;

@Service
public class EntryService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private BatsmanRepo batsmanRepo;

    @Autowired
    private BowlerRepo bowlerRepo;

    @Autowired
    private TeamRepo teamRepo;


    public String addBatsman(Batsman batsman) {
        String batsmanId = batsmanRepo.save(batsman).getBatsmanId();

//        Team byTeamName = teamRepo.findByTeamName(batsman.getTeamName());
        Query query = new Query(Criteria.where("teamName").is(batsman.getTeamName()));
        Update update = new Update().push("batsman",batsmanId);

        mongoTemplate.updateFirst(query,update,Team.class);


        return batsmanId;
    }


    public String addBowler(Bowler bowler){
        String bowlerId = bowlerRepo.save(bowler).getBowlerId();

        Query query = new Query(Criteria.where("teamName").is(bowler.getTeamName()));

        Update update = new Update().push("bowler",bowlerId);

        mongoTemplate.updateFirst(query,update,Team.class);

        return bowlerId;
    }


    public String addTeam(Team team){
        return teamRepo.save(team).getTeamId();
    }
}
