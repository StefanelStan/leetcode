package com.ss.leetcode.LC2022.april;

public class ContainerWithMostWater {
    // https://leetcode.com/problems/container-with-most-water/
    /** Algorithm
     *  1. In order to find the biggest container, we have to balance width with height. Could be the widest or the tallest.
     *  2. Take lines 0 and n-1 as reference reference[0,1]
     *  3. In a while loop, with low and high index, look on right OR left side, depending on which reference is smaller.
     *  4. If height of left reference is smaller than right reference, look on left side for next greater line, starting from left ref position
     *     and stopping at right reference position. If no greater element is found, return -1 or BREAK tke loop as you reached the end.
     *     If right reference is smaller than left one, then look on the right side (starting from right ref) to next greater line
     *  5. Once found, determine if this new container is bigger than the reference container. If yes, then update the reference container
     *  6. Repeat this until low = high OR the next Greater returned passes the stopping point.
     *  7. Return the reference container size.
     */
    public int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int[] maxArea = { 0, height.length - 1 };
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                left = getNextGreaterElement(left + 1, right, height[left], height, +1);
            } else {
                right = getNextGreaterElement(right - 1, left, height[right], height, -1);
            }
            if (left == -1 || right == -1) {
                break;
            }
            if ((Math.min(height[maxArea[0]], height[maxArea[1]]) * (maxArea[1] - maxArea[0])) < (Math.min(height[left], height[right]) * (right - left))) {
                maxArea[0] = left;
                maxArea[1] = right;
            }
        }
        return Math.min(height[maxArea[0]], height[maxArea[1]]) * (maxArea[1] - maxArea[0]);
    }

    // Trick to navigate backwards or forwards (from start to end pos), depending on the int direction: +1 (forward,) -1 backwards.
    private int getNextGreaterElement(int startPos, int endPos, int ref, int[] height, int direction) {
        for (int i = startPos; i != endPos; i += direction) {
            if (height[i] > ref) {
                return i;
            }
        }
        return -1;
    }
}
