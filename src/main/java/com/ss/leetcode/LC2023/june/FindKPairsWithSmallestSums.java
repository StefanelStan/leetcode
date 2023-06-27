package com.ss.leetcode.LC2023.june;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    // https://leetcode.com/problems/find-k-pairs-with-smallest-sums
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        long product = (long)nums1.length * nums2.length;
        k = product < k ? (int)product : k;
        List<List<Integer>> smallestPairs = new ArrayList<>(k);
        PriorityQueue<int[]> lowestNums = new PriorityQueue<>(Comparator.comparingInt(i -> nums1[i[0]] + nums2[i[1]]));
        for(int i = 0; i < nums1.length; i++) {
            lowestNums.add(new int[]{i, 0});
        }
        int[] head;
        while(k > 0) {
            head = lowestNums.poll();
            smallestPairs.add(List.of(nums1[head[0]], nums2[head[1]]));
            head[1]++;
            if(head[1] < nums2.length) {
                lowestNums.add(head);
            }
            k--;
        }
        return smallestPairs;
    }
}
