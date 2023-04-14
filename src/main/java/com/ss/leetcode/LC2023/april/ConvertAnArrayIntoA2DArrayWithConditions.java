package com.ss.leetcode.LC2023.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertAnArrayIntoA2DArrayWithConditions {
    // https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> matrix = new ArrayList<>();
        int[] count = countNums(nums);
        for (int i = 1; i < count.length; i++) {
            if (count[i] > 0) {
                insertIntoMatrix(i, count[i], matrix);
            }
        }
        return matrix;
    }

    private int[] countNums(int[] nums) {
        int[] count = new int[201];
        for (int num : nums) {
            count[num]++;
        }
        return count;
    }
    private void insertIntoMatrix(int num, int times, List<List<Integer>> matrix) {
        for (int i = 1; i <= times; i++) {
            if (i > matrix.size()) {
                matrix.add(new ArrayList<>());
            }
            matrix.get(i-1).add(num);
        }
    }

    public List<List<Integer>> findMatrix2(int[] nums) {
        List<List<Integer>> matrix = new ArrayList<>();
        Arrays.sort(nums);
        int prev = 0, row = 1;
        for (int num : nums) {
            if (num == prev) {
                row++;
            } else {
                row = 1;
            }
            insertIntoMatrix(num, matrix, row);
            prev = num;
        }
        return matrix;
    }

    private void insertIntoMatrix(int num, List<List<Integer>> matrix, int row) {
        if (row > matrix.size()) {
            matrix.add(new ArrayList<>());
        }
        matrix.get(row - 1).add(num);
    }
}
