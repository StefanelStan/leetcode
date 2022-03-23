package com.ss.leetcode.LC2022.march;

public class BrokenCalculator {
    // https://leetcode.com/problems/broken-calculator/
    /** Algorithm
         1. If startValue > target (eg: 20, 3), return the difference, as only deductions are possible
         2. For any other cases, apply divide et impera tactic
         3. Divide et impera for start < target : In order to hit target, you need to hit half of target.
         As from half of target, there is only one move to target (multiplication by 2)
         4. If start == target, return 0, no steps are required
         5. If target is odd, add 1 to it and call 1 + divide et impera.
         EG: target = 7. adding 1 = 8. So start will have to hit 8 and deduct 1 (7).
         6. If start == half of target, return 1, as only a multiplicatio step is needed from start to target
         7. If start < half, then return 1 + divideEtImpera(start, half), as one extra step is needed to hit half
         8. If start > half, then you need to deduct to reach half and then multiply it (1 + start - half)
     */
    public int brokenCalc(int startValue, int target) {
        if (target < startValue) {
            return startValue - target;
        }
        return divideEtImpera(startValue, target);
    }

    private int divideEtImpera(int startValue, int target) {
        // if equal
        if (startValue == target) {
            return 0;
        }
        if (target % 2 == 1 && startValue < target) {
            return 1 + divideEtImpera(startValue, target + 1);
        }
        // if half and even
        if (startValue == target /2) {
            return 1;
        } else if (startValue < target / 2) {
            return 1 + divideEtImpera(startValue, target /2);
        } else {
            return 1 + (startValue - target /2);
        }
    }
}
