package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.november.BuildAnArrayWithStackOperations;
import com.ss.leetcode.LC2023.november.BusRoutes;
import com.ss.leetcode.LC2023.november.CountTheNumberOfGoodSubarrays;
import com.ss.leetcode.LC2023.november.DesignGraphWithShortestPathCalculator;
import com.ss.leetcode.LC2023.november.DetermineIfACellIsReachableAtAGivenTime;
import com.ss.leetcode.LC2023.november.FindTheWinnerOfAnArrayGame;
import com.ss.leetcode.LC2023.november.LastMomentBeforeAllAntsFallOutOfAPlank;
import com.ss.leetcode.LC2023.november.MaximumElementAfterDecreasingAndRearranging;
import com.ss.leetcode.LC2023.november.NumberOfSubstringsContainingAllThreeCharacters;
import com.ss.leetcode.LC2023.november.SortVowelsInAString;
import com.ss.leetcode.LC2023.november.Two2KeysKeyboard;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

//        start.buildAnArrayWithStackOperations();
//        start.countTheNumberOfGoodSubarrays();
//        start.lastMomentBeforeAllAntsFallOutOfAPlank();
//        start.findTheWinnerOfAnArrayGame();
//        start.two2KeysKeyboard();
//        start.determineIfACellIsReachableAtAGivenTime();
//        start.numberOfSubstringsContainingAllThreeCharacters();
//        start.designGraphWithShortestPathCalculator();
//        start.busRoutes();
//        start.sortVowelsInAString();
        start.maximumElementAfterDecreasingAndRearranging();
    }

    public void buildAnArrayWithStackOperations() {
        BuildAnArrayWithStackOperations baawso = new BuildAnArrayWithStackOperations();

        System.out.println("[Push,Push,Pop,Push] == " + baawso.buildArray(new int[]{1,3}, 3));
        System.out.println("[Push,Push,Push] == " + baawso.buildArray(new int[]{1,2,3}, 3));
        System.out.println("[Push,Push] == " + baawso.buildArray(new int[]{1,2}, 4));
    }

    public void countTheNumberOfGoodSubarrays() {
        CountTheNumberOfGoodSubarrays ctnogs = new CountTheNumberOfGoodSubarrays();

        System.out.println("1 == " + ctnogs.countGood(new int[]{1,1,1,1,1}, 10));
        System.out.println("4 == " + ctnogs.countGood(new int[]{3,1,4,3,2,2,4}, 2));
        System.out.println("446 == " + ctnogs.countGood(new int[]{3,1,4,3,2,2,1,3,4,3,2,1,2,3,4,5,6,5,4,3,2,1,2,3,4,5,6,7,8,7,2,6,5,4,3,4,2,4}, 4));
    }

    public void lastMomentBeforeAllAntsFallOutOfAPlank() {
        LastMomentBeforeAllAntsFallOutOfAPlank lmbaafoap = new LastMomentBeforeAllAntsFallOutOfAPlank();

        System.out.println("4 == " + lmbaafoap.getLastMoment(4, new int[]{4,3}, new int[]{0,1}));
        System.out.println("7 == " + lmbaafoap.getLastMoment(7, new int[0], new int[]{0,1,2,3,4,5,6,7}));
    }

    public void findTheWinnerOfAnArrayGame() {
        FindTheWinnerOfAnArrayGame ftwoaag = new FindTheWinnerOfAnArrayGame();

        System.out.println("5 == " + ftwoaag.getWinner(new int[]{2,1,3,5,4,6,7}, 2));
        System.out.println("3 == " + ftwoaag.getWinner(new int[]{3,2,1}, 10));
    }

    public void two2KeysKeyboard() {
        Two2KeysKeyboard t2kk = new Two2KeysKeyboard();

        System.out.println("3 == " + t2kk.minSteps(3));
        System.out.println("0 == " + t2kk.minSteps(1));
        System.out.println("334 == " + t2kk.minSteps(993));
    }

    public void determineIfACellIsReachableAtAGivenTime() {
        DetermineIfACellIsReachableAtAGivenTime diaciraagt = new DetermineIfACellIsReachableAtAGivenTime();

        System.out.println("true == " + diaciraagt.isReachableAtTime(2, 4, 7, 7, 6));
        System.out.println("false == " + diaciraagt.isReachableAtTime(3, 1, 7, 3, 3));
        System.out.println("false == " + diaciraagt.isReachableAtTime(4, 4, 4, 4, 1));
        System.out.println("true == " + diaciraagt.isReachableAtTime(4, 4, 4, 4, 2));
    }

    public void numberOfSubstringsContainingAllThreeCharacters() {
        NumberOfSubstringsContainingAllThreeCharacters noscatc = new NumberOfSubstringsContainingAllThreeCharacters();

        System.out.println("10 == " + noscatc.numberOfSubstrings("abcabc"));
        System.out.println("3 == " + noscatc.numberOfSubstrings("aaacb"));
        System.out.println("1 == " + noscatc.numberOfSubstrings("abc"));
    }

    public void designGraphWithShortestPathCalculator() {
        DesignGraphWithShortestPathCalculator dgwspc = new DesignGraphWithShortestPathCalculator(13, new int[][]{{7,2,10},
            {9,4,62},{9,1,85},{1,3,39},{10,2,46},{6,7,9},{1,4,26},{8,0,84},{6,4,82},{10,3,56},{5,6,40},{4,7,88},{12,1,57},
            {8,5,79},{10,9,68},{1,6,67},{3,6,97},{0,10,26},{1,11,59},{0,12,37},{11,5,57},{6,2,32},{5,1,82},{3,8,14},{2,9,97},
            {7,0,10},{11,8,54},{3,11,6},{1,0,21}});

        System.out.println("124 == " + dgwspc.shortestPath(9,3));
    }

    public void busRoutes() {
        BusRoutes br = new BusRoutes();

        System.out.println("2 == " + br.numBusesToDestination(new int[][]{{1,2,7},{3,6,7}}, 1, 6));
        System.out.println("-1 == " + br.numBusesToDestination(new int[][]{{7,12},{4,5,15},{6},{15,19}}, 15, 12));
        System.out.println("0 == " + br.numBusesToDestination(new int[][]{{1,7},{3,5}}, 5, 5));
        System.out.println("0 == " + br.numBusesToDestination(new int[][]{{1,7},{3,5}}, 6, 6));
    }

    public void sortVowelsInAString() {
        SortVowelsInAString svias = new SortVowelsInAString();

        System.out.println("lEOtcede == " + svias.sortVowels("lEetcOde"));
        System.out.println("lYmpH == " + svias.sortVowels("lYmpH"));
    }

    public void maximumElementAfterDecreasingAndRearranging() {
        MaximumElementAfterDecreasingAndRearranging meadar = new MaximumElementAfterDecreasingAndRearranging();

        System.out.println("2 == " + meadar.maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}));
        System.out.println("3 == " + meadar.maximumElementAfterDecrementingAndRearranging(new int[]{100,1,1000}));
        System.out.println("5 == " + meadar.maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5}));
    }
}
