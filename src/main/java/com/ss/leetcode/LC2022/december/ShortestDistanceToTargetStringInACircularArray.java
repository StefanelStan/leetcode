package com.ss.leetcode.LC2022.december;

public class ShortestDistanceToTargetStringInACircularArray {
    // https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array
    /** Algorithm
     *  1. FailFast: if words[startIndex] == target, return 0 immediately
     *  2. Use two indices/pointers: left (startIndex-1) and right (startIndex+1) that will go left/right by 1
     *  3. Move them one step at a time and check if either left or right matches target. If so, return steps.
     *     If not, increment steps done.
     */
    public int closestTarget(String[] words, String target, int startIndex) {
        if (words[startIndex].equals(target)) {
            return 0;
        }
        int steps = 1;
        int left = startIndex == 0 ? words.length -1 : startIndex - 1;
        int right = startIndex ==words.length -1 ? 0 : startIndex + 1;
        while (steps <= words.length /2) {
            if (words[left].equals(target) || words[right].equals(target)) {
                return steps;
            }
            left = left == 0 ? words.length -1: left - 1;
            right = right == words.length -1 ? 0 : right + 1;
            steps++;
        }
        return -1;
    }

    /** Algorithm
     *  1. Traverse with i from 0 to n and check if current word/index equals target
     *  2. If it matches, determine which would be the best option: to go left of i to 0 then n-1 to startIndex or from i to startIndex.
     *  3. Retain the min best option found.
     *  4. Is such option was found, return it, -1 otherwise.
     */
    public int closestTarget2(String[] words, String target, int startIndex) {
        int shortest = Integer.MAX_VALUE;
        int currentDistance = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                currentDistance = i <= startIndex
                    ? Math.min(startIndex - i, i + words.length - startIndex)
                    : Math.min(i - startIndex, startIndex + words.length - i);
                shortest = Math.min(shortest, currentDistance);
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}
