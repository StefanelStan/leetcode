package com.ss.leetcode.LC2024.october;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {
    // https://leetcode.com/problems/make-sum-divisible-by-p
    public int minSubarray(int[] nums, int p) {
        int longest = 0;
        long totalSum = 0, prefixSum = 0;
        int prefixModulo, rightModulo;
        Map<Integer, int[]> moduloMap = new HashMap<>();
        int[] complementaryModulo;
        for (int num : nums) {
            totalSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            prefixModulo = (int)(prefixSum % p);
            if (prefixModulo == 0) {
                longest = Math.max(longest, i + 1);
            } else {
                rightModulo = (int)((totalSum - prefixSum) % p);
                complementaryModulo = moduloMap.get(rightModulo == 0 ? 0 : p - rightModulo);
                if (complementaryModulo != null) {
                    longest = Math.max(longest, complementaryModulo[1] + 1 + (nums.length - (1 + i)));
                }
                if (i == nums.length - 1) {
                    complementaryModulo = moduloMap.get(prefixModulo);
                    if (complementaryModulo != null) {
                        longest = Math.max(longest, nums.length - (1 + complementaryModulo[0]));
                    }
                }
            }
            putInMap(prefixModulo, i, moduloMap);
        }
        return longest == 0 ? -1 : nums.length - longest;
    }

    private void putInMap(int modulo, int index, Map<Integer, int[]> moduloMap) {
        int[] firstAndLast = moduloMap.computeIfAbsent(modulo, k -> new int[]{-1, -1});
        firstAndLast[1] = index;
        if (firstAndLast[0] == -1) {
            firstAndLast[0] = index;
        }
    }
}
