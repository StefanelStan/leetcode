package com.ss.leetcode.LC2023.march;

public class FormArrayByConcatenatingSubarraysOfAnotherArray {
    // https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array
    /** Algorithm
        1. Starting from the last group and from the last index of nums, try to find each group 1 by 1
        2. Traverse nums from n to 0 and try to find last group by traversing the group backwards.
        3. It is good to add fail-fast conditions!
        4. Compute the prefixSum of lengths of each group. In your index m is 7 and you have to find 2 groups whose sum
            of lengths is 8, you should break as you can't find 8 elements inside a segment of 7 elements.
        5. If a group is found, decrement the group index to search (7,6,5..0) and also deduct group's length from the
            index that is used to traverse nums.
            eg: j = 8, group is found and its length is 5. Then j will jump to 8-5 and llok for next group.
        6. Return true is all groups have been found.
     */
    public boolean canChoose(int[][] groups, int[] nums) {
        int[] groupLength = getGroupLength(groups);
        int groupIndex = groups.length -1;
        // search group n, n-1, n-2 .. 0. Break if index j is lesser than the prefix sum of remaining groups lengths.
        for (int j = nums.length -1; groupIndex >= 0 && j >= groupLength[groupIndex] -1;) {
            if(canBeConcatenated(nums, j, groups[groupIndex])) {
                // reduce j by the group's length
                j -= groups[groupIndex].length;
                groupIndex--;
            } else {
                j--;
            }
        }
        return groupIndex == -1;
    }

    private boolean canBeConcatenated(int[] nums, int j, int[] group) {
        for (int i = group.length -1; i>= 0; i--, j--) {
            if (nums[j] != group[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getGroupLength(int[][] groups) {
        int[] groupLength = new int[groups.length];
        groupLength[0] = groups[0].length;
        for (int i = 1; i < groupLength.length; i++) {
            groupLength[i] = groupLength[i-1] + groups[i].length;
        }
        return groupLength;
    }
}
