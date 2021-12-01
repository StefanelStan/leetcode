package com.ss.leetcode.LC2021.february;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> subArrays = new LinkedList<>();
        for (int i = 0; i < l.length; i++) {
            subArrays.add(checkArithmeticSubarray(nums, l[i], r[i]));
        }
        return subArrays;
    }

    private Boolean checkArithmeticSubarray(int[] nums, int start, int end) {
        int[] subarray = Arrays.copyOfRange(nums, start, end + 1);
        Arrays.sort(subarray);
        int diff = subarray[1] - subarray[0];
        for (int i = 2; i < subarray.length; i++) {
            if (subarray[i] - subarray[i-1] != diff) {
                return false;
            }
        }
        return true;
    }
}
