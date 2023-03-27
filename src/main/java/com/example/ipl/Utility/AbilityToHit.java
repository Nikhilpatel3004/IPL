package com.example.ipl.Utility;

import java.util.ArrayList;
import java.util.Arrays;

public class AbilityToHit {
   public static ArrayList<Integer> StrongerToStronger = new ArrayList<>(Arrays.asList(0,1,1,1,2,4,4,6,6,7,7,7));
   public static ArrayList<Integer> StrongerBatToStronger = new ArrayList<>(Arrays.asList(0,0,1,1,2,2,4,4,6,6,6,7));
   public static ArrayList<Integer> StrongerToAverage =  new ArrayList<>(Arrays.asList(0,0,0,1,1,2,4,6,7,7,7,7));
   public static ArrayList<Integer> AverageToStronger =  new ArrayList<>(Arrays.asList(0,0,1,1,2,2,4,4,6,6,7,7));
   public static ArrayList<Integer> StrongerToWeaker =   new ArrayList<>(Arrays.asList(0,0,0,1,2,4,6,7,7,7,7,7));
   public static ArrayList<Integer> WeakerToStronger =  new ArrayList<>(Arrays.asList(0,0,0,1,2,2,2,4,4,6,7,7));
}
