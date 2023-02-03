package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.february.CountDistinctNumbersOnBoard;
import com.ss.leetcode.LC2023.february.NumberOfDaysBetweenTwoDates;
import com.ss.leetcode.LC2023.february.TupleWithSameProduct;
import com.ss.leetcode.LC2023.february.UniqueLength3PalindromicSubsequences;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

//        start.numberOfDaysBetweenTwoDates();
//        start.uniqueLength3PalindromicSubsequences();
//        start.countDistinctNumbersOnBoard();
        start.tupleWithSameProduct();
    }

    public void numberOfDaysBetweenTwoDates() {
        NumberOfDaysBetweenTwoDates nodbtd = new NumberOfDaysBetweenTwoDates();

        System.out.println("1 == " + nodbtd.daysBetweenDates("2019-06-29", "2019-06-30"));
        System.out.println("15 == " + nodbtd.daysBetweenDates("2020-01-15", "2019-12-31"));
        System.out.println("5 == " + nodbtd.daysBetweenDates("2004-02-25", "2004-03-01"));
        System.out.println("35068 == " + nodbtd.daysBetweenDates("2004-02-25", "2100-03-01"));
    }

    public void uniqueLength3PalindromicSubsequences() {
        UniqueLength3PalindromicSubsequences ul3ps = new UniqueLength3PalindromicSubsequences();

        System.out.println("3 == " + ul3ps.countPalindromicSubsequence("aabca"));
        System.out.println("0 == " + ul3ps.countPalindromicSubsequence("adc"));
        System.out.println("4 == " + ul3ps.countPalindromicSubsequence("bbcbaba"));
    }

    public void countDistinctNumbersOnBoard() {
        CountDistinctNumbersOnBoard cdnob = new CountDistinctNumbersOnBoard();

        System.out.println("4 == " + cdnob.distinctIntegers(5));
        System.out.println("2 == " + cdnob.distinctIntegers(3));
    }

    public void tupleWithSameProduct() {
        TupleWithSameProduct twsp = new TupleWithSameProduct();

        System.out.println("8 == " + twsp.tupleSameProduct(new int[]{2,3,4,6}));
        System.out.println("16 == " + twsp.tupleSameProduct(new int[]{1,2,4,5,10}));
        System.out.println("536 == " + twsp.tupleSameProduct(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}));
        System.out.println("0 == " + twsp.tupleSameProduct(new int[]{1,2,3,4}));
        System.out.println("40 == " + twsp.tupleSameProduct(new int[]{2,12,1,24,4,6}));
    }
}
