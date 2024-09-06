package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.september.FindTheStudentThatWillReplaceTheChalk;
import com.ss.leetcode.LC2024.september.LargestSumOfAverages;
import com.ss.leetcode.LC2024.september.LexicographicallyMinimumStringAfterRemovingStars;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

//        start.findTheStudentThatWillReplaceTheChalk();
//        start.largestSumOfAverages();
        start.lexicographicallyMinimumStringAfterRemovingStars();
    }

    public void findTheStudentThatWillReplaceTheChalk() {
        FindTheStudentThatWillReplaceTheChalk ftstwrtc = new FindTheStudentThatWillReplaceTheChalk();

        System.out.println("0 == " + ftstwrtc.chalkReplacer(new int[]{5,1,5}, 22));
        System.out.println("1 == " + ftstwrtc.chalkReplacer(new int[]{3,4,1,2}, 25));
        System.out.println("13 == " + ftstwrtc.chalkReplacer(new int[]{3,1,2,3,4,5,6,5,45,3,2,1,2,43,5,78}, 123));
        System.out.println("4 == " + ftstwrtc.chalkReplacer(new int[]{3,1,2,3,4,5,6,5,45,3,2,1,2,43,5,78}, 12));
        System.out.println("3 == " + ftstwrtc.chalkReplacer(new int[]{3,1,2,3,4,5,6,5,45,3,2,1,2,43,5,78}, 812334231));
    }

    public void largestSumOfAverages() {
        LargestSumOfAverages lsoa = new LargestSumOfAverages();

        System.out.println("20.0 == " + lsoa.largestSumOfAverages(new int[]{9,1,2,3,9}, 3));
        System.out.println("20.5 == " + lsoa.largestSumOfAverages(new int[]{1,2,3,4,5,6,7}, 4));
    }

    public void lexicographicallyMinimumStringAfterRemovingStars() {
        LexicographicallyMinimumStringAfterRemovingStars lmsars = new LexicographicallyMinimumStringAfterRemovingStars();

        System.out.println("aab == " + lmsars.clearStars("aaba*"));
        System.out.println("abc == " + lmsars.clearStars("abc"));
    }
}
