package com.ss.leetcode.LC2022.may;

import java.util.LinkedList;

public class LongestValidParentheses {
    // https://leetcode.com/problems/longest-valid-parentheses/
    public int longestValidParentheses(String s) {
        LinkedList<Character> list = new LinkedList<>();
        int longestChain = 0;
        int openScore = 0;
        for(char c : s.toCharArray()) {
            if (c == ')') {
                // closing bracket. It is closing well or not?
                if (openScore > 0) {
                    openScore--;
                    list.add(')');
                } else {
                    // must do an eviction.
                    longestChain = Math.max(longestChain, list.size());
                    list.clear();
                }
            } else {
                list.add('(');
                openScore++;
            }
        }
        if (!list.isEmpty()) {
            //something is not closed properly. Which is it?
            int[] maxChain = {0};
            getMaxFromChain(list, openScore, maxChain);
            longestChain = Math.max(longestChain, maxChain[0]);
        }
        return longestChain;
    }

    private void getMaxFromChain(LinkedList<Character> list, int extraOpenBrackets, int[] maxChain) {
        // traverse from back and get where is cracks. Also, check to see to not get caught:
        // "()()()(()"
        // "()(((()))"
        // traverse from back and count when you hit the first extra (
        // when found it, count the extra (, till extraOpen is 0.
        // from there, return the index till 0 size.
        int closeScore = 0;
        char ch;
        int length = 0;
        while(!list.isEmpty()) {
            ch = list.removeLast();
            if (ch == ')') {
                closeScore++;
            } else {
                if (closeScore > 0) {
                    closeScore--;
                    length += 2;
                    maxChain[0] = Math.max(maxChain[0], length);
                } else {
                    maxChain[0] = Math.max(maxChain[0], length);
                    extraOpenBrackets--;
                    if (extraOpenBrackets >= 0) {
                        getMaxFromChain(list, extraOpenBrackets, maxChain);
                        break;
                    } else {
                        maxChain[0] = Math.max(maxChain[0], list.size());
                    }
                }
            }
        }
    }
}
