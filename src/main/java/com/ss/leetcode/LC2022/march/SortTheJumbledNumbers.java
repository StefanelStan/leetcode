package com.ss.leetcode.LC2022.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class SortTheJumbledNumbers {
    // https://leetcode.com/contest/biweekly-contest-73/problems/sort-the-jumbled-numbers/
    /** Algorithm
        1. Use an int[n][2] numbers to hold the [mapped_value, order] of each num
        2. Traverse nums and set the [mapped_value, order] of each nums.
        3. Sort numbers based on mapped_value and based on order
        4. Return an int[] array that will have the nums that are pointed/found in original nums at the position of each by numbers[i].order (numbers[i][1])
     */
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] numbers = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numbers[i][0] = mapValue(nums[i], mapping);
            numbers[i][1] = i;
        }
        Arrays.sort(numbers, (a,b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[numbers[i][1]];
        }
        return answer;
    }

    private int mapValue(int num, int[] mapping) {
        int value = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            value = value * 10 + (mapping[c - '0']);
        }
        return value;
    }

    public int[] sortJumbled2(int[] mapping, int[] nums) {
        JumbledNumber[] numbers = new JumbledNumber[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = new JumbledNumber(mapValue(nums[i], mapping), i);
        }
        Arrays.sort(numbers, Comparator.comparingInt(JumbledNumber::value).thenComparingInt(JumbledNumber::order));
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[numbers[i].order()];
        }
        return answer;
    }

    private record JumbledNumber(int value, int order) {}

    public int[] sortJumbled3(int[] mapping, int[] nums) {
        boolean inOrder = true;
        for (int i = 1; i < mapping.length && inOrder; i++) {
            if (mapping[i] < mapping[i-1]) {
                inOrder = false;
            }
        }
        if (inOrder) {
            Arrays.sort(nums);
            return (nums);
        }

        // not in order
        TreeMap<Integer, List<Integer>> mappedNums = new TreeMap<>();
        int mappedVal;
        for (int num : nums) {
            mappedVal = getMappedVal(num, mapping);
            mappedNums.computeIfAbsent(mappedVal, v -> new ArrayList<>()).add(num);
        }
        int[] sortedJumbled = new int[nums.length];
        constructInOrder(sortedJumbled, mappedNums);
        return sortedJumbled;
    }

    private int getMappedVal(int num, int[] mapping) {
        int val = 0;
        String stringNum = String.valueOf(num);
        for (int i = 0; i < stringNum.length(); i++) {
            val = val * 10 + mapping[stringNum.charAt(i) - '0'];
        }
        return val;
    }

    private void constructInOrder(int[] sortedJumbled, TreeMap<Integer, List<Integer>> mappedNums) {
        int[] index = {0};
        mappedNums.forEach((k, v) -> {
            v.forEach(num -> {
                sortedJumbled[index[0]] = num;
                index[0]++;
            });
        });
    }
}
