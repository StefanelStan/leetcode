package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.june.FindMinimumOperationsToMakeAllElementsDivisibleByThree;
import com.ss.leetcode.LC2024.june.MagneticForceBetweenTwoBalls;
import com.ss.leetcode.LC2024.june.MinimumIncrementToMakeArrayUnique;
import com.ss.leetcode.LC2024.june.MinimumMovesToCaptureTheQueen;
import com.ss.leetcode.LC2024.june.MinimumNumberOfKConsecutiveBitFlips;
import com.ss.leetcode.LC2024.june.ScoreOfAString;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

//        start.scoreOfAString();
//        start.minimumMovesToCaptureTheQueen();
//        start.minimumIncrementToMakeArrayUnique();
//        start.magneticForceBetweenTwoBalls();
//        start.findMinimumOperationsToMakeAllElementsDivisibleByThree();
        start.minimumNumberOfKConsecutiveBitFlips();
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

    public void minimumIncrementToMakeArrayUnique() {
        MinimumIncrementToMakeArrayUnique mitmau = new MinimumIncrementToMakeArrayUnique();

        System.out.println("1 == " + mitmau.minIncrementForUnique(new int[]{2,1,2}));
        System.out.println("6 == " + mitmau.minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }

    public void magneticForceBetweenTwoBalls() {
        MagneticForceBetweenTwoBalls mfbtb = new MagneticForceBetweenTwoBalls();

        System.out.println("3 == " + mfbtb.maxDistance(new int[]{7,4,1,3,2}, 3));
        System.out.println("999999999 == " + mfbtb.maxDistance(new int[]{5,4,3,2,1,1000000000}, 2));
    }

    public void findMinimumOperationsToMakeAllElementsDivisibleByThree() {
        FindMinimumOperationsToMakeAllElementsDivisibleByThree fmotmaedbt = new FindMinimumOperationsToMakeAllElementsDivisibleByThree();

        System.out.println("3 == " + fmotmaedbt.minimumOperations(new int[]{1,2,3,4}));
        System.out.println("0 == " + fmotmaedbt.minimumOperations(new int[]{3,6,9}));
        System.out.println("10 == " + fmotmaedbt.minimumOperations(new int[]{1,2,3,4,5,6,7,6,50,4,3,2,1,49}));
    }

    public void minimumNumberOfKConsecutiveBitFlips() {
        MinimumNumberOfKConsecutiveBitFlips mnokcbf = new MinimumNumberOfKConsecutiveBitFlips();

        System.out.println("2 == " + mnokcbf.minKBitFlips(new int[]{0,1,0}, 1));
        System.out.println("-1 == " + mnokcbf.minKBitFlips(new int[]{1,1,0}, 2));
        System.out.println("3 == " + mnokcbf.minKBitFlips(new int[]{0,0,0,1,0,1,1,0}, 3));
    }
}
