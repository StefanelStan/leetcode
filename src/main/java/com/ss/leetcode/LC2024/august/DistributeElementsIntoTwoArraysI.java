package com.ss.leetcode.LC2024.august;

public class DistributeElementsIntoTwoArraysI {
    // https://leetcode.com/problems/distribute-elements-into-two-arrays-i
    /** Algorithm
        1. Use first[n] second[n] to store the two arrays. Add nums[0] to first and nums[1] to second
        2. Traverse nums with i [2..n] and check if last first[] > last second[]. Add nums[i] to first[] or second[].
            - Keep two indices for first[] and second[].
        3. Copy the valid elements from second[] into first, in the continuation where the traversal/first index stopped.
     */
    public int[] resultArray(int[] nums) {
        int[] first = new int[nums.length];
        int[] second = new int[nums.length];
        int index1 = 0, index2 = 0;
        first[0] = nums[0];
        second[0] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (first[index1] > second[index2]) {
                first[++index1] = nums[i];
            } else {
                second[++index2] = nums[i];
            }
        }
        for (int i = 0; i <= index2; i++) {
            first[++index1] = second[i];
        }
        return first;
    }
}
