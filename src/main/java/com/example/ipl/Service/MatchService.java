package com.example.ipl.Service;

import com.example.ipl.DTO.MatchDTO;
import com.example.ipl.DTO.MatchResultDTO;
import com.example.ipl.Model.Batsman;
import com.example.ipl.Model.Bowler;
import com.example.ipl.Repo.BatsmanRepo;
import com.example.ipl.Repo.BowlerRepo;
import com.example.ipl.Utility.AbilityToHit;
import com.example.ipl.Utility.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import  java.util.*;

import static com.example.ipl.Utility.Constant.BALL_IN_OVER;
import static com.example.ipl.Utility.OutputOfBall.outputOfBall;
import static com.example.ipl.Utility.SelectBowler.selectBowler;

@Service
public class MatchService {

    @Autowired
    TeamService teamService;

    @Autowired
    BowlerRepo bowlerRepo;

    @Autowired
    BatsmanRepo batsmanRepo;
    @Autowired
    MongoTemplate mongoTemplate;




     public  Integer Inning(List<String> BatTeam,List<String> BowlTeam,int overs){

         int striker = 0;
         int run = 0;
         int wicket = 0;
         int bowler  = 0;
         int lastoverRun = 0;
         int totalRun  = 0;
         int wicketinlastover = 0;
         int batrate = calculateBatRate(striker,BatTeam.get(striker)) ;
         for(int  i = 0;i<overs;i++){

             bowler = selectBowler(bowler);

             String bowler_id = BowlTeam.get(bowler);

             int bowlrate  = calculateBowlRate(bowler,bowler_id);


             for(int j = 0;j<BALL_IN_OVER;j++){

                    int output = outputOfBall(batrate,bowlrate);

                    if(output == 7){

                        System.out.println(totalRun+ "/" +wicket + "  " + getplayerName(striker,BatTeam.get(striker)) + " score " + run );
                        //System.out.println("Wicket number " + wicket + "The batsman run is " + run);
                        Query query = new Query(Criteria.where("batsmanId").is(BatTeam.get(striker)));
                        Update update = new Update().inc("run",run);
                        mongoTemplate.updateFirst(query,update, Batsman.class);

                        wicketinlastover++;
                        striker++;
                        wicket++;
                        run = 0;

                        if(wicket == 11){
                            return totalRun;
                        }
                        batrate = calculateBatRate(striker,BatTeam.get(striker));

                    }else{
                        lastoverRun+=output;
                        run += output;
                        totalRun += output ;
                    }
             }

             Query query = new Query(Criteria.where("bowlerId").is(bowler_id));
             Update update = new Update().inc("wicket",wicketinlastover);
             mongoTemplate.updateFirst(query,update,Bowler.class);
             lastoverRun = 0;
             wicketinlastover = 0;

         }

         return totalRun;
     }

    private String getplayerName(int striker, String Batsman_id) {
         if(striker<=5){
             Optional<Batsman> byId = batsmanRepo.findById(Batsman_id);

             if(byId.isPresent()){
                 return byId.get().getName();
             }else {
                 throw new RuntimeException("Id not valid when find Name");
             }
         }else{
             Optional<Bowler> byId = bowlerRepo.findById(Batsman_id);
             if(byId.isPresent()){
                 return byId.get().getName();
             }else {
                 throw new RuntimeException("Id not valid when find Name");
             }
         }
    }



    private int calculateBatRate(int striker,String Batsman_id){

         if(striker <= 5) {
             Optional<com.example.ipl.Model.Batsman> byId = batsmanRepo.findById(Batsman_id);

             if (byId.isPresent()) {
                 return byId.get().getBatrate();
             } else {
                 throw new RuntimeException("Bat Id is not valid");
             }
          }else{
             Optional<Bowler> byId = bowlerRepo.findById(Batsman_id);
             if (byId.isPresent()) {
                 return byId.get().getBatrate();
             } else {
                 throw new RuntimeException("Bat(Bowl) Id is not valid");
             }
         }

     }

     private int calculateBowlRate(int bowler,String Bowler_id){
         Optional<Bowler> byId = bowlerRepo.findById(Bowler_id);

         if (byId.isPresent()){
             return byId.get().getBowlrate();
         }else{
             throw new RuntimeException("Id is not valid");
         }
     }


    public MatchResultDTO matchStart(MatchDTO matchDTO){

         String Team1Name = matchDTO.getTeam1();
         String Team2Name = matchDTO.getTeam2();
        Integer overs = matchDTO.getOvers();
          List<String> Team1 = teamService.getPlaying11(Team1Name);
          List<String> Team2 = teamService.getPlaying11(Team2Name);


        System.out.println();
        System.out.println("First Inning Start");
        Integer firstInningRun  = Inning(Team1, Team2, overs);
        System.out.println();
        System.out.println("Second Inning Start");
        System.out.println();
        Integer secondInningRun  = Inning(Team2,Team1,overs);

        MatchResultDTO matchResultDTO = new MatchResultDTO();

        matchResultDTO.setFirstInningRun(firstInningRun);
        matchResultDTO.setSecondInningRun(secondInningRun);
        matchResultDTO.setTeam1(Team1Name);
        matchResultDTO.setTeam2(Team2Name);


        if(firstInningRun > secondInningRun){
            matchResultDTO.setWinnerTeam(Team1Name);
          //  System.out.println(matchDTO.getTeam1() + "win" + " Total Run "+ firstInningRun + " and other Team Run is " + secondInningRun);
        }else{
            matchResultDTO.setWinnerTeam(Team2Name);
            //System.out.println(matchDTO.getTeam2() + "win" + " Total Run "+ secondInningRun + " and other Team Run is " + firstInningRun);
        }


        return matchResultDTO;
    }
}
