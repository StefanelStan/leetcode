package com.ss.leetcode.LC2021.august;

import java.util.Arrays;

public class MakeTwoArraysEqual {
    // https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
    /** Algorithm
        1. You can move any num from arr to any index by doing the reverse substring.
        2. By this reverse, starting from index 0 of target, you can find the num in arr and reverse it to 0 position.
        3. In order for this to work, you need to have the same number and count in target and array.
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];
        for (int num : target) {
            count[num]++;
        }
        for (int num : arr) {
            if (--count[num] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canBeEqual2(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for(int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
