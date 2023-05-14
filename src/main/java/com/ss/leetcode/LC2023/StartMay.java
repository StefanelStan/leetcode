package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.may.CheckIfArrayPairsAreDivisibleByK;
import com.ss.leetcode.LC2023.may.ContainsDuplicateIII;
import com.ss.leetcode.LC2023.may.CountWaysToBuildGoodStrings;
import com.ss.leetcode.LC2023.may.DiagonalTraverse;
import com.ss.leetcode.LC2023.may.EqualRowAndColumnPairs;
import com.ss.leetcode.LC2023.may.FindThePrefixCommonArrayOfTwoArrays;
import com.ss.leetcode.LC2023.may.FindTheWidthOfColumnsOfAGrid;
import com.ss.leetcode.LC2023.may.KItemsWithTheMaximumSum;
import com.ss.leetcode.LC2023.may.MajorityElementII;
import com.ss.leetcode.LC2023.may.MatrixBlockSum;
import com.ss.leetcode.LC2023.may.MaximizeScoreAfterNOperations;
import com.ss.leetcode.LC2023.may.MaximumGap;
import com.ss.leetcode.LC2023.may.MaximumSumOfTwoNonOverlappingSubarrays;
import com.ss.leetcode.LC2023.may.MaximumSumWithExactlyKElements;
import com.ss.leetcode.LC2023.may.MinimumSizeSubarraySum;
import com.ss.leetcode.LC2023.may.NumberOfEvenAndOddBits;
import com.ss.leetcode.LC2023.may.PrimeInDiagonal;
import com.ss.leetcode.LC2023.may.RemoveColoredPiecesIfBothNeighborsAreTheSameColor;
import com.ss.leetcode.LC2023.may.SumMultiples;
import java.util.Arrays;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();

//        start.matrixBlockSum();
//        start.removeColoredPiecesIfBothNeighborsAreTheSameColor();
//        start.containsDuplicateIII();
//        start.maximumGap();
//        start.minimumSizeSubarraySum();
//        start.majorityElementII();
//        start.findTheWidthOfColumnsOfAGrid();
//        start.findThePrefixCommonArrayOfTwoArrays();
//        start.maximumSumWithExactlyKElements();
//        start.sumMultiples();
//        start.kItemsWithTheMaximumSum();
//        start.checkIfArrayPairsAreDivisibleByK();
//        start.maximumSumOfTwoNonOverlappingSubarrays();
//        start.numberOfEvenAndOddBits();
//        start.primeInDiagonal();
//        start.countWaysToBuildGoodStrings();
//        start.maximizeScoreAfterNOperations();
//        start.equalRowAndColumnPairs();
        start.diagonalTraverse();
    }

    public void matrixBlockSum() {
        MatrixBlockSum mbs = new MatrixBlockSum();

        System.out.println("[[12,21,16],[27,45,33],[24,39,28]] == " + Arrays.deepToString(mbs.matrixBlockSum(
            new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 1)));

        System.out.println("[[45,45,45],[45,45,45],[45,45,45]] == " + Arrays.deepToString(mbs.matrixBlockSum(
            new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 2)));
    }

    public void removeColoredPiecesIfBothNeighborsAreTheSameColor() {
        RemoveColoredPiecesIfBothNeighborsAreTheSameColor rcpibnatsc = new RemoveColoredPiecesIfBothNeighborsAreTheSameColor();

        System.out.println("true == " + rcpibnatsc.winnerOfGame("AAABABB"));
        System.out.println("false == " + rcpibnatsc.winnerOfGame("AA"));
        System.out.println("false == " + rcpibnatsc.winnerOfGame("ABBBBBBBAAA"));
        System.out.println("false == " + rcpibnatsc.winnerOfGame("AAAABBBB"));
    }

    public void containsDuplicateIII() {
        ContainsDuplicateIII cdiii = new ContainsDuplicateIII();

        System.out.println("true == " + cdiii.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
        System.out.println("false == " + cdiii.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
        System.out.println("false == " + cdiii.containsNearbyAlmostDuplicate(new int[]{-3, 3}, 2, 4));
    }

    public void maximumGap() {
        MaximumGap mg = new MaximumGap();

        System.out.println("3 == " + mg.maximumGap(new int[]{3,6,9,1}));
        System.out.println("0 == " + mg.maximumGap(new int[]{10}));
    }

    public void minimumSizeSubarraySum() {
        MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();

        System.out.println("2 == " + msss.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println("1 == " + msss.minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println("0 == " + msss.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }

    public void majorityElementII() {
        MajorityElementII meii = new MajorityElementII();

        System.out.println("[3] == " + meii.majorityElement(new int[]{3,2,3}));
        System.out.println("[1] == " + meii.majorityElement(new int[]{1}));
        System.out.println("[1,2] == " + meii.majorityElement(new int[]{1,2}));
        System.out.println("[1] == " + meii.majorityElement(new int[]{1,1}));
    }

    public void findTheWidthOfColumnsOfAGrid() {
        FindTheWidthOfColumnsOfAGrid ftwocoag = new FindTheWidthOfColumnsOfAGrid();

        System.out.println("[3] == " + Arrays.toString(ftwocoag.findColumnWidth(new int[][]{{1},{22},{333}})));
        System.out.println("[3,1,2] == " + Arrays.toString(ftwocoag.findColumnWidth(new int[][]{{-15,1,3},{15,7,12},{5,6,-2}})));
    }

    public void findThePrefixCommonArrayOfTwoArrays() {
        FindThePrefixCommonArrayOfTwoArrays ftpcaota = new FindThePrefixCommonArrayOfTwoArrays();

        System.out.println("[0,2,3,4] == " + Arrays.toString(ftpcaota.findThePrefixCommonArray(new int[]{1,3,2,4}, new int[]{3,1,2,4})));
        System.out.println("[0,1,3] == " + Arrays.toString(ftpcaota.findThePrefixCommonArray(new int[]{2,3,1}, new int[]{3,1,2})));
    }

    public void maximumSumWithExactlyKElements() {
        MaximumSumWithExactlyKElements msweke = new MaximumSumWithExactlyKElements();

        System.out.println("18 == " + msweke.maximizeSum(new int[]{2,4,5,1,3}, 3));
        System.out.println("11 == " + msweke.maximizeSum(new int[]{5,5,5}, 2));
    }

    public void sumMultiples() {
        SumMultiples sm = new SumMultiples();

        System.out.println("21 == " + sm.sumOfMultiples(7));
        System.out.println("40 == " + sm.sumOfMultiples(10));
        System.out.println("342 == " + sm.sumOfMultiples(35));
    }

    public void kItemsWithTheMaximumSum() {
        KItemsWithTheMaximumSum kiwtms = new KItemsWithTheMaximumSum();

        System.out.println("2 == " + kiwtms.kItemsWithMaximumSum(3, 2, 0, 2));
        System.out.println("3 == " + kiwtms.kItemsWithMaximumSum(3, 2, 0, 4));
    }

    public void checkIfArrayPairsAreDivisibleByK() {
        CheckIfArrayPairsAreDivisibleByK ciapadbk = new CheckIfArrayPairsAreDivisibleByK();

        System.out.println("true == " + ciapadbk.canArrange(new int[]{1,2,3,4,5,10,6,7,8,9}, 5));
        System.out.println("true == " + ciapadbk.canArrange(new int[]{1,2,3,4,5,6}, 7));
        System.out.println("false == " + ciapadbk.canArrange(new int[]{1,2,3,4,5,6}, 10));
        System.out.println("true == " + ciapadbk.canArrange(new int[]{-1,1,-2,2,-3,3,-4,4}, 3));
        System.out.println("false == " + ciapadbk.canArrange(new int[]{1,2,3,4,5,6,6,6}, 7));
    }

    public void maximumSumOfTwoNonOverlappingSubarrays() {
        MaximumSumOfTwoNonOverlappingSubarrays msotnos = new MaximumSumOfTwoNonOverlappingSubarrays();

        System.out.println("20 == " + msotnos.maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4}, 1, 2));
        System.out.println("29 == " + msotnos.maxSumTwoNoOverlap(new int[]{3,8,1,3,2,1,8,9,0}, 3, 2));
        System.out.println("31 == " + msotnos.maxSumTwoNoOverlap(new int[]{2,1,5,6,0,9,5,0,3,8}, 4, 3));
    }

    public void numberOfEvenAndOddBits() {
        NumberOfEvenAndOddBits noeaob = new NumberOfEvenAndOddBits();

        System.out.println("[2,0] == " + Arrays.toString(noeaob.evenOddBit(17)));
        System.out.println("[0,1] == " + Arrays.toString(noeaob.evenOddBit(2)));
    }

    public void primeInDiagonal() {
        PrimeInDiagonal pid = new PrimeInDiagonal();

        System.out.println("11 == " + pid.diagonalPrime(new int[][]{{1,2,3},{5,6,7},{9,10,11}}));
        System.out.println("17 == " + pid.diagonalPrime(new int[][]{{1,2,3},{5,17,7},{9,10,11}}));
    }

    public void countWaysToBuildGoodStrings() {
        CountWaysToBuildGoodStrings cwtbgs = new CountWaysToBuildGoodStrings();

        System.out.println("8 == " + cwtbgs.countGoodStrings(3,3,1,1));
        System.out.println("5 == " + cwtbgs.countGoodStrings(2,3,1,2));
        System.out.println("628681342 == " + cwtbgs.countGoodStrings(123,214,4,11));
    }

    public void maximizeScoreAfterNOperations() {
        MaximizeScoreAfterNOperations msano = new MaximizeScoreAfterNOperations();

        System.out.println("1 == " + msano.maxScore(new int[]{1,2}));
        System.out.println("11 == " + msano.maxScore(new int[]{3,4,6,8}));
        System.out.println("14 == " + msano.maxScore(new int[]{1,2,3,4,5,6}));
        System.out.println("162 == " + msano.maxScore(new int[]{1,2,8,3,2,5,6,7,3,2,5,6,7,8}));
        System.out.println("162 == " + msano.maxScore(new int[]{1,2,8,3,2,5,6,7,3,2,5,6,7,8}));
        System.out.println("97 == " + msano.maxScore(new int[]{12,13,14,32,12,14,23,54}));
        System.out.println("484 == " + msano.maxScore(new int[]{12,13,14,32,12,14,23,54,34,13,45,66,88,81}));
        System.out.println("91 == " + msano.maxScore(new int[]{9,17,16,15,18,13,18,20}));
    }

    public void equalRowAndColumnPairs() {
        EqualRowAndColumnPairs eracp = new EqualRowAndColumnPairs();

        System.out.println("1 == " +eracp.equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
        System.out.println("3 == " +eracp.equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
        System.out.println("3 == " +eracp.equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
        System.out.println("4 == " +eracp.equalPairs(new int[][]{{1,1},{1,1}}));
        System.out.println("0 == " +eracp.equalPairs(new int[][]{{2,1},{3,32}}));
    }

    public void diagonalTraverse() {
        DiagonalTraverse dt = new DiagonalTraverse();

        System.out.println("[1,2,4,7,5,3,6,8,9] == " + Arrays.toString(dt.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
        System.out.println("[1,2,3,4] == " + Arrays.toString(dt.findDiagonalOrder(new int[][]{{1,2},{3,4}})));
    }
}
