package com.ss.leetcode.LC2023.february;

import java.util.TreeSet;

public class MinimizeDeviationInArray {
    // https://leetcode.com/problems/minimize-deviation-in-array
    /** Algorithm
        1. Add the numbers into a tree set: if number is odd, multiply it by 2 before adding it
        2. while set.size > 1 and last element is even
            - pull last element, divide it by 2 and add it back in the set
             - set min to be Math.min(min, lastElement - firstElement)
        3. Return min when while has finished.
     */
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> nrs = new TreeSet<>();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 1) {
                num = num * 2;
            }
            nrs.add(num);
        }
        while(nrs.size() > 1 && nrs.last() % 2 == 0) {
            nrs.add(nrs.pollLast()  / 2);
            min = Math.min(min, nrs.last() - nrs.first());
        }
        return Math.min(min, nrs.last() - nrs.first());
    }
}
