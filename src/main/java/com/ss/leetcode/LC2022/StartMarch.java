package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.march.AllAncestorsOfANodeInADirectedAcyclicGraph;
import com.ss.leetcode.LC2022.march.CellsInARangeOnAnExcelSheet;
import com.ss.leetcode.LC2022.march.ChampagneTower;
import com.ss.leetcode.LC2022.march.CopyListWithRandomPointer;
import com.ss.leetcode.LC2022.march.CountIntegersWithEvenDigitSum;
import com.ss.leetcode.LC2022.march.CountOperationsToObtainZero;
import com.ss.leetcode.LC2022.march.CountSpecialQuadruplets;
import com.ss.leetcode.LC2022.march.CountingWordsWithAGivenPrefix;
import com.ss.leetcode.LC2022.march.CreateBinaryTreeFromDescriptions;
import com.ss.leetcode.LC2022.march.DeleteAndEarn;
import com.ss.leetcode.LC2022.march.MinimumRemoveToMakeValidParentheses;
import com.ss.leetcode.LC2022.march.MostFrequentNumberFollowingKeyInAnArray;
import com.ss.leetcode.LC2022.march.RandomPickIndex;
import com.ss.leetcode.LC2022.march.RotateList;
import com.ss.leetcode.LC2022.march.SortTheJumbledNumbers;
import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.NodeWithRandom;
import com.ss.leetcode.shared.TreeNode;

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
//        start.deleteAndEarn();
//        start.countIntegersWithEvenDigitSum();
//        start.cellsInARangeOnAnExcelSheet();
//        start.countSpecialQuadruplets();
//        start.rotateList();
//        start.copyListWithRandomPointer();
//        start.randomPickIndex();
//        start.createBinaryTreeFromDescriptions();
        start.minimumRemoveToMakeValidParentheses();
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

        System.out.println("[[],[0,6],[],[],[2],[0,2,3,7],[],[0],[]] == " +
            aaoaniadac.getAncestors(9, new int[][]{{7,5},{2,5},{0,7},{0,1},{6,1},{2,4},{3,5}}));
    }

    public void deleteAndEarn() {
        DeleteAndEarn dae = new DeleteAndEarn();

        System.out.println("6 == " + dae.deleteAndEarn(new int[]{3,4,2}));
        System.out.println("9 == " + dae.deleteAndEarn(new int[]{2,2,3,3,3,4}));
        System.out.println("10689 == " + dae.deleteAndEarn(new int[]{5,2,8,4,1,8,99,100,4,1,8,4,2,8,4,7,6,3,2,5,6,3,21,6,8,
            54,3,4,2,1,4,66,22,11,33,44,44,55,66,77,78,79,80,10000}));
    }

    public void countIntegersWithEvenDigitSum() {
        CountIntegersWithEvenDigitSum ciweds = new CountIntegersWithEvenDigitSum();

        System.out.println("2 == " + ciweds.countEven(4));
        System.out.println("14 == " + ciweds.countEven(30));
    }

    public void cellsInARangeOnAnExcelSheet() {
        CellsInARangeOnAnExcelSheet ciaroaes = new CellsInARangeOnAnExcelSheet();

        System.out.println("[K1, K2, L1, L2] == " + ciaroaes.cellsInRange("K1:L2"));
        System.out.println("[A1, B1, C1, D1, E1, F1] == " + ciaroaes.cellsInRange("A1:F1"));
    }

    public void countSpecialQuadruplets() {
        CountSpecialQuadruplets csq = new CountSpecialQuadruplets();

        System.out.println("1 == " + csq.countQuadruplets(new int[]{1,2,3,6}));
        System.out.println("0 == " + csq.countQuadruplets(new int[]{3,3,6,4,5}));
        System.out.println("4 == " + csq.countQuadruplets(new int[]{1,1,1,3,5}));
    }

    public void rotateList() {
        RotateList rl = new RotateList();

        ListNode head1 = ListNode.makeChain(new int[]{1,2,3,4,5});
        ListNode head2 = ListNode.makeChain(new int[]{0,1,2});
        ListNode head3 = ListNode.makeChain(new int[]{1,2,3,4,5,1,2,3,4,5,7,3,2,9,7,5,2,1,0});

        System.out.println("[4,5,1,2,3] == " + rl.rotateRight(head1, 2).getAsList());
        System.out.println("[2,0,1] == " + rl.rotateRight(head2, 4).getAsList());
        System.out.println("[5,1,2,3,4,5,7,3,2,9,7,5,2,1,0,1,2,3,4] == " + rl.rotateRight(head3, 1978265119).getAsList());
    }

    public void copyListWithRandomPointer() {
        CopyListWithRandomPointer clwrp = new CopyListWithRandomPointer();

        NodeWithRandom head1 = NodeWithRandom.makeChain(new Integer[][]{{7, null},{13,0},{11,4},{10,2},{1,0}});
        NodeWithRandom head2 = NodeWithRandom.makeChain(new Integer[][]{{1,1},{2,1}});
        NodeWithRandom head3 = NodeWithRandom.makeChain(new Integer[][]{{3, null},{3,0},{3,null}});

        System.out.println("[[7,null],[13,0],[11,4],[10,2],[1,0]] == " + clwrp.copyRandomList(head1).asList());
        System.out.println("[[1,1],[2,1]] == " + clwrp.copyRandomList(head2).asList());
        System.out.println("[[3,null],[3,0],[3,null]] == " + clwrp.copyRandomList(head3).asList());
    }

    public void randomPickIndex() {
        RandomPickIndex rpi = new RandomPickIndex(new int[]{1,2,3,3,3});

        System.out.println("2||3||4 == " + rpi.pick(3));
        System.out.println("0 == " + rpi.pick(1));
        System.out.println("2||3||4 == " + rpi.pick(3));
    }

    public void createBinaryTreeFromDescriptions() {
        CreateBinaryTreeFromDescriptions cbtfd = new CreateBinaryTreeFromDescriptions();

        System.out.println("[50,2015,17,80,19] == " + TreeNode.preOrder(cbtfd.createBinaryTree(new int[][]{{20,15,1},{20,17,0},{50,20,1},
            {50,80,0},{80,19,1}})));

        System.out.println("[1,2,3,4] == " + TreeNode.preOrder(cbtfd.createBinaryTree(new int[][]{{1,2,1},{2,3,0},{3,4,1}})));
    }

    public void minimumRemoveToMakeValidParentheses() {
        MinimumRemoveToMakeValidParentheses mrtmvp = new MinimumRemoveToMakeValidParentheses();

        System.out.println("lee(t(c)o)de == " + mrtmvp.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println("l()ee(t(c)o)de == " + mrtmvp.minRemoveToMakeValid("l())ee(t(c)o)de)"));
        System.out.println("ab(c)d == " + mrtmvp.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(" == " + mrtmvp.minRemoveToMakeValid("))(("));
        System.out.println("a == " + mrtmvp.minRemoveToMakeValid("a"));
        System.out.println("a == " + mrtmvp.minRemoveToMakeValid("a("));
    }
}
