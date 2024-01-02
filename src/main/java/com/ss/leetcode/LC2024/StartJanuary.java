package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.january.ReplaceElementsInAnArray;
import java.util.Arrays;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

        start.replaceElementsInAnArray();
    }

    public void replaceElementsInAnArray() {
        ReplaceElementsInAnArray reiaa = new ReplaceElementsInAnArray();

        System.out.println("[3,2,7,1] == " + Arrays.toString(reiaa.arrayChange(new int[]{1,2,4,6}, new int[][]{{1,3},{4,7},{6,1}})));
        System.out.println("[2,1] == " + Arrays.toString(reiaa.arrayChange(new int[]{1,2}, new int[][]{{1,3},{2,1},{3,2}})));
    }
}
