package com.ss.leetcode.september;

public class NumberComplement {
    // https://leetcode.com/problems/number-complement/
    public int findComplement(int num) {
        char[] chrs = Integer.toBinaryString(num).toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            chrs[i] = chrs[i] == '0' ?  '1' : '0';
        }
        return Integer.parseInt(new String(chrs), 2);
    }
}
