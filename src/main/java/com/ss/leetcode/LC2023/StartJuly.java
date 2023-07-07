package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.july.FindTheKthLargestIntegerInTheArray;
import com.ss.leetcode.LC2023.july.LongestEvenOddSubarrayWithThreshold;
import com.ss.leetcode.LC2023.july.MaximizeTheConfusionOfAnExam;
import com.ss.leetcode.LC2023.july.TotalDistanceTraveled;
import com.ss.leetcode.LC2023.july.UniqueSubstringsInWraparoundString;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

//        start.uniqueSubstringsInWraparoundString();
//        start.totalDistanceTraveled();
//        start.findTheKthLargestIntegerInTheArray();
//        start.maximizeTheConfusionOfAnExam();
        start.longestEvenOddSubarrayWithThreshold();
    }

    public void uniqueSubstringsInWraparoundString() {
        UniqueSubstringsInWraparoundString usiws = new UniqueSubstringsInWraparoundString();

        System.out.println("1 == " + usiws.findSubstringInWraproundString("a"));
        System.out.println("2 == " + usiws.findSubstringInWraproundString("cac"));
        System.out.println("6 == " + usiws.findSubstringInWraproundString("zab"));
    }

    public void totalDistanceTraveled() {
        TotalDistanceTraveled tdt = new TotalDistanceTraveled();
        String[]  strings = {"a", "b"};
        System.out.println("60 == " + tdt.distanceTraveled(5, 10));
        System.out.println("10 == " + tdt.distanceTraveled(1, 2));
        System.out.println("820 == " + tdt.distanceTraveled(70, 12));
    }

    public void findTheKthLargestIntegerInTheArray() {
        FindTheKthLargestIntegerInTheArray ftkliata = new FindTheKthLargestIntegerInTheArray();

        System.out.println("3 == " + ftkliata.kthLargestNumber(new String[]{"3","6","7","10"}, 4));
        System.out.println("2 == " + ftkliata.kthLargestNumber(new String[]{"2","21","12","1"}, 3));
        System.out.println("2 == " + ftkliata.kthLargestNumber(new String[]{"0","0"}, 2));
    }

    public void maximizeTheConfusionOfAnExam() {
        MaximizeTheConfusionOfAnExam mtcoaa = new MaximizeTheConfusionOfAnExam();

        System.out.println("4 == " + mtcoaa.maxConsecutiveAnswers("TTFF", 2));
        System.out.println("3 == " + mtcoaa.maxConsecutiveAnswers("TFFT", 1));
        System.out.println("5 == " + mtcoaa.maxConsecutiveAnswers("TTFTTFTT", 1));
    }

    public void longestEvenOddSubarrayWithThreshold() {
        LongestEvenOddSubarrayWithThreshold leoswt = new LongestEvenOddSubarrayWithThreshold();

        System.out.println("3 == " + leoswt.longestAlternatingSubarray(new int[]{3,2,5,4}, 5));
        System.out.println("1 == " + leoswt.longestAlternatingSubarray(new int[]{1,2}, 2));
        System.out.println("3 == " + leoswt.longestAlternatingSubarray(new int[]{2,3,4,5}, 4));
        System.out.println("1 == " + leoswt.longestAlternatingSubarray(new int[]{2,8}, 4));
    }
}
