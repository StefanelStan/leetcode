package com.ss.leetcode.LC2021.april;

public class ReverseString {
    public void reverseString(char[] s) {
        char temp;
        for (int end = s.length -1, start = 0; start <= end; start++, end--) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
        }
    }
}
