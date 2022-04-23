package com.ss.leetcode.LC2022.april;

public class CalculateDigitSumOfAString {
    // https://leetcode.com/problems/calculate-digit-sum-of-a-string/
    /** Algorithm
         1. While s is longer than k, try to add its digits into a string builder stb
         2. Loop in windows of k size and continue ONLY if current index  < s.length().
            (meaning current expanding window is still shorter than s.length())
            EG: "123456789", k = 4. window1 : "1,2,3,4", window2 = "5,6,7,8"
         3. In an inner loop, loop with j from i to i+ k; stopping at i + k OR when j reaches s.length() -1
             Add digits to a temp int and add it to string builder
         4. Make s point to the string value of the string builder.
         5. Return s.
     */
    public String digitSum(String s, int k) {
        StringBuilder stb = new StringBuilder();
        int temp = 0;
        while(s.length() > k) {
            stb.setLength(0);
            for(int i = 0; i < s.length(); i += k) {
                temp = 0;
                for(int j = i; j < i + k && j < s.length(); j++) {
                    temp += s.charAt(j) - '0';
                }
                stb.append(temp);
            }
            s = stb.toString();
        }
        return s;
    }
}
