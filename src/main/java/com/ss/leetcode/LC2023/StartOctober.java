package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.october.AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod;
import com.ss.leetcode.LC2023.october.BinaryStringWithSubstringsRepresenting1ToN;
import com.ss.leetcode.LC2023.october.CheckIfMoveIsLegal;
import com.ss.leetcode.LC2023.october.CheckIfStringsCanBeMadeEqualWithOperationsII;
import com.ss.leetcode.LC2023.october.CountCollisionsOnARoad;
import com.ss.leetcode.LC2023.october.CountGoodNumbers;
import com.ss.leetcode.LC2023.october.DistantBarcodes;
import com.ss.leetcode.LC2023.october.DoubleANumberRepresentedAsALinkedList;
import com.ss.leetcode.LC2023.october.FindTheMostCompetitiveSubsequence;
import com.ss.leetcode.LC2023.october.FindTheOriginalArrayOfPrefixXor;
import com.ss.leetcode.LC2023.october.FindingPairsWithACertainSum;
import com.ss.leetcode.LC2023.october.GrumpyBookstoreOwner;
import com.ss.leetcode.LC2023.october.MakeStringASubsequenceUsingCyclicIncrements;
import com.ss.leetcode.LC2023.october.MaxDotProductOfTwoSubsequences;
import com.ss.leetcode.LC2023.october.MaximumScoreOfAGoodSubarray;
import com.ss.leetcode.LC2023.october.MinimumSwapsToGroupAll1sTogetherII;
import com.ss.leetcode.LC2023.october.NumberOfFlowersInFullBloom;
import com.ss.leetcode.LC2023.october.NumberOfWaysToStayInTheSamePlaceAfterSomeSteps;
import com.ss.leetcode.LC2023.october.ParallelCoursesIII;
import com.ss.leetcode.LC2023.october.SumOfMutatedArrayClosestToTarget;
import com.ss.leetcode.shared.ListNode;
import java.util.Arrays;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start = new StartOctober();

//        start.alertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod();
//        start.countGoodNumbers();
//        start.countCollisionsOnARoad();
//        start.sumOfMutatedArrayClosestToTarget();
//        start.makeStringASubsequenceUsingCyclicIncrements();
//        start.maxDotProductOfTwoSubsequences();
//        start.numberOfFlowersInFullBloom();
//        start.findTheMostCompetitiveSubsequence();
//        start.numberOfWaysToStayInTheSamePlaceAfterSomeSteps();
//        start.doubleANumberRepresentedAsALinkedList();
//        start.parallelCoursesIII();
//        start.minimumSwapsToGroupAll1sTogetherII();
//        start.findingPairsWithACertainSum();
//        start.maximumScoreOfAGoodSubarray();
//        start.grumpyBookstoreOwner();
//        start.checkIfStringsCanBeMadeEqualWithOperationsII();
//        start.binaryStringWithSubstringsRepresenting1ToN();
//        start.distantBarcodes();
//        start.checkIfMoveIsLegal();
        start.findTheOriginalArrayOfPrefixXor();
    }

    public void alertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod() {
        AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod auskctomtiaohp = new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod();

        System.out.println("[daniel] == " + auskctomtiaohp.alertNames(new String[]{"daniel","daniel","daniel","luis","luis","luis","luis"}, new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"}));
        System.out.println("[bob] == " + auskctomtiaohp.alertNames(new String[]{"alice","alice","alice","bob","bob","bob","bob"}, new String[]{"12:01","12:00","18:00","21:00","21:20","21:30","23:00"}));
    }

    public void countGoodNumbers() {
        CountGoodNumbers cgn = new CountGoodNumbers();

        System.out.println("5 == " + cgn.countGoodNumbers(1));
        System.out.println("400 == " + cgn.countGoodNumbers(4));
        System.out.println("8000 == " + cgn.countGoodNumbers(6));
        System.out.println("564908303 == " + cgn.countGoodNumbers(50));
    }

    public void countCollisionsOnARoad() {
        CountCollisionsOnARoad ccoar = new CountCollisionsOnARoad();

        System.out.println("5 == " + ccoar.countCollisions("RLRSLL"));
        System.out.println("0 == " + ccoar.countCollisions("LLRR"));
        System.out.println("63 == " + ccoar.countCollisions("RLRLRLLRRLLRRLLRLRLRLLLSLSLLRLRLRSSSLSLSLSLLRLRLRLSLSLSLRRRRRLRLLLRLRLRLRL"));
        System.out.println("12 == " + ccoar.countCollisions("RRRRRSLLLLLLL"));
        System.out.println("11 == " + ccoar.countCollisions("LLLLLLLLLLLRRRRRLLLLLLS"));
        System.out.println("26 == " + ccoar.countCollisions("SLLLLLLLLRRRRRRRLLLLLLLSSSSSSLLLL"));
        System.out.println("0 == " + ccoar.countCollisions("S"));
        System.out.println("0 == " + ccoar.countCollisions("R"));
        System.out.println("0 == " + ccoar.countCollisions("L"));
        System.out.println("0 == " + ccoar.countCollisions("LLLLSSSSS"));
    }

    public void sumOfMutatedArrayClosestToTarget() {
        SumOfMutatedArrayClosestToTarget somactt = new SumOfMutatedArrayClosestToTarget();

        System.out.println("3 == " + somactt.findBestValue(new int[]{4,9,3}, 10));
        System.out.println("5 == " + somactt.findBestValue(new int[]{2,3,5}, 10));
        System.out.println("11361 == " + somactt.findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803));
        System.out.println("1 == " + somactt.findBestValue(new int[]{1,1}, 100000));
    }

    public void makeStringASubsequenceUsingCyclicIncrements() {
        MakeStringASubsequenceUsingCyclicIncrements msasuci = new MakeStringASubsequenceUsingCyclicIncrements();

        System.out.println("true == " + msasuci.canMakeSubsequence("abc", "ad"));
        System.out.println("true == " + msasuci.canMakeSubsequence("zc", "ad"));
        System.out.println("false == " + msasuci.canMakeSubsequence("ab", "d"));
    }

    public void maxDotProductOfTwoSubsequences() {
        MaxDotProductOfTwoSubsequences mdpots = new MaxDotProductOfTwoSubsequences();

        System.out.println("18 == " + mdpots.maxDotProduct(new int[]{2,1,-2,5}, new int[]{3,0,-6}));
        System.out.println("21 == " + mdpots.maxDotProduct(new int[]{3, -2}, new int[]{2,-6,7}));
        System.out.println("-1 == " + mdpots.maxDotProduct(new int[]{-1,-1}, new int[]{1,1}));
        System.out.println("14 == " + mdpots.maxDotProduct(new int[]{1,2,3}, new int[]{1,2,3}));
    }

    public void numberOfFlowersInFullBloom() {
        NumberOfFlowersInFullBloom nofifb = new NumberOfFlowersInFullBloom();

        System.out.println("[1,2,2,2] == " + Arrays.toString(nofifb.fullBloomFlowers(new int[][]{{1,6},{3,7},{9,12},{4,13}}, new int[]{2,3,7,11})));
        System.out.println("[2,2,1] == " + Arrays.toString(nofifb.fullBloomFlowers(new int[][]{{1,10},{3,3}}, new int[]{3,3,2})));
    }

    public void findTheMostCompetitiveSubsequence() {
        FindTheMostCompetitiveSubsequence ftmcs = new FindTheMostCompetitiveSubsequence();

        System.out.println("[2,6] == " + Arrays.toString(ftmcs.mostCompetitive(new int[]{3,5,2,6}, 2)));
        System.out.println("[2,3,3,4] == " + Arrays.toString(ftmcs.mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4)));
    }

    public void numberOfWaysToStayInTheSamePlaceAfterSomeSteps() {
        NumberOfWaysToStayInTheSamePlaceAfterSomeSteps nowtsitspass = new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps();

        System.out.println("4 == " + nowtsitspass.numWays(3, 2));
        System.out.println("2 == " + nowtsitspass.numWays(2, 4));
        System.out.println("8 == " + nowtsitspass.numWays(4, 2));
        System.out.println("374847123 == " + nowtsitspass.numWays(500, 1000000));
        System.out.println("2188 == " + nowtsitspass.numWays(10, 50));
    }

    public void doubleANumberRepresentedAsALinkedList() {
        DoubleANumberRepresentedAsALinkedList danraall = new DoubleANumberRepresentedAsALinkedList();

        ListNode head1 = ListNode.makeChain(new int[]{1,8,9});
        ListNode head2 = ListNode.makeChain(new int[]{9,9,9});

        System.out.println("[3,7,8] == " + danraall.doubleIt(head1).getAsList());
        System.out.println("[1,9,9,8] == " + danraall.doubleIt(head2).getAsList());
    }

    public void parallelCoursesIII() {
        ParallelCoursesIII pciii = new ParallelCoursesIII();

        System.out.println("8 == " + pciii.minimumTime(3, new int[][]{{1,3},{2,3}}, new int[]{3,2,5}));
        System.out.println("12 == " + pciii.minimumTime(5, new int[][]{{1,5},{2,5},{3,5},{3,4},{4,5}}, new int[]{1,2,3,4,5}));
        System.out.println("32 == " + pciii.minimumTime(9, new int[][]{{2,7},{2,6},{3,6},{4,6},{7,6},{2,1},{3,1},{4,1},{6,1},{7,1},{3,8},{5,8},{7,8},{1,9},{2,9},{6,9},{7,9}}, new int[]{9,5,9,5,8,7,7,8,4}));
    }

    public void minimumSwapsToGroupAll1sTogetherII() {
        MinimumSwapsToGroupAll1sTogetherII mstga1t = new MinimumSwapsToGroupAll1sTogetherII();

        System.out.println("1 == " + mstga1t.minSwaps(new int[]{0,1,0,1,1,0,0}));
        System.out.println("2 == " + mstga1t.minSwaps(new int[]{0,1,1,1,0,0,1,1,0}));
        System.out.println("0 == " + mstga1t.minSwaps(new int[]{1,1,0,0,1}));
        System.out.println("0 == " + mstga1t.minSwaps(new int[]{1,1,0,0,1}));
        System.out.println("2 == " + mstga1t.minSwaps(new int[]{1,1,1,0,0,0,1,1,0,0,0,0,1}));
        System.out.println("1 == " + mstga1t.minSwaps(new int[]{1,0,1,0,0,0,1,0,1}));
    }

    public void findingPairsWithACertainSum() {
        FindingPairsWithACertainSum fpwacs = new FindingPairsWithACertainSum(new int[]{1,1,2,2,2,3}, new int[]{1,4,5,2,5,4});

        System.out.println("8 == " + fpwacs.count(7));
        fpwacs.add(3,2);
        System.out.println("2 == " + fpwacs.count(8));
        System.out.println("1 == " + fpwacs.count(4));
        fpwacs.add(0,1);
        fpwacs.add(1,1);
        System.out.println("11 == " + fpwacs.count(7));
    }

    public void maximumScoreOfAGoodSubarray() {
        MaximumScoreOfAGoodSubarray mcoags = new MaximumScoreOfAGoodSubarray();

        System.out.println("15 == " + mcoags.maximumScore(new int[]{1,4,3,7,4,5}, 3));
        System.out.println("20 == " + mcoags.maximumScore(new int[]{5,5,4,5,4,1,1,1}, 0));
    }

    public void grumpyBookstoreOwner() {
        GrumpyBookstoreOwner gbo = new GrumpyBookstoreOwner();

        System.out.println("16 == " + gbo.maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
        System.out.println("1 == " + gbo.maxSatisfied(new int[]{1}, new int[]{0}, 1));
        System.out.println("29 == " + gbo.maxSatisfied(new int[]{1,2,3,2,1,2,3,4,5,6,5,4,3,1,1}, new int[]{0,1,1,0,0,1,1,1,0,1,0,0,1,1,0}, 3));
        System.out.println("25 == " + gbo.maxSatisfied(new int[]{1,2,3,2,1,2,3,4,5,6,5,4,3,1,1}, new int[]{0,1,1,0,0,1,1,1,0,1,0,0,1,1,0}, 1));
        System.out.println("34 == " + gbo.maxSatisfied(new int[]{1,2,3,2,1,2,3,4,5,6,5,4,3,1,1}, new int[]{0,1,1,0,0,1,1,1,0,1,0,0,1,1,0}, 6));
        System.out.println("32 == " + gbo.maxSatisfied(new int[]{1,2,3,2,1,2,3,4,5,6,5,4,3,1,1}, new int[]{0,1,1,0,0,1,1,1,0,1,0,0,1,1,0}, 4));
    }

    public void checkIfStringsCanBeMadeEqualWithOperationsII() {
        CheckIfStringsCanBeMadeEqualWithOperationsII ciscbmqwoii = new CheckIfStringsCanBeMadeEqualWithOperationsII();

        System.out.println("true == " + ciscbmqwoii.checkStrings("abcdba","cabdab"));
        System.out.println("false == " + ciscbmqwoii.checkStrings("abe","bea"));
    }

    public void binaryStringWithSubstringsRepresenting1ToN() {
        BinaryStringWithSubstringsRepresenting1ToN bswsr1tn = new BinaryStringWithSubstringsRepresenting1ToN();

        System.out.println("true == " + bswsr1tn.queryString("0110", 3));
        System.out.println("false == " + bswsr1tn.queryString("0110", 4));
    }

    public void distantBarcodes() {
        DistantBarcodes db = new DistantBarcodes();

        System.out.println("[2,1,2,1,2,1] == " + Arrays.toString(db.rearrangeBarcodes(new int[]{1,1,1,2,2,2})));
        System.out.println("[1,3,1,3,1,2,1,2] == " + Arrays.toString(db.rearrangeBarcodes(new int[]{1,1,1,1,2,2,3,3})));
    }

    public void checkIfMoveIsLegal() {
        CheckIfMoveIsLegal cimil = new CheckIfMoveIsLegal();

        System.out.println("true == " + cimil.checkMove(new char[][]{{'.','.','.','B','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'W','B','B','.','W','W','W','B'},{'.','.','.','B','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','W','.','.','.','.'}}, 4, 3, 'B'));
        System.out.println("false == " + cimil.checkMove(new char[][]{{'.','.','.','.','.','.','.','.'},{'.','B','.','.','W','.','.','.'},{'.','.','W','.','.','.','.','.'},{'.','.','.','W','B','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','B','W','.','.'},{'.','.','.','.','.','.','W','.'},{'.','.','.','.','.','.','.','B'}}, 4, 4, 'W'));
    }

    public void findTheOriginalArrayOfPrefixXor() {
        FindTheOriginalArrayOfPrefixXor ftoaopx = new FindTheOriginalArrayOfPrefixXor();

        System.out.println("[5,7,2,3,2] == " + Arrays.toString(ftoaopx.findArray(new int[]{5,2,0,3,1})));
        System.out.println("[13] == " + Arrays.toString(ftoaopx.findArray(new int[]{13})));
    }
}
