package com.ss.leetcode.LC2024.october;

public class MaximumSwap {
    // https://leetcode.com/problems/maximum-swap
    /** Algorithm
        1. You need to find the first situation when current digit is smaller than the max on right. You need to know the last index of that max.
            (In case there are 2 "max" digits on the right, you need the closest to the tail)
        2. Traverse backwards and use 3 variables: minIndexToSwap, maxIndexToSwap and maxIndex. You will swap minIndexToSwap with maxIndexToSwap.
        3. Traverse backwards and if current digit < maxDigitSoFar, mark minIndexToSwap = i and maxIndexToSwap = index of maxDigitSoFar.
        4. Also, set the maxDigitSoFar if current digit > maxDigitSoFar.
        5. If your minIndexToSwap != -1, swap minIndexToSwap with maxIndexToSwap.
     */
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int maxIndex = chars.length - 1, minIndexToSwap = -1, maxIndexToSwap = -1;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] < chars[maxIndex]) {
                minIndexToSwap = i;
                maxIndexToSwap = maxIndex;
            }
            if (chars[i] > chars[maxIndex]) {
                maxIndex = i;
            }
        }
        if (minIndexToSwap != -1) {
            char temp = chars[minIndexToSwap];
            chars[minIndexToSwap] = chars[maxIndexToSwap];
            chars[maxIndexToSwap] = temp;
        }
        return Integer.parseInt(new String(chars));
    }
}
