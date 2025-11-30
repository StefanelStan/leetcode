package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.november.MinimumOperationsToMakeArraySumDivisibleByK;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

        start.minimumOperationsToMakeArraySumDivisibleByK();
    }

    public void minimumOperationsToMakeArraySumDivisibleByK() {
        MinimumOperationsToMakeArraySumDivisibleByK motmasdbk = new MinimumOperationsToMakeArraySumDivisibleByK();

        System.out.println("4 == " + motmasdbk.minOperations(new int[]{3,9,7}, 5));
        System.out.println("0 == " + motmasdbk.minOperations(new int[]{4,1,3}, 4));
        System.out.println("5 == " + motmasdbk.minOperations(new int[]{3,2}, 6));
    }
}
