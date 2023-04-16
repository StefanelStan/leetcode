package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.april.ArrayWithElementsNotEqualToAverageOfNeighbors;
import com.ss.leetcode.LC2023.april.ChangeMinimumCharactersToSatisfyOneOfThreeConditions;
import com.ss.leetcode.LC2023.april.CheckIfThereIsAValidPathInAGrid;
import com.ss.leetcode.LC2023.april.ConvertAnArrayIntoA2DArrayWithConditions;
import com.ss.leetcode.LC2023.april.CourseSchedule;
import com.ss.leetcode.LC2023.april.DestroyingAsteroids;
import com.ss.leetcode.LC2023.april.FindTheLongestBalancedSubstringOfABinaryString;
import com.ss.leetcode.LC2023.april.FindTheSubstringWithMaximumCost;
import com.ss.leetcode.LC2023.april.FormSmallestNumberFromTwoDigitArrays;
import com.ss.leetcode.LC2023.april.MaximumDistanceBetweenAPairOfValues;
import com.ss.leetcode.LC2023.april.MaximumScoreFromRemovingStones;
import com.ss.leetcode.LC2023.april.MaximumSumObtainedOfAnyPermutation;
import com.ss.leetcode.LC2023.april.MinimizeMaximumOfArray;
import com.ss.leetcode.LC2023.april.MinimumMovesToReachTargetScore;
import com.ss.leetcode.LC2023.april.NumberOfEnclaves;
import com.ss.leetcode.LC2023.april.RearrangeSpacesBetweenWords;
import com.ss.leetcode.LC2023.april.SellDiminishingValuedColoredBalls;
import com.ss.leetcode.LC2023.april.ShortestCycle;
import com.ss.leetcode.LC2023.april.SimplifyPath;
import java.util.Arrays;

public class StartApril {
    public static void main(String[] args) {
        StartApril start = new StartApril();

//        start.formSmallestNumberFromTwoDigitArrays();
//        start.findTheSubstringWithMaximumCost();
//        start.shortestCycle();
//        start.sellDiminishingValuedColoredBalls();
//        start.maximumSumObtainedOfAnyPermutation();
//        start.minimizeMaximumOfArray();
//        start.rearrangeSpacesBetweenWords();
//        start.changeMinimumCharactersToSatisfyOneOfThreeConditions();
//        start.numberOfEnclaves();
//        start.maximumDistanceBetweenAPairOfValues();
//        start.destroyingAsteroids();
//        start.courseSchedule();
//        start.simplifyPath();
//        start.checkIfThereIsAValidPathInAGrid();
//        start.convertAnArrayIntoA2DArrayWithConditions();
//        start.maximumScoreFromRemovingStones();
//        start.arrayWithElementsNotEqualToAverageOfNeighbors();
//        start.findTheLongestBalancedSubstringOfABinaryString();
        start.minimumMovesToReachTargetScore();
    }

    public void formSmallestNumberFromTwoDigitArrays() {
        FormSmallestNumberFromTwoDigitArrays fsnftda = new FormSmallestNumberFromTwoDigitArrays();

        System.out.println("15 == " + fsnftda.minNumber(new int[]{4,1,3}, new int[]{5,7}));
        System.out.println("3 == " + fsnftda.minNumber(new int[]{3,5,2,6}, new int[]{3,1,7}));
    }

    public void findTheSubstringWithMaximumCost() {
        FindTheSubstringWithMaximumCost ftswmc = new FindTheSubstringWithMaximumCost();

        System.out.println("2 == " + ftswmc.maximumCostSubstring("adaa", "d", new int[]{-1000}));
        System.out.println("0 == " + ftswmc.maximumCostSubstring("abc", "abc", new int[]{-1,-1,-1}));
    }

    public void shortestCycle() {
        ShortestCycle ss = new ShortestCycle();

        System.out.println("3 == " + ss.findShortestCycle(7, new int[][]{{0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}}));
        System.out.println("-1 == " + ss.findShortestCycle(4, new int[][]{{0,1},{0,2}}));
    }

    public void sellDiminishingValuedColoredBalls() {
        SellDiminishingValuedColoredBalls sdvcb = new SellDiminishingValuedColoredBalls();

        System.out.println("6 == " + sdvcb.maxProfit(new int[]{2,2}, 4));
        System.out.println("19 == " + sdvcb.maxProfit(new int[]{3,5}, 6));
        System.out.println("19 == " + sdvcb.maxProfit(new int[]{3,5}, 6));
        System.out.println("21 == " + sdvcb.maxProfit(new int[]{1000000000}, 1000000000));
        System.out.println("18 == " + sdvcb.maxProfit(new int[]{4,2,1,5,9,9,9,8,7,6,5,4}, 2));
        System.out.println("27 == " + sdvcb.maxProfit(new int[]{4,2,1,5,9,9,9,8,7,6,5,4}, 3));
        System.out.println("100 == " + sdvcb.maxProfit(new int[]{4,2,1,5,9,9,9,8,7,6,5,4}, 13));
        System.out.println("155 == " + sdvcb.maxProfit(new int[]{4,2,1,5,9,9,9,8,7,6,5,4}, 23));
    }

    public void maximumSumObtainedOfAnyPermutation() {
        MaximumSumObtainedOfAnyPermutation msooap = new MaximumSumObtainedOfAnyPermutation();

        System.out.println("19 == " + msooap.maxSumRangeQuery(new int[]{1,2,3,4,5}, new int[][]{{1,3}, {0,1}}));
        System.out.println("11 == " + msooap.maxSumRangeQuery(new int[]{1,2,3,4,5,6}, new int[][]{{0,1}}));
        System.out.println("47 == " + msooap.maxSumRangeQuery(new int[]{1,2,3,4,5,10}, new int[][]{{0,2},{1,3},{1,1}}));
    }

    public void minimizeMaximumOfArray() {
        MinimizeMaximumOfArray mmoa = new MinimizeMaximumOfArray();

        System.out.println("5 == " + mmoa.minimizeArrayValue(new int[]{3,7,1,6}));
        System.out.println("10 == " + mmoa.minimizeArrayValue(new int[]{10,1}));
    }

    public void rearrangeSpacesBetweenWords() {
        RearrangeSpacesBetweenWords rsbw = new RearrangeSpacesBetweenWords();

        System.out.println("this   is   a   sentence == " + rsbw.reorderSpaces("  this   is  a sentence "));
        System.out.println("practice   makes   perfect  == " + rsbw.reorderSpaces(" practice   makes   perfect"));
        System.out.println("john        == " + rsbw.reorderSpaces("   john     "));
        System.out.println("doe       == " + rsbw.reorderSpaces("doe      "));
        System.out.println("r        == " + rsbw.reorderSpaces("       r"));
    }

    public void changeMinimumCharactersToSatisfyOneOfThreeConditions() {
        ChangeMinimumCharactersToSatisfyOneOfThreeConditions cmctsoftc = new ChangeMinimumCharactersToSatisfyOneOfThreeConditions();

        System.out.println("2 == " + cmctsoftc.minCharacters("aba", "caa"));
        System.out.println("3 == " + cmctsoftc.minCharacters("dabadd", "cda"));
        System.out.println("0 == " + cmctsoftc.minCharacters("zzzzzzzz", "cda"));
        System.out.println("0 == " + cmctsoftc.minCharacters("a", "a"));
        System.out.println("33 == " + cmctsoftc.minCharacters("dsfgsdfsdfdsfsdfsdfsdfsdfsdfdffdfsd", "yujgujthdfgsdfsdfgrtgfdgdjguohniufvhwsydfigywekjdfnwaoidfmsmsufignfiweuhdus"));
        System.out.println("52 == " + cmctsoftc.minCharacters("zzzzzzaaaaaazzzzzaaaaaabcdefghjijlopqrstuwxxxyyyyzzz", "zzzzzzaaaaaazzzzzaaaaaabcdefghjijlopqrstuwxxxyyyyzzz"));
    }

    public void numberOfEnclaves() {
        NumberOfEnclaves noe = new NumberOfEnclaves();

        System.out.println("3 == " + noe.numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
        System.out.println("0 == " + noe.numEnclaves(new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}}));
        System.out.println("5 == " + noe.numEnclaves(new int[][]{{0,0,0,0,1},{1,0,1,0,0},{0,1,1,1,0},{0,1,0,0,1},{1,0,0,1,0}}));
        System.out.println("0 == " + noe.numEnclaves(new int[][]{{1}}));
        System.out.println("1 == " + noe.numEnclaves(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println("0 == " + noe.numEnclaves(new int[][]{{0}}));
    }

    public void maximumDistanceBetweenAPairOfValues() {
        MaximumDistanceBetweenAPairOfValues mdbapov = new MaximumDistanceBetweenAPairOfValues();

        System.out.println("2 == " + mdbapov.maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}));
        System.out.println("1 == " + mdbapov.maxDistance(new int[]{2,2,2}, new int[]{10,10,1}));
        System.out.println("2 == " + mdbapov.maxDistance(new int[]{30,29,19,5}, new int[]{25,25,25,25,25}));
        System.out.println("0 == " + mdbapov.maxDistance(new int[]{121,111,101,99,88,77,66,55,30,5,4,2}, new int[]{131,100,20,10,10,5}));
        System.out.println("4 == " + mdbapov.maxDistance(new int[]{121,111,101,99,88,77,66,55,30,5,4,2}, new int[]{151,141,131,100,20,10,10,5,5,5,4,4,3,3,2,2,1,1}));
        System.out.println("0 == " + mdbapov.maxDistance(new int[]{1}, new int[]{2}));
        System.out.println("6 == " + mdbapov.maxDistance(new int[]{3,3,3,3,3,3,3,3}, new int[]{4,4,4,4,4,4,4,1}));
    }

    public void destroyingAsteroids() {
        DestroyingAsteroids da = new DestroyingAsteroids();

        System.out.println("true == " + da.asteroidsDestroyed(10, new int[]{3,9,19,5,21}));
        System.out.println("false == " + da.asteroidsDestroyed(5, new int[]{4,9,23,4}));
        System.out.println("true == " + da.asteroidsDestroyed(5, new int[]{4,9,18,4,23,23,23,23,23,23,23}));
        System.out.println("true == " + da.asteroidsDestroyed(5, new int[]{5}));
        System.out.println("false == " + da.asteroidsDestroyed(5, new int[]{6}));
    }

    public void courseSchedule() {
        CourseSchedule cs = new CourseSchedule();

        System.out.println("true == " + cs.canFinish(2, new int[][]{{1,0}}));
        System.out.println("false == " + cs.canFinish(2, new int[][]{{1,0},{0,1}}));
        System.out.println("true == " + cs.canFinish(4, new int[0][0]));
    }

    public void simplifyPath() {
        SimplifyPath sp = new SimplifyPath();

        System.out.println("/home == " + sp.simplifyPath("/home/"));
        System.out.println("/ == " + sp.simplifyPath("/../"));
        System.out.println("/home/foo == " + sp.simplifyPath("/home//foo/"));
    }

    public void checkIfThereIsAValidPathInAGrid() {
        CheckIfThereIsAValidPathInAGrid citiavpiag = new CheckIfThereIsAValidPathInAGrid();

        System.out.println("true == " + citiavpiag.hasValidPath(new int[][]{{2,4,3},{6,5,2}}));
        System.out.println("false == " + citiavpiag.hasValidPath(new int[][]{{1,2,1},{1,2,1}}));
        System.out.println("false == " + citiavpiag.hasValidPath(new int[][]{{1,1,2}}));
        System.out.println("false == " + citiavpiag.hasValidPath(new int[][]{{2,4,3,3,1},{2,2,6,5,2}}));
        System.out.println("false == " + citiavpiag.hasValidPath(new int[][]{{1,1,1,5},{2,2,6,5,2}}));
        System.out.println("true == " + citiavpiag.hasValidPath(new int[][]{{1}}));
        System.out.println("true == " + citiavpiag.hasValidPath(new int[][]{{1}}));
        System.out.println("true == " + citiavpiag.hasValidPath(new int[][]{{3},{2},{2},{2},{6}}));
    }

    public void convertAnArrayIntoA2DArrayWithConditions() {
        ConvertAnArrayIntoA2DArrayWithConditions caaia2dawc = new ConvertAnArrayIntoA2DArrayWithConditions();

        System.out.println("[[1,3,4,2],[1,3],[1]] == " + caaia2dawc.findMatrix(new int[]{1,3,4,1,2,3,1}));
        System.out.println("[[4,3,2,1]] == " + caaia2dawc.findMatrix(new int[]{1,2,3,4}));
    }

    public void maximumScoreFromRemovingStones() {
        MaximumScoreFromRemovingStones msfrs = new MaximumScoreFromRemovingStones();

        System.out.println("6 == " + msfrs.maximumScore(2,4,6));
        System.out.println("7 == " + msfrs.maximumScore(4,4,6));
        System.out.println("9 == " + msfrs.maximumScore(1,8,8));
    }

    public void arrayWithElementsNotEqualToAverageOfNeighbors() {
        ArrayWithElementsNotEqualToAverageOfNeighbors awenetaon = new ArrayWithElementsNotEqualToAverageOfNeighbors();

        System.out.println("[5,2,1,4,3] == " + Arrays.toString(awenetaon.rearrangeArray(new int[]{1,2,3,4,5})));
        System.out.println("[0,2,6,7,9] == " + Arrays.toString(awenetaon.rearrangeArray(new int[]{6,2,0,9,7})));
    }

    public void findTheLongestBalancedSubstringOfABinaryString() {
        FindTheLongestBalancedSubstringOfABinaryString ftlbsoabs = new FindTheLongestBalancedSubstringOfABinaryString();

        System.out.println("6 == " + ftlbsoabs.findTheLongestBalancedSubstring("01000111"));
        System.out.println("4 == " + ftlbsoabs.findTheLongestBalancedSubstring("00111"));
        System.out.println("0 == " + ftlbsoabs.findTheLongestBalancedSubstring("111"));
    }

    public void minimumMovesToReachTargetScore() {
        MinimumMovesToReachTargetScore mmtrts = new MinimumMovesToReachTargetScore();

        System.out.println("4 == " + mmtrts.minMoves(5, 0));
        System.out.println("7 == " + mmtrts.minMoves(19, 2));
        System.out.println("4 == " + mmtrts.minMoves(10, 4));
    }
}
