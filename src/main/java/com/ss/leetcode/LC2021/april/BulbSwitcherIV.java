package com.ss.leetcode.LC2021.april;

public class BulbSwitcherIV {
    // https://leetcode.com/problems/bulb-switcher-iv/
    public int minFlips(String target) {
        int globalSwitches = 0;
        boolean isGlobalEven = true;
        for (int i =0; i < target.length(); i++) {
            if (target.charAt(i) != (isGlobalEven ? '0' : '1')) {
                globalSwitches++;
                isGlobalEven = !isGlobalEven;
            }
        }
        return globalSwitches;
    }
}
