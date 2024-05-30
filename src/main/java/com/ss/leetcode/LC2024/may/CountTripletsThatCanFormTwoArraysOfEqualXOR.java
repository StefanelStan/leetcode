package com.ss.leetcode.LC2024.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR {
    // https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
    public int countTriplets(int[] arr) {
        int triplets = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            triplets += countXorTriplets(arr, i);
        }
        return triplets;
    }

    private int countXorTriplets(int[] arr, int from) {
        int count = 0, leftXor = arr[from], rightXor;
        for (int i = from; i < arr.length - 1; i++) {
            leftXor = i == from ? leftXor : leftXor ^ arr[i];
            rightXor = arr[i+1];
            for (int j = i + 1; j < arr.length; j++) {
                rightXor = j == i + 1 ? rightXor : rightXor ^ arr[j];
                count += (leftXor == rightXor ? 1 : 0);
            }
        }
        return count;
    }


    // not working
    public int countTriplets2(int[] arr) {
        int triplets = 0, prefixXor = arr[0];
        Map<Integer, List<Integer>> xorPositions = getXorPositions(arr);
        triplets += countXorTriplets(arr, prefixXor, 0, xorPositions);
        for (int i = 1; i < arr.length - 1; i++) {
            prefixXor = prefixXor ^ arr[i];
            triplets += countXorTriplets(arr, prefixXor, i, xorPositions);
        }
        return triplets;
    }

    private int countXorTriplets(int[] arr, int prefixXor, int from, Map<Integer, List<Integer>> xorPositions) {
        int count = 0, intervalXor = arr[from], targetXor;
        for (int i = from; i < arr.length - 1; i++) {
            intervalXor = (i == from ? arr[i] : intervalXor ^ arr[i]);
            targetXor = prefixXor ^ intervalXor;
            count += countRightSize(xorPositions.get(targetXor), i + 1);
        }
        return count;
    }


    private Map<Integer, List<Integer>> getXorPositions(int[] arr) {
        Map<Integer, List<Integer>> xorPositions = new HashMap<>();
        int xor = arr[0];
        xorPositions.computeIfAbsent(xor, k -> new ArrayList<>()).add(0);
        for (int i = 1; i < arr.length; i++) {
            xor = xor ^ arr[i];
            xorPositions.computeIfAbsent(xor, k -> new ArrayList<>()).add(i);
        }
        return xorPositions;
    }

    private int countRightSize(List<Integer> list, int target) {
        if (list == null) {
            return 0;
        }
        int low = 0, high = list.size() - 1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (list.get(pivot) == target) {
                return list.size() - pivot;
            } else if (list.get(pivot) < target) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return list.size() - low;
    }
}
