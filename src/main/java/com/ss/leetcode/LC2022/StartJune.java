package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.june.MinimumMovesToEqualArrayElementsII;
import com.ss.leetcode.LC2022.june.CountAsterisks;
import com.ss.leetcode.LC2022.june.CountNodesWithTheHighestScore;
import com.ss.leetcode.LC2022.june.CountSquareSubmatricesWithAllOnes;
import com.ss.leetcode.LC2022.june.FindPlayersWithZeroOrOneLosses;
import com.ss.leetcode.LC2022.june.FurthestBuildingYouCanReach;
import com.ss.leetcode.LC2022.june.MatchSubstringAfterReplacement;
import com.ss.leetcode.LC2022.june.MaximumErasureValue;
import com.ss.leetcode.LC2022.june.MaximumPointsYouCanObtainFromCards;
import com.ss.leetcode.LC2022.june.MaximumXORAfterOperations;
import com.ss.leetcode.LC2022.june.MinMaxGame;
import com.ss.leetcode.LC2022.june.MinimumDeletionsToMakeCharacterFrequenciesUnique;
import com.ss.leetcode.LC2022.june.MinimumDifferenceBetweenHALOfKScores;
import com.ss.leetcode.LC2022.june.MinimumNumberOfOperationsToConvertTime;
import com.ss.leetcode.LC2022.june.MinimumOperationsToReduceXToZero;
import com.ss.leetcode.LC2022.june.NumberOfMatchingSubsequences;
import com.ss.leetcode.LC2022.june.PartitionList;
import com.ss.leetcode.LC2022.june.PrefixAndSuffixSearch;
import com.ss.leetcode.LC2022.june.QueueReconstructionByHeight;
import com.ss.leetcode.LC2022.june.ReorderDataInLogFiles;
import com.ss.leetcode.LC2022.june.SearchSuggestionsSystem;
import com.ss.leetcode.LC2022.june.ShortEncodingOfWords;
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
        start.successfulPairsOfSpellsAndPotions();
//        start.matchSubstringAfterReplacement();
//        start.maximumErasureValue();
//        start.triangle();
//        start.findPlayersWithZeroOrOneLosses();
//        start.countSquareSubmatricesWithAllOnes();
//        start.prefixAndSuffixSearch();
//        start.minimumDifferenceBetweenHighestAndLowestOfKScores();
//        start.searchSuggestionsSystem();
//        start.shortEncodingOfWords();
//        start.furthestBuildingYouCanReach();
//        start.minimumNumberOfOperationsToConvertTime();
//        start.countAsterisks();
//        start.countUnreachablePairsOfNodesInAnUndirectedGraph();
//        start.maximumXORAfterOperations();
//        start.maximumPointsYouCanObtainFromCards();
//        start.countNodesWithTheHighestScore();
//        start.minimumDeletionsToMakeCharacterFrequenciesUnique();
//        start.queueReconstructionByHeight();
//        start.minimumMovesToEqualArrayElementsII();
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
        System.out.println("[5,5,5] == " + Arrays.toString(sposap.successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 1)));
        System.out.println("[2,0,2] == " + Arrays.toString(sposap.successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16)));
        System.out.println("[0,0,0] == " + Arrays.toString(sposap.successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 2986127332L)));
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

    public void searchSuggestionsSystem() {
        SearchSuggestionsSystem sss = new SearchSuggestionsSystem();

        System.out.println("[[mobile, moneypot, monitor],[mobile, moneypot, monitor],[mouse, mousepad],[mouse, mousepad],[mouse, mousepad]] == "
            + sss.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
        System.out.println("[[havana],[havana],[havana],[havana],[havana],[havana]] == "
            + sss.suggestedProducts(new String[]{"havana"}, "havana"));
        System.out.println("[[baggage, bags, banner],[baggage, bags, banner],[baggage, bags],[bags]] == "
            + sss.suggestedProducts(new String[]{"bags","baggage","banner","box","cloths"}, "bags"));
    }

    public void shortEncodingOfWords() {
        ShortEncodingOfWords seow = new ShortEncodingOfWords();

        System.out.println("10 == " + seow.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println("2 == " + seow.minimumLengthEncoding(new String[]{"t"}));
    }

    public void furthestBuildingYouCanReach() {
        FurthestBuildingYouCanReach fbycr = new FurthestBuildingYouCanReach();

        System.out.println("4 == " + fbycr.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
        System.out.println("7 == " + fbycr.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
        System.out.println("3 == " + fbycr.furthestBuilding(new int[]{14,3,19,3}, 17, 0));
    }

    public void minimumNumberOfOperationsToConvertTime() {
        MinimumNumberOfOperationsToConvertTime mnootct = new MinimumNumberOfOperationsToConvertTime();

        System.out.println("3 == " + mnootct.convertTime("02:30", "04:35"));
        System.out.println("1 == " + mnootct.convertTime("11:00", "11:01"));
        System.out.println("6 == " + mnootct.convertTime("03:48", "04:16"));
    }

    public void countAsterisks() {
        CountAsterisks ca = new CountAsterisks();

        System.out.println("2 == " + ca.countAsterisks("l|*e*et|c**o|*de|"));
        System.out.println("0 == " + ca.countAsterisks("iamprogrammer"));
        System.out.println("5 == " + ca.countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }

    public void maximumXORAfterOperations() {
        MaximumXORAfterOperations mxorao = new MaximumXORAfterOperations();

        System.out.println("7 == " + mxorao.maximumXOR(new int[]{3,2,4,6}));
        System.out.println("11 == " + mxorao.maximumXOR(new int[]{1,2,3,9,2}));
        System.out.println("640 == " + mxorao.maximumXOR(new int[]{640}));
    }

    public void maximumPointsYouCanObtainFromCards() {
        MaximumPointsYouCanObtainFromCards mpycofc = new MaximumPointsYouCanObtainFromCards();

        System.out.println("12 == " + mpycofc.maxScore(new int[]{1,2,3,4,5,6,1}, 3));
        System.out.println("4 == " + mpycofc.maxScore(new int[]{2,2,2}, 2));
        System.out.println("55 == " + mpycofc.maxScore(new int[]{9,7,7,9,7,7,9}, 7));
    }

    public void countNodesWithTheHighestScore() {
        CountNodesWithTheHighestScore cnwths = new CountNodesWithTheHighestScore();

        System.out.println("3 == " + cnwths.countHighestScoreNodes(new int[]{-1,2,0,2,0}));
        System.out.println("2 == " + cnwths.countHighestScoreNodes(new int[]{-1,2,0}));
    }

    public void minimumDeletionsToMakeCharacterFrequenciesUnique() {
        MinimumDeletionsToMakeCharacterFrequenciesUnique mdtmcfu = new MinimumDeletionsToMakeCharacterFrequenciesUnique();

        System.out.println("0 == " + mdtmcfu.minDeletions("aab"));
        System.out.println("2 == " + mdtmcfu.minDeletions("aaabbbcc"));
        System.out.println("2 == " + mdtmcfu.minDeletions("ceabaacb"));
        System.out.println("1 == " + mdtmcfu.minDeletions("rrrttt"));
        System.out.println("1 == " + mdtmcfu.minDeletions("accdcdadddbaadbc"));
        System.out.println("276 == " + mdtmcfu.minDeletions("abcdefghijklmnopqrstuvwxwzabcdefghijklmn"
            + "opqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrst"
            + "uvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwz"
            + "abcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdef"
            + "ghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijkl"
            + "mnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqr"
            + "stuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwx"
            + "wzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcd"
            + "efghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghij"
            + "klmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnop"
            + "qrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuv"
            + "wxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzab"
            + "cdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefgh"
            + "ijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklm"
            + "nopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrs"
            + "tuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxw"
            + "zabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcde"
            + "fghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijk"
            + "lmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopq"
            + "rstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvw"
            + "xwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabc"
            + "defghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghi"
            + "jklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmno"
            + "pqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstu"
            + "vwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwz"));
    }

    public void queueReconstructionByHeight() {
        QueueReconstructionByHeight qrbh = new QueueReconstructionByHeight();

        System.out.println("[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] == "
            + Arrays.deepToString(qrbh.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}})));
        System.out.println("[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]] == "
            + Arrays.deepToString(qrbh.reconstructQueue(new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}})));
        System.out.println("[[0,0],[6,0],[1,1],[5,1],[5,2],[4,3],[7,0],[6,2],[5,5],[6,3]] == "
            + Arrays.deepToString(qrbh.reconstructQueue(new int[][]{{0,0},{6,2},{5,5},{4,3},{5,2},{1,1},{6,0},{6,3},{7,0},{5,1}})));
    }

    public void minimumMovesToEqualArrayElementsII() {
        MinimumMovesToEqualArrayElementsII mmteaeii = new MinimumMovesToEqualArrayElementsII();

        System.out.println("2 == " + mmteaeii.minMoves2(new int[]{1,2,3}));
        System.out.println("16 == " + mmteaeii.minMoves2(new int[]{1,10,2,9}));
        System.out.println("294 == " + mmteaeii.minMoves2(new int[]{-45,23,17,17,-18,-10,0,12,9,13,90,13,12,13,11,7,-4,-7,-16}));
    }
}