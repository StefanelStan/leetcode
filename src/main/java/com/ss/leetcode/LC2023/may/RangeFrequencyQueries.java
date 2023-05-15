package com.ss.leetcode.LC2023.may;

import java.util.ArrayList;
import java.util.List;

public class RangeFrequencyQueries {
    // https://leetcode.com/problems/range-frequency-queries
    /** Algorithm
        1. Use a List[10_001] to add each number's positions. List[5] will contain an ArrayList<> with all positions of number 5
        2. For each query, get the list positions of value/target.
            If it's null, return 0.
            Else perform binary search on left, right and return their difference.
     */
    List[] positions;
    public RangeFrequencyQueries(int[] arr) {
        positions = new List[10_001];
        for (int i = 0; i < arr.length; i++) {
            if(positions[arr[i]] == null) {
                positions[arr[i]] = new ArrayList<Integer>();
            }
            positions[arr[i]].add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> pos = positions[value];
        if (pos == null || pos.get(0) > right || pos.get(pos.size() -1) < left) {
            return 0;
        }
        int leftIndex = binarySearch(pos, left);
        int rightIndex = binarySearch(pos, right);
        if (rightIndex < pos.size() && pos.get(rightIndex) == right) {
            rightIndex++;
        }
        return Math.max(0, (rightIndex - leftIndex));
    }

    private int binarySearch(List<Integer> arr, int target) {
        int low = 0, high = arr.size() - 1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (arr.get(pivot) == target) {
                return pivot;
            } else if (arr.get(pivot) < target) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low;
    }
}
