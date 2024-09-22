package com.ss.leetcode.LC2024.september;

import java.util.HashMap;
import java.util.Map;

public class FindTheNumberOfDistinctColorsAmongTheBalls {
    // https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls
    /** Algorithm
        1. Use 2 Maps<Integer, Integer> coloredBalls and usedColors and  to keep track of the color of each ball and counting the colors
        2. When coloring a ball:
            - set the new color of the ball (coloredBalls)
            - if that ball had another color before, you have to decrement the count for that color (usedColors).
                If the new count becomes 0, then remove that color from the map.
            - increment the count of the new color (usedColors)
        3. After coloring each ball, save the size of the usedColors.
     */
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> usedColors = new HashMap<>();
        Map<Integer, Integer> coloredBalls = new HashMap<>();
        int[] results = new int[queries.length];
        Integer oldBallColor;
        for (int i = 0; i < queries.length; i++) {
            oldBallColor = coloredBalls.put(queries[i][0], queries[i][1]);
            if (oldBallColor != null && usedColors.merge(oldBallColor, -1, Integer::sum) == 0) {
                usedColors.remove(oldBallColor);
            }
            usedColors.merge(queries[i][1], 1, Integer::sum);
            results[i] = usedColors.size();
        }
        return results;
    }
}
