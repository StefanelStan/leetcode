package com.ss.leetcode.LC2024.march;

public class SemiOrderedPermutation {
    // https://leetcode.com/problems/semi-ordered-permutation
    /** Algorithm
        1. We know ALL number are unique so we need to know the position of 1 and n (nums.length)
        2. We have two outcomes: posOfOne < posOfMax OR posOfMax < posOfOne (max is somewhere to the left of 1)
        3. In both cases, we need to ADD the distance from 0 to the leftMost position and from
            index n-1 to rightMost position.
        4. If the case of posOfMax < posOfOne, we also need to add the double of their distance -1(posOfOne  - posOfMax), as both will be shifted towards eachother.
            - when they are next to eachother, in 1 move they will be swapped, so we deduct 1 from the distnce double.
     */
    public int semiOrderedPermutation(int[] nums) {
        int posOfOne = -1, posOfMax = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                posOfOne = i;
            }
            if (nums[i] == nums.length) {
                posOfMax = i;
            }
        }
        int distance = Math.min(posOfOne, posOfMax) + nums.length - 1 - Math.max(posOfOne, posOfMax);
        if (posOfMax < posOfOne) {
            distance += 2 * (posOfOne - posOfMax) - 1;
        }
        return distance;
    }
}
