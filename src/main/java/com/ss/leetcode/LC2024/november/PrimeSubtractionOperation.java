package com.ss.leetcode.LC2024.november;

import java.util.ArrayList;
import java.util.List;

public class PrimeSubtractionOperation {
    // https://leetcode.com/problems/prime-subtraction-operation
    /** Algorithm
        1. Populate the first prime numbers from 2 to 997.
            - This can also be done "on-demand"/LAZY, per call, if last item in the list is lesser than the searched/required number
        2. For each number, you need to lower it (subtract) the closest prime number <= curr - prev - 1.
        3. Use binary search to find that target prime number. If target is < 2, return 0, as no prime can be deducted
        4. Deduct that prime from current number. If prev >= current, return false
     */
    private static List<Integer> PRIMES;
    public boolean primeSubOperation(int[] nums) {
        populatePrimes();
        int prev = 0;
        for (int num : nums) {
            num -= findNextPrime(num - prev - 1);
            if (num <= prev) {
                return false;
            }
            prev = num;
        }
        return true;
    }

    private int findNextPrime(int target) {
        if(target < 2) {
            return 0;
        }
        int low = 0, high = PRIMES.size() - 1;
        int pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (PRIMES.get(pivot) == target) {
                return target;
            } else if (PRIMES.get(pivot) < target) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return PRIMES.get(low - 1);
    }

    // Can also do LAZY if last prime < target number
    private void populatePrimes() {
        if (PRIMES == null) {
            PRIMES = new ArrayList<>();
            PRIMES.add(2);
            for (int i = 3; i <= 997; i += 2) {
                if (isPrime(i)) {
                    PRIMES.add(i);
                }
            }
        }
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
