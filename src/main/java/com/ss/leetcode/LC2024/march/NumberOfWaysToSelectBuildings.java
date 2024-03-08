package com.ss.leetcode.LC2024.march;

public class NumberOfWaysToSelectBuildings {
    // https://leetcode.com/problems/number-of-ways-to-select-buildings
    /** Algorithm
        1. If your current number is 1, then all the 0s on the LEFT can be combined (multiplied) with all the 0s from RIGHT.
        2. If your current number is 0, then all the 1s on the LEFT can be combined with all the 1s from RIGHT.
        3. Count the 1s/zeroes.
        4. Traverse the string again, keeping track of how many 1s/0s you have encountered so far. Multiple the LEFT and RIGHT count, depending on current number.
     */
    public long numberOfWays(String s) {
        int totalOne = 0, totalZero;
        for (int i = 0; i < s.length(); i++) {
            totalOne += (s.charAt(i) - '0');
        }
        long numberOfWays = 0;
        totalZero = s.length() - totalOne;
        int countOfOne = s.charAt(0) - '0';
        int countOfZero = 1 - countOfOne;
        int currentNumber;
        for (int i = 1; i < s.length() - 1; i++) {
            currentNumber = s.charAt(i) - '0';
            if (currentNumber == 1) {
                numberOfWays += (long)countOfZero * (totalZero - countOfZero);
            } else {
                numberOfWays += (long)countOfOne * (totalOne - countOfOne);
            }
            countOfOne += currentNumber;
            countOfZero = i + 1 - countOfOne;
        }
        return numberOfWays;
    }
}
