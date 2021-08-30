package com.ss.leetcode.august;

public class RotateArray {
    // https://leetcode.com/problems/rotate-array/
    public void rotate(int[] nums, int k) {
        if (k == nums.length) {
            return;
        }
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newPosition = i + k >= nums.length ? (i + k) % nums.length : i + k;
            answer[newPosition] = nums[i];
        }
        System.arraycopy(answer, 0, nums, 0, nums.length);
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;

        rotateInPlace(nums, 0, nums.length-1);
        rotateInPlace(nums, 0, k-1);
        rotateInPlace(nums, k, nums.length-1);
    }

    private void rotateInPlace(int[] nums, int start, int end) {
        int temp;
        while (start <= end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
