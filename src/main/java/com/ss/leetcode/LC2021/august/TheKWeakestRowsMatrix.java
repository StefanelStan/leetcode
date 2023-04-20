package com.ss.leetcode.LC2021.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TheKWeakestRowsMatrix {
    // https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] weakRows = mapWeakRows(mat);
        int[] kWeakest = new int[k];
        while(k > 0) {
            kWeakest[k-1] = weakRows[k-1][1];
            k--;
        }
        return kWeakest;
    }

    private int[][] mapWeakRows(int[][] mat) {
        int[][] weakRows = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            weakRows[i][0] = powerOf(mat[i]);
            weakRows[i][1] = i;
        }
        Arrays.sort(weakRows, (a, b) -> a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]);
        return weakRows;
    }

    private int powerOf(int[] row) {
        int left = 0, right = row.length -1, pivot;
        while(left <= right) {
            pivot = left + (right - left) / 2;
            if (row[pivot] == 1) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return row[0] == 1 ? left : 0;
    }

    public int[] kWeakestRows2(int[][] mat, int k) {
        int[][] rows = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int count  = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            rows[i][0] = i;
            rows[i][1] = count;
        }

        Arrays.sort(rows, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int[] order = new int[k];
        for (int i = 0; i < k; i++) {
            order[i] = rows[i][0];
        }
        return order;
    }

    public int[] kWeakestRows3(int[][] mat, int k) {
        List<Row> rows = new ArrayList<>(mat.length);
        int nrOfSoldiers = 0;
        for (int i = 0; i < mat.length; i++) {
            nrOfSoldiers = 0;
            for (int j = 0; j< mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    nrOfSoldiers++;
                } else {
                    break;
                }
            }
            rows.add(new Row(i, nrOfSoldiers));
        }

        Collections.sort(rows);
        int[] result = new int[k];
        for (int i = 0; i <k; i++) {
            result[i] = rows.get(i).rowNumber;
        }
        return result;
    }

    private static class Row implements Comparable<Row>{
        int rowNumber;
        int soldiers;
        public Row(int rowNumber, int soldiers) {
            this.rowNumber = rowNumber;
            this.soldiers = soldiers;
        }

        public int compareTo(Row other) {
            int compare = Integer.compare(soldiers, other.soldiers);
            return compare == 0 ? Integer.compare(rowNumber, other.rowNumber) : compare;
        }
    }
}
