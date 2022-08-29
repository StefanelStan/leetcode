package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.august.CountVowelsPermutation;
import com.ss.leetcode.LC2022.august.LargestLocalValuesInAMatrix;
import com.ss.leetcode.LC2022.august.LongestIncreasingSubsequence;
import com.ss.leetcode.LC2022.august.MakeArrayZeroBySubtractingEqualAmounts;
import com.ss.leetcode.LC2022.august.MaxSumOfRectangleNoLargerThanK;
import com.ss.leetcode.LC2022.august.MergeSimilarItems;
import com.ss.leetcode.LC2022.august.NumberOfArithmeticTriplets;
import com.ss.leetcode.LC2022.august.NumberOfIslands;
import com.ss.leetcode.LC2022.august.StringWithoutAAAOrBBB;
import com.ss.leetcode.LC2022.august.SubstringWithConcatenationOfAllWords;
import java.util.Arrays;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

//        start.makeArrayZeroBySubtractingEqualAmounts();
//        start.countVowelsPermutation();
//        start.longestIncreasingSubsequence();
//        start.numberOfArithmeticTriplets();
//        start.substringWithConcatenationOfAllWords();
//        start.largestLocalValuesInAMatrix();
//        start.mergeSimilarItems();
//        start.stringWithoutAAAOrBBB();
//        start.maxSumOfRectangleNoLargerThanK();
        start.numberOfIslands();
    }

    public void makeArrayZeroBySubtractingEqualAmounts() {
        MakeArrayZeroBySubtractingEqualAmounts mazbsea = new MakeArrayZeroBySubtractingEqualAmounts();

        System.out.println("3 == " + mazbsea.minimumOperations(new int[]{1,5,0,3,5}));
        System.out.println("0 == " + mazbsea.minimumOperations(new int[]{0}));
        System.out.println("5 == " + mazbsea.minimumOperations(new int[]{7,1,5,0,3,5,6}));
    }

    public void countVowelsPermutation() {
        CountVowelsPermutation cvp = new CountVowelsPermutation();

        System.out.println("5 == " + cvp.countVowelPermutation(1));
        System.out.println("10 == " + cvp.countVowelPermutation(2));
        System.out.println("68 == " + cvp.countVowelPermutation(5));
        System.out.println("759959057 == " + cvp.countVowelPermutation(20000));
        System.out.println("377163667 == " + cvp.countVowelPermutation(15682));
        System.out.println("288864303 == " + cvp.countVowelPermutation(4821));
    }

    public void longestIncreasingSubsequence() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

        System.out.println("4 == " + lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println("4 == " + lis.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println("1 == " + lis.lengthOfLIS(new int[]{7}));
        System.out.println("4 == " + lis.lengthOfLIS(new int[]{3,2,1,1,1,1,2,3,4,4,4,4,3,2,1,2,3}));
        System.out.println("9 == " + lis.lengthOfLIS(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println("1 == " + lis.lengthOfLIS(new int[]{9,8,7,6,5,4,3,2,1}));
    }

    public void numberOfArithmeticTriplets() {
        NumberOfArithmeticTriplets noat = new NumberOfArithmeticTriplets();

        System.out.println("2 == " + noat.arithmeticTriplets(new int[]{0,1,4,6,7,10}, 3));
        System.out.println("2 == " + noat.arithmeticTriplets(new int[]{4,5,6,7,8,9}, 2));
        System.out.println("7 == " + noat.arithmeticTriplets(new int[]{1,2,3,4,5,6,7,8,9}, 1));
        System.out.println("1 == " + noat.arithmeticTriplets(new int[]{2,4,6}, 2));
        System.out.println("0 == " + noat.arithmeticTriplets(new int[]{2,4,5}, 2));
    }

    public void substringWithConcatenationOfAllWords() {
        SubstringWithConcatenationOfAllWords swcoaw = new SubstringWithConcatenationOfAllWords();

        System.out.println("[0,9] == " + swcoaw.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        System.out.println("[] == " + swcoaw.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        System.out.println("[6,9,12] == " + swcoaw.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }

    public void largestLocalValuesInAMatrix() {
        LargestLocalValuesInAMatrix llviam = new LargestLocalValuesInAMatrix();

        System.out.println("[[9,9],[8,6]] == " + Arrays.deepToString(llviam.largestLocal(new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}})));
        System.out.println("[[2,2,2],[2,2,2],[2,2,2]] == " + Arrays.deepToString(llviam.largestLocal(new int[][]{{1,1,1,1,1},{1,1,1,1,1},
            {1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}})));
    }

    public void mergeSimilarItems() {
        MergeSimilarItems msi = new MergeSimilarItems();

        System.out.println("[[1,6],[3,9],[4,5]] == " + msi.mergeSimilarItems(new int[][]{{1,1},{4,5},{3,8}}, new int[][]{{3,1},{1,5}}));
        System.out.println("[[1,4],[2,4],[3,4]] == " + msi.mergeSimilarItems(new int[][]{{1,1},{3,2},{2,3}}, new int[][]{{2,1},{3,2},{1,3}}));
        System.out.println("[[1,7],[2,4],[7,1]] == " + msi.mergeSimilarItems(new int[][]{{1,3},{2,2}}, new int[][]{{7,1},{2,2},{1,4}}));
    }

    public void stringWithoutAAAOrBBB() {
        StringWithoutAAAOrBBB swaob = new StringWithoutAAAOrBBB();

        System.out.println("bba == " + swaob.strWithout3a3b(1, 2));
        System.out.println("aabaa == " + swaob.strWithout3a3b(4, 1));
        System.out.println("aabaabaaba == " + swaob.strWithout3a3b(7, 3));
        System.out.println("aabaabaabaabaabaa == " + swaob.strWithout3a3b(12, 5));
    }

    public void maxSumOfRectangleNoLargerThanK() {
        MaxSumOfRectangleNoLargerThanK msornltk = new MaxSumOfRectangleNoLargerThanK();

        System.out.println("2 == " + msornltk.maxSumSubmatrix(new int[][]{{1,0,1},{0,-2,3}}, 2));
        System.out.println("3 == " + msornltk.maxSumSubmatrix(new int[][]{{2,2,-1}}, 3));
        System.out.println("2 == " + msornltk.maxSumSubmatrix(new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}}, 3));
    }

    public void numberOfIslands() {
        NumberOfIslands noi = new NumberOfIslands();

        System.out.println("1 == " + noi.numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
        System.out.println("3 == " + noi.numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
        System.out.println("2 == " + noi.numIslands(new char[][]{{'1'},{'0'}, {'1'}}));
    }
}
