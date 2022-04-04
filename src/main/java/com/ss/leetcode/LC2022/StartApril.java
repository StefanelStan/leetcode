package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.april.CountOddNumbersInAnIntervalRange;
import com.ss.leetcode.LC2022.april.FindTriangularSumOfAnArray;
import com.ss.leetcode.LC2022.april.FindUniqueBinaryString;
import com.ss.leetcode.LC2022.april.MinimumBitFlipsToConvertNumber;
import com.ss.leetcode.LC2022.april.NextPermutation;
import com.ss.leetcode.LC2022.april.SumOfScoresOfBuiltStrings;
import com.ss.leetcode.LC2022.april.SwappingNodesInALinkedList;
import com.ss.leetcode.shared.ListNode;

import java.util.Arrays;

public class StartApril {
    public static void main(String[] args) {
        StartApril start = new StartApril();

//        start.findUniqueBinaryString();
//        start.minimumBitFlipsToConvertNumber();
//        start.findTriangularSumOfAnArray();
//        start.sumOfScoresOfBuiltStrings();
//        start.countOddNumbersInAnIntervalRange();
//        start.nextPermutation();
        start.swappingNodesInALinkedList();
    }

    public void findUniqueBinaryString() {
        FindUniqueBinaryString fubs = new FindUniqueBinaryString();

        System.out.println("00 == " + fubs.findDifferentBinaryString(new String[]{"01","10"}));
        System.out.println("11 == " + fubs.findDifferentBinaryString(new String[]{"00","01"}));
        System.out.println("000 == " + fubs.findDifferentBinaryString(new String[]{"111","011","001"}));
    }

    public void minimumBitFlipsToConvertNumber() {
        MinimumBitFlipsToConvertNumber mbftcn = new MinimumBitFlipsToConvertNumber();

        System.out.println("3 == " + mbftcn.minBitFlips(10, 7));
        System.out.println("3 == " + mbftcn.minBitFlips(3, 4));
        System.out.println("3 == " + mbftcn.minBitFlips(3, 973299123));
        System.out.println("3 == " + mbftcn.minBitFlips(542122143, 7));
    }

    public void findTriangularSumOfAnArray() {
        FindTriangularSumOfAnArray ftsoaa = new FindTriangularSumOfAnArray();

        System.out.println("8 == " + ftsoaa.triangularSum(new int[]{1,2,3,4,5}));
        System.out.println("4 == " + ftsoaa.triangularSum(new int[]{1,2,3,4,5,4,2,7,5,3,2,8,5,3,2,7,4,3,8,1,5,7,9,3,2,0,1}));
        System.out.println("5 == " + ftsoaa.triangularSum(new int[]{5}));
    }

    public void sumOfScoresOfBuiltStrings() {
        SumOfScoresOfBuiltStrings sosobs = new SumOfScoresOfBuiltStrings();

        System.out.println("9 == " + sosobs.sumScores("babab"));
        System.out.println("14 == " + sosobs.sumScores("azbazbzaz"));
        System.out.println("235 == " + sosobs.sumScores("nskmiwknpiclnptttlihicvixtqyxzdyrkulgqpfeckxssnlekuxiwvmxhyfzspt"
            + "cjdqxvuavtakihlizitoozcnnubaafdsadfrvxnadgfshkpfqpcfrtcjsydkjbaupsflzgyumyggutzjcicbqmeghncnsgjkwqwksyahx"
            + "sykyjnqvofkmpxmeaqqhtddflkwvpbpqzkxzyzkdcrctmopmiipaewlw"));
        System.out.println("18 == " + sosobs.sumScores("hhzjhhzjsoiz"));
    }

    public void countOddNumbersInAnIntervalRange() {
        CountOddNumbersInAnIntervalRange coniair = new CountOddNumbersInAnIntervalRange();

        System.out.println("3 == " + coniair.countOdds(3,7));
        System.out.println("1 == " + coniair.countOdds(8,10));
    }

    public void nextPermutation() {
        NextPermutation np = new NextPermutation();

        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{3,2,1};
        int[] arr3 = new int[]{1,5,1};
        int[] arr4 = new int[]{1,5,2,7,4,2,8,5,1,7,3,2,8,9,1,3,2,1,1,1,1};

        np.nextPermutation(arr1);
        np.nextPermutation(arr2);
        np.nextPermutation(arr3);
        np.nextPermutation(arr4);

        System.out.println("[1,3,2] == " + Arrays.toString(arr1));
        System.out.println("[1,2,3] == " + Arrays.toString(arr2));
        System.out.println("[1,1,5] == " + Arrays.toString(arr3));
        System.out.println("[1,5,2,7,4,2,8,5,1,7,3,2,8,9,2,1,1,1,1,1,3] == " + Arrays.toString(arr4));
    }

    public void swappingNodesInALinkedList() {
        SwappingNodesInALinkedList sniall = new SwappingNodesInALinkedList();

        System.out.println("[1,4,3,2,5] == " + sniall.swapNodes(ListNode.makeChain(new int[]{1,2,3,4,5}), 2).getAsList());
        System.out.println("[1,3,2,4] == " + sniall.swapNodes(ListNode.makeChain(new int[]{1,2,3,4}), 2).getAsList());
        System.out.println("[7,9,6,6,8,7,3,0,9,5] == " + sniall.swapNodes(ListNode.makeChain(new int[]{7,9,6,6,7,8,3,0,9,5}), 5).getAsList());
        System.out.println("[2,1] == " + sniall.swapNodes(ListNode.makeChain(new int[]{1,2}), 2).getAsList());
        System.out.println("[3,2,1] == " + sniall.swapNodes(ListNode.makeChain(new int[]{1,2,3}), 1).getAsList());
        System.out.println("[2,1] == " + sniall.swapNodes(ListNode.makeChain(new int[]{1,2}), 1).getAsList());
    }
}
