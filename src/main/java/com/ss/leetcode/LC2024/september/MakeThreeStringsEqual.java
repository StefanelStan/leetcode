package com.ss.leetcode.LC2024.september;

public class MakeThreeStringsEqual {
    // https://leetcode.com/problems/make-three-strings-equal
    /** Algorithm
        1. For the strings to be equal, they need to have the same length: at least the length of the shortest.
        2. Loop with i from 0 to shortestLength
            - If s1[i] == s2[i] == s3[i] then advance your pointer. eG: i = 1
            - If not, then this [0..i -1] is the common prefix of all 3 strings. S1 will need to remove s1.length - index; s2: s2.length -index; so s3.
     */
    public int findMinimumOperations(String s1, String s2, String s3) {
        int minLength = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int index = 0;
        boolean areMatching = true;
        while(areMatching && index < minLength) {
            areMatching = s1.charAt(index) == s2.charAt(index) && s2.charAt(index) == s3.charAt(index);
            index += areMatching ? 1 : 0;
        }
        return index == 0 ? -1 : s1.length() + s2.length() + s3.length() - 3 * index;
    }
}
