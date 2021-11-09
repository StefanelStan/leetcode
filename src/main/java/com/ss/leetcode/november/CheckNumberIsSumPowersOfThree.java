package com.ss.leetcode.november;

public class CheckNumberIsSumPowersOfThree {
    // https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
    int[] powers;
    public boolean checkPowersOfThree(int n) {
        setPowers();
        int powerIndex = powers.length;
        while(n > 0) {
            powerIndex = getPowerIndex(n, powerIndex-1);
            if (powerIndex == -1) {
                return false;
            }
            n = n - powers[powerIndex];
            if (n == 0) {
                return true;
            } else if (n < 0) {
                return false;
            }
        }
        return false;
    }

    private void setPowers() {
        if(powers == null) {
            powers = new int[19];
        }
        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = powers[i-1] * 3;
        }
    }

    private int getPowerIndex(int n, int endPosition) {
        while(endPosition >= 0) {
            if (n >= powers[endPosition]) {
                return endPosition;
            } else {
                endPosition--;
            }
        }
        return -1;
    }
}
