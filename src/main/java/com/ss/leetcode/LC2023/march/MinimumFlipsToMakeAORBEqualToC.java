package com.ss.leetcode.LC2023.march;

public class MinimumFlipsToMakeAORBEqualToC {
    // https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c
    /** Algorithm
        1. We need to fetch the last bit of a, b and c. This can be done via a & a (bitwise operator)
        2. While a,b,c > 0 fetch their last bit. (LBa)
        3. If LBa | LBb != LBc, then we need 1 or two flips
            IF LBc is 1, we only need 1 flip, else (any of them can be flipped to 1)
            IF LBc is 0, we need the 1s to be flipped to 0: (LBa + LBb)
            How many 1s we have ? LBa + LBb
        4. Shift a,b,c by 1 bit: >> 1;
     */
    public int minFlips(int a, int b, int c) {
        int minFlips = 0;
        int lastBitA, lastBitB, lastBitC;
        while (c > 0 || a > 0 || b > 0) {
            lastBitA = a & 1;
            lastBitB = b & 1;
            lastBitC = c & 1;
            if ((lastBitA | lastBitB) != lastBitC) {
                minFlips += lastBitC == 0 ? (lastBitA + lastBitB) : 1;
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return minFlips;
    }
}
