package com.ss.leetcode.september;

public class ComplementOfBase10Integer {
    // https://leetcode.com/problems/complement-of-base-10-integer/
    public int bitwiseComplement(int n) {
        char[] chrs = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            chrs[i] = chrs[i] == '0' ?  '1' : '0';
        }
        return Integer.parseInt(new String(chrs), 2);
    }
}
