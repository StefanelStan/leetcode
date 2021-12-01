package com.ss.leetcode.LC2021.february;

import java.util.LinkedList;
import java.util.List;

public class ReplaceTheSubstringForBalancedString {
    // https://leetcode.com/problems/replace-the-substring-for-balanced-string/
    public int balancedString(String s) {
        List<Integer> qp = new LinkedList<>();
        List<Integer> wp = new LinkedList<>();
        List<Integer> ep = new LinkedList<>();
        List<Integer> rp = new LinkedList<>();

        traverseStringAndCountLetters(s, qp, wp, ep, rp);

        if(qp.size() == wp.size() && wp.size() == ep.size() && ep.size() == rp.size()) {
            return 0;
        }

        return 1;
    }

    private void traverseStringAndCountLetters(String s, List<Integer> qPositions, List<Integer> wPositions,
                                               List<Integer> ePositions, List<Integer> rPositions) {

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'Q' -> qPositions.add(i);
                case 'W' -> wPositions.add(i);
                case 'E' -> ePositions.add(i);
                case 'R' -> rPositions.add(i);
                default -> throw new RuntimeException("Invalid character detected!");
            }
        }
    }
}
