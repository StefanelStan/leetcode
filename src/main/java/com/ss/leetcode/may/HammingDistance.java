package com.ss.leetcode.may;

public class HammingDistance {
    // https://leetcode.com/problems/hamming-distance/
    public int hammingDistance(int x, int y) {
        String min = Integer.toBinaryString(Math.min(x, y));
        String max = Integer.toBinaryString(Math.max(x, y));
        int distance = 0;
        for (int minI = min.length() -1, maxJ = max.length()-1; minI >= 0; minI--, maxJ--) {
            if (min.charAt(minI) != max.charAt(maxJ)) {
                distance++;
            }
        }
        if (max.length() > min.length()) {
            for (int i = 0; i < max.length() - min.length(); i++) {
                if (max.charAt(i) == '1') {
                    distance++;
                }
            }
        }
        return distance;
    }
}
