package com.example.ipl.Utility;

public class OutputOfBall {
    public static int outputOfBall(int batrate,int bowlrate) {
        int abilityDiff = batrate - bowlrate;
        int index = RandomUtil.RandomNumber(10);
        int value = RandomUtil.RandomNumber(99);

        if(abilityDiff < 0){
            if( value%3 != 0) {
                return AbilityToHit.StrongerToWeaker.get(index);
            }else{
                return AbilityToHit.WeakerToStronger.get(index);
            }
        }else if(  abilityDiff <= 10){
            if( value%2 != 0) {
                return AbilityToHit.StrongerToAverage.get(index);
            }else{
                return AbilityToHit.AverageToStronger.get(index);
            }
        }else {
            if(value%3 == 0) {
                return AbilityToHit.StrongerToStronger.get(index);
            }else{
                return AbilityToHit.StrongerBatToStronger.get(index);
            }
        }

    }
}
