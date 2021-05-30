package com.ss.leetcode.may;

public class MaximumNestingDepthParentheses {
    // https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
    public int maxDepth(String s) {
        int maxDepth = 0, depthCoefficient = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depthCoefficient++;
                if (depthCoefficient > maxDepth) {
                    maxDepth = depthCoefficient;
                }
            } else if (s.charAt(i) == ')') {
                depthCoefficient--;
            }
        }
        return maxDepth;
    }
}
