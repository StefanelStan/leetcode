package com.ss.leetcode.LC2021.december;

public class RingsAndRods {
    // https://leetcode.com/problems/rings-and-rods/
    public int countPoints(String rings) {
        boolean[][] rods = new boolean[3][10];
        for (int i = 0; i < rings.length(); i += 2) {
            rods[getRGB(rings.charAt(i))][rings.charAt(i + 1) - '0'] = true;
        }
        int points = 0;
        for (int i = 0; i < rods[0].length; i++) {
            if (rods[0][i] && rods[1][i] && rods[2][i]) {
                points++;
            }
        }
        return points;

    }

    private int getRGB(char color) {
        return switch (color) {
            case 'R' -> 0;
            case 'G' -> 1;
            default -> 2;
        };
    }
}
