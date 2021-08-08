package com.ss.leetcode;

import com.ss.leetcode.august.AddBinary;
import com.ss.leetcode.august.AddStrings;
import com.ss.leetcode.august.DeleteCharsFancyString;
import com.ss.leetcode.august.DetermineColorChessboardSquare;
import com.ss.leetcode.august.FindLuckyIntegerInAnArray;
import com.ss.leetcode.august.GameOfLife;
import com.ss.leetcode.august.IncreasingOrderSearchTree;
import com.ss.leetcode.august.LargestTriangleArea;
import com.ss.leetcode.august.LengthOfLastWord;
import com.ss.leetcode.august.LongestContinuousIncSubs;
import com.ss.leetcode.august.MakeTwoArraysEqual;
import com.ss.leetcode.august.MakingALargeIsland;
import com.ss.leetcode.august.MergeTwoBinaryTrees;
import com.ss.leetcode.august.MinOperationsToMakeArrayEqual;
import com.ss.leetcode.august.NaryTreeLevelOrderTraversal;
import com.ss.leetcode.august.PalindromePartitioningII;
import com.ss.leetcode.august.PathSum;
import com.ss.leetcode.august.PathSumII;
import com.ss.leetcode.august.PlusOne;
import com.ss.leetcode.august.ReverseWordsInAStringIII;
import com.ss.leetcode.august.SetMatrixZeroes;
import com.ss.leetcode.august.SmallestStringStartingFromLeaf;
import com.ss.leetcode.august.SortArrayByParity;
import com.ss.leetcode.august.StoneGame;
import com.ss.leetcode.august.Subsets;
import com.ss.leetcode.august.SubsetsII;
import com.ss.leetcode.august.SumOfLeftLeaves;
import com.ss.leetcode.august.SumRootToLeaf;
import com.ss.leetcode.shared.Node;
import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;
import java.util.List;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

//        start.makingALargeIsland();
//        start.plusOne();
//        start.makeTwoArraysEqual();
//        start.sumRootToLeaf();
//        start.mergeTwoBinaryTrees();
//        start.addStrings();
//        start.subsets();
//        start.subsetsII();
//        start.sortArrayByParity();
//        start.increasingOrderSearchTree();
//        start.reverseWordsInAStringIII();
//        start.pathSumII();
//        start.sumOfLeftLeaves();
//        start.pathSum();
//        start.stoneGame();
//        start.lengthOfLastWord();
//        start.addBinary();
//        start.minOperationsToMakeArrayEqual();
//        start.naryTreeLevelOrderTraversal();
//        start.deleteCharactersToMakeFancyString();
//        start.palindromePartitioningII();
//        start.determineColorChessboardSquare();
//        start.longestContinuousIncreasingSubsequence();
//        start.findLuckyIntegerInAnArray();
//        start.largestTriangleArea();
//        start.gameOfLife();
//        start.setMatrixZeroes();
        start.smallestStringStartingFromLeaf();
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

    public void subsets() {
        Subsets s = new Subsets();

        System.out.println("[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]] == " + s.subsets(new int[]{1,2,3,4}));
    }

    public void subsetsII() {
        SubsetsII s = new SubsetsII();

        System.out.println("[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]] == " + s.subsetsWithDup(new int[]{1,2,3}));
    }

    public void sortArrayByParity() {
        SortArrayByParity sobp = new SortArrayByParity();

        System.out.println("[4,2,3,1] == " + Arrays.toString(sobp.sortArrayByParity(new int[]{3,1,2,4})));
    }

    public void increasingOrderSearchTree() {
        IncreasingOrderSearchTree iost = new IncreasingOrderSearchTree();
        TreeNode root1 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
                                      new TreeNode(6, null, new TreeNode(8, new TreeNode(7), new TreeNode(9))));
        TreeNode root2 = new TreeNode(5, new TreeNode(1), new TreeNode(7));

        System.out.println("1 == " + iost.increasingBST(root1).val);
        System.out.println("1 == " + iost.increasingBST(root2).val);
    }

    public void reverseWordsInAStringIII() {
        ReverseWordsInAStringIII rwias = new ReverseWordsInAStringIII();

        System.out.println("s'teL ekat edoCteeL tsetnoc == [" + rwias.reverseWords("Let's take LeetCode contest") + "]");
        System.out.println("doG gniD == [" + rwias.reverseWords("God Ding") + "]");
        System.out.println("ehhhhhheh == [" + rwias.reverseWords("hehhhhhhe") + "]");
    }

    public void pathSumII() {
        PathSumII psII = new PathSumII();

        TreeNode root1 = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                                      new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));

        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root3 = new TreeNode(1, null, new TreeNode(2));

        System.out.println("[[5,4,11,2],[5,8,4,5]] == " + psII.pathSum(root1, 22));
        System.out.println("[] == " + psII.pathSum(root2, 5));
        System.out.println("[] == " + psII.pathSum(root3, 0));

    }

    public void sumOfLeftLeaves() {
        SumOfLeftLeaves soll = new SumOfLeftLeaves();

        TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1);

        System.out.println("24 == " + soll.sumOfLeftLeaves(root1));
        System.out.println("0 == " + soll.sumOfLeftLeaves(root2));
    }

    public void pathSum() {
        PathSum ps = new PathSum();

        TreeNode root1 = new TreeNode(5, new TreeNode(4,new TreeNode(11, new TreeNode(7), new TreeNode(2)),null),
                                     new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root3 = new TreeNode(1, null, new TreeNode(2));

        System.out.println("true == " + ps.hasPathSum(root1, 22));
        System.out.println("false == " + ps.hasPathSum(root2, 5));
        System.out.println("false == " + ps.hasPathSum(root1, 0));
    }

    public void stoneGame() {
        StoneGame sg = new StoneGame();

        System.out.println("true == " + sg.stoneGame(new int[]{5,3,4,5}));
    }

    public void lengthOfLastWord() {
        LengthOfLastWord lolw = new LengthOfLastWord();

        System.out.println("5 == " + lolw.lengthOfLastWord("Hello World"));
        System.out.println("4 == " + lolw.lengthOfLastWord("   fly me   to  the moon  "));
        System.out.println("6 == " + lolw.lengthOfLastWord("luffy is still joyboy"));
    }

    public void addBinary() {
        AddBinary ab = new AddBinary();

        System.out.println("100 == " + ab.addBinary("11", "1"));
        System.out.println("10101 == " + ab.addBinary("1010", "1011"));
    }

    public void minOperationsToMakeArrayEqual() {
        MinOperationsToMakeArrayEqual motmae = new MinOperationsToMakeArrayEqual();

        System.out.println("2 == " + motmae.minOperations(3));
        System.out.println("9 == " + motmae.minOperations(6));
        System.out.println("20 == " + motmae.minOperations(7));
        System.out.println("36 == " + motmae.minOperations(9));
    }

    public void naryTreeLevelOrderTraversal() {
        NaryTreeLevelOrderTraversal ntlot = new NaryTreeLevelOrderTraversal();

        Node root1 = new Node(1, List.of(new Node(3, List.of(new Node(5), new Node(6))), new Node(2), new Node(4)));
        Node root2 = new Node(1, List.of(
            new Node(2),
            new Node(2, List.of(new Node(6), new Node(7, List.of(new Node(11, List.of(new Node(14))))))),
            new Node(4, List.of(new Node(8, List.of(new Node(12))))),
            new Node(5, List.of(new Node(9, List.of(new Node(13))), new Node(10)))
        ));

        System.out.println("[[1],[3,2,4],[5,6]] == " + ntlot.levelOrder(root1));
        System.out.println("[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]] == " + ntlot.levelOrder(root2));
    }

    public void deleteCharactersToMakeFancyString() {
        DeleteCharsFancyString dcfs = new DeleteCharsFancyString();

        System.out.println("leetcode == " + dcfs.makeFancyString("leeetcode"));
        System.out.println("aabaa == " + dcfs.makeFancyString("aaabaaaa"));
        System.out.println("aab == " + dcfs.makeFancyString("aab"));
        System.out.println("aax == " + dcfs.makeFancyString("aaax"));
    }

    public void palindromePartitioningII() {
        PalindromePartitioningII ppii = new PalindromePartitioningII();

        System.out.println("3 == " + ppii.minCut("aabacd"));
        System.out.println("1 == " + ppii.minCut("aab"));
        System.out.println("0 == " + ppii.minCut("a"));
        System.out.println("1 == " + ppii.minCut("ab"));
    }

    public void determineColorChessboardSquare() {
        DetermineColorChessboardSquare dccs = new DetermineColorChessboardSquare();

        System.out.println("false == " + dccs.squareIsWhite("a1"));
        System.out.println("true == " + dccs.squareIsWhite("h3"));
        System.out.println("false == " + dccs.squareIsWhite("c7"));
    }

    public void longestContinuousIncreasingSubsequence() {
        LongestContinuousIncSubs lcis = new LongestContinuousIncSubs();

        System.out.println(("3 == " + lcis.findLengthOfLCIS(new int[]{1,3,5,4,7})));
        System.out.println(("1 == " + lcis.findLengthOfLCIS(new int[]{2,2,2,2,2})));
    }

    public void findLuckyIntegerInAnArray() {
        FindLuckyIntegerInAnArray fliiaa = new FindLuckyIntegerInAnArray();

        System.out.println("2 == " +fliiaa.findLucky(new int[]{2,2,3,4}));
        System.out.println("3 == " +fliiaa.findLucky(new int[]{1,2,2,3,3,3}));
        System.out.println("-1 == " +fliiaa.findLucky(new int[]{2,2,2,3,3}));
        System.out.println("-1 == " +fliiaa.findLucky(new int[]{5}));
    }

    public void largestTriangleArea() {
        LargestTriangleArea lta = new LargestTriangleArea();

        System.out.println("2.00000 == " + lta.largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}}));
        System.out.println("0.50000 == " + lta.largestTriangleArea(new int[][]{{1,0},{0,0},{0,1}}));
    }

    public void gameOfLife() {
        GameOfLife gof = new GameOfLife();

        int[][] board1 = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        int[][] board2 = {{1,1}, {1,0}};
        gof.gameOfLife(board1);
        gof.gameOfLife(board2);
        System.out.println("[[0,0,0],[1,0,1],[0,1,1],[0,1,0]] == " + Arrays.deepToString(board1));
        System.out.println("[[1,1],[1,1]] == " + Arrays.deepToString(board2));
    }

    public void setMatrixZeroes() {
        SetMatrixZeroes smz = new SetMatrixZeroes();

        int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        smz.setZeroes(matrix1);
        smz.setZeroes(matrix2);
        System.out.println("[[1,0,1],[0,0,0],[1,0,1]] == " + Arrays.deepToString(matrix1));
        System.out.println("[[0,0,0,0],[0,4,5,0],[0,3,1,0]] == " + Arrays.deepToString(matrix2));
    }

    public void smallestStringStartingFromLeaf() {
        SmallestStringStartingFromLeaf sssfl = new SmallestStringStartingFromLeaf();

        TreeNode root1 = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(3), new TreeNode(4)));
        TreeNode root2 = new TreeNode(25, new TreeNode(1, new TreeNode(1),new TreeNode(3)), new TreeNode(3, new TreeNode(0), new TreeNode(2)));
        TreeNode root3 = new TreeNode(2, new TreeNode(2, null, new TreeNode(1, new TreeNode(0), null)), new TreeNode(1, new TreeNode(0), null));

        System.out.println("dba == " + sssfl.smallestFromLeaf(root1));
        System.out.println("adz == " + sssfl.smallestFromLeaf(root2));
        System.out.println("abc == " + sssfl.smallestFromLeaf(root3));
    }
}
