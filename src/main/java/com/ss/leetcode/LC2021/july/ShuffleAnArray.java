package com.ss.leetcode.LC2021.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleAnArray {
    private final int[] nums;
    private final List<Integer> shuffled;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        List<Integer> numsList = new ArrayList<>(nums.length);
        for (int num : nums) {
            numsList.add(num);
        }
        shuffled = new ArrayList<>(numsList);
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        Collections.shuffle(shuffled);
        int[] retshuffle = new int[shuffled.size()];
        for (int i = 0; i < shuffled.size();i++) {
            retshuffle[i] = shuffled.get(i);
        }
        return retshuffle;
    }
}
