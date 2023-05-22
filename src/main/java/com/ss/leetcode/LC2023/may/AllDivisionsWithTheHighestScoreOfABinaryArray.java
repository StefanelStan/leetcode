package com.ss.leetcode.LC2023.may;

import java.util.ArrayList;
import java.util.List;

public class AllDivisionsWithTheHighestScoreOfABinaryArray {
    // https://leetcode.com/problems/all-divisions-with-the-highest-score-of-a-binary-array
    /** Algorithm
        1. Count number of ones from array
        2. From i = 0 to n
            - determine the current score my adding countOfZero and countOfOne
            - if currentScore >= maxScore, add i to the list of maxScores (flush the list if current > max)
            - increment countOfZero (if current nr is 0)
            - decrement countOfOne (if current nr is 1)
        3. Return the list of max indices.
     */
    public List<Integer> maxScoreIndices(int[] nums) {
        int numsOfOne = getNumsOfOne(nums);
        return getMaxScoreIndices(nums, numsOfOne);
    }

    private List<Integer> getMaxScoreIndices(int[] nums, int ones) {
        List<Integer> maxScoreIndices = new ArrayList<>();
        int maxScore = 0, currentScore = 0;
        int countOfZero = 0;
        for (int i = 0; i <= nums.length; i++) {
            currentScore = countOfZero + ones;
            if (currentScore > maxScore) {
                maxScore = currentScore;
                maxScoreIndices.clear();
                maxScoreIndices.add(i);
            } else if (currentScore == maxScore) {
                maxScoreIndices.add(i);
            }
            countOfZero += i < nums.length ? 1 - nums[i] : 0;
            ones -= i < nums.length ? nums[i] : 0;
        }
        return maxScoreIndices;
    }

    private int getNumsOfOne(int[] nums) {
        int ones = 0;
        for (int num : nums) {
            ones += num;
        }
        return ones;
    }
}
