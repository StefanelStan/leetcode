package com.ss.leetcode.LC2023.october;

import java.util.HashMap;
import java.util.Map;

public class CountGoodNumbers {
    // https://leetcode.com/problems/count-good-numbers
    /** Algorithm: Divide et impera
        1. Looking at some examples of n:
            EG: n = 2 => we have (0,2,4,6,8) on 0 index * (2,3,5,7) on odd index: so it's 4*5
            EG: n = 4 => 5 * 4 * 5 * 4 => 400.
        2. Looking at greater numbers (eg: n = 10) we have 5*4*5*4*5*4*5*4*5*4. Which end to really high numbers.
        3. However, multiplication is associative, we so we split it into (5*4*5*4*5) * (*4*5*4*5*4).
            We already observe that if we keep splitting this, we end up with the possibility of precomputing the
            multiplication modulo results and feeding them when requested.
        4: EG: n = 8: 5 * 4 * 5 * 4 * 5 * 5 * 5 * 4
            #1:  (5 * 4 * 5 * 4) * (5 * 4 * 5 * 4)
            We observe that if we precumpute first half we already have second half.
        5. Create a helper function that will cache the precumputed results and return them upon calling
            ! Pay attention that for some numbers the halfs will be deifferent:
            EG: n  =6: 5*4*5*4*5*4: (5*4*5) != (4*5*4).
            So you will need 2 maps that will cache the lengths based on their start index: evenIndex and oddIndex.
        6. Recursively split and return the cached results
     */
    private static Map<Long, Integer> evenIndexModulo;
    private static Map<Long, Integer> oddIndexModulo;
    public int countGoodNumbers(long n) {
        initCache();
        if (n <= 2) {
            return evenIndexModulo.get(n);
        }
        return calculateDigitStrings(0, n-1);
    }

    private int calculateDigitStrings(long start, long end) {
        Map<Long, Integer> targetMap =  start % 2 == 0 ? evenIndexModulo : oddIndexModulo;
        Integer cachedResult = targetMap.get(1 + end - start);
        if (cachedResult == null) {
            cachedResult = (int)(((long)calculateDigitStrings(start, start + (end - start)/2)
                * calculateDigitStrings(start + (end - start)/2 + 1, end)) % 1_000_000_007);
            targetMap.put(1 + end - start, cachedResult);
        }
        return cachedResult;
    }

    private void initCache() {
        if (evenIndexModulo == null) {
            evenIndexModulo = new HashMap<>();
            oddIndexModulo = new HashMap<>();
            evenIndexModulo.put(1L,5);
            evenIndexModulo.put(2L, 20);
            oddIndexModulo.put(1L, 4);
            oddIndexModulo.put(2L, 20);
        }
    }
}
