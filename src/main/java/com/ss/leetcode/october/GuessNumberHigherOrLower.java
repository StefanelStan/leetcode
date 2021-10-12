package com.ss.leetcode.october;

public class GuessNumberHigherOrLower {
    // https://leetcode.com/problems/guess-number-higher-or-lower/
    public int guessNumber(int n) {
        int low = 1, high = n;
        int pivot = 1, status = -1;
        while (low <= high) {
            if (low == high) {
                return low;
            }
            pivot = low + (high - low) / 2;
            status = guess(pivot);
            if (status == 0) {
                break;
            } else if (status == -1) {
                high = pivot - 1;
            } else {

                low = pivot + 1;
            }
        }
        return pivot;
    }

    private int guess(int pivot) {
        return 0;
    }
}
