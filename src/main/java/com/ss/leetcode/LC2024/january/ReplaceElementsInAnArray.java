package com.ss.leetcode.LC2024.january;

import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsInAnArray {
    // https://leetcode.com/problems/replace-elements-in-an-array
    /** Algorithm
        1. All numbers of nums are unique and all operations from/to will not create duplications of same number
        2. Use a Map<Integer, Integer> to map the position of each number in the arrray
        3. For each operation
            - get the position from the map
            - put the new number in the nums array at fetched position
            - replace the old mapping with the new mapping (op[1] will sit at the prev pos instead of op[0])
     */
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> positions = getPositions(nums);
        for (int[] operation : operations) {
            applyReplacement(operation[0], operation[1], positions, nums);
        }
        return nums;
    }

    private void applyReplacement(int num, int replacement, Map<Integer, Integer> positions, int[] nums) {
        int oldPos = positions.remove(num);
        nums[oldPos] = replacement;
        positions.put(replacement, oldPos);
    }

    private Map<Integer, Integer> getPositions(int[] nums) {
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            positions.put(nums[i], i);
        }
        return positions;
    }
}
