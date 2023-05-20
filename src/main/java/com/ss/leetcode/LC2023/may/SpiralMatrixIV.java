package com.ss.leetcode.LC2023.may;

import com.ss.leetcode.shared.ListNode;

public class SpiralMatrixIV {
    // https://leetcode.com/problems/spiral-matrix-iv
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int[] addedElements = {0};
        int topRow = 0, rightCol = n - 1, bottomRow = m-1;
        while(addedElements[0] < m * n) {
            head = addHorizontally(matrix, topRow, rightCol, topRow, 1, addedElements, head);
            head = addVertically(matrix, topRow, bottomRow, rightCol, 1, addedElements, head);
            head = addHorizontally(matrix, rightCol, topRow, bottomRow, -1, addedElements, head);
            head = addVertically(matrix, bottomRow, topRow, topRow, -1, addedElements, head);
            topRow++;
            rightCol--;
            bottomRow--;
        }
        return matrix;
    }

    private ListNode addHorizontally(int[][] matrix, int startCol, int endCol, int row, int direction, int[] addedElements, ListNode head) {
        int toAdd = 0;
        while (addedElements[0] < matrix.length * matrix[0].length) {
            if (head != null) {
                toAdd = head.val;
                head = head.next;
            } else {
                toAdd = -1;
            }
            matrix[row][startCol] = toAdd;
            addedElements[0]++;
            if (startCol == endCol) {
                break;
            }
            startCol += direction;
        }
        return head;
    }

    private ListNode addVertically(int[][] matrix, int startRow, int endRow, int col, int direction, int[] addedElements, ListNode head) {
        int toAdd = 0;
        startRow += direction;
        while (addedElements[0] < matrix.length * matrix[0].length && startRow != endRow) {
            if (head != null) {
                toAdd = head.val;
                head = head.next;
            } else {
                toAdd = -1;
            }
            matrix[startRow][col] = toAdd;
            addedElements[0]++;
            startRow += direction;
        }
        return head;
    }
}
