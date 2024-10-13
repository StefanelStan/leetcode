package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.october.CheckIfStringsCanBeMadeEqualWithOperationsI;
import com.ss.leetcode.LC2024.october.CountSubstringsStartingAndEndingWithGivenCharacter;
import com.ss.leetcode.LC2024.october.DividePlayersIntoTeamsOfEqualSkill;
import com.ss.leetcode.LC2024.october.FindTheGridOfRegionAverage;
import com.ss.leetcode.LC2024.october.MakeSumDivisibleByP;
import com.ss.leetcode.LC2024.october.MaximumSumBSTInBinaryTree;
import com.ss.leetcode.LC2024.october.MaximumWidthRamp;
import com.ss.leetcode.LC2024.october.MinimumNumberOfSwapsToMakeTheStringBalanced;
import com.ss.leetcode.LC2024.october.MinimumOperationsToMakeBinaryArrayElementsEqualToOneI;
import com.ss.leetcode.LC2024.october.MinimumStringLengthAfterRemovingSubstrings;
import com.ss.leetcode.LC2024.october.ReportSpamMessage;
import com.ss.leetcode.LC2024.october.SplitArrayIntoMaximumNumberOfSubarrays;
import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
        start.countSubstringsStartingAndEndingWithGivenCharacter();
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
}