package com.ss.leetcode.LC2022.april;

import java.util.ArrayList;
import java.util.List;

public class FindTheDifferenceOfTwoArrays {
    // https://leetcode.com/problems/find-the-difference-of-two-arrays/
    /** Algorithm
         1. Map the nums from nums1 and nums2 into 2 boolean[] arrays of size [2001].
            Why 2001? Because nums1 is between -1000 and 1000.
            Deducting 1000 from any index between 0 and 2001 will result in a number between -1000 and 1000
            eg: num =  -679; this would be mapped to [-679 + 1000] = 321. Deducting 1000 from 321 = -679.
         2. Create a method that will traverse with i from 0 to 2000 and j from 2000 to 0 over the two booleans[]
            - if i present in first and not in second, add the index - 1000 to firstList
            - if j present in second and not in first, add j - 1000 to secondList.
         3. Return a list containing both lists.
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] present1 = markPresentNumbers(nums1);
        boolean[] present2 = markPresentNumbers(nums2);
        List<Integer> unique1 = new ArrayList<>();
        List<Integer> unique2 = new ArrayList<>();
        for (int i = 0; i < present1.length; i++) {
            if (present1[i] ^ present2[i]) {
                if (present1[i]) {
                    unique1.add(i - 1000);
                } else {
                    unique2.add(i - 1000);
                }
            }
        }
        return List.of(unique1, unique2);
    }

    private boolean[] markPresentNumbers(int[] nums) {
        boolean[] present = new boolean[2001];
        for (int num : nums) {
            present[num + 1000] = true;
        }
        return present;
    }
}
