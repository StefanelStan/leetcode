package com.ss.leetcode.LC2023.february;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {
    // https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference
    /** Algorithm
        1. Utilize a Map<Integer, Integer> previousNums to mark the presence of numbers and their longest chain
        2. Traverse arr and see if num - diff is present in the map. If yes, get it's chain value and set map(num, value +1).
            EG: [7,9,11, 14, 16] diff = 2
            i = 0 : previousNums.get (7-2) == null. We don't have 5. Set previousNums(7,0). Longest chain 7 can make is 0
            i = 1 : previousNums.get(9-2). We have mapping(7 -> 0) So 9 can make a mapping of 0 + 1 length
            Set previousNums(9,1) (number 9 when linked to number 7 can make a chain on length 1)
            i = 2 : previousNums.get(11-2) We have mapping (9 -> 1) . It means 11 linked to 9 can make a chain of size 1 + 1 = 2.
            Set previousNums(11,2).
            i = 3 : previousNums.get(14-2) == null. We don't have 12. Set previousNums(14,0).
            i = 4 : previousNums.get(16-2) => We have mapping (14 -> 0). 16 linked to 14 can make a chain 0 + 1 length.
        3. As we traverse this, keep track of the max chain that can be made. In our case is 2.
        4. Return maxChain + 1.
     */
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> previousNums = new HashMap<>();
        int maxLength = 0;
        for (int num : arr) {
            Integer present = previousNums.get(num - difference);
            if (present != null) {
                previousNums.put(num, present + 1);
                maxLength = Math.max(maxLength, present + 1);
            } else {
                previousNums.put(num, 0);
            }
        }
        return maxLength + 1;
    }
}
