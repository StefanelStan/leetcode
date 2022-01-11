package com.ss.leetcode.LC2021;

import com.ss.leetcode.LC2021.august.*;
import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.Node;
import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
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
//        start.smallestStringStartingFromLeaf();
//        start.maximumUnitsOnATruck();
//        start.sumOfUniqueElements();
//        start.frequencyOfMostFrequentElement();
//        start.minimumDistanceTargetElement();
//        start.nRepeatedElementInSize2NArray();
//        start.theKWeakestRowsMatrix();
//        start.arrayPartitionI();
//        start.peakIndexInAMountainArray();
//        start.maximumNumberWordsYouCanType();
//        start.squaresOfASortedArray();
//        start.countGoodNodesInBinaryTree();
//        start.searchInABST();
//        start.replaceElementsWithGreatestRightSide();
//        start.deleteNodeInALinkedList();
//        start.arrayOfDoubledPairs();
//        start.sumOfNodesEvenValuedGrandparent();
//        start.finalPricesWithSpecialDiscount();
//        start.countNegativeNumbersSortedMatrix();
//        start.groupAnagrams();
//        start.partitionLabels();
//        start.minimumNumberOpsMoveBallsEachBox();
//        start.deleteColumnsToMakeSorted();
//        start.canMakeAritProgressionFromSeq();
//        start.sortIntegersByNumberOf1Bits();
//        start.sumOfDigitsInBaseK();
//        start.naryTreePreorderTraversal();
//        start.diStringMatch();
//        start.deleteLeavesWithGivenValue();
//        start.insertIntoABST();
//        start.shortestDistanceToACharacter();
//        start.naryTreePostorderTraversal();
//        start.maximumDifferenceNodeAncestor();
//        start.maximumDepthOfNaryTree();
//        start.findAllDuplicatesInInArray();
//        start.mergeInBetweenLinkedLists();
//        start.univaluedBinaryTree();
//        start.incrementalMemoryLeak();
//        start.invertBinaryTree();
//        start.baseballGame();
//        start.rangeSumQueryImmutable();
//        start.maximumLevelSumOfABinaryTree();
//        start.findModeInBinarySearchTree();
//        start.binaryTreeInorderTraversal();
//        start.averageOfLevelsInBT();
//        start.signOfTheProductOfAnArray();
//        start.numberOfLinesToWriteString();
//        start.dailyTemperatures();
//        start.relativeSortArray();
//        start.maximumProductOfSplittedBT();
//        start.findWordsFormedByCharacters();
//        start.flipEquivalentBinaryTrees();
//        start.validSudoku();
//        start.averageSalaryExcludingMinMax();
//        start.printInOrder();
//        start.availableCapturesForRook();
//        start.islandPerimeter();
//        start.sudokuSolver();
//        start.minimumTimeToTypeWordUsingSpecialTypewriter();
//        start.maximumMatrixSum();
//        start.rectangleAreaII();
//        start.mergeIntervals();
//        start.removePalindromicSubseq();
//        start.twoSumIVInputIsABST();
//        start.twoSumIIInputArrayIsSorted();
//        start.complexNumberMultiplication();
//        start.findCommonCharacters();
//        start.sumOfSquareNumbers();
//        start.findGCDOfArray();
//        start.decodeXORedArray();
//        start.numberOfStringAsSubstringsInWord();
//        start.ransomNote();
//        start.dayOfTheYear();
//        start.findElementsContaminatedBT();
//        start.maximumScoreWordsFormedByLetters();
//        start.verifyPreorderSerializationBT();
//        start.reverseLinkedList();
//        start.longestUncommonSubsequenceII();
//        start.longestUncommonSubsequenceI();
//        start.recoverATreeFromPreorderTraversal();
//        start.maximumProfitInJobScheduling();
//        start.uniqueEmailAddresses();
//        start.nextGreaterElementI();
//        start.binarySearch();
//        start.firstBadVersion();
//        start.rotateArray();
//        start.moveZeroes();
//        start.removeNthNodeFromEndOfList();
//        start.rangeAdditionII();
//        start.permutationInString();
//        start.floodFill();
//        start.findMinInRotatedSortedArray();
        start.maxAreaOfIsland();
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
        SumOfRootToLeafBinaryNumbers srtf = new SumOfRootToLeafBinaryNumbers();

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

    public void maximumUnitsOnATruck() {
        MaximumUnitsOnATruck muoat = new MaximumUnitsOnATruck();

        System.out.println("8 == " + muoat.maximumUnits(new int[][]{{1,3}, {2,2}, {3,1}}, 4));
        System.out.println("91 == " + muoat.maximumUnits(new int[][]{{5,10}, {2,5}, {4,7}, {3,9}}, 10));
    }

    public void sumOfUniqueElements() {
        SumOfUniqueElements soue = new SumOfUniqueElements();

        System.out.println("4 == " + soue.sumOfUnique(new int[]{1,2,3,2}));
        System.out.println("0 == " + soue.sumOfUnique(new int[]{1,1,1,1,1}));
        System.out.println("15 == " + soue.sumOfUnique(new int[]{1,2,3,4,5}));
    }

    public void frequencyOfMostFrequentElement() {
        // not solved yet
        FrequencyOfMostFreqElem fomfe = new FrequencyOfMostFreqElem();

        System.out.println("3 == " + fomfe.maxFrequency(new int[]{1,2,4}, 5));
        System.out.println("2 == " + fomfe.maxFrequency(new int[]{1,4,8,13}, 5));
        System.out.println("1 == " + fomfe.maxFrequency(new int[]{3,9,6}, 2));
    }

    public void minimumDistanceTargetElement() {
        MinimumDistanceTargetElement mdte = new MinimumDistanceTargetElement();

        System.out.println("1 == " + mdte.getMinDistance(new int[]{1,2,3,4,5}, 5, 3));
        System.out.println("0 == " + mdte.getMinDistance(new int[]{1}, 1, 0));
        System.out.println("0 == " + mdte.getMinDistance(new int[]{1,1,1,1,1,1,1,1,1,1}, 1, 0));
        System.out.println("2 == " + mdte.getMinDistance(new int[]{5,4,3,1,8,9,6,3,1,9,4}, 1, 5));
    }

    public void nRepeatedElementInSize2NArray() {
        NRepeatedElementIn2NArray nreitna = new NRepeatedElementIn2NArray();

        System.out.println("3 == " + nreitna.repeatedNTimes(new int[]{1,2,3,3}));
        System.out.println("2 == " + nreitna.repeatedNTimes(new int[]{2,1,2,5,3,2}));
        System.out.println("3 == " + nreitna.repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));
    }

    public void theKWeakestRowsMatrix() {
        TheKWeakestRowsMatrix tkwrm = new TheKWeakestRowsMatrix();

        System.out.println("[2,0,3] == " + Arrays.toString(tkwrm.kWeakestRows(new int[][]{{1,1,0,0,0}, {1,1,1,1,0},
                                                            {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,1}}, 3)));
        System.out.println("[0, 2] == " + Arrays.toString(tkwrm.kWeakestRows(new int[][]{{1,0,0,0}, {1,1,1,1}, {1,0,0,0}, {1,0,0,0}}, 2)));
        System.out.println("[0, 2] == " + Arrays.toString(tkwrm.kWeakestRows(new int[][]{{1,1,1,1,1,1}, {1,1,1,1,1,1}, {1,1,1,1,1,1}}, 1)));
    }

    public void arrayPartitionI() {
        ArrayPartitionI api = new ArrayPartitionI();

        System.out.println("4 == " + api.arrayPairSum(new int[]{1,4,3,2}));
        System.out.println("9 == " + api.arrayPairSum(new int[]{6,2,6,5,1,2}));
    }

    public void peakIndexInAMountainArray() {
        PeakIndexInAMountainArray piiama = new PeakIndexInAMountainArray();

        System.out.println("1 == " + piiama.peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println("1 == " + piiama.peakIndexInMountainArray(new int[]{0,2,1,0}));
        System.out.println("1 == " + piiama.peakIndexInMountainArray(new int[]{0,10,5,2}));
        System.out.println("2 == " + piiama.peakIndexInMountainArray(new int[]{3,4,5,1}));
        System.out.println("2 == " + piiama.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
    }

    public void maximumNumberWordsYouCanType() {
        MaximumNumberWordsYouCanType mnwyct = new MaximumNumberWordsYouCanType();

        System.out.println("1 == " + mnwyct.canBeTypedWords("hello world", "ad"));
        System.out.println("1 == " + mnwyct.canBeTypedWords("leet code", "lt"));
        System.out.println("0 == " + mnwyct.canBeTypedWords("leet code", "e"));
    }

    public void squaresOfASortedArray() {
        SquaresOfASortedArray soasa = new SquaresOfASortedArray();

        System.out.println("[0,1,9,16,100] == " + Arrays.toString(soasa.sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println("[4,9,9,49,121] == " + Arrays.toString(soasa.sortedSquares(new int[]{-7,-3,2,3,11})));
    }

    public void countGoodNodesInBinaryTree() {
        CountGoodNodesInBinaryTree cgnibt = new CountGoodNodesInBinaryTree();
        TreeNode root1 = new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        TreeNode root2 = new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null);
        TreeNode root3 = new TreeNode(1);

        System.out.println("4 == " + cgnibt.goodNodes(root1));
        System.out.println("3 == " + cgnibt.goodNodes(root2));
        System.out.println("1 == " + cgnibt.goodNodes(root3));
    }

    public void searchInABST() {
        SearchInABST siabst = new SearchInABST();

        TreeNode root1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));

        System.out.println("[2,1,3] == " + siabst.searchBST(root1, 2));
        System.out.println("[] == " + siabst.searchBST(root1, 5));
    }

    public void replaceElementsWithGreatestRightSide() {
        ReplaceElementsGreatestRightSide regrs = new ReplaceElementsGreatestRightSide();

        System.out.println("[18,6,6,6,1,-1] == " + Arrays.toString(regrs.replaceElements(new int[]{17,18,5,4,6,1})));
        System.out.println("[-1] == " + Arrays.toString(regrs.replaceElements(new int[]{400})));
    }

    public void deleteNodeInALinkedList() {
        DeleteNodeInALinkedList dniall = new DeleteNodeInALinkedList();

        ListNode node11 = new ListNode(5, new ListNode(1, new ListNode(9)));
        ListNode head11 = new ListNode(4, node11);

        ListNode node21 = new ListNode(1, new ListNode(9));
        ListNode head21 = new ListNode(4, new ListNode(5, node21));

        ListNode node31 = new ListNode(3, new ListNode(4));
        ListNode head31 = new ListNode(1, new ListNode(2, node31));

        dniall.deleteNode(node11);
        dniall.deleteNode(node21);
        dniall.deleteNode(node31);
        System.out.println("[4,1,9] == " + head11.getAsList());
        System.out.println("[4,5,9] == " + head21.getAsList());
        System.out.println("[1,2,4] == " + head31.getAsList());
    }

    public void arrayOfDoubledPairs() {
        ArrayOfDoubledPairs aodp = new ArrayOfDoubledPairs();

        System.out.println(("false == " + aodp.canReorderDoubled(new int[]{3,1,3,6})));
        System.out.println(("false == " + aodp.canReorderDoubled(new int[]{3,1,3,6})));
        System.out.println(("true == " + aodp.canReorderDoubled(new int[]{4,-2,2,-4})));
        System.out.println(("false == " + aodp.canReorderDoubled(new int[]{1,2,4,16,8,4})));
    }

    public void sumOfNodesEvenValuedGrandparent() {
        SumOfNodesEvenValuedGrandparent sofevg = new SumOfNodesEvenValuedGrandparent();

        TreeNode root1 = new TreeNode(6, new TreeNode(7, new TreeNode(2, new TreeNode(9), null), new TreeNode(7, new TreeNode(1), new TreeNode(4))),
                                      new TreeNode(8, new TreeNode(1), new TreeNode(3, null, new TreeNode(5))));
        TreeNode root2 = new TreeNode(1);

        System.out.println("18 == " + sofevg.sumEvenGrandparent(root1));
        System.out.println("0 == " + sofevg.sumEvenGrandparent(root2));
    }

    public void finalPricesWithSpecialDiscount() {
        FinalPricesWithSpecialDiscount fpwsd = new FinalPricesWithSpecialDiscount();

        System.out.println("[4,2,4,2,3] == " + Arrays.toString(fpwsd.finalPrices(new int[] { 8, 4, 6, 2, 3 })));
        System.out.println("[1,2,3,4,5] == " + Arrays.toString(fpwsd.finalPrices(new int[] { 1, 2, 3, 4, 5 })));
        System.out.println("[9,0,1,6] == " + Arrays.toString(fpwsd.finalPrices(new int[] { 10, 1, 1, 6 })));
    }

    public void countNegativeNumbersSortedMatrix() {
        CountNegativeNumbersSortedMatrix cnnsm = new CountNegativeNumbersSortedMatrix();

        System.out.println("8 == " +  cnnsm.countNegatives(new int[][]{{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}}));
        System.out.println("0 == " +  cnnsm.countNegatives(new int[][]{{3, 2}, {1, 0}}));
        System.out.println("3 == " +  cnnsm.countNegatives(new int[][]{{1, -1}, {-1, -1}}));
        System.out.println("1 == " +  cnnsm.countNegatives(new int[][]{{-1}}));
    }

    public void groupAnagrams() {
        GroupAnagrams ga = new GroupAnagrams();

        System.out.println("[[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]] == " +
                                            ga.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));

        System.out.println("[[]] == " + ga.groupAnagrams(new String[]{""}));
        System.out.println("[[a]] == " + ga.groupAnagrams(new String[]{"a"}));
    }

    public void partitionLabels() {
        PartitionLabels pl = new PartitionLabels();

        System.out.println("[9,7,8] == " + pl.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println("[10] == " + pl.partitionLabels("eccbbbbdec"));
    }

    public void minimumNumberOpsMoveBallsEachBox() {
        MinimumNumberOpsMoveBallsEachBox mnombeb = new MinimumNumberOpsMoveBallsEachBox();

        System.out.println(("[1,1,3] == " + Arrays.toString(mnombeb.minOperations("110"))));
        System.out.println(("[11,8,5,4,3,4] == " + Arrays.toString(mnombeb.minOperations("001011"))));
    }

    public void deleteColumnsToMakeSorted() {
        DeleteColumnsToMakeSorted dctms = new DeleteColumnsToMakeSorted();

        System.out.println("1 == " + dctms.minDeletionSize(new String[]{"cba","daf","ghi"}));
        System.out.println("0 == " + dctms.minDeletionSize(new String[]{"a","b"}));
        System.out.println("3 == " + dctms.minDeletionSize(new String[]{"zyx","wvu","tsr"}));
    }

    public void canMakeAritProgressionFromSeq() {
        CanMakeAritProgressionFromSeq cmapfs = new CanMakeAritProgressionFromSeq();

        System.out.println("true == " + cmapfs.canMakeArithmeticProgression(new int[]{3,5,1}));
        System.out.println("false == " + cmapfs.canMakeArithmeticProgression(new int[]{1,2,4}));
    }

    public void sortIntegersByNumberOf1Bits() {
        SortIntegersByNumberOf1Bits sibnoob = new SortIntegersByNumberOf1Bits();

        System.out.println("[0,1,2,4,8,3,5,6,7] == " + Arrays.toString(sibnoob.sortByBits(new int[]{0,1,2,3,4,5,6,7,8})));
        System.out.println("[1,2,4,8,16,32,64,128,256,512,1024] == " + Arrays.toString(sibnoob.sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1})));
        System.out.println("[10000,10000] == " + Arrays.toString(sibnoob.sortByBits(new int[]{10000,10000})));
        System.out.println("[2,3,5,17,7,11,13,19] == " + Arrays.toString(sibnoob.sortByBits(new int[]{2,3,5,7,11,13,17,19})));
        System.out.println("[10,100,10000,1000] == " + Arrays.toString(sibnoob.sortByBits(new int[]{10,100,1000,10000})));
    }

    public void sumOfDigitsInBaseK() {
        SumOfDigitsInBaseK sodibk = new SumOfDigitsInBaseK();

        System.out.println("9 == " + sodibk.sumBase(34, 6));
        System.out.println("1 == " + sodibk.sumBase(10, 10));
    }

    public void naryTreePreorderTraversal() {
        NaryTreePreorderTraversal ntpt = new NaryTreePreorderTraversal();

        Node root1 = new Node(1, List.of(new Node(3, List.of(new Node(5), new Node(6))), new Node(2), new Node(4)));

        System.out.println("[1,3,5,6,2,4] == " + ntpt.preorder(root1));
    }

    public void diStringMatch() {
        DIStringMatch dism = new DIStringMatch();

        System.out.println("[0,4,1,3,2] == " + Arrays.toString(dism.diStringMatch("IDID")));
        System.out.println("[0,1,2,3] == " + Arrays.toString(dism.diStringMatch("III")));
        System.out.println("[3,2,0,1] == " + Arrays.toString(dism.diStringMatch("DDI")));

    }

    public void deleteLeavesWithGivenValue() {
        DeleteLeavesWithGivenValue dlwgv = new DeleteLeavesWithGivenValue();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(2), null), new TreeNode(3, new TreeNode(2), new TreeNode(4)));
        TreeNode root2 = new TreeNode(1, new TreeNode(3, new TreeNode(3), new TreeNode(2)), new TreeNode(3));
        TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(2, new TreeNode(2), null), null), null);

        System.out.println("[1,3,4] == " + TreeNode.preOrder(dlwgv.removeLeafNodes(root1, 2)));
        System.out.println("[1,3,2] == " + TreeNode.preOrder(dlwgv.removeLeafNodes(root2, 3)));
        System.out.println("[1] == " + TreeNode.preOrder(dlwgv.removeLeafNodes(root3, 2)));
    }

    public void insertIntoABST() {
        InsertIntoABST iiabst = new InsertIntoABST();

        TreeNode root1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));

        System.out.println("[4,2,7,1,3,5] == " + TreeNode.preOrder(iiabst.insertIntoBST(root1, 5)));
    }

    public void shortestDistanceToACharacter() {
        ShortestDistanceToACharacter sdtac = new ShortestDistanceToACharacter();

        System.out.println("[3,2,1,0,1,0,0,1,2,2,1,0] == " +  Arrays.toString(sdtac.shortestToChar("loveleetcode", 'e')));
        System.out.println("[3,2,1,0] == " +  Arrays.toString(sdtac.shortestToChar("aaab", 'b')));
    }

    public void naryTreePostorderTraversal() {
        NaryTreePostorderTraversal ntpr = new NaryTreePostorderTraversal();

        Node node1 = new Node(1, List.of(new Node(3, List.of(new Node(5), new Node(6))), new Node(2), new Node(4)));
        Node node2 = new Node(1, List.of(
            new Node(2),
            new Node(3, List.of(new Node(6), new Node(7, List.of(new Node(11, List.of(new Node(14))))))),
            new Node(4, List.of(new Node(8, List.of(new Node(12))))),
            new Node(5, List.of(new Node(9, List.of(new Node(13))), new Node(10))
        )));

        System.out.println("[5,6,3,2,4,1] == " + ntpr.postorder(node1));
        System.out.println("[2,6,14,11,7,3,12,8,4,13,9,10,5,1] == " + ntpr.postorder(node2));
    }

    public void maximumDifferenceNodeAncestor() {
        MaximumDifferenceNodeAncestor mdna = new MaximumDifferenceNodeAncestor();

        TreeNode root1 = new TreeNode(8, new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
                                      new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null)));

        System.out.println("7 == " + mdna.maxAncestorDiff(root1));
        System.out.println("3 == " + mdna.maxAncestorDiff(root2));
    }

    public void maximumDepthOfNaryTree() {
        MaximumDepthOfNaryTree mdont = new MaximumDepthOfNaryTree();

        Node node1 = new Node(1, List.of(new Node(3, List.of(new Node(5), new Node(6))), new Node(2), new Node(4)));
        Node node2 = new Node(1, List.of(
            new Node(2),
            new Node(3, List.of(new Node(6), new Node(7, List.of(new Node(11, List.of(new Node(14))))))),
            new Node(4, List.of(new Node(8, List.of(new Node(12))))),
            new Node(5, List.of(new Node(9, List.of(new Node(13))), new Node(10)))
        ));

        System.out.println("3 == " + mdont.maxDepth(node1));
        System.out.println("5 == " + mdont.maxDepth(node2));
    }

    public void findAllDuplicatesInInArray() {
        FindAllDuplicatesInanArray fadiaa = new FindAllDuplicatesInanArray();

        System.out.println("[2,3] == " + fadiaa.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println("[1] == " + fadiaa.findDuplicates(new int[]{1,1,2}));
        System.out.println("[] == " + fadiaa.findDuplicates(new int[]{1}));
    }

    public void mergeInBetweenLinkedLists() {
        MergeInBetweenLinkedLists mibll = new MergeInBetweenLinkedLists();

        ListNode head1 = ListNode.makeChain(new int[]{0,1,2,3,4,5});
        ListNode head2 = ListNode.makeChain(new int[]{1000000,1000001,1000002});
        ListNode head3 = ListNode.makeChain(new int[]{0,1,2,3,4,5,6});
        ListNode head4 = ListNode.makeChain(new int[]{1000000,1000001,1000002,1000003,1000004});
        ListNode head5 = ListNode.makeChain(new int[]{0,3,2,1,4,5});
        ListNode head6 = ListNode.makeChain(new int[]{1000000,1000001,1000002});

        System.out.println("[0,1,2,1000000,1000001,1000002,5] == " + mibll.mergeInBetween(head1, 3, 4, head2).getAsList());
        System.out.println("[0,1,1000000,1000001,1000002,1000003,1000004,6] == " + mibll.mergeInBetween(head3, 2, 5, head4).getAsList());
        System.out.println("[0,3,2,1000000,1000001,1000002,5] == " + mibll.mergeInBetween(head5, 3, 4, head6).getAsList());
    }

    public void univaluedBinaryTree() {
        UnivaluedBinaryTree ubt = new UnivaluedBinaryTree();

        TreeNode root1 = new TreeNode(1, new TreeNode(1, new TreeNode(1), new TreeNode(1)), new TreeNode(1, null, new TreeNode(1)));
        TreeNode root2 = new TreeNode(2, new TreeNode(2, new TreeNode(5), new TreeNode(2)), new TreeNode(2));

        System.out.println("true == " + ubt.isUnivalTree(root1));
        System.out.println("false == " + ubt.isUnivalTree(root2));
    }

    public void incrementalMemoryLeak() {
        IncrementalMemoryLeak iml = new IncrementalMemoryLeak();

        System.out.println("[3,1,0] == " + Arrays.toString(iml.memLeak(2, 2)));
        System.out.println("[6,0,4] == " + Arrays.toString(iml.memLeak(8, 11)));
    }

    public void invertBinaryTree() {
        InvertBinaryTree ibt = new InvertBinaryTree();

        TreeNode root1 = new TreeNode(4, new TreeNode(2, new TreeNode(1),new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode root2 = new TreeNode(2,new TreeNode(1), new TreeNode(3));
        TreeNode root3 = null;

        System.out.println("[9,6,7,3,1,2,4] == " + TreeNode.preOrder(ibt.invertTree(root1)));
        System.out.println("[3,1,2] == " + TreeNode.preOrder(ibt.invertTree(root2)));
        System.out.println("[] == " + TreeNode.preOrder(ibt.invertTree(root3)));
    }

    public void baseballGame() {
        BaseballGame bg = new BaseballGame();

        System.out.println("30 == " + bg.calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println("27 == " + bg.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
        System.out.println("1 == " + bg.calPoints(new String[]{"1"}));
    }

    public void rangeSumQueryImmutable() {
        RangeSumQueryImmutable rsqi = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});

        System.out.println("1 == " + rsqi.sumRange(0, 2));
        System.out.println("-1 == " + rsqi.sumRange(2, 5));
        System.out.println("-3 == " + rsqi.sumRange(0, 5));
    }

    public void maximumLevelSumOfABinaryTree() {
        MaximumLevelSumOfABinaryTree mlsofbt = new MaximumLevelSumOfABinaryTree();

        TreeNode root1 = new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));
        TreeNode root2 = new TreeNode(989, null, new TreeNode(10250, new TreeNode(98693), new TreeNode(-89388,null, new TreeNode(-32127))));

        System.out.println("2 == " + mlsofbt.maxLevelSum(root1));
        System.out.println("2 == " + mlsofbt.maxLevelSum(root2));
    }

    public void findModeInBinarySearchTree() {
        FindModeInBST fmibst = new FindModeInBST();

        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));
        TreeNode root2 = new TreeNode(0);

        System.out.println("[2] == " + Arrays.toString(fmibst.findMode(root1)));
        System.out.println("[0] == " + Arrays.toString(fmibst.findMode(root2)));
    }

    public void binaryTreeInorderTraversal() {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();

        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode root2 = null;
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(1, new TreeNode(2), null);
        TreeNode root5 = new TreeNode(1, null, new TreeNode(2));

        System.out.println("[1,3,2] == " + btit.inorderTraversal(root1));
        System.out.println("[] == " + btit.inorderTraversal(root2));
        System.out.println("[1] == " + btit.inorderTraversal(root3));
        System.out.println("[1,2] == " + btit.inorderTraversal(root4));
        System.out.println("[1,2] == " + btit.inorderTraversal(root5));
    }

    public void averageOfLevelsInBT() {
        AverageOfLevelsInBT aofibt = new AverageOfLevelsInBT();

        TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root2 = new TreeNode(9, new TreeNode(9, new TreeNode(15), new TreeNode(7)), new TreeNode(20));

        System.out.println("[3.00000,14.50000,11.00000] == " + aofibt.averageOfLevels(root1));
        System.out.println("[3.00000,14.50000,11.00000] == " + aofibt.averageOfLevels(root2));
    }

    public void signOfTheProductOfAnArray() {
        SignOfTheProductOfAnArray sotpoaa = new SignOfTheProductOfAnArray();

        System.out.println("1 == " + sotpoaa.arraySign(new int[]{-1,-2,-3,-4,3,2,1}));
        System.out.println("0 == " + sotpoaa.arraySign(new int[]{1,5,0,2,-3}));
        System.out.println("-1 == " + sotpoaa.arraySign(new int[]{-1,1,-1,1,-1}));
    }

    public void numberOfLinesToWriteString() {
        NumberOfLinesToWriteString noltws = new NumberOfLinesToWriteString();

        int[] widths1 = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        int[] widths2 = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};

        System.out.println("[3,60] == " + Arrays.toString(noltws.numberOfLines(widths1, "abcdefghijklmnopqrstuvwxyz")));
        System.out.println("[2,4] == " + Arrays.toString(noltws.numberOfLines(widths2, "bbbcccdddaaa")));

    }

    public void dailyTemperatures() {
        DailyTemperatures dt = new DailyTemperatures();

        System.out.println("[1,1,4,2,1,1,0,0] == " + Arrays.toString(dt.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
        System.out.println("[1,1,1,0] == " + Arrays.toString(dt.dailyTemperatures(new int[]{30,40,50,60})));
        System.out.println("[1,1,0] == " + Arrays.toString(dt.dailyTemperatures(new int[]{30,60,90})));
    }

    public void relativeSortArray() {
        RelativeSortArray rsa = new RelativeSortArray();

        System.out.println("[2,2,2,1,4,3,3,9,6,7,19] == " + Arrays.toString(rsa.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6})));
        System.out.println("[22,28,8,6,17,44] == " + Arrays.toString(rsa.relativeSortArray(new int[]{28,6,22,8,44,17}, new int[]{22,28,8,6})));
    }

    public void maximumProductOfSplittedBT() {
        MaximumProductOfSplittedBT mposbt = new MaximumProductOfSplittedBT();

        TreeNode root1 = new TreeNode(1,new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2,new TreeNode(3), new TreeNode(4, new TreeNode(5), new TreeNode(6))));
        TreeNode root3 = new TreeNode(2,
            new TreeNode(3, new TreeNode(10, new TreeNode(5), new TreeNode(4)), new TreeNode(7, new TreeNode(11),new TreeNode(1))),
            new TreeNode(9, new TreeNode(8),new TreeNode(6)));
        TreeNode root4 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        TreeNode root5 = new TreeNode(1, new TreeNode(1), null);
        TreeNode root6 = new TreeNode(10, new TreeNode(7, null, new TreeNode(10)), new TreeNode(6, null, new TreeNode(10)));
        TreeNode root7 = new TreeNode(6, new TreeNode(10, null, new TreeNode(6, new TreeNode(1, new TreeNode(1), null),null)), null);

        System.out.println("110 == " + mposbt.maxProduct(root1));
        System.out.println("90 == " + mposbt.maxProduct(root2));
        System.out.println("1025 == " + mposbt.maxProduct(root3));
        System.out.println("4 == " + mposbt.maxProduct(root4));
        System.out.println("1 == " + mposbt.maxProduct(root5));
        System.out.println("442 == " + mposbt.maxProduct(root6));
        System.out.println("128 == " + mposbt.maxProduct(root7));
    }

    public void findWordsFormedByCharacters() {
        FindWordsFormedByCharacters fwfbc = new FindWordsFormedByCharacters();

        System.out.println("6 == " + fwfbc.countCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));
        System.out.println("10 == " + fwfbc.countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr"));
    }

    public void flipEquivalentBinaryTrees() {
        FlipEquivalentBinaryTrees febt = new FlipEquivalentBinaryTrees();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8))),
                                      new TreeNode(3, new TreeNode(6), null));
        TreeNode root2 = new TreeNode(1, new TreeNode(3, null, new TreeNode(6)),
                                      new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), new TreeNode(7))));
        TreeNode root3 = null, root4 = null, root5 = new TreeNode(1);
        TreeNode root6 = new TreeNode(0, null, new TreeNode(1));
        TreeNode root7 = new TreeNode(0, new TreeNode(1),null);
        TreeNode root8 = new TreeNode(0, new TreeNode(3), new TreeNode(1, null, new TreeNode(2)));
        TreeNode root9 = new TreeNode(0, new TreeNode(3, new TreeNode(2), null), new TreeNode(1));
        TreeNode root10 = new TreeNode(0, null, new TreeNode(1));

        System.out.println("true == " + febt.flipEquiv(root1, root2));
        System.out.println("true == " + febt.flipEquiv(root3, root4));
        System.out.println("false == " + febt.flipEquiv(root3, root5));
        System.out.println("false == " + febt.flipEquiv(root6, root3));
        System.out.println("true == " + febt.flipEquiv(root6, root7));
        System.out.println("true == " + febt.flipEquiv(root6, root10));
        System.out.println("false == " + febt.flipEquiv(root8, root9));
    }

    public void validSudoku() {
        ValidSudoku vs = new ValidSudoku();
        char[][] board1 =  {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        char[][] board2 =  {{'8','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};

        System.out.println("true == " + vs.isValidSudoku(board1));
        System.out.println("false == " + vs.isValidSudoku(board2));
    }

    public void averageSalaryExcludingMinMax() {
        AverageSalaryExcludingMinMax asemm = new AverageSalaryExcludingMinMax();

        System.out.println("2500.0 == " + asemm.average(new int[]{4000,3000,1000,2000}));
        System.out.println("2000.0 == " + asemm.average(new int[]{1000,2000,3000}));
        System.out.println("3500.0 == " + asemm.average(new int[]{6000,5000,4000,3000,2000,1000}));
        System.out.println("4750.0 == " + asemm.average(new int[]{8000,9000,2000,3000,6000,1000}));
    }

    public void printInOrder(){
        PrintInOrder pio = new PrintInOrder();
        final List<String> myList = new ArrayList<>();
        Thread t1 = new Thread(() -> pio.third(() -> {
            myList.add("Third");
            System.out.println("Third");
        }));
        Thread t2 = new Thread(() -> pio.first(() -> {
            myList.add("First");
            System.out.println("First");
        }));
        Thread t3 = new Thread(() -> pio.second(() -> {
            myList.add("Second");
            System.out.println("Second");
        }));

        t2.start();
        t3.start();
        t1.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            System.out.println("[First, Second, Third] == " + myList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void availableCapturesForRook() {
        AvailableCapturesForRook acfr = new AvailableCapturesForRook();

        char[][] board1 =   {{'.','.','.','.','.','.','.','.'},
                            {'.','.','.','p','.','.','.','.'},
                            {'.','.','.','R','.','.','.','p'},
                            {'.','.','.','.','.','.','.','.'},
                            {'.','.','.','.','.','.','.','.'},
                            {'.','.','.','p','.','.','.','.'},
                            {'.','.','.','.','.','.','.','.'},
                            {'.','.','.','.','.','.','.','.'}};
        char[][] board2 =   {{'.','.','.','.','.','.','.','.'},
                            {'.','p','p','p','p','p','.','.'},
                            {'.','p','p','B','p','p','.','.'},
                            {'.','p','B','R','B','p','.','.'},
                            {'.','p','p','B','p','p','.','.'},
                            {'.','p','p','p','p','p','.','.'},
                            {'.','.','.','.','.','.','.','.'},
                            {'.','.','.','.','.','.','.','.'}};

        System.out.println("3 == " + acfr.numRookCaptures(board1));
        System.out.println("0 == " + acfr.numRookCaptures(board2));
    }

    public void islandPerimeter() {
        IslandPerimeter ip = new IslandPerimeter();

        System.out.println("16 == " + ip.islandPerimeter(new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}}));
        System.out.println("4 == " + ip.islandPerimeter(new int[][]{{1}}));
        System.out.println("4 == " + ip.islandPerimeter(new int[][]{{1, 0}}));
    }

    public void sudokuSolver() {
        SudokuSolver ss = new SudokuSolver();
        SudokuSolver2 ss2 = new SudokuSolver2();

        char[][] board1 =  {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};

        char[][] board2 =  {{'.','.','9','7','4','8','.','.','.'},
                            {'7','.','.','.','.','.','.','.','.'},
                            {'.','2','.','1','.','9','.','.','.'},
                            {'.','.','7','.','.','.','2','4','.'},
                            {'.','6','4','.','1','.','5','9','.'},
                            {'.','9','8','.','.','.','3','.','.'},
                            {'.','.','.','8','.','3','.','2','.'},
                            {'.','.','.','.','.','.','.','.','6'},
                            {'.','.','.','2','7','5','9','.','.'}};

        ss.solveSudoku(board1);
        System.out.println(ss.toString(board2));
    }

    public void minimumTimeToTypeWordUsingSpecialTypewriter() {
        MinTimeTypeWordSpecialTypewriter mttst = new MinTimeTypeWordSpecialTypewriter();

        System.out.println("5 == "+ mttst.minTimeToType("abc"));
        System.out.println("7 == "+ mttst.minTimeToType("bza"));
        System.out.println("34 == "+ mttst.minTimeToType("zjpc"));
    }

    public void maximumMatrixSum() {
        MaximumMatrixSum mms = new MaximumMatrixSum();

        System.out.println("4 == " + mms.maxMatrixSum(new int[][]{{-1, -1}, {-1,-1}}));
        System.out.println("16 == " + mms.maxMatrixSum(new int[][]{{1,2,3}, {-1,-2,-3}, {1,2,3}}));
        System.out.println("15 == " + mms.maxMatrixSum(new int[][]{{-1, 0, -1}, {-2,1,3}, {3,2,2}}));
        System.out.println("34 == " + mms.maxMatrixSum(new int[][]{{2,9,3}, {5,4,-4}, {1,7,1}}));
        System.out.println("114 == " + mms.maxMatrixSum(new int[][]{{-9,9,9,-9}, {-10,10,7,5}, {4,-8,-9,6}, {10,2,-6,1}}));
    }

    public void rectangleAreaII() {
        RectangleAreaII raii = new RectangleAreaII();

        System.out.println("7 == " + raii.rectangleArea(new int[][]{{0,2,1,4}, {0,0,2,2}, {3,1,4,2}}));
//        System.out.println("6 == " + raii.rectangleArea(new int[][]{{0,0,2,2}, {1,0,2,3}, {1,0,3,1}}));
//        System.out.println("49 == " + raii.rectangleArea(new int[][]{{0,0,1000000000,1000000000}}));
    }

    public void mergeIntervals() {
        MergeIntervals mi = new MergeIntervals();

        System.out.println("[[0,9],[10,14],[15,18]] == " + Arrays.deepToString(mi.merge(new int[][]{{2,5}, {0,2}, {4,9}, {15,18}, {10, 14}})));
        System.out.println("[[1,6],[8,10],[15,18]] == " + Arrays.deepToString(mi.merge(new int[][]{{1,3}, {2,6}, {8,10}, {15,18}})));
        System.out.println("[[1,4],[4,5]] == " + Arrays.deepToString(mi.merge(new int[][]{{1,4}, {4,5}})));
    }

    public void removePalindromicSubseq() {
        RemovePalindromicSubseq rps = new RemovePalindromicSubseq();

        System.out.println("1 == " + rps.removePalindromeSub("ababa"));
        System.out.println("2 == " + rps.removePalindromeSub("abb"));
        System.out.println("2 == " + rps.removePalindromeSub("baabb"));
    }

    public void twoSumIVInputIsABST() {
        TwoSumIVInputIsABST tsiviiabst = new TwoSumIVInputIsABST();

        TreeNode root1 = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6,null, new TreeNode(7)));
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        System.out.println("true == " + tsiviiabst.findTarget(root1, 9));
        System.out.println("false == " + tsiviiabst.findTarget(root1, 28));
        System.out.println("false == " + tsiviiabst.findTarget(root2, 2));
        System.out.println("true == " + tsiviiabst.findTarget(root3, 4));
        System.out.println("false == " + tsiviiabst.findTarget(root2, 1));
        System.out.println("true == " + tsiviiabst.findTarget(root3, 3));
    }

    public void twoSumIIInputArrayIsSorted() {
        TwoSumIIInputArrayIsSorted tsiiiais = new TwoSumIIInputArrayIsSorted();

        System.out.println("[1,2] == " + Arrays.toString(tsiiiais.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println("[1,3] == " + Arrays.toString(tsiiiais.twoSum(new int[]{2,3,4}, 6)));
        System.out.println("[1,2] == " + Arrays.toString(tsiiiais.twoSum(new int[]{-1,0}, -1)));
    }

    public void complexNumberMultiplication() {
        ComplexNumberMultiplication cnm = new ComplexNumberMultiplication();

        System.out.println("0+2i == " + cnm.complexNumberMultiply("1+1i", "1+1i"));
        System.out.println("0+-2i == " + cnm.complexNumberMultiply("1+-1i", "1+-1i"));
    }

    public void findCommonCharacters() {
        FindCommonCharacters fcc = new FindCommonCharacters();

        System.out.println("[e, l, l] ==" + fcc.commonChars(new String[]{"bella","label","roller"}));
        System.out.println("[c, o] ==" + fcc.commonChars(new String[]{"cool","lock","cook"}));
    }

    public void sumOfSquareNumbers() {
        SumOfSquareNumbers sosn = new  SumOfSquareNumbers();

        System.out.println("true == " + sosn.judgeSquareSum(5));
        System.out.println("false == " + sosn.judgeSquareSum(3));
        System.out.println("true == " + sosn.judgeSquareSum(4));
        System.out.println("true == " + sosn.judgeSquareSum(2));
        System.out.println("true == " + sosn.judgeSquareSum(1));
    }

    public void findGCDOfArray() {
        FindGCDOfArray fgcdoa = new FindGCDOfArray();

        System.out.println("2 == " + fgcdoa.findGCD(new int[]{2,5,6,9,10}));
        System.out.println("1 == " + fgcdoa.findGCD(new int[]{7,5,6,8,3}));
        System.out.println("3 == " + fgcdoa.findGCD(new int[]{3,3}));
    }

    public void decodeXORedArray() {
        DecodeXORedArray dxora = new DecodeXORedArray();

        System.out.println("[1,0,2,1] == " + Arrays.toString(dxora.decode(new int[]{1,2,3}, 1)));
        System.out.println("[4,2,0,7,4] == " + Arrays.toString(dxora.decode(new int[]{6,2,7, 3}, 4)));
    }

    public void numberOfStringAsSubstringsInWord() {
        NumberOfStringAsSubstringsInWord nosasiw = new NumberOfStringAsSubstringsInWord();

        System.out.println("3 == " + nosasiw.numOfStrings(new String[]{"a","abc","bc","d"}, "abc"));
        System.out.println("2 == " + nosasiw.numOfStrings(new String[]{"a","b","c"}, "aaaaabbbbb"));
        System.out.println("3 == " + nosasiw.numOfStrings(new String[]{"a","a","a"}, "ab"));
    }

    public void ransomNote() {
        RansomNote rn = new RansomNote();

        System.out.println("false == " + rn.canConstruct("a", "b"));
        System.out.println("false == " + rn.canConstruct("aa", "ab"));
        System.out.println("true == " + rn.canConstruct("aa", "aab"));
    }

    public void dayOfTheYear() {
        DayOfTheYear doty = new DayOfTheYear();

        System.out.println("9 == " + doty.dayOfYear("2019-01-09"));
        System.out.println("41 == " + doty.dayOfYear("2019-02-10"));
        System.out.println("60 == " + doty.dayOfYear("2003-03-01"));
        System.out.println("61 == " + doty.dayOfYear("2004-03-01"));
    }

    public void findElementsContaminatedBT() {
        TreeNode root1 = new TreeNode(-1, null, new TreeNode(-1));
        TreeNode root2 = new TreeNode(-1, new TreeNode(-1, new TreeNode(-1), new TreeNode(-1)), new TreeNode(-1));
        TreeNode root3 = new TreeNode(-1, null, new TreeNode(-1, new TreeNode(-1, new TreeNode(-1), null), null));

        FindElementsContaminatedBT fecbt1 = new FindElementsContaminatedBT(root1);
        FindElementsContaminatedBT fecbt2 = new FindElementsContaminatedBT(root2);
        FindElementsContaminatedBT fecbt3 = new FindElementsContaminatedBT(root3);

        System.out.println("false == " + fecbt1.find(1));
        System.out.println("true == " + fecbt1.find(2));

        System.out.println("true == " + fecbt2.find(1));
        System.out.println("true == " + fecbt2.find(3));
        System.out.println("false == " + fecbt2.find(5));

        System.out.println("true == " + fecbt3.find(2));
        System.out.println("false == " + fecbt3.find(3));
        System.out.println("false == " + fecbt3.find(4));
        System.out.println("true == " + fecbt3.find(5));
    }

    public void maximumScoreWordsFormedByLetters() {
        MaximumScoreWordsFormedByLetters mswfbl = new MaximumScoreWordsFormedByLetters();

        System.out.println("23 == " + mswfbl.maxScoreWords(new String[]{"dog","cat","dad","good"},
            new char[]{'a','a','c','d','d','d','g','o','o'}, new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0}));

        System.out.println("27 == " + mswfbl.maxScoreWords(new String[]{"xxxz","ax","bx","cx"},
            new char[]{'z','a','b','c','x','x','x'}, new int[]{4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10}));

        System.out.println("0 == " + mswfbl.maxScoreWords(new String[]{"leetcode"},
            new char[]{'l','e','t','c','o','d'}, new int[]{0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0}));
    }

    public void verifyPreorderSerializationBT() {
        VerifyPreorderSerializationBT vpsbt = new VerifyPreorderSerializationBT();

        System.out.println("true == " + vpsbt.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println("false == " + vpsbt.isValidSerialization("9,#,#,1"));
        System.out.println("false == " + vpsbt.isValidSerialization("9,#,#,1"));
    }

    public void reverseLinkedList() {
        ReverseLinkedList rll = new ReverseLinkedList();

        ListNode node1 = ListNode.makeChain(new int[]{1,2,3,4,5});
        ListNode node2 = ListNode.makeChain(new int[]{1,2});
        ListNode node3 = null;

        System.out.println("[5,4,3,2,1] == " + rll.reverseList(node1).getAsList());
        System.out.println("[2,1] == " + rll.reverseList(node2).getAsList());
        System.out.println("null == " + rll.reverseList(node3));
    }

    public void longestUncommonSubsequenceII() {
        LongestUncommonSubsequenceII lusii = new LongestUncommonSubsequenceII();

        System.out.println("3 == " + lusii.findLUSlength(new String[]{"aba","cdc","eae"}));
        System.out.println("-1 == " + lusii.findLUSlength(new String[]{"aaa","aaa","aa"}));
    }

    public void longestUncommonSubsequenceI() {
        LongestUncommonSubsequenceI lusi = new LongestUncommonSubsequenceI();

        System.out.println("3 == " + lusi.findLUSlength("aba", "cdc"));
        System.out.println("-1 == " + lusi.findLUSlength("aaa", "bbb"));
        System.out.println("3 == " + lusi.findLUSlength("aaa", "aa"));
    }

    public void recoverATreeFromPreorderTraversal() {
        RecoverATreeFromPreorderTraversal ratfpt = new RecoverATreeFromPreorderTraversal();

        System.out.println("[1,2,3,4,5,6,7] == " + TreeNode.preOrder(ratfpt.recoverFromPreorder("1-2--3--4-5--6--7")));
        System.out.println("[1,2,3,4,5,6,7] == " + TreeNode.preOrder(ratfpt.recoverFromPreorder("1-2--3---4-5--6---7")));
        System.out.println("[1,401, 349, 90, 88] == " + TreeNode.preOrder(ratfpt.recoverFromPreorder("1-401--349---90--88")));
    }

    public void maximumProfitInJobScheduling() {
        MaximumProfitInJobScheduling mpijs = new MaximumProfitInJobScheduling();

        System.out.println("18 == " + mpijs.jobScheduling(new int[]{4,2,4,8,2}, new int[]{5,5,5,10,8}, new int[]{1,2,8,10,4}));
        System.out.println("25 == " + mpijs.jobScheduling(new int[]{7,4,4,2,1}, new int[]{14,11,6,5,3}, new int[]{2,15,12,5,10}));
        System.out.println("120 == " + mpijs.jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}));
        System.out.println("150 == " + mpijs.jobScheduling(new int[]{1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60}));
        System.out.println("6 == " + mpijs.jobScheduling(new int[]{1,1,1}, new int[]{2,3,4}, new int[]{5,6,4}));
    }

    public void uniqueEmailAddresses() {
        UniqueEmailAddresses uea = new UniqueEmailAddresses();

        System.out.println("2 == " + uea.numUniqueEmails(new String[]{"test.email+alex@leetcode.com",
                                            "test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println("2 == " + uea.numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"}));
    }

    public void nextGreaterElementI() {
        NextGreaterElementI ngei = new NextGreaterElementI();

//        System.out.println("[-1,3,-1] == " + Arrays.toString(ngei.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
//        System.out.println("[3,-1] == " + Arrays.toString(ngei.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));
        System.out.println("[-1,13,27,27] == " + Arrays.toString(ngei.nextGreaterElement(new int[]{27,9,11,6}, new int[]{9,13,72,11,6,27,16})));
    }

    public void binarySearch() {
        BinarySearch bs = new BinarySearch();

        System.out.println("4 == " + bs.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println("1 == " + bs.search(new int[]{1,4}, 4));
        System.out.println("-1 == " + bs.search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println("6 == " + bs.search(new int[]{-23, -12, -5, 0, 2,6,9,12,34,78,123,11225}, 9));
    }

    public void firstBadVersion() {
        FirstBadVersion fbv = new FirstBadVersion();

        fbv.setBadVersion(4);
        System.out.println("4 == " + fbv.firstBadVersion(5));

        fbv.setBadVersion(1);
        System.out.println("1 == " + fbv.firstBadVersion(1));

        fbv.setBadVersion(54);
        System.out.println("54 == " + fbv.firstBadVersion(100));

        fbv.setBadVersion(2);
        System.out.println("2 == " + fbv.firstBadVersion(3));
    }

    public void rotateArray() {
        RotateArray ra = new RotateArray();

        int[] array1 = new int[]{1,2,3,4,5,6,7};
        int[] array2 = new int[]{-1,-100,3,99};
        int[] array3 = new int[]{-1};
        ra.rotate(array1, 3);
        ra.rotate(array2, 2);
        ra.rotate(array3, 2);
        System.out.println("[5,6,7,1,2,3,4] == " + Arrays.toString(array1));
        System.out.println("[3,99,-1,-100] == " + Arrays.toString(array2));
        System.out.println("[-1] == " + Arrays.toString(array3));
    }

    public void moveZeroes() {
        MoveZeroes mz = new MoveZeroes();

        int[] array1 = {0,1,0,3,12};
        int[] array2 = {0};
        int[] array3 = {1,0};
        int[] array4 = {2,8,3,0,1,0,2,7,0,0,2,9,0,1,1,0,0};
        mz.moveZeroes(array1);
        mz.moveZeroes(array2);
        mz.moveZeroes(array3);
        mz.moveZeroes(array4);
        System.out.println("[1,3,12,0,0] == " + Arrays.toString(array1));
        System.out.println("[0] == " + Arrays.toString(array2));
        System.out.println("[1,0] == " + Arrays.toString(array3));
        System.out.println("[2,8,3,1,2,7,2,9,1,1,0,0,0,0,0,0,0] == " + Arrays.toString(array4));
    }

    public void removeNthNodeFromEndOfList() {
        RemoveNthNodeFromEndOfList rnnfeol = new RemoveNthNodeFromEndOfList();

        ListNode node1 = ListNode.makeChain(new int[]{1,2,3,4,5});
        ListNode node2 = new ListNode(1);
        ListNode node3 = ListNode.makeChain(new int[]{1,2});
        System.out.println("[1,2,3,5] == " + rnnfeol.removeNthFromEnd(node1, 2).getAsList());
        System.out.println("[] == " + rnnfeol.removeNthFromEnd(node2, 1));
        System.out.println("[1] == " + rnnfeol.removeNthFromEnd(node3, 1).getAsList());
    }

    public void rangeAdditionII() {
        RangeAdditionII raii = new RangeAdditionII();

        System.out.println("4 == " + raii.maxCount(3,3, new int[][]{{2,2}, {3,3}}));
        System.out.println("4 == " + raii.maxCount(3,3, new int[][]{{2,2}, {3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3}}));
        System.out.println("9 == " + raii.maxCount(3,3, new int[0][0]));
    }

    public void permutationInString() {
        PermutationInString pis = new PermutationInString();

        System.out.println("true == " + pis.checkInclusion("ab", "eidbaooo"));
        System.out.println("false == " + pis.checkInclusion("ab", "eidboaoo"));
        System.out.println("true == " + pis.checkInclusion("ab", "ab"));
        System.out.println("true == " + pis.checkInclusion("adc", "dcda"));
    }

    public void floodFill() {
        FloodFill ff = new FloodFill();

        System.out.println("[[2,2,2],[2,2,0],[2,0,1]] == " + Arrays.deepToString(ff.floodFill(new int[][]{{1,1,1}, {1,1,0}, {1,0,1}}, 1,1,2)));
        System.out.println("[[2,2,2],[2,2,2]] == " + Arrays.deepToString(ff.floodFill(new int[][]{{0,0,0}, {0,0,0}}, 0,0,2)));
        System.out.println("[[,0,0,0],[0,1,1]] == " + Arrays.deepToString(ff.floodFill(new int[][]{{0,0,0}, {0,1,1}}, 1,1,1)));
    }

    public void findMinInRotatedSortedArray() {
        FindMinInRotatedSortedArray fmrsa = new FindMinInRotatedSortedArray();

        System.out.println("1 == " + fmrsa.findMin(new int[]{3,4,5,1,2}));
        System.out.println("0 == " + fmrsa.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println("11 == " + fmrsa.findMin(new int[]{11,13,15,17}));
    }

    public void maxAreaOfIsland() {
        MaxAreaOfIsland maoi = new MaxAreaOfIsland();

        int[][] area1 = {{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] area2 = {{0,0,0,0,0,0,0,0}};

        System.out.println("6 == " + maoi.maxAreaOfIsland(area1));
        System.out.println("0 == " + maoi.maxAreaOfIsland(area2));
    }
}
