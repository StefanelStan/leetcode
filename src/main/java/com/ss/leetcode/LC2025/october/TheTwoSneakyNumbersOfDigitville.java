package com.ss.leetcode.LC2025.october;

public class TheTwoSneakyNumbersOfDigitville {
    // https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville
    /** Algorithm
        1. Use a boolean[n-2] present to mark the present numbers
        2. Traverse nums and assign present[num] = !present[num];
        3. If present[num] is false after the assignment, it means it has been assigned twice, so it's duplicated. Add it to answer;
     */
    public int[] getSneakyNumbers(int[] nums) {
        boolean[] present =  new boolean[nums.length - 2];
        int[] sneaky = new int[2];
        int index = 0;
        for (int num : nums) {
            present[num] = !present[num];
            if (!present[num]) {
                sneaky[index++] = num;
            }
        }
        return sneaky;
    }
}
