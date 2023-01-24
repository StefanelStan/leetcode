package com.ss.leetcode.LC2023.january;

import java.util.LinkedList;

public class StepsToMakeArrayNonDecreasing {
    // https://leetcode.com/problems/steps-to-make-array-non-decreasing
    // NOT WORKING YET
    public int totalSteps(int[] nums) {
        int lastGreatElementIndex = -1;
        LinkedList<Integer> currentStack = new LinkedList<>();
        int currentStepsStack = 0;
        int currentSteps = 0, maxSteps = 0;
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] > nums[i+1]) {
                if (lastGreatElementIndex == -1) {
                    currentSteps++;
                    lastGreatElementIndex = i;
                } else if (lastGreatElementIndex == i) {
                    currentSteps++;
                }
                maxSteps = Math.max(currentSteps, maxSteps);
            } else {
                if (lastGreatElementIndex == -1) {
                    lastGreatElementIndex = i + 1;
                } else if (nums[i + 1] < nums[lastGreatElementIndex]) {
                   if (currentStack.isEmpty()) {
                       currentStepsStack += currentSteps;
                       currentStack.addLast(i + 1);
                       maxSteps = Math.max(maxSteps, currentStepsStack);
                       currentSteps = 1;
                   } else { // do some logic in stack here.
//                       if (nums[i+1])
                   }

                } else {
                    lastGreatElementIndex = i + 1;
                    maxSteps = Math.max(maxSteps, currentStepsStack + currentSteps);
                    currentSteps = 0;
                    currentStepsStack = 0;
                    currentStack.clear();
                }
            }
        }
        return maxSteps;
    }
}
