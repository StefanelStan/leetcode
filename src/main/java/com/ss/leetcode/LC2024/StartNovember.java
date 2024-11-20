package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.november.CountAlternatingSubarrays;
import com.ss.leetcode.LC2024.november.FindIfArrayCanBeSorted;
import com.ss.leetcode.LC2024.november.FindTheMaximumAchievableNumber;
import com.ss.leetcode.LC2024.november.FindThePowerOfKSizeSubarraysI;
import com.ss.leetcode.LC2024.november.KthLargestPerfectSubtreeSizeInBinaryTree;
import com.ss.leetcode.LC2024.november.LargestCombinationWithBitwiseANDGreaterThanZero;
import com.ss.leetcode.LC2024.november.MakeASquareWithTheSameColor;
import com.ss.leetcode.LC2024.november.MaximumEqualFrequency;
import com.ss.leetcode.LC2024.november.MaximumNumberOfOperationsToMoveOnesToTheEnd;
import com.ss.leetcode.LC2024.november.MinimizeMalwareSpreadII;
import com.ss.leetcode.LC2024.november.MinimumAbsoluteDifferenceBetweenElementsWithConstraint;
import com.ss.leetcode.LC2024.november.MinimumSumOfMountainTripletsII;
import com.ss.leetcode.LC2024.november.PancakeSorting;
import com.ss.leetcode.LC2024.november.PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList;
import com.ss.leetcode.LC2024.november.PrimeSubtractionOperation;
import com.ss.leetcode.LC2024.november.ShortestSubarrayWithORAtLeastKII;
import com.ss.leetcode.LC2024.november.StringCompressionIII;
import com.ss.leetcode.LC2024.november.TakeKOfEachCharacterFromLeftAndRight;
import com.ss.leetcode.shared.TreeNode;
import java.util.Arrays;
import java.util.List;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

//        start.countAlternatingSubarrays();
//        start.minimizeMalwareSpreadII();
//        start.kthLargestPerfectSubtreeSizeInBinaryTree();
//        start.stringCompressionIII();
//        start.peopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList();
//        start.minimumAbsoluteDifferenceBetweenElementsWithConstraint();
//        start.findTheMaximumAchievableNumber();
//        start.maximumEqualFrequency();
//        start.findIfArrayCanBeSorted();
//        start.largestCombinationWithBitwiseANDGreaterThanZero();
//        start.shortestSubarrayWithORAtLeastKII();
//        start.primeSubtractionOperation();
//        start.minimumSumOfMountainTripletsII();
//        start.makeASquareWithTheSameColor();
//        start.maximumNumberOfOperationsToMoveOnesToTheEnd();
//        start.findThePowerOfKSizeSubarraysI();
//        start.pancakeSorting();
        start.takeKOfEachCharacterFromLeftAndRight();
    }

    public void countAlternatingSubarrays() {
        CountAlternatingSubarrays cas = new CountAlternatingSubarrays();

        System.out.println("5 == " + cas.countAlternatingSubarrays(new int[]{0,1,1,1}));
        System.out.println("10 == " + cas.countAlternatingSubarrays(new int[]{1,0,1,0}));
        System.out.println("1 == " + cas.countAlternatingSubarrays(new int[]{1}));
        System.out.println("3 == " + cas.countAlternatingSubarrays(new int[]{0,1}));
        System.out.println("2 == " + cas.countAlternatingSubarrays(new int[]{1,1}));
        System.out.println("5 == " + cas.countAlternatingSubarrays(new int[]{0,0,1,1}));
        System.out.println("129 == " + cas.countAlternatingSubarrays(new int[]{0,1,1,1,1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0}));
        System.out.println("71 == " + cas.countAlternatingSubarrays(new int[]{0,0,0,0,0,1,0,0,0,1,0,1,0,1,1,0,0,1,0,1,0,1,0,1}));
    }

    public void minimizeMalwareSpreadII() {
        MinimizeMalwareSpreadII mmsii = new MinimizeMalwareSpreadII();

        System.out.println("0 == " + mmsii.minMalwareSpread(new int[][]{{1,1,0}, {1,1,0},{0,0,1}}, new int[]{0,1}));
        System.out.println("1 == " + mmsii.minMalwareSpread(new int[][]{{1,1,0}, {1,1,1},{0,1,1}}, new int[]{0,1}));
        System.out.println("1 == " + mmsii.minMalwareSpread(new int[][]{{1,1,0,0}, {1,1,1,0},{0,1,1,1},{0,0,1,1}}, new int[]{0,1}));
    }

    public void kthLargestPerfectSubtreeSizeInBinaryTree() {
        KthLargestPerfectSubtreeSizeInBinaryTree klpssibt = new KthLargestPerfectSubtreeSizeInBinaryTree();

        TreeNode root1 = new TreeNode(5, new TreeNode(3, new TreeNode(5, new TreeNode(1), new TreeNode(8)), new TreeNode(2)),
            new TreeNode(6, new TreeNode(5, new TreeNode(6), new TreeNode(8)), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        TreeNode root3 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));

        System.out.println("3 == " + klpssibt.kthLargestPerfectSubtree(root1, 2));
        System.out.println("7 == " + klpssibt.kthLargestPerfectSubtree(root2, 1));
        System.out.println("-1 == " + klpssibt.kthLargestPerfectSubtree(root3, 3));
    }

    public void stringCompressionIII() {
        StringCompressionIII sciii = new StringCompressionIII();

        System.out.println("1a1b1c1d1e == " + sciii.compressedString("abcde"));
        System.out.println("9a5a2b == " + sciii.compressedString("aaaaaaaaaaaaaabb"));
        System.out.println("1a == " + sciii.compressedString("a"));
        System.out.println("9a4a9b6b6a8b == " + sciii.compressedString("aaaaaaaaaaaaabbbbbbbbbbbbbbbaaaaaabbbbbbbb"));
        System.out.println("7b5a1b7a7b9a7a2b5a1b == " + sciii.compressedString("bbbbbbbaaaaabaaaaaaabbbbbbbaaaaaaaaaaaaaaaabbaaaaab"));
        System.out.println("1a1b1c1d1e1f == " + sciii.compressedString("abcdef"));
    }

    public void peopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList() {
        PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList pwlofcinasoal = new PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList();

        System.out.println("[0,1,4] == " + pwlofcinasoal.peopleIndexes(List.of(List.of("leetcode","google","facebook"), List.of("google","microsoft"), List.of("google","facebook"), List.of("google"), List.of("amazon"))));
        System.out.println("[0,1] == " + pwlofcinasoal.peopleIndexes(List.of(List.of("leetcode","google","facebook"), List.of("leetcode","amazon"), List.of("facebook","google"))));
        System.out.println("[0,1,2,3] == " + pwlofcinasoal.peopleIndexes(List.of(List.of("leetcode"), List.of("google"), List.of("facebook"), List.of("amazon"))));
    }

    public void minimumAbsoluteDifferenceBetweenElementsWithConstraint() {
        MinimumAbsoluteDifferenceBetweenElementsWithConstraint madbewc = new MinimumAbsoluteDifferenceBetweenElementsWithConstraint();

        System.out.println("0 == " + madbewc.minAbsoluteDifference(List.of(4,3,2,4), 2));
        System.out.println("1 == " + madbewc.minAbsoluteDifference(List.of(5,3,2,10,15), 1));
        System.out.println("3 == " + madbewc.minAbsoluteDifference(List.of(1,2,3,4), 3));
        System.out.println("0 == " + madbewc.minAbsoluteDifference(List.of(4,3,1,2,3,4,5,6,7,8,7,6,4,2,1,3,5,7,8,6,4,2,1), 12));
        System.out.println("0 == " + madbewc.minAbsoluteDifference(List.of(4,3,1,2,3,4,5,6,7,8,7,6,4,2,1,3,5,7,8,6,4,2,1), 7));
        System.out.println("0 == " + madbewc.minAbsoluteDifference(List.of(4,3,1,2,3,4,5,6,7,8,7,6,4,2,1,3,5,7,8,6,4,2,1), 2));
        System.out.println("0 == " + madbewc.minAbsoluteDifference(List.of(4,3,1,2,3,4,5,6,7,8,7,6,4,2,1,3,5,7,8,6,4,2,1), 1));
        System.out.println("24 == " + madbewc.minAbsoluteDifference(List.of(61,85,196,17), 1));
    }

    public void findTheMaximumAchievableNumber() {
        FindTheMaximumAchievableNumber ftman = new FindTheMaximumAchievableNumber();

        System.out.println("6 == " + ftman.theMaximumAchievableX(4, 1));
        System.out.println("7 == " + ftman.theMaximumAchievableX(3, 2));
        System.out.println("110 == " + ftman.theMaximumAchievableX(10, 50));
        System.out.println("150 == " + ftman.theMaximumAchievableX(50, 50));
        System.out.println("57 == " + ftman.theMaximumAchievableX(23, 17));
        System.out.println("101 == " + ftman.theMaximumAchievableX(1, 50));
    }

    public void maximumEqualFrequency() {
        MaximumEqualFrequency mef = new MaximumEqualFrequency();

        System.out.println("7 == " + mef.maxEqualFreq(new int[]{2,2,1,1,5,3,3,5}));
        System.out.println("13 == " + mef.maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5}));
        System.out.println("9 == " + mef.maxEqualFreq(new int[]{2,1,2,3,4,4,3,2,1,2,3,4,4,3,2,1,2,3,4,5,4,3,2,1}));
        System.out.println("3 == " + mef.maxEqualFreq(new int[]{2,2,3}));
        System.out.println("3 == " + mef.maxEqualFreq(new int[]{2,2,3}));
        System.out.println("7 == " + mef.maxEqualFreq(new int[]{3,4,5,6,5,4,3,4,5,4,6,6,5,4,3,3,4,5,6,5,4}));
        System.out.println("5 == " + mef.maxEqualFreq(new int[]{1,1,1,2,2,2}));
        System.out.println("2 == " + mef.maxEqualFreq(new int[]{1,1}));
        System.out.println("7 == " + mef.maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3}));
    }

    public void findIfArrayCanBeSorted() {
        FindIfArrayCanBeSorted fiacbs = new FindIfArrayCanBeSorted();

        System.out.println("true == " + fiacbs.canSortArray(new int[]{8,4,2,30,15}));
        System.out.println("true == " + fiacbs.canSortArray(new int[]{1,2,3,4,5}));
        System.out.println("false == " + fiacbs.canSortArray(new int[]{3,16,8,4,2}));
        System.out.println("false == " + fiacbs.canSortArray(new int[]{3,2,1,2,3,4,5,76,8,9,7}));
        System.out.println("false == " + fiacbs.canSortArray(new int[]{20, 16}));
    }

    public void largestCombinationWithBitwiseANDGreaterThanZero() {
        LargestCombinationWithBitwiseANDGreaterThanZero lcwbagtz = new LargestCombinationWithBitwiseANDGreaterThanZero();

        System.out.println("4 == " + lcwbagtz.largestCombination(new int[]{16,17,71,62,12,24,14}));
        System.out.println("2 == " + lcwbagtz.largestCombination(new int[]{8,8}));
    }

    public void shortestSubarrayWithORAtLeastKII() {
        ShortestSubarrayWithORAtLeastKII sswoalkii = new ShortestSubarrayWithORAtLeastKII();

        System.out.println("1 == " + sswoalkii.minimumSubarrayLength(new int[]{1,2,3}, 2));
        System.out.println("3 == " + sswoalkii.minimumSubarrayLength(new int[]{2,1,8}, 10));
        System.out.println("1 == " + sswoalkii.minimumSubarrayLength(new int[]{1,2}, 0));
        System.out.println("3 == " + sswoalkii.minimumSubarrayLength(new int[]{1,2,32,21}, 55));
    }

    public void primeSubtractionOperation() {
        PrimeSubtractionOperation pso = new PrimeSubtractionOperation();

        System.out.println("true == " + pso.primeSubOperation(new int[]{4,9,6,10}));
        System.out.println("true == " + pso.primeSubOperation(new int[]{6,8,11,12}));
        System.out.println("false == " + pso.primeSubOperation(new int[]{5,8,3}));
    }

    public void minimumSumOfMountainTripletsII() {
        MinimumSumOfMountainTripletsII msomtii = new MinimumSumOfMountainTripletsII();

        System.out.println("9 == " + msomtii.minimumSum(new int[]{8,6,1,5,3}));
        System.out.println("13 == " + msomtii.minimumSum(new int[]{5,4,8,7,10,2}));
        System.out.println("-1 == " + msomtii.minimumSum(new int[]{6,5,4,3,4,5}));
    }

    public void makeASquareWithTheSameColor() {
        MakeASquareWithTheSameColor maswtsc = new MakeASquareWithTheSameColor();

        System.out.println("true == " + maswtsc.canMakeSquare(new char[][]{{'B','W','B'}, {'B','W','W'},{'B','W','B'}}));
        System.out.println("false == " + maswtsc.canMakeSquare(new char[][]{{'B','W','B'}, {'W','B','W'},{'B','W','B'}}));
        System.out.println("true == " + maswtsc.canMakeSquare(new char[][]{{'B','W','B'}, {'B','W','W'},{'B','W','W'}}));
    }

    public void maximumNumberOfOperationsToMoveOnesToTheEnd() {
        MaximumNumberOfOperationsToMoveOnesToTheEnd mnootmotte = new MaximumNumberOfOperationsToMoveOnesToTheEnd();

        System.out.println("4 == " + mnootmotte.maxOperations("1001101"));
        System.out.println("0 == " + mnootmotte.maxOperations("00111"));
        System.out.println("21 == " + mnootmotte.maxOperations("10010100010100101"));
        System.out.println("0 == " + mnootmotte.maxOperations("1"));
        System.out.println("0 == " + mnootmotte.maxOperations("0000"));
        System.out.println("36 == " + mnootmotte.maxOperations("1001000001010100101010"));
        System.out.println("26 == " + mnootmotte.maxOperations("100101001001011111100"));
        System.out.println("3 == " + mnootmotte.maxOperations("000001001011"));
    }

    public void findThePowerOfKSizeSubarraysI() {
        FindThePowerOfKSizeSubarraysI ftpokssi = new FindThePowerOfKSizeSubarraysI();

        System.out.println("[3,4,-1,-1,-1] == " + Arrays.toString(ftpokssi.resultsArray(new int[]{1,2,3,4,3,2,5}, 3)));
        System.out.println("[-1,-1] == " + Arrays.toString(ftpokssi.resultsArray(new int[]{2,2,2,2,2}, 2)));
        System.out.println("[-1,3,-1,3,-1] == " + Arrays.toString(ftpokssi.resultsArray(new int[]{3,2,3,2,3,2}, 2)));
        System.out.println("[6,7,8,9,10,-1,-1,-1,-1,5,6,7,8,9,1] == " + Arrays.toString(ftpokssi.resultsArray(new int[]{2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10}, 5)));
        System.out.println("[3,4,5,6,7,8,9,10,-1,2,3,4,5,6,7,8,9,10] == " + Arrays.toString(ftpokssi.resultsArray(new int[]{2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10}, 2)));
        System.out.println("[8,9,10,-1,-1,-1,-1,-1,-1,7,8,9,10] == " + Arrays.toString(ftpokssi.resultsArray(new int[]{2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10}, 7)));
        System.out.println("[10,-1,-1,-1,-1,-1,-1,-1,-1,9,10] == " + Arrays.toString(ftpokssi.resultsArray(new int[]{2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10}, 9)));
        System.out.println("[7,8,9,10,-1,-1,-1,-1,-1,6,7,8,9,10] == " + Arrays.toString(ftpokssi.resultsArray(new int[]{2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10}, 6)));
    }

    public void pancakeSorting() {
        PancakeSorting ps = new PancakeSorting();

        System.out.println("[3,4,2,3,2] == " + ps.pancakeSort(new int[]{3,2,4,1}));
        System.out.println("[] == " + ps.pancakeSort(new int[]{1,2,3}));
    }

    public void takeKOfEachCharacterFromLeftAndRight() {
        TakeKOfEachCharacterFromLeftAndRight tkoacflar = new TakeKOfEachCharacterFromLeftAndRight();

        System.out.println("8 == " + tkoacflar.takeCharacters("aabaaaacaabc", 2));
        System.out.println("-1 == " + tkoacflar.takeCharacters("a", 1));
        System.out.println("3 == " + tkoacflar.takeCharacters("abc", 1));
        System.out.println("3 == " + tkoacflar.takeCharacters("bcca", 1));
    }
}
