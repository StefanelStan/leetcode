package com.ss.leetcode.LC2023.february;

public class MaximumValueOfAStringInAnArray {
    // https://leetcode.com/problems/maximum-value-of-a-string-in-an-array
    /** Algorithm
        1. Loop over each string s of chars while using a global maxValue and tempValue;
        2. While traversing string s, if current char >= 'a', set temp = s.length() and break the traversal of s
        3. If current char is digit, multiply temp by 10 and add that digit
        4. At the end of #3 and #4 set maxValue to be the max between temp and maxValue. Reset temp to 0
        5. Return maxValue;
     */
    public int maximumValue(String[] strs) {
        int maxValue = 0;
        int temp;
        for (String s : strs) {
            temp = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 'a') {
                    temp = s.length();
                    break;
                } else {
                    temp = temp * 10 + (s.charAt(i) - '0');
                }
            }
            maxValue = Math.max(maxValue, temp);
        }
        return maxValue;
    }
}
