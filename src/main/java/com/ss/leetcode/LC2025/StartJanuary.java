package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.january.FindTheLexicographicallyLargestStringFromTheBoxI;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

        start.findTheLexicographicallyLargestStringFromTheBoxI();
    }

    public void findTheLexicographicallyLargestStringFromTheBoxI() {
        FindTheLexicographicallyLargestStringFromTheBoxI ftllsftbi = new FindTheLexicographicallyLargestStringFromTheBoxI();

        System.out.println("dbc == " + ftllsftbi.answerString("dbca", 2));
        System.out.println("g == " + ftllsftbi.answerString("gggg", 4));
    }
}
