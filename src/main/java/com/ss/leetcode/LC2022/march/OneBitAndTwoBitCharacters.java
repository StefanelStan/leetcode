package com.ss.leetcode.LC2022.march;

public class OneBitAndTwoBitCharacters {
    // https://leetcode.com/problems/1-bit-and-2-bit-characters/
    /** Algorithm
         1. Traverse with an index i: if bits[0] == 0, increase by 1, else by 2
        2. If reached the end, check and return if last bit is 0 or 1
        3. If the loop did not return anything, then it means the last char was double,
            terminating the index. If it's double char, then return false.
     */
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length;) {
            if (i == bits.length -1) {
                return bits[i] == 0;
            }
            i += (bits[i] + 1);
        }
        return false;
    }
}
