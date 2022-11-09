package com.ss.leetcode.LC2022.november;

public class MakeTheStringGreat {
    // https://leetcode.com/problems/make-the-string-great/
    /** Algorithm
        1. Use a StringBuilder to append chars
        2. Iterate over s and check if current char and last char from stringBuilder are "bad chars".
            - If yes, then remove the last char from stringBuilder.
            - If No, then add current char to stringBuilder
        3. Return stringBuilder.toString();
     */
    public String makeGood(String s) {
        StringBuilder stb = new StringBuilder(s.length());
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (!stb.isEmpty()) {
                if (hasBadAdjacentCharacters(stb.charAt(stb.length() - 1), ch)) {
                    stb.setLength(stb.length() - 1);
                }  else {
                    stb.append(ch);
                }
            } else {
                stb.append(ch);
            }
        }
        return stb.toString();
    }

    private boolean hasBadAdjacentCharacters(char left, char right) {
        return left + 32 == right || left == right + 32;
    }
}
