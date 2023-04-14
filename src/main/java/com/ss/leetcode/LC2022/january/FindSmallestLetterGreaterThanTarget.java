package com.ss.leetcode.LC2022.january;

public class FindSmallestLetterGreaterThanTarget {
    // https://leetcode.com/problems/find-smallest-letter-greater-than-target/
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (letters[pivot] <= target) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low == letters.length ? letters[0] : letters[low];
    }

    //LOL Binary Search
    public char nextGreatestLetter2(char[] letters, char target) {
        int left = 0, right = letters.length -1;
        int pivot;
        while(left <= right) {
            if (left == right) {
                if (target >= letters[left]) {
                    return letters[0];
                } else {
                    return letters[right];
                }
            }
            pivot = left + (right - left) / 2;
            if (letters[right] <= target) {
                return letters[0];
            }
            if (letters[left] > target) {
                return letters[left];
            }
            if (letters[pivot] <= target) {
                left = pivot + 1;
            } else if (letters[pivot] > target) {
                if (pivot -1 >= 0 && letters[pivot -1] <= target) {
                    return letters[pivot];
                } else {
                    right = pivot -1;
                }
            }
        }
        return 'a';
    }
}
