package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.february.CountVowelSubstringsOfAString;
import com.ss.leetcode.LC2024.february.DivideArrayIntoArraysWithMaxDifference;
import com.ss.leetcode.LC2024.february.MaximumConsecutiveFloorsWithoutSpecialFloors;
import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

//        start.divideArrayIntoArraysWithMaxDifference();
        start.maximumConsecutiveFloorsWithoutSpecialFloors();
        start.countVowelSubstringsOfAString();
    }

    public void divideArrayIntoArraysWithMaxDifference() {
        DivideArrayIntoArraysWithMaxDifference daiawmd = new DivideArrayIntoArraysWithMaxDifference();

        System.out.println("[[1,1,3],[3,4,5],[7,8,9]] == " + Arrays.deepToString(daiawmd.divideArray(new int[]{1,3,4,8,7,9,3,5,1}, 2)));
        System.out.println("[] == " + Arrays.deepToString(daiawmd.divideArray(new int[]{1,3,3,2,7,3}, 3)));
    }

    public void maximumConsecutiveFloorsWithoutSpecialFloors() {
        MaximumConsecutiveFloorsWithoutSpecialFloors mcfwsf = new MaximumConsecutiveFloorsWithoutSpecialFloors();

        System.out.println("3 == " + mcfwsf.maxConsecutive(2, 2, new int[]{4,6}));
        System.out.println("0 == " + mcfwsf.maxConsecutive(6, 8, new int[]{7,6,8}));
    }

    public void countVowelSubstringsOfAString() {
        CountVowelSubstringsOfAString cvsoas = new CountVowelSubstringsOfAString();

        System.out.println("2 == " + cvsoas.countVowelSubstrings("aeiouu"));
        System.out.println("0 == " + cvsoas.countVowelSubstrings("unicornarihan"));
        System.out.println("7 == " + cvsoas.countVowelSubstrings("cuaieuouac"));
    }
}
