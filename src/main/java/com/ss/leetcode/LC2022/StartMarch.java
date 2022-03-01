package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.march.CountOperationsToObtainZero;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();

        start.countOperationsToObtainZero();
    }

    public void countOperationsToObtainZero() {
        CountOperationsToObtainZero cotoz = new CountOperationsToObtainZero();

        System.out.println("3 == " + cotoz.countOperations(2, 3));
        System.out.println("1 == " + cotoz.countOperations(10, 10));
    }
}
