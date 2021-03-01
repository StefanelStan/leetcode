package com.ss.leetcode.march;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> distribution = new ArrayList<>(candies.length);
        int max = 0;
        for(int candy : candies) {
            if (candy > max) {
                max =  candy;
            }
        }
        for(int candy : candies) {
            distribution.add(candy + extraCandies >= max);
        }
        return distribution;
    }
}
