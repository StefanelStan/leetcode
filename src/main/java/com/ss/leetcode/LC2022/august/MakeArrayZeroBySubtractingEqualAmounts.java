package com.ss.leetcode.LC2022.august;

public class MakeArrayZeroBySubtractingEqualAmounts {
    // https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
    /** Algorithm
         1. Take the example of [7,1,5,0,3,5,6].
         2. Let's look at a sorted view of this: [0,1,1,3,5,5,6,7]
         3. Following the instructions, we would chose 1 (smallest greater than 0) and deduct
             it from every other nr >= than this number.
             Our array would become [0,0,0,2,4,4,5,6].
         4. Following this, we would chose 2 => [0,0,0,0,2,2,3,4].
             2 again => [0,0,0,0,0,0,1,2]
             1 => [0,0..,0,1]
             1 => [0,......0]
         5. As we can observe, with each pick of the smallest number, all the other numbers decrease.
             So, in fact, we need to know how many distinct numbers are in total, as each of them
             will be picked by turn and deducted from all others.
         6. Declare a boolean[101] (or Set<Integer>) and check & count (count of you use boolean[])
             if the current number is > 0 and if it has not been added.
             If not, add and increase the count.
         7. Return the count or set size.
     */
    public int minimumOperations(int[] nums) {
        boolean[] present = new boolean[101];
        int distinctElements = 0;
        for (int num : nums) {
            if (num > 0 && !present[num]) {
                present[num] = true;
                distinctElements++;
            }
        }
        return distinctElements;
    }
}
