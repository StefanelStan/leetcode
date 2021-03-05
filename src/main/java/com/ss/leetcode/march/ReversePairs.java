package com.ss.leetcode.march;

import java.util.Arrays;
import java.util.Objects;

public class ReversePairs {
    // https://leetcode.com/problems/reverse-pairs/
    public int reversePairs(int[] nums) {
        DoubleValue[] doubles = new DoubleValue[nums.length];
        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            doubles[i] = new DoubleValue(2L * nums[i], i);
        }
        Arrays.sort(doubles);
        for (int i = 0; i <= nums.length - 2; i++) {
            pairs += getNumberOfDoublesSmallerThan(nums[i], doubles, i);
        }
        return pairs;
    }

    private int getNumberOfDoublesSmallerThan(int num, DoubleValue[] doubles, int position) {
        int occurrences = 0;
        for (int i= 0; i < doubles.length && doubles[i].value < num; i++) {
            if (doubles[i].originalPosition > position) {
                occurrences++;
            }
        }
        return occurrences;
    }

    private static class DoubleValue implements Comparable<DoubleValue>{
        private final long value;
        private final int originalPosition;

        public DoubleValue(long value, int originalPosition) {
            this.value = value;
            this.originalPosition = originalPosition;
        }

        @Override
        public int compareTo(DoubleValue o) {
            return Long.compare(value, o.value);
        }

        @Override
        public boolean equals(Object obj) {
            return Objects.equals(value, ((DoubleValue)obj).value);
        }
    }
}
