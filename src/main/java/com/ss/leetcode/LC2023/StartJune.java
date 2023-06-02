package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.june.NumberOfSeniorCitizens;
import com.ss.leetcode.LC2023.june.RemoveTrailingZerosFromAString;
import com.ss.leetcode.LC2023.june.ShortestPathInBinaryMatrix;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

//        start.shortestPathInBinaryMatrix();
//        start.numberOfSeniorCitizens();
        start.removeTrailingZerosFromAString();
    }

    public void shortestPathInBinaryMatrix() {
        ShortestPathInBinaryMatrix spibm = new ShortestPathInBinaryMatrix();

        System.out.println("2 == " + spibm.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        System.out.println("4 == " + spibm.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
        System.out.println("-1 == " + spibm.shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
    }

    public void numberOfSeniorCitizens() {
        NumberOfSeniorCitizens nosc = new NumberOfSeniorCitizens();

        System.out.println("2 == " + nosc.countSeniors(new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"}));
        System.out.println("0 == " + nosc.countSeniors(new String[]{"1313579440F2036","2921522980M5644"}));
    }

    public void removeTrailingZerosFromAString() {
        RemoveTrailingZerosFromAString rtzfas = new RemoveTrailingZerosFromAString();

        System.out.println("512301 == " + rtzfas.removeTrailingZeros("51230100"));
        System.out.println("123 == " + rtzfas.removeTrailingZeros("123"));
    }
}
