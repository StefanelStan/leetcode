package com.ss.leetcode.LC2023.january;

public class RearrangeCharactersToMakeTargetString {
    // https://leetcode.com/problems/rearrange-characters-to-make-target-string/
    /** Algorithm
         1. In order to make copies of target, you need to know how many letters of each time from target you have in s string;
         2. Count/map the letters from s and target
         3. For each letter of target, divide the count of that letter from s to the count of target.
             EG: s = "aabba" -> 3a 2b
             t = "ab"      1a 1b
             Letter  a: 3 / 1 = 3 -  you can make max 3 copies
             Letter  b: 2 / 1 = 2 - you can make max 2 copies.
         4. Return the min of all divisions of all letters from target.
     */
    public int rearrangeCharacters(String s, String target) {
        int[] sCount = getCount(s);
        int[] tCount = getCount(target);
        int maxCopies = 101;
        for (int i = 0; i < sCount.length; i++) {
            if (tCount[i] != 0) {
                maxCopies = Math.min(maxCopies, sCount[i] / tCount[i]);
            }
        }
        return maxCopies;
    }

    private int[] getCount(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }
}
