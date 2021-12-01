package com.ss.leetcode.LC2021.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    // https://leetcode.com/problems/group-anagrams/
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapList = new HashMap<>();
        char[] chars;
        String sorted;
        for(String str : strs) {
            chars = str.toCharArray();
            Arrays.sort(chars);
            sorted = String.valueOf(chars);
            List<String> list = mapList.computeIfAbsent(sorted, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(mapList.values());
    }
}
