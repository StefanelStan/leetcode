package com.ss.leetcode.august;

import java.util.Arrays;

public class MoveZeroes {
    // https://leetcode.com/problems/move-zeroes/
    public void moveZeroes(int[] nums) {
        int j = 0, nrOfZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            } else {
                nrOfZero++;
            }
        }
        Arrays.fill(nums, nums.length - nrOfZero, nums.length, 0);
    }

   public void moveZeroes2(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int zeroCount = 0;
        boolean overZeroSequence = false;
        TargetInsertion targetInsertion = new TargetInsertion();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                if (!overZeroSequence) {
                    overZeroSequence = true;
                    if (targetInsertion.insPos == -1) {
                        targetInsertion.insPos = i;
                    }
                }
            } else if (nums[i] != 0 && overZeroSequence) {
                overZeroSequence = false;
                i = shiftCharsLeftByDistance(nums, i, targetInsertion);
            }
        }
        if (zeroCount > 0) {
            Arrays.fill(nums, nums.length - zeroCount, nums.length, 0);
        }
    }

    private int shiftCharsLeftByDistance(int[] nums, int start, TargetInsertion targetInsertion) {
        int j = start;
        for (int insertPos = targetInsertion.insPos; j < nums.length && nums[j] != 0; insertPos++, j++) {
            nums[insertPos] = nums[j];
        }

        targetInsertion.insPos = j - (start - targetInsertion.insPos);
        return j - 1;
    }

    static class TargetInsertion {
        int insPos = -1;
    }
}
