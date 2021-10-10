package com.ss.leetcode.october;

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int result = left;
        int startLeft = left;
        while (++left <= right && result !=0) {
            result &= left;
        }
        return left < 0 ? startLeft : result;
    }
}
