package com.ss.leetcode.LC2022.december;

public class SecondLargestDigitInAString {
    // https://leetcode.com/problems/second-largest-digit-in-a-string
    /** Algorithm
         1. Use two ints: largest and secondLargest, both set as -1;
         2. For each character of s, if it's a digit
            - if digit > largest, set secondLargest = largest and largest = digit.
            - else if digit > secondLargest and != largest (it wants unique digits) set secondLargest = digit.
         3. Return secondLargest.
     */
    public int secondHighest(String s) {
        int largest = -1;
        int secondLargest = -1;
        int digitVal;
        for (char ch : s.toCharArray()) {
            if (ch < 'a') {
                digitVal = ch - '0';
                if (digitVal > largest) {
                    secondLargest = largest;
                    largest = digitVal;
                } else if (digitVal > secondLargest && digitVal != largest) {
                    secondLargest = digitVal;
                }
            }
        }
        return secondLargest;
    }
}
