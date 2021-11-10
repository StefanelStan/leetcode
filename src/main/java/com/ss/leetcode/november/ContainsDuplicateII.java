package com.ss.leetcode.november;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    // https://leetcode.com/problems/contains-duplicate-ii/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        Integer value;
        for (int i = 0; i < nums.length; i++) {
            value = numMap.get(nums[i]);
            if (value != null) {
                if (Math.abs(value - i) <= k) {
                    return true;
                }
            }
            numMap.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        int[][] numsAndPos = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numsAndPos[i][0] = i;
            numsAndPos[i][1] = nums[i];
        }

        Arrays.sort(numsAndPos, (a,b) -> {
            if (a[1] == b[1]) {
                return a[0] < b[0] ? 1 : -1;
            } else {
                return a[1] < b[1] ? 1 : -1;
            }
        });
        for (int i = 0; i < nums.length-1;) {
            if (numsAndPos[i][1] == numsAndPos[i+1][1]) {
                int j = i+1;
                for (;j < nums.length && numsAndPos[j][1] == numsAndPos[i][1]; j++) {
                    if (Math.abs(numsAndPos[j][0] - numsAndPos[j-1][0]) <= k) {
                        return true;
                    }
                }
                i = j;
            } else {
                i++;
            }
        }
        return false;
    }
}
