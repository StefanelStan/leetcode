package com.ss.leetcode.LC2022.february;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    // https://leetcode.com/problems/subarray-sum-equals-k/
    /** Algorithm/Theory
     1. Take the example of [5,-2, -8, 8,3,4,6] and k = 13
     2. Start doing the cumulative sum from 1st and last, storing and countimg them into a map
     3. The cumulative sum is [5,3, -5, 3,6, 10, 16]
        and the map should be like 5 -> 1 (1 sum of 5), 3 ->2, -5 ->1, [6,10,16] -> 1
     4. Take the example of i = 4, cumulative sum = 6.
         Ask the question: could there be any previous sum (maybe 0 ->1, 0->2) that is equal to 6 - 13?
        Why? because if I remove that previousSum from current Sum, I obtain 13.
        If currentSum is 6, and one previousSum is -7, then if I remove -7 from current Sum, I will get 13.
        For i=4 (cS = 6, there is not)
     5. Take the next example: i = 6 and cs = 16. Is there a sum of 16 - 13 so that if I remove it,
        I obtain 13? Yes there are 2 of them: on pos 1 and 4. Then if i remove 3 from current cumulative sum I obtain 13.
        [-----prevSum3----prevSum3----cumSum16].
                     |---------- ------------| this must be equal to 16-3
                                |------------| this also must be equal to 16-3.
     */
    public int subarraySum(int[] nums, int k) {
        int sum =0, count = 0;
        Map<Integer, Integer> previousSum = new HashMap<>();
        for (int num : nums) {
            sum += num;
            if (sum == k) {
                count++;
            }
            count += previousSum.getOrDefault(sum - k, 0);
            previousSum.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}
