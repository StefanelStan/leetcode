package com.ss.leetcode.february;

import java.math.BigInteger;

public class ConcatenationOfConsecutiveBinaryNumbers {
    private static final long MOD_CONSTANT = 1000000007;
    public int concatenatedBinary(int n) {
        StringBuilder stb = new StringBuilder();
        for (int i = n; i >= 1 && stb.length() < 150; i--) {
             stb.append(new StringBuilder(Integer.toBinaryString(i)).reverse().toString());
        }

        BigInteger bi = new BigInteger(stb.reverse().toString(), 2);
        BigInteger mod = BigInteger.valueOf(MOD_CONSTANT);

        long result = bi.mod(mod).intValue();
        return (int)result;
    }
}
