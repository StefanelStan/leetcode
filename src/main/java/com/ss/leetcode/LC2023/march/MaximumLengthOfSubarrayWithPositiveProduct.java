package com.ss.leetcode.LC2023.march;

public class MaximumLengthOfSubarrayWithPositiveProduct {
    // https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product
    /** Algorithm Sliding window - each window will reset/trigger when a 0 is encountered. Your segments live between 0s and/or
        between 1st and last elements (if no)
        1. Traverse the array and keep track of start and end of window, index of firstNegative, lastNegative and negativeCount
        2. When you hit a 0, determine the length of the longest subarray from that window
        3. If the window has even count of negatives, then the whole window is a valid subarray
        4. If it has an odd number of negatives, check two possible intervals
            EG: [1,1,2,3,-1,4,5,-6,7,8,9,10,-11,12] segment length = 14.
            3 negative numbers at index 4, 7 and 12.
            You have two combinations: eliminate left negative and keep segment leftNegative+1 -> end : [4...12]
            OR eliminate lastNegative and keep the segment [start -> lastNegative-1] : [1..10].
            Return the max of these 2.
        5. Initialize max length with 0, this will take care of any negative lengths returned by the interval calculation.
        6. Return the max length;
     */
    public int getMaxLen(int[] nums) {
        int maxLength = 0;
        int start = 0, end = 0, firstNegative = -1, lastNegative = -1, negativeCount = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                // calculate max length of window
                maxLength = Math.max(maxLength, getMaxLength(start, end -1, firstNegative, lastNegative, negativeCount));
                // reset indices;
                start = end + 1;
                firstNegative = -1;
                lastNegative = -1;
                negativeCount = 0;
            } else if (nums[end] < 0) {
                if (firstNegative == -1) {
                    firstNegative = end;
                }
                lastNegative = end;
                negativeCount++;
            }
            end++;
        }
        // calculate segment made up by ending elements
        maxLength = Math.max(maxLength, getMaxLength(start, end - 1, firstNegative, lastNegative, negativeCount));
        return maxLength;
    }

    private int getMaxLength(int start, int end, int firstNegative, int lastNegative, int negativeCount) {
        if (negativeCount % 2 == 0) {
            return (end - start) + 1;
        } else {
            return Math.max(lastNegative - start, end - firstNegative);
        }
    }
}
