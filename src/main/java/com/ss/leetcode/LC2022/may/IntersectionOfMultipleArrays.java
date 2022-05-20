package com.ss.leetcode.LC2022.may;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfMultipleArrays {
    // https://leetcode.com/problems/intersection-of-multiple-arrays/
    /** Algorithm:
         1. Declare a count[1001] array that will hold the count of each number across all nums
         2. Loop over each array of nums and increment the count of each number present in array
         3. At the end, loop over the count and only select those numbers/indices which have a
             count == length of nums.
             Eg: if [[1,2,3],[2,3,4],[2,5,6]]
             At the end, the count will look like
             [0,1,3,2,1,1,1] : 0 0s, 1 1s, 3 2s, 2 3s, 1 4s, 1 5s etc.
         As we have 3 arrays, each with unique numbers, only number 2 is to be selected as it appears 3 times.
     */
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        List<Integer> intersection = new ArrayList<>();
        for(int[] array : nums) {
            for(int number : array) {
                count[number]++;
            }
        }
        for(int i = 1; i < count.length; i++) {
            if(count[i] == nums.length) {
                intersection.add(i);
            }
        }
        return intersection;
    }
}
