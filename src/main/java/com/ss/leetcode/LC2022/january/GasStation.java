package com.ss.leetcode.LC2022.january;

public class GasStation {
    // https://leetcode.com/problems/gas-station/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTank = 0, collectedGas = 0, startPos = 0;
        for(int i = 0; i < gas.length; i++) {
            gasTank += (gas[i] - cost[i]);
            collectedGas += (gas[i] - cost[i]);
            if (gasTank < 0) {
                gasTank = 0;
                startPos = i +1;
            }
        }
        return collectedGas < 0 ? -1 : startPos;
    }
}
