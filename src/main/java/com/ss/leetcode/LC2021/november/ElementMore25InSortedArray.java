package com.ss.leetcode.LC2021.november;

public class ElementMore25InSortedArray {
    // https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
    public int findSpecialInteger(int[] arr) {
        int oneFourth = arr.length / 4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i+oneFourth]) {
                return arr[i];
            }
        }
        return 0;
    }
}
