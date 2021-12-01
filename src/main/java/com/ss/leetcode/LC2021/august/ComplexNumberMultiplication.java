package com.ss.leetcode.LC2021.august;

public class ComplexNumberMultiplication {
    // https://leetcode.com/problems/complex-number-multiplication/
    public String complexNumberMultiply(String num1, String num2) {
        int[] nr1 = getComplexNumber(num1);
        int[] nr2 = getComplexNumber(num2);
        int[] result = multiply(nr1, nr2);
        return String.format("%s+%si", result[0], result[1]);
    }

    private int[] getComplexNumber(String num) {
        int[] nr = new int[2];
        int index1 = num.indexOf('+');
        nr[0] = Integer.parseInt(num.substring(0, index1));
        nr[1] = Integer.parseInt(num.substring(index1 + 1, num.length() -1));
        return nr;
    }

    private int[] multiply(int[] nr1, int[] nr2) {
        int[] result = new int[2];
        result[0] = nr1[0] * nr2[0] + (-1) * (nr1[1] * nr2[1]);
        result[1] = nr2[0] * nr1[1] + nr1[0] * nr2[1];
        return result;
    }


}
