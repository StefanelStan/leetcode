package com.ss.leetcode.march;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Arrays.sort(nums);
        TreeMap<Integer, List<Integer>> frequencies = new TreeMap<>();
        sortByFrequency(nums, frequencies);
        int[] result = addByFrequency(frequencies, nums.length);

        return result;
    }

    private void sortByFrequency(int[] nums, TreeMap<Integer, List<Integer>> frequencies) {
        int currentElement = nums[nums.length - 1];
        int count = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != currentElement) {
                addFrequency(currentElement, count, frequencies);
                currentElement = nums[i];
                count = 1;
            } else {
                count++;
            }
        }
        // add nums[0] as it hasn't been added
        addFrequency(currentElement, count, frequencies);
    }

    private void addFrequency(int element, int count, TreeMap<Integer, List<Integer>> frequencies) {
        List<Integer> elements = frequencies.get(count);
        if (elements == null) {
            elements = new LinkedList<>();
            elements.add(element);
            frequencies.put(count, elements);
        } else {
            elements.add(element);
        }
    }


    private int[] addByFrequency(TreeMap<Integer, List<Integer>> frequencies, int length) {
        int[] result = new int[length];
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : frequencies.entrySet()) {
            for (int element : entry.getValue()) {
                for (int i = 0; i < entry.getKey(); i++) {
                    result[index] = element;
                    index++;
                }
            }
        }
        return result;
    }
}
