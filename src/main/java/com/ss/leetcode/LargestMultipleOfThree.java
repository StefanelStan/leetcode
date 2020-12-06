package com.ss.leetcode;

import java.util.Arrays;

public class LargestMultipleOfThree {
    // https://leetcode.com/problems/largest-multiple-of-three/

    public String largestMultipleOfThree(int[] digits) {
        if (digits.length <3 ) {
            return "";
        }
        Arrays.sort(digits);
        int sum = 0;
        int index = digits.length -1;
        while(index >= 0 && digits[index] != 0){
            sum += digits[index];
            index--;
        }
        if (sum % 3 == 0) {
            return getStringValueOf(digits, Math.max(index +1, 0), digits.length-1);
        }
        return "0";
    }

    private String getStringValueOf(int[] digits, int front, int back) {
        StringBuilder stb = new StringBuilder();
        for (int i = back; i >= front; i--) {
            stb.append(digits[i]);
        }
        return stb.toString();
    }
}
