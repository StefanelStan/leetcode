package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.june.CountSquareSubmatricesWithAllOnes;
import com.ss.leetcode.LC2022.june.FindPlayersWithZeroOrOneLosses;
import com.ss.leetcode.LC2022.june.MatchSubstringAfterReplacement;
import com.ss.leetcode.LC2022.june.MaximumErasureValue;
import com.ss.leetcode.LC2022.june.MinMaxGame;
import com.ss.leetcode.LC2022.june.MinimumDifferenceBetweenHALOfKScores;
import com.ss.leetcode.LC2022.june.MinimumOperationsToReduceXToZero;
import com.ss.leetcode.LC2022.june.NumberOfMatchingSubsequences;
import com.ss.leetcode.LC2022.june.PartitionList;
import com.ss.leetcode.LC2022.june.PrefixAndSuffixSearch;
import com.ss.leetcode.LC2022.june.ReorderDataInLogFiles;
import com.ss.leetcode.LC2022.june.StrongPasswordCheckerII;
import com.ss.leetcode.LC2022.june.SuccessfulPairsOfSpellsAndPotions;
import com.ss.leetcode.LC2022.june.Triangle;
import com.ss.leetcode.shared.ListNode;
import java.util.Arrays;
import java.util.List;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

//        start.partitionList();
//        start.minMaxGame();
//        start.reorderDataInLogFiles();
//        start.numberOfMatchingSubsequences();
//        start.minimumOperationsToReduceXToZero();
//        start.strongPasswordCheckerII();
//        start.successfulPairsOfSpellsAndPotions();
//        start.matchSubstringAfterReplacement();
//        start.maximumErasureValue();
//        start.triangle();
//        start.findPlayersWithZeroOrOneLosses();
//        start.countSquareSubmatricesWithAllOnes();
//        start.prefixAndSuffixSearch();
        start.minimumDifferenceBetweenHighestAndLowestOfKScores();
    }

    public void partitionList() {
        PartitionList pl = new PartitionList();

        System.out.println("[1,2,2,4,3,5] == " + pl.partition(ListNode.makeChain(new int[]{1,4,3,2,5,2}), 3).getAsList());
        System.out.println("[1,2] == " + pl.partition(ListNode.makeChain(new int[]{2,1}), 2).getAsList());
        System.out.println("[3,2,1,9,8,7,6,5,4] == " + pl.partition(ListNode.makeChain(new int[]{9,8,7,6,5,4,3,2,1}), 4).getAsList());
        System.out.println("[1,1,1,1,1,1,1] == " + pl.partition(ListNode.makeChain(new int[]{1,1,1,1,1,1,1}), 2).getAsList());
        System.out.println("[1,1,1,1,1,1,1,1,1,2,3] == " + pl.partition(ListNode.makeChain(new int[]{1,1,1,1,1,1,2,1,1,1,3}), 2).getAsList());
        System.out.println("[1,2] == " + pl.partition(ListNode.makeChain(new int[]{1,2}), 2).getAsList());
        System.out.println("[1,2,3] == " + pl.partition(ListNode.makeChain(new int[]{2,1,3}), 2).getAsList());
    }

    public void minMaxGame() {
        MinMaxGame mmg = new MinMaxGame();

        System.out.println("1 == " + mmg.minMaxGame(new int[]{1,3,5,2,4,8,2,2}));
        System.out.println("3 == " + mmg.minMaxGame(new int[]{3}));
        System.out.println("3 == " + mmg.minMaxGame(new int[]{8,3,2,88,11,77,22,11,65,124,123,67,13,98,12,52}));
        System.out.println("5 == " + mmg.minMaxGame(new int[]{5,8}));
    }

    public void reorderDataInLogFiles() {
        ReorderDataInLogFiles rdilf = new ReorderDataInLogFiles();

        System.out.println("[let1 art can, let3 art zero, let2 own kit dig, dig1 8 1 5 1, dig2 3 6] == " +
            Arrays.toString(rdilf.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})));

        System.out.println("[g1 act car, a8 act zoo, ab1 off key dog, a1 9 2 3 1, zo4 4 7] == " +
            Arrays.toString(rdilf.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
    }

    public void numberOfMatchingSubsequences() {
        NumberOfMatchingSubsequences noms = new NumberOfMatchingSubsequences();

        System.out.println("3 == " + noms.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
        System.out.println("2 == " + noms.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
    }

    public void strongPasswordCheckerII() {
        StrongPasswordCheckerII spcii = new StrongPasswordCheckerII();

        System.out.println("true == " + spcii.strongPasswordCheckerII("IloveLe3tcode!"));
        System.out.println("false == " + spcii.strongPasswordCheckerII("Me+You--IsMyDream"));
        System.out.println("false == " + spcii.strongPasswordCheckerII("1aB!"));
    }

    public void successfulPairsOfSpellsAndPotions() {
        SuccessfulPairsOfSpellsAndPotions sposap = new SuccessfulPairsOfSpellsAndPotions();

        System.out.println("[4,0,3] == " + Arrays.toString(sposap.successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7)));
        System.out.println("[2,0,2] == " + Arrays.toString(sposap.successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16)));
        System.out.println("[2,0,2] == " + Arrays.toString(sposap.successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 2986127332L)));
    }

    public void matchSubstringAfterReplacement() {
        MatchSubstringAfterReplacement msar = new MatchSubstringAfterReplacement();

        System.out.println("true == " + msar.matchReplacement("fool3e7bar","leet", new char[][]{{'e','3'},{'t','7'},{'t','8'}}));
        System.out.println("false == " + msar.matchReplacement("fooleetbar","f00l", new char[][]{{'o','0'}}));
        System.out.println("true == " + msar.matchReplacement("Fool33tbaR","leetd", new char[][]{{'e','3'},{'t','7'},{'t','8'},{'d','b'},{'p','b'}}));
    }

    public void minimumOperationsToReduceXToZero() {
        MinimumOperationsToReduceXToZero motrxtz = new MinimumOperationsToReduceXToZero();

        System.out.println("2 == " + motrxtz.minOperations(new int[]{1,1,4,2,3}, 5));
        System.out.println("-1 == " + motrxtz.minOperations(new int[]{5,6,7,8,9}, 4));
        System.out.println("5 == " + motrxtz.minOperations(new int[]{3,2,20,1,1,3}, 10));
        System.out.println("1 == " + motrxtz.minOperations(new int[]{5,2,3,1,1}, 5));
    }

    public void maximumErasureValue() {
        MaximumErasureValue mev = new MaximumErasureValue();

        System.out.println("17 == " + mev.maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println("8 == " + mev.maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }

    public void triangle() {
        Triangle t = new Triangle();

        System.out.println("11 == " + t.minimumTotal(List.of(List.of(2), List.of(3,4),List.of(6,5,7), List.of(4,1,8,3))));
        System.out.println("-10 == " + t.minimumTotal(List.of(List.of(-10))));
    }

    public void findPlayersWithZeroOrOneLosses() {
        FindPlayersWithZeroOrOneLosses fpwzool = new FindPlayersWithZeroOrOneLosses();

        System.out.println("[[1,2,10],[4,5,7,8]] == "
            + fpwzool.findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}}));
        System.out.println("[[1,2,5,6],[]] == " + fpwzool.findWinners(new int[][]{{2,3},{1,3},{5,4},{6,4}}));
    }

    public void countSquareSubmatricesWithAllOnes() {
        CountSquareSubmatricesWithAllOnes csswao = new CountSquareSubmatricesWithAllOnes();

        System.out.println("15 == " + csswao.countSquares(new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}}));
        System.out.println("7 == " + csswao.countSquares(new int[][]{{1,0,1},{1,1,0},{1,1,0}}));
    }

    public void prefixAndSuffixSearch() {
        PrefixAndSuffixSearch pass = new PrefixAndSuffixSearch(new String[]{"apple", "cider", "tram", "tramm"});

        System.out.println("0 == " + pass.f("a", "e"));
        System.out.println("-1 == " + pass.f("c", "e"));
        System.out.println("1 == " + pass.f("c", "r"));
        System.out.println("1 == " + pass.f("ci", "er"));
        System.out.println("-1 == " + pass.f("ci", "re"));
        System.out.println("-1 == " + pass.f("ci", "re"));
        System.out.println("2 == " + pass.f("tr", "am"));
        System.out.println("3 == " + pass.f("tr", "m"));
        System.out.println("3 == " + pass.f("tr", "mm"));

        pass = new PrefixAndSuffixSearch(new String[]{"a","a","a","a","a","b","b","b","b","b"});

        System.out.println("4 == " + pass.f("a","a"));
        System.out.println("4 == " + pass.f("a","a"));
        System.out.println("9 == " + pass.f("b","b"));
    }

    public void minimumDifferenceBetweenHighestAndLowestOfKScores() {
        MinimumDifferenceBetweenHALOfKScores mdbhaloks = new MinimumDifferenceBetweenHALOfKScores();

        System.out.println("0 == " + mdbhaloks.minimumDifference(new int[]{90}, 1));
        System.out.println("2 == " + mdbhaloks.minimumDifference(new int[]{9,4,1,7}, 2));
    }
}