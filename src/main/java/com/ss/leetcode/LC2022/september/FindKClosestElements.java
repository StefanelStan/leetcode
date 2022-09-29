package com.ss.leetcode.LC2022.september;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
    // https://leetcode.com/problems/find-k-closest-elements/
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> closest = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int num : arr) {
            closest.add(new int[]{Math.abs(num - x), num});
        }
        List<Integer> vals = new ArrayList<>(k);
        int size = 0;
        while(size++ < k) {
            vals.add(closest.poll()[1]);
        }
        vals.sort(Comparator.naturalOrder());
        return vals;
    }
}
