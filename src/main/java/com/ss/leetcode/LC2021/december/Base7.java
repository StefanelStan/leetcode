package com.ss.leetcode.LC2021.december;

import java.util.StringJoiner;

public class Base7 {
    // https://leetcode.com/problems/base-7/
    private static int[] sevenPower;
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        setSevenPower();
        StringBuilder stb = new StringBuilder();
        int absNum = Math.abs(num);
        int division;
        int powIndex = 9;
        while(absNum > 0) {
            while(absNum < sevenPower[powIndex]) {
                powIndex--;
                if(stb.length() > 0) {
                    stb.append('0');
                }
            }
            division = absNum / sevenPower[powIndex];
            stb.append(division);
            absNum -= division * sevenPower[powIndex--];
        }
        if (absNum == 0 && powIndex >= 0) {
            stb.append("0".repeat(powIndex +1));
        }
        return num < 0 ? "-" + stb : stb.toString();
    }

    private void setSevenPower() {
        if (sevenPower == null) {
            sevenPower = new int[10];
            sevenPower[0] = 1;
            for (int i = 1; i < sevenPower.length; i++) {
                sevenPower[i] = sevenPower[i-1] * 7;
            }
        }
    }
}
