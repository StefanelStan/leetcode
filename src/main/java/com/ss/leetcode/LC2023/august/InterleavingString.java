package com.ss.leetcode.LC2023.august;

public class InterleavingString {
    // https://leetcode.com/problems/interleaving-string
    /** Algorithm
        1. Fail fast: if their lengths do not match return false;
        2. Fail fast: if one of them is empty, return s3.equals(the_other_string)
        3. Use an int[s1.length +1][s2.length+1] to keep track/cache/memo the attempts to build s3 while being at index s1Index of s1 and s2Index of s2. (0 - not visited, 1 - false, cannot build, 2 -success, you can build)
        4. Using a recursive method, if current step has not been attempted, try to build the string
        5. Match char of s1Index with char of s3. If they match, move forward with s1Index +1
        6. If the prev recursive result is NOT 2, then try matching s2Index with s3. If they match, try buildsing using s2Index + 1.
        7. While building, if s1Index >= s1.length && s2Index >= s1.length && s3Index >= s3.length, you haved reached the end of ALL 3 strings and have build the whole string
        8. Recursively, build and return the result of int[0][0] == 2.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        //fail fast (diff length or "" strings);
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        } else if (s1.isEmpty()) {
            return s3.equals(s2);
        } else if (s2.isEmpty()) {
            return s3.equals(s1);
        }
        int[][] interleaving = new int[s1.length() + 1][s2.length() + 1];
        return interleave(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0, interleaving) == 2;
    }

    private int interleave(char[] s1, int s1Index, char[] s2, int s2Index, char[] s3, int s3Index, int[][] interleaving) {
        if (s1Index >= s1.length && s2Index >= s2.length && s3Index >= s3.length) {
            interleaving[s1Index][s2Index] = 2;
        }
        if (interleaving[s1Index][s2Index] == 0) {
            int canBeBuild = 1;
            if (s1Index < s1.length && s1[s1Index] == s3[s3Index]) {
                canBeBuild = Math.max(canBeBuild, interleave(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1, interleaving));
            }
            if (canBeBuild != 2 && s2Index < s2.length && s2[s2Index] == s3[s3Index]) {
                canBeBuild = Math.max(canBeBuild, interleave(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1, interleaving));
            }
            interleaving[s1Index][s2Index] = canBeBuild;
        }
        return interleaving[s1Index][s2Index];
    }
}
