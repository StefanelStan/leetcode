package com.ss.leetcode.LC2023.october;

public class BinaryStringWithSubstringsRepresenting1ToN {
    // https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n
    /** Algorithm
        1. Loop with i from 1 to n and check if s contains binary representation of i
        2. Break and return false if it does not.
     */
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
