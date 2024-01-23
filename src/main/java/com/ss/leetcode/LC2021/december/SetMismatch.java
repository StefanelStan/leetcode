package com.ss.leetcode.LC2021.december;

public class SetMismatch {
    // https://leetcode.com/problems/set-mismatch/
    public int[] findErrorNums(int[] nums) {
        int sum = 0, duplicated = 0, temp;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length;) {
            if (nums[i] != i + 1) {
                temp = nums[nums[i] - 1];
                if (nums[i] == nums[nums[i] - 1]) {
                    duplicated = nums[i];
                    i++;
                    continue;
                }
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        int missing = nums.length * (nums.length + 1) / 2 - (sum - duplicated);
        return new int[]{duplicated, missing};
    }

    public int[] findErrorNums2(int[] nums) {
        boolean[] present = new boolean[nums.length +1];
        int duplicate = 0;
        int sum = 0;
        for (int num : nums) {
            if (present[num]) {
                duplicate = num;
            }
            present[num] = true;
            sum += num;
        }
        int expectedSum = (1 + nums.length) * (nums.length /2);
        if (nums.length % 2 != 0) {
            expectedSum += ((1 + nums.length) / 2);
        }
        return new int[]{duplicate, expectedSum - (sum - duplicate)};
    }
}
