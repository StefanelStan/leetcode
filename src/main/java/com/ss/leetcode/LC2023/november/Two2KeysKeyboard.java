package com.ss.leetcode.LC2023.november;

public class Two2KeysKeyboard {
    // https://leetcode.com/problems/2-keys-keyboard
    /** Algorithm
        1. Any number can be build with the help of its highest divisors:
            EG: 15 = 5 + 5 + 5 => Actions of 5 + copy(5) + paste(5) + paste(5).
            So steps of (5) + 3 (15/5) extra steps.
        2. Loop with i from n/2 to 2
            -  if n % i == 0 (highest divisor), your answer is n/i + steps(i);
        3. If there is no divisor, then it's a prime number, so return n
     */
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        for (int i = n/2; i > 1; i--) {
            if (n % i == 0) {
                return (n / i) + minSteps(i);
            }
        }
        // no divisor => prime number.
        return n;
    }
}
