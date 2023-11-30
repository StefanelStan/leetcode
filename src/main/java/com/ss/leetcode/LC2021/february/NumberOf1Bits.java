package com.ss.leetcode.LC2021.february;

public class NumberOf1Bits {
    // https://leetcode.com/problems/number-of-1-bits
    /** Algorithm
     *  1. The bit mask will be 1 and will shift to left 31 times. EG: 1, 10, 100, 1000, 10000
     *  2. With each step, it will test if n has a bit of 1 on pos 0,1,2,3 etc.
     *  3. If it has a pos of 1, then increment numberOfOnes;
     *  4. Stop after 31 steps.
     *  5. If n < 0, it will have 1 more bit, the sign one (1 for negative)
     */
    public int hammingWeight(int n) {
        int bitMask = 1, numberOfOnes = 0, steps = 0;
        while(steps < 31) {
            numberOfOnes += ((n & bitMask) == 0 ? 0 : 1);
            bitMask = bitMask << 1;
            steps++;
        }
        return n < 0 ? numberOfOnes +1 : numberOfOnes;
    }
    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        String val = Integer.toBinaryString(n);
        int nrOfOne = 0;
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '1') {
                nrOfOne++;
            }
        }
        return nrOfOne;
    }
}
