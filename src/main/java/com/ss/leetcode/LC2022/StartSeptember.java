package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.september.AmountOfTimeForBinaryTreeToBeInfected;
import com.ss.leetcode.shared.TreeNode;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

        start.amountOfTimeForBinaryTreeToBeInfected();
    }

    public void amountOfTimeForBinaryTreeToBeInfected() {
        AmountOfTimeForBinaryTreeToBeInfected aotfbttbi = new AmountOfTimeForBinaryTreeToBeInfected();

        TreeNode root1 = new TreeNode(1, new TreeNode(5, null, new TreeNode(4, new TreeNode(9), new TreeNode(2))),
            new TreeNode(3, new TreeNode(10), new TreeNode(6)));
        TreeNode root2 = new TreeNode(1);

        System.out.println("4 == " + aotfbttbi.amountOfTime(root1, 3));
        System.out.println("0 == " + aotfbttbi.amountOfTime(root2, 1));

    }
}
