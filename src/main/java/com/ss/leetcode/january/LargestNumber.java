package com.ss.leetcode.january;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class LargestNumber {
    // https://leetcode.com/problems/largest-number/
    public String largestNumber(int[] nums) {
        NavigableMap<Integer, List<String>> sortedNumbers = putNumbersIntoSortedMap(nums);
        StringBuilder stb = new StringBuilder();
        for (int i = 9; i >= 1; i--) {
            if (sortedNumbers.containsKey(i)) {
                List<String> nrs = sortedNumbers.get(i);
                nrs.sort(new IntStringComparator());
                if (!nrs.isEmpty()) {
                    nrs.forEach(stb::append);
                }
            }
        }
        if (stb.length() > 0){
            List<String> nrs = sortedNumbers.get(0);
            if (nrs != null) {
                nrs.forEach(stb::append);
            }
        } else if (sortedNumbers.containsKey(0)) {
            stb.append(0);
        }

        return stb.toString();
    }

    private NavigableMap<Integer, List<String>> putNumbersIntoSortedMap(int[] nums) {
        NavigableMap<Integer, List<String>> numbers = new TreeMap<>();
        for (int num : nums) {
            String numAsString = String.valueOf(num);
            int firstDigit = Integer.parseInt(String.valueOf(numAsString.charAt(0)));
            List<String> set = numbers.get(firstDigit);
            if (set == null) {
                set = new LinkedList<>();
            }
            set.add(numAsString);
            numbers.putIfAbsent(firstDigit, set);
        }
        return numbers;
    }

    private static class IntStringComparator implements Comparator<String> {

        @Override
        public int compare(String string1, String string2) {
            Long s1s2 = Long.parseLong(string1 + string2);
            Long s2s1 = Long.parseLong(string2 + string1);
            return s2s1.compareTo(s1s2);
        }
    }
}
