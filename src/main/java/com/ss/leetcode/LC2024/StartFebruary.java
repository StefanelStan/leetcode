package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.february.DivideArrayIntoArraysWithMaxDifference;
import java.util.Arrays;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

        start.divideArrayIntoArraysWithMaxDifference();
    }

    public void divideArrayIntoArraysWithMaxDifference() {
        DivideArrayIntoArraysWithMaxDifference daiawmd = new DivideArrayIntoArraysWithMaxDifference();

        System.out.println("[[1,1,3],[3,4,5],[7,8,9]] == " + Arrays.deepToString(daiawmd.divideArray(new int[]{1,3,4,8,7,9,3,5,1}, 2)));
        System.out.println("[] == " + Arrays.deepToString(daiawmd.divideArray(new int[]{1,3,3,2,7,3}, 3)));
    }
}
