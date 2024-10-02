package com.ss.leetcode.LC2024.october;

public class FindTheGridOfRegionAverage {
    // https://leetcode.com/problems/find-the-grid-of-region-average
    /** Algorithm
        1. Create a class RegionAverage(regionCount, avgSum) and RegionAverage[m][n] regionAverages.
            - This will keep track of each cells status: to how many regions it belongs and a cumumative sum of their average.
        2. For each cell[i][j] [0->m-3, 0-n-3] check if that cell can be the top-left corner of a region. (basically check if all the cells are good)
            - For each cell, just check it's RIGHT and DOWN only. (if right/down is not outside its 3x3 scope)
            - If that top-corner makes a good region, returns its sum of cells.
        3. If that is a good top-left corner (sum >= 0), then set the count and ave inside the regionAverages.
        4. Create your int[m][n] answer and check/set each cell based on regionAverages.
            - if  regionAverages[i][j] == null, your answer is image[i][j], else regionAverages[i][j].sum / regionAverages[i][j].count.
     */
    public int[][] resultGrid(int[][] image, int threshold) {
        int regionSum;
        RegionAverage[][] regionAverages = getRegionAverages(image, threshold);
        int[][] resultGrid = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                resultGrid[i][j] = regionAverages[i][j] == null ? image[i][j] : regionAverages[i][j].sumOfAvgs / regionAverages[i][j].countOfRegions;
            }
        }
        return resultGrid;
    }

    private RegionAverage[][] getRegionAverages(int[][] image, int threshold) {
        int regionSum;
        RegionAverage[][] regionAverages = new RegionAverage[image.length][image[0].length];
        for (int i = 0; i < image.length -2; i++) {
            for (int j = 0; j < image[0].length -2; j++) {
                regionSum = getValidRegionSum(image, i, j, threshold);
                if (regionSum >= 0) {
                    addRegionAverage(regionAverages, i, j, regionSum / 9);
                }
            }
        }
        return regionAverages;
    }

    private void addRegionAverage(RegionAverage[][] regionAverages, int i, int j, int average) {
        for (int r = i; r < i + 3; r++) {
            for(int c = j; c < j + 3; c++) {
                if (regionAverages[r][c] == null) {
                    regionAverages[r][c] = new RegionAverage();
                }
                regionAverages[r][c].countOfRegions++;
                regionAverages[r][c].sumOfAvgs += average;
            }
        }
    }

    private int getValidRegionSum(int[][] image, int i, int j, int threshold) {
        int sum = 0;
        for (int r = i; r < i + 3; r++) {
            for (int c = j; c < j + 3; c++) {
                if ((c < j + 2 && Math.abs(image[r][c] - image[r][c+1]) > threshold) || (r < i + 2 && Math.abs(image[r][c] - image[r + 1][c]) > threshold)) {
                    return -1;
                }
                sum += image[r][c];
            }
        }
        return sum;
    }

    private static class RegionAverage {
        int countOfRegions;
        int sumOfAvgs;
    }
}
