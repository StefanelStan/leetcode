package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.november.BuildAnArrayWithStackOperations;
import com.ss.leetcode.LC2023.november.CountTheNumberOfGoodSubarrays;
import com.ss.leetcode.LC2023.november.DetermineIfACellIsReachableAtAGivenTime;
import com.ss.leetcode.LC2023.november.FindTheWinnerOfAnArrayGame;
import com.ss.leetcode.LC2023.november.LastMomentBeforeAllAntsFallOutOfAPlank;
import com.ss.leetcode.LC2023.november.Two2KeysKeyboard;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

//        start.buildAnArrayWithStackOperations();
//        start.countTheNumberOfGoodSubarrays();
//        start.lastMomentBeforeAllAntsFallOutOfAPlank();
//        start.findTheWinnerOfAnArrayGame();
//        start.two2KeysKeyboard();
        start.determineIfACellIsReachableAtAGivenTime();
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
}
