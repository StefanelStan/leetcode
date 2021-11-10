package com.ss.leetcode.november;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray {
    // https://leetcode.com/problems/rank-transform-of-an-array/
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int[] answer = new int[arr.length];
        System.arraycopy(arr, 0, answer, 0, answer.length);
        Arrays.sort(answer);
        int index = 1;
        for (int val : answer) {
            if (numMap.putIfAbsent(val, index) == null) {
                index++;
            }
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = numMap.get(arr[i]);
        }
        return answer;
    }
}