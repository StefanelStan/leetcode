package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.january.CheckIfAParenthesesStringCanBeValid;
import com.ss.leetcode.LC2025.january.CoordinateWithMaximumNetworkQuality;
import com.ss.leetcode.LC2025.january.CountPrefixAndSuffixPairsI;
import com.ss.leetcode.LC2025.january.CountTheNumberOfSpecialCharactersII;
import com.ss.leetcode.LC2025.january.FindTheLexicographicallyLargestStringFromTheBoxI;
import com.ss.leetcode.LC2025.january.FlowerPlantingWithNoAdjacent;
import com.ss.leetcode.LC2025.january.MakeLexicographicallySmallestArrayBySwappingElements;
import com.ss.leetcode.LC2025.january.MaximumRowsCoveredByColumns;
import com.ss.leetcode.LC2025.january.MaximumTotalRewardUsingOperationsI;
import com.ss.leetcode.LC2025.january.MinimumLengthOfAnagramConcatenation;
import com.ss.leetcode.LC2025.january.SumOfDistances;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

//        start.findTheLexicographicallyLargestStringFromTheBoxI();
//        start.maximumTotalRewardUsingOperationsI();
//        start.flowerPlantingWithNoAdjacent();
//        start.coordinateWithMaximumNetworkQuality();
//        start.countTheNumberOfSpecialCharactersII();
//        start.maximumRowsCoveredByColumns();
//        start.countPrefixAndSuffixPairsI();
//        start.sumOfDistances();
//        start.minimumLengthOfAnagramConcatenation();
//        start.makeLexicographicallySmallestArrayBySwappingElements();
        start.checkIfAParenthesesStringCanBeValid();
    }

    public void findTheLexicographicallyLargestStringFromTheBoxI() {
        FindTheLexicographicallyLargestStringFromTheBoxI ftllsftbi = new FindTheLexicographicallyLargestStringFromTheBoxI();

        System.out.println("dbc == " + ftllsftbi.answerString("dbca", 2));
        System.out.println("g == " + ftllsftbi.answerString("gggg", 4));
    }

    public void maximumTotalRewardUsingOperationsI() {
        MaximumTotalRewardUsingOperationsI mtruoi = new MaximumTotalRewardUsingOperationsI();

        System.out.println("4 == " + mtruoi.maxTotalReward(new int[]{1,1,3,3}));
        System.out.println("11 == " + mtruoi.maxTotalReward(new int[]{1,6,4,3,2}));
        System.out.println("17 == " + mtruoi.maxTotalReward(new int[]{5,6,7,8,4,3,2,1,2,3,4,5,6,7,8,9,8,7,6,5,4,2}));
        System.out.println("3996 == " + mtruoi.maxTotalReward(new int[]{453,129, 2000, 2000, 2000, 1872, 134, 231,654,235,123,876,345,765,678,234,216,1}));
        System.out.println("7 == " + mtruoi.maxTotalReward(new int[]{7}));
        System.out.println("7 == " + mtruoi.maxTotalReward(new int[]{7,7,7}));
    }

    public void flowerPlantingWithNoAdjacent() {
        FlowerPlantingWithNoAdjacent flwna = new FlowerPlantingWithNoAdjacent();

        System.out.println("[1,2,3] == " + Arrays.toString(flwna.gardenNoAdj(3, new int[][]{{1,2},{2,3},{3,1}})));
        System.out.println("[1,2,1,2] == " + Arrays.toString(flwna.gardenNoAdj(4, new int[][]{{1,2},{4,3}})));
        System.out.println("[1,2,3,4] == " + Arrays.toString(flwna.gardenNoAdj(4, new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}})));
        System.out.println("[1,2,1,1,2,2,3] == " + Arrays.toString(flwna.gardenNoAdj(7, new int[][]{{1,5},{2,1},{1,6},{2,4},{3,2},{4,7},{6,7}})));
    }

    public void coordinateWithMaximumNetworkQuality() {
        CoordinateWithMaximumNetworkQuality cwmnq = new CoordinateWithMaximumNetworkQuality();

        System.out.println("[2,1] == " + Arrays.toString(cwmnq.bestCoordinate(new int[][]{{1,2,5},{2,1,7},{3,1,9}}, 2)));
        System.out.println("[23,11] == " + Arrays.toString(cwmnq.bestCoordinate(new int[][]{{23,11,21}}, 9)));
        System.out.println("[1,2] == " + Arrays.toString(cwmnq.bestCoordinate(new int[][]{{1,2,13},{2,1,7},{0,1,9}}, 2)));
        System.out.println("[2,5] == " + Arrays.toString(cwmnq.bestCoordinate(new int[][]{{2,5,10},{10,5,10}}, 5)));
        System.out.println("[1,6] == " + Arrays.toString(cwmnq.bestCoordinate(new int[][]{{30,34,31},{10,44,24},{14,28,23},{50,38,1},{40,13,6},{16,27,9},{2,22,23},{1,6,41},{34,22,40},{40,10,11}},20)));
        System.out.println("[1,6] == " + Arrays.toString(cwmnq.bestCoordinate(new int[][]{{30,34,31},{10,44,24},{16,27,9},{2,22,23},{1,6,41},{34,22,40},{40,10,11}},20)));
    }

    public void countTheNumberOfSpecialCharactersII() {
        CountTheNumberOfSpecialCharactersII ctnoscii = new CountTheNumberOfSpecialCharactersII();

        System.out.println("3 == " + ctnoscii.numberOfSpecialChars("aaAbcBC"));
        System.out.println("0 == " + ctnoscii.numberOfSpecialChars("abc"));
        System.out.println("0 == " + ctnoscii.numberOfSpecialChars("AbBCab"));
    }

    public void maximumRowsCoveredByColumns() {
        MaximumRowsCoveredByColumns mrcbc = new MaximumRowsCoveredByColumns();

        System.out.println("3 == " + mrcbc.maximumRows(new int[][]{{0,0,0},{1,0,1},{0,1,1},{0,0,1}}, 2));
        System.out.println("2 == " + mrcbc.maximumRows(new int[][]{{1},{0}}, 1));
        System.out.println("2 == " + mrcbc.maximumRows(new int[][]{{0,0,1,0,0,1},{1,1,0,0,1,1},{1,1,1,1,1,0},{0,0,0,1,1,1},{0,1,0,0,1,1}}, 4));
    }

    public void countPrefixAndSuffixPairsI() {
        CountPrefixAndSuffixPairsI cpaspi = new CountPrefixAndSuffixPairsI();

        System.out.println("4 == " + cpaspi.countPrefixSuffixPairs(new String[]{"a","aba","ababa","aa"}));
        System.out.println("2 == " + cpaspi.countPrefixSuffixPairs(new String[]{"pa","papa","ma","mama"}));
        System.out.println("0 == " + cpaspi.countPrefixSuffixPairs(new String[]{"abab","ab"}));
        System.out.println("1 == " + cpaspi.countPrefixSuffixPairs(new String[]{"aabb","aabb","ab"}));
    }

    public void sumOfDistances() {
        SumOfDistances sod = new SumOfDistances();

        System.out.println("[5,0,3,4,0] == " + Arrays.toString(sod.distance(new int[]{1,3,1,1,2})));
        System.out.println("[0,0,0] == " + Arrays.toString(sod.distance(new int[]{0,5,3})));
    }

    public void minimumLengthOfAnagramConcatenation() {
        MinimumLengthOfAnagramConcatenation mloac = new MinimumLengthOfAnagramConcatenation();

        System.out.println("2 == " + mloac.minAnagramLength("abba"));
        System.out.println("4 == " + mloac.minAnagramLength("cdef"));
        System.out.println("1 == " + mloac.minAnagramLength("aaaaaa"));
        System.out.println("3 == " + mloac.minAnagramLength("abcabcabcabc"));
        System.out.println("10 == " + mloac.minAnagramLength("abcabcabceabcabcabce"));
        System.out.println("20 == " + mloac.minAnagramLength("abcabcabceabcabcabcf"));
        System.out.println("1 == " + mloac.minAnagramLength("a"));
    }

    public void makeLexicographicallySmallestArrayBySwappingElements() {
        MakeLexicographicallySmallestArrayBySwappingElements mlsabse = new MakeLexicographicallySmallestArrayBySwappingElements();

        System.out.println("[1,3,5,8,9] == " + Arrays.toString(mlsabse.lexicographicallySmallestArray(new int[]{1,5,3,9,8}, 2)));
        System.out.println("[1,6,7,18,1,2] == " + Arrays.toString(mlsabse.lexicographicallySmallestArray(new int[]{1,7,6,18,2,1}, 3)));
        System.out.println("[1,7,28,19,10] == " + Arrays.toString(mlsabse.lexicographicallySmallestArray(new int[]{1,7,28,19,10}, 3)));
        System.out.println("[1000000000] == " + Arrays.toString(mlsabse.lexicographicallySmallestArray(new int[]{1000000000}, 1)));
    }

    public void checkIfAParenthesesStringCanBeValid() {
        CheckIfAParenthesesStringCanBeValid ciapscbv = new CheckIfAParenthesesStringCanBeValid();

        System.out.println("true == " + ciapscbv.canBeValid("))()))", "010100"));
        System.out.println("true == " + ciapscbv.canBeValid("()()", "0000"));
        System.out.println("false == " + ciapscbv.canBeValid(")", "0"));
        System.out.println("true == " + ciapscbv.canBeValid("((()(()()))()((()()))))()((()(()", "10111100100101001110100010001001"));
    }
}
