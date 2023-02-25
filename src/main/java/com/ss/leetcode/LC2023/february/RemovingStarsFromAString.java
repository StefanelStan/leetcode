package com.ss.leetcode.LC2023.february;

public class RemovingStarsFromAString {
    // https://leetcode.com/problems/removing-stars-from-a-string
    /** Algorithm
        1. Use a StringBuilder stb that will hold the answer string
        2. Traverse s and if current char is *, delete last char from stb, else append it to stb.
        3. Return stb string.
     */
    public String removeStars(String s) {
        StringBuilder stb = new StringBuilder();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '*') {
                stb.setLength(Math.max(0, stb.length() -1));
            } else {
                stb.append(ch);
            }
        }
        return stb.toString();
    }
}
