package com.ss.leetcode.LC2021.november;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] existing = new boolean[nums.length + 1];

        for (int num : nums) {
            existing[num] = true;
        }
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 1; i < existing.length; i++) {
            if (!existing[i]) {
                missingNumbers.add(i);
            }
        }
        return missingNumbers;
    }
}
