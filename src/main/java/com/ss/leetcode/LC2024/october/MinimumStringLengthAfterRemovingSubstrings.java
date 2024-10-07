package com.ss.leetcode.LC2024.october;

public class MinimumStringLengthAfterRemovingSubstrings {
    // https://leetcode.com/problems/minimum-string-length-after-removing-substrings
    /** Algorithms
        1. Use a stack or StringBuilder to traverse and append chars
        2. If current char is 'B' and last one from stack / stringBuilder is 'A' or D and C on stack, remove from stack
        3. Else add current char cu stacl/stringBuilder
        4. Return stack/stringbuilder length.
     */
    public int minLength(String s) {
        StringBuilder stb = new StringBuilder();
        char currentChar, prevChar = 0;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (!stb.isEmpty() && ((currentChar == 'B' && prevChar == 'A') || (currentChar == 'D' && prevChar == 'C'))) {
                stb.setLength(stb.length() - 1);
                prevChar = stb.isEmpty() ? 0 : stb.charAt(stb.length() - 1);
            } else {
                stb.append(currentChar);
                prevChar = currentChar;
            }
        }
        return stb.length();
    }
}
