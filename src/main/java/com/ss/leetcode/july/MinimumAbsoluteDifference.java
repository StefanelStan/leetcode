package com.ss.leetcode.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumAbsoluteDifference {
    // https://leetcode.com/problems/minimum-absolute-difference/
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> absDiff = new ArrayList<>();
        Arrays.sort(arr);
        int absMin = Integer.MAX_VALUE;
        int currentDifference;
        for (int i = 0; i < arr.length - 1; i++) {
            currentDifference = Math.abs(arr[i] - arr[i + 1]);
            if (currentDifference < absMin) {
                absDiff.clear();
                absDiff.add(Arrays.asList(arr[i], arr[i + 1]));
                absMin = currentDifference;
            } else if (currentDifference == absMin) {
                absDiff.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return absDiff;
    }
}
