package com.ss.leetcode.LC2023.november;

import java.util.Arrays;

public class ReductionOperationsToMakeTheArrayElementsEqual {
    // https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal
    /** Algorithm: EG: [3,1,3,1,5]
         1. In order to bring 5 to 1 you need to make it 3 and them from 3 to 1. Thus 2 steps
            - In order to bring 3 to 1, you need to make it 1 (so 1 step)
        2. Look at this in a sorted group order: 1 -> 2, 3 ->2, 5 -> 1. (2 1s, 2 3s and 1 of 5)
            - The distance between the 2 3s to 1 is 1 step. So the 2 numbers of 3 will be reduced in 2 steps. (2x1)
                (groupSize x stepDistance)
            - The distance between 5 and 1 is 2. So that 5 will need 1 x 2 steps to reach 1.
        3. You can put the nums in a TreeMap <Int, Int> (value, count) and traverse it
        4. Sort the numbers: 1,1,3,3,5
        5. Traverse the array and use a total and stepDistance to keep track of how many diff numbers you are away from the minimum.
        6. If current == prev, then add stepDistance to total
        7. If current != prev, then you are 1 step further from the min. So increase stepDistance and add it to total.
     */
    public int reductionOperations(int[] nums) {
        int total = 0, order = 0;
        Arrays.sort(nums);
        int prev = nums[0];
        for (int num : nums) {
            order += (prev == num ? 0 : 1);
            total += order;
            prev = num;
        }
        return total;
    }
}
