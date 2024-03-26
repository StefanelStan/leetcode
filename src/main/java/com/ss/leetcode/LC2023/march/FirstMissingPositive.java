package com.ss.leetcode.LC2023.march;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    // https://leetcode.com/problems/first-missing-positive
    /** Algorithm
     *  1. The first missing positive is somewhere in the range of 1 .. arr.length + 1.
     *  2. Arr could be first consecutive numbers so first missing is length +1 or they can be randoms
     *  3. Flag the first present n numbers in a boolean[n+1]
     *  4. Loop with i from 1 to n and return the first !boolean[i].
     *  5. Else, return length +1 (nums are consecutive)
     *  EG: [3,1,4,5,6]
     *   boolean[] present = [false,true, false, true,true,true]
     *   first false is i = 2.
     */
    public int firstMissingPositive(int[] nums) {
        boolean[] present = new boolean[nums.length + 1];
        for (int num : nums) {
            if (num > 0 && num < present.length) {
                present[num] = true;
            }
        }
        for (int i = 1; i < present.length; i++) {
            if (!present[i]) {
                return i;
            }
        }
        return present.length;
    }

    public int firstMissingPositive2(int[] nums) {
        int firstMissingPositive = 1;
        Arrays.sort(nums);
        for (int num : nums) {
            if (num > 0) {
                if (num == firstMissingPositive) {
                    firstMissingPositive++;
                } else if (num > firstMissingPositive) {
                    break;
                }
            }
        }
        return firstMissingPositive;
    }

    public int firstMissingPositive3(int[] nums) {
        Set<Integer> positives = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > 0) {
                min = Math.min(min, num);
                positives.add(num);
            }
        }
        if (min > 1){
            return 1;
        }
        for (int i = min + 1;; i++) {
            if (!positives.contains(i)) {
                return i;
            }
        }
    }
}
