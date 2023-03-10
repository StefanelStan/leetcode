package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.march.BestPokerHand;
import com.ss.leetcode.LC2023.march.CheckIfArrayIsSortedAndRotated;
import com.ss.leetcode.LC2023.march.ConstructStringWithRepeatLimit;
import com.ss.leetcode.LC2023.march.CountTotalNumberOfColoredCells;
import com.ss.leetcode.LC2023.march.CountWaysToGroupOverlappingRanges;
import com.ss.leetcode.LC2023.march.DesignCircularDeque;
import com.ss.leetcode.LC2023.march.FirstMissingPositive;
import com.ss.leetcode.LC2023.march.IncrementSubmatricesByOne;
import com.ss.leetcode.LC2023.march.IntervalsBetweenIdenticalElements;
import com.ss.leetcode.LC2023.march.KokoEatingBananas;
import com.ss.leetcode.LC2023.march.KthLargestSumInABinaryTree;
import com.ss.leetcode.LC2023.march.LengthOfTheLongestAlphabeticalContinuousSubstring;
import com.ss.leetcode.LC2023.march.MaxDifferenceYouCanGetFromChangingAnInteger;
import com.ss.leetcode.LC2023.march.MinimumAmountOfTimeToFillCups;
import com.ss.leetcode.LC2023.march.MinimumFlipsToMakeAORBEqualToC;
import com.ss.leetcode.LC2023.march.MinimumNumberOfDaysToMakeMBouquets;
import com.ss.leetcode.LC2023.march.MinimumNumberOfStepsToMakeTwoStringsAnagramII;
import com.ss.leetcode.LC2023.march.MinimumOperationsToMakeArrayEqualII;
import com.ss.leetcode.LC2023.march.MinimumTimeToCompleteTrips;
import com.ss.leetcode.LC2023.march.NumberOfTimesBinaryStringIsPrefixAligned;
import com.ss.leetcode.LC2023.march.PartitionStringIntoSubstringsWithValuesAtMostK;
import com.ss.leetcode.LC2023.march.PassThePillow;
import com.ss.leetcode.LC2023.march.PreviousPermutationWithOneSwap;
import com.ss.leetcode.LC2023.march.PrintWordsVertically;
import com.ss.leetcode.LC2023.march.RemovingMinimumNumberOfMagicBeans;
import com.ss.leetcode.LC2023.march.SmallestNumberInInfiniteSet;
import com.ss.leetcode.LC2023.march.SortAnArray;
import com.ss.leetcode.LC2023.march.SplitWithMinimumSum;
import com.ss.leetcode.LC2023.march.ThousandSeparator;
import com.ss.leetcode.shared.TreeNode;
import java.util.Arrays;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();

//        start.sortAnArray();
//        start.maxDifferenceYouCanGetFromChangingAnInteger();
//        start.minimumFlipsToMakeAORBEqualToC();
//        start.minimumNumberOfDaysToMakeMBouquets();
//        start.partitionStringIntoSubstringsWithValuesAtMostK();
//        start.minimumOperationsToMakeArrayEqualII();
//        start.minimumAmountOfTimeToFillCups();
//        start.smallestNumberInInfiniteSet();
//        start.splitWithMinimumSum();
//        start.countTotalNumberOfColoredCells();
//        start.countWaysToGroupOverlappingRanges();
//        start.incrementSubmatricesByOne();
//        start.numberOfTimesBinaryStringIsPrefixAligned();
//        start.thousandSeparator();
//        start.printWordsVertically();
//        start.passThePillow();
//        start.kthLargestSumInABinaryTree();
//        start.lengthOfTheLongestAlphabeticalContinuousSubstring();
//        start.designCircularDeque();
//        start.minimumNumberOfStepsToMakeTwoStringsAnagramII();
//        start.removingMinimumNumberOfMagicBeans();
//        start.minimumTimeToCompleteTrips();
//        start.kokoEatingBananas();
//        start.checkIfArrayIsSortedAndRotated();
//        start.intervalsBetweenIdenticalElements();
//        start.firstMissingPositive();
//        start.bestPokerHand();
//        start.previousPermutationWithOneSwap();
        start.constructStringWithRepeatLimit();
    }

    public void sortAnArray() {
        SortAnArray saa = new SortAnArray();

        System.out.println("[1,2,3,5] == " + Arrays.toString(saa.sortArray(new int[]{5,2,3,1})));
        System.out.println("[0,0,1,1,2,5] == " + Arrays.toString(saa.sortArray(new int[]{5,1,1,2,0,0})));
    }

    public void maxDifferenceYouCanGetFromChangingAnInteger() {
        MaxDifferenceYouCanGetFromChangingAnInteger mdycgfcai = new MaxDifferenceYouCanGetFromChangingAnInteger();

        System.out.println("888 == " + mdycgfcai.maxDiff(555));
        System.out.println("8 == " + mdycgfcai.maxDiff(9));
    }

    public void minimumFlipsToMakeAORBEqualToC() {
        MinimumFlipsToMakeAORBEqualToC mftmaobetc = new MinimumFlipsToMakeAORBEqualToC();

        System.out.println("3 == " + mftmaobetc.minFlips(2,6,5));
        System.out.println("1 == " + mftmaobetc.minFlips(4,2,7));
        System.out.println("0 == " + mftmaobetc.minFlips(1,2,3));
    }

    public void minimumNumberOfDaysToMakeMBouquets() {
        MinimumNumberOfDaysToMakeMBouquets mnodtmmb = new MinimumNumberOfDaysToMakeMBouquets();

        System.out.println("3 == " + mnodtmmb.minDays(new int[]{1,10,3,10,2}, 3, 1));
        System.out.println("-1 == " + mnodtmmb.minDays(new int[]{1,10,3,10,2}, 3, 2));
        System.out.println("12 == " + mnodtmmb.minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));
    }

    public void partitionStringIntoSubstringsWithValuesAtMostK() {
        PartitionStringIntoSubstringsWithValuesAtMostK psiswvamk = new PartitionStringIntoSubstringsWithValuesAtMostK();
        System.out.println("4 == " + psiswvamk.minimumPartition("165462", 60));
        System.out.println("-1 == " + psiswvamk.minimumPartition("238182", 5));
        System.out.println("9 == " + psiswvamk.minimumPartition("26157345257163988868117846274721761212579599849281498323426933956822333959", 784955370));
    }

    public void minimumOperationsToMakeArrayEqualII() {
        MinimumOperationsToMakeArrayEqualII motmaeii = new MinimumOperationsToMakeArrayEqualII();

        System.out.println("2 == " + motmaeii.minOperations(new int[]{4,3,1,4}, new int[]{1,3,7,1}, 3));
        System.out.println("2 == " + motmaeii.minOperations(new int[]{3,8,5,2}, new int[]{2,4,1,6}, 1));
        System.out.println("-1 == " + motmaeii.minOperations(new int[]{4,3,1,4}, new int[]{1,3,7,1}, 0));
        System.out.println("0 == " + motmaeii.minOperations(new int[]{1,3,7,1}, new int[]{1,3,7,1}, 0));
        System.out.println("-1 == " + motmaeii.minOperations(new int[]{5,2,11,4,9}, new int[]{1,2,3,4,5}, 4));
        System.out.println("2 == " + motmaeii.minOperations(new int[]{5,2,5,4,9}, new int[]{1,2,13,4,5}, 4));
    }

    public void minimumAmountOfTimeToFillCups() {
        MinimumAmountOfTimeToFillCups maoftfc = new MinimumAmountOfTimeToFillCups();

        System.out.println("4 == " + maoftfc.fillCups(new int[]{1,4,2}));
        System.out.println("7 == " + maoftfc.fillCups(new int[]{5,4,4}));
        System.out.println("5 == " + maoftfc.fillCups(new int[]{5,0,0}));
    }

    public void smallestNumberInInfiniteSet() {
        SmallestNumberInInfiniteSet sniis = new SmallestNumberInInfiniteSet();

        sniis.addBack(2);
        System.out.println("1 == " + sniis.popSmallest());
        System.out.println("2 == " + sniis.popSmallest());
        System.out.println("3 == " + sniis.popSmallest());
        sniis.addBack(1);
        System.out.println("1 == " + sniis.popSmallest());
        System.out.println("4 == " + sniis.popSmallest());
        System.out.println("5 == " + sniis.popSmallest());
    }

    public void splitWithMinimumSum() {
        SplitWithMinimumSum swms = new SplitWithMinimumSum();

        System.out.println("59 == " + swms.splitNum(4325));
        System.out.println("75 == " + swms.splitNum(687));
    }

    public void countTotalNumberOfColoredCells() {
        CountTotalNumberOfColoredCells ctnocc = new CountTotalNumberOfColoredCells();

        System.out.println("1 == " + ctnocc.coloredCells(1));
        System.out.println("5 == " + ctnocc.coloredCells(2));
        System.out.println("13 == " + ctnocc.coloredCells(3));
        System.out.println("25 == " + ctnocc.coloredCells(4));
    }

    public void countWaysToGroupOverlappingRanges() {
        CountWaysToGroupOverlappingRanges cttgor = new CountWaysToGroupOverlappingRanges();

        System.out.println("2 == " + cttgor.countWays(new int[][]{{6,10},{5,15}}));
        System.out.println("4 == " + cttgor.countWays(new int[][]{{1,3},{10,20},{2,5},{4,8}}));
        System.out.println("16 == " + cttgor.countWays(new int[][]{{0,0},{8,9},{12,13},{1,3}}));
        System.out.println("8 == " + cttgor.countWays(new int[][]{{5,11},{20,22},{1,3},{21,22}, {11,11}}));
        System.out.println("2 == " + cttgor.countWays(new int[][]{{34,56},{28,29},{12,16},{11,48},{24,54},{22,55},{28,41},{41,44}}));
    }

    public void incrementSubmatricesByOne() {
        IncrementSubmatricesByOne isbo = new IncrementSubmatricesByOne();

        System.out.println("[[1,1,0],[1,2,1],[0,1,1]] == " + Arrays.deepToString(isbo.rangeAddQueries(3, new int[][]{{1,1,2,2},{0,0,1,1}})));
        System.out.println("[[1,1],[1,1]] == " + Arrays.deepToString(isbo.rangeAddQueries(2, new int[][]{{0,0,1,1}})));
        System.out.println("[[1,1,0,0],[1,2,2,0],[0,1,2,0],[0,0,1,0]] == " + Arrays.deepToString(isbo.rangeAddQueries(3, new int[][]{{1,1,2,2},{0,0,1,1},{1,2,3,2}})));
    }

    public void numberOfTimesBinaryStringIsPrefixAligned() {
        NumberOfTimesBinaryStringIsPrefixAligned notbsipa = new NumberOfTimesBinaryStringIsPrefixAligned();

        System.out.println("2 == " + notbsipa.numTimesAllBlue(new int[]{3,2,4,1,5}));
        System.out.println("1 == " + notbsipa.numTimesAllBlue(new int[]{4,1,2,3}));
        System.out.println("1 == " + notbsipa.numTimesAllBlue(new int[]{8,7,6,5,1,2,3,4}));
        System.out.println("9 == " + notbsipa.numTimesAllBlue(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println("1 == " + notbsipa.numTimesAllBlue(new int[]{1}));
    }

    public void thousandSeparator() {
        ThousandSeparator ts = new ThousandSeparator();

        System.out.println("987 == " + ts.thousandSeparator(987));
        System.out.println("1.234 == " + ts.thousandSeparator(1234));
        System.out.println("1.312.312.312 == " + ts.thousandSeparator(1312312312));
        System.out.println("123.132.131 == " + ts.thousandSeparator(123132131));
        System.out.println("0 == " + ts.thousandSeparator(0));
        System.out.println("1.000 == " + ts.thousandSeparator(1000));
    }

    public void printWordsVertically() {
        PrintWordsVertically pwv = new PrintWordsVertically();

        System.out.println("[HAY,ORO,WEU] == " + pwv.printVertically("HOW ARE YOU"));
        System.out.println("[TBONTB,OEROOE,   T] == " + pwv.printVertically("TO BE OR NOT TO BE"));
        System.out.println("[AAAAAAA, BBBBDD,  CCDFF,   DERE,   ERER,      G,      A] == " + pwv.printVertically("A AB ABC ABCDE ABDER ADFRE ADFERGA"));
    }

    public void passThePillow() {
        PassThePillow ptp = new PassThePillow();

        System.out.println("2 == " + ptp.passThePillow(4,5));
        System.out.println("3 == " + ptp.passThePillow(3,2));
    }

    public void kthLargestSumInABinaryTree() {
        KthLargestSumInABinaryTree klsiabt = new KthLargestSumInABinaryTree();

        TreeNode root1 = new TreeNode(5,
            new TreeNode(8, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(1)),
            new TreeNode(9, new TreeNode(3), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);

        System.out.println("13 == " + klsiabt.kthLargestLevelSum(root1, 2));
        System.out.println("3 == " + klsiabt.kthLargestLevelSum(root2, 1));
    }

    public void lengthOfTheLongestAlphabeticalContinuousSubstring() {
        LengthOfTheLongestAlphabeticalContinuousSubstring lotlacs = new LengthOfTheLongestAlphabeticalContinuousSubstring();

        System.out.println("2 == " + lotlacs.longestContinuousSubstring("abacaba"));
        System.out.println("5 == " + lotlacs.longestContinuousSubstring("abcde"));
    }

    public void designCircularDeque() {
        DesignCircularDeque dcd = new DesignCircularDeque(3);

        System.out.println("true == " + dcd.insertLast(1));
        System.out.println("true == " + dcd.insertLast(2));
        System.out.println("true == " + dcd.insertFront(3));
        System.out.println("false == " + dcd.insertFront(4));
        System.out.println("2 == " + dcd.getRear());
        System.out.println("true == " + dcd.isFull());
        System.out.println("true == " + dcd.deleteLast());
        System.out.println("true == " + dcd.insertFront(4));
        System.out.println("4 == " + dcd.getFront());


        dcd = new DesignCircularDeque(3);

        System.out.println("true == " + dcd.insertLast(1));
        System.out.println("true == " + dcd.insertFront(3));
        System.out.println("true == " + dcd.insertFront(4));
        System.out.println("1 == " + dcd.getRear());
        System.out.println("4 == " + dcd.getFront());
        System.out.println("true == " + dcd.isFull());
        System.out.println("true == " + dcd.deleteFront());
        System.out.println("true == " + dcd.insertLast(5));
        System.out.println("5 == " + dcd.getRear());
        System.out.println("3 == " + dcd.getFront());

         dcd = new DesignCircularDeque(8);

        System.out.println("true == " + dcd.insertFront(5));
        System.out.println("5 == " + dcd.getFront());
        System.out.println("false == " + dcd.isEmpty());
        System.out.println("true == " + dcd.deleteFront());
        System.out.println("true == " + dcd.insertLast(3));
        System.out.println("3 == " + dcd.getRear());
        System.out.println("true == " + dcd.insertLast(7));
        System.out.println("true == " + dcd.insertFront(7));
        System.out.println("true == " + dcd.deleteLast());
        System.out.println("true == " + dcd.insertLast(4));
        System.out.println("false == " + dcd.isEmpty());


    }

    public void minimumNumberOfStepsToMakeTwoStringsAnagramII() {
        MinimumNumberOfStepsToMakeTwoStringsAnagramII mnostmtsaii = new MinimumNumberOfStepsToMakeTwoStringsAnagramII();

        System.out.println("7 == " + mnostmtsaii.minSteps("leetcode", "coats"));
        System.out.println("0 == " + mnostmtsaii.minSteps("night", "thing"));
    }

    public void removingMinimumNumberOfMagicBeans() {
        RemovingMinimumNumberOfMagicBeans rmnomb = new RemovingMinimumNumberOfMagicBeans();

        System.out.println("4 == " + rmnomb.minimumRemoval(new int[]{4,1,6,5}));
        System.out.println("7 == " + rmnomb.minimumRemoval(new int[]{2,10,3,2}));
    }

    public void minimumTimeToCompleteTrips() {

        MinimumTimeToCompleteTrips mttct = new MinimumTimeToCompleteTrips();

        System.out.println("3 == " + mttct.minimumTime(new int[]{1,2,3}, 5));
        System.out.println("2 == " + mttct.minimumTime(new int[]{2}, 1));
        System.out.println("48 == " + mttct.minimumTime(new int[]{1,2,3,4,5,6,7,8,7,6,5,4,34,5,6,5,4,5,6,8,9,7,6,4,3,54,56,7,5,4,3,45,65,76,5,34,3}, 327));
        System.out.println("25 == " + mttct.minimumTime(new int[]{5,10,10}, 9));
        System.out.println("9 == " + mttct.minimumTime(new int[]{3,3,8}, 6));
        System.out.println("9 == " + mttct.minimumTime(new int[]{3,3,8}, 7));
    }

    public void kokoEatingBananas() {
        KokoEatingBananas keb = new KokoEatingBananas();

        System.out.println("4 == " + keb.minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println("30 == " + keb.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println("23 == " + keb.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }

    public void checkIfArrayIsSortedAndRotated() {
        CheckIfArrayIsSortedAndRotated ciaisar = new CheckIfArrayIsSortedAndRotated();

        System.out.println("true == " + ciaisar.check(new int[]{3,4,5,1,2}));
        System.out.println("false == " + ciaisar.check(new int[]{2,1,3,4}));
        System.out.println("true == " + ciaisar.check(new int[]{1,2,3}));
        System.out.println("false == " + ciaisar.check(new int[]{1,3,2}));
    }

    public void intervalsBetweenIdenticalElements() {
        IntervalsBetweenIdenticalElements ibie = new IntervalsBetweenIdenticalElements();

        System.out.println("[4,2,7,2,4,4,5] == " + Arrays.toString(ibie.getDistances(new int[]{2,1,3,1,2,3,3})));
        System.out.println("[5,0,3,4] == " + Arrays.toString(ibie.getDistances(new int[]{10,5,10,10})));
        System.out.println("[0] == " + Arrays.toString(ibie.getDistances(new int[]{10})));
    }

    public void firstMissingPositive() {
        FirstMissingPositive fmp = new FirstMissingPositive();

        System.out.println("3 == " + fmp.firstMissingPositive(new int[]{1,2,0}));
        System.out.println("2 == " + fmp.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println("1 == " + fmp.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println("4 == " + fmp.firstMissingPositive(new int[]{7,8,9,11,120,0,1,2,3,5,6,7}));
    }

    public void bestPokerHand() {
        BestPokerHand bph = new BestPokerHand();

        System.out.println("Flush == " + bph.bestHand(new int[]{13,2,3,1,9}, new char[]{'a','a','a','a','a'}));
        System.out.println("Three of a Kind == " + bph.bestHand(new int[]{4,4,2,4,4}, new char[]{'d','a','a','b','c'}));
        System.out.println("Pair == " + bph.bestHand(new int[]{10,10,2,12,9}, new char[]{'a','b','c','a','d'}));
    }

    public void previousPermutationWithOneSwap() {
        PreviousPermutationWithOneSwap ppwos = new PreviousPermutationWithOneSwap();

        System.out.println("[3,1,2] == " + Arrays.toString(ppwos.prevPermOpt1(new int[]{3,2,1})));
        System.out.println("[1,1,5] == " + Arrays.toString(ppwos.prevPermOpt1(new int[]{1,1,5})));
        System.out.println("[1,7,4,6,9] == " + Arrays.toString(ppwos.prevPermOpt1(new int[]{1,9,4,6,7})));
        System.out.println("[1,3,1,3] == " + Arrays.toString(ppwos.prevPermOpt1(new int[]{3,1,1,3})));
    }

    public void constructStringWithRepeatLimit() {
        ConstructStringWithRepeatLimit cswrl = new ConstructStringWithRepeatLimit();

        System.out.println("zzcccac == " + cswrl.repeatLimitedString("cczazcc", 3));
        System.out.println("bbabaa == " + cswrl.repeatLimitedString("aababab", 2));
        System.out.println("bbabaa == " + cswrl.repeatLimitedString("aabasdfhsdyifsdjfhsdguyfgsdyufgydhfgdhfdhgfgdhfgfhfhgdhgdghdghdfdfdfdfghdfhghghgdfhdfhgdfghdfuhdfuydfuydfuydfuyhdfuuhuhdfsjksdfjkdsfkldsfkldfsklkjkgjkljohkjgjhdbab", 3));
    }
}