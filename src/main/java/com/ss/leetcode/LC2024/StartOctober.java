package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.october.SplitArrayIntoMaximumNumberOfSubarrays;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start = new StartOctober();

        start.splitArrayIntoMaximumNumberOfSubarrays();
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
}
