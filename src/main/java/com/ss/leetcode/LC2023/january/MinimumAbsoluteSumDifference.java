package com.ss.leetcode.LC2023.january;

public class MinimumAbsoluteSumDifference {
    // https://leetcode.com/problems/minimum-absolute-sum-difference
    /** Algorithm
     *  1. The best replacement can be done when a high difference (eg: 1 - 7) can be replaced by a lower one (eg: 3-7).
     *  2. Use a sorted set/ sort a copy of nums1 to store and search (binary search or ceiling/floor) inside nums1
     *  3. For each index of nums1, try to look for the closest nums2[index] in nums1.
     *  4. Compare this result with the greatest reduction encountered so far.
     *     EG: nums1 = [1,3,5], nums2=[1,9,2]
     *     index0, 1 ==1 so ignore it
     *     index1 diff is 6 (9-3). Can we find a number closer to 9? yes: 5: so our largest diff of 6 becomes 4. We have a reduction of 2!
     *     index2: diff is 3. Can we find a nr closer to 5 ? we have 9 and 2. Best fit it 2 (2-5 < 9-5) However, in this case the reduction is 0.
     *     Overall, the best reduction is at index 1.
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long[] absoluteSum = {0};
        int[] sortedUnique = getSortedUnique(nums1, nums2, absoluteSum);
        int bestDiff = 0, bestCandidateDiff = 0;
        int currentDiff, candidateDiff;
        for (int i = 0; i < nums1.length; i++) {
            currentDiff = Math.abs(nums1[i] - nums2[i]);
            if(currentDiff != 0) {
                candidateDiff = getCandidateDiff(sortedUnique, nums2[i]);
                if (currentDiff > candidateDiff && currentDiff - candidateDiff > bestDiff - bestCandidateDiff) {
                    bestDiff = currentDiff;
                    bestCandidateDiff = candidateDiff;
                }
            }
        }
        return (int)((absoluteSum[0] - bestDiff + bestCandidateDiff) % 1_000_000_007);
    }

    private int getCandidateDiff(int[] sortedUnique, int target) {
        int low = 0, high = sortedUnique.length - 1;
        int pivot;
        while(low < high) {
            if (high - low == 1) {
                break;
            }
            pivot = low + (high - low) / 2;
            if (sortedUnique[pivot] == target) {
                return 0;
            } else if (sortedUnique[pivot] > target) {
                high = pivot;
            } else low = pivot;
        }

        return Math.min(Math.abs(target - sortedUnique[low]), Math.abs(sortedUnique[high] - target));
    }

    private int[] getSortedUnique(int[] nums1, int[] nums2, long[] absoluteSum) {
        int unique = 0;
        boolean[] present = new boolean[100_001];
        for (int i = 0; i < nums1.length; i++) {
            if (!present[nums1[i]]) {
                unique++;
            }
            present[nums1[i]] = true;
            absoluteSum[0] += Math.abs(nums1[i] - nums2[i]);
        }
        int[] sortedUnique = new int[unique];
        int insert = 0;
        for (int i = 0; i < present.length; i++) {
            if(present[i]) {
                sortedUnique[insert++] = i;
            }
        }
        return sortedUnique;
    }
}
