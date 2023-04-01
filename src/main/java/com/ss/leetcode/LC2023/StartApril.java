package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.april.FindTheSubstringWithMaximumCost;
import com.ss.leetcode.LC2023.april.FormSmallestNumberFromTwoDigitArrays;
import com.ss.leetcode.LC2023.april.SellDiminishingValuedColoredBalls;
import com.ss.leetcode.LC2023.april.ShortestCycle;

public class StartApril {
    public static void main(String[] args) {
        StartApril start = new StartApril();

//        start.formSmallestNumberFromTwoDigitArrays();
//        start.findTheSubstringWithMaximumCost();
//        start.shortestCycle();
        start.sellDiminishingValuedColoredBalls();
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
}
