package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.august.CountVowelsPermutation;
import com.ss.leetcode.LC2022.august.LongestIncreasingSubsequence;
import com.ss.leetcode.LC2022.august.MakeArrayZeroBySubtractingEqualAmounts;
import com.ss.leetcode.LC2022.august.NumberOfArithmeticTriplets;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

//        start.makeArrayZeroBySubtractingEqualAmounts();
//        start.countVowelsPermutation();
//        start.longestIncreasingSubsequence();
        start.numberOfArithmeticTriplets();
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

    public void longestIncreasingSubsequence() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

        System.out.println("4 == " + lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println("4 == " + lis.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println("1 == " + lis.lengthOfLIS(new int[]{7}));
        System.out.println("4 == " + lis.lengthOfLIS(new int[]{3,2,1,1,1,1,2,3,4,4,4,4,3,2,1,2,3}));
        System.out.println("9 == " + lis.lengthOfLIS(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println("1 == " + lis.lengthOfLIS(new int[]{9,8,7,6,5,4,3,2,1}));
    }

    public void numberOfArithmeticTriplets() {
        NumberOfArithmeticTriplets noat = new NumberOfArithmeticTriplets();

        System.out.println("2 == " + noat.arithmeticTriplets(new int[]{0,1,4,6,7,10}, 3));
        System.out.println("2 == " + noat.arithmeticTriplets(new int[]{4,5,6,7,8,9}, 2));
        System.out.println("7 == " + noat.arithmeticTriplets(new int[]{1,2,3,4,5,6,7,8,9}, 1));
        System.out.println("1 == " + noat.arithmeticTriplets(new int[]{2,4,6}, 2));
        System.out.println("0 == " + noat.arithmeticTriplets(new int[]{2,4,5}, 2));
    }
}
