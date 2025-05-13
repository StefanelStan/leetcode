package com.ss.leetcode.LC2025.may;

public class TotalCharactersInStringAfterTransformationsI {
    // https://leetcode.com/problems/total-characters-in-string-after-transformations-i
    /** Algorithm
        1. Count the chars of s: int[26] count;
        2. While t > 0, loop with i from 24 to 0
            - get a copy of count[25] (z)
            - move all the counts from i to i+1
            - increment count[0] and count[1] with the initial copy of count[25]. Make sure you MOD it as addition can lead to overflow
        3. At the end, loop over the count and add each MODDED value
     */
    private static final int MOD = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int zCount;
        while (t-- > 0) {
            zCount = count[count.length - 1];
            for (int i = count.length - 2; i >= 0; i--) {
                count[i + 1] = count[i];
            }
            count[0] = zCount;
            count[1] =  (count[1] + zCount) % MOD;
        }
        int length = 0;
        for (int c : count) {
            length = (length + c) % MOD;
        }
        return length;
    }
}
