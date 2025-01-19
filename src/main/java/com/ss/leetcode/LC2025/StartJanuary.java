package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.january.AdjacentIncreasingSubarraysDetectionI;
import com.ss.leetcode.LC2025.january.CheckIfAParenthesesStringCanBeValid;
import com.ss.leetcode.LC2025.january.CoordinateWithMaximumNetworkQuality;
import com.ss.leetcode.LC2025.january.CountPrefixAndSuffixPairsI;
import com.ss.leetcode.LC2025.january.CountSubstringsThatCanBeRearrangedToContainAStringII;
import com.ss.leetcode.LC2025.january.CountTheNumberOfSpecialCharactersII;
import com.ss.leetcode.LC2025.january.FindCommonElementsBetweenTwoArrays;
import com.ss.leetcode.LC2025.january.FindTheLexicographicallyLargestStringFromTheBoxI;
import com.ss.leetcode.LC2025.january.FlowerPlantingWithNoAdjacent;
import com.ss.leetcode.LC2025.january.MakeLexicographicallySmallestArrayBySwappingElements;
import com.ss.leetcode.LC2025.january.MaximumRowsCoveredByColumns;
import com.ss.leetcode.LC2025.january.MaximumStarSumOfAGraph;
import com.ss.leetcode.LC2025.january.MaximumTotalRewardUsingOperationsI;
import com.ss.leetcode.LC2025.january.MinimizeXOR;
import com.ss.leetcode.LC2025.january.MinimumEqualSumOfTwoArraysAfterReplacingZeros;
import com.ss.leetcode.LC2025.january.MinimumLengthOfAnagramConcatenation;
import com.ss.leetcode.LC2025.january.MinimumLengthOfStringAfterOperations;
import com.ss.leetcode.LC2025.january.MinimumLevelsToGainMorePoints;
import com.ss.leetcode.LC2025.january.MinimumOperationsToMakeASpecialNumber;
import com.ss.leetcode.LC2025.january.MinimumSubstringPartitionOfEqualCharacterFrequency;
import com.ss.leetcode.LC2025.january.ModifyTheMatrix;
import com.ss.leetcode.LC2025.january.SumOfDistances;
import com.ss.leetcode.LC2025.january.WaterBottlesII;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
//        start.checkIfAParenthesesStringCanBeValid();
//        start.findCommonElementsBetweenTwoArrays();
//        start.minimumLengthOfStringAfterOperations();
//        start.minimizeXOR();
//        start.adjacentIncreasingSubarraysDetectionI();
//        start.waterBottlesII();
//        start.countSubstringsThatCanBeRearrangedToContainAStringII();
//        start.minimumLevelsToGainMorePoints();
//        start.minimumSubstringPartitionOfEqualCharacterFrequency();
//        start.minimumEqualSumOfTwoArraysAfterReplacingZeros();
//        start.modifyTheMatrix();
//        start.minimumOperationsToMakeASpecialNumber();
        start.maximumStarSumOfAGraph();
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

    public void findCommonElementsBetweenTwoArrays() {
        FindCommonElementsBetweenTwoArrays fcebta = new FindCommonElementsBetweenTwoArrays();

        System.out.println("[2,1] == " + Arrays.toString(fcebta.findIntersectionValues(new int[]{2,3,2}, new int[]{1,2})));
        System.out.println("[3,4] == " + Arrays.toString(fcebta.findIntersectionValues(new int[]{4,3,2,3,1}, new int[]{2,2,5,2,3,6})));
        System.out.println("[0,0] == " + Arrays.toString(fcebta.findIntersectionValues(new int[]{3,4,2,3}, new int[]{1,5})));
        System.out.println("[2,2] == " + Arrays.toString(fcebta.findIntersectionValues(new int[]{3,2,1,2,4,5,6,7}, new int[]{6,3,10,11})));
        System.out.println("[9,1] == " + Arrays.toString(fcebta.findIntersectionValues(new int[]{1,1,1,1,1,1,1,1,1,6,7,8,9,10}, new int[]{1,2,3,4,5})));
    }

    public void minimumLengthOfStringAfterOperations() {
        MinimumLengthOfStringAfterOperations mlosao = new MinimumLengthOfStringAfterOperations();

        System.out.println("5 == " + mlosao.minimumLength("abaacbcbb"));
        System.out.println("2 == " + mlosao.minimumLength("aa"));
        System.out.println("5 == " + mlosao.minimumLength("aaaaabbbbaaacccccaccacacacaccaa"));
        System.out.println("1 == " + mlosao.minimumLength("a"));
    }

    public void minimizeXOR() {
        MinimizeXOR mxor = new MinimizeXOR();

        System.out.println("3 == " + mxor.minimizeXor(3, 5));
        System.out.println("3 == " + mxor.minimizeXor(1, 12));
        System.out.println("63 == " + mxor.minimizeXor(1, 100000));
        System.out.println("24575 == " + mxor.minimizeXor(23323, 45435535));
        System.out.println("353280 == " + mxor.minimizeXor(353454, 2323));
        System.out.println("213123199 == " + mxor.minimizeXor(213123123, 3432432));
        System.out.println("123903 == " + mxor.minimizeXor(123213, 56546565));
    }

    public void adjacentIncreasingSubarraysDetectionI() {
        AdjacentIncreasingSubarraysDetectionI aisdi = new AdjacentIncreasingSubarraysDetectionI();

        System.out.println("true == " + aisdi.hasIncreasingSubarrays(List.of(2,5,7,8,9,2,3,4,3,1), 3));
        System.out.println("false == " + aisdi.hasIncreasingSubarrays(List.of(1,2,3,4,4,4,4,5,6,7), 5));
        System.out.println("true == " + aisdi.hasIncreasingSubarrays(List.of(5,8,-2,-1), 2));
    }

    public void waterBottlesII() {
        WaterBottlesII wbii = new WaterBottlesII();

        System.out.println("15 == " + wbii.maxBottlesDrunk(13, 6));
        System.out.println("13 == " + wbii.maxBottlesDrunk(10, 3));
        System.out.println("24 == " + wbii.maxBottlesDrunk(23, 12));
        System.out.println("69 == " + wbii.maxBottlesDrunk(65, 12));
        System.out.println("66 == " + wbii.maxBottlesDrunk(56, 2));
        System.out.println("108 == " + wbii.maxBottlesDrunk(98, 6));
        System.out.println("68 == " + wbii.maxBottlesDrunk(59, 3));
    }

    public void countSubstringsThatCanBeRearrangedToContainAStringII() {
        CountSubstringsThatCanBeRearrangedToContainAStringII cstcbrtcasii = new CountSubstringsThatCanBeRearrangedToContainAStringII();

        System.out.println("1 == " + cstcbrtcasii.validSubstringCount("bcca", "abc"));
        System.out.println("10 == " + cstcbrtcasii.validSubstringCount("abcabc", "abc"));
        System.out.println("0 == " + cstcbrtcasii.validSubstringCount("abcabc", "aaabc"));
        System.out.println("3 == " + cstcbrtcasii.validSubstringCount("eeded", "dde"));
        System.out.println("0 == " + cstcbrtcasii.validSubstringCount("abbabababa", "abbabababbababa"));
        System.out.println("23 == " + cstcbrtcasii.validSubstringCount("eeddeeded", "dde"));
    }

    public void minimumLevelsToGainMorePoints() {
        MinimumLevelsToGainMorePoints mltgmp = new MinimumLevelsToGainMorePoints();

        System.out.println("1 == " + mltgmp.minimumLevels(new int[]{1,0,1,0}));
        System.out.println("3 == " + mltgmp.minimumLevels(new int[]{1,1,1,1,1}));
        System.out.println("-1 == " + mltgmp.minimumLevels(new int[]{0,0}));
        System.out.println("1 == " + mltgmp.minimumLevels(new int[]{0,0,0}));
        System.out.println("3 == " + mltgmp.minimumLevels(new int[]{1,1,1,0,1,1}));
        System.out.println("1 == " + mltgmp.minimumLevels(new int[]{1,0,0}));
        System.out.println("-1 == " + mltgmp.minimumLevels(new int[]{0,1,1}));
        System.out.println("5 == " + mltgmp.minimumLevels(new int[]{1,0,1,1,1,1,0,1,1,0,0,1}));
        System.out.println("1 == " + mltgmp.minimumLevels(new int[]{1,0,0,1,1,0,0,1,1,0,0,1,1,0}));
        System.out.println("2 == " + mltgmp.minimumLevels(new int[]{1,1,1}));
    }

    public void minimumSubstringPartitionOfEqualCharacterFrequency() {
        MinimumSubstringPartitionOfEqualCharacterFrequency mspoecf = new MinimumSubstringPartitionOfEqualCharacterFrequency();

        System.out.println("3 == " + mspoecf.minimumSubstringsInPartition("fabccddg"));
        System.out.println("2 == " + mspoecf.minimumSubstringsInPartition("abababaccddb"));
        System.out.println("1 == " + mspoecf.minimumSubstringsInPartition("a"));
        System.out.println("1 == " + mspoecf.minimumSubstringsInPartition("aaaa"));
        System.out.println("3 == " + mspoecf.minimumSubstringsInPartition("dsadsasasddadsdsdsa"));
        System.out.println("9 == " + mspoecf.minimumSubstringsInPartition("adssaddfdsfdfhfjjkghdfsdffgfd"));
        System.out.println("3 == " + mspoecf.minimumSubstringsInPartition("safghtujuthrefddf"));
        System.out.println("5 == " + mspoecf.minimumSubstringsInPartition("sadfdgjuyjtyhbveeftrhrgf"));
    }

    public void minimumEqualSumOfTwoArraysAfterReplacingZeros() {
        MinimumEqualSumOfTwoArraysAfterReplacingZeros mesotaarz = new MinimumEqualSumOfTwoArraysAfterReplacingZeros();

        System.out.println("12 == " + mesotaarz.minSum(new int[]{3,2,0,1,0}, new int[]{6,5,0}));
        System.out.println("-1 == " + mesotaarz.minSum(new int[]{2,0,2,0}, new int[]{1,4}));
        System.out.println("-1 == " + mesotaarz.minSum(new int[]{2,3,4,5,6,7,0}, new int[]{1,2,3,4}));
        System.out.println("12 == " + mesotaarz.minSum(new int[]{0,0,0,0,0,0,0,0,4}, new int[]{12}));
        System.out.println("13 == " + mesotaarz.minSum(new int[]{0,0,0,0,0,0,0,0,4}, new int[]{13}));
        System.out.println("-1 == " + mesotaarz.minSum(new int[]{0,0,0,0,0,0,0,0,4}, new int[]{11}));
        System.out.println("5 == " + mesotaarz.minSum(new int[]{0}, new int[]{5}));
        System.out.println("6 == " + mesotaarz.minSum(new int[]{0}, new int[]{5,0}));
    }

    public void modifyTheMatrix() {
        ModifyTheMatrix mtm = new ModifyTheMatrix();

        System.out.println("[[1,2,8],[4,8,8],[7,8,8]] == " + Arrays.deepToString(mtm.modifiedMatrix(new int[][]{{1,2,-1},{4,-1,-1},{7,8,8}})));
        System.out.println("[[1,2,9],[4,8,6],[7,8,9]] == " + Arrays.deepToString(mtm.modifiedMatrix(new int[][]{{1,2,-1},{4,-1,6},{7,8,9}})));
        System.out.println("[[3,2],[5,2]] == " + Arrays.deepToString(mtm.modifiedMatrix(new int[][]{{3,-1},{5,2}})));
    }

    public void minimumOperationsToMakeASpecialNumber() {
        MinimumOperationsToMakeASpecialNumber motmasn = new MinimumOperationsToMakeASpecialNumber();

        System.out.println("2 == " + motmasn.minimumOperations("2245047"));
        System.out.println("3 == " + motmasn.minimumOperations("2908305"));
        System.out.println("1 == " + motmasn.minimumOperations("10"));
        System.out.println("2 == " + motmasn.minimumOperations("110"));
        System.out.println("1 == " + motmasn.minimumOperations("10010101001001010"));
        System.out.println("4 == " + motmasn.minimumOperations("1024320340923059033590324"));
        System.out.println("8 == " + motmasn.minimumOperations("120149248738597435948543"));
        System.out.println("5 == " + motmasn.minimumOperations("309348397129438732095013241"));
        System.out.println("18 == " + motmasn.minimumOperations("121211112121212121"));
    }

    public void maximumStarSumOfAGraph() {
        MaximumStarSumOfAGraph mssoag = new MaximumStarSumOfAGraph();

        System.out.println("16 == " + mssoag.maxStarSum(new int[]{1,2,3,4,10,-10,-20}, new int[][]{{0,1},{1,2},{1,3},{3,4},{3,5},{3,6}}, 2));
        System.out.println("-5 == " + mssoag.maxStarSum(new int[]{-5}, new int[0][0], 0));
        System.out.println("20 == " + mssoag.maxStarSum(new int[]{1,2,3,4,10,-10,-20,-17,8,5,2,3,4}, new int[][]{{0,1},{1,2},{1,3},{3,4},{3,5},{3,6},{6,9},{7,5},{10,12},{11,12},{8,11},{7,12},{11,9}}, 3));
        System.out.println("20 == " + mssoag.maxStarSum(new int[]{1,2,3,4,10,-10,-20,-17,8,5,2,3,4}, new int[][]{{0,1},{1,2},{1,3},{3,4},{3,5},{3,6},{6,9},{7,5},{10,12},{11,12},{8,11},{7,12},{11,9}}, 4));
    }
}
