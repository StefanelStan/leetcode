package com.ss.leetcode.LC2023.september;

public class MinimumElementsToAddToFormAGivenSum {
    // https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum
    /** Algorithm
        1. Add the number of the array and get their sum.
        2. Determine the absolute of the difference between the goal and the sum.
            EG: [1,-1,1], limit =3, goal = -4
            sum = 1. The difference between sum and goal (1 - -4) = -5. Abs(-5) = 5.
        3. If the difference is ==0, return 0 as the sum equals the goal
        4. How many numbers of max 3 you need in order to obtain 3?
            - Answer: 5/3 = 1. Because 5 %3 != 0, you have a remainer, so you need one extra number.
            - If diff was 6, then 6 / 3 = 2. Becuase 6 % 3 == 0, you don't have a remainder.
     */
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        int minElements = 0;
        for (int num : nums) {
            sum += num;
        }
        long diff = Math.abs((long)goal - sum);
        if (diff != 0) {
            minElements = (int)(diff / limit);
            minElements += (diff % limit == 0 ? 0 : 1);
        }
        return minElements;
    }
}
