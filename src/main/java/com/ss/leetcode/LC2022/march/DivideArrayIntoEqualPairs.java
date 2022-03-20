package com.ss.leetcode.LC2022.march;

public class DivideArrayIntoEqualPairs {
    // https://leetcode.com/problems/divide-array-into-equal-pairs/
    /** Algorithm
         1. In order for the condition to be satisfied, each number has to be present an even number of times.
             EG: [3,2,3,2,2,2] => 4 nums of 2 and  2 nums of 3 and. Their cardinal is even
             [3,2,2,2,2,2] => 5 nums of 2 and 1 num of 3. 5 and 1 are odd, so they cannot form pairs.
         2. Based on this, count all the nums of nums and store them in a count[] array
         3. Loop over the count[] and immediately return false if count[i] is odd
         4. Return true at the end (if step 3 does not return false).
     */
    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0) {
            return false;
        }

        int[] numCount = new int[501];
        for (int num : nums) {
            numCount[num]++;
        }
        for (int count : numCount) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
