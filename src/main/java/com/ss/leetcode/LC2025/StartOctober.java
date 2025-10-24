package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.october.CheckIfDigitsAreEqualInStringAfterOperationsI;
import com.ss.leetcode.LC2025.october.NextGreaterNumericallyBalancedNumber;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start = new StartOctober();

//        start.checkIfDigitsAreEqualInStringAfterOperationsI();
        start.nextGreaterNumericallyBalancedNumber();
    }

    public void checkIfDigitsAreEqualInStringAfterOperationsI() {
        CheckIfDigitsAreEqualInStringAfterOperationsI cidaeisaoi = new CheckIfDigitsAreEqualInStringAfterOperationsI();

        System.out.println("true == " + cidaeisaoi.hasSameDigits("3902"));
        System.out.println("false == " + cidaeisaoi.hasSameDigits("34789"));
        System.out.println("false == " + cidaeisaoi.hasSameDigits("04723047243159859345683459358734985"));
        System.out.println("true == " + cidaeisaoi.hasSameDigits("00000"));
        System.out.println("false == " + cidaeisaoi.hasSameDigits("2402143590873285923754"));
        System.out.println("true == " + cidaeisaoi.hasSameDigits("111"));
    }

    public void nextGreaterNumericallyBalancedNumber() {
        NextGreaterNumericallyBalancedNumber ngnbn = new NextGreaterNumericallyBalancedNumber();

        System.out.println("22 = " + ngnbn.nextBeautifulNumber(1));
        System.out.println("1333 = " + ngnbn.nextBeautifulNumber(1000));
        System.out.println("3133 = " + ngnbn.nextBeautifulNumber(3000));
        System.out.println("1224444 = " + ngnbn.nextBeautifulNumber(899000));
    }
}
