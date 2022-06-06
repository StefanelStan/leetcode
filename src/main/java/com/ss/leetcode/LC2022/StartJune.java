package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.june.MinMaxGame;
import com.ss.leetcode.LC2022.june.PartitionList;
import com.ss.leetcode.shared.ListNode;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

//        start.partitionList();
        start.minMaxGame();
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
}