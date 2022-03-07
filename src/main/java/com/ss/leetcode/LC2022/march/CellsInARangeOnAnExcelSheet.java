package com.ss.leetcode.LC2022.march;

import java.util.ArrayList;
import java.util.List;

public class CellsInARangeOnAnExcelSheet {
    // https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/
    /** Algorithm
         1. Loop from the starting letter to ending letter
         2. Inside this loop, loop again from starting number to ending number
         3. Use a char[2] to store the chars and add it to the list of cells.
         4. Return the answer/cells.
     */
    public List<String> cellsInRange(String s) {
        List<String> cells = new ArrayList<>();
        char[] cell = new char[2];
        for (char l = s.charAt(0); l <= s.charAt(3); l++) {
            cell[0] = l;
            for (char n = s.charAt(1); n <= s.charAt(4); n++) {
                cell[1] = n;
                cells.add(new String(cell));
            }
        }
        return cells;
    }
}
