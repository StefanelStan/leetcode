package com.ss.leetcode.july;

public class ConcatenationOfArray {
    // https://leetcode.com/problems/concatenation-of-array/
    public int[] getConcatenation(int[] nums) {
        int[] answer = new int[nums.length * 2];
        for (int i = 0, j = nums.length; i < nums.length; i++, j++) {
            answer[i] = nums[i];
            answer[j] = nums[i];
        }
        return answer;
    }
}
