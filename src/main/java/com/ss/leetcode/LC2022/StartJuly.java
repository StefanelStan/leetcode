package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.july.Candy;
import com.ss.leetcode.LC2022.july.DecodeTheMessage;
import com.ss.leetcode.LC2022.july.MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

//        start.maximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();
//        start.decodeTheMessage();
        start.candy();
    }

    public void maximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts() {
        MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts maoapocahavc = new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();

        System.out.println("4 == " + maoapocahavc.maxArea(5,4, new int[]{1,2,4}, new int[]{1,3}));
        System.out.println("6 == " + maoapocahavc.maxArea(5,4, new int[]{3,1}, new int[]{1}));
        System.out.println("9 == " + maoapocahavc.maxArea(5,4, new int[]{3}, new int[]{3}));
        System.out.println("321374711 == " + maoapocahavc.maxArea(10000000,10000000, new int[]{5,500000}, new int[]{239,597124}));
    }

    public void decodeTheMessage() {
        DecodeTheMessage dtm = new DecodeTheMessage();

        System.out.println("this is a secret == " + dtm.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println("the five boxing wizards jump quickly == " + dtm.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }

    public void candy() {
        Candy c = new Candy();

//        System.out.println("5 == " + c.candy(new int[]{1,0,2}));
//        System.out.println("4 == " + c.candy(new int[]{1,2,2}));
        System.out.println("12 == " + c.candy(new int[]{29,51,87,87,72,12}));
    }
}
