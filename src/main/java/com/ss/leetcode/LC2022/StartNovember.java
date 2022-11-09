package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.november.ApplyOperationsToAnArray;
import com.ss.leetcode.LC2022.november.ImageSmoother;
import com.ss.leetcode.LC2022.november.LargestPositiveIntegerThatExistsWithItsNegative;
import com.ss.leetcode.LC2022.november.LongestPalindromeByConcatenatingTwoLetterWords;
import com.ss.leetcode.LC2022.november.MakeTheStringGreat;
import com.ss.leetcode.LC2022.november.MaximumSumOfDistinctSubarraysWithLengthK;
import com.ss.leetcode.LC2022.november.MinimumGeneticMutation;
import com.ss.leetcode.LC2022.november.OnlineStockSpan;
import java.util.Arrays;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

//        start.largestPositiveIntegerThatExistsWithItsNegative();
//        start.minimumGeneticMutation();
//        start.longestPalindromeByConcatenatingTwoLetterWords();
//        start.imageSmoother();
//        start.maximumSumOfDistinctSubarraysWithLengthK();
//        start.makeTheStringGreat();
//        start.applyOperationsToAnArray();
        start.stockSpan();
    }

    public void largestPositiveIntegerThatExistsWithItsNegative() {
        LargestPositiveIntegerThatExistsWithItsNegative lpitewin = new LargestPositiveIntegerThatExistsWithItsNegative();

        System.out.println("3 == " + lpitewin.findMaxK(new int[]{-1,2,-3,3}));
        System.out.println("7 == " + lpitewin.findMaxK(new int[]{-1,10,6,7,-7,1}));
        System.out.println("-1 == " + lpitewin.findMaxK(new int[]{-10,8,6,7,-2,-3}));
    }

    public void minimumGeneticMutation() {
        MinimumGeneticMutation mgm = new MinimumGeneticMutation();

        System.out.println("1 == " + mgm.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println("2 == " + mgm.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
        System.out.println("3 == " + mgm.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"}));
        System.out.println("-1 == " + mgm.minMutation("AAAAAAAA", "CCCCCCCC", new String[]{"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"}));
        System.out.println("4 == " + mgm.minMutation("AAAACCCC", "CCCCCCCC", new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"}));
    }

    public void longestPalindromeByConcatenatingTwoLetterWords() {
        LongestPalindromeByConcatenatingTwoLetterWords lpbctlw = new LongestPalindromeByConcatenatingTwoLetterWords();

        System.out.println("6 == " + lpbctlw.longestPalindrome(new String[]{"lc","cl","gg"}));
        System.out.println("8 == " + lpbctlw.longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"}));
        System.out.println("2 == " + lpbctlw.longestPalindrome(new String[]{"cc","ll","xx"}));
        System.out.println("0 == " + lpbctlw.longestPalindrome(new String[]{"cu","lz","xa"}));
        System.out.println("22 == " + lpbctlw.longestPalindrome(new String[]{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"}));
    }

    public void imageSmoother() {
        ImageSmoother is = new ImageSmoother();

        System.out.println("[[0,0,0],[0,0,0],[0,0,0]] == " + Arrays.deepToString(is.imageSmoother(new int[][]{{1,1,1},{1,0,1},{1,1,1}})));
        System.out.println("[[137,141,137],[141,138,141],[137,141,137]] == " + Arrays.deepToString(is.imageSmoother(new int[][]{{100,200,100},{200,50,200},{100,200,100}})));
        System.out.println("[[1]] == " + Arrays.deepToString(is.imageSmoother(new int[][]{{1}})));
    }

    public void maximumSumOfDistinctSubarraysWithLengthK() {
        MaximumSumOfDistinctSubarraysWithLengthK msaodswlk = new MaximumSumOfDistinctSubarraysWithLengthK();

        System.out.println("15 == " + msaodswlk.maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
        System.out.println("0 == " + msaodswlk.maximumSubarraySum(new int[]{4,4,4}, 3));
        System.out.println("0 == " + msaodswlk.maximumSubarraySum(new int[]{4}, 1));
        System.out.println("9 == " + msaodswlk.maximumSubarraySum(new int[]{4,5,5}, 2));
        System.out.println("0 == " + msaodswlk.maximumSubarraySum(new int[]{4,5,5,6}, 3));
        System.out.println("24 == " + msaodswlk.maximumSubarraySum(new int[]{1,1,1,7,8,9}, 3));
    }

    public void makeTheStringGreat() {
        MakeTheStringGreat mtsg = new MakeTheStringGreat();

        System.out.println("leetcode == " + mtsg.makeGood("leEeetcode"));
        System.out.println(" == " + mtsg.makeGood("abBAcC"));
        System.out.println("s == " + mtsg.makeGood("s"));
        System.out.println(" == " + mtsg.makeGood("pP"));
        System.out.println(" == " + mtsg.makeGood("Pp"));
    }

    public void applyOperationsToAnArray() {
        ApplyOperationsToAnArray aotaa = new ApplyOperationsToAnArray();

        System.out.println("[4,4,2,0] == " + Arrays.toString(aotaa.applyOperations(new int[]{4,2,2,2})));
        System.out.println("[1,0] == " + Arrays.toString(aotaa.applyOperations(new int[]{0,1})));
        System.out.println("[5,4,3,2,2,2,3,4,5,12,12,7,8,9,0,0,0,0,0] == " + Arrays.toString(aotaa.applyOperations(new int[]{5,4,3,2,1,1,2,3,4,5,6,6,6,6,7,8,9,0,0})));
        System.out.println("[2,0] == " + Arrays.toString(aotaa.applyOperations(new int[]{1,1})));
        System.out.println("[2,2,0,0] == " + Arrays.toString(aotaa.applyOperations(new int[]{1,1,1,1})));
        System.out.println("[2,4,0,0] == " + Arrays.toString(aotaa.applyOperations(new int[]{1,1,2,2})));
    }

    public void stockSpan() {
        OnlineStockSpan oss = new OnlineStockSpan();

        System.out.println("1 == " + oss.next(100));
        System.out.println("1 == " + oss.next(80));
        System.out.println("1 == " + oss.next(60));
        System.out.println("2 == " + oss.next(70));
        System.out.println("3 == " + oss.next(70));
        System.out.println("1 == " + oss.next(60));
        System.out.println("5 == " + oss.next(75));
        System.out.println("7 == " + oss.next(85));

        oss = new OnlineStockSpan();
        System.out.println("1 == " + oss.next(31));
        System.out.println("2 == " + oss.next(41));
        System.out.println("3 == " + oss.next(48));
        System.out.println("4 == " + oss.next(59));
        System.out.println("5 == " + oss.next(79));
    }
}
