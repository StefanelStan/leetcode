package com.ss.leetcode.LC2022.april;

public class MinimumBitFlipsToConvertNumber {
    // https://leetcode.com/contest/biweekly-contest-75/problems/minimum-bit-flips-to-convert-number/
    /** Algorithm
        1. While start > 0 OR goal  > 0, check their last bit match
        2. If it does not match, then you need to flip it, so increment flips by 1
        3. Return total number of flips.
     */
    public int minBitFlips(int start, int goal) {
        int flips = 0;
        while (start > 0 || goal > 0) {
            flips += ((start & 1) == (goal & 1) ? 0 : 1);
            start = start >> 1;
            goal = goal >> 1;
        }
        return flips;
    }

    // LOL SOLUTION
    /** Algorithm
     *  1. Convert start and goal to binary String representation
     *     eg:  7 = 111 , 17 = 10001
     *  2. Determine which string is shortest/longest so you can traverse them in a bit-significant level and count the differences
     *     eg: thus, will do a difference between 111 and 001 (substring of 1010).
     *  3. For the longest string (10001) traverse from 0 to the remaining index 1 (longest.length - shortest.length)
     *     and count if the char is != than 0;
     *     100 => only one bit is 1.
     *  4. This sum will be the difference between the two binary representations of numbers
     */
    public int minBitFlips2(int start, int goal) {
        String binaryStart = Integer.toBinaryString(start);
        String binaryGoal = Integer.toBinaryString(goal);

        String shortString = start < goal ? binaryStart : binaryGoal;
        String longString = shortString == binaryGoal ? binaryStart : binaryGoal;
        int diff = 0;

        diff += getDifference(longString, shortString,  longString.length() - shortString.length());
        if (longString.length() != shortString.length()) {
            for (int i = 0; i < longString.length() - shortString.length(); i++) {
                if (longString.charAt(i) != '0') {
                    diff++;
                }
            }
        }
        return diff;
    }

    private int getDifference(String longString, String shortString, int start) {
        int diff = 0;
        for (int i = 0; i < shortString.length(); i++) {
            if (longString.charAt(start + i) != shortString.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}
