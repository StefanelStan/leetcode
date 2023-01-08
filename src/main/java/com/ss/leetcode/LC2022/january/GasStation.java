package com.ss.leetcode.LC2022.january;

public class GasStation {
    // https://leetcode.com/problems/gas-station/
    /** Algorithm
     *  1. Try to collect gas from station0
     *  2. If at any point your tank is < 0, you know that your starting position is not the right as you will run out of gas if you start from there
     *  3. So increment your startPos to next one.
     */
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
