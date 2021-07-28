package com.ss.leetcode.december;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new LinkedList<>();
        if (nums.length <= 2) return sums;
        Arrays.sort(nums);
        int lowIndex, highIndex, partialSum;
        for (int i = 0; i < nums.length - 2; i++) {
            lowIndex = i + 1;
            highIndex = nums.length - 1;
            while(lowIndex < highIndex){
                partialSum = nums[lowIndex] + nums[highIndex];
                if (partialSum > -nums[i]) {
                    highIndex--;
                } else if (partialSum < -nums[i]) {
                    lowIndex++;
                } else {
                    addToList(sums, Arrays.asList(nums[i], nums[lowIndex], nums[highIndex]));
                    highIndex--;
                }
            }
        }
        return sums;
    }

    private void addToList(List<List<Integer>> sums, List<Integer> nrs) {
        for (List<Integer> sum : sums) {
            if (sum.get(0).equals(nrs.get(0)) && sum.get(1).equals(nrs.get(1)) && sum.get(2).equals(nrs.get(2))){
                return;
            }
        }
        sums.add(nrs);
    }
}
