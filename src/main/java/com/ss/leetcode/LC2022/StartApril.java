package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.april.FindUniqueBinaryString;

public class StartApril {
    public static void main(String[] args) {
        StartApril start = new StartApril();

        start.findUniqueBinaryString();
    }

    public void findUniqueBinaryString() {
        FindUniqueBinaryString fubs = new FindUniqueBinaryString();

        System.out.println("00 == " + fubs.findDifferentBinaryString(new String[]{"01","10"}));
        System.out.println("11 == " + fubs.findDifferentBinaryString(new String[]{"00","01"}));
        System.out.println("000 == " + fubs.findDifferentBinaryString(new String[]{"111","011","001"}));
    }
}
