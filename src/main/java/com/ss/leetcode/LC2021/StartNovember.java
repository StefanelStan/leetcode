package com.ss.leetcode.LC2021;

import com.ss.leetcode.LC2021.november.*;
import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;
import java.util.List;

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
            // to be continued ->
        start.recoverBinarySearchTree();
//        start.minimumValueToGetPositiveStepSum();
//        start.binaryTreeTilt();
//        start.minimumAbsoluteDifferenceInBST();
//        start.subtreeOfAnotherTree();
//        start.secondMinimumNodeInABinaryTree();
//        start.checkTwoStringsAreAlmostEquivalent();
//        start.mostBeautifulItemForEachQuery();
//        start.iteratorForCombination();
//        start.findBottomLeftTreeValue();
//        start.detectCapital();
//        start.largestDivisibleSubset();
//        start.evenOddTree();
//        start.sortList();
//        start.uniquePaths();
//        start.summaryRanges();
//        start.nimGame();
//        start.reverseVowelsOfAString();
//        start.findAllNumbersDisappearedInAnArray();
//        start.missingNumber();
//        start.wordPattern();
//        start.powerOfThree();
//        start.isSubsequence();
//        start.singleElementInASortedArray();
//        start.assignCookies();
//        start.numberOfSegmentsInAString();
//        start.longerContiguousSegmentsOf1Than0();
//        start.repeatedSubstringPattern();
//        start.thirdMaximumNumber();
//        start.longestPalindrome();
//        start.licenseKeyFormatting();
//        start.studentAttendanceRecordI();
//        start.reverseStringII();
//        start.intervalListIntersections();
//        start.powerOfFour();
//        start.maximumProductOfThreeNumbers();
//        start.monotonicArray();
//        start.relativeRanks();
//        start.happyNumber();
//        start.countCommonWordsWithOneOccurrence();
//        start.minimumCostHomeComingOfARobotInAGrid();
//        start.minimumNumberOfBucketsCollectRainwaterHouses();
        // missing or hidden description and requirements
//        start.checkCompletenessOfABinaryTree();
//        start.minimumMovesToEqualArrayElementsII(); // not working
//        start.heaters();
//        start.accountsMerge();
//        start.findTargetIndicesAfterSortingArray();
//        start.completeBinaryTreeInserter();
//        start.findTheDifference();
//        start.findAllAnagramsInAString();
//        start.pascalsTriangleII();
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
        TreeNode root3 = new TreeNode(2, new TreeNode(3), new TreeNode(1));

//        rbst.recoverTree(root1);
//        rbst.recoverTree(root2);
        rbst.recoverTree(root3);

//        System.out.println("[1,2,3] == " + TreeNode.inOrder(root1));
//        System.out.println("[1,2,3,4] == " + TreeNode.inOrder(root2));
        System.out.println("[1,2,3] == " + TreeNode.inOrder(root3));
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

    public void iteratorForCombination() {
        IteratorForCombination ifc = new IteratorForCombination("abc", 2);

        System.out.println("ab == " + ifc.next());
        System.out.println("true == " + ifc.hasNext());
        System.out.println("ac == " + ifc.next());
        System.out.println("true == " + ifc.hasNext());
        System.out.println("bc == " + ifc.next());
        System.out.println("false == " + ifc.hasNext());
    }

    public void findBottomLeftTreeValue() {
        FindBottomLeftTreeValue fbltv = new FindBottomLeftTreeValue();

        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
                                      new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));
        TreeNode root3 = new TreeNode(0, null, new TreeNode(-1));

        System.out.println("1 == " + fbltv.findBottomLeftValue(root1));
        System.out.println("7 == " + fbltv.findBottomLeftValue(root2));
        System.out.println("-1 == " + fbltv.findBottomLeftValue(root3));
    }

    public void detectCapital() {
        DetectCapital dc = new DetectCapital();

        System.out.println("true == " + dc.detectCapitalUse("USA"));
        System.out.println("false == " + dc.detectCapitalUse("FlaG"));
    }

    public void largestDivisibleSubset() {
        LargestDivisibleSubset lds = new LargestDivisibleSubset();

        System.out.println("[1,2] == " + lds.largestDivisibleSubset(new int[]{3,2,1}));
        System.out.println("[1,2,4,8] == " + lds.largestDivisibleSubset(new int[]{8,4,2,1}));
        System.out.println("[2,4,8] == " + lds.largestDivisibleSubset(new int[]{8,4,2,3,9}));
    }

    public void evenOddTree() {
        EvenOddTree eot = new EvenOddTree();

        TreeNode root1 = new TreeNode(1, new TreeNode(10, new TreeNode(3, new TreeNode(12), new TreeNode(8)), null),
            new TreeNode(4, new TreeNode(7, new TreeNode(6), null), new TreeNode(9, null, new TreeNode(2))));
        TreeNode root2 = new TreeNode(5, new TreeNode(4, new TreeNode(3), new TreeNode(3)), new TreeNode(2, new TreeNode(7), null));
        TreeNode root3 = new TreeNode(5, new TreeNode(9, new TreeNode(3), new TreeNode(5)), new TreeNode(1, new TreeNode(7), null));
        TreeNode root4 = new TreeNode(11, new TreeNode(8, new TreeNode(1, new TreeNode(30, new TreeNode(17), null), new TreeNode(20)), new TreeNode(3, new TreeNode(18), new TreeNode(16))),
            new TreeNode(6, new TreeNode(9, new TreeNode(12), new TreeNode(10)), new TreeNode(11, new TreeNode(4), new TreeNode(2))));

        System.out.println("true == " + eot.isEvenOddTree(root1));
        System.out.println("false == " + eot.isEvenOddTree(root2));
        System.out.println("false == " + eot.isEvenOddTree(root3));
        System.out.println("true == " + eot.isEvenOddTree(new TreeNode(1)));
        System.out.println("true == " + eot.isEvenOddTree(root4));
    }

    public void sortList() {
        SortList sl = new SortList();

        ListNode head1 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode head2 = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

//        System.out.println("[1,2,3,4] == " + sl.sortList(head1).getAsList());
//        System.out.println("[-1,0,3,4,5] == " + sl.sortList(head2).getAsList());
//        System.out.println("[] == " + sl.sortList(null));
//        System.out.println("[1] == " + sl.sortList(new ListNode(1)));
        System.out.println("[1,2,3,4] == " + sl.sortList(head3).getAsList());
    }

    public void uniquePaths() {
        UniquePaths up = new UniquePaths();

        System.out.println("28 == " + up.uniquePaths(3,7));
        System.out.println("3 == " + up.uniquePaths(3,2));
        System.out.println("28 == " + up.uniquePaths(7,3));
        System.out.println("6 == " + up.uniquePaths(3,3));
    }

    public void summaryRanges() {
        SummaryRanges sr = new SummaryRanges();

        System.out.println("[0->2, 4->5, 7] == " + sr.summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println("[0, 2->4, 6, 8->9] == " + sr.summaryRanges(new int[]{0,2,3,4,6,8,9}));
        System.out.println("[] == " + sr.summaryRanges(new int[0]));
        System.out.println("[-1] == " + sr.summaryRanges(new int[]{-1}));
    }

    public void nimGame() {
        NimGame ng = new NimGame();

        System.out.println("false == " + ng.canWinNim(4));
        System.out.println("true == " + ng.canWinNim(1));
        System.out.println("true == " + ng.canWinNim(2));
    }

    public void reverseVowelsOfAString() {
        ReverseVowelsOfAString rvoas = new ReverseVowelsOfAString();

        System.out.println("holle == " + rvoas.reverseVowels("hello"));
        System.out.println("leotcede == " + rvoas.reverseVowels("leetcode"));
    }

    public void findAllNumbersDisappearedInAnArray() {
        FindAllNumbersDisappearedInAnArray fandiaa = new FindAllNumbersDisappearedInAnArray();

        System.out.println("[5,6] == " + fandiaa.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println("[2] == " + fandiaa.findDisappearedNumbers(new int[]{1,1}));
    }

    public void missingNumber() {
        MissingNumber mn = new MissingNumber();

        System.out.println("2 == " + mn.missingNumber(new int[]{3,0,1}));
        System.out.println("2 == " + mn.missingNumber(new int[]{0,1}));
        System.out.println("8 == " + mn.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println("1 == " + mn.missingNumber(new int[]{0}));
    }

    public void wordPattern() {
        WordPattern wp = new WordPattern();

        System.out.println("true == " + wp.wordPattern("abba", "dog cat cat dog"));
        System.out.println("false == " + wp.wordPattern("abba", "dog cat cat fish"));
        System.out.println("false == " + wp.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println("false == " + wp.wordPattern("abba", "dog dog dog dog"));
    }

    public void powerOfThree() {
        PowerOfThree pot = new PowerOfThree();

        System.out.println("true == " + pot.isPowerOfThree(27));
        System.out.println("false == " + pot.isPowerOfThree(0));
        System.out.println("true == " + pot.isPowerOfThree(9));
        System.out.println("false == " + pot.isPowerOfThree(45));
        System.out.println("false == " + pot.isPowerOfThree(19684));
    }

    public void isSubsequence() {
        IsSubsequence is = new IsSubsequence();

        System.out.println("true == " + is.isSubsequence("abc", "ahbgdc"));
        System.out.println("false == " + is.isSubsequence("axc", "ahbgdc"));
    }

    public void singleElementInASortedArray() {
        SingleElementInASortedArray seiasa = new SingleElementInASortedArray();

        System.out.println("2 == " + seiasa.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println("10 == " + seiasa.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        System.out.println("12 == " + seiasa.singleNonDuplicate(new int[]{0,0,1,1,3,3,8,8,9,9,11,11,12,13,13,14,14}));
        System.out.println("0 == " + seiasa.singleNonDuplicate(new int[]{0,1,1,3,3,8,8,9,9,11,11,12,12,13,13,14,14}));
        System.out.println("14 == " + seiasa.singleNonDuplicate(new int[]{0,0,1,1,3,3,8,8,9,9,11,11,12,12,13,13,14}));
    }

    public void assignCookies() {
        AssignCookies ac = new AssignCookies();

        System.out.println("1 == " + ac.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println("2 == " + ac.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }

    public void numberOfSegmentsInAString() {
        NumberOfSegmentsInAString nosias = new NumberOfSegmentsInAString();

        System.out.println("5 == " + nosias.countSegments("Hello, my name is John"));
        System.out.println("1 == " + nosias.countSegments("Hello"));
        System.out.println("4 == " + nosias.countSegments("love live! mu'sic forever"));
        System.out.println("1 == " + nosias.countSegments("0"));
        System.out.println("0 == " + nosias.countSegments(""));
    }

    public void longerContiguousSegmentsOf1Than0() {
        LongerContiguousSegmentsOf1Than0 lcso1t0 = new LongerContiguousSegmentsOf1Than0();

        System.out.println("true == " + lcso1t0.checkZeroOnes("1101"));
        System.out.println("false == " + lcso1t0.checkZeroOnes("111000"));
        System.out.println("false == " + lcso1t0.checkZeroOnes("110100010"));
    }

    public void repeatedSubstringPattern() {
        RepeatedSubstringPattern rsp = new RepeatedSubstringPattern();

        System.out.println("true == " + rsp.repeatedSubstringPattern("abab"));
        System.out.println("false == " + rsp.repeatedSubstringPattern("aba"));
        System.out.println("true == " + rsp.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println("false == " + rsp.repeatedSubstringPattern("a"));
        System.out.println("true == " + rsp.repeatedSubstringPattern("babbabbabbabbab"));
        System.out.println("false == " + rsp.repeatedSubstringPattern("aabaaba"));
    }

    public void thirdMaximumNumber() {
        ThirdMaximumNumber tmm = new ThirdMaximumNumber();

        System.out.println("1 == " + tmm.thirdMax(new int[]{3,2,1}));
        System.out.println("2 == " + tmm.thirdMax(new int[]{1,2}));
        System.out.println("1 == " + tmm.thirdMax(new int[]{2,2,3,1}));
        System.out.println("5 == " + tmm.thirdMax(new int[]{5,2,2}));
    }

    public void longestPalindrome() {
        LongestPalindrome lp = new LongestPalindrome();

        System.out.println("7 == " + lp.longestPalindrome("abccccdd"));
        System.out.println("1 == " + lp.longestPalindrome("a"));
        System.out.println("2 == " + lp.longestPalindrome("bb"));
    }

    public void licenseKeyFormatting() {
        LicenseKeyFormatting lkf = new LicenseKeyFormatting();

        System.out.println("5F3Z-2E9W == " + lkf.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println("2-5G-3J == " + lkf.licenseKeyFormatting("2-5g-3-J", 2));
    }

    public void studentAttendanceRecordI() {
        StudentAttendanceRecordI sari = new StudentAttendanceRecordI();

        System.out.println("true == " + sari.checkRecord("PPALLP"));
        System.out.println("false == " + sari.checkRecord("PPALLL"));
    }

    public void reverseStringII() {
        ReverseStringII rsii = new ReverseStringII();

        System.out.println("bacdfeg == " + rsii.reverseStr("abcdefg", 2));
        System.out.println("bacd == " + rsii.reverseStr("abcd", 2));
    }

    public void intervalListIntersections() {
        IntervalListIntersections ili = new IntervalListIntersections();

        System.out.println("[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]] == " + Arrays.deepToString(
            ili.intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}}, new int[][]{{1,5},{8,12},{15,24},{25,26}})));
        System.out.println("[] == " + Arrays.deepToString(ili.intervalIntersection(new int[][]{{1,3},{5,9}}, new int[0][0])));
        System.out.println("[] == " + Arrays.deepToString(ili.intervalIntersection(new int[0][0], new int[][]{{1,3},{5,9}})));
        System.out.println("[3,7] == " + Arrays.deepToString(ili.intervalIntersection(new int[][]{{1,7}}, new int[][]{{3,10}})));
    }

    public void powerOfFour() {
        PowerOfFour pof = new PowerOfFour();

        System.out.println("true == " + pof.isPowerOfFour(16));
        System.out.println("false == " + pof.isPowerOfFour(5));
        System.out.println("true == " + pof.isPowerOfFour(1));
    }

    public void maximumProductOfThreeNumbers() {
        MaximumProductOfThreeNumbers mpotn = new MaximumProductOfThreeNumbers();

        System.out.println("6 == " + mpotn.maximumProduct(new int[]{1,2,3}));
        System.out.println("24 == " + mpotn.maximumProduct(new int[]{1,2,3,4}));
        System.out.println("-6 == " + mpotn.maximumProduct(new int[]{-1,-2,-3}));
    }

    public void monotonicArray() {
        MonotonicArray ma = new MonotonicArray();

//        System.out.println("true == " + ma.isMonotonic(new int[]{1,2,2,3}));
//        System.out.println("true == " + ma.isMonotonic(new int[]{6,5,4,4}));
//        System.out.println("false == " + ma.isMonotonic(new int[]{1,3,2}));
//        System.out.println("true == " + ma.isMonotonic(new int[]{1,2,4,5}));
//        System.out.println("true == " + ma.isMonotonic(new int[]{1,1,1}));
        System.out.println("false == " + ma.isMonotonic(new int[]{5,3,2,4,1}));

    }

    public void relativeRanks() {
        RelativeRanks rr = new RelativeRanks();

        System.out.println("[Gold Medal,Silver Medal,Bronze Medal,4,5] == " + Arrays.toString(rr.findRelativeRanks(new int[]{5,4,3,2,1})));
        System.out.println("[Gold Medal,5,Bronze Medal,Silver Medal,4] == " + Arrays.toString(rr.findRelativeRanks(new int[]{10,3,8,9,4})));
    }

    public void happyNumber() {
        HappyNumber hn = new HappyNumber();

        System.out.println("true == " + hn.isHappy(19));
        System.out.println("false == " + hn.isHappy(2));
    }

    public void countCommonWordsWithOneOccurrence() {
        CountCommonWordsWithOneOccurrence ccwwoo = new CountCommonWordsWithOneOccurrence();

        System.out.println("2 == " + ccwwoo.countWords(new String[]{"leetcode","is","amazing","as","is"}, new String[]{"amazing","leetcode","is"}));
        System.out.println("0 == " + ccwwoo.countWords(new String[]{"b","bb","bbb"}, new String[]{"a","aa","aaa"}));
        System.out.println("1 == " + ccwwoo.countWords(new String[]{"a","ab"}, new String[]{"a","a","a","ab"}));
    }

    public void minimumCostHomeComingOfARobotInAGrid() {
        MinimumCostHomeComingOfARobotInAGrid mchmcoariag = new MinimumCostHomeComingOfARobotInAGrid();

        System.out.println("18 == " + mchmcoariag.minCost(new int[]{1,0}, new int[]{2,3}, new int[]{5,4,3}, new int[]{8,2,6,7}));
        System.out.println("0 == " + mchmcoariag.minCost(new int[]{0,0}, new int[]{0,0}, new int[]{5}, new int[]{26}));
    }

    public void minimumNumberOfBucketsCollectRainwaterHouses() {
        MinimumNumberOfBucketsCollectRainwaterHouses mnobcrh = new MinimumNumberOfBucketsCollectRainwaterHouses();

        System.out.println("2 == " + mnobcrh.minimumBuckets("H..H"));
        System.out.println("2 == " + mnobcrh.minimumBuckets("..H.H..H.H"));
        System.out.println("1 == " + mnobcrh.minimumBuckets(".H.H."));
        System.out.println("-1 == " + mnobcrh.minimumBuckets(".HHH."));
        System.out.println("-1 == " + mnobcrh.minimumBuckets("H"));
        System.out.println("3 == " + mnobcrh.minimumBuckets(".HH.H.H.H.."));
        System.out.println("3 == " + mnobcrh.minimumBuckets("...HH...H."));
        System.out.println("3 == " + mnobcrh.minimumBuckets("...HH...H.."));
        System.out.println("3 == " + mnobcrh.minimumBuckets("...HH...H.."));
        System.out.println("2 == " + mnobcrh.minimumBuckets(".H..H"));
    }

    public void checkCompletenessOfABinaryTree() {
        CheckCompletenessOfABinaryTree ccoabt = new CheckCompletenessOfABinaryTree();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(5), null), new TreeNode(3, new TreeNode(7), new TreeNode(8)));
        TreeNode root4 = new TreeNode(1, null, new TreeNode(2));
        TreeNode root5 = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(7), new TreeNode(8)));

        System.out.println("true == " + ccoabt.isCompleteTree(root1));
        System.out.println("false == " + ccoabt.isCompleteTree(root2));
        System.out.println("false == " + ccoabt.isCompleteTree(root3));
        System.out.println("false == " + ccoabt.isCompleteTree(root4));
        System.out.println("false == " + ccoabt.isCompleteTree(root5));
    }

    public void minimumMovesToEqualArrayElementsII() {
        MinimumMovesToEqualArrayElementsII mmteaeii = new MinimumMovesToEqualArrayElementsII();

        System.out.println("2 == " + mmteaeii.minMoves2(new int[]{1,2,3}));
        System.out.println("16 == " + mmteaeii.minMoves2(new int[]{1,10,2,9}));
        System.out.println("44 == " + mmteaeii.minMoves2(new int[]{10,11,-10,-11, -12}));
    }

    public void heaters() {
        Heaters h = new Heaters();

        System.out.println("1 == " + h.findRadius(new int[]{1,2,3}, new int[]{2}));
        System.out.println("1 == " + h.findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
        System.out.println("3 == " + h.findRadius(new int[]{1,5}, new int[]{2}));
        System.out.println("14 == " + h.findRadius(new int[]{6,3,9,1,2,12,14,18,5,44}, new int[]{23,17,21,19,8,30}));
        System.out.println("0 == " + h.findRadius(new int[]{1,2,3,4,5,6,7,8,9,10,4}, new int[]{1,2,3,4,5,6,7,8,9,10,4}));

    }

    public void accountsMerge() {
        AccountsMerge am = new AccountsMerge();

        System.out.println("[[John, john00@mail.com, john_newyork@mail.com, johnsmith@mail.com],[Mary, mary@mail.com ],[ John , johnnybravo@mail.com]] == " +
            am.accountsMerge(List.of(List.of("John","johnsmith@mail.com","john_newyork@mail.com"), List.of("John","johnsmith@mail.com","john00@mail.com"),
                List.of("Mary","mary@mail.com"), List.of("John","johnnybravo@mail.com"))));

        System.out.println("[[Ethan, Ethan0@m.co, Ethan4@m.co , Ethan5@m.co ],[Gabe, Gabe0@m.co , Gabe1@m.co , Gabe3@m.co ]," +
            "[Hanzo, Hanzo0@m.co, Hanzo1@m.co, Hanzo3@m.co],[Kevin, Kevin0@m.co, Kevin3@m.co, Kevin5@m.co],[Fern,Fern0@m.co,Fern1@m.co,Fern5@m.co]] == " +
            am.accountsMerge(List.of(List.of("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"), List.of("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"),
                List.of("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"), List.of("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"),
                List.of("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"))));
    }

    public void findTargetIndicesAfterSortingArray() {
        FindTargetIndicesAfterSortingArray ftiasa = new FindTargetIndicesAfterSortingArray();

        System.out.println("[1,2] == " + ftiasa.targetIndices(new int[]{1,2,5,2,3}, 2));
        System.out.println("[3] == " + ftiasa.targetIndices(new int[]{1,2,5,2,3}, 3));
        System.out.println("[4] == " + ftiasa.targetIndices(new int[]{1,2,5,2,3}, 5));
        System.out.println("[] == " + ftiasa.targetIndices(new int[]{1,2,5,2,3}, 4));
    }

    public void completeBinaryTreeInserter() {
        CompleteBinaryTreeInserter cbti = new CompleteBinaryTreeInserter(new TreeNode(1, new TreeNode(2), null));

        System.out.println("1 == " + cbti.insert(3));
        System.out.println("2 == " + cbti.insert(4));
        System.out.println("[1,2,4,3] == " + TreeNode.preOrder(cbti.get_root()));

    }

    public void findTheDifference() {
        FindTheDifference ftd = new FindTheDifference();

        System.out.println("e == " + ftd.findTheDifference("abcd", "abcde"));
        System.out.println("y == " + ftd.findTheDifference("", "y"));
        System.out.println("a == " + ftd.findTheDifference("a", "aa"));
        System.out.println("a == " + ftd.findTheDifference("ae", "aea"));
    }

    public void findAllAnagramsInAString() {
        FindAllAnagramsInAString faaias = new FindAllAnagramsInAString();

        System.out.println("[0,6] == " + faaias.findAnagrams("cbaebabacd", "abc"));
        System.out.println("[0,1,2] == " + faaias.findAnagrams("abab", "ab"));
    }

    public void pascalsTriangleII() {
        PascalsTriangleII ptii = new PascalsTriangleII();

        System.out.println("[1,3,3,1] == " + ptii.getRow(3));
        System.out.println("[1] == " + ptii.getRow(0));
        System.out.println("[1,1] == " + ptii.getRow(1));
    }
}