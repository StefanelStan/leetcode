package com.ss.leetcode.LC2023.september;

import java.util.Arrays;
import java.util.Comparator;

public class QueryKthSmallestTrimmedNumber {
    // https://leetcode.com/problems/query-kth-smallest-trimmed-number
    /** Algorithm
        1. Declare an object NumberChar(char[] number, int position) that will wrap the chars of the given
            numbers and the position. Use an NumberChar[] to mirror the initial String[] nums.
            Having access to char[] instead of String will make sorting faster
        2. Using a basic method, we need to sort the NumberChar (each chars[]) based on the trim value.
            If trim is 3, then we need to sort them based on their value starting of char[] with index n-3.
            Also, if the comparison result is 0, then the position in nums takes priority
        3. However, if we have multiple queries with the same trim value, it's best to do these in one go.
        4. So wrap/remap the queries[][] into a new sortedQueries[][] that will hold 3 items: k, trim, positionInQuery.
            - Thus, when traversing this sortedQuery, we will know the original position in queries[][] due to the position index present at sortedQuery[2].  .
        5. Sort this sortedQueries based on trim (sortedQueries[1]). This way, we will group the trims together: [1,1],[1,1],[4,2][x,2] etc.
        6. For each sortedQuery, if the previous sorting Trim is different that current, then we need to sort NumberChar[] based
            on new trim (sortedquery[1]), else, we already have it sorted
        7. Build your answer[] array: answer[sortedQuery[2]] = NumberChar[sortedQuery[0] - 1].position.
            sortedQuery[0] -1 will point to the 0-based k priority index of the sortedNums.
     */
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        NumberChar[] numbers = getNumbers(nums);
        int[][] orderedQueries = getOrderedQueries(queries);
        final int[] orderIndex = {-1};
        int[] smallestTrimmed = new int[queries.length];
        for (int[] orderedQuery : orderedQueries) {
            if (orderedQuery[1] != orderIndex[0]) {
                Arrays.sort(numbers, (n1, n2) -> determineMin(n1, n2, n1.chars.length - orderedQuery[1]));
            }
            smallestTrimmed[orderedQuery[2]] = numbers[orderedQuery[0] - 1].position;
            orderIndex[0] = orderedQuery[1];
        }
        return smallestTrimmed;
    }

    private int determineMin(NumberChar n1, NumberChar n2, int fromPosition) {
        while (fromPosition < n1.chars.length && n1.chars[fromPosition] == n2.chars[fromPosition]) {
            fromPosition++;
        }

        return fromPosition == n1.chars.length ? Integer.compare(n1.position, n2.position) : n1.chars[fromPosition] - n2.chars[fromPosition];
    }

    private NumberChar[] getNumbers(String[] nums) {
        NumberChar[] numbers = new NumberChar[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = new NumberChar(nums[i].toCharArray(), i);
        }
        return numbers;
    }

    private int[][] getOrderedQueries(int[][] queries) {
        int[][] orderedQueries = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            orderedQueries[i] = new int[]{queries[i][0], queries[i][1], i};
        }
        Arrays.sort(orderedQueries, Comparator.comparingInt(q -> q[1]));
        return orderedQueries;
    }

    private static class NumberChar {
        char[] chars;
        int position;

        public NumberChar(char[] chrs, int position) {
            this.chars = chrs;
            this.position = position;
        }
    }
}
