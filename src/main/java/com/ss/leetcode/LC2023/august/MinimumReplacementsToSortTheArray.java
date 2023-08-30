package com.ss.leetcode.LC2023.august;

public class MinimumReplacementsToSortTheArray {
    // https://leetcode.com/problems/minimum-replacements-to-sort-the-array
    /** Algorithm
        1. With an index i (0,n-2) traverse the nums and check if nums[i] is sorted against the rightSide. Initially, rightSide will ne nums[n-1].
        2. If nums[i] <= rightSide, then continue
        3. If they are not sorted, then nums[i] > rightSide, so nums[i] needs to be broken into other nums, smaller or equal to rightSide
        4. EG: 12,13,6
            13 can be broken into 1,6,6 => 12,1,6,6,6
            However, this is not the best way, as 1 will cause troubles to all the other numbers to its left,
            as ALL the other numbers from LEFT will have to be lowered to match it.
        5. It is clear that 13 MUST be broken into 3 segments in two moves, however,
            the segments need to be carefully picked so that it won't lower the left side too much.
        6. Knowing that it needs to be broken into 3 segments, what is the average?
            13/3 = 4. Thus, we can break 13 into something that starts with 4. EG: 4,4,5
        7. Thus, 13 will be broken in 2 moves and the remaining part is 4.
        8. Apply the change, increase the number of steps and return the head of this segment.
            The head will become your new rightEdge and next number will be compared to this rightEdge
        9. 12,4 => their modulo is 0,  so 12 can be broken into 4 equal numbers (3 moves)
     */
    public long minimumReplacement(int[] nums) {
        long[] operations = {0};
        int rightEdge = nums[nums.length -1];
        for (int i = nums.length -2; i >=0; i--) {
            rightEdge = replaceToMinimum(nums[i], rightEdge, operations);
        }
        return operations[0];
    }

    private int replaceToMinimum(int left, int right, long[] operations) {
        if (left <= right) {
            return left;
        }
        int div = left / right;
        if (left % right == 0) {
            operations[0] += (div - 1);
            return right;
        } else {
            operations[0] += div;
            return left / (div + 1);
        }
    }
}
