package com.ss.leetcode.august;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementIn2NArray {
    // https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
    public int repeatedNTimes(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (!unique.add(num)){
                return num;
            }
        }
        return 1;
    }
}
