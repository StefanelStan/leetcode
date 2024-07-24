package com.ss.leetcode.LC2021.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortArrayByIncreasingFrequency {
    // https://leetcode.com/problems/sort-array-by-increasing-frequency
    public int[] frequencySort(int[] nums) {
        int[][] freq = new int[201][2];
        for (int num : nums) {
            freq[num + 100][0] = num;
            freq[num + 100][1]++;
        }
        Arrays.sort(freq, (a,b) -> a[1] == b[1] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));
        int[] answer = new int[nums.length];
        int insertIndex = nums.length - 1;
        for (int i = 200; i >= 0 && insertIndex >= 0; i--) {
            while (freq[i][1]-- > 0) {
                answer[insertIndex--] = freq[i][0];
            }
        }
        return answer;
    }

    public int[] frequencySort2(int[] nums) {
        int[] freq = new int[201];
        List<Integer> numbers = new ArrayList<>(nums.length);
        for (int num : nums) {
            numbers.add(num + 100);
            freq[num + 100]++;
        }
        return numbers.stream().sorted((a,b) -> freq[a] == freq[b] ? Integer.compare(b, a) : Integer.compare(freq[a], freq[b])).mapToInt(a -> a - 100).toArray();
    }

    public int[] frequencySort3(int[] nums) {
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
