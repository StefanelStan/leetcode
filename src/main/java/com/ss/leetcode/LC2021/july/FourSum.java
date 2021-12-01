package com.ss.leetcode.LC2021.july;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new LinkedList<>();
        Set<Integer> hashSets = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -3; i++) {
            for (int j = i+1; j < nums.length - 2; j++) {
                for (int k = j+1; k < nums.length -1; k++) {
                    for (int l = k+1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            if (!hashSets.contains(list.hashCode())) {
                                hashSets.add(list.hashCode());
                                answer.add(list);
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
