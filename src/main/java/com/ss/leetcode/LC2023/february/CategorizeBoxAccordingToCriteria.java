package com.ss.leetcode.LC2023.february;

public class CategorizeBoxAccordingToCriteria {
    // https://leetcode.com/problems/categorize-box-according-to-criteria
    /** Algorithm
        1. Apply a sign for each base category: bulky = 1, heavy = 2.
        2. Use a String[] matching their combinations: "Neither", "Bulky", "Heavy","Both"
        3. Return [bulky + heavy]
     */
    private static final String[] category = {"Neither", "Bulky", "Heavy","Both"};
    public String categorizeBox(int length, int width, int height, int mass) {
        int bulky = Math.max(length, Math.max(width, height)) >= 10000 ||
            (long)length * width * height >= 1_000_000_000L ? 1 : 0;
        int heavy = mass >= 100 ? 2 : 0;
        return category[bulky+heavy];
    }
}
