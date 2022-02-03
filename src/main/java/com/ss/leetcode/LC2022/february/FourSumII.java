package com.ss.leetcode.LC2022.february;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    // https://leetcode.com/problems/4sum-ii/
    /** Algorithm:
     *  1. As intuition dictates, the brute force solution would imply 4 loops over nums1, nums2, nums3, nums4
     *     Looking at L3 and L4, we can observe that nums3[i] + nums4[j] is a repeated action (nums1.length * nums2.length times).
     *  2. In this case, why not storing the results of L3 and L4 into a map, grouping and counting the sums.
     *  3. Thus, in L1 and L2 (over nums1[i] & nums2[j]) look in the map for the - (nums1[i] + nums2[j]) and add the count to total sum
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> nums34Sums = addSumsToMap(nums3, nums4);

        int secondHalf = 0;
        for (int num1 : nums1) {
            for (int num2: nums2) {
                secondHalf = nums34Sums.getOrDefault(-(num1 + num2), 0);
                count += secondHalf;
            }
        }
        return count;
    }

    private Map<Integer, Integer> addSumsToMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int num1 : nums1) {
            for(int num2 : nums2) {
                sumMap.merge(num1 + num2, 1, Integer::sum);
            }
        }
        return sumMap;
    }
}
