package com.ss.leetcode.december;

public class LongestMountain {
    public int longestMountain(int[] numbers) {
        if (numbers.length <3) {
            return 0;
        }
        int longestMountain = 0;
        int currentLength = 0;

        for (int i = 0; i < numbers.length;) {
            int ascendingMountain = findAscendingMountain(numbers, i);
            int descendingMountain = 0;
            if (ascendingMountain > 0) {
                descendingMountain = findDescendingMountain(numbers, i + ascendingMountain);
                if(descendingMountain > 0) {
                    currentLength = 1 + ascendingMountain + descendingMountain;
                    if (currentLength > longestMountain) {
                        longestMountain = currentLength;
                    }
                }
            }
            i+= currentLength > 1 ? currentLength -1 : 1;
            currentLength = 0;
        }

        return longestMountain < 2 ? 0 : longestMountain;
        // https://leetcode.com/problems/longest-mountain-in-array/
    }

    private int findAscendingMountain(int[] numbers, int startIndex) {
        int ascendingMountainLength = 0;
        for (int i = startIndex; i < numbers.length -1; i++) {
            if(numbers[i] < numbers[i+1]) {
                ascendingMountainLength++;
            } else {
                break;
            }
        }
        return ascendingMountainLength;
    }

    private int findDescendingMountain(int[] numbers, int startIndex) {
        int descendingMountainLength = 0;
        for (int i = startIndex; i < numbers.length -1; i++) {
            if(numbers[i] > numbers[i+1]) {
                descendingMountainLength++;
            } else {
                break;
            }
        }
        return descendingMountainLength;
    }
}
