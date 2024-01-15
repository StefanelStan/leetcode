package com.ss.leetcode.LC2024.january;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsOfInterchangeableRectangles {
    // https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles
    /** Algorithm
        1. Use a Map<Double, Integer> to group/count the ratio of each rectangle
        2. Iterate over the values and if value > 1, use the combination formula n! / ((n-k)! * k!).
            - When we know k = 2, the formula is ((n-1) * n / 2).
            - Pay attention to long as 10^5 * 10^5 = 10^10.
     */
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> ratioMap = getRatioMap(rectangles);
        long total = 0L;
        for(int count : ratioMap.values()) {
            if (count > 1) {
                total += ((long)(count) * (count-1) / 2);
            }
        }
        return total;
    }

    private Map<Double, Integer> getRatioMap(int[][] rectangles) {
        Map<Double, Integer> ratioMap = new HashMap<>();
        for (int[] rectangle : rectangles) {
            ratioMap.merge((double)rectangle[0] / rectangle[1], 1, Integer::sum);
        }
        return ratioMap;
    }
}
