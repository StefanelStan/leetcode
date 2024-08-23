package com.ss.leetcode.LC2024.august;

public class FractionAdditionAndSubtraction {
    // https://leetcode.com/problems/fraction-addition-and-subtraction
    /** Algorithm
        1. Pull current fraction, next Operation and Next Fraction
        2. Bring current and next fraction denominators to same multiplier by finding out GCD. (EG: x/5 + y/2 => 2x/10 + 5y/10)
        3. Apply the operation between the two fractions.
        4. Fetch next fraction and apply steps 2 and 3.
        5. Return the result (If result is 0/x you must make it 0/1)
     */
    public String fractionAddition(String expression) {
        int[] index = {0};
        Fraction current = getNextFraction(expression, index);
        Fraction next;
        while(index[0] < expression.length()) {
            char operation = expression.charAt(index[0]);
            index[0]++;
            next = getNextFraction(expression, index);
            applyOperation(current, next, operation);
        }
        if (current.numerator == 0) {
            return "0/1";
        } else {
            int gcd = getGCD(Math.abs(current.numerator), Math.abs(current.denominator));
            return (current.numerator/gcd) + "/" + (current.denominator/gcd);
        }
    }

    private Fraction getNextFraction(String expression, int[] index) {
        int numerator = 0, denominator = 0;
        int positiveMultiplier = 1;
        boolean metSlash = false;
        char ch;
        while(index[0] < expression.length()) {
            ch = expression.charAt(index[0]);
            if (ch == '/') {
                metSlash = true;
            } else if ((ch == '+' || ch == '-') && metSlash) {
                break;
            } else if (ch == '-') {
                positiveMultiplier = -1;
            } else {
                if (!metSlash) {
                    numerator = numerator * 10 + (ch - '0');
                } else {
                    denominator = denominator * 10 + (ch - '0');
                }
            }
            index[0]++;
        }
        numerator *= positiveMultiplier;
        return new Fraction(numerator, denominator);
    }

    private void applyOperation(Fraction left, Fraction right, char operation) {
        int gcd = getGCD(left.denominator, right.denominator);
        raiseFactionsToSameDenominator(left, right, gcd);
        if (operation == '+') {
            left.numerator += right.numerator;
        } else {
            left.numerator -= right.numerator;
        }
    }

    private void raiseFactionsToSameDenominator(Fraction left, Fraction right, int gcd) {
        if (gcd == 1) {
            int leftDenominator = left.denominator;
            left.numerator *= right.denominator;
            left.denominator *= right.denominator;
            right.numerator *= leftDenominator;
            right.denominator *= leftDenominator;
        } else {
            int maxMultiplier = Math.max(left.denominator, right.denominator) / gcd;
            int minMultiplier =  Math.min(left.denominator, right.denominator) / gcd;
            int leftMultiplier = left.denominator == Math.max(left.denominator, right.denominator) ? minMultiplier : maxMultiplier;
            int rightMultiplier = leftMultiplier == maxMultiplier ? minMultiplier : maxMultiplier;
            left.numerator *= leftMultiplier;
            left.denominator *= leftMultiplier;
            right.numerator *= rightMultiplier;
            right.denominator *= rightMultiplier;
        }
    }

    private int getGCD(int num1, int num2) {
        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);
        if (max % min == 0) {
            return min;
        }
        int half = min / 2;
        while(half > 1) {
            if (max % half == 0 && min % half == 0) {
                return half;
            }
            half--;
        }
        return 1;
    }

    private static class Fraction {
        int numerator;
        int denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }
}
