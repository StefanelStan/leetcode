package com.ss.leetcode.september;

import java.util.Arrays;

public class MeanOfArrayRemoveElem {
    // https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = arr.length/20; i < (arr.length - arr.length/20); i++) {
            sum += arr[i];
        }
        return (double)sum / (arr.length - arr.length/10);
    }
}
