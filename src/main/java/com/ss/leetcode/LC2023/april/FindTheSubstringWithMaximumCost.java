package com.ss.leetcode.LC2023.april;

public class FindTheSubstringWithMaximumCost {
    // https://leetcode.com/contest/biweekly-contest-101/problems/find-the-substring-with-maximum-cost/

    /** Algorithm
       1. Determine the cost of each a-z letter: the initial cost is its alphabet index [1,2,3].
           If the letter is in chars, then override the cost with the value from vals[]
       2. For each letter of s, add its cost to a currentCost. If the currentCost is <0, reset it to 0. (max(0, currentCost))
           Also, at east step, determine the max cost between maxCost and currentCost.
       3. Return maxCost.
     */
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int maxGeneralCost = 0, currentCost = 0;
        int[] cost = getCost(chars, vals);
        int codePoint = 0;
        for (int i = 0; i < s.length(); i++) {
            codePoint = s.charAt(i) - 'a';
            currentCost += cost[codePoint];
            maxGeneralCost = Math.max(maxGeneralCost, currentCost);
            currentCost = Math.max(0, currentCost);
        }
        return maxGeneralCost;
    }

    private int[] getCost(String chars, int[] vals) {
        int[] cost = new int[26];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = i+1;
        }
        for (int i = 0; i < chars.length(); i++) {
            cost[chars.charAt(i) - 'a'] = vals[i];
        }
        return cost;
    }
}
