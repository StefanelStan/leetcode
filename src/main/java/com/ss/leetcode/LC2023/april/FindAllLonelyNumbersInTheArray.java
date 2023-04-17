package com.ss.leetcode.LC2023.april;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllLonelyNumbersInTheArray {
    // https://leetcode.com/problems/find-all-lonely-numbers-in-the-array
    /** Algorithm
        1. If nums.length == 1, return the single number
        2. Sort the numbers
        3. If n[0] + 1 < n[1], add it to list. Same for last number.
            Do this to avoid extra checks inside the loop.
        4. From i = 1 to n-2, if n[i-1] + 1 < n[i] && n[i] + 1 < n[i+1]
            (left +1 less than current and current + 1 less than next), add current to list
        5. Return the list.
     */
    public List<Integer> findLonely(int[] nums) {
        if (nums.length == 1) {
            return List.of(nums[0]);
        }
        Arrays.sort(nums);
        List<Integer> lonelyNumbers = new LinkedList<>();
        if (nums[0] + 1 < nums[1]) {
            lonelyNumbers.add(nums[0]);
        }
        if (nums[nums.length -2] + 1 < nums[nums.length -1]) {
            lonelyNumbers.add(nums[nums.length - 1]);
        }
        for (int i = 1; i < nums.length -1; i++) {
            if (nums[i - 1] + 1 < nums[i] && nums[i] + 1 < nums[i+1]) {
                lonelyNumbers.add(nums[i]);
            }
        }
        return lonelyNumbers;
    }
}
