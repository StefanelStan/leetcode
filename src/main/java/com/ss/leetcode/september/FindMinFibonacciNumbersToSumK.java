package com.ss.leetcode.september;

public class FindMinFibonacciNumbersToSumK {
    /**
     * Algorithm:
     * 0. Find the next fib smaller than k. Deduct it from k (diff); repeat the process for diff until diff is 0
     * 1. Cache the first 45 fibonacci numbers (46th is over 10^9)
     * 2. Starting from k and 45th fib number, deduct the first fib number that is smaller or equal to k
     * 3. If one exists, deduct it from k and call the same method again, this time passing the difference instead
     * 4. As optimization, keep an index of the last fibonacci position, so you will search from that position backwards.
     */
    private static int[] fibs;
    public int findMinFibonacciNumbers(int k) {
        initFibs();
        int minNumbers = 0, indexPoint = fibs.length -1;
        while(k > 0) {
            // get the index of the first fib smaller than k
            indexPoint = findNextFib(k, indexPoint);
            minNumbers++;
            k = k - fibs[indexPoint];
        }
        return minNumbers;
    }

    private int findNextFib(int k, int indexPoint) {
        for (int i = indexPoint; i >= 1; i--) {
            if (fibs[i] <= k) {
                return i;
            }
        }
        return -1;
    }

    // given number is max 10^9; there are 45 fibonacci numbers smaller than 10^9.
    private void initFibs() {
        if (fibs == null) {
            fibs = new int[45];
            fibs[0] = 0;
            fibs[1] = 1;
            for (int i = 2; i < fibs.length; i++) {
                fibs[i] = fibs[i-1] + fibs[i-2];
            }
        }
    }
}
