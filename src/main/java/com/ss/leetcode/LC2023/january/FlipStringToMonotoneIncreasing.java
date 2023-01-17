package com.ss.leetcode.LC2023.january;

public class FlipStringToMonotoneIncreasing {

    /** Algorithm
     *  1. Count the ones. If there are 0 1s or ALL are 1s, return 0 as no change is needed.
     *  2. While counting, retain the position of the 1st 1 (from left).
     *  3. Set your min changes to be the min required to make all string 1 starting from firstOnePosition.
     *  4. Iterate from last index to the position of first 1, counting how many 1s you have encountered so far
     *      - If char is 1, determine a how many flips would need to make everything on left 0 and everything on right 1
     *         (Know that you already know how many 1s you have passed so far and how many you got left on left side
     *      - If char is 0, determine how many flips you need to make everything on left 0 and from index+1 all 1s.
     *  5. Return the minChanges required amongst all these changes.
     */
    public int minFlipsMonoIncr(String s) {
        int ones = 0, firstOnePos = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                ones++;
                firstOnePos = i;
            }
        }
        if (ones == 0 || ones == s.length()) {
            return 0;
        }
        int minChanges = s.length() - firstOnePos;
        int onesSoFar = 0;
        for (int i = s.length() -1; i >= firstOnePos; i--) {
            if (s.charAt(i) == '1') {
                onesSoFar++;
                minChanges = Math.min(minChanges, ((s.length() - i - onesSoFar) + (ones - onesSoFar)));
            } else {
                minChanges = Math.min(minChanges, (ones - onesSoFar) + ((s.length() - i - 1) - onesSoFar));
            }
        }
        return minChanges;
    }
}
