package com.ss.leetcode.LC2024.february;

import java.util.Arrays;

public class FindPolygonWithTheLargestPerimeter {
    // https://leetcode.com/problems/find-polygon-with-the-largest-perimeter
    /** Algorithm
        1. Sort the numbers and get their sum
        2. Iterate with i from n-1 to 2. If prefixSum [i-1] > nums[i], then you have a poligon
            with sum prefix[i]. Return the prefixSum of current index.
        3. Return -1 by default.
     */
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = nums.length - 1; i >= 2; i--) {
            sum -= nums[i];
            if (sum > nums[i]) {
                return sum + nums[i];
            }
        }
        return -1;
    }
}
