package com.ss.leetcode.september;

public class ReverseBits {
    // https://leetcode.com/problems/reverse-bits/
    public int reverseBits(int n) {
        String bytes = Integer.toBinaryString(n);
        StringBuilder stb = new StringBuilder();
        stb.append("0".repeat(32 - bytes.length()));
        stb.append(bytes);

        return Integer.parseUnsignedInt(stb.reverse().toString(), 2);
    }
}
