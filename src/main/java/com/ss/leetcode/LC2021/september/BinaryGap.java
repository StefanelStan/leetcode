package com.ss.leetcode.LC2021.september;

public class BinaryGap {
    // https://leetcode.com/problems/binary-gap/
    public int binaryGap(int n) {
        String nBinary = Integer.toBinaryString(n);
        int maxDistance = 0, distance = 0, nrOfOnes = 0;
        for (int i = 0; i < nBinary.length(); ) {
            if (nBinary.charAt(i) == '1') {
                nrOfOnes++;
                distance = getZeroDistance(i + 1, nBinary);
                if (distance < 0) {
                    break;
                } else {
                    maxDistance = Math.max(distance, maxDistance);
                    i += distance;
                }
            } else {
                i++;
            }
        }
        return nrOfOnes < 2 ? 0 : maxDistance;
    }

    private int getZeroDistance(int start, String s) {
        int distance = 1;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                distance++;
                if (i == s.length() - 1) {
                    return -1;
                }
            } else {
                break;
            }
        }
        return distance;
    }
}
