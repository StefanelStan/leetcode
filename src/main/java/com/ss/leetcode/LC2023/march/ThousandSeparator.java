package com.ss.leetcode.LC2023.march;

public class ThousandSeparator {
    // https://leetcode.com/problems/thousand-separator
    /** Algorithm
        1. Quick return: if n < 1000, return string value of it.
        2. While n > 10, append n % 10 to the stringBuilder and increment the group count.
            Every 3 chrs, if n is greater than 9, also append a dot .
            n needs to be greater than 9, if not, the edge case 123123 will result in .123.123
        3. Return the reverse of stringbuilder.
     */
    public String thousandSeparator(int n) {
        if (n < 1000) {
            return String.valueOf(n);
        }
        StringBuilder stb = new StringBuilder();
        int group = 0;
        while(n > 0) {
            stb.append(n % 10);
            group++;
            if (group == 3 && n > 9) {
                stb.append('.');
                group = 0;
            }
            n = n / 10;
        }
        return stb.reverse().toString();
    }
}
