package com.ss.leetcode.july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckIfNAndDoubleExist {
    // https://leetcode.com/problems/check-if-n-and-its-double-exist/
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

    public boolean checkIfExist(int[] arr) {
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
