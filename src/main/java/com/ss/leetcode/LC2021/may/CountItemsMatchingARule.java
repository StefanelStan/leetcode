package com.ss.leetcode.LC2021.may;

import java.util.List;

public class CountItemsMatchingARule {
    // https://leetcode.com/problems/count-items-matching-a-rule/
    private static final List<String> RULES = List.of("type", "color","name");
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int matches = 0;
        int ruleIndex = RULES.indexOf(ruleKey);
        for (var item : items) {
            if (item.get(ruleIndex).equals(ruleValue)) {
                matches++;
            }
        }
        return matches;
    }
}
