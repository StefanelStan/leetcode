package com.ss.leetcode.LC2023.april;

public class RLEIterator {
    /** Algorithm
        1. Use an int index to keep track of where you are over encoding.
        2. If n > encoding[index], deduct enc[index] from n and move to next index (index + 2)
        3. If there are enough numbers, deduct their quantity (encoding[index] -= n) and return
             encoding[index + 1].
        4. If index >= encoding.length, return -1 by default.
    */
    int index;
    int[] encoding;
    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
    }

    public int next(int n) {
        int toDelete, toReturn = -1;
        while (n > 0 && index < encoding.length) {
            toDelete = Math.min(n, encoding[index]);
            n -= toDelete;
            encoding[index] -= toDelete;
            if (n == 0) {
                toReturn = encoding[index + 1];
            }
            if (encoding[index] == 0) {
                index += 2;
            }
        }
        return toReturn;
    }
}
