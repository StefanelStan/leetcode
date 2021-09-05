package com.ss.leetcode.september;

import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfFarmland {
    // https://leetcode.com/contest/biweekly-contest-60/problems/find-all-groups-of-farmland/
    public int[][] findFarmland(int[][] land) {
        List<List<Integer>> farms = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                    List<Integer> farm = new ArrayList<>();
                    farm.add(i);
                    farm.add(j);
                    farm.add(i);
                    farm.add(j);
                    parseAndFindFarmland(land, i, j, farm);
                    farms.add(farm);
                }
            }
        }
        return toArray(farms);
    }

    private void parseAndFindFarmland(int[][] land, int i, int j, List<Integer> farm) {
        if (i < 0 || i == land.length || j < 0 || j == land[0].length || land[i][j] != 1) {
            return;
        }

        land[i][j] = 0;
        if (farm.get(2) < i || farm.get(3) < j) {
            farm.set(2, i);
            farm.set(3, j);
        }

        parseAndFindFarmland(land, i - 1, j,farm);
        parseAndFindFarmland(land, i + 1, j,farm);
        parseAndFindFarmland(land, i, j - 1,farm);
        parseAndFindFarmland(land, i, j + 1,farm);
    }

    private int[][] toArray(List<List<Integer>> farms) {
        int[][] result = new int[farms.size()][4];
        for (int i = 0; i < farms.size(); i++) {
            List<Integer> farm = farms.get(i);
            result[i][0] = farm.get(0);
            result[i][1] = farm.get(1);
            result[i][2] = farm.get(2);
            result[i][3] = farm.get(3);
        }
        return result;
    }
}
