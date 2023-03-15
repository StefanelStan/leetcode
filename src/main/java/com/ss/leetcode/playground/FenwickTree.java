package com.ss.leetcode.playground;

public class FenwickTree {
    private int[] fenArray;
    public FenwickTree(int[] nums) {
        fenArray = new int[nums.length + 1];
        constructFenTree(nums);
    }

    private void constructFenTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            updateFenwick(i, nums[i]);
        }
    }

    public void updateFenwick(int idx, int num) {
        idx = idx + 1;
        while (idx < fenArray.length) {
            fenArray[idx] = fenArray[idx] + num;
            idx +=  idx & (-idx);
        }
    }

    public int getPrefixSum(int idx) {
        int total = 0;
        idx = idx + 1;
        // Traversing the ancestors of the fenTree[idx]
        while (idx > 0) {
            total += fenArray[idx];
            idx -= idx & (-idx);
        }
        return total;
    }

    public int getRangeSum(int left, int right) {
        return getPrefixSum(right) - getPrefixSum(left - 1);
    }
}
