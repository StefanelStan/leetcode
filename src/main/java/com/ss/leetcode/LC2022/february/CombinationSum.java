package com.ss.leetcode.LC2022.february;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // https://leetcode.com/problems/combination-sum/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> targetSums =  new ArrayList<>();
        getCombinations(candidates, 0, 0, target, new ArrayList<>(), targetSums);
        return targetSums;
    }

    public void getCombinations(int[] candidates, int i, int currSum, int targetSum,
                                List<Integer> tempSum, List<List<Integer>> targetSums) {
        if(i >= candidates.length) {
            return;
        }
        boolean skipped = false;
        while(currSum < targetSum) {
            if (!skipped) {
                getCombinations(candidates, i + 1, currSum, targetSum, new ArrayList<>(tempSum), targetSums);
                skipped = true;
            } else {
                currSum += candidates[i];
                if (currSum == targetSum) {
                    tempSum.add(candidates[i]);
                    targetSums.add(tempSum);
                } else if (currSum < targetSum) {
                    tempSum.add(candidates[i]);
                    getCombinations(candidates, i + 1, currSum, targetSum, new ArrayList<>(tempSum), targetSums);
                }
            }
        }
    }
}
