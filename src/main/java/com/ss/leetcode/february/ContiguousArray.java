package com.ss.leetcode.february;

import java.util.ArrayList;
import java.util.List;

public class ContiguousArray {
    // https://leetcode.com/problems/contiguous-array/
    public int findMaxLength(int[] nums) {
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
