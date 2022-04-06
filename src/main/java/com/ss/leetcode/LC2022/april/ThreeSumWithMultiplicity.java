package com.ss.leetcode.LC2022.april;

public class ThreeSumWithMultiplicity {
    // https://leetcode.com/problems/3sum-with-multiplicity/
    public int threeSumMulti(int[] arr, int target) {
        int[] count = count(arr);
        long[] treeSum ={0};
        for(int i = count.length -1; i >= 0; i--) {
            if (count[i] > 0) {
                treeSum[0] += calculateTreeSum(count, i, target, 3);
            }
        }
        return (int)(treeSum[0] % 1_000_000_007);
    }

    private int[] count(int[] nums) {
        int[] count = new int[101];
        for(int num : nums) {
            count[num]++;
        }
        return count;
    }

    private long calculateTreeSum(int[] count, int pos, int target, int remaining) {
        if (remaining == 0 || pos < 0 || target < 0) {
            return 0;
        }
        if (remaining == 1) {
            return target > pos ? 0 : count[target];
        }
        long combinations = 0;
        if(remaining == 2) { // if current pos has double the amount of them.
            if (count[pos] > 1 && 2 * pos == target) {
                combinations += getCombinations(count[pos], 2);
            }
            // keep 1 and see what the rest are
            if (count[pos] > 0) {
                combinations += count[pos] * calculateTreeSum(count, pos-1, target - pos, 1);
            }
            return combinations;
        }
        if (remaining == 3) {
            if (count[pos] > 2 && 3 * pos == target) {
                combinations += getCombinations(count[pos], 3);
            }
            // try to get with two
            if (count[pos] > 1) {
                if (2 * pos <= target) {
                    combinations += (getCombinations(count[pos], 2) * calculateTreeSum(count, pos - 1, target - (2 * pos), 1));
                }
            }
            //now keep 1 and move along;
            for (int i = pos -1; i >= 0; i--) {
                if (count[i] > 0) {
                    combinations += (count[pos] * calculateTreeSum(count, i, target - pos, 2));
                }
            }
            return combinations;
        }
        return 0;
    }

    private long getCombinations(long n, int k) {
        return k == 2 ? ((n-1) * n) /2 : ((n-2) * (n-1) * n) / 6;
    }
}
