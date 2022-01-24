package com.ss.leetcode.LC2022.january;

import java.util.Arrays;

public class LongestHarmoniousSubsequence {
    // https://leetcode.com/problems/longest-harmonious-subsequence/
    public int findLHS(int[] nums) {
        if (nums.length ==1) {
            return 0;
        }
        int[] subSeq = new int[2];
        boolean[] isSet = new boolean[2];
        int longest = 0;
        Arrays.sort(nums);
        subSeq[0] = 1;
        isSet[0] = true;
        int tempDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            tempDiff = Math.abs(nums[i] - nums[i-1]);
            if (tempDiff == 0) { //two consec numebers. set 1 or 2 ?
                if (isSet[1]) {
                    subSeq[1]++;
                    longest = Math.max(longest, subSeq[0] + subSeq[1]);
                } else {
                    subSeq[0]++;
                }
            } else if (tempDiff == 1) {
                // 11 -> 2 or 1122->3
                if (isSet[1]) { // 1122 -> 3
                    subSeq[0] = subSeq[1];
                    subSeq[1] = 1;
                } else {
                    isSet[1] = true;
                    subSeq[1] = 1;
                }
                longest = Math.max(longest, subSeq[0] + subSeq[1]);
            } else {
                // diff > 2 so cancel 2nd and set 1
                subSeq[0] = 1;
                subSeq[1] = 0;
                isSet[1] = false;
            }
        }
        if (isSet[1]) {
            return Math.max(longest, subSeq[0] + subSeq[1]);
        } else {
            return longest;
        }

    }
}
