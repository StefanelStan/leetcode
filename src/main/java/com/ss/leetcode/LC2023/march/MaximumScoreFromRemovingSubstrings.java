package com.ss.leetcode.LC2023.march;

import java.util.LinkedList;

public class MaximumScoreFromRemovingSubstrings {
    // https://leetcode.com/problems/maximum-score-from-removing-substrings
    /** Algorithm
        1. Traverse the string and eliminate the grouping that has the max score: [a,b] or [b,a]
            Use a LinkedList/Stack to keep the leftovers. The leftovers might contain the min grouping
        2. Traverse the LinkedList and with the help of a 2nd LinkedList/Stack perform the same logic as in step 1, but for
            the min score grouping
     */
    public int maximumGain(String s, int x, int y) {
        int maxScore = Math.max(x, y);
        int minScore = Math.min(x, y);
        char[] min = x <= y ? new char[]{'a', 'b'} : new char[]{'b', 'a'};
        char[] max = y >= x ? new char[]{'b', 'a'} : new char[]{'a', 'b'};
        if (s.length() == 1) {
            return 0;
        }
        LinkedList<Character> chars = new LinkedList<>();
        int maxGain = removeMaxCombination(chars, s, maxScore, max);
        maxGain += removeMinCombination(chars, minScore, min);
        return maxGain;
    }

    private int removeMaxCombination(LinkedList<Character> chars, String s, int maxScore, char[] max) {
        char current;
        int maxGain = 0;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (!chars.isEmpty() && chars.peekLast() == max[0] && current == max[1]) {
                chars.removeLast();
                maxGain += maxScore;
            } else {
                chars.add(current);
            }
        }
        return maxGain;
    }

    private int removeMinCombination(LinkedList<Character> chars, int score, char[] min) {
        LinkedList<Character> mins = new LinkedList<>();
        int gain = 0;
        for(char c : chars) {
            if (!mins.isEmpty() && mins.peekLast() == min[0] && c == min[1]) {
                gain += score;
                mins.removeLast();
            } else {
                mins.add(c);
            }
        }
        return gain;
    }
}
