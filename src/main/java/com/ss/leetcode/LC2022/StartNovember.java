package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.november.LargestPositiveIntegerThatExistsWithItsNegative;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

        start.largestPositiveIntegerThatExistsWithItsNegative();
    }


    public void largestPositiveIntegerThatExistsWithItsNegative() {
        LargestPositiveIntegerThatExistsWithItsNegative lpitewin = new LargestPositiveIntegerThatExistsWithItsNegative();

        System.out.println("3 == " + lpitewin.findMaxK(new int[]{-1,2,-3,3}));
        System.out.println("7 == " + lpitewin.findMaxK(new int[]{-1,10,6,7,-7,1}));
        System.out.println("-1 == " + lpitewin.findMaxK(new int[]{-10,8,6,7,-2,-3}));
    }
}
