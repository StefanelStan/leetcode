package com.ss.leetcode.LC2022.may;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    // https://leetcode.com/problems/binary-prefix-divisible-by-5/
    /** Algorithm/Theory
         1. In order to determine if a binary is divisible by 5, we have to build the 10 base & check
         2. As the problem states, there will be a stream of bits, 1 and 0 that will build n numbers
             In order to build the next number, start with a value of 0, multiply the current value with 2 and and 0 or 1 (depending on current bit)
             EG: 1100
             step1: value = 0. 0 * 2 + 1 = 1;
             step2: value = 1. 1 * 2 + 1 = 3;
             step3: value = 3. 3 * 2 + 0 = 6;
             step4: value = 6. 6 * 2 + 0 = 12.
         3. Looking at the steps on #2, we can see that no number (1,3,6,12) is divibile by 5
         4. What if the stream is much longer, like 33,34 bits? The numbers will become 4 bil +
             We need to find a smart approach for this.
         5. We don't really need the whole number, but just it's modulo 10.
         EG: value = 6 and the stream continues with [1,1,1,1]
             - 6 * 2 + 1 = 13   => modulo 10 = 3
             13 * 2 + 1 = 27  => 3 * 2 + 1 = 7
             27 * 2 + 1 = 55  => 7 * 2 + 1 = 15 mod 10 = 5.
             6. Thus we observe that the numbers will always be between 0 and 9.
             If current value is 0 or 5, then it divides, if !=, then it doesn't divide.
     */
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> divisibleByFive = new ArrayList<>(nums.length);
        int n = 0;
        for(int bit : nums) {
            n = (n * 2 + bit) % 10;
            divisibleByFive.add(n == 5 || n == 0);
        }
        return divisibleByFive;
    }
}
