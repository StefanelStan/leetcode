package com.ss.leetcode.LC2023.november;

public class FindIndicesWithIndexAndValueDifferenceII {
    // https://leetcode.com/problems/find-indices-with-index-and-value-difference-ii
    /** Algorithm
        1. Fail fast: if indexDiff >= nums.length, then return {-1,-1} as you cannot have such distant indices
        2. Looking at the indexDiff, you realise that if you pick i [0..n-indexDiff],
            then the next available number you can chose if after i + indexDiff.
            - Thus, we observe a gap/window: the other index must be outside this window
        3. If your right index is [indexDiff], then your left index is 0.
            If your right index is [indedDiff +1], then your left indices could be [0, 1].
        4. We observe a pattern: if the right index is indexDiff + x, then the left side valid indices are between [0, x]
        5. The most relevant numbers to consider on the left side are min and max.
            Because Abs(max - nums[indexDiff + x]) OR abs(min - nums[indexDiff + x]) most probably will give you a diff
            greater than the valueDiff.
        6. Using such a window, traverse the array and keep track of min/max of the left index.
            Calculate abs(max - [rightIndex]) & abs(min-[rightIndex]). Stop when you find a valid combination.
     */
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        if (indexDifference >= nums.length) {
            return new int[]{-1,-1};
        }
        int minValue = Integer.MAX_VALUE, minIndex = 0;
        int maxValue = Integer.MIN_VALUE, maxIndex = 0;
        for (int i = nums.length - indexDifference - 1, j = nums.length -1; i >= 0; i--, j--) {
            if (nums[j] < minValue) {
                minValue = nums[j];
                minIndex = j;
            }
            if (nums[j] > maxValue) {
                maxValue = nums[j];
                maxIndex = j;
            }
            if (Math.abs(nums[i] - minValue) >= valueDifference) {
                return new int[]{i, minIndex};
            }
            if (Math.abs(nums[i] - maxValue) >= valueDifference) {
                return new int[]{i, maxIndex};
            }
        }
        return new int[]{-1, -1};
    }
}
