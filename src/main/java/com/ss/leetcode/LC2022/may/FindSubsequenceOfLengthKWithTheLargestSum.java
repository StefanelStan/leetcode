package com.ss.leetcode.LC2022.may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindSubsequenceOfLengthKWithTheLargestSum {
    /** Algorithm
         1. Use 2 priority queues:
             - maxValues  will keep only the highest k values
             - minIndices will sort the k elements of maxValue based on their index,position
         2. Each priority queue will accept elements of type int[]; [value, index].
            first Queue will compare based on a[0](value) and second one based on [1] (index-position in array)
         3. Traverse nums and add a new int[value, index] in the maxValues. If its size > k, remove one element.
             This will remove the head, which is the minumum by value
         4. When done, poll all the elements from maxValues queue to minIndices queue. This second queue will
            sort them, with the minimum index first [1].
         5. Traverse the minIndices and pull each result into an answer int[k] array.
     */
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> maxValues = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> minIndices = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(int i = 0; i < nums.length; i++) {
            maxValues.add(new int[]{nums[i], i});
            if(maxValues.size() > k) {
                maxValues.poll();
            }
        }
        while(!maxValues.isEmpty()) {
            minIndices.add(maxValues.poll());
        }
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = minIndices.poll()[0];
        }
        return answer;
    }

    public int[] maxSubsequence2(int[] nums, int k) {
        int[][] numbers = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            numbers[i][0] = nums[i];
            numbers[i][1] = i;
        }
        Arrays.sort(numbers, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(numbers, nums.length - k, nums.length, Comparator.comparingInt(a -> a[1]));
        int[] answer = new int[k];
        for (int i = 0,  j = nums.length - k; i < k; i++, j++) {
            answer[i] = numbers[j][0];
        }
        return answer;
    }

    public int[] maxSubsequence3(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(a -> nums[a]));
        Arrays.sort(indices, nums.length - k, nums.length);
        int[] maxSubseq = new int[k];
        for (int i = nums.length - k, j = 0; j < k; i++, j++) {
            maxSubseq[j] = nums[indices[i]];
        }
        return maxSubseq;
    }
}
