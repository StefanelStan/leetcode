package com.ss.leetcode.LC2025.january;

public class MinimizeXOR {
    // https://leetcode.com/problems/minimize-xor
    /** Algorithm
        1. Make the mask and chars1 to be the same length char array: 30
        2. Get the bitcount of num2
        3. To minimize the result, you must write the same bit (0 or 1) of num1 to the mask
           - this can be done if you have enough 1s (if bit is 1) or you still have room on the right to put 0 (and keep 1s ar the end).
        4. Greedily, match 1s and 0s from the beginning and leave 1s for the end
     */
    public int minimizeXor(int num1, int num2) {
        char[] chars1 = new char[30];
        char[] mask = new char[30];
        populateBits(chars1, num1);
        int bitCount = Integer.bitCount(num2);
        for (int i = 0; i < chars1.length; i++) {
            if (canPutTheSame(chars1[i], i, bitCount)) {
                mask[i] = chars1[i];
                bitCount -= (mask[i] == '1' ? 1 : 0);
            } else {
                mask[i] = (chars1[i] == '1' ? '0' : '1');
                bitCount -= (mask[i] - '0');
            }
        }
        return Integer.parseInt(new String(mask), 2);
    }

    private boolean canPutTheSame(char reference, int maskIndex, int remBits) {
        return reference == '1' ? remBits > 0 : remBits < 30 - maskIndex;
    }

    private void populateBits(char[] chars, int num) {
        int bitValue;
        for (int i = chars.length - 1; i >= 0; i--) {
            bitValue = (num & 1);
            chars[i] = (char)('0' + bitValue);
            num = num >> 1;
        }
    }
}
