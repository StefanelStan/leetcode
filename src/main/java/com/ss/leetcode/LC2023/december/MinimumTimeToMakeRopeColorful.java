package com.ss.leetcode.LC2023.december;

public class MinimumTimeToMakeRopeColorful {
    // https://leetcode.com/problems/minimum-time-to-make-rope-colorful
    /** Algorithm
        1. If you have any consecutive colors, then your goal is to eliminate the min ones and keep the max.
            "eg": "abb", [3,4,5]. You want to eliminate 1st b (cost 4) to obtain the fastest elimination time
        2. Traverse the string and keep track of prevColor and prevColorTime.
        3. If current color[i] == prevColor
            - eliminate the min between(time[i], prevColorTime)
            - keep the color of max between these two instances.
            - This way you will always eliminate lower ones and keep the max time color in a consecutive chain
        4. If color[i] != prevColor, then your prevColorTime = time[i] (reset as you are changing colors)
     */
    public int minCost(String colors, int[] neededTime) {
        char prevColor = colors.charAt(0), currentColor;
        int prevColorTime = neededTime[0];
        int minCost = 0;
        for (int i = 1; i < colors.length(); i++) {
            currentColor = colors.charAt(i);
            if (currentColor == prevColor) {
                minCost += Math.min(prevColorTime, neededTime[i]);
                prevColorTime = Math.max(prevColorTime, neededTime[i]);
            } else {
                prevColorTime = neededTime[i];
            }
            prevColor = currentColor;
        }
        return minCost;
    }
}
