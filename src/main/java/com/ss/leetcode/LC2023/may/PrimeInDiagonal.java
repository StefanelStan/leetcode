package com.ss.leetcode.LC2023.may;

public class PrimeInDiagonal {
    // https://leetcode.com/problems/prime-in-diagonal
    /** Algorithm
        1. Create a helperMethod that determines if a number if prime or not.
            This will be called for each element from diagonal I and II
        2. Traverse matrix and if current element from diagonal I or II is prime, compare and save
            it against your largest known/encountered prime.
        3. Return largest known prime.
     */
    public int diagonalPrime(int[][] nums) {
        int maxPrime = 0;
        for (int i = 0, j = nums.length -1; i < nums.length; i++, j--) {
            if (isPrime(nums[i][i])) {
                maxPrime = Math.max(maxPrime, nums[i][i]);
            }
            if (isPrime(nums[j][i])) {
                maxPrime = Math.max(maxPrime, nums[j][i]);
            }
        }
        return maxPrime;
    }

    private boolean isPrime(int i) {
        if (i < 2) {
            return false;
        } else if (i < 4) {
            return true;
        }
        int sqrt = (int)Math.sqrt(i);
        if (i % 2 == 0 || sqrt * sqrt == i) {
            return false;
        }
        for (int k = 3; k <= sqrt; k += 2) {
            if (i % k == 0) {
                return false;
            }
        }
        return true;
    }
}
