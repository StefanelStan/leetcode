package com.ss.leetcode.LC2024.october;

public class EqualSumArraysWithMinimumNumberOfOperations {
    // https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations
    public int minOperations(int[] nums1, int[] nums2) {
        int[] bucket1 = new int[7];
        int[] bucket2 = new int[7];
        int sum1 = fillInBucketAndGetSum(nums1, bucket1);
        int sum2 = fillInBucketAndGetSum(nums2, bucket2);
        if (sum1 == sum2) {
            return 0;
        }
        int minSum = Math.min(sum1, sum2);
        int maxSum = Math.max(sum1, sum2);
        int[] minSumArray = sum1 < sum2 ? nums1 : nums2;
        int[] maxSumArray = sum1 > sum2 ? nums1 : nums2;
        int[] minSumBucket = sum1 < sum2 ? bucket1 : bucket2;
        int[] maxSumBucket = sum1 > sum2 ? bucket1 : bucket2;
        // calculate reach sum between these 2
        if (maxSum - minSum > ((minSumArray.length * 6 - minSum) + (maxSum - maxSumArray.length))) {
            return -1;
        }
        return findMinOperations(maxSum - minSum, minSumBucket, maxSumBucket);
    }

    private int findMinOperations(int diff, int[] minBucket, int[] maxBucket) {
        int operations = 0;
        int minIndex = 1, maxIndex = 6, targetIndex;
        int elementsToRemove, diffElement;
        int[] targetBucket;
        while (diff > 0) {
            while (minIndex < minBucket.length && minBucket[minIndex] == 0) {
                minIndex++;
            }
            while (maxIndex > 0 && maxBucket[maxIndex] == 0) {
                maxIndex--;
            }
            diffElement = minIndex == 7 ? maxIndex - 1: maxIndex == 0 ? 6 - minIndex : 6 - minIndex >= maxIndex ? 6 - minIndex : maxIndex - 1;
            targetBucket = minIndex == 7 ? maxBucket : maxIndex == 0 ? minBucket : 6 - minIndex >= maxIndex ? minBucket : maxBucket;
            targetIndex = targetBucket == minBucket ? minIndex : maxIndex;
            elementsToRemove = Math.min(targetBucket[targetIndex], Math.max(1, diff / diffElement));
            targetBucket[targetIndex] -= elementsToRemove;
            diff -= (elementsToRemove * diffElement);
            operations += elementsToRemove;
            if (diff > 0  && targetBucket[targetIndex] > 0) {
                diff -= elementsToRemove;
                operations++;
            }
        }
        return operations;
    }

    private int fillInBucketAndGetSum(int[] nums, int[] bucket) {
        int sum = 0;
        for (int num : nums) {
            bucket[num]++;
            sum += num;
        }
        return sum;
    }
}
