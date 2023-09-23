package com.ss.leetcode.LC2021;
import com.ss.leetcode.LC2021.january.AddToArrayForm;
import com.ss.leetcode.LC2021.january.CoinExchange;
import com.ss.leetcode.LC2021.january.ConstructKPalindromeStrings;
import com.ss.leetcode.LC2021.january.ExcelSheetColumnNumber;
import com.ss.leetcode.LC2021.january.LargestNumber;
import com.ss.leetcode.LC2021.january.LongestStringChain;
import com.ss.leetcode.LC2021.january.LongestTurbulentSubarray;
import com.ss.leetcode.LC2021.january.NextGreaterElementII;
import com.ss.leetcode.LC2021.january.ProductOfArrayExceptSelf;
import com.ss.leetcode.LC2021.january.ReduceArraySizeToTheHalf;
import com.ss.leetcode.LC2021.january.RottingOranges;
import com.ss.leetcode.LC2021.january.SearchA2DMatrixII;
import com.ss.leetcode.LC2021.january.SmallestIntegerDivisibleByK;
import com.ss.leetcode.LC2021.january.SortColors;
import com.ss.leetcode.LC2021.january.SplitTwoStringsToMakePalindrome;
import com.ss.leetcode.LC2021.january.StreamChecker;
import com.ss.leetcode.LC2021.january.SubrectangleQueries;


import java.util.Arrays;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

        start.longestStringChain();
//        start.constructKPalindrome(); //unfinished
//        start.excelSheetColumnNumber();
//        start.largestNumber();
//        start.addToArrayForm();
//        start.productOfArrayExceptSelf();
//        start.subrectangleQueries();
//        start.reduceArraySizeToTheHalf();
//        start.smallestIntegerDivisibleByK();
//        start.sortColors();
//        start.rottingOranges();
//        start.coinExchange();
//        start.longestTurbulentSubarray();
//        start.nextGreaterElementII();
//        start.searchA2DMatrixII();
//        start.streamChecker();
//        start.splitTwoStringsToMakePalindrome();
    }

    private void longestStringChain() {
        LongestStringChain lsc = new LongestStringChain();
        System.out.println("4 == " + lsc.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
        System.out.println("5 == " + lsc.longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
        System.out.println("1 == " + lsc.longestStrChain(new String[]{"abcd","dbqca"}));
        System.out.println("4 == " + lsc.longestStrChain(new String[]{"a","ab","ac","bd","abc","abd","abdd"}));
        System.out.println("1 == " + lsc.longestStrChain(new String[]{"a","b"}));
        System.out.println("9 == " + lsc.longestStrChain(new String[]{"czgxmxrpx","lgh","bj","cheheex","jnzlxgh","nzlgh","ltxdoxc","bju","srxoatl","bbadhiju","cmpx","xi","ntxbzdr","cheheevx","bdju","sra","getqgxi","geqxi","hheex","ltxdc","nzlxgh","pjnzlxgh","e","bbadhju","cmxrpx","gh","pjnzlxghe","oqlt","x","sarxoatl","ee","bbadju","lxdc","geqgxi","oqltu","heex","oql","eex","bbdju","ntxubzdr","sroa","cxmxrpx","cmrpx","ltxdoc","g","cgxmxrpx","nlgh","sroat","sroatl","fcheheevx","gxi","gqxi","heheex"}));
    }

    private void constructKPalindrome() {
        ConstructKPalindromeStrings ckps = new ConstructKPalindromeStrings();
        System.out.println("true ==" + ckps.canConstruct("annabelle", 2));
        System.out.println("false ==" + ckps.canConstruct("leetcode", 3));
        System.out.println("true ==" + ckps.canConstruct("true", 4));
        System.out.println("true ==" + ckps.canConstruct("yzyzyzyzyzyzyzy", 2));
        System.out.println("false ==" + ckps.canConstruct("cr", 7));
        //undone
    }

    private void excelSheetColumnNumber() {
        ExcelSheetColumnNumber escn = new ExcelSheetColumnNumber();
        System.out.println("1 ==" + escn.titleToNumber("A"));
        System.out.println("28 ==" + escn.titleToNumber("AB"));
        System.out.println("701 ==" + escn.titleToNumber("ZY"));
    }

    private void largestNumber() {
        LargestNumber ln = new LargestNumber();
        int[] nums = { 10, 2 };
        int[] nums2 = { 3, 30, 34, 5, 9 };
        int[] nums3 = { 3, 30, 34, 5, 9, 9125, 90, 925 };
        int[] nums4 = { 432, 43243 };
        int[] nums5 = { 8308, 8308, 830 };
//        System.out.println("210 ==" + ln.largestNumber(nums));
//        System.out.println("9534330 ==" + ln.largestNumber(nums2));
//        System.out.println("9925912590 ==" + ln.largestNumber(nums3));
//        System.out.println("43243432 ==" + ln.largestNumber(nums4));
        System.out.println("83088308830 == " + ln.largestNumber(nums5));
    }

    private void addToArrayForm() {
        AddToArrayForm ataf = new AddToArrayForm();
        int[] digits1 = { 1, 2, 0, 0 };
        int[] digits2 = { 2, 7, 4 };
        int[] digits3 = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
        System.out.println(ataf.addToArrayForm(digits1, 34));
        System.out.println(ataf.addToArrayForm(digits2, 181));
        System.out.println(ataf.addToArrayForm(digits3, 1));
    }

    private void productOfArrayExceptSelf() {
        ProductOfArrayExceptSelf poaes = new ProductOfArrayExceptSelf();
//        System.out.println(Arrays.toString(poaes.productExceptSelf(new int[]{1,0})));
        System.out.println(Arrays.toString(poaes.productExceptSelf(new int[] { 1, 2, 3, 4 })));
    }

    private void subrectangleQueries() {
        int[][] rectangle = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
        SubrectangleQueries sq = new SubrectangleQueries(rectangle);
        System.out.println("1 ==" + sq.getValue(0, 0));
        sq.updateSubrectangle(0, 0, 2, 2, 100);
        System.out.println("100 ==" + sq.getValue(0, 0));
        System.out.println("100 ==" + sq.getValue(2, 2));
        sq.updateSubrectangle(1, 1, 2, 2, 20);
        System.out.println("20 ==" + sq.getValue(2, 2));
    }

    private void reduceArraySizeToTheHalf() {
        ReduceArraySizeToTheHalf rasths = new ReduceArraySizeToTheHalf();
        int[] arr = { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 };
        int[] arr2 = { 7, 7, 7, 7, 7, 7 };
        int[] arr3 = { 1, 9 };
        int[] arr4 = { 1000, 1000, 3, 7 };
        int[] arr5 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        System.out.println("2 == " + rasths.minSetSize(arr));
        System.out.println("1 == " + rasths.minSetSize(arr2));
        System.out.println("1 == " + rasths.minSetSize(arr3));
        System.out.println("1 == " + rasths.minSetSize(arr4));
        System.out.println("5 == " + rasths.minSetSize(arr5));

    }

    private void smallestIntegerDivisibleByK() {
        SmallestIntegerDivisibleByK sidbk = new SmallestIntegerDivisibleByK();
//        System.out.println("1 ==" + sidbk.smallestRepunitDivByK(1));
//        System.out.println("-1 ==" + sidbk.smallestRepunitDivByK(2));
//        System.out.println("3 ==" + sidbk.smallestRepunitDivByK(3));
//        System.out.println("6122 ==" + sidbk.smallestRepunitDivByK(18367));
//        System.out.println("6122 ==" + sidbk.smallestRepunitDivByK(19927));
    }

    private void sortColors() {
        int[] nums1 = { 2, 0, 2, 1, 1, 0 };
        int[] nums2 = { 2, 0, 1 };
        int[] nums3 = { 0 };
        int[] nums4 = { 1 };

        SortColors sc = new SortColors();
        sc.sortColors(nums1);
        System.out.println("[0,0,1,1,2,2] == " + Arrays.toString(nums1));

        sc.sortColors(nums2);
        System.out.println("[0,1,2] == " + Arrays.toString(nums2));

        sc.sortColors(nums3);
        System.out.println("[0] == " + Arrays.toString(nums3));

        sc.sortColors(nums4);
        System.out.println("[1] == " + Arrays.toString(nums4));
    }

    private void rottingOranges() {
        RottingOranges ro = new RottingOranges();
        int[][] grid1 = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        int[][] grid2 = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        int[][] grid3 = { { 0, 2 } };

        System.out.println("4 == " + ro.orangesRotting(grid1));
        System.out.println("-1 == " + ro.orangesRotting(grid2));
        System.out.println("0 == " + ro.orangesRotting(grid3));
// https://leetcode.com/problems/coin-change/solution/
    }

    private void coinExchange() {
        CoinExchange co = new CoinExchange();
        System.out.println("3 == " + co.coinChange(new int[] { 1, 2, 5 }, 11));
    }

    private void longestTurbulentSubarray() {
        LongestTurbulentSubarray lts = new LongestTurbulentSubarray();
        int[] nums = { 9, 4, 2, 10, 7, 8, 8, 1, 9 };
        int[] nums2 = { 4, 8, 12, 16 };
        int[] nums3 = { 100 };
        int[] nums4 = { 0, 8, 45, 88, 48, 68, 28, 55, 17, 24 };
//        System.out.println("5 == " + lts.maxTurbulenceSize(nums));
//        System.out.println("2 == " + lts.maxTurbulenceSize(nums2));
//        System.out.println("1 == " + lts.maxTurbulenceSize(nums3));
        System.out.println("8 == " + lts.maxTurbulenceSize(nums4));
    }

    private void nextGreaterElementII() {
        NextGreaterElementII nge = new NextGreaterElementII();
//        int[] nums = { 1, 2, 1 };
//        int[] nums2 = { 3, 6, 8, 6, 9 };
//        int[] nums3 = { 5, 4, 3, 2, 1 };
//        int[] nums4 = { 1, 2, 3, 2, 1 };
        int[] nums5 = { 2, 3, 1, 1, 6, -100 };
//        System.out.println("[2,-1,2] == " + Arrays.toString(nge.nextGreaterElements(nums)));
//        System.out.println("[6,8,9,9,-1] == " + Arrays.toString(nge.nextGreaterElements(nums2)));
//        System.out.println("[-1,5,5,5,5] == " + Arrays.toString(nge.nextGreaterElements(nums3)));
//        System.out.println("[2,3,-1,3,2] == " + Arrays.toString(nge.nextGreaterElements(nums4)));
        System.out.println("[3,6,6,6,-1,2] == " + Arrays.toString(nge.nextGreaterElements(nums5)));

    }

    private void searchA2DMatrixII() {
        SearchA2DMatrixII sa2dm = new SearchA2DMatrixII();
        int[][] nums = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println("true == " + sa2dm.searchMatrix(nums, 5));
        System.out.println("false == " + sa2dm.searchMatrix(nums, 20));
        System.out.println("true == " + sa2dm.searchMatrix(new int[][]{{-5}}, -5));
        System.out.println("false == " + sa2dm.searchMatrix(new int[][]{{-5}}, 5));
        System.out.println("true == " + sa2dm.searchMatrix(new int[][]{{-5,-4,0,2,6,9}}, 6));
        System.out.println("false == " + sa2dm.searchMatrix(new int[][]{{-5,-4,0,2,6,9}}, 5));
    }

    private void streamChecker() {
        StreamChecker sc = new StreamChecker(new String[] { "cd", "f", "kl" });
        System.out.println("false == " + sc.query('a'));
        System.out.println("false == " + sc.query('b'));
        System.out.println("false == " + sc.query('c'));
        System.out.println("true == " + sc.query('d'));
        System.out.println("false == " + sc.query('e'));
        System.out.println("true == " + sc.query('f'));
        System.out.println("false == " + sc.query('g'));
        System.out.println("false == " + sc.query('h'));
        System.out.println("false == " + sc.query('i'));
        System.out.println("false == " + sc.query('j'));
        System.out.println("false == " + sc.query('k'));
        System.out.println("true == " + sc.query('l'));
    }

    private void splitTwoStringsToMakePalindrome() {
        SplitTwoStringsToMakePalindrome ststmp = new SplitTwoStringsToMakePalindrome();
        String s11 = "a";
        String s12 = "b";
        String s21 = "abdef";
        String s22 = "fecab";
        String s31 = "ulacfd";
        String s32 = "jizalu";
        String s41 = "xbdef";
        String s42 = "xecab";
        System.out.println("true == " + ststmp.checkPalindromeFormation(s11, s12));
        System.out.println("true == " + ststmp.checkPalindromeFormation(s21, s22));
        System.out.println("true == " + ststmp.checkPalindromeFormation(s31, s32));
        System.out.println("false == " + ststmp.checkPalindromeFormation(s41, s42));
    }
}

