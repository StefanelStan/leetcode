package com.ss.leetcode;

import java.util.List;

public class RiverRecords {
    public int maxTrailing(List<Integer> levels) {
        // Write your code here
        int referenceLevel = levels.get(0);
        int minimumValue  = levels.get(0);
        int maximumDifference = 0;
        int currentDifference = 0;
        boolean aboveReference = false;
        for(int i = 1; i < levels.size(); i++) {
            if(levels.get(i) < minimumValue) {
                minimumValue = levels.get(i);
            }
            if(levels.get(i) > referenceLevel) {
                aboveReference = true;
            }
            if (levels.get(i) > minimumValue) {
                currentDifference = levels.get(i) - minimumValue;
                if (maximumDifference < currentDifference) {
                    maximumDifference = currentDifference;
                }
            }
        }
        return aboveReference ? maximumDifference : -1;
    }
}
