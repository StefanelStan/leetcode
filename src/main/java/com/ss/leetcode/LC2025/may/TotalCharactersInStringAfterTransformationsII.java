package com.ss.leetcode.LC2025.may;

import java.util.List;

public class TotalCharactersInStringAfterTransformationsII {
    // https://leetcode.com/problems/total-characters-in-string-after-transformations-ii
    // TLE
    private static final int MODULO = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return getLengthAfterTransformations(count, t, nums);
    }

    private int getLengthAfterTransformations(int[] count, int t, List<Integer> nums) {
        int length = 0, nextChar, times;
        int[] newCount = new int[26];
        while (t-- > 0) {
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    times = nums.get(i);
                    for (int j = 1; j <= times; j++) {
                        nextChar = (i + j) % 26;
                        newCount[nextChar] = (count[i] + newCount[nextChar]) % MODULO;
                    }
                }
            }
            count = newCount;
            newCount = new int[26];
        }
        for (int c : count) {
            length = (length + c) % MODULO;
        }
        return length;
    }
}
