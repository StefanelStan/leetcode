package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.june.ScoreOfAString;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

        start.scoreOfAString();
    }

    public void scoreOfAString() {
        ScoreOfAString soas = new ScoreOfAString();

        System.out.println("13 == " + soas.scoreOfString("hello"));
        System.out.println("50 == " + soas.scoreOfString("zaz"));
    }
}
