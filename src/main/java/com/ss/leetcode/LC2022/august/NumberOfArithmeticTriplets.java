package com.ss.leetcode.LC2022.august;

public class NumberOfArithmeticTriplets {
    // https://leetcode.com/problems/number-of-arithmetic-triplets/
    /** Algorithm [0,1,4,6,7,10], 3
         1. Use a boolean[201] to mark the present numbers.
             It's an O(n) operation, but it will answer in O(1) if a number is present or not.
         2. Start from the last index and calculate the 2 steps difference:
            - index = 5. diff1 = 10-3(7) and diff2 = 7-3 (diff1 - diff) = 4.
             Are 7 and 4 present? (present[7] and present[3]) Yes, then increase the counter.
            - index = 4. diff1 = 7-3(4), diff2 = 4-3(1). Are 4 and 1 present? yes. Increase the counter.
            - index = 3. diff1 = 6-3(3), diff2 = 3-3(0). 3 is not present.
            - index = 2. diff1 = 4-3(1), diff2 = 1-3(-2). -2 is not present.
         3. Return the count of triplets.
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        int triples = 0, diff1, diff2;
        boolean[] presentNums = getPresentNums(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            diff1 = nums[i] - diff;
            diff2 = diff1 - diff;
            if (diff1 >= 0 && diff2 >= 0 && presentNums[diff1] && presentNums[diff2]) {
                triples++;
            }
        }
        return triples;
    }

    private boolean[] getPresentNums(int[] nums) {
        boolean[] presentNums = new boolean[nums[nums.length -1] + 1];
        for(int num: nums) {
            presentNums[num] = true;
        }
        return presentNums;
    }
}
