package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.march.MaximumOddBinaryNumber;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();

        start.maximumOddBinaryNumber();
    }

    public void maximumOddBinaryNumber() {
        MaximumOddBinaryNumber mobn = new MaximumOddBinaryNumber();

        System.out.println("001 == " + mobn.maximumOddBinaryNumber("010"));
        System.out.println("1001 == " + mobn.maximumOddBinaryNumber("0101"));
        System.out.println("1 == " + mobn.maximumOddBinaryNumber("1"));
        System.out.println("01 == " + mobn.maximumOddBinaryNumber("01"));
    }
}
