package com.ss.leetcode.LC2021.september;

import java.util.Arrays;

public class IntersectionOfTwoArraysII {
    // https://leetcode.com/problems/intersection-of-two-arrays-ii/
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] nums1Times = new int[1001];
        for (int num : nums1) {
            nums1Times[num]++;
        }
        int[] intersect = new int[1001];
        int index = 0;
        for (int num : nums2) {
            if(nums1Times[num] > 0) {
                intersect[index++] = num;
                nums1Times[num]--;
            }
        }
        return Arrays.copyOf(intersect, index);
    }
}
