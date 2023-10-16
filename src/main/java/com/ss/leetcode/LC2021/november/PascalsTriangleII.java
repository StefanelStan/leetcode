package com.ss.leetcode.LC2021.november;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    // https://leetcode.com/problems/pascals-triangle-ii/
    // OPTIMIZED
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascalRow = new ArrayList<>(rowIndex + 1);
        pascalRow.add(1);
        for (int row = 1; row <= rowIndex; row++) {
            pascalRow.add(1);
            for (int prevRow = row - 1; prevRow > 0; prevRow--) {
                pascalRow.set(prevRow, pascalRow.get(prevRow) + pascalRow.get(prevRow - 1));
            }
        }
        return pascalRow;
    }

    public List<Integer> getRow2(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }
        if (rowIndex == 1) {
            return List.of(1,1);
        }
        List<Integer> pascalRow = new ArrayList<>(rowIndex +1);
        while (rowIndex > 0) {
            pascalRow = getPascalRow(pascalRow);
            rowIndex--;
        }
        return pascalRow;
    }

    private List<Integer> getPascalRow(List<Integer> row) {
        List<Integer> newRow = new ArrayList<>(row.size() +1);
        newRow.add(1);
        for (int i = 0; i < row.size() -1; i++) {
            newRow.add(row.get(i) + row.get(i+1));
        }
        newRow.add(1);
        return newRow;
    }
}
