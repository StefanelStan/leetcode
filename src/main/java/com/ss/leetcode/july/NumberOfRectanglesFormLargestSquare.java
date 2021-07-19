package com.ss.leetcode.july;

import java.util.HashMap;
import java.util.Map;

public class NumberOfRectanglesFormLargestSquare {
    // https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/


    public int countGoodRectangles(int[][] rectangles) {
        int maxSize = 0, maxTriangles = 0;
        int currentSize = 0;
        for (int[] rectangle : rectangles) {
            currentSize = Math.min(rectangle[0], rectangle[1]);
            if (currentSize == maxSize) {
                maxTriangles++;
            } else if (currentSize > maxSize) {
                maxSize = currentSize;
                maxTriangles = 1;
            }

        }
        return maxTriangles;
    }

    /*
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> squares = new HashMap<>();
        for (int[] rectangle : rectangles) {
            squares.merge(Math.min(rectangle[0], rectangle[1]), 1, Integer::sum);
        }
        return squares.entrySet().stream().max(Map.Entry.comparingByKey()).get().getValue();
    }
    */
}
