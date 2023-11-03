package com.ss.leetcode.LC2023.november;

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfGoodSubarrays {
    // https://leetcode.com/problems/count-the-number-of-good-subarrays
    /** Algorithm
        1. Basic math:
            - 2 identical numbers (eg [1,1]) can form 1 pair
            - 3 identical nrs can form 3 pairs (1 ->[2,3], 2->[3])
            - 4 identical nrs can form 6 pairs. 1->[2,3,4], 2->[3,4], 3->[4]
        2. Looking at the example with 4 pairs, we observe a pattern: 3 + 2 + 1 => sum of first n-1 numbers.
            If you have 60 identical numbers, they can form (1+2+3..+59 pairs). (59*60/2)
        3. Use 2 pointers, (left/right) to expand a window over which you will count/group the numbers
        4. Use a Map<Integer, Integer> to map the numbers.
        5. Move right pointer to right while your window has less than k pairs.
        6. Once your window has >=k pairs, then ALL the subarrays that start with left index and include the right index will be a good subarray
            eg: [a,b,c,d,e,a,f,g,h,i,j,m], k = 1
            - your right pointer will move until it reaches index 5. At this index you will have 1 pair, satisfying the k condition
            - this means that the substring [0,5] is good, but also [0,6], [0,7] .. [0,11] => 1 + (11 - 5) good substrings
        7. Now move left pointer until your number of pairs is less than k. While move left to right, if you still have >= k pairs, recalculate them.
            - EG: [a,b,c,d,e,f,c, g,h,i,j,m], k = 1. Your left will be at 0 and right at 6, having 6 substrings
            - when you move left to index 1, you still have 1 pair and 6 good substrings: [1,6], [1,7].. [1,11]
     */
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        long goodSubarrays = 0, pairsInWindow = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            while (right < nums.length && pairsInWindow < k) {
                pairsInWindow += numCount.merge(nums[right], 1, Integer::sum) - 1;
                right++;
            }
            if (pairsInWindow >= k) {
                goodSubarrays += 1 + nums.length - right;
            }
            while (left < right && pairsInWindow >= k) {
                pairsInWindow -= numCount.merge(nums[left], -1, Integer::sum);
                if (pairsInWindow >= k) {
                    goodSubarrays += 1 + nums.length - right;
                }
                left++;
            }
        }
        return goodSubarrays;
    }
}
