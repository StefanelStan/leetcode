package com.ss.leetcode.LC2023.june;

import java.util.Arrays;

public class MaximumStrengthOfAGroup {
    // https://leetcode.com/problems/maximum-strength-of-a-group
    /** Algorithm
        1. In order to pick up the best group, you need to consider the edge cases
            - Do you have an odd or even number of negative numbers? If even, then all must be multiplied
            - If odd, you need to ditch the largest negative: eg: -6,-5,-2: Selecting -6 * -5 renders 30
            - Do you have only one negative number and 0 ? 0 is the best answer
        2. Count the negative and 0 nums. Also sort them
        3. From index i = 0 to last one
            - If number is negative and you have an even number of negative nums OR (odd number of negatives and their remaining count > 1),
                multiply that number.
            - If number if > 0, add it no matter what.
        4. Also use a boolean flag to mark if number has been modified (or you can use the count of negative + zeroes)
            - If yes, return it
            - if No, check if you have a single negative and zero (to return 0) or just the single number in list.
     */
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        // count negtives and zeroes
        int[] signCount = getSignCount(nums);
        long maxStrength = 1L;
        boolean multiplied = false;
        boolean hasOddNegatives = signCount[0] % 2 == 1;
        for (int num : nums) {
            if (num < 0) {
                if (!hasOddNegatives || signCount[0] > 1) {
                    maxStrength *= num;
                    signCount[0]--;
                    multiplied = true;
                }
            } else if (num > 0) {
                maxStrength *= num;
                multiplied = true;
            }
        }
        return multiplied ? maxStrength : signCount[1] == 0 ? nums[0] : 0;
    }

    private int[] getSignCount(int[] nums) {
        int[] signCount = new int[2];
        for (int num : nums) {
            if (num < 0) {
                signCount[0]++;
            } else if (num == 0) {
                signCount[1]++;
            }
        }
        return signCount;
    }
}
