package com.ss.leetcode.LC2021.january;

public class ExcelSheetColumnNumber {
    // https://leetcode.com/problems/excel-sheet-column-number/

    public int titleToNumber(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i) - 64) * (int)Math.pow(26, s.length() -1 - i);
        }
        return sum;
    }
}
