package com.ss.leetcode.LC2023.july;

import java.util.Arrays;

public class FindTheKthLargestIntegerInTheArray {
    // https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array
    /** Algorithm
        1. Sort the numbers by passing a custom comparator
            - the shortest string denotes a smaller int
            - if their length is equal, just return the result of their string comparison
        2. Return the kth largest int (kth distance from the largest one so nums.length - k)
     */
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a,b) -> a.length() < b.length() ? -1 : a.length() > b.length() ? 1 : a.compareTo(b));
        return nums[nums.length - k];
    }
}
