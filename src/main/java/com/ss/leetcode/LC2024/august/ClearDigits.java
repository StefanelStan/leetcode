package com.ss.leetcode.LC2024.august;

public class ClearDigits {
    // https://leetcode.com/problems/clear-digits
    /** Algorithm
        1. Use a stringBuilder to add valid chars
        2. Traverse the string and if current char is a letter, append it to stringbuilder, else decrease the length of string builder by 1(delete last char)
        3. Return stb.toString();
     */
    public String clearDigits(String s) {
        StringBuilder stb = new StringBuilder();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch >= 'a') {
                stb.append(ch);
            } else {
                stb.setLength(stb.length() - 1);
            }
        }
        return stb.toString();
    }
}
