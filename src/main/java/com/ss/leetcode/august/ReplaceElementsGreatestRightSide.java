package com.ss.leetcode.august;

public class ReplaceElementsGreatestRightSide {
    // https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
    public int[] replaceElements(int[] arr) {
        int[] maxRightElements = new int[arr.length];
        maxRightElements[arr.length -1] = arr[arr.length -1];
        int maxRightSize = arr[arr.length -1];
        for (int i = arr.length -2; i>=0; i--) {
            maxRightElements[i] = Math.max(maxRightElements[i + 1], arr[i]);
        }
        System.arraycopy(maxRightElements, 1, arr, 0, arr.length - 1);
        arr[arr.length -1] = -1;
        return arr;
    }
}
