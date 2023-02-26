package com.ss.leetcode.LC2023.february;

public class LeftAndRightSumDifferences {
    // https://leetcode.com/problems/left-and-right-sum-differences
    /** Algorithm
        1. Get the sum of all elements of nums. Use an int[] answer that will hold the leftRigthDifference;
        2. While traversing nums from i = 0 to n-1, add the nums to a rollingSum.
        3. For each index i, leftSum[i] = rollingSum - nums[i], while rightSum = totalSum - rollingSum.
        4. Store the answer into answer[i]
     */
    public int[] leftRigthDifference(int[] nums) {
        int[] answer = new int[nums.length];
        int totalSum = getSum(nums);
        int rollingSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rollingSum += nums[i];
            answer[i] = Math.abs((rollingSum - nums[i]) - (totalSum - rollingSum));
        }
        return answer;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum;
    }
}
