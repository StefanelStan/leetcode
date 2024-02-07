package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.february.AdditiveNumber;
import com.ss.leetcode.LC2024.february.CountElementsWithMaximumFrequency;
import com.ss.leetcode.LC2024.february.CountVowelSubstringsOfAString;
import com.ss.leetcode.LC2024.february.DivideArrayIntoArraysWithMaxDifference;
import com.ss.leetcode.LC2024.february.InsertDeleteGetRandomO1DuplicatesAllowed;
import com.ss.leetcode.LC2024.february.MaximumConsecutiveFloorsWithoutSpecialFloors;
import com.ss.leetcode.LC2024.february.MinimumWindowSubstring;
import com.ss.leetcode.LC2024.february.NumberOfSubarraysWithBoundedMaximum;
import com.ss.leetcode.LC2024.february.PartitionArrayForMaximumSum;
import java.util.Arrays;
import java.util.Set;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

//        start.divideArrayIntoArraysWithMaxDifference();
//        start.maximumConsecutiveFloorsWithoutSpecialFloors();
//        start.countVowelSubstringsOfAString();
//        start.partitionArrayForMaximumSum();
//        start.additiveNumber();
//        start.insertDeleteGetRandomO1DuplicatesAllowed();
//        start.minimumWindowSubstring();
//        start.numberOfSubarraysWithBoundedMaximum();
        start.countElementsWithMaximumFrequency();
    }

    public void divideArrayIntoArraysWithMaxDifference() {
        DivideArrayIntoArraysWithMaxDifference daiawmd = new DivideArrayIntoArraysWithMaxDifference();

        System.out.println("[[1,1,3],[3,4,5],[7,8,9]] == " + Arrays.deepToString(daiawmd.divideArray(new int[]{1,3,4,8,7,9,3,5,1}, 2)));
        System.out.println("[] == " + Arrays.deepToString(daiawmd.divideArray(new int[]{1,3,3,2,7,3}, 3)));
    }

    public void maximumConsecutiveFloorsWithoutSpecialFloors() {
        MaximumConsecutiveFloorsWithoutSpecialFloors mcfwsf = new MaximumConsecutiveFloorsWithoutSpecialFloors();

        System.out.println("3 == " + mcfwsf.maxConsecutive(2, 2, new int[]{4,6}));
        System.out.println("0 == " + mcfwsf.maxConsecutive(6, 8, new int[]{7,6,8}));
    }

    public void countVowelSubstringsOfAString() {
        CountVowelSubstringsOfAString cvsoas = new CountVowelSubstringsOfAString();

        System.out.println("2 == " + cvsoas.countVowelSubstrings("aeiouu"));
        System.out.println("0 == " + cvsoas.countVowelSubstrings("unicornarihan"));
        System.out.println("7 == " + cvsoas.countVowelSubstrings("cuaieuouac"));
    }

    public void partitionArrayForMaximumSum() {
        PartitionArrayForMaximumSum pafms = new PartitionArrayForMaximumSum();
        System.out.println("84 == " + pafms.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
        System.out.println("83 == " + pafms.maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
        System.out.println("1 == " + pafms.maxSumAfterPartitioning(new int[]{1}, 1));
    }

    public void additiveNumber() {
        AdditiveNumber an = new AdditiveNumber();
        System.out.println("true == " + an.isAdditiveNumber("112358"));
        System.out.println("false == " + an.isAdditiveNumber("00123"));
        System.out.println("true == " + an.isAdditiveNumber("0000000000000"));
        System.out.println("false == " + an.isAdditiveNumber("0"));
        System.out.println("false == " + an.isAdditiveNumber("1023"));
        System.out.println("true == " + an.isAdditiveNumber("101"));
        System.out.println("true == " + an.isAdditiveNumber("101"));
        System.out.println("true == " + an.isAdditiveNumber("011235"));
        System.out.println("false == " + an.isAdditiveNumber("0235813"));
    }

    public void insertDeleteGetRandomO1DuplicatesAllowed() {
        InsertDeleteGetRandomO1DuplicatesAllowed idgro1da = new InsertDeleteGetRandomO1DuplicatesAllowed();

        System.out.println("true == " + idgro1da.insert(1));
        System.out.println("false == " + idgro1da.remove(2));
        System.out.println("true == " + idgro1da.insert(2));
        System.out.println("1/2 == " + idgro1da.getRandom());
        System.out.println("true == " + idgro1da.remove(1));
        System.out.println("false == " + idgro1da.insert(2));
        System.out.println("2 == " + idgro1da.getRandom());

        idgro1da = new InsertDeleteGetRandomO1DuplicatesAllowed();

        System.out.println("true == " + idgro1da.insert(4));
        System.out.println("true == " + idgro1da.insert(3));
        System.out.println("false == " + idgro1da.insert(4));
        System.out.println("true == " + idgro1da.insert(2));
        System.out.println("false == " + idgro1da.insert(4));
        System.out.println("true == " + idgro1da.remove(4));
        System.out.println("true == " + idgro1da.remove(3));
        System.out.println("true == " + idgro1da.remove(4));
        System.out.println("true == " + idgro1da.remove(4));

        idgro1da = new InsertDeleteGetRandomO1DuplicatesAllowed();

        System.out.println("true == " + idgro1da.insert(0));
        System.out.println("true == " + idgro1da.remove(0));
        System.out.println("true == " + idgro1da.insert(-1));
        System.out.println("false == " + idgro1da.remove(0));
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());


    }

    public void minimumWindowSubstring() {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();

        System.out.println("BANC == " + mws.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("a == " + mws.minWindow("a", "a"));
        System.out.println(" == " + mws.minWindow("a", "aa"));
    }

    public void numberOfSubarraysWithBoundedMaximum() {
        NumberOfSubarraysWithBoundedMaximum noswbm = new NumberOfSubarraysWithBoundedMaximum();

        System.out.println("3 = " + noswbm.numSubarrayBoundedMax(new int[]{2,1,4,3}, 2, 3));
        System.out.println("7 = " + noswbm.numSubarrayBoundedMax(new int[]{2,9,2,5,6}, 2, 8));
        System.out.println("414 = " + noswbm.numSubarrayBoundedMax(new int[]{3,2,4,5,6,7,8,7,6,5,4,3,23,1,2,3,4,5,6,7,6,5,4,3,2,1,2,3,4,5,6,7,6,5,4,3,2,1,32,4,5,6,7,6,5,4,3,2}, 4, 14));
        System.out.println("1 = " + noswbm.numSubarrayBoundedMax(new int[]{2}, 0, 10));
    }

    public void countElementsWithMaximumFrequency() {
        CountElementsWithMaximumFrequency cewmf = new CountElementsWithMaximumFrequency();

        System.out.println("4 == " + cewmf.maxFrequencyElements(new int[]{1,2,2,3,1,4}));
        System.out.println("5 == " + cewmf.maxFrequencyElements(new int[]{1,2,3,4,5}));
        System.out.println("4 == " + cewmf.maxFrequencyElements(new int[]{1,2,3,4,5,6,7,8,7,6,5,6,7,6,5,4,3,2,1}));
        System.out.println("1 == " + cewmf.maxFrequencyElements(new int[]{1}));
        System.out.println("3 == " + cewmf.maxFrequencyElements(new int[]{1,1,1}));
        System.out.println("2 == " + cewmf.maxFrequencyElements(new int[]{1,2,3,4,1}));
    }
}
