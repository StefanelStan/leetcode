package com.ss.leetcode.LC2022.april;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    // https://leetcode.com/problems/top-k-frequent-elements/
    public int[] topKFrequent(int[] nums, int k) {
        int[] unique = {0};
        int[] count = countNums(nums, unique);
        return getMostFrequent(count, unique[0], k);
    }

    private int[] countNums(int[] nums, int[] unique) {
        int[] count = new int[20_001];
        for (int num : nums) {
            if (count[num+10000]++ == 0) {
                unique[0]++;
            }
        }
        return count;
    }

    private int[] getMostFrequent(int[] count, int unique, int k) {
        int[][] mostFrequent = new int[unique][2];
        int insert = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                mostFrequent[insert][0] = i - 10000;
                mostFrequent[insert++][1] = count[i];
            }
        }
        Arrays.sort(mostFrequent, Comparator.comparingInt(a -> a[1]));
        int[] freq = new int[k];
        insert = 0;
        for (int i = unique - k; i < unique; i++) {
            freq[insert++] = mostFrequent[i][0];
        }
        return freq;
    }

    /** Algorithm
         1. Traverse nums and store their frequency in a hash map (freqMap). Use merge function
             to merge number with the new frequency
         2. Use a priority queue that will store the numbers based on their frequency
            eg: [1,1,1,2,2,3] -> 3,2,1
         3. OPTIMIZATION:
             a) Declare the queue of type int[] ([value][frequency]). This caching will reduce
             the need for an extra call to freqMap to get the frequncy of a number each time a
             new entry will be made into the queue
             b) As comparator, pass Comparator.comparingInt(a -> a[1]) ([0] - number, [1] -frequency)
         4. Traverse the map and add elements into the pQueue. [1,3], [2,2], [3,1]
             If the queue is bigger than k, remove the head. This way, the remaining back segment will
            be of size k, containing most frequent k elements
         5. Traverse the queue and add each element into a returning array[] as answer. Return it.
     */
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }
        Queue<int[]> pQueue = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[1]));
        freqMap.forEach((key, value) -> {
            pQueue.add(new int[]{key, value});
            if(pQueue.size() > k) {
                pQueue.poll();
            }
        });
        int[] topFrequent = new int[k];
        for(int i = 0; i < k; i++) {
            topFrequent[i] = pQueue.poll()[0];
        }
        return topFrequent;
    }
}
