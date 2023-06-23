package com.ss.leetcode.LC2023.june;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    // https://leetcode.com/problems/longest-arithmetic-subsequence
    /** Algorithm
        1. Use a Map<Integer, Integer>[nums.length] to store the maps of longest subseq of each position against the given diff.
            pos[4] will map the longest subseq of every possible diff on its left:
            - EG: [5,6,1,7]
            - pos[1] = 6. 6 will have a mapping:
                [5 -> 1] (6-1 = 5. A diff of 5 has the longest subseq length 1)
                [-1 -> 1] (6 - 7 . A diff of -1 will have the longest subseq of length 1)
            - pos[0] = 5. 5 will have mapping
                [-1 -> 2] (5-6 = -1. As 6 has a mapping for -1, just add it)
                [4 -> 1] (5-1 = 4. )
                [-2 -> 1] (5-7)
        2. For each i n-1..0, for each j = i+1 ..n-1
            - Determine the diff between nums[i] and nums[j].
            - Check if this diff doesn't exist in the mapping of nums[j].
            - Set the mapping of diff on nums[i] to be mapping[nums[j]] if mapping[nums[j]] >= mapping[nums[i]];
        3. Return the longest diff ever recorded.
     */
    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Integer>[] subsequences = new Map[nums.length];
        int longest = 0, diff, nextSeqLength, currentMax;
        for (int i = nums.length -1 ; i >= 0; i--) {
            subsequences[i] = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                diff = nums[i] - nums[j];
                currentMax = subsequences[i].getOrDefault(diff, 1);
                nextSeqLength = subsequences[j].getOrDefault(diff, 1);
                if (nextSeqLength >= currentMax) {
                    subsequences[i].put(diff, ++nextSeqLength);
                    longest = Math.max(longest, nextSeqLength);
                }
            }
        }
        return longest;
    }
}
