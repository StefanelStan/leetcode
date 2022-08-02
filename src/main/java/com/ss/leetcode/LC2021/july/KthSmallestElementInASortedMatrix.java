package com.ss.leetcode.LC2021.july;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length * matrix.length;
        int maxSize = n - k + 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] row : matrix) {
            for (int element : row) {
                queue.add(element);
                if (queue.size() > maxSize) {
                    queue.poll();
                }
            }
        }
        return queue.poll();
    }

    public int kthSmallest2(int[][] matrix, int k) {
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
