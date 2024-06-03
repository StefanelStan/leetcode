package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.june.MinimumMovesToCaptureTheQueen;
import com.ss.leetcode.LC2024.june.ScoreOfAString;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

//        start.scoreOfAString();
        start.minimumMovesToCaptureTheQueen();
    }

    public void scoreOfAString() {
        ScoreOfAString soas = new ScoreOfAString();

        System.out.println("13 == " + soas.scoreOfString("hello"));
        System.out.println("50 == " + soas.scoreOfString("zaz"));
    }

    public void minimumMovesToCaptureTheQueen() {
        MinimumMovesToCaptureTheQueen mmtctq = new MinimumMovesToCaptureTheQueen();

        System.out.println("2 == " + mmtctq.minMovesToCaptureTheQueen(1,1,8,8,2,3));
        System.out.println("1 == " + mmtctq.minMovesToCaptureTheQueen(5,3,3,4,5,2));
        System.out.println("2 == " + mmtctq.minMovesToCaptureTheQueen(4,3,3,4,5,2));
    }
}
