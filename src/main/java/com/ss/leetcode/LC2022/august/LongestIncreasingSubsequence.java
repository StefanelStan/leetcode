package com.ss.leetcode.LC2022.august;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    /**
     *  Algorithm
     *      1. Keep track of the longest increasing sequence for each element in a seqLengths[] array.
     *      2. Also, keep track on the longest so far found sequences. The target seq might just be there
     *      3. If we cannot find a compelling sequence in the foundSequences so far, search on right side for a nr > index
     *         and keep track of best case. Update the seqLengths and maybe foundSequences if it's the case.
     *      4. Return foundSequences.get(0)[1]
     */
    public int lengthOfLIS(int[] nums) {
        // {startValue, length}
        List<int[]> longestSeqs = new ArrayList<>();
        int[] seqLengths = new int[nums.length];
        seqLengths[nums.length - 1] = 1;
        longestSeqs.add(new int[]{nums[nums.length -1], 1});
        for (int i = nums.length - 2; i >= 0; i--) {
            int canAddToLongest = canAddToLongestSeq(nums, i, longestSeqs);
            if (canAddToLongest >= 0) {
                seqLengths[i] = longestSeqs.get(0)[1];
            } else {
                // look for longestSeq
                seqLengths[i] = searchForNextLongestSeq(nums, i, longestSeqs, seqLengths);
            }
        }
        return longestSeqs.get(0)[1];
    }

    // return state of this; was added successfully, was not added, was = with head
    private int canAddToLongestSeq(int[] nums, int i, List<int[]> longestSeqs) {
        int[] longestFoundSeq = null;
        boolean foundEqualSeq = false;
        for (int[] longSeq : longestSeqs) {
            if (nums[i] < longSeq[0]) {
                longestFoundSeq = longSeq;
                break;
            } else if (nums[i] == longSeq[0]) {
                foundEqualSeq = true;
            }
        }
        if (longestFoundSeq != null) {
            longestFoundSeq[0] = nums[i];
            longestFoundSeq[1]++;
            longestSeqs.clear();
            longestSeqs.add(longestFoundSeq);
            return longestFoundSeq[1];
        }
        return foundEqualSeq ? 0 : -1;
    }

    // manually check of right side for best/longest possible sequence
    private int searchForNextLongestSeq(int[] nums, int index, List<int[]> longestSeqs, int[] seqLengths) {
        int[] bestMatch = {nums[index], 1};
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] < nums[i] && seqLengths[i] >= bestMatch[1]) {
                bestMatch[1] = seqLengths[i] + 1;
            }
        }

        if (bestMatch[1] == longestSeqs.get(0)[1]) {
            longestSeqs.add(bestMatch);
        }
        return bestMatch[1];
    }

}
