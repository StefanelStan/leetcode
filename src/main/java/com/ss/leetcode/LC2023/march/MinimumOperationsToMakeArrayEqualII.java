package com.ss.leetcode.LC2023.march;

import java.util.Arrays;

public class MinimumOperationsToMakeArrayEqualII {
    // https://leetcode.com/problems/minimum-operations-to-make-array-equal-ii
    /** Algorithm
        1. Fail fast: if k == 0, check if the two arrays are equal. Yes? return 0, else -1
        2. The logic is to check if the diff between each nums1[i] nums2[i] is divisible by k.
            If not, you cannot obtain nums2[i] by adding /removing k any number of times.
            EG: nums1[i]=3 , nums2[i]=7, k = 3. The diff is 4. You cannot obtain 4 from 3.
            nums1[i]=3 , nums2[i]=7, k = 2. diff = 4: you can obtain 4 by adding 2 two times
        3. Figuring this mechanism, apply a fail fast mechanism: if diff % k != 0, return -1
        4. Else, use two variables (minusDiff, plusDiff) to add the negative and positive diff between each pair nums1[i], nums2[i].
            This is because we need to match the negative diff with the positive diff
        5. At the end, if minusDiff + plusDiff != 0, return -1 (the two differences cannot balance each other), else return plusDiff / k.
            EG: minusDiff = -6, plusDiff = 6, k = 2. 6/2 = 3. We can balance them in 3 steps:
            (+2/-2), (+2/-2),(+2/-2).
     */
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            return Arrays.equals(nums1, nums2) ? 0 : -1;
        }
        long minusDiff = 0, plusDiff = 0, diff;
        for (int i = 0; i < nums1.length; i++) {
            diff = nums1[i] - nums2[i];
            if (diff % k != 0) {
                return -1;
            }
            if (diff > 0) {
                plusDiff += diff;
            } else if (diff < 0) {
                minusDiff += diff;
            }
        }
        return Math.abs(minusDiff) != plusDiff ? -1 : plusDiff / k;
    }
}
