package com.ss.leetcode.september;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    // https://leetcode.com/problems/pascals-triangle/
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            return List.of(List.of(1));
        } else if (numRows == 2) {
            return List.of(List.of(1), List.of(1, 1));
        }
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(List.of(1));
        answer.add(List.of(1, 1));
        for (int i = 2; i < numRows; i++) {
            answer.add(generateList(answer.get(i - 1)));
        }
        return answer;
    }

    private List<Integer> generateList(List<Integer> integers) {
        List<Integer> generated = new ArrayList<>(integers.size() + 1);
        generated.add(1);
        for (int i = 1; i < integers.size(); i++) {
            generated.add(integers.get(i - 1) + integers.get(i));
        }
        generated.add(1);
        return generated;
    }
}
