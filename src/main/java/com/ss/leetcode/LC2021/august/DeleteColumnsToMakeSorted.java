package com.ss.leetcode.LC2021.august;

public class DeleteColumnsToMakeSorted {
    // https://leetcode.com/problems/delete-columns-to-make-sorted/
    public int minDeletionSize(String[] strs) {
        int deletedColumns = 0;
        for (int j = 0; j < strs[0].length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i-1].charAt(j) > strs[i].charAt(j)) {
                    deletedColumns++;
                    break;
                }
            }
        }
        return deletedColumns;
    }
}
