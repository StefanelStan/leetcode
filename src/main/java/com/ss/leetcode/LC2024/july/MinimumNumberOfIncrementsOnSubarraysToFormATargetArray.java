package com.ss.leetcode.LC2024.july;

public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {
    // https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array
    /** Algorithm
        1. If your current number is higher than prev number (prev starts at 0), then you need curr - prev increments
        2. If your curr number is lesser or equal to prev, then you don't need to increment because you have already incremented a segment when
            necessarily for prev number.
            - EG: [3,6,4, 9]
            - i =0 (3). prev = 0, curr =3. You need to raise your array to 3 => 3 steps
            - i =1 (6). prev = 3, curr = 6. At this stage, you need to raise your array/segment 3 more times (6-3)
            - i =2 (4). At this stage, you realize that you already raised the array to 4 when you raised it to 6 on prev step
                (on prev step you raise from 3 to 4 the segments [1,2] and from 4 to 6 the segment[1]). So you need 0 steps
            - i=3 (9). At this stage, your array is at stage 4, and it needd to be raised to 9 (5 steps)
     */
    public int minNumberOperations(int[] target) {
        int operations = 0, prev = 0;
        for (int num : target) {
            operations += Math.max(num - prev, 0);
            prev = num;
        }
        return operations;
    }
}
