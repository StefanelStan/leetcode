package com.ss.leetcode.LC2022.july;

public class MaximumNumberOfPairsInArray {
    // https://leetcode.com/problems/maximum-number-of-pairs-in-array/
    /** Algorithm
         1. Count each number (0..100) and store its count in count[] array
         2. Traverse count[] array incrementing the pairs and leftOvers numbers:
         - pairs will increase by count[i]/ 2 (eg: 5 3s => 2 pairs)
         - leftOvers will increase by count[i] % 2 ( 5 % 2 = 1 , so 1 3 cannot be paired)
         3. Return new array[] {pairs, leftOvers}
     */
    public int[] numberOfPairs(int[] nums) {
        int[] count = new int[101];
        int pairs = 0, leftOvers = 0;
        for (int num : nums) {
            count[num]++;
        }
        for (int j : count) {
            pairs += j / 2;
            leftOvers += j % 2;
        }
        return new int[]{pairs, leftOvers};
    }
}
