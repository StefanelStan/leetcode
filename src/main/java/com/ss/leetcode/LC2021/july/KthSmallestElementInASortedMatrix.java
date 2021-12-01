package com.ss.leetcode.LC2021.july;

import java.util.Arrays;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int[] newArray =  new int[matrix.length * matrix[0].length];
        int startPosition = 0;
        for (int[] line : matrix) {
            System.arraycopy(line, 0, newArray, startPosition, line.length);
            startPosition += line.length;
        }
        Arrays.sort(newArray);
        return newArray[k - 1];
    }
}
