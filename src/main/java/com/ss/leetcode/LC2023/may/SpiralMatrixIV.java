package com.ss.leetcode.LC2023.may;

import com.ss.leetcode.shared.ListNode;

public class SpiralMatrixIV {
    // https://leetcode.com/problems/spiral-matrix-iv
    private static final int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;
    private static final int[][] COEFF = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int horizontalDistance = n, verticalDistance = m - 2;
        int x = 0, y = 0;
        ListNode[] currentHead = {head};
        int currentDirection = EAST;
        int insertedElements = 0;
        while (insertedElements < m * n) {
            switch (currentDirection) {
                case EAST -> {
                    insertElements(matrix, x, y, COEFF[currentDirection], horizontalDistance, currentHead);
                    insertedElements += horizontalDistance;
                    x++;
                    y = y + horizontalDistance - 1;
                }
                case SOUTH -> {
                    insertedElements += verticalDistance;
                    insertElements(matrix, x, y, COEFF[currentDirection], verticalDistance, currentHead);
                    x = x + verticalDistance;
                    // prepare x,y for next direction
                }
                case WEST -> {
                    insertElements(matrix, x, y, COEFF[currentDirection], horizontalDistance, currentHead);
                    insertedElements += horizontalDistance;
                    // prepare x,y for next direction
                    x--;
                    y = 1 + y - horizontalDistance;
                    horizontalDistance -= 2;
                }
                default -> {
                    insertElements(matrix, x, y, COEFF[currentDirection], verticalDistance, currentHead);
                    insertedElements += verticalDistance;
                    // prepare x,y for next direction
                    x = (x - verticalDistance) + 1;
                    y++;
                    verticalDistance -= 2;
                }
            }
            currentDirection = (currentDirection + 1) % 4;
        }
        return matrix;
    }

    private void insertElements(int[][] matrix, int x, int y, int[] indices, int steps, ListNode[] head) {
        int insertValue = -1;
        while(steps-- > 0) {
            if (head[0] != null) {
                insertValue = head[0].val;
                head[0] = head[0].next;
            } else {
                insertValue = -1;
            }
            matrix[x][y] = insertValue;
            x += indices[0];
            y += indices[1];
        }
    }









    public int[][] spiralMatrix2(int m, int n, ListNode head) {
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
