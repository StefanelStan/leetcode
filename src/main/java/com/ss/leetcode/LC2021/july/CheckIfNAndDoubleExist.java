package com.ss.leetcode.LC2021.july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckIfNAndDoubleExist {
    // https://leetcode.com/problems/check-if-n-and-its-double-exist/
    public boolean checkIfExist(int[] arr) {
        boolean zeroFound = false;
        Set<Integer> nums = new HashSet<>();
        for (int num : arr) {
            if ((num % 2 == 0 && nums.contains(num / 2)) || nums.contains(num * 2)){
                return true;
            }
            nums.add(num);
        }
        return false;
    }

    public boolean checkIfExist2(int[] arr) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for(int number: arr)
            numbers.merge(number, 1, Integer::sum);
        Integer searchedEntry;
        if (numbers.get(0) != null && numbers.get(0) > 1) return true;
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            searchedEntry = numbers.get(2 * entry.getKey());
            if (searchedEntry != null) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfExist3(int[] arr) {
        Arrays.sort(arr);
        int doubleValue = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            doubleValue = arr[i] * 2;
            for (int j = i + 1; j < arr.length; j++) {
                if (doubleValue == arr[j] || arr[j] * 2 == arr[i]) {
                    return true;
                }
                if (arr[j] > doubleValue && arr[j] > 0) {
                    break;
                }
            }
        }
        return false;
    }
}
