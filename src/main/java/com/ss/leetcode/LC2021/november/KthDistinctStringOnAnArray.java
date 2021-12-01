package com.ss.leetcode.LC2021.november;

import java.util.LinkedHashMap;
import java.util.Map;

public class KthDistinctStringOnAnArray {
    // https://leetcode.com/problems/kth-distinct-string-in-an-array/
    public String kthDistinct(String[] arr, int k) {
        Map<String, Encounter> encounters = new LinkedHashMap<>();
        for (String s : arr) {
            Encounter e = encounters.computeIfAbsent(s, v -> new Encounter());
            e.times++;
        }
        int times = 0;
        for (Map.Entry<String, Encounter> entry : encounters.entrySet()) {
            if (entry.getValue().times == 1) {
                times++;
                if (times == k) {
                    return entry.getKey();
                }
            }
        }
        return "";
    }

    private static class Encounter {
        int times;
    }
}
