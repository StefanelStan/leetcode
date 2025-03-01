package com.ss.leetcode.LC2022.november;

public class ApplyOperationsToAnArray {
    // https://leetcode.com/problems/apply-operations-to-an-array/
    /** Algorithm
        1. Use an int[] applied to store the answer
        2. Traverse nums and if current number is not zero
            - insert into applied the double value of current number
            - set next number to zero
     */
    public int[] applyOperations(int[] nums) {
        int[] applied =  new int[nums.length];
        int insertIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                if (nums[i] == nums[i + 1]) {
                    applied[insertIndex++] = 2 * nums[i];
                    nums[i + 1] = 0;
                } else {
                    applied[insertIndex++] = nums[i];
                }
            }
        }
        applied[insertIndex] = nums[nums.length - 1];
        return applied;
    }


    /** Algorithm
     *  1. Use an int[] answer to keep the answer: doubles and zeroes in order to avoid modifying the original array
     *  2. If i == i+1, set i = 2*i and i+1 to zero.
     *  3. Pay attention to last element.
     *  4. Swap the zeroes using 2 points: one for current i and one for last known zero/available position.
     */
    public int[] applyOperations2(int[] nums) {
        int[] answer = multiplyAndZero(nums);
        shiftZeroes(answer);
        return answer;
    }

    private int[] multiplyAndZero(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] == nums[i+1]) {
                answer[i] = 2 * nums[i];
                i++;
            } else {
                answer[i] = nums[i];
                answer[i+1] = nums[i+1];
            }
        }
        if (answer[nums.length - 2] == 0) {
            answer[nums.length - 1] = nums[nums.length - 1];
        }
        return answer;
    }

    private void shiftZeroes(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroIndex] = nums[i];
                if (zeroIndex != i) {
                    nums[i] = 0;
                }
                zeroIndex++;
            }
        }
    }
}
