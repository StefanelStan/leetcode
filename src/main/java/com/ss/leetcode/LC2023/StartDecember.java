package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.december.CountLatticePointsInsideACircle;
import com.ss.leetcode.LC2023.december.DecodeWays;
import com.ss.leetcode.LC2023.december.DesignAFoodRatingSystem;
import com.ss.leetcode.LC2023.december.DetectSquares;
import com.ss.leetcode.LC2023.december.FindChampionII;
import com.ss.leetcode.LC2023.december.MaximumAbsoluteSumOfAnySubarray;
import com.ss.leetcode.LC2023.december.MinimumAdditionsToMakeValidString;
import com.ss.leetcode.LC2023.december.MinimumNumberOfChangesToMakeBinaryStringBeautiful;
import com.ss.leetcode.LC2023.december.MinimumTimeToMakeRopeColorful;
import com.ss.leetcode.LC2023.december.NumberOfDiceRollsWithTargetSum;
import com.ss.leetcode.LC2023.december.PartitionStringIntoMinimumBeautifulSubstrings;
import com.ss.leetcode.LC2023.december.RemoveZeroSumConsecutiveNodesFromLinkedList;
import com.ss.leetcode.LC2023.december.SeparateBlackAndWhiteBalls;
import com.ss.leetcode.LC2023.december.StringCompressionII;
import com.ss.leetcode.LC2023.december.TaskScheduler;
import com.ss.leetcode.shared.ListNode;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

//        start.partitionStringIntoMinimumBeautifulSubstrings();
//        start.minimumAdditionsToMakeValidString();
//        start.removeZeroSumConsecutiveNodesFromLinkedList();
//        start.maximumAbsoluteSumOfAnySubarray();
//        start.designAFoodRatingSystem();
//        start.separateBlackAndWhiteBalls();
//        start.detectSquares();
//        start.findChampionII();
//        start.decodeWays();
//        start.numberOfDiceRollsWithTargetSum();
//        start.minimumTimeToMakeRopeColorful();
//        start.stringCompressionII();
//        start.countLatticePointsInsideACircle();
//        start.taskScheduler();
        start.minimumNumberOfChangesToMakeBinaryStringBeautiful();
    }

    public void partitionStringIntoMinimumBeautifulSubstrings() {
        PartitionStringIntoMinimumBeautifulSubstrings psimbs = new PartitionStringIntoMinimumBeautifulSubstrings();

        System.out.println("2 == " + psimbs.minimumBeautifulSubstrings("1011"));
        System.out.println("3 == " + psimbs.minimumBeautifulSubstrings("111"));
        System.out.println("-1 == " + psimbs.minimumBeautifulSubstrings("0"));
        System.out.println("2 == " + psimbs.minimumBeautifulSubstrings("1100001101011"));
        System.out.println("4 == " + psimbs.minimumBeautifulSubstrings("100111000110111"));
    }

    public void minimumAdditionsToMakeValidString() {
        MinimumAdditionsToMakeValidString matmvs = new MinimumAdditionsToMakeValidString();

        System.out.println("2 == " + matmvs.addMinimum("b"));
        System.out.println("6 == " + matmvs.addMinimum("aaa"));
        System.out.println("0 == " + matmvs.addMinimum("abc"));
    }

    public void removeZeroSumConsecutiveNodesFromLinkedList() {
        RemoveZeroSumConsecutiveNodesFromLinkedList rzscnfll = new RemoveZeroSumConsecutiveNodesFromLinkedList();

        System.out.println("[3,1] == " + rzscnfll.removeZeroSumSublists(ListNode.makeChain(new int[]{1,2,-3,3,1})).getAsList());
        System.out.println("[1,2,4] == " + rzscnfll.removeZeroSumSublists(ListNode.makeChain(new int[]{1,2,3,-3,4})).getAsList());
        System.out.println("[1] == " + rzscnfll.removeZeroSumSublists(ListNode.makeChain(new int[]{1,2,3,-3,-2})).getAsList());
    }

    public void maximumAbsoluteSumOfAnySubarray() {
        MaximumAbsoluteSumOfAnySubarray masoas = new MaximumAbsoluteSumOfAnySubarray();

        System.out.println("5 == " + masoas.maxAbsoluteSum(new int[]{1,-3,2,3,-4}));
        System.out.println("8 == " + masoas.maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
    }

    public void designAFoodRatingSystem() {
        DesignAFoodRatingSystem dafrs = new DesignAFoodRatingSystem(new String[]{"czopaaeyl","lxoozsbh","kbaxapl"}, new String[]{"dmnuqeatj","dmnuqeatj","dmnuqeatj"}, new int[]{11,2,15});

        dafrs.changeRating("czopaaeyl", 12);
        System.out.println("kbaxapl == " + dafrs.highestRated("dmnuqeatj"));
        dafrs.changeRating("kbaxapl", 8);
        dafrs.changeRating("lxoozsbh", 5);
        System.out.println("czopaaeyl == " + dafrs.highestRated("dmnuqeatj"));
    }

    public void separateBlackAndWhiteBalls() {
        SeparateBlackAndWhiteBalls sbawb = new SeparateBlackAndWhiteBalls();

        System.out.println("1 == " + sbawb.minimumSteps("101"));
        System.out.println("2 == " + sbawb.minimumSteps("100"));
        System.out.println("0 == " + sbawb.minimumSteps("0111"));
    }

    public void detectSquares() {
        DetectSquares ds = new DetectSquares();

        ds.add(new int[]{3,10});
        ds.add(new int[]{11,2});
        ds.add(new int[]{3,2});
        System.out.println("1 == " + ds.count(new int[]{11,10}));
        ds.add(new int[]{11,2});
        System.out.println("2 == " + ds.count(new int[]{11,10}));

        ds = new DetectSquares();
        ds.add(new int[]{5,10});
        ds.add(new int[]{10,5});
        ds.add(new int[]{10,10});
        System.out.println("1 == " + ds.count(new int[]{5,5}));
        ds.add(new int[]{3,0});
        ds.add(new int[]{8,0});
        ds.add(new int[]{8,5});
        System.out.println("1 == " + ds.count(new int[]{3,5}));
    }

    public void findChampionII() {
        FindChampionII fcii = new FindChampionII();

        System.out.println("0 == " + fcii.findChampion(3, new int[][]{{0,1},{1,2}}));
        System.out.println("-1 == " + fcii.findChampion(4, new int[][]{{0,2},{1,3},{1,2}}));
        System.out.println("0 == " + fcii.findChampion(1, new int[0][0]));
        System.out.println("-1 == " + fcii.findChampion(3, new int[][]{{1,0}}));
    }

    public void decodeWays() {
        DecodeWays dw = new DecodeWays();

        System.out.println("2 == "+ dw.numDecodings("12"));
        System.out.println("3 == "+ dw.numDecodings("226"));
        System.out.println("0 == "+ dw.numDecodings("06"));
        System.out.println("3 == "+ dw.numDecodings("112"));
    }

    public void numberOfDiceRollsWithTargetSum() {
        NumberOfDiceRollsWithTargetSum nodrwts = new NumberOfDiceRollsWithTargetSum();

        System.out.println("1 == " + nodrwts.numRollsToTarget(1, 6, 3));
        System.out.println("6 == " + nodrwts.numRollsToTarget(2, 6, 7));
        System.out.println("222616187 == " + nodrwts.numRollsToTarget(30, 30, 500));
        System.out.println("0 == " + nodrwts.numRollsToTarget(2, 4, 1));
        System.out.println("0 == " + nodrwts.numRollsToTarget(2, 4, 9));
    }

    public void minimumTimeToMakeRopeColorful() {
        MinimumTimeToMakeRopeColorful mttmrc = new MinimumTimeToMakeRopeColorful();

        System.out.println("3 == " + mttmrc.minCost("abaac", new int[]{1,2,3,4,5}));
        System.out.println("0 == " + mttmrc.minCost("abc", new int[]{1,2,3}));
        System.out.println("2 == " + mttmrc.minCost("aabaa", new int[]{1,2,3,4,1}));
    }

    public void stringCompressionII() {
        StringCompressionII scii = new StringCompressionII();

        System.out.println("4 == " + scii.getLengthOfOptimalCompression("aaabcccd", 2));
        System.out.println("2 == " + scii.getLengthOfOptimalCompression("aabbaa", 2));
        System.out.println("3 == " + scii.getLengthOfOptimalCompression("aaaaaaaaaaa", 0));
    }

    public void countLatticePointsInsideACircle() {
        CountLatticePointsInsideACircle clpiac = new CountLatticePointsInsideACircle();

        System.out.println("5 == " + clpiac.countLatticePoints(new int[][]{{2,2,1}}));
        System.out.println("16 == " + clpiac.countLatticePoints(new int[][]{{2,2,2},{3,4,1}}));
        System.out.println("31417 == " + clpiac.countLatticePoints(new int[][]{{50,100,25},{100,100,100}}));
    }

    public void taskScheduler() {
        TaskScheduler ts = new TaskScheduler();

        System.out.println("8 == " + ts.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println("6 == " + ts.leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
        System.out.println("16 == " + ts.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }

    public void minimumNumberOfChangesToMakeBinaryStringBeautiful() {
        MinimumNumberOfChangesToMakeBinaryStringBeautiful mnoctmbsb = new MinimumNumberOfChangesToMakeBinaryStringBeautiful();

        System.out.println("2 == " + mnoctmbsb.minChanges("1001"));
        System.out.println("1 == " + mnoctmbsb.minChanges("10"));
        System.out.println("0 == " + mnoctmbsb.minChanges("0000"));
        System.out.println("0 == " + mnoctmbsb.minChanges("0000"));
        System.out.println("0 == " + mnoctmbsb.minChanges("11"));
        System.out.println("32 == " + mnoctmbsb.minChanges("111100011001100101000101111010101010101010011110010100010100101101010101010010101001"));
    }
}
