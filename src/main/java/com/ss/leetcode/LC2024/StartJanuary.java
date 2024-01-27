package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.january.AdvantageShuffle;
import com.ss.leetcode.LC2024.january.CinemaSeatAllocation;
import com.ss.leetcode.LC2024.january.CircularPermutationInBinaryRepresentation;
import com.ss.leetcode.LC2024.january.CountGoodMeals;
import com.ss.leetcode.LC2024.january.DetectPatternOfLengthMRepeatedKOrMoreTimes;
import com.ss.leetcode.LC2024.january.DivideIntervalsIntoMinimumNumberOfGroups;
import com.ss.leetcode.LC2024.january.FurthestPointFromOrigin;
import com.ss.leetcode.LC2024.january.HouseRobberII;
import com.ss.leetcode.LC2024.january.JumpGameVII;
import com.ss.leetcode.LC2024.january.LengthOfLongestSubarrayWithAtMostKFrequency;
import com.ss.leetcode.LC2024.january.LexicographicallySmallestStringAfterSubstringOperation;
import com.ss.leetcode.LC2024.january.MaximumLengthOfAConcatenatedStringWithUniqueCharacters;
import com.ss.leetcode.LC2024.january.MaximumNumberOfWeeksForWhichYouCanWork;
import com.ss.leetcode.LC2024.january.MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold;
import com.ss.leetcode.LC2024.january.MinimumIndexOfAValidSplit;
import com.ss.leetcode.LC2024.january.MinimumNumberOfFrogsCroaking;
import com.ss.leetcode.LC2024.january.MinimumNumberOfOperationsToMakeArrayEmpty;
import com.ss.leetcode.LC2024.january.MinimumPathCostInAGrid;
import com.ss.leetcode.LC2024.january.NumberOfOrdersInTheBacklog;
import com.ss.leetcode.LC2024.january.NumberOfPairsOfInterchangeableRectangles;
import com.ss.leetcode.LC2024.january.OutOfBoundaryPaths;
import com.ss.leetcode.LC2024.january.PointsThatIntersectWithCars;
import com.ss.leetcode.LC2024.january.ReachableNodesWithRestrictions;
import com.ss.leetcode.LC2024.january.ReplaceElementsInAnArray;
import com.ss.leetcode.LC2024.january.RotatingTheBox;
import com.ss.leetcode.LC2024.january.StoneGameVII;
import com.ss.leetcode.LC2024.january.TheTimeWhenTheNetworkBecomesIdle;
import com.ss.leetcode.LC2024.january.TwoBestNonOverlappingEvents;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

//        start.replaceElementsInAnArray();
//        start.minimumNumberOfOperationsToMakeArrayEmpty();
//        start.advantageShuffle();
//        start.minimumIndexOfAValidSplit();
//        start.countGoodMeals();
//        start.furthestPointFromOrigin();
//        start.minimumPathCostInAGrid();
//        start.rotatingTheBox();
//        start.circularPermutationInBinaryRepresentation();
//        start.lexicographicallySmallestStringAfterSubstringOperation();
//        start.numberOfPairsOfInterchangeableRectangles();
//        start.houseRobberII();
//        start.pointsThatIntersectWithCars();
//        start.detectPatternOfLengthMRepeatedKOrMoreTimes();
//        start.lengthOfLongestSubarrayWithAtMostKFrequency();
//        start.maximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold();
//        start.minimumNumberOfFrogsCroaking();
//        start.cinemaSeatAllocation();
//        start.jumpGameVII();
//        start.maximumNumberOfWeeksForWhichYouCanWork();
//        start.stoneGameVII();
//        start.numberOfOrdersInTheBacklog();
//        start.maximumLengthOfAConcatenatedStringWithUniqueCharacters();
//        start.theTimeWhenTheNetworkBecomesIdle();
//        start.outOfBoundaryPaths();
//        start.reachableNodesWithRestrictions();
        start.divideIntervalsIntoMinimumNumberOfGroups();
//        start.twoBestNonOverlappingEvents();
    }

    public void replaceElementsInAnArray() {
        ReplaceElementsInAnArray reiaa = new ReplaceElementsInAnArray();

        System.out.println("[3,2,7,1] == " + Arrays.toString(reiaa.arrayChange(new int[]{1,2,4,6}, new int[][]{{1,3},{4,7},{6,1}})));
        System.out.println("[2,1] == " + Arrays.toString(reiaa.arrayChange(new int[]{1,2}, new int[][]{{1,3},{2,1},{3,2}})));
    }

    public void minimumNumberOfOperationsToMakeArrayEmpty() {
        MinimumNumberOfOperationsToMakeArrayEmpty mnootmae = new MinimumNumberOfOperationsToMakeArrayEmpty();

        System.out.println("4 == " + mnootmae.minOperations(new int[]{2,3,3,2,2,4,2,3,4}));
        System.out.println("-1 == " + mnootmae.minOperations(new int[]{2,1,2,2,3,3}));
    }

    public void advantageShuffle() {
        AdvantageShuffle as = new AdvantageShuffle();

        System.out.println("[2,11,7,15] == " + Arrays.toString(as.advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11})));
        System.out.println("[24,32,8,12] == " + Arrays.toString(as.advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11})));
    }

    public void minimumIndexOfAValidSplit() {
        MinimumIndexOfAValidSplit mioavs = new MinimumIndexOfAValidSplit();

        System.out.println("2 == " + mioavs.minimumIndex(List.of(1,2,2,2)));
        System.out.println("4 == " + mioavs.minimumIndex(List.of(2,1,3,1,1,1,7,1,2,1)));
        System.out.println("-1 == " + mioavs.minimumIndex(List.of(3,3,3,3,7,2,2)));
    }

    public void countGoodMeals() {
        CountGoodMeals cgm = new CountGoodMeals();

        System.out.println("4 == " + cgm.countPairs(new int[]{1,3,5,7,9}));
        System.out.println("15 == " + cgm.countPairs(new int[]{1,1,1,3,3,3,7}));
    }

    public void furthestPointFromOrigin() {
        FurthestPointFromOrigin fpfo = new FurthestPointFromOrigin();

        System.out.println("3 == " + fpfo.furthestDistanceFromOrigin("L_RL__R"));
        System.out.println("5 == " + fpfo.furthestDistanceFromOrigin("_R__LL_"));
        System.out.println("7 == " + fpfo.furthestDistanceFromOrigin("_______"));
    }

    public void minimumPathCostInAGrid() {
        MinimumPathCostInAGrid mpciag = new MinimumPathCostInAGrid();

        System.out.println("17 == " + mpciag.minPathCost(new int[][]{{5,3},{4,0},{2,1}}, new int[][]{{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}}));
        System.out.println("6 == " + mpciag.minPathCost(new int[][]{{5,1,2},{4,0,3}}, new int[][]{{12,10,15},{20,23,8},{21,7,1},{8,1,13},{9,10,25},{5,3,2}}));
    }

    public void rotatingTheBox() {
        RotatingTheBox rtb = new RotatingTheBox();

        System.out.println("[[.],[#],[#]] == " + Arrays.deepToString(rtb.rotateTheBox(new char[][]{{'#','.','#'}})));
        System.out.println("[[#,.],[#,#],[.,.]] == " + Arrays.deepToString(rtb.rotateTheBox(new char[][]{{'#','.','*','.'},{'#','#','*','.'}})));
        System.out.println("[[.,#,#],[.,#,#],[#,#,*],[#,*,.],[#,.,*],[#,.,.]] == " + Arrays.deepToString(rtb.rotateTheBox(new char[][]{{'#','#','*','.','*','.'},{'#','#','#','*','.','.'},{'#','#','#','.','#','.'}})));
    }

    public void circularPermutationInBinaryRepresentation() {
        CircularPermutationInBinaryRepresentation cpibr = new CircularPermutationInBinaryRepresentation();

        System.out.println("[3,2,0,1] == " + cpibr.circularPermutation(2, 3));
        System.out.println("[2,6,7,5,4,0,1,3] == " + cpibr.circularPermutation(3, 2));
    }

    public void lexicographicallySmallestStringAfterSubstringOperation() {
        LexicographicallySmallestStringAfterSubstringOperation lssaso = new LexicographicallySmallestStringAfterSubstringOperation();

        System.out.println("baabc == " + lssaso.smallestString("cbabc"));
        System.out.println("abaab == " + lssaso.smallestString("acbbc"));
        System.out.println("kddsbncd == " + lssaso.smallestString("leetcode"));
    }

    public void numberOfPairsOfInterchangeableRectangles() {
        NumberOfPairsOfInterchangeableRectangles nopoir = new NumberOfPairsOfInterchangeableRectangles();

        System.out.println("6 == " + nopoir.interchangeableRectangles(new int[][]{{4,8},{3,6},{10,20},{15,30}}));
        System.out.println("0 == " + nopoir.interchangeableRectangles(new int[][]{{4,5},{7,8}}));
    }

    public void houseRobberII() {
        HouseRobberII hrii = new HouseRobberII();

        System.out.println("3 == " + hrii.rob(new int[]{2,3,2}));
        System.out.println("4 == " + hrii.rob(new int[]{1,2,3,1}));
        System.out.println("3 == " + hrii.rob(new int[]{1,2,3}));
        System.out.println("29 == " + hrii.rob(new int[]{3,2,4,5,6,7,8,9,0,1,2,3,4}));
    }

    public void pointsThatIntersectWithCars() {
        PointsThatIntersectWithCars ptiwc = new PointsThatIntersectWithCars();

        System.out.println("7 == " + ptiwc.numberOfPoints(List.of(List.of(3,6), List.of(1,5), List.of(4,7))));
        System.out.println("7 == " + ptiwc.numberOfPoints(List.of(List.of(1,3), List.of(5,8))));
        System.out.println("10 == " + ptiwc.numberOfPoints(List.of(List.of(1,8), List.of(5,10))));
    }

    public void detectPatternOfLengthMRepeatedKOrMoreTimes() {
        DetectPatternOfLengthMRepeatedKOrMoreTimes dpolmrkomt = new DetectPatternOfLengthMRepeatedKOrMoreTimes();

        System.out.println("true == " + dpolmrkomt.containsPattern(new int[]{1,2,4,4,4,4}, 1, 3));
        System.out.println("true == " + dpolmrkomt.containsPattern(new int[]{1,2,1,2,1,1,1,3}, 2, 2));
        System.out.println("false == " + dpolmrkomt.containsPattern(new int[]{1,2,3,1,2}, 2, 2));
        System.out.println("false == " + dpolmrkomt.containsPattern(new int[]{1,2,1,2,1,3}, 2, 3));
    }

    public void lengthOfLongestSubarrayWithAtMostKFrequency() {
        LengthOfLongestSubarrayWithAtMostKFrequency lolswamkf = new LengthOfLongestSubarrayWithAtMostKFrequency();

        System.out.println("6 == " + lolswamkf.maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 2));
        System.out.println("2 == " + lolswamkf.maxSubarrayLength(new int[]{1,2,1,2,1,2,1,2}, 1));
        System.out.println("4 == " + lolswamkf.maxSubarrayLength(new int[]{5,5,5,5,5,5,5}, 4));
        System.out.println("11 == " + lolswamkf.maxSubarrayLength(new int[]{1,2,3,4,5,6,7,8,9,11,12}, 2));
        System.out.println("12 == " + lolswamkf.maxSubarrayLength(new int[]{2,3,2,1,2,3,4,5,6,5,4,3,2,2,2,3,2,1,2,3,4,5,6,5,4,3,2,2,2,3,2,1,2,3,4,5,6,5,4,3,2,2,2,3,2,1,2,3,4,5,6,5,4,3,2,2,2,3,2,1,2,3,4,5,6,5,4,3,2,2}, 3));
    }

    public void maximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold() {
        MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold msloaswsltoett = new MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold();

        System.out.println("2 == " + msloaswsltoett.maxSideLength(new int[][]{{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}}, 4));
        System.out.println("0 == " + msloaswsltoett.maxSideLength(new int[][]{{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}}, 1));
        System.out.println("1 == " + msloaswsltoett.maxSideLength(new int[][]{{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}}, 4));
        System.out.println("2 == " + msloaswsltoett.maxSideLength(new int[][]{{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}}, 9));
    }

    public void minimumNumberOfFrogsCroaking() {
        MinimumNumberOfFrogsCroaking mnofc = new MinimumNumberOfFrogsCroaking();

        System.out.println("1 == " + mnofc.minNumberOfFrogs("croakcroak"));
        System.out.println("2 == " + mnofc.minNumberOfFrogs("crcoakroak"));
        System.out.println("-1 == " + mnofc.minNumberOfFrogs("croakcrook"));
    }

    public void cinemaSeatAllocation() {
        CinemaSeatAllocation csa = new CinemaSeatAllocation();

        System.out.println("4 == " + csa.maxNumberOfFamilies(3, new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}}));
        System.out.println("2 == " + csa.maxNumberOfFamilies(2, new int[][]{{2,1},{1,8},{2,6}}));
        System.out.println("4 == " + csa.maxNumberOfFamilies(4, new int[][]{{4,3},{1,4},{4,6},{1,7}}));
        System.out.println("1 == " + csa.maxNumberOfFamilies(1, new int[][]{{1,3},{1,4}}));
        System.out.println("1 == " + csa.maxNumberOfFamilies(1, new int[][]{{1,1},{1,6},{1,10}}));
        System.out.println("2000000000 == " + csa.maxNumberOfFamilies(1000000000, new int[][]{{1,1}}));
        System.out.println("6 == " + csa.maxNumberOfFamilies(6, new int[][]{{1,1},{1,4},{1,9},{2,7},{3,10},{4,5},{5,2},{5,5},{6,6}}));
        System.out.println("5 == " + csa.maxNumberOfFamilies(3, new int[][]{{2,3}}));
        System.out.println("15548 == " + csa.maxNumberOfFamilies(7778, new int[][]{{80,6},{10,8},{63,10},{72,4},{98,3},{73,7},{35,9},{15,2},{110,8}}));
        System.out.println("232 == " + csa.maxNumberOfFamilies(120, new int[][]{{80,6},{10,8},{63,10},{72,4},{98,3},{73,7},{35,9},{15,2},{110,8}}));
    }

    public void jumpGameVII() {
        JumpGameVII jgvii = new JumpGameVII();

        System.out.println("true == " + jgvii.canReach("011010", 2, 3));
        System.out.println("false == " + jgvii.canReach("01101110", 2, 3));
        System.out.println("false == " + jgvii.canReach("010100110010101010101010101001111010101010101001", 2, 3));
        System.out.println("false == " + jgvii.canReach("010100110010101010101010101001111010101010101000", 2, 3));
        System.out.println("false == " + jgvii.canReach("01", 1, 1));
        System.out.println("true == " + jgvii.canReach("00", 1, 1));
    }

    public void maximumNumberOfWeeksForWhichYouCanWork() {
        MaximumNumberOfWeeksForWhichYouCanWork mnowfwycw = new MaximumNumberOfWeeksForWhichYouCanWork();

        System.out.println("6 == " + mnowfwycw.numberOfWeeks(new int[]{1,2,3}));
        System.out.println("7 == " + mnowfwycw.numberOfWeeks(new int[]{5,2,1}));
        System.out.println("193 == " + mnowfwycw.numberOfWeeks(new int[]{1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,32,1,1,2,3,4,5,6,7,6,5,4,3,32,1,1,2}));
        System.out.println("5 == " + mnowfwycw.numberOfWeeks(new int[]{1,1,1,1,1}));
        System.out.println("4 == " + mnowfwycw.numberOfWeeks(new int[]{1,1,1,1}));
        System.out.println("10 == " + mnowfwycw.numberOfWeeks(new int[]{2,2,2,2,2}));
        System.out.println("8 == " + mnowfwycw.numberOfWeeks(new int[]{2,2,2,2}));
        System.out.println("9 == " + mnowfwycw.numberOfWeeks(new int[]{1,1,1,2,2,2}));

    }

    public void stoneGameVII() {
        StoneGameVII sgvii = new StoneGameVII();

        System.out.println("2 == " + sgvii.stoneGameVII(new int[]{1,4,2}));
        System.out.println("6 == " + sgvii.stoneGameVII(new int[]{5,3,1,4,2}));
        System.out.println("7 == " + sgvii.stoneGameVII(new int[]{5,3,1,4}));
        System.out.println("1 == " + sgvii.stoneGameVII(new int[]{3,1,4}));
        System.out.println("3 == " + sgvii.stoneGameVII(new int[]{5,3,1}));
        System.out.println("122 == " + sgvii.stoneGameVII(new int[]{7,90,5,1,100,10,10,2}));
        System.out.println("55 == " + sgvii.stoneGameVII(new int[]{5,6,7,8,9,7,6,5,4,3,2,1,2,3,4,5,6,7,8,8}));
    }

    public void numberOfOrdersInTheBacklog() {
        NumberOfOrdersInTheBacklog nooitb = new NumberOfOrdersInTheBacklog();

        System.out.println("6 == " + nooitb.getNumberOfBacklogOrders(new int[][]{{10,5,0},{15,2,1},{25,1,1},{30,4,0}}));
        System.out.println("999999984 == " + nooitb.getNumberOfBacklogOrders(new int[][]{{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}}));
    }

    public void maximumLengthOfAConcatenatedStringWithUniqueCharacters() {
        MaximumLengthOfAConcatenatedStringWithUniqueCharacters mloacswuc = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters();

        System.out.println("4 == " + mloacswuc.maxLength(List.of("un","iq","ue")));
        System.out.println("6 == " + mloacswuc.maxLength(List.of("cha","r","act","ers")));
        System.out.println("26 == " + mloacswuc.maxLength(List.of("abcdefghijklmnopqrstuvwxyz")));
        System.out.println("16 == " + mloacswuc.maxLength(List.of("ab","ba","cd","dc","ef","fe","gh","hg","ij","ji","kl","lk","mn","nm","op","po")));
    }

    public void theTimeWhenTheNetworkBecomesIdle() {
        TheTimeWhenTheNetworkBecomesIdle ttwtnbi = new TheTimeWhenTheNetworkBecomesIdle();

        System.out.println("8 == " + ttwtnbi.networkBecomesIdle(new int[][]{{0,1},{1,2}}, new int[]{0,2,1}));
        System.out.println("3 == " + ttwtnbi.networkBecomesIdle(new int[][]{{0,1},{0,2},{1,2}}, new int[]{0,10,10}));
        System.out.println("20 == " + ttwtnbi.networkBecomesIdle(new int[][]{{0,1},{1,2},{0,3},{3,4},{2,4},{2,5},{6,5},{4,7},{4,8},{7,9},{8,11},{9,10}}, new int[]{0,2,3,4,3,2,4,4,6,3,3,3}));
    }

    public void outOfBoundaryPaths() {
        OutOfBoundaryPaths oobp = new OutOfBoundaryPaths();

        System.out.println("6 == " + oobp.findPaths(2, 2, 2, 0, 0));
        System.out.println("12 == " + oobp.findPaths(1, 3, 3, 0, 1));
    }

    public void reachableNodesWithRestrictions() {
        ReachableNodesWithRestrictions rnwr = new ReachableNodesWithRestrictions();

        System.out.println("4 == " + rnwr.reachableNodes(7, new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}}, new int[]{4,5}));
        System.out.println("3 == " + rnwr.reachableNodes(7, new int[][]{{0,1},{0,2},{0,5},{0,4},{3,2},{6,5}}, new int[]{4,2,1}));
        System.out.println("1 == " + rnwr.reachableNodes(2, new int[][]{{0,1}}, new int[]{1}));
    }

    public void divideIntervalsIntoMinimumNumberOfGroups() {
        DivideIntervalsIntoMinimumNumberOfGroups diimnog = new DivideIntervalsIntoMinimumNumberOfGroups();

        System.out.println("3 == " + diimnog.minGroups(new int[][]{{5,10},{6,8},{1,5},{2,3},{1,10}}));
        System.out.println("1 == " + diimnog.minGroups(new int[][]{{1,3},{5,6},{8,10},{11,13}}));
    }

    public void twoBestNonOverlappingEvents() {
        TwoBestNonOverlappingEvents tbnoe = new TwoBestNonOverlappingEvents();

        System.out.println("4 == " + tbnoe.maxTwoEvents(new int[][]{{1,3,2},{4,5,2},{2,4,3}}));
        System.out.println("5 == " + tbnoe.maxTwoEvents(new int[][]{{1,3,2},{4,5,2},{1,5,5}}));
        System.out.println("8 == " + tbnoe.maxTwoEvents(new int[][]{{1,5,3},{1,5,1},{6,6,5}}));
    }
}
