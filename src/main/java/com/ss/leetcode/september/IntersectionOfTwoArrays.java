package com.ss.leetcode.september;

import java.util.Arrays;

public class IntersectionOfTwoArrays {
    // https://leetcode.com/problems/intersection-of-two-arrays/
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] counter = new boolean[1001];
        int[] result = new int[1001];
        int index = 0;

        for (int num : nums1) {
            counter[num] = true;
        }

        for (int num : nums2) {
            if (counter[num]) {
                counter[num] = false;
                result[index++] = num;
            }
        }
        return Arrays.copyOf(result, index);
    }
}
