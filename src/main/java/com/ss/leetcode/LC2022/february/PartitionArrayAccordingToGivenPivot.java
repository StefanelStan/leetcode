package com.ss.leetcode.LC2022.february;

import java.util.ArrayList;
import java.util.List;

public class PartitionArrayAccordingToGivenPivot {
    // https://leetcode.com/contest/biweekly-contest-71/problems/partition-array-according-to-given-pivot/
    public int[] pivotArray(int[] nums, int pivot) {
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
