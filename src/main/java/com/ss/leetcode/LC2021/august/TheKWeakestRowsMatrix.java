package com.ss.leetcode.LC2021.august;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheKWeakestRowsMatrix {
    // https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
    public int[] kWeakestRows(int[][] mat, int k) {
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
