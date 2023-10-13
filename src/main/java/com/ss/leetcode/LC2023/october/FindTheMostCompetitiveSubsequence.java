package com.ss.leetcode.LC2023.october;

import java.util.PriorityQueue;

public class FindTheMostCompetitiveSubsequence {
    // https://leetcode.com/problems/find-the-most-competitive-subsequence
    public int[] mostCompetitive(int[] nums, int k) {
        int[] mostCompetitive =  new int[k];
        int insertIndex = 0, minIndexToInsert;
        PriorityQueue<Integer> mins = new PriorityQueue<>((a,b) -> nums[a] == nums[b] ? Integer.compare(a,b) : Integer.compare(nums[a], nums[b]));
        int left = 0, right = nums.length - k, prevRightIndex= 0;
        while (insertIndex < k) {
            // remove anything out of leftSide
            while (!mins.isEmpty() && mins.peek() < left) {
                mins.poll();
            }
            // expand to right
            while(prevRightIndex <= right) {
                if (!mins.isEmpty() && nums[mins.peek()] > nums[prevRightIndex]) {
                    mins.clear();
                }
                mins.add(prevRightIndex);
                prevRightIndex++;
            }
            // poll and set the new right and left;
            minIndexToInsert = mins.poll();
            left = minIndexToInsert + 1;
            mostCompetitive[insertIndex++] = nums[minIndexToInsert];
            right = nums.length - (k - insertIndex);
        }
        return mostCompetitive;
    }
}
