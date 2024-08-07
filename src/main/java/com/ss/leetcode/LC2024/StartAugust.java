package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.august.ClearDigits;
import com.ss.leetcode.LC2024.august.DistributeElementsIntoTwoArraysI;
import com.ss.leetcode.LC2024.august.FindTheMinimumAreaToCoverAllOnesI;
import com.ss.leetcode.LC2024.august.FindTheSumOfEncryptedIntegers;
import com.ss.leetcode.LC2024.august.IntegerToEnglishWords;
import java.util.Arrays;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

//        start.findTheMinimumAreaToCoverAllOnesI();
//        start.distributeElementsIntoTwoArraysI();
//        start.clearDigits();
//        start.findTheSumOfEncryptedIntegers();
        start.integerToEnglishWords();
    }

    public void findTheMinimumAreaToCoverAllOnesI() {
        FindTheMinimumAreaToCoverAllOnesI ftmatcaoi = new FindTheMinimumAreaToCoverAllOnesI();

        System.out.println("6 == " + ftmatcaoi.minimumArea(new int[][]{{0,1,0}, {1,0,1}}));
        System.out.println("1 == " + ftmatcaoi.minimumArea(new int[][]{{1,0}, {0,0}}));
    }

    public void distributeElementsIntoTwoArraysI() {
        DistributeElementsIntoTwoArraysI deitai = new DistributeElementsIntoTwoArraysI();

        System.out.println("[2,3,1] == " + Arrays.toString(deitai.resultArray(new int[]{2,1,3})));
        System.out.println("[5,3,4,8] == " + Arrays.toString(deitai.resultArray(new int[]{5,4,3,8})));
    }

    public void clearDigits() {
        ClearDigits cd = new ClearDigits();

        System.out.println("abc == " + cd.clearDigits("abc"));
        System.out.println(" == " + cd.clearDigits("cb34"));
    }

    public void findTheSumOfEncryptedIntegers() {
        FindTheSumOfEncryptedIntegers ftsoei = new FindTheSumOfEncryptedIntegers();

        System.out.println("6 == " + ftsoei.sumOfEncryptedInt(new int[]{1,2,3}));
        System.out.println("66 == " + ftsoei.sumOfEncryptedInt(new int[]{10,21,33}));
    }

    public void integerToEnglishWords() {
        IntegerToEnglishWords itew = new IntegerToEnglishWords();

        System.out.println("One Hundred Twenty Three == " + itew.numberToWords(123));
        System.out.println("Twelve Thousand Three Hundred Forty Five == " + itew.numberToWords(12345));
        System.out.println("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven == " + itew.numberToWords(1234567));
        System.out.println("Two Billion One Hundred Twelve Million One Hundred Twenty Three Thousand Four Hundred Fifty Four == " + itew.numberToWords(2112123454));
        System.out.println("One Billion One == " + itew.numberToWords(1000000001));
        System.out.println("One Billion One Million One Thousand One == " + itew.numberToWords(1001001001));
        System.out.println("One Hundred Nine == " + itew.numberToWords(109));
    }
}
