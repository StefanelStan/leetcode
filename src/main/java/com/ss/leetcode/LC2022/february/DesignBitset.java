package com.ss.leetcode.LC2022.february;

import java.util.Arrays;

public class DesignBitset {
    // https://leetcode.com/contest/weekly-contest-279/problems/design-bitset/
    private int oneCount = 0;
    private boolean[] ones;
    private boolean[] zeroes;

    public DesignBitset(int size) {
        ones = new boolean[size];
        zeroes = new boolean[size];
        Arrays.fill(zeroes, true);
    }

    public void fix(int idx) {
        if (!ones[idx]) {
            ones[idx] = true;
            zeroes[idx] = false;
            oneCount++;
        }
    }

    public void unfix(int idx) {
        if (ones[idx]) {
            ones[idx] = false;
            zeroes[idx] = true;
            oneCount--;
        }
    }

    public void flip() {
        boolean[] tmp = ones;
        ones = zeroes;
        zeroes = tmp;
        oneCount = ones.length - oneCount;
    }

    public boolean all() {
        return oneCount == ones.length;
    }

    public boolean one() {
        return oneCount > 0;
    }

    public int count() {
        return oneCount;
    }

    public String toString() {
        char[] digits = new char[ones.length];
        for (int i = 0; i < ones.length; i++) {
            digits[i] = ones[i] ? '1' : '0';
        }
        return new String(digits);
    }

    private static class DesignBitset2 {
        boolean[] bitset;
        boolean flipped = false;
        int ones = 0;

        public DesignBitset2(int size) {
            this.bitset = new boolean[size];
        }

        public void fix(int idx) {
            if (!flipped) {
                if (!bitset[idx]) {
                    bitset[idx] = true;
                    ones++;
                }
            } else {
                if (bitset[idx]) {
                    bitset[idx] = false;
                    ones++;
                }
            }
        }

        public void unfix(int idx) {
            if (!flipped) {
                if (bitset[idx]) {
                    bitset[idx] = false;
                    ones--;
                }
            } else {
                if (!bitset[idx]) {
                    bitset[idx] = true;
                    ones--;
                }
            }
        }

        public void flip() {
            flipped = !flipped;
            ones = bitset.length - ones;
        }

        public boolean all() {
            return ones == bitset.length;
        }

        public boolean one() {
            return ones > 0;
        }

        public int count() {
            return ones;
        }

        public String toString() {
            char[] digits = new char[bitset.length];
            for (int i = 0; i < digits.length; i++) {
                digits[i] = !flipped ? (bitset[i] ? '1' : '0') : (bitset[i] ? '0' : '1');
            }
            return new String(digits);
        }
    }
}
