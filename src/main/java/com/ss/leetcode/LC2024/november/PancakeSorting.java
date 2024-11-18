package com.ss.leetcode.LC2024.november;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSorting {
    // https://leetcode.com/problems/pancake-sorting
    /** Algorithm
        1. Map each number to its positio in an int[n+1] numPos
        2. Loop from last number (n-1) if that number does not have the last position in arr, flip from 0 to k.
            - This way, that number becomes on index 0.
            - Then flip from pos 0 to position n-1, assigning that number to correct insert index in arr.
            - Add the flipped positions to the answer.
     */
    public List<Integer> pancakeSort(int[] arr) {
        int[] numPos = getNumPos(arr);
        List<Integer> flips = new ArrayList<>();
        int highestIndex = arr.length - 1;
        for (int i = numPos.length - 1; i > 0; i--) {
            if (numPos[i] != -1) {
                if (numPos[i] != highestIndex) {
                    performFlips(arr, highestIndex, i, numPos, flips);
                }
                highestIndex--;
            }
        }
        return flips;
    }

    private void performFlips(int[] arr, int highestIndex, int value, int[] numPos, List<Integer> flips) {
        if (numPos[value] > 0) {
            flipToIndex(arr, numPos[value], numPos, flips);
        }
        flipToIndex(arr, highestIndex, numPos, flips);

    }

    private void flipToIndex(int[] arr, int right, int[] numPos, List<Integer> flips) {
        int temp;
        flips.add(right + 1);
        for(int left = 0; left < right; left++, right--) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            numPos[arr[left]] = left;
            numPos[arr[right]] = right;
        }
    }

    private int[] getNumPos (int[] arr) {
        int[] numPos = new int[arr.length + 1];
        Arrays.fill(numPos, -1);
        for (int i = 0 ; i < arr.length; i++) {
            numPos[arr[i]] = i;
        }
        return numPos;
    }
}
