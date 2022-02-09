package com.ss.leetcode.LC2022.february;

public class SumOfEvenNumbersAfterQueries {
    // https://leetcode.com/problems/sum-of-even-numbers-after-queries/
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        int[] answer = new int[queries.length];
        for (int num : nums) {
            if(num % 2 == 0) {
                evenSum += num;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            if (nums[queries[i][1]] % 2 == 0) {
                evenSum -= nums[queries[i][1]];
            }
            nums[queries[i][1]] += queries[i][0];
            if (nums[queries[i][1]] %2 == 0) {
                evenSum += nums[queries[i][1]];
            }
            answer[i] = evenSum;
        }
        return answer;
    }
}
