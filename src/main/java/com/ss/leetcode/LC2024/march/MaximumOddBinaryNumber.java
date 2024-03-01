package com.ss.leetcode.LC2024.march;

public class MaximumOddBinaryNumber {
    // https://leetcode.com/problems/maximum-odd-binary-number
    /** Algorithm
        1. Count the number of 1s
        2. If countOfOne == s.length(), return s as you have only 1s
        3. The tactic is to append one 1 at the end and the rest of 1s at the beginning. Fill the gaps with 0
        4. Use a StringBuilder to append chars
            - append 1 (numberOfOnes -1) times
            - append 0 (s.length() - numberOfOnes) times
            - append 1 one time.
    */
    public String maximumOddBinaryNumber(String s) {
        int numberOfOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            numberOfOnes += (s.charAt(i) - '0');
        }
        if (numberOfOnes == s.length()) {
            return s;
        }
        StringBuilder stb = new StringBuilder(s.length());
        append(stb, '1', numberOfOnes - 1);
        append(stb, '0', s.length() - numberOfOnes);
        append(stb, '1', 1);
        return stb.toString();
    }

    private void append(StringBuilder stb, char ch, int times) {
        while(times-- > 0) {
            stb.append(ch);
        }
    }
}
