package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.june.AvoidFloodInTheCity;
import com.ss.leetcode.LC2023.june.CountArtifactsThatCanBeExtracted;
import com.ss.leetcode.LC2023.june.DetermineTheWinnerOfABowlingGame;
import com.ss.leetcode.LC2023.june.FrequencyTracker;
import com.ss.leetcode.LC2023.june.MaximumNumberOfFishInAGrid;
import com.ss.leetcode.LC2023.june.MaximumStrengthOfAGroup;
import com.ss.leetcode.LC2023.june.MaximumValueAtAGivenIndexInABoundedArray;
import com.ss.leetcode.LC2023.june.MinimizeResultByAddingParenthesesToExpression;
import com.ss.leetcode.LC2023.june.MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves;
import com.ss.leetcode.LC2023.june.NumberOfSeniorCitizens;
import com.ss.leetcode.LC2023.june.NumberOfSmoothDescentPeriodsOfAStock;
import com.ss.leetcode.LC2023.june.RemoveTrailingZerosFromAString;
import com.ss.leetcode.LC2023.june.ReorganizeString;
import com.ss.leetcode.LC2023.june.ShortestPathInBinaryMatrix;
import com.ss.leetcode.LC2023.june.SumOfMatrixAfterQueries;
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
        start.minimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
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
}
