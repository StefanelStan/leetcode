package com.ss.leetcode.LC2022.march;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPickIndex {
    // https://leetcode.com/problems/random-pick-index/
    Random rand;
    Map<Integer, List<Integer>> numPos;

    public RandomPickIndex(int[] nums) {
        rand = new Random();
        numPos = parseAndInsertNums(nums);
    }

    public int pick(int target) {
        List<Integer> nums = numPos.get(target);
        return nums.get(rand.nextInt(nums.size()));
    }

    private Map<Integer, List<Integer>> parseAndInsertNums(int[] nums) {
        Map<Integer, List<Integer>> numPos = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            numPos.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        return numPos;
    }
}
