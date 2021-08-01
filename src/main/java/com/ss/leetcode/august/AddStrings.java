package com.ss.leetcode.august;

public class AddStrings {
    // https://leetcode.com/problems/add-strings/
    public String addStrings(String num1, String num2) {
        String min = (num1.length() < num2.length() ? num1 : num2);
        String max = min == num1 ? num2  : num1;
        StringBuilder stb = new StringBuilder(max.length() + 1);
        char carriedOver = 0;
        int tmp = 0;
        for (int i = min.length() -1, j = max.length() -1; i >= 0; j--, i--) {
            tmp = min.charAt(i) + max.charAt(j) + carriedOver;
            if (tmp > 105) {
                carriedOver = 1;
                tmp -= 10;
            } else {
                carriedOver = 0;
            }
            stb.append((char) (tmp - 96 + 48));
        }
        for (int i = max.length() - min.length() -1; i >= 0; i--) {
            tmp = max.charAt(i) + carriedOver;
            if (tmp > 57) {
                carriedOver = 1;
                tmp = 48;
            } else {
                carriedOver = 0;
            }
            stb.append((char) tmp);
        }
        if (carriedOver == 1) {
            stb.append('1');
        }
        return stb.reverse().toString();
    }
}
