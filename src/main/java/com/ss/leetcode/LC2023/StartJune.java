package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.june.AvoidFloodInTheCity;
import com.ss.leetcode.LC2023.june.CountArtifactsThatCanBeExtracted;
import com.ss.leetcode.LC2023.june.DetermineTheWinnerOfABowlingGame;
import com.ss.leetcode.LC2023.june.DivideArrayInSetsOfKConsecutiveNumbers;
import com.ss.leetcode.LC2023.june.FindKPairsWithSmallestSums;
import com.ss.leetcode.LC2023.june.FrequencyTracker;
import com.ss.leetcode.LC2023.june.KRadiusSubarrayAverages;
import com.ss.leetcode.LC2023.june.LastDayWhereYouCanStillCross;
import com.ss.leetcode.LC2023.june.LexicographicallySmallestPalindrome;
import com.ss.leetcode.LC2023.june.LongestArithmeticSubsequence;
import com.ss.leetcode.LC2023.june.LongestIdealSubsequence;
import com.ss.leetcode.LC2023.june.MaximumNumberOfFishInAGrid;
import com.ss.leetcode.LC2023.june.MaximumNumberOfMovesInAGrid;
import com.ss.leetcode.LC2023.june.MaximumStrengthOfAGroup;
import com.ss.leetcode.LC2023.june.MaximumValueAtAGivenIndexInABoundedArray;
import com.ss.leetcode.LC2023.june.MinimizeResultByAddingParenthesesToExpression;
import com.ss.leetcode.LC2023.june.MinimumCostToMakeArrayEqual;
import com.ss.leetcode.LC2023.june.MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves;
import com.ss.leetcode.LC2023.june.MinimumLengthOfStringAfterDeletingSimilarEnds;
import com.ss.leetcode.LC2023.june.NumberOfSeniorCitizens;
import com.ss.leetcode.LC2023.june.NumberOfSmoothDescentPeriodsOfAStock;
import com.ss.leetcode.LC2023.june.NumberOfSubstringsWithOnly1s;
import com.ss.leetcode.LC2023.june.PathWithMaximumProbability;
import com.ss.leetcode.LC2023.june.RemoveTrailingZerosFromAString;
import com.ss.leetcode.LC2023.june.RemovingMinimumAndMaximumFromArray;
import com.ss.leetcode.LC2023.june.ReorganizeString;
import com.ss.leetcode.LC2023.june.ShortestPathInBinaryMatrix;
import com.ss.leetcode.LC2023.june.SumOfMatrixAfterQueries;
import com.ss.leetcode.LC2023.june.TotalCostToHireKWorkers;
import java.util.Arrays;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

//        start.shortestPathInBinaryMatrix();
//        start.numberOfSeniorCitizens();
//        start.removeTrailingZerosFromAString();
//        start.minimizeResultByAddingParenthesesToExpression();
//        start.countArtifactsThatCanBeExtracted();
//        start.maximumStrengthOfAGroup();
//        start.avoidFloodInTheCity();
//        start.sumOfMatrixAfterQueries();
//        start.maximumNumberOfFishInAGrid();
//        start.maximumValueAtAGivenIndexInABoundedArray();
//        start.frequencyTracker();
//        start.determineTheWinnerOfABowlingGame();
//        start.reorganizeString();
//        start.numberOfSmoothDescentPeriodsOfAStock();
//        start.minimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
//        start.minimumLengthOfStringAfterDeletingSimilarEnds();
//        start.maximumNumberOfMovesInAGrid();
//        start.kRadiusSubarrayAverages();
//        start.minimumCostToMakeArrayEqual();
//        start.longestIdealSubsequence();
//        start.longestArithmeticSubsequence();
//        start.lexicographicallySmallestPalindrome();
//        start.numberOfSubstringsWithOnly1s();
//        start.totalCostToHireKWorkers();
//        start.findKPairsWithSmallestSums();
//        start.pathWithMaximumProbability();
//        start.removingMinimumAndMaximumFromArray();
//        start.divideArrayInSetsOfKConsecutiveNumbers();
        start.lastDayWhereYouCanStillCross();
    }

    public void shortestPathInBinaryMatrix() {
        ShortestPathInBinaryMatrix spibm = new ShortestPathInBinaryMatrix();

        System.out.println("2 == " + spibm.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        System.out.println("4 == " + spibm.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
        System.out.println("-1 == " + spibm.shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
    }

    public void numberOfSeniorCitizens() {
        NumberOfSeniorCitizens nosc = new NumberOfSeniorCitizens();

        System.out.println("2 == " + nosc.countSeniors(new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"}));
        System.out.println("0 == " + nosc.countSeniors(new String[]{"1313579440F2036","2921522980M5644"}));
    }

    public void removeTrailingZerosFromAString() {
        RemoveTrailingZerosFromAString rtzfas = new RemoveTrailingZerosFromAString();

        System.out.println("512301 == " + rtzfas.removeTrailingZeros("51230100"));
        System.out.println("123 == " + rtzfas.removeTrailingZeros("123"));
    }

    public void minimizeResultByAddingParenthesesToExpression() {
        MinimizeResultByAddingParenthesesToExpression mrbapte = new MinimizeResultByAddingParenthesesToExpression();

        System.out.println("2(47+38) == " + mrbapte.minimizeResult("247+38"));
        System.out.println("1(2+3)4 == " + mrbapte.minimizeResult("12+34"));
        System.out.println("(999+999) == " + mrbapte.minimizeResult("999+999"));
        System.out.println("(9999+99999) == " + mrbapte.minimizeResult("9999+99999"));
    }

    public void countArtifactsThatCanBeExtracted() {
        CountArtifactsThatCanBeExtracted catcbe = new CountArtifactsThatCanBeExtracted();

        System.out.println("1 == " + catcbe.digArtifacts(2, new int[][]{{0,0,0,0}, {0,1,1,1}}, new int[][]{{0,0},{0,1}}));
        System.out.println("2 == " + catcbe.digArtifacts(2, new int[][]{{0,0,0,0}, {0,1,1,1}}, new int[][]{{0,0},{0,1},{1,1}}));
        System.out.println("0 == " + catcbe.digArtifacts(2, new int[][]{{0,0,0,0}, {0,1,1,1}}, new int[][]{{1,0}}));
    }

    public void maximumStrengthOfAGroup() {
        MaximumStrengthOfAGroup msoag = new MaximumStrengthOfAGroup();

        System.out.println("1350 == " + msoag.maxStrength(new int[]{3,-1,-5,2,5,-9}));
        System.out.println("20 == " + msoag.maxStrength(new int[]{-4,-5,-4}));
    }

    public void avoidFloodInTheCity() {
        AvoidFloodInTheCity afitc = new AvoidFloodInTheCity();

        System.out.println("[-1,-1,-1,-1] == " + Arrays.toString(afitc.avoidFlood(new int[]{1,2,3,4})));
        System.out.println("[-1,-1,2,1,-1,-1] == " + Arrays.toString(afitc.avoidFlood(new int[]{1,2,0,0,2,1})));
        System.out.println("[] == " + Arrays.toString(afitc.avoidFlood(new int[]{1,2,0,1,2})));
    }

    public void sumOfMatrixAfterQueries() {
        SumOfMatrixAfterQueries somaq = new SumOfMatrixAfterQueries();

        System.out.println("23 == " + somaq.matrixSumQueries(3, new int[][]{{0,0,1},{1,2,2},{0,2,3},{1,0,4}}));
        System.out.println("17 == " + somaq.matrixSumQueries(3, new int[][]{{0,0,4},{0,1,2},{1,0,1},{0,2,3},{1,2,1}}));
    }

    public void maximumNumberOfFishInAGrid() {
        MaximumNumberOfFishInAGrid mnofiag = new MaximumNumberOfFishInAGrid();

        System.out.println("7 == " + mnofiag.findMaxFish(new int[][]{{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}}));
        System.out.println("1 == " + mnofiag.findMaxFish(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,1}}));
    }

    public void maximumValueAtAGivenIndexInABoundedArray() {
        MaximumValueAtAGivenIndexInABoundedArray mvaagiiaba = new MaximumValueAtAGivenIndexInABoundedArray();

        System.out.println("2 == " + mvaagiiaba.maxValue(4, 2, 6));
        System.out.println("3 == " + mvaagiiaba.maxValue(6, 1, 10));
        System.out.println("20 == " + mvaagiiaba.maxValue(4, 2, 76));
        System.out.println("1 == " + mvaagiiaba.maxValue(132, 4, 132));
    }

    public void frequencyTracker() {
        FrequencyTracker ft = new FrequencyTracker();
        ft.add(3);
        ft.add(3);
        System.out.println("true == " + ft.hasFrequency(2));

        ft = new FrequencyTracker();
        ft.add(1);
        ft.deleteOne(1);
        System.out.println("false == " + ft.hasFrequency(1));

        ft = new FrequencyTracker();
        System.out.println("false == " + ft.hasFrequency(2));
        ft.add(3);
        System.out.println("true == " + ft.hasFrequency(1));
    }

    public void determineTheWinnerOfABowlingGame() {
        DetermineTheWinnerOfABowlingGame dtwoabg = new DetermineTheWinnerOfABowlingGame();

        System.out.println("1 == " + dtwoabg.isWinner(new int[]{4,10,7,9}, new int[]{6,5,2,3}));
        System.out.println("2 == " + dtwoabg.isWinner(new int[]{3,5,7,6}, new int[]{8,10,10,2}));
        System.out.println("0 == " + dtwoabg.isWinner(new int[]{2,3}, new int[]{4,1}));
        System.out.println("2 == " + dtwoabg.isWinner(new int[]{2}, new int[]{4}));
    }

    public void reorganizeString() {
        ReorganizeString rs = new ReorganizeString();

        System.out.println("aba == " + rs.reorganizeString("aab"));
        System.out.println(" == " + rs.reorganizeString("aaab"));
        System.out.println(" == " + rs.reorganizeString("ioioioioioioioioiiii"));
        System.out.println(" == " + rs.reorganizeString("aaaaa"));
        System.out.println("a == " + rs.reorganizeString("a"));
        System.out.println("babab == " + rs.reorganizeString("aabbb"));
    }

    public void numberOfSmoothDescentPeriodsOfAStock() {
        NumberOfSmoothDescentPeriodsOfAStock nosdpoas = new NumberOfSmoothDescentPeriodsOfAStock();

        System.out.println("7 == " + nosdpoas.getDescentPeriods(new int[]{3,2,1,4}));
        System.out.println("4 == " + nosdpoas.getDescentPeriods(new int[]{8,6,7,7}));
        System.out.println("1 == " + nosdpoas.getDescentPeriods(new int[]{1}));
    }

    public void minimumDifferenceBetweenLargestAndSmallestValueInThreeMoves() {
        MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves mdblasvitm = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();

        System.out.println("0 == " + mdblasvitm.minDifference(new int[]{5,3,2,4}));
        System.out.println("1 == " + mdblasvitm.minDifference(new int[]{1,5,0,10,14}));
        System.out.println("0 == " + mdblasvitm.minDifference(new int[]{3,100,20}));
    }

    public void minimumLengthOfStringAfterDeletingSimilarEnds() {
        MinimumLengthOfStringAfterDeletingSimilarEnds mlosadse = new MinimumLengthOfStringAfterDeletingSimilarEnds();

        System.out.println("2 == " + mlosadse.minimumLength("ca"));
        System.out.println("0 == " + mlosadse.minimumLength("cabaabac"));
        System.out.println("3 == " + mlosadse.minimumLength("aabccabba"));
        System.out.println("0 == " + mlosadse.minimumLength("aaaa"));
        System.out.println("0 == " + mlosadse.minimumLength("aaaaa"));
        System.out.println("1 == " + mlosadse.minimumLength("a"));
    }

    public void maximumNumberOfMovesInAGrid() {
        MaximumNumberOfMovesInAGrid mnomiag = new MaximumNumberOfMovesInAGrid();

        System.out.println("3 == " + mnomiag.maxMoves(new int[][]{{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}}));
        System.out.println("0 == " + mnomiag.maxMoves(new int[][]{{3,2,4},{2,1,9},{1,1,7}}));
    }

    public void kRadiusSubarrayAverages() {
        KRadiusSubarrayAverages krsa = new KRadiusSubarrayAverages();

        System.out.println("[-1,-1,-1,5,4,4,-1,-1,-1] == " + Arrays.toString(krsa.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3)));
        System.out.println("[100000] == " + Arrays.toString(krsa.getAverages(new int[]{100000}, 0)));
        System.out.println("[-1] == " + Arrays.toString(krsa.getAverages(new int[]{8}, 10000)));
    }

    public void minimumCostToMakeArrayEqual() {
        MinimumCostToMakeArrayEqual mctmae = new MinimumCostToMakeArrayEqual();

        System.out.println("8 == " +  mctmae.minCost(new int[]{1,3,5,2}, new int[]{2,3,1,14}));
        System.out.println("0 == " +  mctmae.minCost(new int[]{2,2,2,2,2}, new int[]{4,2,8,1,3}));
        System.out.println("35 == " +  mctmae.minCost(new int[]{1,3,5,2,6,5,3,2}, new int[]{2,3,1,14,4,3,2,3}));
        System.out.println("55 == " +  mctmae.minCost(new int[]{1,3,5,2,6,5,3,2,1,3,4}, new int[]{2,3,1,14,4,3,2,3,4,5,6}));
        System.out.println("261 == " +  mctmae.minCost(new int[]{1,3,5,2,6,5,3,2,1,3,4,5,6,7,8,9,12,13}, new int[]{2,3,1,14,4,3,2,3,4,5,6,7,8,9,12,13,4,2}));
    }

    public void longestIdealSubsequence() {
        LongestIdealSubsequence lis = new LongestIdealSubsequence();

        System.out.println("4 == " + lis.longestIdealString("acfgbd", 2));
        System.out.println("4 == " + lis.longestIdealString("abcd", 3));
        System.out.println("58 == " + lis.longestIdealString("dkfpsofkemxdrhsyunfeseqaghnsoqdjasifuvhbsrufyeijuyvbcxiatuduhdsnuksdyafhcnowsefhbwiodcjsdibnij", 8));
        System.out.println("19 == " + lis.longestIdealString("dkfpsofkemxdrhsyunfeseqaghnsoqdjasifuvhbsrufyeijuyvbcxiatuduhdsnuksdyafhcnowsefhbwiodcjsdibnij", 1));
        System.out.println("9 == " + lis.longestIdealString("aaaaabbbb", 1));
    }

    public void longestArithmeticSubsequence() {
        LongestArithmeticSubsequence las = new LongestArithmeticSubsequence();

        System.out.println("4 == " + las.longestArithSeqLength(new int[]{3,6,9,12}));
        System.out.println("3 == " + las.longestArithSeqLength(new int[]{9,4,7,2,10}));
        System.out.println("4 == " + las.longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }

    public void lexicographicallySmallestPalindrome() {
        LexicographicallySmallestPalindrome lsp = new LexicographicallySmallestPalindrome();

        System.out.println("efcfe == " + lsp.makeSmallestPalindrome("egcfe"));
        System.out.println("abba == " + lsp.makeSmallestPalindrome("abcd"));
        System.out.println("neven == " + lsp.makeSmallestPalindrome("seven"));
    }

    public void numberOfSubstringsWithOnly1s() {
        NumberOfSubstringsWithOnly1s noswo1 = new NumberOfSubstringsWithOnly1s();

        System.out.println("9 == " + noswo1.numSub("0110111"));
        System.out.println("2 == " + noswo1.numSub("101"));
        System.out.println("21 == " + noswo1.numSub("111111"));
    }

    public void totalCostToHireKWorkers() {
        TotalCostToHireKWorkers tcthkw = new TotalCostToHireKWorkers();

        System.out.println("11 == " + tcthkw.totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));
        System.out.println("4 == " + tcthkw.totalCost(new int[]{1,2,4,1}, 3, 3));
        System.out.println("223 == " + tcthkw.totalCost(new int[]{18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75}, 13, 23));
    }

    public void findKPairsWithSmallestSums() {
        FindKPairsWithSmallestSums fkpwss = new FindKPairsWithSmallestSums();

        System.out.println("[[1,2],[1,4],[1,6]] == " + fkpwss.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
        System.out.println("[[1,1],[1,1]] == " + fkpwss.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 2));
        System.out.println("[[1,3],[2,3]] == " + fkpwss.kSmallestPairs(new int[]{1,2}, new int[]{3}, 3));
    }

    public void pathWithMaximumProbability() {
        PathWithMaximumProbability pwmp = new PathWithMaximumProbability();

        System.out.println("0.2500 == " +  pwmp.maxProbability(3, new int[][]{{0,1},{1,2},{0,2}}, new double[]{0.5, 0.5, 0.2}, 0, 2));
        System.out.println("0.3000 == " +  pwmp.maxProbability(3, new int[][]{{0,1},{1,2},{0,2}}, new double[]{0.5, 0.5, 0.3}, 0, 2));
        System.out.println("0.0000 == " +  pwmp.maxProbability(3, new int[][]{{0,1}}, new double[]{0.5}, 0, 2));
    }

    public void removingMinimumAndMaximumFromArray() {
        RemovingMinimumAndMaximumFromArray rmamfa = new RemovingMinimumAndMaximumFromArray();

        System.out.println("5 == " + rmamfa.minimumDeletions(new int[]{2,10,7,5,4,1,8,6}));
        System.out.println("3 == " + rmamfa.minimumDeletions(new int[]{0,-4,19,1,8,-2,-3,5}));
        System.out.println("1 == " + rmamfa.minimumDeletions(new int[]{101}));
    }

    public void divideArrayInSetsOfKConsecutiveNumbers() {
        DivideArrayInSetsOfKConsecutiveNumbers daisokcn = new DivideArrayInSetsOfKConsecutiveNumbers();

        System.out.println("true == " + daisokcn.isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4));
        System.out.println("true == " + daisokcn.isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 3));
        System.out.println("false == " + daisokcn.isPossibleDivide(new int[]{1,2,3,4}, 3));
    }

    public void lastDayWhereYouCanStillCross() {
        LastDayWhereYouCanStillCross ldwycsc = new LastDayWhereYouCanStillCross();

        System.out.println("2 == " + ldwycsc.latestDayToCross(2, 2, new int[][]{{1,1},{2,1},{1,2},{2,2}}));
        System.out.println("1 == " + ldwycsc.latestDayToCross(2, 2, new int[][]{{1,1},{1,2},{2,1},{2,2}}));
        System.out.println("3 == " + ldwycsc.latestDayToCross(3,3, new int[][]{{1,2},{2,1},{3,3},{2,2},{1,1},{1,3},{2,3},{3,2},{3,1}}));
    }
}
