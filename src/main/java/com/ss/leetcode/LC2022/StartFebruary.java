package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2021.september.PopulatingNextRightPointers;
import com.ss.leetcode.LC2022.february.AddTwoNumbersII;
import com.ss.leetcode.LC2022.february.ArithmeticSlices;
import com.ss.leetcode.LC2022.february.CombinationSum;
import com.ss.leetcode.LC2022.february.CountElementsWithStrictlySmallerAndGreaterElements;
import com.ss.leetcode.LC2022.february.CountEqualAndDivisiblePairsInAnArray;
import com.ss.leetcode.LC2022.february.CountGoodTripletsInAnArray;
import com.ss.leetcode.LC2022.february.DesignBitset;
import com.ss.leetcode.LC2022.february.FindPivotIndex;
import com.ss.leetcode.LC2022.february.FindTheClosestPalindrome;
import com.ss.leetcode.LC2022.february.FindThreeConsecutiveIntegersThatSumToAGivenNumber;
import com.ss.leetcode.LC2022.february.FourSumII;
import com.ss.leetcode.LC2022.february.KeepMultiplyingFoundValuesByTwo;
import com.ss.leetcode.LC2022.february.MaximumSplitOfPositiveEvenIntegers;
import com.ss.leetcode.LC2022.february.MergeNodesInBetweenZeros;
import com.ss.leetcode.LC2022.february.MinimumCostToSetCookingTime;
import com.ss.leetcode.LC2022.february.MinimumSumOfFourDigitNumberAfterSplittingDigits;
import com.ss.leetcode.LC2022.february.NumberOfStudentsUnableToEatLunch;
import com.ss.leetcode.LC2022.february.PartitionArrayAccordingToGivenPivot;
import com.ss.leetcode.LC2022.february.PathCrossing;
import com.ss.leetcode.LC2022.february.PopulatingNextRightPointersInEachNodeII;
import com.ss.leetcode.LC2022.february.RemoveCoveredIntervals;
import com.ss.leetcode.LC2022.february.SmallestValueOfTheRearrangedNumber;
import com.ss.leetcode.LC2022.february.SortEvenAndOddIndicesIndependently;
import com.ss.leetcode.LC2022.february.SubarraySumEqualsK;
import com.ss.leetcode.LC2022.february.SumOfEvenNumbersAfterQueries;
import com.ss.leetcode.LC2022.february.SwapNodesInPairs;
import com.ss.leetcode.shared.ListNode;

import java.util.Arrays;
import java.util.List;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

//        start.keepMultiplyingFoundValuesByTwo();
//        start.fourSumII();
//        start.minimumSumOfFourDigitNumberAfterSplittingDigits();
//        start.partitionArrayAccordingToGivenPivot();
//        start.minimumCostToSetCookingTime();
//        start.sortEvenAndOddIndicesIndependently();
//        start.smallestValueOfTheRearrangedNumber();
//        start.designBitset();
//        start.countElementsWithStrictlySmallerAndGreaterElements();
//        start.addTwoNumbersII();
//        start.sumOfEvenNumbersAfterQueries();
//        start.pathCrossing();
//        start.subarraySumEqualsK();
//        start.populatingNextRightPointersInEachNodeII();
//        start.findTheClosestPalindrome();
//        start.findPivotIndex();
//        start.arithmeticSlices();
//        start.numberOfStudentsUnableToEatLunch();
//        start.swapNodesInPairs();
//        start.combinationSum();
//        start.countEqualAndDivisiblePairsInAnArray();
//        start.maximumSplitOfPositiveEvenIntegers();
//        start.findThreeConsecutiveIntegersThatSumToAGivenNumber();
//        start.countGoodTripletsInAnArray();
//        start.removeCoveredIntervals();
        start.mergeNodesInBetweenZeros();
    }

    public void keepMultiplyingFoundValuesByTwo() {
        KeepMultiplyingFoundValuesByTwo kmfvbt = new KeepMultiplyingFoundValuesByTwo();

        System.out.println("24 == " + kmfvbt.findFinalValue(new int[]{5,3,6,1,12}, 3));
        System.out.println("4 == " + kmfvbt.findFinalValue(new int[]{2,7,9}, 4));
    }

    public void fourSumII() {
        FourSumII fsii = new FourSumII();

        System.out.println("2 == " + fsii.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
        System.out.println("1 == " + fsii.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
        System.out.println("17 == " + fsii.fourSumCount(new int[]{0,1,-1}, new int[]{-1,1,0}, new int[]{0,0,1}, new int[]{-1,1,1}));
    }

    public void minimumSumOfFourDigitNumberAfterSplittingDigits() {
        MinimumSumOfFourDigitNumberAfterSplittingDigits msofdnafd = new MinimumSumOfFourDigitNumberAfterSplittingDigits();

        System.out.println("52 == " + msofdnafd.minimumSum(2932));
        System.out.println("13 == " + msofdnafd.minimumSum(4009));
        System.out.println("1 == " + msofdnafd.minimumSum(1000));
        System.out.println("2 == " + msofdnafd.minimumSum(1001));
    }

    public void partitionArrayAccordingToGivenPivot() {
        PartitionArrayAccordingToGivenPivot paatgp = new PartitionArrayAccordingToGivenPivot();

        System.out.println("[9,5,3,10,10,12,14] == " + Arrays.toString(paatgp.pivotArray(new int[]{9,12,5,10,14,3,10}, 10)));
        System.out.println("[-3,2,4,3] == " + Arrays.toString(paatgp.pivotArray(new int[]{-3,4,3,2}, 2)));
        System.out.println("[4,10,12] == " + Arrays.toString(paatgp.pivotArray(new int[]{12, 10, 4}, 10)));
        System.out.println("[10,12,12,12] == " + Arrays.toString(paatgp.pivotArray(new int[]{12,12,12,10}, 10)));
    }

    public void minimumCostToSetCookingTime() {
        MinimumCostToSetCookingTime mctsct = new MinimumCostToSetCookingTime();

        System.out.println("6 == " + mctsct.minCostSetTime(0, 2, 1, 600));
        System.out.println("6 == " + mctsct.minCostSetTime(0, 1, 2, 76));
    }

    public void sortEvenAndOddIndicesIndependently() {
        SortEvenAndOddIndicesIndependently seaoii = new SortEvenAndOddIndicesIndependently();

        System.out.println("[2,3,4,1] == " + Arrays.toString(seaoii.sortEvenOdd(new int[]{4,1,2,3})));
        System.out.println("[2,1] == " + Arrays.toString(seaoii.sortEvenOdd(new int[]{2,1})));
        System.out.println("[2,3,4,1,7] == " + Arrays.toString(seaoii.sortEvenOdd(new int[]{4,1,2,3,7})));
    }

    public void smallestValueOfTheRearrangedNumber() {
        SmallestValueOfTheRearrangedNumber svotrn = new SmallestValueOfTheRearrangedNumber();

        System.out.println("103 == " + svotrn.smallestNumber(310));
        System.out.println("-7650 == " + svotrn.smallestNumber(-7605));
    }

    public void designBitset() {
        DesignBitset db = new DesignBitset(5);

        db.fix(3);     // the value at idx = 3 is updated to 1, so bitset = "00010".
        db.fix(1);     // the value at idx = 1 is updated to 1, so bitset = "01010".
        db.flip();     // the value of each bit is flipped, so bitset = "10101".
        System.out.println("false == " + db.all());      // return False, as not all values of the bitset are 1.
        db.unfix(0);   // the value at idx = 0 is updated to 0, so bitset = "00101".
        db.flip();     // the value of each bit is flipped, so bitset = "11010".
        System.out.println("true == " + db.one());      // return True, as there is at least 1 index with value 1.
        db.unfix(0);   // the value at idx = 0 is updated to 0, so bitset = "01010".
        System.out.println("2 == " + db.count());    // return 2, as there are 2 bits with value 1.
        System.out.println("01010 == " + db.toString()); // return "01010", which is the composition of bitset.
    }

    public void countElementsWithStrictlySmallerAndGreaterElements() {
        CountElementsWithStrictlySmallerAndGreaterElements cewssage = new CountElementsWithStrictlySmallerAndGreaterElements();

        System.out.println("2 == " + cewssage.countElements(new int[]{11,7,2,15}));
        System.out.println("2 == " + cewssage.countElements(new int[]{-3,3,3,90}));
        System.out.println("0 == " + cewssage.countElements(new int[]{-3,3}));
        System.out.println("0 == " + cewssage.countElements(new int[]{-3,3,3}));
    }

    public void addTwoNumbersII() {
        AddTwoNumbersII atnii = new AddTwoNumbersII();

        ListNode head1 = ListNode.makeChain(new int[]{7,2,4,3});
        ListNode head2 = ListNode.makeChain(new int[]{5,6,4});
        ListNode head3 = ListNode.makeChain(new int[]{2,4,3});
        ListNode head4 = ListNode.makeChain(new int[]{5,6,4});

        System.out.println("[7,8,0,7] == " + atnii.addTwoNumbers(head1, head2).getAsList());
        System.out.println("[8,0,7] == " + atnii.addTwoNumbers(head3, head4).getAsList());
        System.out.println("[0] == " + atnii.addTwoNumbers(ListNode.makeChain(new int[]{0}), ListNode.makeChain(new int[]{0})).getAsList());
    }

    public void sumOfEvenNumbersAfterQueries() {
        SumOfEvenNumbersAfterQueries soenaq = new SumOfEvenNumbersAfterQueries();

        System.out.println("[8,6,2,4] == " + Arrays.toString(soenaq.sumEvenAfterQueries(new int[]{1,2,3,4}, new int[][]{{1,0},{-3,1},{-4,0},{2,3}})));
        System.out.println("[0] == " + Arrays.toString(soenaq.sumEvenAfterQueries(new int[]{1,}, new int[][]{{4,0}})));
    }

    public void pathCrossing() {
        PathCrossing pc = new PathCrossing();

        System.out.println("false == " + pc.isPathCrossing("NES"));
        System.out.println("true == " + pc.isPathCrossing("NESWW"));
    }

    public void subarraySumEqualsK() {
        SubarraySumEqualsK ssek = new SubarraySumEqualsK();

        System.out.println("2 == " + ssek.subarraySum(new int[]{1,1,1}, 2));
        System.out.println("2 == " + ssek.subarraySum(new int[]{1,2,3}, 3));
    }

    public void populatingNextRightPointersInEachNodeII() {
        PopulatingNextRightPointersInEachNodeII pnrpienii = new PopulatingNextRightPointersInEachNodeII();

        PopulatingNextRightPointers.Node root1 = new PopulatingNextRightPointers.Node(1,
            new PopulatingNextRightPointers.Node(2, new PopulatingNextRightPointers.Node(4), new PopulatingNextRightPointers.Node(5)),
            new PopulatingNextRightPointers.Node(3, null, new PopulatingNextRightPointers.Node(7)));

        PopulatingNextRightPointers.Node root2 = null;

        pnrpienii.connect(root1);
        pnrpienii.connect(root2);

        System.out.println("true == " + (root1.left.next == root1.right));
        System.out.println("null == " + root2);
    }

    public void findTheClosestPalindrome() {
        FindTheClosestPalindrome ftcp = new FindTheClosestPalindrome();

        System.out.println("121 == " + ftcp.nearestPalindromic("123"));
        System.out.println("0 == " + ftcp.nearestPalindromic("1"));
        System.out.println("9 == " + ftcp.nearestPalindromic("11"));
        System.out.println("11 == " + ftcp.nearestPalindromic("22"));
        System.out.println("111 == " + ftcp.nearestPalindromic("121"));
        System.out.println("101 == " + ftcp.nearestPalindromic("99"));
        System.out.println("77 == " + ftcp.nearestPalindromic("88"));
        System.out.println("9 == " + ftcp.nearestPalindromic("11"));
        System.out.println("1111 == " + ftcp.nearestPalindromic("1221"));
        System.out.println("1001 == " + ftcp.nearestPalindromic("999"));
    }

    public void findPivotIndex() {
        FindPivotIndex fpi = new FindPivotIndex();

        System.out.println("3 == " + fpi.pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println("-1 == " + fpi.pivotIndex(new int[]{1,2,3}));
        System.out.println("0 == " + fpi.pivotIndex(new int[]{2,1,-1}));
        System.out.println("4 == " + fpi.pivotIndex(new int[]{8,2,7,1,9, 10,8}));
    }

    public void arithmeticSlices() {
        ArithmeticSlices as = new ArithmeticSlices();

        System.out.println("3 == " + as.numberOfArithmeticSlices(new int[]{1,2,3,4}));
        System.out.println("0 == " + as.numberOfArithmeticSlices(new int[]{1}));
        System.out.println("36 == " + as.numberOfArithmeticSlices(new int[]{1,3,5,7,9,12,15,18,21,24,27,31,35,39,43,47,51}));
    }

    public void numberOfStudentsUnableToEatLunch() {
        NumberOfStudentsUnableToEatLunch nosutel = new NumberOfStudentsUnableToEatLunch();

        System.out.println("0 == " + nosutel.countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        System.out.println("3 == " + nosutel.countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }

    public void swapNodesInPairs() {
        SwapNodesInPairs snip = new SwapNodesInPairs();

        System.out.println("[2,1,4,3] == " + snip.swapPairs(ListNode.makeChain(new int[]{1,2,3,4})).getAsList());
        System.out.println("null == " + snip.swapPairs(null));
        System.out.println("[1] == " + snip.swapPairs(ListNode.makeChain(new int[]{1})).getAsList());
        System.out.println("[2,1,3] == " + snip.swapPairs(ListNode.makeChain(new int[]{1,2,3})).getAsList());
    }

    public void combinationSum() {
        CombinationSum cs = new CombinationSum();

        System.out.println("[[2,2,3],[7]] == " + cs.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println("[[2,2,2,2],[2,3,3],[3,5]] == " + cs.combinationSum(new int[]{2,3,5}, 8));
        System.out.println("[] == " + cs.combinationSum(new int[]{2}, 1));
    }

    public void countEqualAndDivisiblePairsInAnArray() {
        CountEqualAndDivisiblePairsInAnArray ceadpiaa = new CountEqualAndDivisiblePairsInAnArray();

        System.out.println("4 == " + ceadpiaa.countPairs(new int[]{3,1,2,2,2,1,3}, 2));
        System.out.println("0 == " + ceadpiaa.countPairs(new int[]{1,2,3,4}, 1));
        System.out.println("0 == " + ceadpiaa.countPairs(new int[]{1}, 1));
    }

    public void maximumSplitOfPositiveEvenIntegers() {
        MaximumSplitOfPositiveEvenIntegers msopei = new MaximumSplitOfPositiveEvenIntegers();

        System.out.println("[2,4,6] == " + msopei.maximumEvenSplit(12));
        System.out.println("[] == " + msopei.maximumEvenSplit(7));
        System.out.println("[2,4,6,16] == " + msopei.maximumEvenSplit(28));
        System.out.println("[2,4,6,16] == " + msopei.maximumEvenSplit(10000000000L));
        System.out.println("[2] == " + msopei.maximumEvenSplit(2));
        System.out.println("[4] == " + msopei.maximumEvenSplit(4));
        System.out.println("[2,4] == " + msopei.maximumEvenSplit(6));
        System.out.println("[2,6] == " + msopei.maximumEvenSplit(8));
    }

    public void findThreeConsecutiveIntegersThatSumToAGivenNumber() {
        FindThreeConsecutiveIntegersThatSumToAGivenNumber ftcitstagn = new FindThreeConsecutiveIntegersThatSumToAGivenNumber();

        System.out.println("[10,11,12] == " + Arrays.toString(ftcitstagn.sumOfThree(33)));
        System.out.println("[] == " + Arrays.toString(ftcitstagn.sumOfThree(4)));
        System.out.println("[] == " + Arrays.toString(ftcitstagn.sumOfThree(4)));
    }

    public void countGoodTripletsInAnArray() {
        CountGoodTripletsInAnArray cgtiaa = new CountGoodTripletsInAnArray();

        System.out.println("1 == " + cgtiaa.goodTriplets(new int[]{2,0,1,3}, new int[]{0,1,2,3}));
        System.out.println("4 == " + cgtiaa.goodTriplets(new int[]{4,0,1,3,2}, new int[]{4,1,0,2,3}));
    }

    public void removeCoveredIntervals() {
        RemoveCoveredIntervals rci = new RemoveCoveredIntervals();

        System.out.println("2 == " + rci.removeCoveredIntervals(new int[][]{{1,4},{3,6},{2,8}}));
        System.out.println("1 == " + rci.removeCoveredIntervals(new int[][]{{1,4},{2,3}}));
        System.out.println("2 == " + rci.removeCoveredIntervals(new int[][]{{1,7},{1,6},{2,3},{3,6},{4,5},{4,10}}));
        System.out.println("1 == " + rci.removeCoveredIntervals(new int[][]{{1,2},{1,4},{3,4}}));
    }

    public void mergeNodesInBetweenZeros() {
        MergeNodesInBetweenZeros mnibz = new MergeNodesInBetweenZeros();

        System.out.println("[4,1] == " + mnibz.mergeNodes(ListNode.makeChain(new int[]{0,3,1,0,4,5,2,0})).getAsList());
        System.out.println("[1,3,4] == " + mnibz.mergeNodes(ListNode.makeChain(new int[]{0,1,0,3,0,2,2,0})).getAsList());
        System.out.println("[1] == " + mnibz.mergeNodes(ListNode.makeChain(new int[]{0,1,0})).getAsList());
        System.out.println("[3,2,4] == " + mnibz.mergeNodes(ListNode.makeChain(new int[]{0,1,1,1,0,1,1,0,4,0})).getAsList());
    }
}
