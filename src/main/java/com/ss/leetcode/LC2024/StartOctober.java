package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.october.CheckIfStringsCanBeMadeEqualWithOperationsI;
import com.ss.leetcode.LC2024.october.CountSubstringsStartingAndEndingWithGivenCharacter;
import com.ss.leetcode.LC2024.october.CountSubstringsWithKFrequencyCharactersI;
import com.ss.leetcode.LC2024.october.DividePlayersIntoTeamsOfEqualSkill;
import com.ss.leetcode.LC2024.october.EqualSumArraysWithMinimumNumberOfOperations;
import com.ss.leetcode.LC2024.october.FindKthBitInNthBinaryString;
import com.ss.leetcode.LC2024.october.FindTheGridOfRegionAverage;
import com.ss.leetcode.LC2024.october.MakeSumDivisibleByP;
import com.ss.leetcode.LC2024.october.MarkElementsOnArrayByPerformingQueries;
import com.ss.leetcode.LC2024.october.MaximumSumBSTInBinaryTree;
import com.ss.leetcode.LC2024.october.MaximumSwap;
import com.ss.leetcode.LC2024.october.MaximumWidthRamp;
import com.ss.leetcode.LC2024.october.MinimumDeletionsToMakeStringKSpecial;
import com.ss.leetcode.LC2024.october.MinimumNumberOfRemovalsToMakeMountainArray;
import com.ss.leetcode.LC2024.october.MinimumNumberOfSwapsToMakeTheStringBalanced;
import com.ss.leetcode.LC2024.october.MinimumOperationsToMakeBinaryArrayElementsEqualToOneI;
import com.ss.leetcode.LC2024.october.MinimumStringLengthAfterRemovingSubstrings;
import com.ss.leetcode.LC2024.october.MonotoneIncreasingDigits;
import com.ss.leetcode.LC2024.october.ParsingABooleanExpression;
import com.ss.leetcode.LC2024.october.RemoveSubFolderFromTheFilesystem;
import com.ss.leetcode.LC2024.october.ReportSpamMessage;
import com.ss.leetcode.LC2024.october.ShortestDistanceAfterRoadAdditionQueriesI;
import com.ss.leetcode.LC2024.october.SplitArrayIntoMaximumNumberOfSubarrays;
import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start = new StartOctober();

//        start.splitArrayIntoMaximumNumberOfSubarrays();
//        start.findTheGridOfRegionAverage();
//        start.makeSumDivisibleByP();
//        start.dividePlayersIntoTeamsOfEqualSkill();
//        start.maximumSumBSTInBinaryTree();
//        start.minimumStringLengthAfterRemovingSubstrings();
//        System.out.println("1== " + start.minSwaps("][]["));
//        start.minimumNumberOfSwapsToMakeTheStringBalanced();
//        start.minimumOperationsToMakeBinaryArrayElementsEqualToOneI();
//        start.maximumWidthRamp();
//        start.checkIfStringsCanBeMadeEqualWithOperationsI();
//        start.reportSpamMessage();
//        start.countSubstringsStartingAndEndingWithGivenCharacter();
//        start.monotoneIncreasingDigits();
//        start.maximumSwap();
//        start.shortestDistanceAfterRoadAdditionQueriesI();
//        start.findKthBitInNthBinaryString();
//        start.parsingABooleanExpression();
//        start.countSubstringsWithKFrequencyCharactersI();
//        start.markElementsOnArrayByPerformingQueries();
//        start.minimumDeletionsToMakeStringKSpecial();
//        start.removeSubFolderFromTheFilesystem();
//        start.minimumNumberOfRemovalsToMakeMountainArray();
        start.equalSumArraysWithMinimumNumberOfOperations();
    }

    public void splitArrayIntoMaximumNumberOfSubarrays() {
        SplitArrayIntoMaximumNumberOfSubarrays saimnos = new SplitArrayIntoMaximumNumberOfSubarrays();

        System.out.println("3 == " + saimnos.maxSubarrays(new int[]{1,0,2,0,1,2}));
        System.out.println("1 == " + saimnos.maxSubarrays(new int[]{5,7,1,3}));
        System.out.println("3 == " + saimnos.maxSubarrays(new int[]{3,2,1,2,3,4,5,6,5,4,3,1,1}));
        System.out.println("4 == " + saimnos.maxSubarrays(new int[]{5,4,3,2,3,5,7,8,6,5,3}));
        System.out.println("5 == " + saimnos.maxSubarrays(new int[]{3,2,3,5,6,8,7,6,5,3,2,4,6,7,56,3}));
        System.out.println("3 == " + saimnos.maxSubarrays(new int[]{3,2,34,5,7,98,9,7,5,4,2}));
        System.out.println("2 == " + saimnos.maxSubarrays(new int[]{1234,3423,354,43534,56456,3524,425435,452341,2343,6576,24123}));
        System.out.println("1 == " + saimnos.maxSubarrays(new int[]{22,21,29,22}));
    }

    public void findTheGridOfRegionAverage() {
        FindTheGridOfRegionAverage ftgora = new FindTheGridOfRegionAverage();

        System.out.println("[[9,9,9,9],[9,9,9,9],[9,9,9,9]] == " + Arrays.deepToString(ftgora.resultGrid(new int[][]{{5,6,7,10}, {8,9,10,10},{11,12,13,10}}, 3)));
        System.out.println("[[25,25,25],[27,27,27],[27,27,27],[30,30,30]] == " + Arrays.deepToString(ftgora.resultGrid(new int[][]{{10,20,30}, {15,25,35},{20,30,40},{25,35,45}}, 12)));
        System.out.println("[[5,6,7],[8,9,10],[11,12,13]] == " + Arrays.deepToString(ftgora.resultGrid(new int[][]{{5,6,7}, {8,9,10},{11,12,13}}, 1)));
    }

    public void makeSumDivisibleByP() {
        MakeSumDivisibleByP msdbp = new MakeSumDivisibleByP();

        System.out.println("1 == " + msdbp.minSubarray(new int[]{3,1,4,2}, 6));
        System.out.println("1 == " + msdbp.minSubarray(new int[]{2,8,7,3,6,3,19,19,4,10}, 74));
        System.out.println("0 == " + msdbp.minSubarray(new int[]{1}, 1));
        System.out.println("-1 == " + msdbp.minSubarray(new int[]{5,12,2,14,11,15,10,22,20,10,20}, 81));
        System.out.println("3 == " + msdbp.minSubarray(new int[]{26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3}, 26));
        System.out.println("7 == " + msdbp.minSubarray(new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2}, 148));
    }

    public void dividePlayersIntoTeamsOfEqualSkill() {
        DividePlayersIntoTeamsOfEqualSkill dpitoes = new DividePlayersIntoTeamsOfEqualSkill();

        System.out.println("22 == " + dpitoes.dividePlayers(new int[]{3,2,5,1,3,4}));
        System.out.println("12 == " + dpitoes.dividePlayers(new int[]{3,4}));
        System.out.println("-1 == " + dpitoes.dividePlayers(new int[]{1,1,2,3}));
    }

    public void maximumSumBSTInBinaryTree() {
        MaximumSumBSTInBinaryTree msbstibt = new MaximumSumBSTInBinaryTree();

        System.out.println("20 == " + msbstibt.maxSumBST(new TreeNode(1, new TreeNode(4, new TreeNode(2), new TreeNode(4)), new TreeNode(3, new TreeNode(2),new TreeNode(5, new TreeNode(4), new TreeNode(6))))));
        System.out.println("2 == " + msbstibt.maxSumBST(new TreeNode(4, new TreeNode(3, new TreeNode(1), new TreeNode(2)), null)));
        System.out.println("0 == " + msbstibt.maxSumBST(new TreeNode(-4, new TreeNode(-2), new TreeNode(-5))));
    }

    public void minimumStringLengthAfterRemovingSubstrings() {
        MinimumStringLengthAfterRemovingSubstrings mslars = new MinimumStringLengthAfterRemovingSubstrings();

        System.out.println("2 == " + mslars.minLength("ABFCACDB"));
        System.out.println("5 == " + mslars.minLength("ACBBD"));
        System.out.println("1 == " + mslars.minLength("D"));
    }

    public void minimumNumberOfSwapsToMakeTheStringBalanced() {
        MinimumNumberOfSwapsToMakeTheStringBalanced mnostmsb = new MinimumNumberOfSwapsToMakeTheStringBalanced();

        System.out.println("3 == " + mnostmsb.minSwaps("[][]]]]]][[[][[[[[]]][[][]"));
        System.out.println("2 == " + mnostmsb.minSwaps("]]][[]]][][[[[]]]][[[[[][[[]]][][[[[][]]][[[]][]]]"));
        System.out.println("4 == " + mnostmsb.minSwaps("]][[]][][[][[[[]][]][][[]]]][[][]]][[]]]]]][[[][]]][[[][[[[[[]]]][][][][[][[][][[]]]][[["));
        System.out.println("1 == " + mnostmsb.minSwaps("][[[][][][[[]]]][][][][[][[][[[[[][][]][[]]][]][[[[][]]]][]]][[]][][]]"));
        System.out.println("1 == " + mnostmsb.minSwaps("][]][[][][[[[]]]][[]][][][[][[][][]]]][][["));
        System.out.println("2 == " + mnostmsb.minSwaps("]][[[][]][[[][[]][][[]][][[][[][]]][[[[]][]][]][][[[[[]]][[]]]]]]]][[[[][]]][][[[]][[]]][][["));
        System.out.println("1 == " + mnostmsb.minSwaps("][[][][[[][][]]][[]]"));
        System.out.println("1 == " + mnostmsb.minSwaps("[][[][[[][[]]][]]]]][[][[][][][][[[[][]]]]"));
    }

    public void minimumOperationsToMakeBinaryArrayElementsEqualToOneI() {
        MinimumOperationsToMakeBinaryArrayElementsEqualToOneI motmbaeetoi = new MinimumOperationsToMakeBinaryArrayElementsEqualToOneI();

        System.out.println("3 == " + motmbaeetoi.minOperations(new int[]{0,1,1,1,0,0}));
        System.out.println("-1 == " + motmbaeetoi.minOperations(new int[]{0,1,1,1}));
        System.out.println("4 == " + motmbaeetoi.minOperations(new int[]{1,1,1,0,0,1,1,0,1,0,1}));
        System.out.println("-1 == " + motmbaeetoi.minOperations(new int[]{0,0,1,1,0}));
        System.out.println("0 == " + motmbaeetoi.minOperations(new int[]{1,1,1,1,1}));
        System.out.println("-1 == " + motmbaeetoi.minOperations(new int[]{0,0,0,0,0}));
        System.out.println("1 == " + motmbaeetoi.minOperations(new int[]{0,0,0}));
    }

    public void maximumWidthRamp() {
        MaximumWidthRamp mwr = new MaximumWidthRamp();

        System.out.println("4 == " + mwr.maxWidthRamp(new int[]{6,0,8,2,1,5}));
        System.out.println("7 == " + mwr.maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
        System.out.println("22 == " + mwr.maxWidthRamp(new int[]{4,3,1,2,3,4,5,6,7,6,5,3,5,6,4,3,1,2,4,5,6,5,4,3}));
        System.out.println("1 == " + mwr.maxWidthRamp(new int[]{10,9,8,7,6,5,4,3,2,1,1,0}));
        System.out.println("1 == " + mwr.maxWidthRamp(new int[]{0,1}));
        System.out.println("1 == " + mwr.maxWidthRamp(new int[]{3,4,1,2}));
    }

    public void checkIfStringsCanBeMadeEqualWithOperationsI() {
        CheckIfStringsCanBeMadeEqualWithOperationsI ciscbmewoi = new CheckIfStringsCanBeMadeEqualWithOperationsI();

        System.out.println("true == " + ciscbmewoi.canBeEqual("abcd", "cdab"));
        System.out.println("false == " + ciscbmewoi.canBeEqual("abcd", "dacb"));
    }

    public void reportSpamMessage() {
        ReportSpamMessage rsm = new ReportSpamMessage();

        System.out.println("true == " + rsm.reportSpam(new String[]{"hello","world","leetcode"}, new String[]{"world","hello"}));
        System.out.println("true == " + rsm.reportSpam(new String[]{"hello","programming","fun", "programming"}, new String[]{"world","programming","leetcode"}));
        System.out.println("false == " + rsm.reportSpam(new String[]{"hello","programming","fun"}, new String[]{"world","programming","leetcode"}));
    }

    public void countSubstringsStartingAndEndingWithGivenCharacter() {
        CountSubstringsStartingAndEndingWithGivenCharacter cssaewgc = new CountSubstringsStartingAndEndingWithGivenCharacter();

        System.out.println("6 == " + cssaewgc.countSubstrings("abada", 'a'));
        System.out.println("6 == " + cssaewgc.countSubstrings("zzz", 'z'));
    }

    public void monotoneIncreasingDigits() {
        MonotoneIncreasingDigits mid = new MonotoneIncreasingDigits();

        System.out.println("9 == " + mid.monotoneIncreasingDigits(10));
        System.out.println("1234 == " + mid.monotoneIncreasingDigits(1234));
        System.out.println("299 == " + mid.monotoneIncreasingDigits(332));
        System.out.println("123456789 == " + mid.monotoneIncreasingDigits(123456789));
        System.out.println("1229999 == " + mid.monotoneIncreasingDigits(1231312));
        System.out.println("129999999 == " + mid.monotoneIncreasingDigits(131232323));
        System.out.println("59999999 == " + mid.monotoneIncreasingDigits(64564323));
        System.out.println("122999 == " + mid.monotoneIncreasingDigits(123143));
        System.out.println("799999 == " + mid.monotoneIncreasingDigits(865832));
    }

    public void maximumSwap() {
        MaximumSwap ms = new MaximumSwap();

        System.out.println("99975952 == " + ms.maximumSwap(99275959));
        System.out.println("1 == " + ms.maximumSwap(1));
        System.out.println("52341 == " + ms.maximumSwap(12345));
        System.out.println("8765321 == " + ms.maximumSwap(8765321));
        System.out.println("72123455 == " + ms.maximumSwap(52123457));
        System.out.println("98123431 == " + ms.maximumSwap(89123431));
        System.out.println("72343211 == " + ms.maximumSwap(12343217));
        System.out.println("98863 == " + ms.maximumSwap(98368));
    }

    public void shortestDistanceAfterRoadAdditionQueriesI() {
        ShortestDistanceAfterRoadAdditionQueriesI sdaraqi = new ShortestDistanceAfterRoadAdditionQueriesI();

        System.out.println("[3,2,1] == " + Arrays.toString(sdaraqi.shortestDistanceAfterQueries(5, new int[][]{{2,4},{0,2},{0,4}})));
        System.out.println("[1,1] == " + Arrays.toString(sdaraqi.shortestDistanceAfterQueries(4, new int[][]{{0,3},{0,2}})));
    }

    public void findKthBitInNthBinaryString() {
        FindKthBitInNthBinaryString fkbinbs = new FindKthBitInNthBinaryString();

        System.out.println("0 == " + fkbinbs.findKthBit(3, 1));
        System.out.println("1 == " + fkbinbs.findKthBit(4, 11));
        System.out.println("0 == " + fkbinbs.findKthBit(2, 1));
        System.out.println("1 == " + fkbinbs.findKthBit(2, 2));
        System.out.println("0 == " + fkbinbs.findKthBit(20, 1000721));
        System.out.println("0 == " + fkbinbs.findKthBit(17, 56129));
    }

    public void parsingABooleanExpression() {
        ParsingABooleanExpression pabe = new ParsingABooleanExpression();

        System.out.println("false == " + pabe.parseBoolExpr("&(|(f))"));
        System.out.println("true == " + pabe.parseBoolExpr("|(f,f,f,t)"));
        System.out.println("true == " + pabe.parseBoolExpr("!(&(f,t))"));
        System.out.println("false == " + pabe.parseBoolExpr("&(|(t,f),!(|(t,!(f))),&(t,f))"));
        System.out.println("true == " + pabe.parseBoolExpr("|(&(t,t),!(f))"));
        System.out.println("false == " + pabe.parseBoolExpr("!(|(t,t,f))"));
        System.out.println("false == " + pabe.parseBoolExpr("&(|(t),|(f,t),&(t,f))"));
        System.out.println("false == " + pabe.parseBoolExpr("!(t)"));
        System.out.println("false == " + pabe.parseBoolExpr("&(&(t),&(t),&(t),&(t),&(f))"));
    }

    public void countSubstringsWithKFrequencyCharactersI() {
        CountSubstringsWithKFrequencyCharactersI cswkfci = new CountSubstringsWithKFrequencyCharactersI();

        System.out.println("15 == " + cswkfci.numberOfSubstrings("abcde", 1));
        System.out.println("703 == " + cswkfci.numberOfSubstrings("retergtrehagrtyhtyhtyhtjyyhtgfdgdfgfe", 1));
        System.out.println("8528 == " + cswkfci.numberOfSubstrings("gdsgjdhgdfjgdgfdbfgdgdsghjuytghnytrfddfgbfbfdvfdvfdgfhfhgfhsshghtrryjtjgfbfdvdsfghyufdvdscdsfdgfgnhgngbfdvfbgfbgfbfgnhgngwefgjynbvdcds", 2));
        System.out.println("7897 == " + cswkfci.numberOfSubstrings("gdsgjdhgdfjgdgfdbfgdgdsghjuytghnytrfddfgbfbfdvfdvfdgfhfhgfhsshghtrryjtjgfbfdvdsfghyufdvdscdsfdgfgnhgngbfdvfbgfbgfbfgnhgngwefgjynbvdcds", 3));
        System.out.println("7408 == " + cswkfci.numberOfSubstrings("gdsgjdhgdfjgdgfdbfgdgdsghjuytghnytrfddfgbfbfdvfdvfdgfhfhgfhsshghtrryjtjgfbfdvdsfghyufdvdscdsfdgfgnhgngbfdvfbgfbgfbfgnhgngwefgjynbvdcds", 4));
        System.out.println("6804 == " + cswkfci.numberOfSubstrings("gdsgjdhgdfjgdgfdbfgdgdsghjuytghnytrfddfgbfbfdvfdvfdgfhfhgfhsshghtrryjtjgfbfdvdsfghyufdvdscdsfdgfgnhgngbfdvfbgfbgfbfgnhgngwefgjynbvdcds", 5));
        System.out.println("6207 == " + cswkfci.numberOfSubstrings("gdsgjdhgdfjgdgfdbfgdgdsghjuytghnytrfddfgbfbfdvfdvfdgfhfhgfhsshghtrryjtjgfbfdvdsfghyufdvdscdsfdgfgnhgngbfdvfbgfbgfbfgnhgngwefgjynbvdcds", 6));
        System.out.println("4 == " + cswkfci.numberOfSubstrings("toxqq", 2));
    }

    public void markElementsOnArrayByPerformingQueries() {
        MarkElementsOnArrayByPerformingQueries meoabpq = new MarkElementsOnArrayByPerformingQueries();

        System.out.println("[8,3,0] == " + Arrays.toString(meoabpq.unmarkedSumArray(new int[]{1,2,2,1,2,3,1}, new int[][]{{1,2},{3,3},{4,2}})));
        System.out.println("[7] == " + Arrays.toString(meoabpq.unmarkedSumArray(new int[]{1,4,2,3}, new int[][]{{0,1}})));
    }

    public void minimumDeletionsToMakeStringKSpecial() {
        MinimumDeletionsToMakeStringKSpecial mdtmsks = new MinimumDeletionsToMakeStringKSpecial();

        System.out.println("3 == " + mdtmsks.minimumDeletions("aabcaba", 0));
        System.out.println("2 == " + mdtmsks.minimumDeletions("dabdcbdcdcd", 2));
        System.out.println("1 == " + mdtmsks.minimumDeletions("aaabaaa", 2));
        System.out.println("19 == " + mdtmsks.minimumDeletions("gdgdfdfgdsghjfgfddsfgbhnjuytrdfsfgfbhnjytrsewsadcvfgbhtyrsewas", 2));
        System.out.println("11 == " + mdtmsks.minimumDeletions("gdgdfdfgdsghjfgfddsfgbhnjuytrdfsfgfbhnjytrsewsadcvfgbhtyrsewas", 4));
        System.out.println("24 == " + mdtmsks.minimumDeletions("gdgdfdfgdsghjfgfddsfgbhnjuytrdfsfgfbhnjytrsewsadcvfgbhtyrsewas", 1));
        System.out.println("1 == " + mdtmsks.minimumDeletions("gdgdfdfgdsghjfgfddsfgbhnjuytrdfsfgfbhnjytrsewsadcvfgbhtyrsewas", 7));
        System.out.println("7 == " + mdtmsks.minimumDeletions("gdgdfdfgdsghjfgfddsfgbhnjuytrdfsfgfbhnjytrsewsadcvfgbhtyrsewas", 5));
    }

    public void removeSubFolderFromTheFilesystem() {
        RemoveSubFolderFromTheFilesystem rsftf = new RemoveSubFolderFromTheFilesystem();

        System.out.println("[/a, /c/d, /c/f] == " + rsftf.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
        System.out.println("[/a] == " + rsftf.removeSubfolders(new String[]{"/a","/a/b/c","/a/b/d"}));
        System.out.println("[/a/b/c, /a/b/ca, /a/b/d] == " + rsftf.removeSubfolders(new String[]{"/a/b/c","/a/b/ca","/a/b/d"}));
    }

    public void minimumNumberOfRemovalsToMakeMountainArray() {
        MinimumNumberOfRemovalsToMakeMountainArray mnortmma = new MinimumNumberOfRemovalsToMakeMountainArray();

        System.out.println("3 == " + mnortmma.minimumMountainRemovals(new int[]{2,1,1,5,6,2,3,1}));
        System.out.println("2 == " + mnortmma.minimumMountainRemovals(new int[]{9,8,1,7,6,5,4,3,2,1}));
        System.out.println("2 == " + mnortmma.minimumMountainRemovals(new int[]{1,2,3,4,5,1000,999,954,953,952,951,950,949,6,7,8,9,10,11,12,13,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,1}));
        System.out.println("7 == " + mnortmma.minimumMountainRemovals(new int[]{1,2,3,4,5,4,5,6,5,4,8,1,3,5,6,4,2,1}));
        System.out.println("10 == " + mnortmma.minimumMountainRemovals(new int[]{5,4,3,2,3,4,5,76,8,7,6,5,3,2,4,5,7,8,67,5,3,2}));
        System.out.println("3 == " + mnortmma.minimumMountainRemovals(new int[]{4,3,7,1,2,4,5,7,8,9,7,5,3,2,1}));
        System.out.println("2 == " + mnortmma.minimumMountainRemovals(new int[]{9,8,1,7,6,5,4,3,2,1}));
        System.out.println("0 == " + mnortmma.minimumMountainRemovals(new int[]{1,2,3,4,5,4}));
        System.out.println("6 == " + mnortmma.minimumMountainRemovals(new int[]{100,92,89,77,74,66,64,66,64}));
    }

    public void equalSumArraysWithMinimumNumberOfOperations() {
        EqualSumArraysWithMinimumNumberOfOperations esawmnoo = new EqualSumArraysWithMinimumNumberOfOperations();

        System.out.println("3 == " + esawmnoo.minOperations(new int[]{1,2,3,4,5,6}, new int[]{1,1,2,2,2,2}));
        System.out.println("-1 == " + esawmnoo.minOperations(new int[]{1,1,1,1,1,1,1}, new int[]{6}));
        System.out.println("3 == " + esawmnoo.minOperations(new int[]{1}, new int[]{6,6}));
        System.out.println("3 == " + esawmnoo.minOperations(new int[]{3,2,1,2,3,4,3,2,1,1,2,3,4,5,6,5,4,3,2,1,1}, new int[]{6,5,4,5,5,6,4,2,1,2,4,3}));
        System.out.println("11 == " + esawmnoo.minOperations(new int[]{1,1,1}, new int[]{6,6,6,6,6,6,6,6,6}));
        System.out.println("-1 == " + esawmnoo.minOperations(new int[]{6}, new int[]{2,2,2,2,2,2,2,2,2,2}));
    }
}