package com.ss.leetcode.LC2024.february;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumSumOfAlmostUniqueSubarray {
    // https://leetcode.com/problems/maximum-sum-of-almost-unique-subarray
    /** Algorithm
        1. Sliding Window: the problem asks for a continous subarray of size k => window of size k
        2. Use a Map<Integer, Integer> to keep track of count of numbers that are inside map.
        3. When adding a number, increase the count of the map and also add it to a LONG sum.
        4. When removing a number, decrease the count. If count goes 0, remove the mapping.
            Also decrease the sum.
        5. In a sliding window, remove the left edge and add the right edge numbers.
     */
    public long maxSum(List<Integer> nums, int m, int k) {
        UniqueSubarrayWindow usw = new UniqueSubarrayWindow(m);
        for (int i = 0; i < k; i++) {
            usw.addNumber(nums.get(i));
        }
        long maxSum = usw.isValid() ? usw.sum : 0;
        for (int i = 0, j = k; j < nums.size(); i++, j++) {
            usw.removeNumber(nums.get(i));
            usw.addNumber(nums.get(j));
            if (usw.isValid()) {
                maxSum = Math.max(maxSum, usw.sum);
            }
        }
        return maxSum;
    }

    private static class UniqueSubarrayWindow {
        Map<Integer, Integer> count;
        long sum = 0;
        int minDistinct;

        public UniqueSubarrayWindow(int minDistinct) {
            this.count = new HashMap<>();
            this.minDistinct = minDistinct;
        }

        public void addNumber(int number) {
            sum += number;
            count.merge(number, 1, Integer::sum);
        }

        public void removeNumber(int number) {
            sum -= number;
            if (count.merge(number, -1, Integer::sum) == 0) {
                count.remove(number);
            }
        }

        public boolean isValid() {
            return count.size() >= minDistinct;
        }

    }
}
