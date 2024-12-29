package com.ss.leetcode.LC2024.december;

public class FindTheEncryptedString {
    // https://leetcode.com/problems/find-the-encrypted-string
    /** Algorithm
        1. Use a StringBuilder to hold the temp string
        2. Traverse with i and append the character of s[(i + k) % n].
     */
    public String getEncryptedString(String s, int k) {
        StringBuilder stb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            stb.append(s.charAt((i + k) % s.length()));
        }
        return stb.toString();
    }
}
