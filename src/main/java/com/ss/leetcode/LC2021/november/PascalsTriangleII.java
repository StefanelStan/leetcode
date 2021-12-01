package com.ss.leetcode.LC2021.november;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    // https://leetcode.com/problems/pascals-triangle-ii/
    public List<Integer> getRow(int rowIndex) {
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
