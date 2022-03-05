package com.ss.leetcode.LC2022.march;

public class MostFrequentNumberFollowingKeyInAnArray {
    // https://leetcode.com/contest/biweekly-contest-73/problems/most-frequent-number-following-key-in-an-array/
    public int mostFrequent(int[] nums, int key) {
        int mostFrequent = 0;
        int mostFrequentIndex = 0;
        int[] frequencies = new int[1001];
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] == key) {
                frequencies[nums[i+1]]++;
            }
        }
        for (int i = 1; i < frequencies.length; i++) {
            if (frequencies[i] > mostFrequent) {
                mostFrequent = frequencies[i];
                mostFrequentIndex = i;
            }
        }
        return mostFrequentIndex;
    }
}
