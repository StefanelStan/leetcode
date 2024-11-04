package com.ss.leetcode.LC2024.november;

public class StringCompressionIII {
    // https://leetcode.com/problems/string-compression-iii
    /** Algorithm
        1. Use a StringBuilder to append the string compression to it
        2. Use a char variable lastChar and int lastCharCount. Set to to word[0] and 1
        3. Traverse word with i from 1 to n-1
            - if current char != lastChar  OR lastCharCount == 9, add lastCharCount and lastChar to stringbuilder.
                set lastChar to currentChar and reset counter to 1
            - else increment counter
        4. Add lastCharCount and lastChar to stringbuilder and return its value;
     */
    public String compressedString(String word) {
        StringBuilder stb = new StringBuilder();
        char lastChar = word.charAt(0);
        char currentChar;
        int lastCharCount = 1;
        for (int i = 1; i < word.length(); i++) {
            currentChar = word.charAt(i);
            if (currentChar != lastChar || lastCharCount == 9) {
                stb.append(lastCharCount).append(lastChar);
                lastChar = currentChar;
                lastCharCount = 0;
            }
            lastCharCount++;
        }
        stb.append(lastCharCount).append(lastChar);
        return stb.toString();
    }
}
