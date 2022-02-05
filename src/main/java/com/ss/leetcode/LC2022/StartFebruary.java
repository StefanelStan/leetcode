package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.february.FourSumII;
import com.ss.leetcode.LC2022.february.KeepMultiplyingFoundValuesByTwo;
import com.ss.leetcode.LC2022.february.MinimumCostToSetCookingTime;
import com.ss.leetcode.LC2022.february.MinimumSumOfFourDigitNumberAfterSplittingDigits;
import com.ss.leetcode.LC2022.february.PartitionArrayAccordingToGivenPivot;

import java.util.Arrays;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

//        start.keepMultiplyingFoundValuesByTwo();
//        start.fourSumII();
//        start.minimumSumOfFourDigitNumberAfterSplittingDigits();
//        start.partitionArrayAccordingToGivenPivot();
        start.minimumCostToSetCookingTime();
    }

    public void keepMultiplyingFoundValuesByTwo() {
        KeepMultiplyingFoundValuesByTwo kmfvbt = new KeepMultiplyingFoundValuesByTwo();

        System.out.println("24 == " + kmfvbt.findFinalValue(new int[]{5,3,6,1,12}, 3));
        System.out.println("4 == " + kmfvbt.findFinalValue(new int[]{2,7,9}, 4));
    }

    public void fourSumII() {
        FourSumII fsii = new FourSumII();

        System.out.println("2 == " + fsii.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
        System.out.println("1 == " + fsii.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
        System.out.println("17 == " + fsii.fourSumCount(new int[]{0,1,-1}, new int[]{-1,1,0}, new int[]{0,0,1}, new int[]{-1,1,1}));
    }

    public void minimumSumOfFourDigitNumberAfterSplittingDigits() {
        MinimumSumOfFourDigitNumberAfterSplittingDigits msofdnafd = new MinimumSumOfFourDigitNumberAfterSplittingDigits();

        System.out.println("52 == " + msofdnafd.minimumSum(2932));
        System.out.println("13 == " + msofdnafd.minimumSum(4009));
        System.out.println("1 == " + msofdnafd.minimumSum(1000));
        System.out.println("2 == " + msofdnafd.minimumSum(1001));
    }

    public void partitionArrayAccordingToGivenPivot() {
        PartitionArrayAccordingToGivenPivot paatgp = new PartitionArrayAccordingToGivenPivot();

        System.out.println("[9,5,3,10,10,12,14] == " + Arrays.toString(paatgp.pivotArray(new int[]{9,12,5,10,14,3,10}, 10)));
        System.out.println("[-3,2,4,3] == " + Arrays.toString(paatgp.pivotArray(new int[]{-3,4,3,2}, 2)));
        System.out.println("[4,10,12] == " + Arrays.toString(paatgp.pivotArray(new int[]{12, 10, 4}, 10)));
        System.out.println("[10,12,12,12] == " + Arrays.toString(paatgp.pivotArray(new int[]{12,12,12,10}, 10)));
    }

    public void minimumCostToSetCookingTime() {
        MinimumCostToSetCookingTime mctsct = new MinimumCostToSetCookingTime();

        System.out.println("6 == " + mctsct.minCostSetTime(0, 2, 1, 600));
        System.out.println("6 == " + mctsct.minCostSetTime(0, 1, 2, 76));
    }
}
