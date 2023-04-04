package com.ss.leetcode.LC2023.april;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumSumObtainedOfAnyPermutation {
    // https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation
    /** Algorithm
        1. Looking at the intervals, we observe that some intervals/numbers are in higher demand, are more frequent that others.
            EG: [[1,3],[0,1]]. Index 1 is requested twice, 0 once, 2 & 3 once.
        2. It makes sense to put the highest numbers at the most requested intervals/indices
        3. On an int[] mark the presence of intervals with +1 (beginning) and -1 (ending index + 1)
            eg: [1,3] and [0,1] will
            [1,3] -> [0,+1,0,0,-1] (index 1 will be marked with +1 and index 4 with -1)
            [0,1] -> [+1,+2,-1,0,-1]
        4. Run a line sweep from 0 to n and determine the bonus/stat of each index
            => [+1,+2,+1,+1, -1]
            We see that index 0 and 2 and 3 are requested 1 time and index 1 twice.
        5. Sort this [-1,1,1,1,2]
        6. Sort the given numbers [1,2,3,4,5]
        7. From i = n to 0, multiply the bonus [-1,1,1,1,2] with the highest numbers [i].
            eg: 5 *2 + 1 * 1 + 1*3.. etc
        8. Return the modulo.
     */
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        Arrays.sort(nums);
        int[] mostFrequentNumbers = getMostFrequentNumbers(requests, nums.length);
        return getTopNumbersByReference(nums, mostFrequentNumbers);
    }

    private int getTopNumbersByReference(int[] nums, int[] intervalRelevance) {
        long sum = 0L;
        for (int j = intervalRelevance.length -1, i = nums.length -1; j >=0 && intervalRelevance[j] > 0; j--) {
            sum += (long) nums[i] * intervalRelevance[j];
            i--;
        }
        return (int) (sum % 1_000_000_007);
    }

    private int[] getMostFrequentNumbers(int[][] requests, int n) {
        int[] mostFrequent =  new int[n+1];
        for (int[] request : requests) {
            mostFrequent[request[0]]++;
            mostFrequent[request[1]+1]--;
        }

        int bonus = 0;
        for (int i = 0; i < mostFrequent.length; i++) {
            bonus += mostFrequent[i];
            mostFrequent[i] = bonus;
        }

        Arrays.sort(mostFrequent);
        return mostFrequent;
    }

    // You can just add the most requested indices * sorted_highest_nums[i]
    // EG: if index 4 is requested 3 times, then multiply highest_nums_by_3
    public int maxSumRangeQuery2(int[] nums, int[][] requests) {
        Arrays.sort(nums);
        int[][] intervalRelevance = getIntervalRelevance(requests, nums.length);
        int[] numsByRelevance = getNumsByRelevance(nums, intervalRelevance);
        return getMaxSumRangeQuery(numsByRelevance, requests);
    }

    private int getMaxSumRangeQuery(int[] nums, int[][] requests) {
        long[] prefixSum = new long[nums.length];
        long prefix = 0L;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            prefixSum[i] = prefix;
        }
        long maxSum = 0L, onLeft;
        for(int[] request : requests) {
            onLeft = request[0] == 0 ? 0 : prefixSum[request[0] - 1];
            maxSum += prefixSum[request[1]] - onLeft;
        }
        return (int)(maxSum % 1_000_000_007);
    }

    private int[] getNumsByRelevance(int[] nums, int[][] intervalRelevance) {
        int[] numsByRelevance = new int[nums.length];
        long sum = 0L;
        for (int j = intervalRelevance.length -1, i = nums.length -1; j >=0 && i >= 0; j--) {
            if (intervalRelevance[j][0] != nums.length && intervalRelevance[j][1] > 0) {
                sum += (long) nums[i] * intervalRelevance[j][1];
                i--;
            }
        }
        return numsByRelevance;
    }

    private int[][] getIntervalRelevance(int[][] requests, int n) {
        int[][] intervalRelevance =  new int[n+1][2];
        for (int i = 0; i < intervalRelevance.length; i++) {
            intervalRelevance[i][0] = i;
        }
        for (int[] request : requests) {
            intervalRelevance[request[0]][1]++;
            intervalRelevance[request[1]+1][1]--;
        }

        int bonus = 0;
        for (int i = 0; i < intervalRelevance.length; i++) {
            bonus += intervalRelevance[i][1];
            intervalRelevance[i][1] = bonus;
        }

        Arrays.sort(intervalRelevance, Comparator.comparingInt(a -> a[1]));
        return intervalRelevance;
    }

}
