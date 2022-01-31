package com.ss.leetcode.LC2022.january;

public class NumberOfLaserBeamsInABank {
    // https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
    /** Algorithm:
         1. Parse each row and get the number of devices on that row, keeping track of previous row with devices.
         2. If devices > 0, multiply with the devices on previous row and add it the answer.
         3. Return the answer.
     */
    public int numberOfBeams(String[] bank) {
        int beams = 0, rowDevices;
        int prevRowDevices = getRowDevices(bank[0]);
        for (int i = 1; i < bank.length; i++) {
            rowDevices = getRowDevices(bank[i]);
            if (rowDevices > 0) {
                beams += (prevRowDevices * rowDevices);
                prevRowDevices = rowDevices;
            }
        }
        return beams;
    }

    private int getRowDevices(String row) {
        int devices = 0;
        for (int i = 0; i < row.length(); i++) {
            if (row.charAt(i) == '1') {
                devices++;
            }
        }
        return devices;
    }
}
