package com.ss.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReorderedPowerOf2 {
    // https://leetcode.com/problems/reordered-power-of-2/
    private static final Set<String> powersOfTwo = new HashSet<>();

    static {
        int power = 1;
        powersOfTwo.add("1");
        for (int i = 1; i <= 30; i++) {
            power *= 2;
            powersOfTwo.add(getSortedStringValueOf(power));
        }
    }

    public boolean reorderedPowerOf2(int number) {
        // create a map of power of 2 power 30 and put them in map of SortedList()
        return powersOfTwo.contains(getSortedStringValueOf(number));
        // get digits of number and sort them. Check if the map contains the sorted digits of number
    }

    private static String getSortedStringValueOf(int value) {
        char[] chars = Integer.toString(value).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
