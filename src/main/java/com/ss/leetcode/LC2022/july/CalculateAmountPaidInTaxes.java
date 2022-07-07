package com.ss.leetcode.LC2022.july;

public class CalculateAmountPaidInTaxes {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0;
        int taxableAmount = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (income > brackets[i][0]) {
                taxableAmount = i == 0 ? brackets[i][0] : brackets[i][0] - brackets[i-1][0];
                tax += (double)(taxableAmount * brackets[i][1]) / 100;
            } else {
                taxableAmount = i == 0 ? income : income - brackets[i-1][0];
                tax += (double)(taxableAmount * brackets[i][1]) / 100;
                break;
            }
        }
        return tax;
    }
}
