package com.ss.leetcode.LC2024.january;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {
    // https://leetcode.com/problems/count-good-meals
    /** Algorithm
        1. You have a limited number of power of 2: 2^0, 2^1 .. 2^20. Put these into an array powerOfTw[21].
        2. Use a map<int, int> to map and count each number.
        3. For each entry in the map (value, count) try to determine how many pairs it can build.
        4. Determining the pairs
            - loop with i from 20 until 0 && powerOfTwo[i] > number
            - determine the difference between current power of two and selected number
            - see if the diff is present in the map. If yes, multiply the counts (eg: 3 7s and 6 9s) => 18 ways of making 16
            - EDGE CASE: if the diff is equal to given num (eg: num = 4: 8 - 4 = 4.) then you can only pair in two
                (combination of X taken by 2).
            - Pay attention to integer overflow: EG: 100000 4s => 10^10. SO use a long to compute
            - break when current diff if lesser than num
        5. It is important to break when your diff is lesser than the num to avoid counting twice the same values
            EG: you have [1,7]
            - your current num is 7. You check diff for power of two 16: 16 - 7 = 9. No 9 present
            - you check for diff for power of 2 = 8. 8 - 7 = 1. so you have 1 pair
            - when you do the same for current number 1: 8 - 1 = 7, you will count this pair again.
    */
    private static int[] powerOfTwo;
    public int countPairs(int[] deliciousness) {
        initPowerOfTwo();
        Map<Integer, Integer> numsAndCount = getNumsAndCount(deliciousness);
        int pairs = 0;
        for(Map.Entry<Integer, Integer> entry : numsAndCount.entrySet()) {
            pairs = (pairs + countPairsFor(entry.getKey(), entry.getValue(), numsAndCount)) % 1_000_000_007;
        }
        return pairs;
    }

    private int countPairsFor(int num, int count, Map<Integer, Integer> numsAndCount) {
        int diff, sum = 0;
        for (int i = powerOfTwo.length - 1; i >= 0 && powerOfTwo[i] >= num; i--) {
            diff = powerOfTwo[i] - num;
            if (diff > num) {
                sum = (sum + (int)((long)count * numsAndCount.getOrDefault(diff, 0) % 1_000_000_007)) % 1_000_000_007;
            } else if (diff == 0 || diff == num) {
                sum = (sum + (int)(((long)count * (count - 1) / 2) % 1_000_000_007)) % 1_000_000_007;
                break;
            } else {
                break;
            }
        }
        return sum;
    }

    private Map<Integer, Integer> getNumsAndCount(int[] deliciousness) {
        Map<Integer, Integer> numsAndCount = new HashMap<>();
        for (int value : deliciousness) {
            numsAndCount.merge(value, 1, Integer::sum);
        }
        return numsAndCount;
    }

    private void initPowerOfTwo() {
        if (powerOfTwo == null) {
            powerOfTwo = new int[21];
            powerOfTwo[0] = 1;
            for (int i = 1; i < powerOfTwo.length; i++) {
                powerOfTwo[i] = 2 * powerOfTwo[i-1];
            }
        }
    }
}
