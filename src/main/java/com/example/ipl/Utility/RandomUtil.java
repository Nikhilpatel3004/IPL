package com.example.ipl.Utility;

import java.security.SecureRandom;

public class RandomUtil {
    private static SecureRandom secureRandom = new SecureRandom();

    public static int RandomNumber(int bound){
        return secureRandom.nextInt(bound);
    }
}
