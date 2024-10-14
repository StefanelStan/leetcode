package com.ss.leetcode.LC2024.october;

public class MonotoneIncreasingDigits {
    // https://leetcode.com/problems/monotone-increasing-digits
    /** Algorithm
        1. Looking at the numbers, the highest monotone increasing is ending with 9 (unless number is already monotone: eg: 12345)
        2. To obtain numbers ending with 9, subtract n % (j) + 1 from n, where j is a power of 10: 10,100, 1000.
        3. EG:
            - 332 - (332 % 10 + 1) = 332 - (2 + 1) = 332 - 3 = 329. This is not monotone, so we need to increase the modulo factor to 100
            - 332 - (332 % 100 + 1) = 332 - 33 = 299= > This is a monotone increasing.
        4. Subtract power(10, i) + 1 from n until n becomes monotone.
     */
    public int monotoneIncreasingDigits(int n) {
        int multiplier = 10, decreasedN = n;
        while (!isMonotone(decreasedN)) {
            decreasedN = n - (n % multiplier + 1);
            multiplier *= 10;
        }
        return decreasedN;
    }

    private boolean isMonotone(int n) {
        int prev = Integer.MAX_VALUE, current;
        while (n > 0) {
            current = n % 10;
            if (current > prev) {
                return false;
            }
            prev = current;
            n = n / 10;
        }
        return true;
    }
}
