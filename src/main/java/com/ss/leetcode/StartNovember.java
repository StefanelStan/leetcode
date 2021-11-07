package com.ss.leetcode;

import com.ss.leetcode.november.ArrangingCoins;
import com.ss.leetcode.november.BinaryTreePaths;
import com.ss.leetcode.november.BinaryTreeRightSideView;
import com.ss.leetcode.november.ConsecutiveCharacters;
import com.ss.leetcode.november.DeleteNodeInABST;
import com.ss.leetcode.november.InsufficientNodesInRootToLeafPaths;
import com.ss.leetcode.november.KClosestPointsToOrigin;
import com.ss.leetcode.november.KthDistinctStringOnAnArray;
import com.ss.leetcode.november.MultiplyStrings;
import com.ss.leetcode.november.NumberValidWordsSentence;
import com.ss.leetcode.november.SingleNumberIII;
import com.ss.leetcode.november.SumOfAbsoluteDiffSortedArray;
import com.ss.leetcode.november.SurroundedRegions;
import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

//        start.surroundedRegions();
//        start.binaryTreePaths();
//        start.deleteNodeInABST();
//        start.kthDistinctStringOnAnArray();
//        start.kClosestPointsToOrigin();
//        start.sumOfAbsoluteDiffSortedArray();
//        start.binaryTreeRightSideView();
//        start.insufficientNodesInRootToLeafPaths();
//        start.arrangingCoins();
//        start.consecutiveCharacters();
//        start.numberValidWordsSentence();
//        start.singleNumberIII();
        start.multiplyStrings();
    }

    public void surroundedRegions() {
        SurroundedRegions sr = new SurroundedRegions();

        char[][] board1 = {{'X','X','X','X'}, {'X','O','O','X'},{'X','X','O','X'}, {'X','X','X','X'}};
        char[][] board2 = {{'O','O','O','O','X','X'}, {'O','O','O','O','O','O'}, {'O','X','O','X','O','O'},
            {'O','X','O','O','X','O'}, {'O','X','O','X','O','O'}, {'O','X','O','O','O','O'}};
        char[][] board3 = {{'X','O','X','O','O','O','O'}, {'X','O','O','O','O','O','O'}, {'X','O','O','O','O','X','O'},
            {'O','O','O','O','X','O','X'}, {'X','O','O','O','O','O','O'}, {'O','O','O','O','O','O','O'}, {'O','X','O','O','O','O','O'}};

        sr.solve(board1);
        sr.solve(board2);
        sr.solve(board3);
        System.out.println("[[X,X,X,X],[X,X,X,X],[X,O,X,X]] == " + Arrays.deepToString(board1));
        System.out.println("[[O,O,O,O,X,X],[O,O,O,O,O,O],[O,X,O,X,O,O],[O,X,O,O,X,O],[O,X,O,X,O,O], [O,X,O,O,O,O]] == " + Arrays.deepToString(board2));
        System.out.println("[[X,O,X,O,O,O,O],[X,O,O,O,O,O,O],[X,O,O,O,O,X,O], [O,O,O,O,X,O,X],[O,X,O,O,O,O,O],[O,O,O,O,O,O,O],[O,X,O,O,O,O,O]] == " + Arrays.deepToString(board3));

    }

    public void binaryTreePaths() {
        BinaryTreePaths btp = new BinaryTreePaths();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        TreeNode root2 = new TreeNode(1);

        System.out.println("[1->2->5, 1->3] == " + btp.binaryTreePaths(root1));
        System.out.println("[1] == " + btp.binaryTreePaths(root2));
    }

    public void deleteNodeInABST() {
        DeleteNodeInABST dniabst = new DeleteNodeInABST();

        TreeNode root1 = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        TreeNode root2 = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(3, new TreeNode(2), new TreeNode(5, new TreeNode(4), new TreeNode(10, new TreeNode(8, new TreeNode(7), null), new TreeNode(15))));
        TreeNode root5 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));

//        System.out.println("[5,4,6,2,7] == " + TreeNode.extractValues(dniabst.deleteNode(root1, 3)));
//        System.out.println("[5,3,6,2,4,7] == " + TreeNode.extractValues(dniabst.deleteNode(root2, 0)));
//        System.out.println("[] == " + TreeNode.extractValues(dniabst.deleteNode(root3, 0)));
//        System.out.println("[6,3,7,2,4] == " + TreeNode.extractValues(dniabst.deleteNode(root1, 5)));
//        System.out.println("[3,2,7,4,10,8,15] == " + TreeNode.extractValues(dniabst.deleteNode(root4, 5)));
        System.out.println("[3,1,4] == " + TreeNode.extractValues(dniabst.deleteNode(root5, 2)));
    }

    public void kthDistinctStringOnAnArray() {
        KthDistinctStringOnAnArray kdsoaa = new KthDistinctStringOnAnArray();

        System.out.println("a == " + kdsoaa.kthDistinct(new String[]{"d","b","c","b","c","a"}, 2));
        System.out.println("aaa == " + kdsoaa.kthDistinct(new String[]{"aaa","aa","a"}, 1));
        System.out.println(" == " + kdsoaa.kthDistinct(new String[]{"a","b","a"}, 1));
    }

    public void kClosestPointsToOrigin() {
        KClosestPointsToOrigin kcpto = new KClosestPointsToOrigin();

        System.out.println("[[-2,2]] == " + Arrays.deepToString(kcpto.kClosest(new int[][]{{1,3}, {-2, 2}}, 1)));
        System.out.println("[[3,3],[-2,4]] == " + Arrays.deepToString(kcpto.kClosest(new int[][]{{3,3}, {5, -1},{-2, 4}}, 2)));
    }

    public void sumOfAbsoluteDiffSortedArray() {
        SumOfAbsoluteDiffSortedArray soadsa = new SumOfAbsoluteDiffSortedArray();

        System.out.println("[4,3,5] == " + Arrays.toString(soadsa.getSumAbsoluteDifferences(new int[]{2,3,5})));
        System.out.println("[24,15,13,15,21] == " + Arrays.toString(soadsa.getSumAbsoluteDifferences(new int[]{1,4,6,8,10})));
    }

    public void binaryTreeRightSideView() {
        BinaryTreeRightSideView btrsw = new BinaryTreeRightSideView();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        TreeNode root2 = new TreeNode(1, null, new TreeNode(3));

        System.out.println("[1,3,4] == " + btrsw.rightSideView(root1));
        System.out.println("[1,3] == " + btrsw.rightSideView(root2));
        System.out.println("[] == " + btrsw.rightSideView(null));
    }

    public void insufficientNodesInRootToLeafPaths() {
        InsufficientNodesInRootToLeafPaths inirtlp = new InsufficientNodesInRootToLeafPaths();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), new TreeNode(-99, new TreeNode(-99), new TreeNode(-99))),
            new TreeNode(3, new TreeNode(-99, new TreeNode(12), new TreeNode(13)), new TreeNode(7, new TreeNode(-99), new TreeNode(14))));
        TreeNode root2 = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(1)), null),
            new TreeNode(8, new TreeNode(17), new TreeNode(4, new TreeNode(5), new TreeNode(3))));
        TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(-5), null), new TreeNode(-3, new TreeNode(4), null));

        System.out.println("[1,2,3,4,7,8,9,14] == " + TreeNode.extractValues(inirtlp.sufficientSubset(root1, 1)));
        System.out.println("[5,4,8,11,17,4,7,5] == " + TreeNode.extractValues(inirtlp.sufficientSubset(root2, 22)));
        System.out.println("[1,-3,4] == " + TreeNode.extractValues(inirtlp.sufficientSubset(root3, -1)));
    }

    public void arrangingCoins() {
        ArrangingCoins ac = new ArrangingCoins();

        System.out.println("2 == " + ac.arrangeCoins(5));
        System.out.println("3 == " + ac.arrangeCoins(8));
    }

    public void consecutiveCharacters() {
        ConsecutiveCharacters cc = new ConsecutiveCharacters();

        System.out.println("2 == " + cc.maxPower("leetcode"));
        System.out.println("5 == " + cc.maxPower("abbcccddddeeeeedcba"));
        System.out.println("5 == " + cc.maxPower("triplepillooooow"));
        System.out.println("11 == " + cc.maxPower("hooraaaaaaaaaaay"));
        System.out.println("1 == " + cc.maxPower("tourist"));
    }

    public void numberValidWordsSentence() {
        NumberValidWordsSentence nvws = new NumberValidWordsSentence();

        System.out.println("3 == " + nvws.countValidWords("cat and  dog"));
        System.out.println("0 == " + nvws.countValidWords("!this  1-s b8d!"));
        System.out.println("5 == " + nvws.countValidWords("alice and  bob are playing stone-game10"));
        System.out.println("6 == " + nvws.countValidWords( "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }

    public void singleNumberIII() {
        SingleNumberIII sniii = new SingleNumberIII();

        System.out.println("[3,5] == " + Arrays.toString(sniii.singleNumber(new int[]{1,2,1,3,2,5})));
        System.out.println("[-1, 0] == " + Arrays.toString(sniii.singleNumber(new int[]{-1,0})));
        System.out.println("[0,1] == " + Arrays.toString(sniii.singleNumber(new int[]{0,1})));
    }

    public void multiplyStrings() {
        MultiplyStrings ms = new MultiplyStrings();

        System.out.println("6 == " + ms.multiply("2", "3"));
        System.out.println("56008 == " + ms.multiply("123", "456"));
        System.out.println("998001 == " + ms.multiply("999", "999"));
        System.out.println("5796 == " + ms.multiply("23", "252"));
        System.out.println("0 == " + ms.multiply("0", "351"));
    }
}

