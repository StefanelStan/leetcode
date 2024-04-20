package com.ss.leetcode.LC2021.september;

import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfFarmland {
    // https://leetcode.com/contest/biweekly-contest-60/problems/find-all-groups-of-farmland/
    /** Algorithm
        1. Traverse matrix and the first land [x][y] = 1 will be the top left corner.
            - From that point you will traverse right and bottom, marking with 0 and keeping track of max(x). max(y).
        2. Iteratively, loop from that [x,y] to the right, stopping when you reach 0 on that row.
        3. At the same time, mark those cells with 0, as they are visited
        4. When finished with this row, move to next row, starting from x+1, y. Mark them with 0.
        5. At each time, keep track of most right point.
        6. Your [x,y, max(x), max(y)] will be the coords of the found island
     */
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> farms = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int[] rightEdge = findAndMark(land, i, j);
                    farms.add(new int[]{i, j, rightEdge[0], rightEdge[1]});
                }
            }
        }
        return farms.toArray(int[][]::new);
    }

    private int[] findAndMark(int[][] land, int x, int y) {
        int[] edge = {x, y};
        for (int i = x; i < land.length && land[i][y] == 1; i++) {
            edge[0] = Math.max(edge[0], i);
            for (int j = y; j < land[0].length && land[i][j] == 1; j++) {
                land[i][j] = 0;
                edge[1] = Math.max(edge[1], j);
            }
        }
        return edge;
    }


    public int[][] findFarmland2(int[][] land) {
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
