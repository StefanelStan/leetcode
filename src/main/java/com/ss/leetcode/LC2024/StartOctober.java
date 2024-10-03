package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.october.FindTheGridOfRegionAverage;
import com.ss.leetcode.LC2024.october.MakeSumDivisibleByP;
import com.ss.leetcode.LC2024.october.SplitArrayIntoMaximumNumberOfSubarrays;
import java.util.Arrays;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start = new StartOctober();

//        start.splitArrayIntoMaximumNumberOfSubarrays();
//        start.findTheGridOfRegionAverage();
        start.makeSumDivisibleByP();
    }

    public void splitArrayIntoMaximumNumberOfSubarrays() {
        SplitArrayIntoMaximumNumberOfSubarrays saimnos = new SplitArrayIntoMaximumNumberOfSubarrays();

        System.out.println("3 == " + saimnos.maxSubarrays(new int[]{1,0,2,0,1,2}));
        System.out.println("1 == " + saimnos.maxSubarrays(new int[]{5,7,1,3}));
        System.out.println("3 == " + saimnos.maxSubarrays(new int[]{3,2,1,2,3,4,5,6,5,4,3,1,1}));
        System.out.println("4 == " + saimnos.maxSubarrays(new int[]{5,4,3,2,3,5,7,8,6,5,3}));
        System.out.println("5 == " + saimnos.maxSubarrays(new int[]{3,2,3,5,6,8,7,6,5,3,2,4,6,7,56,3}));
        System.out.println("3 == " + saimnos.maxSubarrays(new int[]{3,2,34,5,7,98,9,7,5,4,2}));
        System.out.println("2 == " + saimnos.maxSubarrays(new int[]{1234,3423,354,43534,56456,3524,425435,452341,2343,6576,24123}));
        System.out.println("1 == " + saimnos.maxSubarrays(new int[]{22,21,29,22}));
    }

    public void findTheGridOfRegionAverage() {
        FindTheGridOfRegionAverage ftgora = new FindTheGridOfRegionAverage();

        System.out.println("[[9,9,9,9],[9,9,9,9],[9,9,9,9]] == " + Arrays.deepToString(ftgora.resultGrid(new int[][]{{5,6,7,10}, {8,9,10,10},{11,12,13,10}}, 3)));
        System.out.println("[[25,25,25],[27,27,27],[27,27,27],[30,30,30]] == " + Arrays.deepToString(ftgora.resultGrid(new int[][]{{10,20,30}, {15,25,35},{20,30,40},{25,35,45}}, 12)));
        System.out.println("[[5,6,7],[8,9,10],[11,12,13]] == " + Arrays.deepToString(ftgora.resultGrid(new int[][]{{5,6,7}, {8,9,10},{11,12,13}}, 1)));
    }

    public void makeSumDivisibleByP() {
        MakeSumDivisibleByP msdbp = new MakeSumDivisibleByP();

        System.out.println("1 == " + msdbp.minSubarray(new int[]{3,1,4,2}, 6));
        System.out.println("1 == " + msdbp.minSubarray(new int[]{2,8,7,3,6,3,19,19,4,10}, 74));
        System.out.println("0 == " + msdbp.minSubarray(new int[]{1}, 1));
        System.out.println("-1 == " + msdbp.minSubarray(new int[]{5,12,2,14,11,15,10,22,20,10,20}, 81));
        System.out.println("3 == " + msdbp.minSubarray(new int[]{26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3}, 26));
        System.out.println("7 == " + msdbp.minSubarray(new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2}, 148));
    }
}
