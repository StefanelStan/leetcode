package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.august.CountVowelsPermutation;
import com.ss.leetcode.LC2022.august.MakeArrayZeroBySubtractingEqualAmounts;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

//        start.makeArrayZeroBySubtractingEqualAmounts();
        start.countVowelsPermutation();
    }

    public void makeArrayZeroBySubtractingEqualAmounts() {
        MakeArrayZeroBySubtractingEqualAmounts mazbsea = new MakeArrayZeroBySubtractingEqualAmounts();

        System.out.println("3 == " + mazbsea.minimumOperations(new int[]{1,5,0,3,5}));
        System.out.println("0 == " + mazbsea.minimumOperations(new int[]{0}));
        System.out.println("5 == " + mazbsea.minimumOperations(new int[]{7,1,5,0,3,5,6}));
    }

    public void countVowelsPermutation() {
        CountVowelsPermutation cvp = new CountVowelsPermutation();

        System.out.println("5 == " + cvp.countVowelPermutation(1));
        System.out.println("10 == " + cvp.countVowelPermutation(2));
        System.out.println("68 == " + cvp.countVowelPermutation(5));
        System.out.println("759959057 == " + cvp.countVowelPermutation(20000));
        System.out.println("377163667 == " + cvp.countVowelPermutation(15682));
        System.out.println("288864303 == " + cvp.countVowelPermutation(4821));
    }
}
