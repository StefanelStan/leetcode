package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.may.AllDivisionsWithTheHighestScoreOfABinaryArray;
import com.ss.leetcode.LC2023.may.AppendCharactersToStringToMakeSubsequence;
import com.ss.leetcode.LC2023.may.CheckIfArrayPairsAreDivisibleByK;
import com.ss.leetcode.LC2023.may.ContainsDuplicateIII;
import com.ss.leetcode.LC2023.may.CountTheNumberOfCompleteComponents;
import com.ss.leetcode.LC2023.may.CountWaysToBuildGoodStrings;
import com.ss.leetcode.LC2023.may.DetonateTheMaximumBombs;
import com.ss.leetcode.LC2023.may.DiagonalTraverse;
import com.ss.leetcode.LC2023.may.EqualRowAndColumnPairs;
import com.ss.leetcode.LC2023.may.FindTheDistinctDifferenceArray;
import com.ss.leetcode.LC2023.may.FindThePrefixCommonArrayOfTwoArrays;
import com.ss.leetcode.LC2023.may.FindTheWidthOfColumnsOfAGrid;
import com.ss.leetcode.LC2023.may.IsGraphBipartite;
import com.ss.leetcode.LC2023.may.KItemsWithTheMaximumSum;
import com.ss.leetcode.LC2023.may.MajorityElementII;
import com.ss.leetcode.LC2023.may.MatrixBlockSum;
import com.ss.leetcode.LC2023.may.MaxSumOfAPairWithEqualSumOfDigits;
import com.ss.leetcode.LC2023.may.MaximizeScoreAfterNOperations;
import com.ss.leetcode.LC2023.may.MaximumGap;
import com.ss.leetcode.LC2023.may.MaximumSubsequenceScore;
import com.ss.leetcode.LC2023.may.MaximumSumOfTwoNonOverlappingSubarrays;
import com.ss.leetcode.LC2023.may.MaximumSumWithExactlyKElements;
import com.ss.leetcode.LC2023.may.MinimumSizeSubarraySum;
import com.ss.leetcode.LC2023.may.NumberOfEvenAndOddBits;
import com.ss.leetcode.LC2023.may.PrimeInDiagonal;
import com.ss.leetcode.LC2023.may.RangeFrequencyQueries;
import com.ss.leetcode.LC2023.may.RemoveColoredPiecesIfBothNeighborsAreTheSameColor;
import com.ss.leetcode.LC2023.may.ShortestBridge;
import com.ss.leetcode.LC2023.may.SpiralMatrixIV;
import com.ss.leetcode.LC2023.may.SumInAMatrix;
import com.ss.leetcode.LC2023.may.SumMultiples;
import com.ss.leetcode.LC2023.may.TheKStrongestValuesInAnArray;
import com.ss.leetcode.shared.ListNode;
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
//        start.diagonalTraverse();
//        start.rangeFrequencyQueries();
//        start.maxSumOfAPairWithEqualSumOfDigits();
//        start.appendCharactersToStringToMakeSubsequence();
//        start.isGraphBipartite();
//        start.findTheDistinctDifferenceArray();
//        start.spiralMatrixIV();
//        start.shortestBridge();
//        start.theKStrongestValuesInAnArray();
//        start.allDivisionsWithTheHighestScoreOfABinaryArray();
//        start.detonateTheMaximumBombs();
//        start.countTheNumberOfCompleteComponents();
//        start.maximumSubsequenceScore();
        start.sumInAMatrix();
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

    public void rangeFrequencyQueries() {
        RangeFrequencyQueries rfq = new RangeFrequencyQueries(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});

        System.out.println("1 == " + rfq.query(1,2,4));
        System.out.println("2 == " + rfq.query(0,11,33));
        System.out.println("2 == " + rfq.query(0,11,33));

        rfq = new RangeFrequencyQueries(new int[]{3,4,5,3,3,2,2,2,5,4});
        System.out.println("2 == " + rfq.query(2,6,3));
        System.out.println("0 == " + rfq.query(5,6,5));
        System.out.println("2 == " + rfq.query(1,6,2));
        System.out.println("1 == " + rfq.query(0,2,3));
        System.out.println("0 == " + rfq.query(5,6,4));
    }

    public void maxSumOfAPairWithEqualSumOfDigits() {
        MaxSumOfAPairWithEqualSumOfDigits msoapwesod = new MaxSumOfAPairWithEqualSumOfDigits();

        System.out.println("54 == " + msoapwesod.maximumSum(new int[]{18,43,36,13,7}));
        System.out.println("-1 == " + msoapwesod.maximumSum(new int[]{10,12,19,14}));
        System.out.println("-1 == " + msoapwesod.maximumSum(new int[]{1}));
        System.out.println("233 == " + msoapwesod.maximumSum(new int[]{18,43,36,13,7,11,12,13,14,15,51,23,32,44,44,76,67,157}));
        System.out.println("155 == " + msoapwesod.maximumSum(new int[]{19,91,55,64}));
    }

    public void appendCharactersToStringToMakeSubsequence() {
        AppendCharactersToStringToMakeSubsequence actstms = new AppendCharactersToStringToMakeSubsequence();

        System.out.println("4 == " + actstms.appendCharacters("coaching", "coding"));
        System.out.println("0 == " + actstms.appendCharacters("abcde", "a"));
        System.out.println("5 == " + actstms.appendCharacters("z", "abcde"));
    }

    public void isGraphBipartite() {
        IsGraphBipartite igb = new IsGraphBipartite();

        System.out.println("false == " + igb.isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
        System.out.println("true == " + igb.isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
    }

    public void findTheDistinctDifferenceArray() {
        FindTheDistinctDifferenceArray ftdda = new FindTheDistinctDifferenceArray();

        System.out.println("[-3,-1,1,3,5] == " + Arrays.toString(ftdda.distinctDifferenceArray(new int[]{1,2,3,4,5})));
        System.out.println("[-2,-1,0,2,3] == " + Arrays.toString(ftdda.distinctDifferenceArray(new int[]{3,2,3,4,2})));
    }

    public void spiralMatrixIV() {
        SpiralMatrixIV smiv = new SpiralMatrixIV();

        ListNode head1 = ListNode.makeChain(new int[]{3,0,2,6,8,1,7,9,4,2,5,5,0});
        ListNode head2 = ListNode.makeChain(new int[]{0,1,2});

        System.out.println("[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]] == " + Arrays.deepToString(smiv.spiralMatrix(3, 5, head1)));
        System.out.println("[[0,1,2,-1]] == " + Arrays.deepToString(smiv.spiralMatrix(1, 4, head2)));
    }

    public void shortestBridge() {
        ShortestBridge sb = new ShortestBridge();

        System.out.println("1 == " + sb.shortestBridge(new int[][]{{0,1},{1,0}}));
        System.out.println("2 == " + sb.shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}}));
        System.out.println("1 == " + sb.shortestBridge(new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}}));
    }

    public void theKStrongestValuesInAnArray() {
        TheKStrongestValuesInAnArray tksviaa = new TheKStrongestValuesInAnArray();

        System.out.println("[5,1] == " + Arrays.toString(tksviaa.getStrongest(new int[]{1,2,3,4,5}, 2)));
        System.out.println("[5,5] == " + Arrays.toString(tksviaa.getStrongest(new int[]{1,1,3,5,5}, 2)));
        System.out.println("[11,8,6,6,7] == " + Arrays.toString(tksviaa.getStrongest(new int[]{6,7,11,7,6,8}, 5)));
    }

    public void allDivisionsWithTheHighestScoreOfABinaryArray() {
        AllDivisionsWithTheHighestScoreOfABinaryArray adwthsoaba = new AllDivisionsWithTheHighestScoreOfABinaryArray();

        System.out.println("[2,4] == " + adwthsoaba.maxScoreIndices(new int[]{0,0,1,0}));
        System.out.println("[3] == " + adwthsoaba.maxScoreIndices(new int[]{0,0,0}));
        System.out.println("[0] == " + adwthsoaba.maxScoreIndices(new int[]{1,1}));
    }

    public void detonateTheMaximumBombs() {
        DetonateTheMaximumBombs dtmb = new DetonateTheMaximumBombs();

        System.out.println("2 == " + dtmb.maximumDetonation(new int[][]{{2,1,3},{6,1,4}}));
        System.out.println("1 == " + dtmb.maximumDetonation(new int[][]{{1,1,5},{10,10,5}}));
        System.out.println("5 == " + dtmb.maximumDetonation(new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}}));
        System.out.println("1 == " + dtmb.maximumDetonation(new int[][]{{54,95,4},{99,46,3},{29,21,3},{96,72,8},{49,43,3},{11,20,3},{2,57,1},{69,51,7},{97,1,10},{85,45,2},{38,47,1},{83,75,3},{65,59,3},{33,4,1},{32,10,2},{20,97,8},{35,37,3}}));
        System.out.println("3 == " + dtmb.maximumDetonation(new int[][]{{7,26,7},{7,18,4},{3,10,7},{17,50,1},{3,25,10},{85,23,8},{80,50,1},{58,74,1},{38,39,7},{50,51,8},{31,99,3},{53,6,5},{59,27,10},{87,78,9},{68,58,3}}));
        System.out.println("9 == " + dtmb.maximumDetonation(new int[][]{{855,82,158},{17,719,430},{90,756,164},{376,17,340},{691,636,152},{565,776,5},{464,154,271},{53,361,162},{278,609,82},{202,927,219},{542,865,377},{330,402,270},{720,199,10},{986,697,443},{471,296,69},{393,81,404},{127,405,177}}));
    }

    public void countTheNumberOfCompleteComponents() {
        CountTheNumberOfCompleteComponents ctnocc = new CountTheNumberOfCompleteComponents();

        System.out.println("3 == " + ctnocc.countCompleteComponents(6, new int[][]{{0,1},{0,2},{1,2},{3,4}}));
        System.out.println("1 == " + ctnocc.countCompleteComponents(6, new int[][]{{0,1},{0,2},{1,2},{3,4},{3,5}}));
    }

    public void maximumSubsequenceScore() {
        MaximumSubsequenceScore mss = new MaximumSubsequenceScore();

        System.out.println("12 == " + mss.maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3));
        System.out.println("30 == " + mss.maxScore(new int[]{4,2,3,1,1}, new int[]{7,5,10,9,6}, 1));
        System.out.println("168 == " + mss.maxScore(new int[]{2,1,14,12}, new int[]{11,7,13,6}, 3));
        System.out.println("216 == " + mss.maxScore(new int[]{2,1,14,12,8,4,1,6,2,7,2}, new int[]{11,7,13,6,1,7,8,2,1,5,9}, 7));
        System.out.println("98 == " + mss.maxScore(new int[]{2,1,14,12,8,4,1,6,2,7,2}, new int[]{11,7,13,6,1,7,8,2,1,5,9}, 9));
    }

    public void sumInAMatrix() {
        SumInAMatrix siam = new SumInAMatrix();

        System.out.println("15 == " + siam.matrixSum(new int[][]{{7,2,1},{6,4,2},{6,5,3},{3,2,1}}));
        System.out.println("1 == " + siam.matrixSum(new int[][]{{1}}));
    }
}
