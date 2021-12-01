package com.ss.leetcode.LC2021.july;

public class ExcelSheetColumnTitle {
    // https://leetcode.com/problems/excel-sheet-column-title/
    private static final char[] CHARS = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                                                    'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public String convertToTitle(int columnNumber) {
        StringBuilder stb = new StringBuilder();
        int div = 0;

        while(columnNumber > 0) {
            div = (columnNumber -1) % 26;
            stb.append(CHARS[div]);
            columnNumber = (columnNumber - 1) / 26;
        }
        return stb.reverse().toString();
    }
}
