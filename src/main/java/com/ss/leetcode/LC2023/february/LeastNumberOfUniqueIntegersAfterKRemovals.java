package com.ss.leetcode.LC2023.february;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    // https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals
    /** Algorithm
        1. Count the nums using a hashmap
        2. Get the values(), put them in a list and sort the list
        3. Iterate over the list, reducing k with the given index elements
        4. Break when k reaches <= 0 and return the list size() - stopped index
     */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (k >= arr.length) {
            return 0;
        }
        int removed = 0;
        List<Integer> ints = getUniqueCount(arr);
        while(k > 0) {
            k -= ints.get(removed);
            removed++;
        }
        return k < 0 ? (ints.size() - removed) + 1 : ints.size() - removed;
    }

    private List<Integer> getUniqueCount(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            count.merge(num, 1, Integer::sum);
        }
        List<Integer> ints =  new ArrayList<>(count.values());
        Collections.sort(ints);
        return ints;
    }

    public int findLeastNumOfUniqueInts2(int[] arr, int k) {
        if (k >= arr.length) {
            return 0;
        }
        PriorityQueue<Integer> uniques = getUniqueCountAsPQ(arr);
        while(!uniques.isEmpty() && k > 0) {
            if (uniques.peek() <= k) {
                k -= uniques.poll();
            } else {
                break;
            }
        }
        return uniques.size();
    }

    private PriorityQueue<Integer> getUniqueCountAsPQ(int[] arr) {
        PriorityQueue<Integer> uniques = new PriorityQueue<>();
        Arrays.sort(arr);
        int unqCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                uniques.add(unqCount);
                unqCount = 1;
            } else {
                unqCount++;
            }
        }
        uniques.add(unqCount);
        return uniques;
    }
}
