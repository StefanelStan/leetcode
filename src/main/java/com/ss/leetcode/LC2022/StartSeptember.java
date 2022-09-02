package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.september.AmountOfTimeForBinaryTreeToBeInfected;
import com.ss.leetcode.LC2022.september.LongestSubsequenceWithLimitedSum;
import com.ss.leetcode.shared.TreeNode;
import java.util.Arrays;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

//        start.amountOfTimeForBinaryTreeToBeInfected();
        start.longestSubsequenceWithLimitedSum();
    }

    public void amountOfTimeForBinaryTreeToBeInfected() {
        AmountOfTimeForBinaryTreeToBeInfected aotfbttbi = new AmountOfTimeForBinaryTreeToBeInfected();

        TreeNode root1 = new TreeNode(1, new TreeNode(5, null, new TreeNode(4, new TreeNode(9), new TreeNode(2))),
            new TreeNode(3, new TreeNode(10), new TreeNode(6)));
        TreeNode root2 = new TreeNode(1);

        System.out.println("4 == " + aotfbttbi.amountOfTime(root1, 3));
        System.out.println("0 == " + aotfbttbi.amountOfTime(root2, 1));
    }

    public void longestSubsequenceWithLimitedSum() {
        LongestSubsequenceWithLimitedSum lswls = new LongestSubsequenceWithLimitedSum();

//        System.out.println("[2,3,4] == " + Arrays.toString(lswls.answerQueries(new int[]{4,5,2,1}, new int[]{3,10,21})));
//        System.out.println("[0] == " + Arrays.toString(lswls.answerQueries(new int[]{2,3,4,5}, new int[]{1})));
//        System.out.println("[2,2,1,1,2,3,3] == " + Arrays.toString(lswls.answerQueries(new int[]{736411,184882,914641,37925,214915}, new int[]{331244,273144,118983,118252,305688,718089,665450})));
//        System.out.println("[0,2,0,1,2] == " + Arrays.toString(lswls.answerQueries(new int[]{76478,102343,247573,477461,430399,260435,250631,785081,904724,392720}, new int[]{63736,339518,37262,108251,216825})));
        System.out.println("[0,2,0,1,2] == " + Arrays.toString(lswls.answerQueries(new int[]{573210,20594,196301}, new int[]{880897,461149,301768,510087,572628,544429,141852,870779,156572})));
//        System.out.println("[7,17,22,11,7,1,2,3,4,11,11,11,8,8,11,11,11,13,16,17] == " +
//            Arrays.toString(lswls.answerQueries(new int[]{4,2,1,1,3,4,5,4,3,2,1,2,3,4,4,3,2,1,3,4,5,6},
//                new int[]{11,45,98,23,11,1,2,3,4,22,22,21,12,12,21,22,23,30,40,45})));
    }
}
