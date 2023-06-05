package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.june.CountArtifactsThatCanBeExtracted;
import com.ss.leetcode.LC2023.june.MinimizeResultByAddingParenthesesToExpression;
import com.ss.leetcode.LC2023.june.NumberOfSeniorCitizens;
import com.ss.leetcode.LC2023.june.RemoveTrailingZerosFromAString;
import com.ss.leetcode.LC2023.june.ShortestPathInBinaryMatrix;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

//        start.shortestPathInBinaryMatrix();
//        start.numberOfSeniorCitizens();
//        start.removeTrailingZerosFromAString();
//        start.minimizeResultByAddingParenthesesToExpression();
        start.countArtifactsThatCanBeExtracted();
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

    public void minimizeResultByAddingParenthesesToExpression() {
        MinimizeResultByAddingParenthesesToExpression mrbapte = new MinimizeResultByAddingParenthesesToExpression();

        System.out.println("2(47+38) == " + mrbapte.minimizeResult("247+38"));
        System.out.println("1(2+3)4 == " + mrbapte.minimizeResult("12+34"));
        System.out.println("(999+999) == " + mrbapte.minimizeResult("999+999"));
        System.out.println("(9999+99999) == " + mrbapte.minimizeResult("9999+99999"));
    }

    public void countArtifactsThatCanBeExtracted() {
        CountArtifactsThatCanBeExtracted catcbe = new CountArtifactsThatCanBeExtracted();

        System.out.println("1 == " + catcbe.digArtifacts(2, new int[][]{{0,0,0,0}, {0,1,1,1}}, new int[][]{{0,0},{0,1}}));
        System.out.println("2 == " + catcbe.digArtifacts(2, new int[][]{{0,0,0,0}, {0,1,1,1}}, new int[][]{{0,0},{0,1},{1,1}}));
        System.out.println("0 == " + catcbe.digArtifacts(2, new int[][]{{0,0,0,0}, {0,1,1,1}}, new int[][]{{1,0}}));
    }
}
