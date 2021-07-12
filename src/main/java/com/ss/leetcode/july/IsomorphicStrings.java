package com.ss.leetcode.july;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        int sCurrentIndex, tCurrentIndex;
        for (int i = 0; i < s.length(); i++) {
            if (!sMap.containsKey(s.charAt(i))) {
                sMap.put(s.charAt(i), sMap.size());
            }
            sCurrentIndex = sMap.get(s.charAt(i));

            if (!tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i), tMap.size());
            }
            tCurrentIndex = tMap.get(t.charAt(i));

            if(sCurrentIndex != tCurrentIndex) {
                return false;
            }
        }
        return true;
    }
}
