package com.ss.leetcode.LC2022.june;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    // https://leetcode.com/problems/triangle/
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        List<Integer> mins = triangle.get(triangle.size() -1);
        List<Integer> newMins;
        for (int i = triangle.size() -2; i >= 0; i--) {
            newMins = new ArrayList<>(triangle.get(i).size());
            for (int j = 0; j < triangle.get(i).size(); j++) {
                newMins.add(triangle.get(i).get(j) + Math.min(mins.get(j), mins.get(j+1)));
            }
            mins = newMins;
        }
        return mins.get(0);
    }
}
