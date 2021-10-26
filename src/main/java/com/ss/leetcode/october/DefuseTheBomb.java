package com.ss.leetcode.october;

public class DefuseTheBomb {
    // https://leetcode.com/problems/defuse-the-bomb/
    /**
     * Algorithm: 1. Calculate and cache the sum of number starting from left and starting from right.
     *  This way if we have 2 indices, we can calculate the sum of the segment by deducting sum of left + sum of right from the total sum
     */
    public int[] decrypt(int[] code, int k) {
        int[] decrypt = new int[code.length];
        if (k == 0) {
            return decrypt;
        }
        int[] leftSum = new int[code.length];
        int[] rightSum = new int[code.length];
        initializeSums(leftSum, rightSum, code);
        if (k > 0 ) {
            decryptPositives(decrypt, leftSum, rightSum, k);
        } else {
            decryptNegatives(decrypt, leftSum, rightSum, k);
        }
        return decrypt;
    }

    // calculate in case we deal with positive K. Pay attention to the fact that i +k > code.length. This way we have two windows:
    private void decryptPositives(int[] decrypt, int[] leftSum, int[] rightSum, int k) {
        for (int i = 0; i < decrypt.length; i++) {
            if (i + k < decrypt.length) {
                decrypt[i] = rightSum[0] - (leftSum[i] + (i + k == decrypt.length - 1 ? 0 : rightSum[i + k + 1]));
            } else {
                decrypt[i] = ((i == decrypt.length -1 ? 0 : rightSum[i + 1]) + leftSum[i + k - decrypt.length]);
            }
        }
    }

    // calculate in case we deal with negative K. Pay attention to the fact that i +k < 0 -> we have two windows:
    private void decryptNegatives(int[] decrypt, int[] leftSum, int[] rightSum, int k) {
        for (int i = 0; i < decrypt.length; i++) {
            if (i + k >= 0) {
                int left = ((i + k == 0 ? 0 : leftSum[i + k - 1]));
                int right = (i > decrypt.length - 1? 0 : rightSum[i]);
                decrypt[i] = rightSum[0] - (left + right);
            } else {
                decrypt[i] = (i -1 < 0 ? 0 : leftSum[i -1]) + rightSum[decrypt.length + i + k];
            }
        }
    }

    private void initializeSums(int[] leftSum, int[] rightSum, int[] nums)  {
        leftSum[0] = nums[0];
        rightSum[rightSum.length - 1] = nums[nums.length -1];

        for(int i = 1, j = nums.length -2; j >= 0; i++, j--) {
            leftSum[i] += leftSum[i-1] + nums[i];
            rightSum[j] = rightSum[j + 1] + nums[j];
        }
    }
}
