package com.example.ipl.Utility;

public class SelectBowler {
    public static int selectBowler(int bowler) {

        int RandomNumber = RandomUtil.RandomNumber(5);

        if(RandomNumber + 6 == bowler){
            RandomNumber = (RandomNumber+1)%5;
        }
        return RandomNumber+6;
    }
}
