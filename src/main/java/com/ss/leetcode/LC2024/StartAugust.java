package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.august.FindTheMinimumAreaToCoverAllOnesI;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

        start.findTheMinimumAreaToCoverAllOnesI();
    }

    public void findTheMinimumAreaToCoverAllOnesI() {
        FindTheMinimumAreaToCoverAllOnesI ftmatcaoi = new FindTheMinimumAreaToCoverAllOnesI();

        System.out.println("6 == " + ftmatcaoi.minimumArea(new int[][]{{0,1,0}, {1,0,1}}));
        System.out.println("1 == " + ftmatcaoi.minimumArea(new int[][]{{1,0}, {0,0}}));
    }
}
