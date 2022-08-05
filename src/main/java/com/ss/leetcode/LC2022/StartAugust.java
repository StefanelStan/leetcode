package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.august.MakeArrayZeroBySubtractingEqualAmounts;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

        start.makeArrayZeroBySubtractingEqualAmounts();
    }

    public void makeArrayZeroBySubtractingEqualAmounts() {
        MakeArrayZeroBySubtractingEqualAmounts mazbsea = new MakeArrayZeroBySubtractingEqualAmounts();

        System.out.println("3 == " + mazbsea.minimumOperations(new int[]{1,5,0,3,5}));
        System.out.println("0 == " + mazbsea.minimumOperations(new int[]{0}));
        System.out.println("5 == " + mazbsea.minimumOperations(new int[]{7,1,5,0,3,5,6}));
    }
}
