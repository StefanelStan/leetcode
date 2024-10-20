package com.ss.leetcode.LC2024.october;

public class FindKthBitInNthBinaryString {
    // https://leetcode.com/problems/find-kth-bit-in-nth-binary-string
    /** Algorithm
        1. Use a static char[][] digitCache that will store the first 20 binary strings. The output is constant so it must be static.
        2. If given n is not in cache, populate until n and return it.
        3. For each population, the next row will be formed from previous + 1 + revier(inverse(previous))
     */
    private static final char[][] digitCache = new char[21][];
    private static int size = 1;
    static {
        digitCache[1] = new char[]{'0'};
    }
    public char findKthBit(int n, int k) {
        if (n > size) {
            updateCache(n);
        }
        return digitCache[n][k-1];
    }

    private void updateCache(int n) {
        while (size < n) {
            digitCache[size + 1] = getNextBinaryString(digitCache[size]);
            size++;
        }
    }

    private char[] getNextBinaryString(char[] prev) {
        char[] next = new char[prev.length + 1 + prev.length];
        System.arraycopy(prev, 0, next, 0, prev.length);
        next[prev.length] = '1';
        for (int nextIndex = next.length -1, i = 0; i < prev.length; nextIndex--, i++) {
            next[nextIndex] = prev[i] == '0' ? '1' : '0';
        }
        return next;
    }
}
