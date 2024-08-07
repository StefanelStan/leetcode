package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.may.CountTripletsThatCanFormTwoArraysOfEqualXOR;
import com.ss.leetcode.LC2024.may.DifferenceOfNumberOfDistinctValuesOnDiagonals;
import com.ss.leetcode.LC2024.may.FindChampionI;
import com.ss.leetcode.LC2024.may.FindTheSafestPathInAGrid;
import com.ss.leetcode.LC2024.may.FindTheScoreOfAllPrefixesOfAnArray;
import com.ss.leetcode.LC2024.may.GroupsOfSpecialEquivalentStrings;
import com.ss.leetcode.LC2024.may.KthSmallestPrimeFraction;
import com.ss.leetcode.LC2024.may.LongestStrictlyIncreasingOrStrictlyDecreasingSubarray;
import com.ss.leetcode.LC2024.may.MatrixSimilarityAfterCyclicShifts;
import com.ss.leetcode.LC2024.may.MaximizeHappinessOfSelectedChildren;
import com.ss.leetcode.LC2024.may.MaximumGoodSubarraySum;
import com.ss.leetcode.LC2024.may.MaximumNumberOfGroupsEnteringACompetition;
import com.ss.leetcode.LC2024.may.Minesweeper;
import com.ss.leetcode.LC2024.may.MinimumCostToHireKWorkers;
import com.ss.leetcode.LC2024.may.MinimumNumberOfPushesToTypeWordII;
import com.ss.leetcode.LC2024.may.NumberOfStepsToReduceANumberInBinaryRepresentationToOne;
import com.ss.leetcode.LC2024.may.NumberOfVisiblePeopleInAQueue;
import com.ss.leetcode.LC2024.may.SpecialArrayWithXElementsGreaterThanOrEqualX;
import com.ss.leetcode.LC2024.may.SumOfAllSubsetXORTotals;
import com.ss.leetcode.LC2024.may.SumOfBeautyInTheArray;
import com.ss.leetcode.LC2024.may.TheNumberOfBeautifulSubsets;
import com.ss.leetcode.LC2024.may.WordBreakII;
import java.util.Arrays;
import java.util.List;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();

//        start.maximumNumberOfGroupsEnteringACompetition();
//        start.minesweeper();
//        start.maximizeHappinessOfSelectedChildren();
//        start.kthSmallestPrimeFraction();
//        start.matrixSimilarityAfterCyclicShifts();
//        start.longestStrictlyIncreasingOrStrictlyDecreasingSubarray();
//        start.minimumCostToHireKWorkers();
//        start.minimumNumberOfPushesToTypeWordII();
//        start.numberOfVisiblePeopleInAQueue();
//        start.findTheSafestPathInAGrid();
//        start.groupsOfSpecialEquivalentStrings();
//        start.differenceOfNumberOfDistinctValuesOnDiagonals();
//        start.findTheScoreOfAllPrefixesOfAnArray();
//        start.sumOfAllSubsetXORTotals();
//        start.findChampionI();
//        start.maximumGoodSubarraySum();
//        start.sumOfBeautyInTheArray();
//        start.theNumberOfBeautifulSubsets();
//        start.wordBreakII();
//        start.specialArrayWithXElementsGreaterThanOrEqualX();
//        start.numberOfStepsToReduceANumberInBinaryRepresentationToOne();
        start.countTripletsThatCanFormTwoArraysOfEqualXOR();
    }

    public void maximumNumberOfGroupsEnteringACompetition() {
        MaximumNumberOfGroupsEnteringACompetition mnogeac = new MaximumNumberOfGroupsEnteringACompetition();

        System.out.println("3 == " + mnogeac.maximumGroups(new int[]{10,6,12,7,3,5}));
        System.out.println("1 == " + mnogeac.maximumGroups(new int[]{8,8}));
        System.out.println("8 == " + mnogeac.maximumGroups(new int[]{4,3,2,3,43,5,56,76,78,8,7,6,56,5,34,23,34,4,5,6,7,88,7,6,5,45,3,3,76,4,5,6,7,8,87,7,6,5,4,3,4,5,6}));
        System.out.println("3 == " + mnogeac.maximumGroups(new int[]{1,1,1,1,1,1,1,1,1}));
        System.out.println("6 == " + mnogeac.maximumGroups(new int[]{1,6,5,4,3,2,3,4,5,4,3,1,2,3,4,2,100,1000,10000,20000,30000}));
        System.out.println("1 == " + mnogeac.maximumGroups(new int[]{1}));
        System.out.println("1 == " + mnogeac.maximumGroups(new int[]{7}));
    }

    public void minesweeper() {
        Minesweeper m = new Minesweeper();

        System.out.println("[[B,1,E,1,B],[B,1,M,1,B],[B,1,1,1,B],[B,B,B,B,B]] == " + Arrays.deepToString(m.updateBoard(new char[][]{{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}}, new int[]{3,0})));
        System.out.println("[[B,1,E,1,B],[B,1,X,1,B],[B,1,1,1,B],[B,B,B,B,B]] == " + Arrays.deepToString(m.updateBoard(new char[][]{{'B','1','E','1','B'},{'B','1','M','1','B'},{'B','1','1','1','B'},{'B','B','B','B','B'}}, new int[]{3,0})));
    }

    public void maximizeHappinessOfSelectedChildren() {
        MaximizeHappinessOfSelectedChildren mhosc = new MaximizeHappinessOfSelectedChildren();

        System.out.println("4 == " + mhosc.maximumHappinessSum(new int[]{1,2,3}, 2));
        System.out.println("1 == " + mhosc.maximumHappinessSum(new int[]{1,1,1,1}, 2));
        System.out.println("5 == " + mhosc.maximumHappinessSum(new int[]{2,3,4,5}, 1));
    }

    public void kthSmallestPrimeFraction() {
        KthSmallestPrimeFraction kspf = new KthSmallestPrimeFraction();

        System.out.println("[2,5] == " + Arrays.toString(kspf.kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3)));
        System.out.println("[1,7] == " + Arrays.toString(kspf.kthSmallestPrimeFraction(new int[]{1,7}, 1)));
    }

    public void matrixSimilarityAfterCyclicShifts() {
        MatrixSimilarityAfterCyclicShifts msacs = new MatrixSimilarityAfterCyclicShifts();

        System.out.println("true == " + msacs.areSimilar(new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 2));
        System.out.println("true == " + msacs.areSimilar(new int[][]{{2,2},{2,2}}, 3));
        System.out.println("false == " + msacs.areSimilar(new int[][]{{1,2}}, 1));
        System.out.println("true == " + msacs.areSimilar(new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 24));
        System.out.println("false == " + msacs.areSimilar(new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 49));
        System.out.println("true == " + msacs.areSimilar(new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 50));
        System.out.println("true == " + msacs.areSimilar(new int[][]{{4}}, 37));
        System.out.println("true == " + msacs.areSimilar(new int[][]{{5},{3},{2}}, 14));
    }

    public void longestStrictlyIncreasingOrStrictlyDecreasingSubarray() {
        LongestStrictlyIncreasingOrStrictlyDecreasingSubarray lsiosds = new LongestStrictlyIncreasingOrStrictlyDecreasingSubarray();

        System.out.println("2 == " + lsiosds.longestMonotonicSubarray(new int[]{1,4,3,3,2}));
        System.out.println("1 == " + lsiosds.longestMonotonicSubarray(new int[]{3,3,3,3}));
        System.out.println("3 == " + lsiosds.longestMonotonicSubarray(new int[]{3,2,1}));
        System.out.println("5 == " + lsiosds.longestMonotonicSubarray(new int[]{1,2,3,4,3,2,3,4,5,6,5,34,3,5,6,34,2,43,46,5,43,44,32,48,5,34,45,24,5,43,45,23,45,4,34,45,5,34,6,15,6,47}));
        System.out.println("1 == " + lsiosds.longestMonotonicSubarray(new int[]{5}));
    }

    public void minimumCostToHireKWorkers() {
        MinimumCostToHireKWorkers mcthkw = new MinimumCostToHireKWorkers();

        System.out.println("105.0 == " + mcthkw.mincostToHireWorkers2(new int[]{10,20,5}, new int[]{70,50,30}, 2));
        System.out.println("30.66667 == " + mcthkw.mincostToHireWorkers2(new int[]{3,1,10,10,1}, new int[]{4,8,2,2,7}, 3));
    }

    public void minimumNumberOfPushesToTypeWordII() {
        MinimumNumberOfPushesToTypeWordII mnopttwii = new MinimumNumberOfPushesToTypeWordII();

        System.out.println("5 == " + mnopttwii.minimumPushes("abcde"));
        System.out.println("12 == " + mnopttwii.minimumPushes("xyzxyzxyzxyz"));
        System.out.println("24 == " + mnopttwii.minimumPushes("aabbccddeeffgghhiiiiii"));
        System.out.println("7 == " + mnopttwii.minimumPushes("aaaaaaa"));
        System.out.println("154 == " + mnopttwii.minimumPushes("ogdgoifgjewifwjeiofepofewifwjhidofwfhjwogfajeofduienmizzkowzokwzmoziwznzwuiwzhgzywgzwuzwnwzoizwhwzizwoizwnpnbzhgvztrdfr"));
    }

    public void numberOfVisiblePeopleInAQueue() {
        NumberOfVisiblePeopleInAQueue novpiaq = new NumberOfVisiblePeopleInAQueue();

        System.out.println("[3,1,2,1,1,0] == " + Arrays.toString(novpiaq.canSeePersonsCount(new int[]{10,6,8,5,11,9})));
        System.out.println("[4,1,1,1,0] == " + Arrays.toString(novpiaq.canSeePersonsCount(new int[]{5,1,2,3,10})));
        System.out.println("[1,1,1,1,1,0] == " + Arrays.toString(novpiaq.canSeePersonsCount(new int[]{1,2,3,4,5,6})));
        System.out.println("[2,2,2,1,1,0] == " + Arrays.toString(novpiaq.canSeePersonsCount(new int[]{10,8,7,6,11,9})));
        System.out.println("[1,3,1,2,1,3,2,1,1,0] == " + Arrays.toString(novpiaq.canSeePersonsCount(new int[]{11,19,12,15,14,18,7,1,8,9})));
        System.out.println("[0] == " + Arrays.toString(novpiaq.canSeePersonsCount(new int[]{5})));
        System.out.println("[1,0] == " + Arrays.toString(novpiaq.canSeePersonsCount(new int[]{5,4})));
        System.out.println("[1,0] == " + Arrays.toString(novpiaq.canSeePersonsCount(new int[]{4,5})));
    }

    public void findTheSafestPathInAGrid() {
        FindTheSafestPathInAGrid ftspiag = new FindTheSafestPathInAGrid();

        System.out.println("0 == " + ftspiag.maximumSafenessFactor(List.of(List.of(1,0,0), List.of(0,0,0), List.of(0,0,1))));
        System.out.println("2 == " + ftspiag.maximumSafenessFactor(List.of(List.of(0,0,1), List.of(0,0,0), List.of(0,0,0))));
        System.out.println("2 == " + ftspiag.maximumSafenessFactor(List.of(List.of(0,0,0,1), List.of(0,0,0,0), List.of(0,0,0,0), List.of(1,0,0,0))));
    }

    public void groupsOfSpecialEquivalentStrings() {
        GroupsOfSpecialEquivalentStrings goses = new GroupsOfSpecialEquivalentStrings();

        System.out.println("3 == " + goses.numSpecialEquivGroups(new String[]{"abcd","cdab","cbad","xyzz","zzxy","zzyx"}));
        System.out.println("3 == " + goses.numSpecialEquivGroups(new String[]{"abc","acb","bac","bca","cab","cba"}));
        System.out.println("1 == " + goses.numSpecialEquivGroups(new String[]{"abcd","cdab","adcb","cbad"}));
    }

    public void differenceOfNumberOfDistinctValuesOnDiagonals() {
        DifferenceOfNumberOfDistinctValuesOnDiagonals donodvod = new DifferenceOfNumberOfDistinctValuesOnDiagonals();

        System.out.println("[[1,1,0],[1,0,1],[0,1,1]] == " + Arrays.deepToString(new int[][]{{1,2,3},{3,1,5},{3,2,1}}));
        System.out.println("[[0]] == " + Arrays.deepToString(new int[][]{{1}}));
        System.out.println("[[3,3,3,4,4,3,3,2,1,0],[3,2,2,2,2,2,1,1,0,1],[2,1,0,0,0,0,0,0,1,2],[1,0,1,1,1,1,1,1,1,2],[0,1,2,3,3,2,2,3,3,2]] == " + Arrays.deepToString(new int[][]{{1,2,3,4,5,6,7,8,9,10},{12,3,5,6,5,4,3,2,1,1},{1,2,3,2,3,4,5,6,7,8},{1,2,3,4,5,6,6,6,6,6},{1,9,8,7,6,6,7,8,9,1}}));
        System.out.println("[[0],[0],[0],[0],[0],[0]] == " + Arrays.deepToString(new int[][]{{4},{5},{9},{1},{3},{10}}));
        System.out.println("[[0,0,0,0,0,0,0,0,0,0,0,0,0,0]] == " + Arrays.deepToString(new int[][]{{3,2,1,2,3,4,5,6,7,8,9,8,7,6}}));
    }

    public void findTheScoreOfAllPrefixesOfAnArray() {
        FindTheScoreOfAllPrefixesOfAnArray ftsoapoaa = new FindTheScoreOfAllPrefixesOfAnArray();

        System.out.println("[4,10,24,36,56] == " + Arrays.toString(ftsoapoaa.findPrefixScore(new int[]{2,3,7,5,10})));
        System.out.println("[2,4,8,16,32,64] == " + Arrays.toString(ftsoapoaa.findPrefixScore(new int[]{1,1,2,4,8,16})));
        System.out.println("[8,15,21,28,36,126,238,372,446,519,591,662,732,811] == " + Arrays.toString(ftsoapoaa.findPrefixScore(new int[]{4,3,2,3,4,45,56,67,7,6,5,4,3,12})));
        System.out.println("[68] == " + Arrays.toString(ftsoapoaa.findPrefixScore(new int[]{34})));
    }

    public void sumOfAllSubsetXORTotals() {
        SumOfAllSubsetXORTotals soasxort = new SumOfAllSubsetXORTotals();

        System.out.println("6 == " + soasxort.subsetXORSum(new int[]{1,3}));
        System.out.println("28 == " + soasxort.subsetXORSum(new int[]{5,1,6}));
        System.out.println("480 == " + soasxort.subsetXORSum(new int[]{3,4,5,6,7,8}));
    }

    public void findChampionI() {
        FindChampionI fci = new FindChampionI();

        System.out.println("0 == " + fci.findChampion(new int[][]{{0,1},{0,0}}));
        System.out.println("1 == " + fci.findChampion(new int[][]{{0,0,1},{1,0,1},{0,0,0}}));
    }

    public void maximumGoodSubarraySum() {
        MaximumGoodSubarraySum mgss = new MaximumGoodSubarraySum();

        System.out.println("11 == " + mgss.maximumSubarraySum(new int[]{1,2,3,4,5,6}, 1));
        System.out.println("11 == " + mgss.maximumSubarraySum(new int[]{-1,3,2,4,5}, 3));
        System.out.println("-6 == " + mgss.maximumSubarraySum(new int[]{-1,-2,-3,-4}, 2));
    }

    public void sumOfBeautyInTheArray() {
        SumOfBeautyInTheArray sobita = new SumOfBeautyInTheArray();

        System.out.println("2 == " + sobita.sumOfBeauties(new int[]{1,2,3}));
        System.out.println("1 == " + sobita.sumOfBeauties(new int[]{2,4,6,4}));
        System.out.println("0 == " + sobita.sumOfBeauties(new int[]{3,2,1}));
        System.out.println("6 == " + sobita.sumOfBeauties(new int[]{4,3,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2}));
        System.out.println("20 == " + sobita.sumOfBeauties(new int[]{12,13,14,23,24,25,34,35,36,45,46,47}));
        System.out.println("0 == " + sobita.sumOfBeauties(new int[]{5,5,5,5,5,8}));
    }

    public void theNumberOfBeautifulSubsets() {
        TheNumberOfBeautifulSubsets tnobs = new TheNumberOfBeautifulSubsets();

        System.out.println("4 == " + tnobs.beautifulSubsets(new int[]{2,4,6}, 2));
        System.out.println("1 == " + tnobs.beautifulSubsets(new int[]{1}, 1));
        System.out.println("19403 == " + tnobs.beautifulSubsets(new int[]{4,3,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8,9,1}, 5));
        System.out.println("17710 == " + tnobs.beautifulSubsets(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, 1));
        System.out.println("20735 == " + tnobs.beautifulSubsets(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, 2));
        System.out.println("24275 == " + tnobs.beautifulSubsets(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, 3));
        System.out.println("28560 == " + tnobs.beautifulSubsets(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, 4));
        System.out.println("32767 == " + tnobs.beautifulSubsets(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, 5));
    }

    public void wordBreakII() {
        WordBreakII wbii = new WordBreakII();

        System.out.println("[cats and dog, cat sand dog] == " + wbii.wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
//        System.out.println("[pine apple pen apple, pineapple pen apple, pine applepen apple] == " + wbii.wordBreak("pineapplepenapple", List.of("apple","pen","applepen","pine","pineapple")));
//        System.out.println("[] == " + wbii.wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
    }

    public void specialArrayWithXElementsGreaterThanOrEqualX() {
        SpecialArrayWithXElementsGreaterThanOrEqualX sawxegtoex = new SpecialArrayWithXElementsGreaterThanOrEqualX();

        System.out.println("2 == " + sawxegtoex.specialArray(new int[]{3,5}));
        System.out.println("-1 == " + sawxegtoex.specialArray(new int[]{0,0}));
        System.out.println("3 == " + sawxegtoex.specialArray(new int[]{0,4,3,0,4}));
    }

    public void numberOfStepsToReduceANumberInBinaryRepresentationToOne() {
        NumberOfStepsToReduceANumberInBinaryRepresentationToOne nostranibrto = new NumberOfStepsToReduceANumberInBinaryRepresentationToOne();

        System.out.println("6 == " + nostranibrto.numSteps("1101"));
        System.out.println("1 == " + nostranibrto.numSteps("10"));
        System.out.println("0 == " + nostranibrto.numSteps("1"));
        System.out.println("0 == " + nostranibrto.numSteps("1"));
        System.out.println("33 == " + nostranibrto.numSteps("100101010101010010101"));
        System.out.println("5 == " + nostranibrto.numSteps("101"));
        System.out.println("3 == " + nostranibrto.numSteps("11"));
    }

    public void countTripletsThatCanFormTwoArraysOfEqualXOR() {
        CountTripletsThatCanFormTwoArraysOfEqualXOR cttcftaoexor = new CountTripletsThatCanFormTwoArraysOfEqualXOR();

        System.out.println("4 == " + cttcftaoexor.countTriplets(new int[]{2,3,1,6,7}));
        System.out.println("10 == " + cttcftaoexor.countTriplets(new int[]{1,1,1,1,1}));
        System.out.println("10425 == " + cttcftaoexor.countTriplets(new int[]{7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7}));
    }
}
