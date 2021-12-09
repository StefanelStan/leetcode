package com.ss.leetcode.LC2021.december;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class JumpGameIII {
    // https://leetcode.com/problems/jump-game-iii/
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        boolean[] reached = {false};
        jump(arr, new boolean[50001], start, reached);
        return reached[0];
    }

    private void jump(int[] arr, boolean[] usedPaths, int position, boolean[] reached) {
        if (reached[0] || usedPaths[position]) {
            return;
        }
        if (arr[position] == 0) {
            reached[0] = true;
            return;
        }
        int leftPosition = position - arr[position];
        int rightPosition = position + arr[position];
        usedPaths[position] = true;
        if (leftPosition >= 0 && !usedPaths[leftPosition]) {
            jump(arr, usedPaths, leftPosition, reached);
        }
        if (!reached[0] && rightPosition < arr.length && !usedPaths[rightPosition]) {
            jump(arr, usedPaths, rightPosition, reached);
        }
    }
}
