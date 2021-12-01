package com.ss.leetcode.LC2021.november;

import java.util.HashSet;
import java.util.Set;

public class MinimumMovesToEqualArrayElementsII {
    // https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
    public int minMoves2(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        long genSum = 0;
        long negSum = 0, negCount = 0;
        long posSum = 0, posCount = 0;
        for (int num : nums)  {
            uniques.add(num);
            if (num > 0) {
                posSum += num;
                posCount++;
            } else if (num < 0) {
                negSum += num;
                negCount++;
            }
            genSum += num;
        }
        double avg = 0.0;
        if (Math.abs(negSum) > Math.abs(posSum)) {
            avg = (double) negSum / negCount;

        } else {
            avg = (double) posSum / posCount;
        }
        int ceil = (int) Math.ceil(avg);
        int floor = (int) Math.floor(avg);
        int target = uniques.contains(ceil) ? ceil : uniques.contains(floor) ? floor : (int)avg;
        int steps = 0;
        for (int num : nums) {
            steps += getStepsToTarget(num, target);
        }
        return steps;
    }

    private int getStepsToTarget(int num, int target) {
        if (num >= 0 && target >= 0 || (num <0 && target < 0)) {
            return Math.abs(num - target);
        } else {
            return Math.abs(num) + Math.abs(target);
        }
    }
}
