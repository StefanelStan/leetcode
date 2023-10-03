package com.ss.leetcode.LC2021.april;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    // https://leetcode.com/problems/number-of-good-pairs/
    // PERFORMANT SOLUTION
    public int numIdenticalPairs(int[] nums) {
        int sum = 0;
        int[] count = getCount(nums);
        for (int c : count) {
            if (c > 1) {
                sum += (c * (c-1) / 2);
            }
        }
        return sum;
    }

    private int[] getCount(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        return count;
    }


    public int numIdenticalPairs2(int[] nums) {
        Map<Integer, Integer> incidences = new HashMap<>();
        Map<Integer, BigInteger> factorials = new HashMap<>();
        for(int num : nums) {
            incidences.merge(num, 1, Integer::sum);
        }
        BigInteger[] totalPairs = {BigInteger.ZERO};
        incidences.values().forEach(value-> { if (value > 1) {
            totalPairs[0] = totalPairs[0].add(getFactorial(value, factorials).divide(getFactorial (value -2, factorials).multiply(BigInteger.valueOf(2))));
        }});
        return totalPairs[0].intValue();
    }

    private BigInteger getFactorial(int value, Map<Integer, BigInteger> factorials) {
        return factorials.computeIfAbsent(value, this::calculateFactorial);
    }

    private BigInteger calculateFactorial(int value) {
        BigInteger fact = BigInteger.ONE;
        if (value == 0) {
            return fact;
        } else {
            while(value > 0) {
                fact = fact.multiply(BigInteger.valueOf(value));
                value--;
            }
        }
        return fact;
    }
}
