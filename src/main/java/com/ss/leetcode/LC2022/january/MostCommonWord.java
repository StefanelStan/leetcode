package com.ss.leetcode.LC2022.january;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    // https://leetcode.com/problems/most-common-word/
    public String mostCommonWord(String paragraph, String[] banned) {
        StringBuilder stb = new StringBuilder();
        Set<String> bannedWords = new HashSet<>();
        int maxTimes = 0;
        String maxWord = "";
        Collections.addAll(bannedWords, banned);
        Map<String, Integer> encounters = new HashMap<>();
        for (int i = 0; i < paragraph.length(); i++) {
            if (Character.isLetter(paragraph.charAt(i))) {
                stb.append(Character.toLowerCase(paragraph.charAt(i)));
            } else {
                if (stb.length() > 0 && !bannedWords.contains(stb.toString())) {
                    String str = stb.toString();
                    encounters.merge(str, 1, Integer::sum);
                    int times = encounters.get(str);
                    if (times > maxTimes) {
                        maxTimes = times;
                        maxWord = str;
                    }
                }
                stb.setLength(0);
            }
        }
        if (stb.length() > 0) {
            String str = stb.toString();
            if (!bannedWords.contains(stb.toString())) {
                encounters.merge(str, 1, Integer::sum);
                int times = encounters.get(str);
                if (times > maxTimes) {
                    maxWord = str;
                }
            }
        }
        return maxWord;
    }
}
