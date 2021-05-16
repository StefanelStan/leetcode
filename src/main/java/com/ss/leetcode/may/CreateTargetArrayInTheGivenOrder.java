package com.ss.leetcode.may;

import java.util.LinkedList;
import java.util.List;

public class CreateTargetArrayInTheGivenOrder {
    // https://leetcode.com/problems/create-target-array-in-the-given-order/
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> numbers = new LinkedList<>();
        for(int i= 0; i < nums.length; i++) {
            numbers.add(index[i], nums[i]);
        }

        int i = 0;
        for(Integer nr : numbers) {
            nums[i] = nr;
            i++;
        }
        return nums;
    }
}
