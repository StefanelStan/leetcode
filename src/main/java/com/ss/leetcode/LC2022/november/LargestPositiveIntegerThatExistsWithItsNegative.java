package com.ss.leetcode.LC2022.november;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    // https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
    /** Algorithm
         1. Use a boolean[2001] to mark the presence of the number range -1000..1000.
         2. The interval 0,1000 will be reserved for negative numbers and 1001..2000 for positive
         3. If num if negative, mark -num as present
            eg: -3 -> present[3] = true;
            Also check if present[3 + 1000] = true. If so, retain this maxCandidate
         4. If num is positive, mark [num + 1000] as true;
            eg: 5 -> present[1005] = true;
            If present[num] = true, then this is also a candidate.
            -5 will be marked as [5] so [5], [1005] will represent -5, 5.
         5. Return the max K.
     */
    public int findMaxK(int[] nums) {
        boolean[] present = new boolean[2001];
        int maxPositive = -1;
        for (int num : nums) {
            if (num < 0) {
                // -5 : -5 will be marked as [5]. Its positive side will be marked as 1005.
                present[-num] = true;
                if (present[-num + 1000]) {
                    maxPositive = Math.max(maxPositive, -num);
                }
            } else {
                // eg: 5. mark 1005 as present. Also check if 5 (representation of -5) is present.
                present[num + 1000] = true;
                if (present[num]) {
                    maxPositive = Math.max(maxPositive, num);
                }
            }
        }
        return maxPositive;
    }
}
