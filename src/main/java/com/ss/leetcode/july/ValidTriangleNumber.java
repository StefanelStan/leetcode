package com.ss.leetcode.july;

import java.util.Arrays;

public class ValidTriangleNumber {
    // https://leetcode.com/problems/valid-triangle-number/
    public int triangleNumber(int[] nums) {
        int validTriangles = 0;
        if (nums.length < 3) return validTriangles;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                for (int j = i - 1; j > 0; j--) {
                    if (nums[j] + nums[0] > nums[i]) {
                        validTriangles += j;
                    } else {
                        for (int k = j - 1; k >= 0; k--) {
                            if (nums[i] + nums[k] > nums[j] && nums[j] + nums[k] > nums[i]) {
                                validTriangles++;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return validTriangles;
    }
}
