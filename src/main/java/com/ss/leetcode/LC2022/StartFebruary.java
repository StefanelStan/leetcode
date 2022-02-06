package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.february.CountElementsWithStrictlySmallerAndGreaterElements;
import com.ss.leetcode.LC2022.february.DesignBitset;
import com.ss.leetcode.LC2022.february.FourSumII;
import com.ss.leetcode.LC2022.february.KeepMultiplyingFoundValuesByTwo;
import com.ss.leetcode.LC2022.february.MinimumCostToSetCookingTime;
import com.ss.leetcode.LC2022.february.MinimumSumOfFourDigitNumberAfterSplittingDigits;
import com.ss.leetcode.LC2022.february.PartitionArrayAccordingToGivenPivot;
import com.ss.leetcode.LC2022.february.SmallestValueOfTheRearrangedNumber;
import com.ss.leetcode.LC2022.february.SortEvenAndOddIndicesIndependently;

import java.util.Arrays;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

//        start.keepMultiplyingFoundValuesByTwo();
//        start.fourSumII();
//        start.minimumSumOfFourDigitNumberAfterSplittingDigits();
//        start.partitionArrayAccordingToGivenPivot();
//        start.minimumCostToSetCookingTime();
//        start.sortEvenAndOddIndicesIndependently();
//        start.smallestValueOfTheRearrangedNumber();
//        start.designBitset();
        start.countElementsWithStrictlySmallerAndGreaterElements();
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

    public void sortEvenAndOddIndicesIndependently() {
        SortEvenAndOddIndicesIndependently seaoii = new SortEvenAndOddIndicesIndependently();

        System.out.println("[2,3,4,1] == " + Arrays.toString(seaoii.sortEvenOdd(new int[]{4,1,2,3})));
        System.out.println("[2,1] == " + Arrays.toString(seaoii.sortEvenOdd(new int[]{2,1})));
        System.out.println("[2,3,4,1,7] == " + Arrays.toString(seaoii.sortEvenOdd(new int[]{4,1,2,3,7})));
    }

    public void smallestValueOfTheRearrangedNumber() {
        SmallestValueOfTheRearrangedNumber svotrn = new SmallestValueOfTheRearrangedNumber();

        System.out.println("103 == " + svotrn.smallestNumber(310));
        System.out.println("-7650 == " + svotrn.smallestNumber(-7605));
    }

    public void designBitset() {
        DesignBitset db = new DesignBitset(5);

        db.fix(3);     // the value at idx = 3 is updated to 1, so bitset = "00010".
        db.fix(1);     // the value at idx = 1 is updated to 1, so bitset = "01010".
        db.flip();     // the value of each bit is flipped, so bitset = "10101".
        System.out.println("false == " + db.all());      // return False, as not all values of the bitset are 1.
        db.unfix(0);   // the value at idx = 0 is updated to 0, so bitset = "00101".
        db.flip();     // the value of each bit is flipped, so bitset = "11010".
        System.out.println("true == " + db.one());      // return True, as there is at least 1 index with value 1.
        db.unfix(0);   // the value at idx = 0 is updated to 0, so bitset = "01010".
        System.out.println("2 == " + db.count());    // return 2, as there are 2 bits with value 1.
        System.out.println("01010 == " + db.toString()); // return "01010", which is the composition of bitset.
    }

    public void countElementsWithStrictlySmallerAndGreaterElements() {
        CountElementsWithStrictlySmallerAndGreaterElements cewssage = new CountElementsWithStrictlySmallerAndGreaterElements();

        System.out.println("2 == " + cewssage.countElements(new int[]{11,7,2,15}));
        System.out.println("2 == " + cewssage.countElements(new int[]{-3,3,3,90}));
        System.out.println("0 == " + cewssage.countElements(new int[]{-3,3}));
        System.out.println("0 == " + cewssage.countElements(new int[]{-3,3,3}));
    }
}
