package com.ss.leetcode.LC2024.january;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeArrayEmpty {
    // https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty
    /** Algorithm
        1. Map the number and their count (group size) in a Map<Integer, Integer> numCount
        2. Iterate over each entry and determine the min operations needed for each number/group
            - If groupCount == 1, return -1 immediately as you cannot group 1 in groups of 2 or 3
            - Else, divide the groupCount by 3. If the modulo %3 ! 0, then you need an extra step to group by 2
            - eg: 7: 13/3 = 4 and modulo 1. => last 3 must be broken into 2 groups of 2: 3 + 3+ 3+ 2 + 2)
            - eg: 14 14/3 = 4 and modulo 2 => you need an extra step to take the 2: 3+3+3+3+2
        3. Return sum of operations.
    */
    public int minOperations(int[] nums) {
        Map<Integer, Integer> numCount = getNumCount(nums);
        int sum = 0;
        for (int count : numCount.values()) {
            if (count == 1) {
                return -1;
            } else {
                // sum += getOperations(int count)
                sum += (int) Math.ceil((double)count / 3);
            }
        }
        return sum;
    }

    private int getOperations(int count) {
        int sum = count / 3;
        if (count % 3 != 0) {
            sum++;
        }
        return sum;
    }

    private Map<Integer, Integer> getNumCount(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }
        return count;
    }
}
