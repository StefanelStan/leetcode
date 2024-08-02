package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.august.ClearDigits;
import com.ss.leetcode.LC2024.august.DistributeElementsIntoTwoArraysI;
import com.ss.leetcode.LC2024.august.FindTheMinimumAreaToCoverAllOnesI;
import java.util.Arrays;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

//        start.findTheMinimumAreaToCoverAllOnesI();
//        start.distributeElementsIntoTwoArraysI();
        start.clearDigits();
    }

    public void findTheMinimumAreaToCoverAllOnesI() {
        FindTheMinimumAreaToCoverAllOnesI ftmatcaoi = new FindTheMinimumAreaToCoverAllOnesI();

        System.out.println("6 == " + ftmatcaoi.minimumArea(new int[][]{{0,1,0}, {1,0,1}}));
        System.out.println("1 == " + ftmatcaoi.minimumArea(new int[][]{{1,0}, {0,0}}));
    }

    public void distributeElementsIntoTwoArraysI() {
        DistributeElementsIntoTwoArraysI deitai = new DistributeElementsIntoTwoArraysI();

        System.out.println("[2,3,1] == " + Arrays.toString(deitai.resultArray(new int[]{2,1,3})));
        System.out.println("[5,3,4,8] == " + Arrays.toString(deitai.resultArray(new int[]{5,4,3,8})));
    }

    public void clearDigits() {
        ClearDigits cd = new ClearDigits();

        System.out.println("abc == " + cd.clearDigits("abc"));
        System.out.println(" == " + cd.clearDigits("cb34"));
    }
}
