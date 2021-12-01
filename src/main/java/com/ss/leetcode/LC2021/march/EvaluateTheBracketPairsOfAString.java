package com.ss.leetcode.LC2021.march;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateTheBracketPairsOfAString {
    // https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> keyMap = new HashMap<>();
        StringBuffer stb = new StringBuffer(s);
        for(List<String> item : knowledge) {
            keyMap.put(item.get(0), item.get(1));
        }

        int endPosition = 0;
        for (int i = s.length() -1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                endPosition = i;
            } else if (s.charAt(i) == '(') {
                findAndReplaceSequence(i, endPosition, stb, keyMap);
            }
        }
        return stb.toString();
    }

    private void findAndReplaceSequence(int seqStart, int seqEnd, StringBuffer stb,  Map<String, String> keyMap) {
        String word = stb.substring(seqStart+1, seqEnd);
        stb.replace(seqStart, seqEnd+1, keyMap.getOrDefault(word, "?"));
    }

}
