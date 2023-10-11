package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.october.AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod;
import com.ss.leetcode.LC2023.october.CountCollisionsOnARoad;
import com.ss.leetcode.LC2023.october.CountGoodNumbers;
import com.ss.leetcode.LC2023.october.MakeStringASubsequenceUsingCyclicIncrements;
import com.ss.leetcode.LC2023.october.MaxDotProductOfTwoSubsequences;
import com.ss.leetcode.LC2023.october.NumberOfFlowersInFullBloom;
import com.ss.leetcode.LC2023.october.SumOfMutatedArrayClosestToTarget;
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
        start.numberOfFlowersInFullBloom();
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

        System.out.println("[3,4] == " + Arrays.toString(mdpots.searchRange(new int[]{5,7,7,8,8,10}, 8)));
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
}
