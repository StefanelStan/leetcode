package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.june.MinMaxGame;
import com.ss.leetcode.LC2022.june.NumberOfMatchingSubsequences;
import com.ss.leetcode.LC2022.june.PartitionList;
import com.ss.leetcode.LC2022.june.ReorderDataInLogFiles;
import com.ss.leetcode.shared.ListNode;
import java.util.Arrays;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

//        start.partitionList();
//        start.minMaxGame();
//        start.reorderDataInLogFiles();
        start.numberOfMatchingSubsequences();
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
}