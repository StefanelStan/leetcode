package com.ss.leetcode.LC2025.september;

public class DesignSpreadsheet {
    // https://leetcode.com/problems/design-spreadsheet
    /** Algorithm
        1. Use an int[rows][26] spreadsheet to save the value of each cell
        2. Set the cell: extract the column (cell[0] - 'A') and row (parseInt(cell[1]..cell[n]])) and set the new value
        3. Reset: set the cell to 0, like in step #2;
        4. Sum: split the formula around "\\+" char.
            - If one operand starts with a char, return the cell value, else the integer value.
     */
    private final int[][] spreadsheet;
    public DesignSpreadsheet(int rows) {
        spreadsheet = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int[] rowCol = getRowColumn(cell);
        spreadsheet[rowCol[0] - 1][rowCol[1]] = value;
    }

    public void resetCell(String cell) {
        int[] rowCol = getRowColumn(cell);
        spreadsheet[rowCol[0] - 1][rowCol[1]] = 0;
    }

    public int getValue(String formula) {
        String[] operands = getOperands(formula);
        return extractValue(operands[0]) + extractValue(operands[1]);
    }

    private int extractValue(String operand) {
        if (operand.charAt(0) >= 'A') {
            int[] rowCol = getRowColumn(operand);
            return spreadsheet[rowCol[0] - 1][rowCol[1]];
        } else {
            return Integer.parseInt(operand);
        }
    }

    private String[] getOperands(String formula) {
        String[] chunks = formula.split("\\+");
        return new String[]{chunks[0].substring(1), chunks[1]};
    }

    private int[] getRowColumn(String cell) {
        int column = cell.charAt(0) - 'A';
        int row = 0;
        for (int i = 1; i < cell.length(); i++) {
            row = row * 10 + (cell.charAt(i) - '0');
        }
        return new int[]{row, column};
    }
}
