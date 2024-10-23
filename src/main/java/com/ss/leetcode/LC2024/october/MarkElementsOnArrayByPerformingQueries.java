package com.ss.leetcode.LC2024.october;

import java.util.Arrays;
import java.util.Comparator;

public class MarkElementsOnArrayByPerformingQueries {
    // https://leetcode.com/problems/mark-elements-on-array-by-performing-queries
    /** Algorithm
        1. Create a class Element that holds a boolean flag (marked) and the value of the elememnt of nums
        2. Create two arrays: indexedElements and sortedElements of type Element of size nums.length
        3. Traverse nums and populate these two arrays with the SAME referenced object idx[i] = srtd[i] = new Element(value);
            - Also calculate the sum of all nums. The unmarkedSum will be the diff between arraySum and markedSum.
        4. Sort the sortedElemens by value in increasing order.
        5. For each query
            - if indexElements[q[0]] is NOT marked, set it as marked and add the value to a markedSum
            - use an index markedIndex to keep track of last index of  sortedElements. Move that index query[1] times,
                as long as sortedElements[markedIndex].marked =  false and add that value to a markedSum
            - set the diff between arraySum and markedSum in the answer array.
     */
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long arraySum = 0L;
        Element[] indexedElements = new Element[nums.length];
        Element[] sortedElements = new Element[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexedElements[i] = sortedElements[i] = new Element(nums[i]);
            arraySum += nums[i];
        }
        Arrays.sort(sortedElements, Comparator.comparingInt(a -> a.value));
        return calculateUnmarkedSumArray(nums, queries, arraySum, indexedElements, sortedElements);
    }

    private long[] calculateUnmarkedSumArray(int[] nums, int[][] queries, long arraySum, Element[] indexedElements, Element[] sortedElements) {
        long[] unmarkedSums = new long[queries.length];
        long markedSum = 0L;
        int markingIndex = 0;
        for (int i = 0; i < queries.length && markingIndex < nums.length; i++) {
            if (!indexedElements[queries[i][0]].marked) {
                markedSum += indexedElements[queries[i][0]].value;
                indexedElements[queries[i][0]].marked = true;
            }
            for (int j = 0; j < queries[i][1] && markingIndex < nums.length; markingIndex++) {
                if (!sortedElements[markingIndex].marked) {
                    j++;
                    sortedElements[markingIndex].marked = true;
                    markedSum += sortedElements[markingIndex].value;
                }
            }
            unmarkedSums[i] = arraySum - markedSum;
        }
        return unmarkedSums;
    }

    private static class Element {
        boolean marked;
        int value;
        public Element(int value) {
            this.value = value;
        }
    }
}
