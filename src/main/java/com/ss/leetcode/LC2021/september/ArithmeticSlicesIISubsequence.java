package com.ss.leetcode.LC2021.september;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArithmeticSlicesIISubsequence {
    // https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        long[] longNums = new long[nums.length];
        for(int i = 0; i < nums.length; i++) {
            longNums[i] = nums[i];
        }
        Set<Integer> threeSets = new HashSet<>();
        Map<Integer, BigInteger> factorials =  new HashMap<>();
        Set<CombSet> combinations = new HashSet<>();
        for (int i = 0; i < nums.length -2; i++) {
            for (int j = i + 1; j < nums.length -1; j++) {
                if (!combinationExists(i, j, longNums, combinations)) {
                    searchCompatibility(i, j, longNums, new boolean[nums.length], combinations);
                }
            }
        }
        int slices = 0;
        for(CombSet comb : combinations) {
            slices += calculateCombinationSize(comb, factorials, threeSets);
        }
        return slices;
    }

    private long calculateCombinationSize(CombSet combSet, Map<Integer, BigInteger> factorials, Set<Integer> threeSets) {
        if (combSet.difference == 0) {
            long sum = 0;
            for (int i = 3; i <= combSet.size; i++ ) {
                sum += combOfNByK(combSet.size, i, factorials);
            }
            return sum;
        } else {
            if (combSet.size == 3) {
                return 1;
            }
            // calculate 3 sets
            long sum = 0;
            for (int i = 0; i < combSet.indices.length -2; i++) {
                if (threeSets.add(Arrays.hashCode(new int[]{combSet.indices[i], combSet.indices[i+1],combSet.indices[i+2]}))) {
                    sum++;
                }
            }
            // calculate 4+ windows
            long end = combSet.size - 3;
            long ret = end % 2 == 0 ? (end + 1) * (end / 2) : (end +1) * (end /2) + (end + 1) / 2;
            return ret + sum;
        }
    }

    private long combOfNByK(int n, int k, Map<Integer, BigInteger> factorials) {
        BigInteger first = fact(n, factorials);
        BigInteger second = fact(k, factorials).multiply(fact(n-k, factorials));
        BigInteger result = first.divide(second);
        return result.longValue();
    }

    private BigInteger fact(int n, Map<Integer, BigInteger> factorials) {
        if (!factorials.containsKey(n)) {
            BigInteger start = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                start = start.multiply(BigInteger.valueOf(i));
            }
            factorials.put(n, start);
        }
        return factorials.get(n);
    }

    private void searchCompatibility(int firstPos, int secondPos, long[] nums, boolean[] positions, Set<CombSet> combs) {
        int prevIndex = firstPos;
        int currentIndex = secondPos;
        positions[firstPos] = true;
        positions[secondPos] = true;

        long difference = nums[firstPos] - nums[secondPos];
        for (int i = secondPos +1; i < nums.length; i++) {
            if (difference == nums[currentIndex] - nums[i]) {
                positions[i] = true;
                prevIndex = currentIndex;
                currentIndex = i;
            } else if (difference == nums[prevIndex] - nums[i]) {
                boolean[] different = new boolean[positions.length];
                System.arraycopy(positions, 0, different, 0, different.length);
                different[currentIndex] = false;
                different[i] = true;

                searchCompatibility(prevIndex, i, nums, different, combs);
            }
        }
        int size = 0;
        for(boolean pos : positions) {
            if(pos) size++;
        }
        if (size > 2) {
            combs.add(new CombSet(difference, positions));
        }
    }

    private boolean combinationExists(int pos1, int pos2, long[] nums, Set<CombSet> combinations) {
        for (CombSet comb : combinations) {
            if (comb.positions[pos1] && comb.positions[pos2] && comb.difference == nums[pos1] - nums[pos2]) {
                return true;
            }
        }
        return false;
    }

    private static class CombSet {
        int size;
        boolean[] positions;
        int[] indices;
        long difference;
        public CombSet (long difference, boolean[] positions) {
            this.difference = difference;
            this.positions = positions;
            this.indices = new int[positions.length];
            int index = 0;
            for (int i = 0; i < positions.length; i++) {
                if (positions[i]) {
                    indices[index] = i;
                    index++;
                }
            }
            this.size = index;
            this.indices = Arrays.copyOf(indices, size);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CombSet combSet = (CombSet) o;
            return Arrays.equals(positions, combSet.positions);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(positions);
        }
    }
}
