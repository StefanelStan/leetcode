package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.february.FourSumII;
import com.ss.leetcode.LC2022.february.KeepMultiplyingFoundValuesByTwo;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

//        start.keepMultiplyingFoundValuesByTwo();
        start.fourSumII();
    }

    public void keepMultiplyingFoundValuesByTwo() {
        KeepMultiplyingFoundValuesByTwo kmfvbt = new KeepMultiplyingFoundValuesByTwo();

        System.out.println("24 == " + kmfvbt.findFinalValue(new int[]{5,3,6,1,12}, 3));
        System.out.println("4 == " + kmfvbt.findFinalValue(new int[]{2,7,9}, 4));
    }

    public void fourSumII() {
        FourSumII fsii = new FourSumII();

        System.out.println("2 == " + fsii.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
        System.out.println("1 == " + fsii.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
        System.out.println("17 == " + fsii.fourSumCount(new int[]{0,1,-1}, new int[]{-1,1,0}, new int[]{0,0,1}, new int[]{-1,1,1}));
    }
}
