package com.ss.leetcode.LC2022.november;

public class GetEqualSubstringsWithinBudget {
    // https://leetcode.com/problems/get-equal-substrings-within-budget/
    /** Algorithm
         1. Use a flexible window technique that will hold start, end, size and cost
         2. Traverse each index i=[0,n] of both strings and attempt to expand the window
         3. If after one expansion the cost is withing the budget, check/set the maxSize
         4. If the cost if over the budget, reduce the window size from the left until under the budget
         5. Return the longest/max window size.
     */
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLength = 0;
        FlexibleWindow fw = new FlexibleWindow(s.toCharArray(), t.toCharArray());
        while(fw.increase()) {
            if (fw.totalCost <= maxCost) {
                maxLength = Math.max(maxLength, fw.size);
            } else {
                while(fw.totalCost > maxCost) {
                    fw.decrease();
                }
            }
        }
        return maxLength;
    }

    private static class FlexibleWindow {
        int start = 0, end = -1;
        int totalCost = 0;
        char[] sChars;
        char[] tChars;
        int size = 0;

        public FlexibleWindow(char[] sChars, char[] tChars) {
            this.sChars = sChars;
            this.tChars = tChars;
        }

        public void decrease() {
            totalCost -= Math.abs(sChars[start] - tChars[start]);
            start++;
            if (start > end) {
                end = start -1;
            }
            size--;
        }

        public boolean increase() {
            if (end + 1 >= sChars.length) {
                return false;
            }
            end++;
            totalCost += Math.abs(sChars[end] - tChars[end]);
            size++;
            return true;
        }
    }
}
