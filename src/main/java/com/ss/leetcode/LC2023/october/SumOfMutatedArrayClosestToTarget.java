package com.ss.leetcode.LC2023.october;

import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget {
    // https://leetcode.com/problems/sum-of-mutated-array-closest-to-target
    public int findBestValue(int[] arr, int target) {
        NumberGroup[] numberGroups = getNumberGroup(arr);
        int closestAbsTargetDiff = Integer.MAX_VALUE, closestValue = -1, candidateSum, candidateDiff;
        int low = 0, high = numberGroups[numberGroups.length -1].value, pivot;
        while (low <= high && closestAbsTargetDiff != 0) {
            pivot = low + (high - low) / 2;
            candidateSum = applyValueAndGetValueSum(numberGroups, pivot);
            candidateDiff = Math.abs(candidateSum - target);
            if (candidateDiff < closestAbsTargetDiff) {
                closestAbsTargetDiff = candidateDiff;
                closestValue = pivot;
            } else if (candidateDiff == closestAbsTargetDiff) {
                closestValue = Math.min(closestValue, pivot);
            }
            if (candidateSum < target) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return closestValue;
    }

    private int applyValueAndGetValueSum(NumberGroup[] numberGroups, int value) {
        int index = findIndex(numberGroups, value);
        if (index == numberGroups.length) {
            return numberGroups[numberGroups.length - 1].prefixSum;
        }
        int leftSum = numberGroups[index].prefixSum;
        int elementsToModify = numberGroups[numberGroups.length - 1].prefixSumGroupSize - numberGroups[index].prefixSumGroupSize;
        if (numberGroups[index].value > value) {
            elementsToModify += numberGroups[index].groupSize;
            leftSum = (index == 0 ? 0 : numberGroups[index - 1].prefixSum);
        }
        return leftSum + (elementsToModify * value);
    }

    private int findIndex(NumberGroup[] numberGroups, int target) {
        int low = 0, high = numberGroups.length - 1, pivot;
        while(low <= high) {
            pivot = low + (high - low) / 2;
            if (numberGroups[pivot].value == target) {
                return pivot;
            } else if (numberGroups[pivot].value < target) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low;
    }

    private NumberGroup[] getNumberGroup(int[] arr) {
        Arrays.sort(arr);
        NumberGroup[] numberGroups = new NumberGroup[arr.length];
        numberGroups[0] = new NumberGroup(arr[0], 1, arr[0]);
        int insertIndex = 0, countSum = 1, prefixSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            countSum++;
            prefixSum += arr[i];
            if (arr[i] == numberGroups[insertIndex].value) {
                numberGroups[insertIndex].groupSize++;
            } else {
                insertIndex++;
                numberGroups[insertIndex] = new NumberGroup(arr[i]);
            }
            numberGroups[insertIndex].prefixSumGroupSize = countSum;
            numberGroups[insertIndex].prefixSum = prefixSum;
        }
        return Arrays.copyOf(numberGroups, insertIndex + 1);
    }

    private static class NumberGroup {
        private int value;
        private int groupSize;
        private int prefixSumGroupSize;
        private int prefixSum;

        public NumberGroup(int value) {
            this.value = value;
            this.groupSize = 1;
        }

        public NumberGroup(int value, int prefixSumGroupSize, int prefixSum) {
            this(value);
            this.prefixSumGroupSize = prefixSumGroupSize;
            this.prefixSum = prefixSum;
        }
    }
}
