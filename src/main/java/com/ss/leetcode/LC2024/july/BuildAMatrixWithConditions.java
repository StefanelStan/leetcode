package com.ss.leetcode.LC2024.july;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuildAMatrixWithConditions {
    // https://leetcode.com/problems/build-a-matrix-with-conditions
    // TODO
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] offsetByRow = getOffset(k + 1, rowConditions);
        if (offsetByRow != null) {
            int[] offSetByColumn = getOffset(k + 1, colConditions);
            return offSetByColumn != null ? buildMatrix(k, offsetByRow, offSetByColumn) : new int[0][0];
        }
        return new int[0][0];
    }

    private int[][] buildMatrix(int k, int[] offsetByRow, int[] offsetByColumn) {
        int[][] matrix = new int[k][k];
        boolean[] added = new boolean[k + 1];
        // add the mandatory ones: have an offset by 1
        for (int i = 1; i <= k; i++) {
            if (offsetByRow[i] > 1 && offsetByColumn[i] > 1) {
                addByOffset(matrix, i, offsetByRow[i], offsetByColumn[i]);
                added[i] = true;
            }
        }
        for (int i = 1; i <= k; i++) {
            if (!added[i] && (offsetByRow[i] > 1 || offsetByColumn[i] > 1)) {
                addByOffset(matrix, i, offsetByRow[i], offsetByColumn[i]);
                added[i] = true;
            }
        }
        for (int i = 1; i <= k; i++) {
            if (!added[i] && (offsetByRow[i] > 0 || offsetByColumn[i] > 0)) {
                addByOffset(matrix, i, offsetByRow[i], offsetByColumn[i]);
                added[i] = true;
            }
        }
        // add the rest of them
        int x = 0, y = 0;
        boolean put = true;
        for (int i = 1; i <= k; i++) {
            if (!added[i]) {
                put = false;
                for(; x < k && !put ; x = (x + 1) % k) {
                    for (; y < k && !put; y = (y + 1) % k) {
                        if (matrix[x][y] == 0) {
                            matrix[x][y] = i;
                            put = true;
                        }
                    }
                }
            }
        }
        return matrix;
    }

    private void addByOffset(int[][] matrix, int num, int offsetByRow, int offsetByColumn) {
        if (offsetByRow > 0 && offsetByColumn > 0) {
            for (int i = offsetByRow -1; i < matrix.length; i++) {
                for (int j = offsetByColumn -1; j < matrix.length; j = Math.max(offsetByColumn -1, (j + 1) % matrix.length)) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = num;
                        return;
                    }
                }
            }
        } else if (offsetByRow == 0) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][offsetByColumn - 1] == 0) {
                    matrix[i][offsetByColumn - 1] = num;
                    break;
                }
            }
        } else {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[offsetByRow -1][j] == 0) {
                    matrix[offsetByRow -1][j] = num;
                    break;
                }
            }
        }
    }

    private int[] getOffset(int k, int[][] conditions) {
        int[] offset = new int[k];
        int difference = 1;
        int[] indegree = new int[k];
        List<Integer>[] outgoing = getOutgoing(k, conditions, indegree);
        LinkedList<Integer> queue = getNoIndegree(indegree);
        int size = 0, currentNode;
        boolean added = true;
        while(!queue.isEmpty() && added) {
            added = false;
            size = queue.size();
            while (size > 0) {
                currentNode = queue.removeFirst();
                indegree[currentNode]--;
                if (outgoing[currentNode] != null) {
                    for (int next : outgoing[currentNode]) {
                        if (--indegree[next] == 0) {
                            added = true;
                            queue.addLast(next);
                        }
                    }
                }
                offset[currentNode] = difference;
                size--;
            }
            difference++;
        }
        for (int i = 1; i < offset.length; i++) {
            if (indegree[i] > 0) {
                return null;
            }
        }
        return offset;
    }

    private LinkedList<Integer> getNoIndegree(int[] indegree) {
        LinkedList<Integer> answer = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                answer.addLast(i);
            }
        }
        return answer;
    }

    private List<Integer>[] getOutgoing(int k, int[][] connections, int[] indegree) {
        boolean[][] connected = new boolean[k][k];
        List<Integer>[] outgoing = new List[k];
        for (int[] connection : connections) {
            if (!connected[connection[0]][connection[1]]) {
                if (outgoing[connection[0]] == null) {
                    outgoing[connection[0]] = new ArrayList<>();
                }
                outgoing[connection[0]].add(connection[1]);
                indegree[connection[1]]++;
                connected[connection[0]][connection[1]] = true;
            }
        }
        return outgoing;
    }
}
