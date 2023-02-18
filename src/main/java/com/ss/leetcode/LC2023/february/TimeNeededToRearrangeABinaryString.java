package com.ss.leetcode.LC2023.february;

public class TimeNeededToRearrangeABinaryString {
    // https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string
    /** Algorithm
        1. While there are replaces to be made, traverse the char[] chars of String from 0 to n and replace all 01 with 10.
            After each loop, if change has been made, increment the steps, break otherwise
        2. Return the number of steps.
     */
    public int secondsToRemoveOccurrences(String s) {
        char[] chrs = s.toCharArray();
        boolean swapped = true;
        int steps = 0;
        while(swapped) {
            swapped = false;
            for (int i = 0; i < s.length() - 1; i++) {
                if (chrs[i] == '0' && chrs[i+1] == '1') {
                    chrs[i] = '1';
                    chrs[i+1] = '0';
                    i++;
                    swapped = true;
                }
            }
            if(swapped) {
                steps++;
            }
        }
        return steps;
    }
}
