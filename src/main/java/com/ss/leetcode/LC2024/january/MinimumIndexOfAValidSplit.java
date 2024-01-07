package com.ss.leetcode.LC2024.january;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexOfAValidSplit {
    // https://leetcode.com/problems/minimum-index-of-a-valid-split
    /** Algorithm
        1. For an element to be dominant across two subarrays, it needs to be dominant across whole array
        2. Traverse the array and count each number/occurance. (EG:use a Map<Integer, Integer>) to determine the dominant. (number, count)
        3. If you NOT have a dominant number (count * 2 > size), return -1 immediately.
        4. Traverse the array and prefix count the dominant check LEFT/RIGHT for having the dominant
            - LEFT subarray: prefixCount * 2 > (index +1)
            - RIGHT subarray: 2 * (totalCount - prefixCount) > (nums.size() - index - 1)
        5. If LEFT and RIGHT have the dominant, return the index i
        6. Return -1 by default (edge case: 112): the array has dominant but you can't split the array in 2 subarrays.
     */
    public int minimumIndex(List<Integer> nums) {
        int[] valueAndCount = getValueAndCount(nums);
        return valueAndCount == null ? -1 : findMinIndex(nums, valueAndCount[0], valueAndCount[1]);
    }

    private int findMinIndex(List<Integer> nums, int value, int count) {
        int occurences = 0, index = 0;
        for (int num : nums) {
            if (num == value) {
                occurences++;
                if (occurences * 2 > (index + 1) && (2 * (count - occurences) > (nums.size() - index - 1))) {
                    return index;
                }
            }
            index++;
        }
        return -1;
    }

    private int[] getValueAndCount(List<Integer> nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int targetValue = -1;
        for (int num : nums) {
            if (countMap.merge(num, 1, Integer::sum) * 2 > nums.size()) {
                targetValue = num;
            }
        }
        return targetValue == -1 ? null : new int[]{targetValue, countMap.get(targetValue)};
    }
}
