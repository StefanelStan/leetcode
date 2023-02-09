package com.ss.leetcode.LC2023.february;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamingACompany {
    // https://leetcode.com/problems/naming-a-company/
    // TLE
    /**
     * Algorithm
     *  1. Build a map of idea suffixes starting with 2nd char and the boolean[] starting chars
     *      EG: ["car","dar"]: "ar" -> [false, false, true, true...]
     *          ["bit","ait"]: "it" -. [true, true, false, false....]
     *  2. In fact, we only need the list of boolean[] so we can group i 0..n-1 with j i+1...n
     *  3. Comparing first array with 2nd array: if up is true and down is false, count up +1
     *      if down is true and up is false, count down+1
     *      return 2 * up * down.
     */
    private static final String singleCharIdea = "R";
    public long distinctNames(String[] ideas) {
        List<boolean[]> suffixesList = getSuffixes(ideas);
        long distinctNames = 0;
        for (int i = 0; i < suffixesList.size() -1; i++) {
            for (int j = i +1; j < suffixesList.size(); j++) {
                distinctNames += getDistinctNames(suffixesList.get(i), suffixesList.get(j));
            }
        }
        return distinctNames;
    }

    private List<boolean[]> getSuffixes (String[] ideas) {
        Map<String, boolean[]> suffixes = new HashMap<>();
        char ch;
        String suffix;
        for (String idea : ideas) {
            ch = idea.charAt(0);
            suffix = idea.length() > 1 ? idea.substring(1) : singleCharIdea;
            suffixes.computeIfAbsent(suffix, k -> new boolean[26])[ch - 'a'] = true;
        }
        return new ArrayList<>(suffixes.values());
    }

    private int getDistinctNames(boolean[] left, boolean[] right) {
        int distinctOne = 0, distinctTwo = 0;
        for (int i = 0; i < left.length; i++) {
            if (left[i] && !right[i]) {
                distinctOne++;
            }
            if (right[i] && !left[i]) {
                distinctTwo++;
            }
        }
        return 2 * distinctOne * distinctTwo;
    }
}
