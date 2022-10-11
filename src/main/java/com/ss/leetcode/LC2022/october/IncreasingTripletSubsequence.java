package com.ss.leetcode.LC2022.october;

import java.util.Arrays;
import java.util.LinkedList;

public class IncreasingTripletSubsequence {
    // https://leetcode.com/problems/increasing-triplet-subsequence/
    // TLE
    public boolean increasingTriplet(int[] nums) {
        if (nums.length <= 3) {
            return nums.length < 3 ? false : nums[0] < nums[1] && nums[1] < nums[2];
        } else {
            int[][] nextGreaterNumbers = parseAndGetNextGreaterNumber(nums);
            if (nextGreaterNumbers == null) {
                return false;
            }
            boolean found = false;
            Arrays.sort(nextGreaterNumbers, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            for (int i = nums.length -2; i >= 1 && !found; i--) {
                if (nextGreaterNumbers[i][2] != -1) {
                    // found one (b < c) pair. Let's find (a<b) pair {}
                    if (nextGreaterNumbers[i][1] < i) { // position in nums is closer to 0
                        found = searchInNums(nums, nextGreaterNumbers[i][1], nextGreaterNumbers[i][0]);
                    } else {
                        found = searchInGreaterNums(nextGreaterNumbers, i);
                    }
                }
            }
            return found;
        }
    }

    private int[][] parseAndGetNextGreaterNumber(int[] nums) {
        int[][] numbers = new int[nums.length][3];
        LinkedList<Integer> greaterNumbers = new LinkedList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            numbers[i][0] = nums[i];
            numbers[i][1] = i;
            numbers[i][2] = -1;
            if (nums[i] < nums[i+1]) {
                numbers[i][2] = i + 1;
                while (!greaterNumbers.isEmpty() && nums[greaterNumbers.peekLast()] < nums[i+1]) {
                    numbers[greaterNumbers.removeLast()][2] = i + 1;
                }
            } else {
                greaterNumbers.addLast(i);
            }
        }
        numbers[numbers.length -1][0] = nums[nums.length-1];
        numbers[numbers.length -1][1] = nums.length-1;
        numbers[numbers.length -1][2] =-1;
        if (greaterNumbers.size() > nums.length - 3) {
            return null;
        }
        return numbers;
    }

    private boolean searchInNums(int[] nums, int startPos, int value) {
        for (int i = startPos -1; i >= 0; i--) {
            if (nums[i] < value) {
                return true;
            }
        }
        return false;
    }

    private boolean searchInGreaterNums(int[][] greaterNums, int index) {
        for (int i = index -1; i >= 0; i--) {
            if (greaterNums[i][0] < greaterNums[index][0] && greaterNums[i][1] < greaterNums[index][1]) {
                return true;
            }
        }
        return false;
    }
}
