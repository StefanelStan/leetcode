package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.february.KeepMultiplyingFoundValuesByTwo;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

        start.keepMultiplyingFoundValuesByTwo();
    }

    public void keepMultiplyingFoundValuesByTwo() {
        KeepMultiplyingFoundValuesByTwo kmfvbt = new KeepMultiplyingFoundValuesByTwo();

        System.out.println("24 == " + kmfvbt.findFinalValue(new int[]{5,3,6,1,12}, 3));
        System.out.println("4 == " + kmfvbt.findFinalValue(new int[]{2,7,9}, 4));
    }
}
