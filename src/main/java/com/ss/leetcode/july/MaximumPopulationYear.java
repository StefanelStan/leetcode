package com.ss.leetcode.july;

public class MaximumPopulationYear {
    // https://leetcode.com/problems/maximum-population-year/
    public int maximumPopulation(int[][] logs) {
        int[] livingYears = new int[101];
        for (int[] log : logs) {
            insertLivingYears(livingYears, log[0] - 1950, log[1] - 1950 - 1);
        }
        int maxPopYear = 0, maxPopYearIndex = 0;
        for (int i = 0; i < livingYears.length; i++) {
            if (livingYears[i] > maxPopYear) {
                maxPopYear = livingYears[i];
                maxPopYearIndex = i;
            }
        }
        return maxPopYearIndex + 1950;
    }

    private void insertLivingYears(final int[] livingYears, final int fromYear, final int toYear) {
        for (int i = fromYear; i <= toYear; i++) {
            livingYears[i]++;
        }
    }
}
