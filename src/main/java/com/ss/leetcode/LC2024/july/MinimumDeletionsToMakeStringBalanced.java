package com.ss.leetcode.LC2024.july;

public class MinimumDeletionsToMakeStringBalanced {
    // https://leetcode.com/problems/minimum-deletions-to-make-string-balanced
    /** Algorithm
        1. You need to create a string of type aaa OR bbb OR aaabbb
        2. The problems occur when you have ba chars as you need to either delete b or a
        3. Traverse the string and keep track of number of b
        4. When you encounter an a and your b count > 0, then one of them needs to be deleted. Increase the deletion count, but also the b count.
        5. Return the deletion count;
     */
    public int minimumDeletions(String s) {
        int bCount = 0, deleted = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (bCount > 0) {
                    bCount--;
                    deleted++;
                }
            } else {
                bCount++;
            }
        }
        return deleted;
    }
}
