package com.example.ipl.Service;

import com.example.ipl.DTO.ElectDTO;
import com.example.ipl.DTO.TossDTO;
import com.example.ipl.Enum.BatOrBall;
import com.example.ipl.Enum.Toss;
import com.example.ipl.Model.Elect;
import com.example.ipl.Repo.ElectRepo;
import com.example.ipl.Utility.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TossService {

    @Autowired
    private  ElectRepo electRepo;

    public  String flipCoin(TossDTO tossDTO) {
        int val = RandomUtil.RandomNumber(2);
        //0 means HEAD
        if((val&1) == 0){
            if(tossDTO.getToss() == Toss.HEAD){
                return  "You won :)";
            }else{
                return "You Loss :( ";
            }
        }else{
            //1 means Tail
            if(tossDTO.getToss() == Toss.TAIL){
                return  "You won :)";
            }else{
                return "You Loss :( ";
            }
        }
    }

    public  String electBatOrBall(ElectDTO electDTO) {
         Elect elect = new Elect();
        System.out.println(electDTO.getTossWinnerTeamName());
        System.out.println(electDTO.getTossLoseTeamName());
         elect.setTeamName(electDTO.getTossWinnerTeamName());
         elect.setLoseTeamName(electDTO.getTossLoseTeamName());
        if(electDTO.getElect() == null){
             int val = RandomUtil.RandomNumber(2);
            BatOrBall batOrBall ;
             if((val & 1) == 0){
                 batOrBall = BatOrBall.BAT;
             }else{
                 batOrBall = BatOrBall.BOWL;
             }
             elect.setBatOrBall(batOrBall);
        }else{
            elect.setBatOrBall(electDTO.getElect());
        }
        System.out.println(elect.getTeamName()+ "   " + elect.getLoseTeamName());
        return electRepo.save(elect).getElectId();
    }
}
