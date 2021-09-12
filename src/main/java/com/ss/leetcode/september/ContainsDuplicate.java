package com.ss.leetcode.september;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    // https://leetcode.com/problems/contains-duplicate/
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numberSet =  new HashSet<>();
        for (int num : nums) {
            if (!numberSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}
