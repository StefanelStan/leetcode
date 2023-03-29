package com.ss.leetcode.LC2023.march;

public class MaximumValueAfterInsertion {
    // https://leetcode.com/problems/maximum-value-after-insertion
    /** Algorithm
        1. If n is positive, insert x before the first digit that is lesser than x, else at the end
        2. f n is negative, insert x before the first digit greater than x, else at the end.
        3. Return the modified n
     */
    public String maxValue(String n, int x) {
        StringBuilder stb = new StringBuilder(n.length() + 1);
        boolean isNegative = n.charAt(0) == '-';
        int i = 0;
        if (isNegative) {
            stb.append(n.charAt(i++));
        }
        char c;
        int codePoint;
        for (; i < n.length(); i++) {
            c = n.charAt(i);
            codePoint = c - '0';
            if ((x < codePoint && isNegative) || (x > codePoint && !isNegative)) {
                stb.append(x);
                stb.append(n, i, n.length());
                return stb.toString();
            } else {
                stb.append(c);
            }
        }
        stb.append(x);
        return stb.toString();
    }
}
