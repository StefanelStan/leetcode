package com.ss.leetcode;

import com.ss.leetcode.august.AddStrings;
import com.ss.leetcode.august.MakeTwoArraysEqual;
import com.ss.leetcode.august.MakingALargeIsland;
import com.ss.leetcode.august.MergeTwoBinaryTrees;
import com.ss.leetcode.august.PlusOne;
import com.ss.leetcode.august.SumRootToLeaf;
import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;


public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

//        start.makingALargeIsland();
//        start.plusOne();
//        start.makeTwoArraysEqual();
//        start.sumRootToLeaf();
//        start.mergeTwoBinaryTrees();
        start.addStrings();
    }

    public void makingALargeIsland() {

        MakingALargeIsland mali = new MakingALargeIsland();

        System.out.println("29 == " + mali.largestIsland(new int[][]{{1,0,0,0,0,0,0,0},{1,1,1,1,0,0,0,1},{1,0,0,0,1,1,1,0},
                                                        {1,1,1,0,1,0,0,1},{1,0,1,1,0,1,1,0},{0,0,1,0,1,0,0,0},{1,1,1,1,1,0,1,0},{1,0,1,1,0,1,0,1}}));
        System.out.println("12 == " + mali.largestIsland(new int[][]{{1,0,1,1,0},{1,0,0,0,0},{0,1,0,0,1},{1,1,0,1,1},{0,1,1,1,0}}));
        System.out.println("15 == " + mali.largestIsland(new int[][]{{1,0,1,0,1},{0,1,1,0,1},{1,1,1,0,0},{1,0,1,1,1},{0,0,1,1,0}}));
        System.out.println("18 == " + mali.largestIsland(new int[][]{{0,0,0,0,0,0,0},{0,1,1,1,1,0,0},{0,1,0,0,1,0,0},
                                                        {1,0,1,0,1,0,0},{0,1,0,0,1,0,0},{0,1,0,0,1,0,0},{0,1,1,1,1,0,0}}));
        System.out.println("3 == " + mali.largestIsland(new int[][]{{1,0},{0,1}}));
        System.out.println("4 == " + mali.largestIsland(new int[][]{{1,1},{0,1}}));
        System.out.println("4 == " + mali.largestIsland(new int[][]{{1,1},{1,1}}));
    }

    public void plusOne() {
        PlusOne po = new PlusOne();

        System.out.println("[1,2,4] == " + Arrays.toString(po.plusOne(new int[]{1,2,3})));
        System.out.println("[4,3,2,2] == " + Arrays.toString(po.plusOne(new int[]{4,3,2,1})));
        System.out.println("[1] == " + Arrays.toString(po.plusOne(new int[]{0})));
    }

    public void makeTwoArraysEqual() {
        MakeTwoArraysEqual mtae = new MakeTwoArraysEqual();

        System.out.println("true == " + mtae.canBeEqual(new int[]{1,2,3,4}, new int[]{2,4,1,3}));
        System.out.println("true == " + mtae.canBeEqual(new int[]{7}, new int[]{7}));
        System.out.println("true == " + mtae.canBeEqual(new int[]{1,12}, new int[]{12,1}));
        System.out.println("false == " + mtae.canBeEqual(new int[]{3,7,9}, new int[]{3,7,11}));
        System.out.println("true == " + mtae.canBeEqual(new int[]{1,1,1,1,1}, new int[]{1,1,1,1,1}));
    }

    public void sumRootToLeaf() {
        SumRootToLeaf srtf = new SumRootToLeaf();

        TreeNode root1 = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        TreeNode root2 = new TreeNode(1, null,  new TreeNode(1));

        System.out.println("22 == " + srtf.sumRootToLeaf(root1));
        System.out.println("0 == " + srtf.sumRootToLeaf(new TreeNode(0)));
        System.out.println("1 == " + srtf.sumRootToLeaf(new TreeNode(1)));
        System.out.println("3 == " + srtf.sumRootToLeaf(root2));


    }

    public void mergeTwoBinaryTrees() {
        MergeTwoBinaryTrees mtbt = new MergeTwoBinaryTrees();

        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5),null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(1, null, new TreeNode(2));
        TreeNode root5 = null;

        System.out.println("3 == " + mtbt.mergeTrees(root1, root2).val);
        System.out.println("2 == " + mtbt.mergeTrees(root3, root4).val);
        System.out.println("1 == " + mtbt.mergeTrees(root3, root5).val);

    }

    public void addStrings() {
        AddStrings as = new AddStrings();

        System.out.println("108 == " + as.addStrings("9" , "99"));
        System.out.println("134 == " + as.addStrings("11" , "123"));
        System.out.println("103 == " + as.addStrings("55" , "48"));
        System.out.println("533 == " + as.addStrings("456" , "77"));
        System.out.println("0 == " + as.addStrings("0" , "0"));
    }
}
