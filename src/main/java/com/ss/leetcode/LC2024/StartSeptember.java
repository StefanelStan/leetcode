package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.september.FindTheStudentThatWillReplaceTheChalk;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

        start.findTheStudentThatWillReplaceTheChalk();
    }

    public void findTheStudentThatWillReplaceTheChalk() {
        FindTheStudentThatWillReplaceTheChalk ftstwrtc = new FindTheStudentThatWillReplaceTheChalk();

        System.out.println("0 == " + ftstwrtc.chalkReplacer(new int[]{5,1,5}, 22));
        System.out.println("1 == " + ftstwrtc.chalkReplacer(new int[]{3,4,1,2}, 25));
        System.out.println("13 == " + ftstwrtc.chalkReplacer(new int[]{3,1,2,3,4,5,6,5,45,3,2,1,2,43,5,78}, 123));
        System.out.println("4 == " + ftstwrtc.chalkReplacer(new int[]{3,1,2,3,4,5,6,5,45,3,2,1,2,43,5,78}, 12));
        System.out.println("3 == " + ftstwrtc.chalkReplacer(new int[]{3,1,2,3,4,5,6,5,45,3,2,1,2,43,5,78}, 812334231));
    }
}
