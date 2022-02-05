package com.ss.leetcode.LC2021.february;

import java.util.ArrayList;
import java.util.List;

public class ContiguousArray {
    // https://leetcode.com/problems/contiguous-array/
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int[][] leftCount =  new int[2][nums.length];
        int[][] rightCount = new int[2][nums.length];
        countDigits(nums, leftCount, rightCount);
        int intervalZeroes, intervalOnes, tempDiff;
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = nums.length -1; j > i && j - i > maxLength;) {
                intervalZeroes = leftCount[0][nums.length -1] - (getLeftCount(leftCount[0], i) + getRightCount(rightCount[0], j));
                intervalOnes = leftCount[1][nums.length -1] - (getLeftCount(leftCount[1], i) + getRightCount(rightCount[1], j));
                tempDiff = Math.abs(intervalOnes - intervalZeroes);
                if (tempDiff == 0) {
                    maxLength = Math.max(maxLength, intervalOnes * 2);
                    break;
                } else {
                    j -= tempDiff;
                }
            }
        }
        return maxLength;
    }

    private int getLeftCount(int[] leftCount, int i) {
        return i == 0 ? 0 : leftCount[i-1];
    }

    private int getRightCount(int[] rightCount, int i) {
        return i == rightCount.length -1 ? 0 : rightCount[i+1];
    }

    private void countDigits(int[] nums, int[][] leftCount, int[][] rightCount) {
        leftCount[0][0] = nums[0] == 0 ? 1 : 0;
        leftCount[1][0] = nums[0] == 1 ? 1: 0;
        rightCount[0][nums.length - 1] = nums[nums.length -1] == 0 ? 1 : 0;
        rightCount[1][nums.length - 1] = nums[nums.length -1] == 1 ? 1 : 0;
        for (int i = 1, j = nums.length -2; i < nums.length; i++, j--) {
            if (nums[i] == 0) {
                leftCount[0][i] = leftCount[0][i-1] + 1;
                leftCount[1][i] = leftCount[1][i-1];
            } else {
                leftCount[0][i] = leftCount[0][i-1];
                leftCount[1][i] = leftCount[1][i-1] + 1;
            }
            // check rightCount;
            if (nums[j] == 0) {
                rightCount[0][j] = rightCount[0][j+1] + 1;
                rightCount[1][j] = rightCount[1][j+1];
            } else {
                rightCount[0][j] = rightCount[0][j+1];
                rightCount[1][j] = rightCount[1][j+1] + 1;
            }
        }

    }

    public int findMaxLength2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 2 && nums[0] != nums[1]) {
            return 2;
        }
        return getMaxLength(nums);
    }

    private int getMaxLength(int[] nums) {
        int evenStoppingPoint = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        int oddStoppingPoint = nums.length % 2 == 0 ? nums.length - 1 : nums.length - 2;
        List<int[]> countedElements = countElements(nums);
        int[] numberOfZeroes = countedElements.get(0);
        int[] numberOfOnes = countedElements.get(1);
        int maxContigousLength = 0;
        int currentDifference = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i % 2 == 0 ? oddStoppingPoint : evenStoppingPoint; j > i; j -= 2) {
                currentDifference = (j - i) + 1;
                if (maxContigousLength > currentDifference) {
                    break;
                } else if (getIntervalCount(numberOfOnes, j, i) == getIntervalCount(numberOfZeroes, j, i) && currentDifference > maxContigousLength) {
                    maxContigousLength = currentDifference;
                    break;
                }
            }
        }
        return maxContigousLength;
    }

    private List<int[]> countElements(int[] nums) {
        List<int[]> countedElements = new ArrayList<>();
        int[] numberOfZeroes = new int[nums.length];
        int[] numberOfOnes = new int[nums.length];
        int nrOfZeroes = 0;
        int nrOfOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nrOfZeroes++;
            } else {
                nrOfOnes++;
            }
            numberOfZeroes[i] = nrOfZeroes;
            numberOfOnes[i] = nrOfOnes;
        }
        countedElements.add(numberOfZeroes);
        countedElements.add(numberOfOnes);
        return countedElements;
    }

    private int getIntervalCount(int[] counts, int j, int i) {
        if (i == 0) {
            return counts[j];
        } else {
            return counts[j] - counts[i -1];
        }
    }
}
