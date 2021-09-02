package com.ss.leetcode;

import com.ss.leetcode.september.ArrayNesting;
import com.ss.leetcode.september.DeleteNodesAndReturnForest;
import com.ss.leetcode.september.MinimumCostToMoveChips;
import com.ss.leetcode.september.PopulatingNextRightPointers;
import com.ss.leetcode.september.ReverseBits;
import com.ss.leetcode.september.SingleNumber;
import com.ss.leetcode.september.UniqueBinarySearchTreesII;
import com.ss.leetcode.shared.TreeNode;

import java.util.List;

public class StartSeptember {

    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();
//        start.arrayNesting();
//        start.populatingNextRightPointers();
//        start.singleNumber();
//        start.reverseBits();
//        start.minimumCostToMoveChips();
//        start.uniqueBinarySearchTreesII();
        start.deleteNodesAndReturnForest();
    }

    public void arrayNesting() {
        ArrayNesting an = new ArrayNesting();

        System.out.println("4 == " + an.arrayNesting(new int[]{5,4,0,3,1,6,2}));
        System.out.println("1 == " + an.arrayNesting(new int[]{0,1,2}));
    }

    public void populatingNextRightPointers() {
        PopulatingNextRightPointers pnrp = new PopulatingNextRightPointers();

        PopulatingNextRightPointers.Node root1 = new PopulatingNextRightPointers.Node(1,
            new PopulatingNextRightPointers.Node(2, new PopulatingNextRightPointers.Node(4), new PopulatingNextRightPointers.Node(5)),
            new PopulatingNextRightPointers.Node(3, new PopulatingNextRightPointers.Node(6), new PopulatingNextRightPointers.Node(7)));

        PopulatingNextRightPointers.Node root2 = null;

        pnrp.connect(root1);
        pnrp.connect(root2);

        System.out.println("true == " + (root1.left.next == root1.right));
        System.out.println("null == " + root2);
    }

    public void singleNumber() {
        SingleNumber sn = new SingleNumber();

        System.out.println("1 == " + sn.singleNumber(new int[]{2,2,1}));
        System.out.println("4 == " + sn.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println("1 == " + sn.singleNumber(new int[]{1}));
    }

    public void reverseBits() {
        ReverseBits rb = new ReverseBits();

        System.out.println("964176192 == " + rb.reverseBits(Integer.parseUnsignedInt("00000010100101000001111010011100", 2)));
        System.out.println("-1073741825 == " + rb.reverseBits(Integer.parseUnsignedInt("11111111111111111111111111111101", 2)));

    }

    public void minimumCostToMoveChips() {
        MinimumCostToMoveChips mctmc = new MinimumCostToMoveChips();

        System.out.println("1 == " + mctmc.minCostToMoveChips(new int[]{1,2,3}));
        System.out.println("2 == " + mctmc.minCostToMoveChips(new int[]{2,2,2,3,3}));
        System.out.println("1 == " + mctmc.minCostToMoveChips(new int[]{1,1000000000}));
    }

    public void uniqueBinarySearchTreesII() {
        UniqueBinarySearchTreesII ubstii = new UniqueBinarySearchTreesII();

        System.out.println("5 == " + ubstii.generateTrees(3).size());
        System.out.println("1 == " + ubstii.generateTrees(1).size());
    }

    public void deleteNodesAndReturnForest() {
        DeleteNodesAndReturnForest dnarf = new DeleteNodesAndReturnForest();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(4));
        TreeNode root3 = new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4)));

        StringBuilder stb = new StringBuilder();
        StringBuilder stb2 = new StringBuilder();
        StringBuilder stb3 = new StringBuilder();
        dnarf.delNodes(root1, new int[]{3,5}).forEach(head -> stb.append(TreeNode.extractValues(head)));
        dnarf.delNodes(root2, new int[]{3}).forEach(head -> stb2.append(TreeNode.extractValues(head)));
        dnarf.delNodes(root3, new int[]{2,1}).forEach(head -> stb3.append(TreeNode.extractValues(head)));

        System.out.println("[[1,2,4],[6],[7]] == " + stb);
        System.out.println("[[1,2,4]] == " + stb2);
        System.out.println("[[3,4]] == " + stb3);
    }
}
