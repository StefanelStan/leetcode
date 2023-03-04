package com.ss.leetcode.LC2023.march;

public class NumberOfTimesBinaryStringIsPrefixAligned {
    // https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned
    /** Algorithm
        1. Looking at the definition of "prefix-align" we need all 1s (so far) to be ahead of zeroes.
        2. Looking at the example [1,1,1,1,0,0,0] flips [4,1,3,2,8,5,6,7] we can say is align IF at position 4 we have flipped the fist 4 bits.
        3. How can we tell if the interval 1.4 contains exactly the numbers 1,2,3,4 ?
            We can detect that by checking the maximum known so far.
        4. index 1: maxSoFar = 4. Can we say that we have 4 numbers flipped? No, the index is 1
           index 2: maxSoFar = 4. The same: only 2 numbers are flipped
          ..index 4: marSoFar = 4 ! We know that the maximum is 4 and we have 4 numbers! This means that 1,2,3,4 are
            in this set => is it prefix aligned!
        5. If your maxSoFar matches index (1 indexed) in flips, then that sequence is prefixied.
     */
    public int numTimesAllBlue(int[] flips) {
        int maxSoFar = -1, prefixes = 0;
        for (int i = 0; i < flips.length; i++) {
            maxSoFar = Math.max(flips[i], maxSoFar);
            if (maxSoFar == i + 1) {
                prefixes++;
            }
        }
        return prefixes;
    }
}
