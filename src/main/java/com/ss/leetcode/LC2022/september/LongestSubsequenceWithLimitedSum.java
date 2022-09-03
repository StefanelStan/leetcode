package com.ss.leetcode.LC2022.september;

import java.util.Arrays;
import java.util.Comparator;

public class LongestSubsequenceWithLimitedSum {
    // https://leetcode.com/problems/longest-subsequence-with-limited-sum/
    /** Algorithm
         1. The "longest subsequence" actually means you have to start by selecting the lowest numbers first.
            EG:[2,2,2,3,4,5,1,1,1] query = [3]. We will always get better results if we select the smallest ones first. (1,1,1)
         2. In order to acheive this, the intuition tell to use count the numbers and use a TreeMap<Integer, Integer(count)>
            so you can traverse it and keep adding/calculating the sum until you reach your query.
         3. However, you can do a trick: why not sort the numbers (1,1,1,2,2,3,4,5) and calculate a rolling sum.
             This way, each sum (1,2,3,5,7,10,14,19) and its index will indicate how many numbers form up that sum.
             EG: 7 is at index 4. (0 based). This means that 5he smallest 5 numbers make this sum (1+1+1+2+2).
         4. Thus, sort the nums and calculate their rolling sum.
         5. Once this, for each query, apply a binary search, detecting the index of where the query would fit.
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        // use the same nums array to override the rolling sum. We have already sorted this, so we already
        // messed up with the input array, so we might as well use it, rather than allocating new array[].
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = answerQuery(nums, queries[i]);
        }
        return answer;
    }

    private int answerQuery(int[] nums, int query) {
        int low = 0, high = nums.length - 1, pivot;
        while (low < high) {
            // try a quick fast/fail. If you're on the extreme left/right return their index. Will help chop off 2 ms
            if (query >= nums[high]) {
                return high + 1;
            } else if (query < nums[low]) {
                return low;
            }
            // apply standard binary search
            pivot = low + (high - low) / 2;
            if (query == nums[pivot]) {
                return pivot + 1;
            } else if (query > nums[pivot]) {
                low = pivot + 1;
            } else {
                high = pivot -1;
            }
        }
        return query >= nums[low] ? low + 1 : low;
    }

    // sorted queries with search-to-right-direction solution.
    public int[] answerQueries3(int[] nums, int[] queries) {
        int[] cumulativeSum = getCumulativeSortedSum(nums);
        int[][] sortedQueries = countAndSortQueries(queries);
        return answerQueries(cumulativeSum, sortedQueries);
    }

    private int[][] countAndSortQueries(int[] queries) {
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));
        return sortedQueries;
    }

    private int[] getCumulativeSortedSum(int[] nums) {
        Arrays.sort(nums);
        int[] cumulativeSum = new int[nums.length + 1];
        for (int numIndex = 0, csIndex = 1; numIndex < nums.length; numIndex++, csIndex++) {
            cumulativeSum[csIndex] = cumulativeSum[csIndex - 1] + nums[numIndex];
        }
        return cumulativeSum;
    }

    private int[] answerQueries(int[] cumulativeSum, int[][] sortedQueries) {
        int[] answer = new int[sortedQueries.length];
        int csIndex = 0;
        for (int[] sortedQuery : sortedQueries) {
            while (csIndex < cumulativeSum.length && cumulativeSum[csIndex] <= sortedQuery[0]) {
                csIndex++;
            }
            answer[sortedQuery[1]] = csIndex - 1;
        }
        return answer;
    }
}
