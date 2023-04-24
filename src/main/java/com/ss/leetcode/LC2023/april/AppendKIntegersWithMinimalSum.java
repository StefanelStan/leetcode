package com.ss.leetcode.LC2023.april;

import java.util.Arrays;

public class AppendKIntegersWithMinimalSum {
    // https://leetcode.com/problems/append-k-integers-with-minimal-sum
    /** Algorithm
        1. Sort the numbers in natural order
        2. For each num in nums
        3. If current - prev > 1 (interval gap), determine the sum of the interval gap
            EG: 3 and 8. There is a gap of 4,5,6,7 of sum 4+5+6+7.
        4. To quickly calculate the sum of any gap apply basic math:
            - the sum of 4+5+6+7 = Sum(1..7) - sum (1..3).
            which is n * (n+1) / 2 -> (7*8 /2) - (3 * 4 /2) = 28 - 6 = 22.
        5. For each step, if there is a gap, calculate the interval gap size.
            Also, decrement k with each gap.
        6. If K is still > 0 when reaching the end, add the missing gap to the sum.
     */
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = 0, currentDiff;
        long missingIntervalSum = 0L;
        int i = 0;
        while(i < nums.length) {
            if (k > 0) {
                currentDiff = Math.min(k, nums[i] - prev - 1);
                if (currentDiff > 0) {
                    missingIntervalSum += calculateInterval(prev, prev + currentDiff);;
                    k -= currentDiff;
                }
            }
            prev = nums[i];
            i++;
        }
        if (k > 0) {
            missingIntervalSum += calculateInterval(prev, prev + k);
        }
        return missingIntervalSum;
    }

    private long calculateInterval(long beforeIntervalStart, int intervalEnd) {
        long totalIntervalSum = (long)(intervalEnd) * (intervalEnd + 1) / 2;
        long beforeIntervalSum = beforeIntervalStart * (beforeIntervalStart + 1) / 2;
        return totalIntervalSum - beforeIntervalSum;
    }
}
