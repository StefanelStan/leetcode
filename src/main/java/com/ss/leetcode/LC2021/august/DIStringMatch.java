package com.ss.leetcode.LC2021.august;

public class DIStringMatch {
    // https://leetcode.com/problems/di-string-match/
    public int[] diStringMatch(String s) {
        int[] answer = new int[s.length() + 1];
        int low = 0;
        int high = s.length();
        for (int i = 0; i < answer.length - 1; i++) {
            if (s.charAt(i) == 'I') {
                answer[i] = low++;
            } else {
                answer[i] = high--;
            }
        }
        answer[answer.length - 1] = high;
        return answer;
    }
}
