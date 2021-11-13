package com.ss.leetcode;

import com.ss.leetcode.november.ArrangingCoins;
import com.ss.leetcode.november.BinaryTreePaths;
import com.ss.leetcode.november.BinaryTreeRightSideView;
import com.ss.leetcode.november.BinaryTreeTilt;
import com.ss.leetcode.november.CheckNumberIsSumPowersOfThree;
import com.ss.leetcode.november.CheckTwoStringsAreAlmostEquivalent;
import com.ss.leetcode.november.ConsecutiveCharacters;
import com.ss.leetcode.november.ContainsDuplicateII;
import com.ss.leetcode.november.DeleteNodeInABST;
import com.ss.leetcode.november.ElementMore25InSortedArray;
import com.ss.leetcode.november.FindDuplicateFileInSystem;
import com.ss.leetcode.november.FindLargestValueInEachTreeRow;
import com.ss.leetcode.november.InsufficientNodesInRootToLeafPaths;
import com.ss.leetcode.november.KClosestPointsToOrigin;
import com.ss.leetcode.november.KthDistinctStringOnAnArray;
import com.ss.leetcode.november.LongestNiceSubstring;
import com.ss.leetcode.november.MinimumAbsoluteDifferenceInBST;
import com.ss.leetcode.november.MinimumDistanceBetweenBSTNodes;
import com.ss.leetcode.november.MinimumIndexSumOfTwoLists;
import com.ss.leetcode.november.MinimumValueToGetPositiveStepSum;
import com.ss.leetcode.november.MostBeautifulItemForEachQuery;
import com.ss.leetcode.november.MostFrequentSubtreeSum;
import com.ss.leetcode.november.MultiplyStrings;
import com.ss.leetcode.november.NumberValidWordsSentence;
import com.ss.leetcode.november.RankTransformOfAnArray;
import com.ss.leetcode.november.RecoverBinarySearchTree;
import com.ss.leetcode.november.ReformatDate;
import com.ss.leetcode.november.SecondMinimumNodeInABinaryTree;
import com.ss.leetcode.november.SimpleBankSystem;
import com.ss.leetcode.november.SingleNumberIII;
import com.ss.leetcode.november.SubtreeOfAnotherTree;
import com.ss.leetcode.november.SumOfAbsoluteDiffSortedArray;
import com.ss.leetcode.november.SurroundedRegions;
import com.ss.leetcode.november.UniqueBinarySearchTrees;
import com.ss.leetcode.shared.TreeNode;
import com.sun.source.tree.YieldTree;

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
//        start.multiplyStrings();
//        start.uniqueBinarySearchTrees();
//        start.checkIfNumberIsASumOfPowersOfThree();
//        start.longestNiceSubstring();
//        start.minimumIndexSumOfTwoLists();
//        start.containsDuplicateII();
//        start.simpleBankSystem();
//        start.findDuplicateFileInSystem();
//        start.reformatDate();
//        start.findLargestValueInEachTreeRow();
//        start.mostFrequentSubtreeSum();
//        start.minimumDistanceBetweenBSTNodes();
//        start.elementMore25InSortedArray();
//        start.rankTransformOfAnArray();
        // to be continued -> start.recoverBinarySearchTree();
//        start.minimumValueToGetPositiveStepSum();
//        start.binaryTreeTilt();
//        start.minimumAbsoluteDifferenceInBST();
//        start.subtreeOfAnotherTree();
//        start.secondMinimumNodeInABinaryTree();
//        start.checkTwoStringsAreAlmostEquivalent();
        start.mostBeautifulItemForEachQuery();
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
        System.out.println("[3,1,4] == " + TreeNode.preOrder(dniabst.deleteNode(root5, 2)));
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

        System.out.println("[1,2,3,4,7,8,9,14] == " + TreeNode.preOrder(inirtlp.sufficientSubset(root1, 1)));
        System.out.println("[5,4,8,11,17,4,7,5] == " + TreeNode.preOrder(inirtlp.sufficientSubset(root2, 22)));
        System.out.println("[1,-3,4] == " + TreeNode.preOrder(inirtlp.sufficientSubset(root3, -1)));
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

    public void uniqueBinarySearchTrees() {
        UniqueBinarySearchTrees ubst = new UniqueBinarySearchTrees();

        System.out.println("5 == " + ubst.numTrees(3));
        System.out.println("1430 == " + ubst.numTrees(8));
        System.out.println("1767263190 == " + ubst.numTrees(19));
    }

    public void checkIfNumberIsASumOfPowersOfThree() {
        CheckNumberIsSumPowersOfThree cnispot = new CheckNumberIsSumPowersOfThree();

        System.out.println("true == " + cnispot.checkPowersOfThree(12));
        System.out.println("true == " + cnispot.checkPowersOfThree(91));
        System.out.println("false == " + cnispot.checkPowersOfThree(21));
    }

    public void longestNiceSubstring() {
        LongestNiceSubstring lns = new LongestNiceSubstring();

        System.out.println("aAa == " + lns.longestNiceSubstring("YazaAay"));
        System.out.println("Bb == " + lns.longestNiceSubstring("Bb"));
        System.out.println(" == " + lns.longestNiceSubstring("c"));
        System.out.println("dD == " + lns.longestNiceSubstring("dDzeE"));
    }

    public void minimumIndexSumOfTwoLists() {
        MinimumIndexSumOfTwoLists misotl = new MinimumIndexSumOfTwoLists();

        String[] list1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        String[] list3 = new String[]{"KFC","Shogun","Burger King"};
        String[] list4 = new String[]{"KFC","Burger King","Tapioca Express","Shogun"};
        String[] list5 = new String[]{"KNN","KFC","Burger King","Tapioca Express","Shogun"};

        System.out.println("[Shogun] == " + Arrays.toString(misotl.findRestaurant(list1, list2)));
        System.out.println("[Shogun] == " + Arrays.toString(misotl.findRestaurant(list1, list3)));
        System.out.println("[KFC,Burger King, Tapioca Express,Shogun] == " + Arrays.toString(misotl.findRestaurant(list1, list4)));
        System.out.println("[KFC,Burger King, Tapioca Express,Shogun] == " + Arrays.toString(misotl.findRestaurant(list1, list5)));
        System.out.println("[KFC] == " + Arrays.toString(misotl.findRestaurant(new String[]{"KFC"}, new String[]{"KFC"})));
    }

    public void containsDuplicateII() {
        ContainsDuplicateII cdii = new ContainsDuplicateII();

        System.out.println("true == " + cdii.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println("true == " + cdii.containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println("false == " + cdii.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
        System.out.println("true == " + cdii.containsNearbyDuplicate(new int[]{0,1,2,3,4,0,0,7,8,9,10,11,12,0}, 1));

    }

    public void simpleBankSystem() {
        SimpleBankSystem sbs = new SimpleBankSystem(new long[]{10, 100, 20, 50, 30});

        System.out.println("true == " + sbs.withdraw(3,10));
        System.out.println("true == " + sbs.transfer(5,1,20));
        System.out.println("true == " + sbs.deposit(5,20));
        System.out.println("false == " + sbs.transfer(3,4,15));
        System.out.println("false == " + sbs.withdraw(10,50));
    }

    public void findDuplicateFileInSystem() {
        FindDuplicateFileInSystem fdfis = new FindDuplicateFileInSystem();

        System.out.println("[[root/a/2.txt, root/c/d/4.txt, root/4.txt],[root/a/1.txt,root/c/3.txt]] == "
            + fdfis.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"}));

        System.out.println("[[root/a/2.txt,root/c/d/4.txt],[root/a/1.txt,root/c/3.txt]] == "
            + fdfis.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"}));
    }

    public void reformatDate() {
        ReformatDate rd = new ReformatDate();

        System.out.println("2052-10-20 == "+ rd.reformatDate("20th Oct 2052"));
        System.out.println("1933-06-06 == "+ rd.reformatDate("6th Jun 1933"));
        System.out.println("1960-05-26 == "+ rd.reformatDate("26th May 1960"));
    }

    public void findLargestValueInEachTreeRow() {
        FindLargestValueInEachTreeRow flvier = new FindLargestValueInEachTreeRow();

        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(1, null, new TreeNode(2));

        System.out.println("[1,3,9] == " + flvier.largestValues(root1));
        System.out.println("[1,3] == " + flvier.largestValues(root2));
        System.out.println("[1] == " + flvier.largestValues(root3));
        System.out.println("[1,2] == " + flvier.largestValues(root4));
        System.out.println("[] == " + flvier.largestValues(null));
    }

    public void mostFrequentSubtreeSum() {
        MostFrequentSubtreeSum mfss = new MostFrequentSubtreeSum();

        TreeNode root1 = new TreeNode(5, new TreeNode(2), new TreeNode(-3));
        TreeNode root2 = new TreeNode(5, new TreeNode(2), new TreeNode(-5));

        System.out.println("[2,-3,4] == " + Arrays.toString(mfss.findFrequentTreeSum(root1)));
        System.out.println("[2] == " + Arrays.toString(mfss.findFrequentTreeSum(root2)));
    }

    public void minimumDistanceBetweenBSTNodes() {
        MinimumDistanceBetweenBSTNodes mdbbstn = new MinimumDistanceBetweenBSTNodes();

        TreeNode root1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        TreeNode root2 = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));

        System.out.println("1 == " + mdbbstn.minDiffInBST(root1));
        System.out.println("1 == " + mdbbstn.minDiffInBST(root2));
    }

    public void elementMore25InSortedArray() {
        ElementMore25InSortedArray em25isa = new ElementMore25InSortedArray();

        System.out.println("6 == " + em25isa.findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
        System.out.println("1 == " + em25isa.findSpecialInteger(new int[]{1,1}));
    }

    public void rankTransformOfAnArray() {
        RankTransformOfAnArray rtoaa = new RankTransformOfAnArray();

        System.out.println("[4,1,2,3] == " + Arrays.toString(rtoaa.arrayRankTransform(new int[]{40,10,20,30})));
        System.out.println("[1,1,1] == " + Arrays.toString(rtoaa.arrayRankTransform(new int[]{100,100,100})));
        System.out.println("[5,3,4,2,8,6,7,1,3] == " + Arrays.toString(rtoaa.arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12})));
    }

    public void recoverBinarySearchTree() {
        RecoverBinarySearchTree rbst = new RecoverBinarySearchTree();

        TreeNode root1 = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        TreeNode root2 = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));

        rbst.recoverTree(root1);
        rbst.recoverTree(root2);
        System.out.println("[3,1,2] == " + TreeNode.preOrder(root1));
        System.out.println("[2,1,4,3] == " + TreeNode.preOrder(root2));
    }

    public void minimumValueToGetPositiveStepSum() {
        MinimumValueToGetPositiveStepSum mvtgpss = new MinimumValueToGetPositiveStepSum();

        System.out.println("5 == " + mvtgpss.minStartValue(new int[]{-3,2,-3,4,2}));
        System.out.println("1 == " + mvtgpss.minStartValue(new int[]{1,2}));
        System.out.println("5 == " + mvtgpss.minStartValue(new int[]{1,-2,-3}));
    }

    public void binaryTreeTilt() {
        BinaryTreeTilt btt = new BinaryTreeTilt();

        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root2 = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(5)), new TreeNode(9, null, new TreeNode(7)));
        TreeNode root3 = new TreeNode(21, new TreeNode(7, new TreeNode(1, new TreeNode(3), new TreeNode(3)), new TreeNode(1)),
            new TreeNode(14, new TreeNode(2), new TreeNode(2)));

        System.out.println("1 == " + btt.findTilt(root1));
        System.out.println("15 == " + btt.findTilt(root2));
        System.out.println("9 == " + btt.findTilt(root3));
    }

    public void minimumAbsoluteDifferenceInBST() {
        MinimumAbsoluteDifferenceInBST madibst = new MinimumAbsoluteDifferenceInBST();

        TreeNode root1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        TreeNode root2 = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));

        System.out.println("1 == " + madibst.getMinimumDifference(root1));
        System.out.println("1 == " + madibst.getMinimumDifference(root2));
    }

    public void subtreeOfAnotherTree() {
        SubtreeOfAnotherTree soat = new SubtreeOfAnotherTree();

        TreeNode root1 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode root2= new TreeNode(4, new TreeNode(1), new TreeNode(2));
        TreeNode root3 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)), new TreeNode(5));
        TreeNode root4 = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        System.out.println("true == " + soat.isSubtree(root1, root2));
        System.out.println("false == " + soat.isSubtree(root3, root4));
    }

    public void secondMinimumNodeInABinaryTree() {
        SecondMinimumNodeInABinaryTree smniabt = new SecondMinimumNodeInABinaryTree();

        TreeNode root1 = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        TreeNode root2 = new TreeNode(2, new TreeNode(2), new TreeNode(2));

        System.out.println("5 == " + smniabt.findSecondMinimumValue(root1));
        System.out.println("-1 == " + smniabt.findSecondMinimumValue(root2));
    }

    public void checkTwoStringsAreAlmostEquivalent() {
        CheckTwoStringsAreAlmostEquivalent ctsaae = new CheckTwoStringsAreAlmostEquivalent();

        System.out.println("false == " + ctsaae.checkAlmostEquivalent("aaaa", "bccb"));
        System.out.println("true == " + ctsaae.checkAlmostEquivalent("abcdeef", "abaaacc"));
        System.out.println("true == " + ctsaae.checkAlmostEquivalent("cccddabba", "babababab"));
    }

    public void mostBeautifulItemForEachQuery() {
        MostBeautifulItemForEachQuery mbifeq = new MostBeautifulItemForEachQuery();

        System.out.println("[2,4,5,5,6,6] == " + Arrays.toString(mbifeq.maximumBeauty(new int[][]{{1,2}, {3,2},{2,4},{5,6},{3,5}},
                                            new int[]{1,2,3,4,5,6})));
        System.out.println("[4] == " + Arrays.toString(mbifeq.maximumBeauty(new int[][]{{1,2}, {1,2},{1,3},{1,4}}, new int[]{1})));
        System.out.println("[0] == " + Arrays.toString(mbifeq.maximumBeauty(new int[][]{{10,10000}}, new int[]{5})));
    }
}

