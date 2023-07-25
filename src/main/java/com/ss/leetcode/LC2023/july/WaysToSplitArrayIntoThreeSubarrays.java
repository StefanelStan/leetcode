package com.ss.leetcode.LC2023.july;

public class WaysToSplitArrayIntoThreeSubarrays {
    // https://leetcode.com/problems/ways-to-split-array-into-three-subarrays
    /** Algorithm
        1. Compute the prefix sum for the array of nums
        2. You need to find all possible segments s1,s2,s3 where sum(s1) <= sum(s2) <= sum(s3)
        3. For each segment s1 = [0, a] ([0,0],[0,1],[0..n-3] )
        4. Try to find the shortest next segment whose sum is AT LEAST equal to current segment.
            As you have prefixSum, you just need to find the value/index of s1Sum * 2
            Make sure you find the shortest one, as you might have edge cases like 3,3,0,0,0
            When you have segment[3] (index 0), the shortest next segment is [3](index 1).
            If you use binary search, move high to pivot -1 if rollingSum[pivot] >= target
        5. Now you need to find the average of totalSum - s1 OR s2 + s3.
            Knowing the average index, you know that you can increase s2 up and including the average
            EG: [4,2,2,3,1,1,1,1,12,12] , prefixSum = [4,6,8,11,12,13,14,15,27,39]
            s1 = [4] (index 0)
            s2 = [2,2] (index 1,2)
            average of s2 + s3 = (2+2+3+1+1+1+1+12+12)/2 = 17 + 4 (sum of first segment) = 21
            21 is found at index 7 (15).
            This means that segment2 can grow from index [1,2] to index [1,7]: [1,2],[1,3],[1,4]..[1,7] => 6 segments
            It can grow because the sum of s2 will not go OVER the half of the remaining sum of totalSum - s1.
            At index 7 s2 will have a sum of 11 and s3 = 24.
            If we attempt to increase s2 once more, we get sum of 23 and s3 = 12, which is not respecing the rules.
        6. Apply #3 and #4 #5 for each s1 starting from [0,0] .. [0,n-2]
        7. Also, apply some basic logic: if sum(s1) goes over a third of totalSum OR s2 > s3 => break.
     */
    public int waysToSplit(int[] nums) {
        int[] rollingSum = getRollingSum(nums);
        int ways = 0;
        int sum = 0;
        int thirdTotal = rollingSum[rollingSum.length - 1];
        for (int i = 0; i < nums.length - 2 && sum <= thirdTotal; i++) {
            sum += nums[i];
            ways = (ways + findWaysToSplit(sum, i+1, rollingSum, rollingSum.length)) % 1_000_000_007;
        }
        return ways;
    }

    private int findWaysToSplit(int sum, int from, int[] rollingSum, int l) {
        if (sum * 2 > rollingSum[l - 1] - sum) {
            return 0;
        }
        int midSegmentStart = findLeftMost(from, l - 2, sum * 2, rollingSum);
        // edge case: [3,2,100,0,0]: midsegment is greater than 3 (2+100) but is also greater than s3 (0,0)
        if (rollingSum[midSegmentStart] - sum > rollingSum[l - 1] - rollingSum[midSegmentStart]) {
            return 0;
        }
        int averageIndex = findRightMost(midSegmentStart, l - 2,  sum + (rollingSum[l - 1] - sum) / 2, rollingSum);
        // find if we can leverage or not the averageIndex
        if (rollingSum[averageIndex] - sum > rollingSum[l -1] - rollingSum[averageIndex]) {
            return 0;
        }
        // else we are good to compute sum
        return (averageIndex - midSegmentStart) + 1;
    }

    private int findLeftMost(int left, int right, int target, int[] rollingSum) {
        if (target == 0) {
            return left;
        }
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (rollingSum[pivot] >= target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }

    private int findRightMost(int left, int right, int target, int[] rollingSum) {
        int pivot;
        while (left < right) {
            pivot = left + (right - left) / 2;
            if (rollingSum[pivot] <= target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return rollingSum[left] > target ? left - 1 : left;
    }

    private int[] getRollingSum(int[] nums) {
        int[] rollingSum = new int[nums.length];
        int prevSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rollingSum[i] = prevSum + nums[i];
            prevSum = rollingSum[i];
        }
        return rollingSum;
    }
}
