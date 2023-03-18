package com.ss.leetcode.LC2023.march;


import java.util.Arrays;

public class MaximizeGreatnessOfAnArray {
    public int maximizeGreatness(int[] nums) {
        int greatness = 0;
        Arrays.sort(nums);
        int i = 0, j = 1;
            while(j < nums.length) {
            if (nums[i] < nums[j]) {
                i++;
                j++;
                greatness++;
            } else {
                j++;
            }
        }
        return greatness;
    }






























        /**
        Arrays.sort(nums);
        int unique = countUnique(nums);
        int[] uniques = getUniques(nums, unique);
        int[] suffixSum = getSuffixSum (uniques);
        for (int i = 0; i < suffixSum.length - 1 && suffixSum[i+1] > 0; i++) {
            int min = Math.min(uniques[i], suffixSum[i+1]);
            if (min == 0 ) {
                break;
            }
            greatness += min;
            if (i )
        }
        return greatness;
    }

    private int countUnique(int[] sorted) {
        int unique = 1;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] != sorted[i-1]) {
                unique++;
            }
        }
        return unique;
    }

    private int[] getUniques(int[] nums, int count) {
        int[] uniques = new int[count];
        int index = 0;
        uniques[index]++;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                index++;
            }
            uniques[index]++;
        }
        return uniques;
    }

    private int[] getSuffixSum(int[] uniques) {
        int l = uniques.length;
        int[] suffixSum = new int[l];
        suffixSum[l-1] = uniques[l-1];
        for (int i = l-2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i+1] + uniques[i];
        }
        return suffixSum;
    } */
}
