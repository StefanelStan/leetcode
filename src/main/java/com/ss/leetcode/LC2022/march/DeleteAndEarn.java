package com.ss.leetcode.LC2022.march;

public class DeleteAndEarn {
    // https://leetcode.com/problems/delete-and-earn/
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        int max = 0;
        for(int num : nums) {
            count[num]++;
            max = Math.max(max, num);
        }

        int prev = 0, temp = 0;
        int current = count[1];
        for(int i = 2; i <= max; i++) {
            temp = current;
            current = Math.max(current, prev + i * count[i]);
            prev = temp;
        }
        return Math.max(prev, current);
    }
}
