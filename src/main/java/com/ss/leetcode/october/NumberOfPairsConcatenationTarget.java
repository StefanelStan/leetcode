package com.ss.leetcode.october;

public class NumberOfPairsConcatenationTarget {
    // https://leetcode.com/contest/biweekly-contest-62/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
    public int numOfPairs(String[] nums, String target) {
        int numOfPairs = 0;
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if ((nums[i] + nums[j]).equals(target)) {
                        numOfPairs++;
                    }
                }
            }
        }
        return  numOfPairs;
    }
}
