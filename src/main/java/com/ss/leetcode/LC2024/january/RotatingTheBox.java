package com.ss.leetcode.LC2024.january;

public class RotatingTheBox {
    // https://leetcode.com/problems/rotating-the-box
    /** Algorithm
        1. Create your char[][] rotated of size[columns][rows]
        2. For each line of box populate each column of rotated: line 0 or box = column[m-1]; line1 = column[m-2]
        3. Populating each column
            - Traverse line with i from n-1 to 0. Use an moveIndex that will start from m-1 to 0.
            - MoveIndex will be your 2nd pointer that will populate column index
            - With each insert #, your moveIndex will go up by 1 (moveIndex--)
            - If you encounter an obstacle (*), your moveIndex will point to current index (i-1) and not on moveIndex
            - If you encounter a space, just copy that to current index (and not moveIndex)
     */
    public char[][] rotateTheBox(char[][] box) {
        char[][] rotated = new char[box[0].length][box.length];
        for (int i = 0; i < box.length; i++) {
            rotateLine(box[i], box.length - i - 1, rotated);
        }
        return rotated;
    }

    private void rotateLine(char[] line, int index, char[][] rotated) {
        int moveIndex = line.length - 1;
        for (int i = line.length - 1; i >= 0; i--) {
            switch (line[i]) {
                case '#':
                    rotated[i][index] = '.';
                    rotated[moveIndex--][index] = '#';
                    break;
                case '*':
                    rotated[i][index] = '*';
                    moveIndex = i - 1;
                    break;
                default:
                    rotated[i][index] = '.';
            }
        }
    }
}
