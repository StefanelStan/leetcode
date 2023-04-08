package com.ss.leetcode.LC2023.april;

public class MaximumDistanceBetweenAPairOfValues {
    // https://leetcode.com/problems/maximum-distance-between-a-pair-of-values
    /** Algorithm
        1. Use two pointers i and j for nums1 and nums2, starting from the end
        2. While i >= 0 && j >= distance (if distance is x, there is no point searching when j is less than x)
        3. Move i to the left while nums1[i] < nums2[j].
        4. If nums2[j] >= nums1[i], determine the distance.
        5. Move j left by 1 point.
        6. Return the max distance.
     */
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = nums1.length -1, j = nums2.length -1;
        int maxDistance = 0;
        while (i >= 0 && j >= maxDistance) {
            while (i > 0 && nums1[i-1] <= nums2[j]) {
                i--;
            }
            if (nums2[j] >= nums1[i]) {
                maxDistance = Math.max(maxDistance, Math.max(0, j - i));
            }
            j--;
        }
        return maxDistance;
    }
}
