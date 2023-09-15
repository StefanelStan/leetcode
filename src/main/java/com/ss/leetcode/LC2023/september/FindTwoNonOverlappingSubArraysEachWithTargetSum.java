package com.ss.leetcode.LC2023.september;

import java.util.Arrays;

public class FindTwoNonOverlappingSubArraysEachWithTargetSum {
    // https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum
    /** Algorithm
        1. Use a sliding window to calculate the sums of number in window
        2. Use a sumSoFar[n] to keep track of MINIMUM segment/window sizes that have the sum == target
        3. If window has a sum, update the sumSoFar[i] with the windowSize OR minSoFar
        4. If sumSoFar also has another valid entry at index left - 1, (so another window exists) calculate the min sum of the 2 windows
     */
    public int minSumOfLengths(int[] arr, int target) {
        int size = 1;
        int[] sumsSoFar = new int[arr.length];
        Arrays.fill(sumsSoFar, arr.length + 1);
        int bestSum = arr.length + 1;
        int left = 0, right = 0, currentSum = arr[0];
        while (right < arr.length && left < arr.length) {
            if (currentSum == target) {
                if (left - 1 >= 0) {
                    bestSum = Math.min(bestSum, sumsSoFar[left - 1] + size);
                }
                sumsSoFar[right] = Math.min(size, sumsSoFar[Math.max(0, right - 1)]);
                currentSum -= arr[left];
                left++;
                right = Math.max(right, left - 1);
                size--;
            } else if (currentSum < target) {
                sumsSoFar[right] = Math.min(sumsSoFar[right], sumsSoFar[Math.max(0, right - 1)]);
                if (right < arr.length - 1) {
                    right++;
                    currentSum += arr[right];
                    size++;
                } else {
                    break;
                }
            } else {
                sumsSoFar[right] = Math.min(sumsSoFar[right], sumsSoFar[Math.max(0, right - 1)]);
                currentSum -= arr[left];
                left++;
                right = Math.max(right, left - 1);
                size--;
            }
        }
        return bestSum >= arr.length + 1 ? -1 : bestSum;
    }

    public int minSumOfLengths2(int[] arr, int target) {
        int minSumLength = arr.length + 1;
        Window window = new Window(arr);
        int[] minSumSoFar = new int[arr.length];
        Arrays.fill(minSumSoFar, arr.length +1);
        boolean canAdvance = true;
        while (canAdvance) {
            if (window.sum == target) {
                if (window.left - 1 >= 0) {
                    minSumLength = Math.min(minSumLength, minSumSoFar[window.left - 1] + window.size);
                }
                minSumSoFar[window.right] = Math.min(window.size, minSumSoFar[Math.max(0, window.right - 1)]);
                canAdvance = window.shrink();
            } else if (window.sum < target) {
                canAdvance = window.advance();
                minSumSoFar[Math.max(0, window.right - 1)] = Math.min(minSumSoFar[Math.max(0, window.right - 1)], minSumSoFar[Math.max(0, window.right - 2)]);
            } else {
                minSumSoFar[window.right] = Math.min(minSumSoFar[window.right], minSumSoFar[Math.max(0, window.right - 1)]);
                canAdvance = window.shrink();
            }
        }
        return minSumLength == arr.length + 1 ? -1 : minSumLength;
    }

    private static class Window {
        int size;
        int sum;
        int left;
        int right = - 1;
        int[] numbers;

        public Window(int[] arr) {
            this.numbers = arr;
        }

        public boolean advance() {
            if (right < numbers.length - 1) {
                right++;
                sum += numbers[right];
                size++;
                return true;
            } else {
                return false;
            }
        }

        public boolean shrink() {
            if (left < numbers.length) {
                sum -= numbers[left];
                size--;
                left++;
                right = Math.max(left -1, right);
                return true;
            } else {
                return false;
            }
        }
    }
}
