package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.april.CountOddNumbersInAnIntervalRange;
import com.ss.leetcode.LC2022.april.FindTriangularSumOfAnArray;
import com.ss.leetcode.LC2022.april.FindUniqueBinaryString;
import com.ss.leetcode.LC2022.april.MinimumBitFlipsToConvertNumber;
import com.ss.leetcode.LC2022.april.SumOfScoresOfBuiltStrings;

public class StartApril {
    public static void main(String[] args) {
        StartApril start = new StartApril();

//        start.findUniqueBinaryString();
//        start.minimumBitFlipsToConvertNumber();
//        start.findTriangularSumOfAnArray();
//        start.sumOfScoresOfBuiltStrings();
        start.countOddNumbersInAnIntervalRange();
    }

    public void findUniqueBinaryString() {
        FindUniqueBinaryString fubs = new FindUniqueBinaryString();

        System.out.println("00 == " + fubs.findDifferentBinaryString(new String[]{"01","10"}));
        System.out.println("11 == " + fubs.findDifferentBinaryString(new String[]{"00","01"}));
        System.out.println("000 == " + fubs.findDifferentBinaryString(new String[]{"111","011","001"}));
    }

    public void minimumBitFlipsToConvertNumber() {
        MinimumBitFlipsToConvertNumber mbftcn = new MinimumBitFlipsToConvertNumber();

        System.out.println("3 == " + mbftcn.minBitFlips(10, 7));
        System.out.println("3 == " + mbftcn.minBitFlips(3, 4));
        System.out.println("3 == " + mbftcn.minBitFlips(3, 973299123));
        System.out.println("3 == " + mbftcn.minBitFlips(542122143, 7));
    }

    public void findTriangularSumOfAnArray() {
        FindTriangularSumOfAnArray ftsoaa = new FindTriangularSumOfAnArray();

        System.out.println("8 == " + ftsoaa.triangularSum(new int[]{1,2,3,4,5}));
        System.out.println("4 == " + ftsoaa.triangularSum(new int[]{1,2,3,4,5,4,2,7,5,3,2,8,5,3,2,7,4,3,8,1,5,7,9,3,2,0,1}));
        System.out.println("5 == " + ftsoaa.triangularSum(new int[]{5}));
    }

    public void sumOfScoresOfBuiltStrings() {
        SumOfScoresOfBuiltStrings sosobs = new SumOfScoresOfBuiltStrings();

        System.out.println("9 == " + sosobs.sumScores("babab"));
        System.out.println("14 == " + sosobs.sumScores("azbazbzaz"));
        System.out.println("235 == " + sosobs.sumScores("nskmiwknpiclnptttlihicvixtqyxzdyrkulgqpfeckxssnlekuxiwvmxhyfzspt"
            + "cjdqxvuavtakihlizitoozcnnubaafdsadfrvxnadgfshkpfqpcfrtcjsydkjbaupsflzgyumyggutzjcicbqmeghncnsgjkwqwksyahx"
            + "sykyjnqvofkmpxmeaqqhtddflkwvpbpqzkxzyzkdcrctmopmiipaewlw"));
        System.out.println("18 == " + sosobs.sumScores("hhzjhhzjsoiz"));
    }

    public void countOddNumbersInAnIntervalRange() {
        CountOddNumbersInAnIntervalRange coniair = new CountOddNumbersInAnIntervalRange();

        System.out.println("3 == " + coniair.countOdds(3,7));
        System.out.println("1 == " + coniair.countOdds(8,10));
    }
}
