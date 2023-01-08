package com.ss.leetcode.LC2023.january;

public class MostFrequentEvenElement {
    /** Algorithm
        1. Traverse and map each even number to its count (use an int[250000] (num / 2) or map)
        2. While doing so, keep track/always save  the min mostFrequestElement and how many times it is present.
        3. If such element exists, return it, else return -1.
     */
    public int mostFrequentEven(int[] nums) {
        int[] mostEven = new int[250_001];
        int maxTimes = -1, mostFrequentNum = 500_000, halfNum;
        for (int num : nums) {
            if (num % 2 == 0) {
                halfNum = num/2;
                mostEven[halfNum]++;
                if (mostEven[halfNum] > maxTimes) {
                    maxTimes = mostEven[halfNum];
                    mostFrequentNum = num;
                } else if (mostEven[halfNum] == maxTimes) {
                    mostFrequentNum = Math.min(num, mostFrequentNum);
                }
            }
        }
        return maxTimes == -1 ? -1 : mostFrequentNum;
    }
}
