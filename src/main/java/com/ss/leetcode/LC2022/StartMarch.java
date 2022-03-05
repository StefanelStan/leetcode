package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.march.AllAncestorsOfANodeInADirectedAcyclicGraph;
import com.ss.leetcode.LC2022.march.ChampagneTower;
import com.ss.leetcode.LC2022.march.CountOperationsToObtainZero;
import com.ss.leetcode.LC2022.march.CountingWordsWithAGivenPrefix;
import com.ss.leetcode.LC2022.march.DeleteAndEarn;
import com.ss.leetcode.LC2022.march.MostFrequentNumberFollowingKeyInAnArray;
import com.ss.leetcode.LC2022.march.SortTheJumbledNumbers;

import java.util.Arrays;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();

//        start.countOperationsToObtainZero();
//        start.countWordsWithAGivenPrefix();
//        start.champagneTower();
//        start.mostFrequentNumberFollowingKeyInAnArray();
//        start.sortTheJumbledNumbers();
//        start.allAncestorsOfANodeInADirectedAcyclicGraph();
        start.deleteAndEarn();
    }

    public void countOperationsToObtainZero() {
        CountOperationsToObtainZero cotoz = new CountOperationsToObtainZero();

        System.out.println("3 == " + cotoz.countOperations(2, 3));
        System.out.println("1 == " + cotoz.countOperations(10, 10));
    }

    public void countWordsWithAGivenPrefix() {
        CountingWordsWithAGivenPrefix cwwagp = new CountingWordsWithAGivenPrefix();

        System.out.println("2 == " + cwwagp.prefixCount(new String[]{"pay","attention","practice","attend"}, "at"));
        System.out.println("0 == " + cwwagp.prefixCount(new String[]{"leetcode","win","loops","success"}, "code"));
    }

    public void champagneTower() {
        ChampagneTower ct = new ChampagneTower();

        System.out.println("0.0000 == " + ct.champagneTower(1, 1, 1));
        System.out.println("0.5000 == " + ct.champagneTower(2, 1, 1));
        System.out.println("1.0000 == " + ct.champagneTower(100000009, 33, 17));
        System.out.println("1.0000 == " + ct.champagneTower(50, 6, 5));
        System.out.println("1.0000 == " + ct.champagneTower(5352433, 86, 34));
    }

    public void mostFrequentNumberFollowingKeyInAnArray() {
        MostFrequentNumberFollowingKeyInAnArray mfnfkia = new MostFrequentNumberFollowingKeyInAnArray();

        System.out.println("100 == " + mfnfkia.mostFrequent(new int[]{1,100,200,1,100}, 1));
        System.out.println("2 == " + mfnfkia.mostFrequent(new int[]{2,2,2,2,3}, 2));
    }

    public void sortTheJumbledNumbers() {
        SortTheJumbledNumbers stjn = new SortTheJumbledNumbers();

        System.out.println("[338,38,991] == " + Arrays.toString(stjn.sortJumbled(new int[]{8,9,4,0,2,1,3,5,7,6}, new int[]{991,338,38})));
        System.out.println("[123,456,789] == " + Arrays.toString(stjn.sortJumbled(new int[]{0,1,2,3,4,5,6,7,8,9}, new int[]{789,456,123})));
    }

    public void allAncestorsOfANodeInADirectedAcyclicGraph() {
        AllAncestorsOfANodeInADirectedAcyclicGraph aaoaniadac = new AllAncestorsOfANodeInADirectedAcyclicGraph();

        System.out.println("[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]] == " +
            aaoaniadac.getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));

        System.out.println("[[],[0],[0,1],[0,1,2],[0,1,2,3]] == " +
            aaoaniadac.getAncestors(5, new int[][]{{0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}}));
    }

    public void deleteAndEarn() {
        DeleteAndEarn dae = new DeleteAndEarn();

        System.out.println("6 == " + dae.deleteAndEarn(new int[]{3,4,2}));
        System.out.println("9 == " + dae.deleteAndEarn(new int[]{2,2,3,3,3,4}));
        System.out.println("10689 == " + dae.deleteAndEarn(new int[]{5,2,8,4,1,8,99,100,4,1,8,4,2,8,4,7,6,3,2,5,6,3,21,6,8,
            54,3,4,2,1,4,66,22,11,33,44,44,55,66,77,78,79,80,10000}));
    }
}
