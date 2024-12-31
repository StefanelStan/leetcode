package com.ss.leetcode.LC2024.december;

public class LargestPalindromicNumber {
    // https://leetcode.com/problems/largest-palindromic-number
    /** Algorithm
        1. Traverse num and get the count of each digit in count[10]. You want to add the highest numbers first
        2. The logic is to append only half of numbers and then just mirror the first half into second half
        3. Start from highest digit (9) and try to append half of them.
            - You have a special case where you can have a number an oddly times, but only once.
            - EG: 3 9s. You want to add one nine at the beginning and 1 9 at the middle.
        4. Edge case: if you stringbuilder isempty, do not append 0s, but just 1 zero.
     */
    public String largestPalindromic(String num) {
        StringBuilder stb = new StringBuilder();
        int[] count = new int[10];
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i) - '0']++;
        }
        int toAddAtMiddle = appendHalfOfPalindrome(stb, count);
        if (toAddAtMiddle != -1) {
            stb.append((char)(toAddAtMiddle + '0'));
            appendReverse(stb, stb.length() - 2);
        } else {
            appendReverse(stb, stb.length() - 1);
        }
        if (stb.isEmpty() && count[0] > 0) {
            return "0";
        }
        return stb.toString();
    }

    private void appendReverse(StringBuilder stb, int from) {
        while (from >= 0) {
            stb.append(stb.charAt(from));
            from--;
        }
    }

    private int appendHalfOfPalindrome(StringBuilder stb, int[] count) {
        int toAddAtEnd = -1;
        for (int i = 9; i >= 0; i--) {
            if (count[i] > 0) {
                if (count[i] % 2 == 0) {
                    if (!(i == 0 && stb.isEmpty())) {
                        append(stb, (char)(i + '0'), count[i] / 2);
                    }
                } else {
                    if (toAddAtEnd == -1) {
                        toAddAtEnd = i;
                    }
                    if (!(i == 0 && stb.isEmpty())) {
                        append(stb, (char)(i + '0'), count[i] / 2);
                    }
                }
            }
        }
        return toAddAtEnd;
    }

    private void append(StringBuilder stb, char ch, int times) {
        while (times-- > 0) {
            stb.append(ch);
        }
    }
}
