package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.july.MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

        start.maximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();
    }

    public void maximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts() {
        MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts maoapocahavc = new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();

        System.out.println("4 == " + maoapocahavc.maxArea(5,4, new int[]{1,2,4}, new int[]{1,3}));
        System.out.println("6 == " + maoapocahavc.maxArea(5,4, new int[]{3,1}, new int[]{1}));
        System.out.println("9 == " + maoapocahavc.maxArea(5,4, new int[]{3}, new int[]{3}));
        System.out.println("321374711 == " + maoapocahavc.maxArea(10000000,10000000, new int[]{5,500000}, new int[]{239,597124}));
    }
}
