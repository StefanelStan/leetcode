package com.ss.leetcode.LC2023.august;

public class CheckIfThereIsAValidPartitionForTheArray {
    // https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array
    /** Algorithm
        1. Use an int[nums.length] OR Boolean[nums.length] to mark if array has a partition at the given indices (0,1,2 etc)
        2. In a recursive function that takes an index, check if a partition can be made from that index
        3. If index >= nums.length, then your method was called from a successful call, so you have built a partition that ends
            the nums
        4. For each index, if the int[] or Boolean[] is not set, check the 3 conditions: index == index +1,
            or index+1==index+2==indeX+3 or consecutive numbers.
            - For each successfull condition, call the function to determine if partition can be made from index +2/+3.
             - Cache the results and return the final
     */
    public boolean validPartition(int[] nums) {
        Boolean[] hasPartition = new Boolean[nums.length];
        return checkForPartition(nums, 0, hasPartition);
    }

    private boolean checkForPartition(int[] nums, int index, Boolean[] hasPartition) {
        if (index >= nums.length) {
            return true;
        }
        if (hasPartition[index] == null) {
            hasPartition[index] = false;
            if (index < nums.length -1 && nums[index] == nums[index + 1]) {
                hasPartition[index] = hasPartition[index] || checkForPartition(nums, index + 2, hasPartition);
            }
            if (index < nums.length - 2) {
                if (!hasPartition[index] && nums[index] == nums[index+1] && nums[index] == nums[index+2]) {
                    hasPartition[index] = hasPartition[index] || checkForPartition(nums, index + 3, hasPartition);
                }
                if (!hasPartition[index] && nums[index] +1 == nums[index+1] && nums[index] +2 == nums[index+2]) {
                    hasPartition[index] = hasPartition[index] || checkForPartition(nums, index + 3, hasPartition);
                }
            }
        }
        return hasPartition[index];
    }
}
