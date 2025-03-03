package com.ss.leetcode.LC2022.february;

import java.util.ArrayList;
import java.util.List;

public class PartitionArrayAccordingToGivenPivot {
    // https://leetcode.com/contest/biweekly-contest-71/problems/partition-array-according-to-given-pivot/
    /** Algorithm
        1. Use an int[] sorted to store the correct ordered numbers
        2. Traverse nums and count how many lessThan, equalToPivot and greaterThanPivot there are.
        3. This count will give you the insertion indices for each category.
        4. Traverse nums and insert into sorted[] at the right indices, based on the relation between num and pivot.
     */
    public int[] pivotArray(int[] nums, int pivot) {
        int[] sorted = new int[nums.length];
        int lessThanPivot = 0, equalToPivot = 0, greaterThanPivot = 0;
        for (int num : nums) {
            if (num < pivot) {
                lessThanPivot++;
            } else if (num > pivot) {
                greaterThanPivot++;
            }
        }
        equalToPivot = nums.length - (lessThanPivot + greaterThanPivot);
        int lessIndex = 0, equalIndex = lessThanPivot, greaterIndex = lessThanPivot + equalToPivot;
        for (int num : nums) {
            if (num < pivot) {
                sorted[lessIndex++] = num;
            } else if (num > pivot) {
                sorted[greaterIndex++] = num;
            } else {
                sorted[equalIndex++] = num;
            }
        }
        return sorted;
    }


    public int[] pivotArray2(int[] nums, int pivot) {
        int[] answer = new int[nums.length];
        int low = 0, high = nums.length -1;
        int leftIndex = 0, rightIndex = nums.length -1;
        int equals = 0;
        while (low <= nums.length && high >= 0) {
            if (nums[low] < pivot) {
                answer[leftIndex++] = nums[low];
            } else if (nums[low] == pivot) {
                equals++;
            }
            if(nums[high] > pivot) {
                answer[rightIndex--] = nums[high];
            }
            low++;
            high--;
        }
        while(equals > 0) {
            answer[leftIndex++] = pivot;
            equals--;
        }
        return answer;
    }
}
