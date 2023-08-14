package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.august.CheckIfThereIsAValidPartitionForTheArray;
import com.ss.leetcode.LC2023.august.FindTheMaximumDivisibilityScore;
import com.ss.leetcode.LC2023.august.MinimizeTheMaximumDifferenceOfPairs;
import com.ss.leetcode.LC2023.august.PlatesBetweenCandles;
import com.ss.leetcode.LC2023.august.RepeatedDNASequences;
import com.ss.leetcode.LC2023.august.WalkingRobotSimulationII;
import com.ss.leetcode.LC2023.august.WordBreak;
import java.util.Arrays;
import java.util.List;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

//        start.repeatedDNASequences();
//        start.findTheMaximumDivisibilityScore();
//        start.wordBreak();
//        start.walkingRobotSimulationII();
//        start.minimizeTheMaximumDifferenceOfPairs();
//        start.checkIfThereIsAValidPartitionForTheArray();
        start.platesBetweenCandles();
    }

    public void repeatedDNASequences() {
        RepeatedDNASequences rdnas = new RepeatedDNASequences();

        System.out.println("[AAAAACCCCC,CCCCCAAAAA] == " + rdnas.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println("[AAAAAAAAAA] == " + rdnas.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }

    public void findTheMaximumDivisibilityScore() {
        FindTheMaximumDivisibilityScore ftmds = new FindTheMaximumDivisibilityScore();

        System.out.println("3 == " + ftmds.maxDivScore(new int[]{4,7,9,3,9}, new int[]{5,2,3}));
        System.out.println("5 == " + ftmds.maxDivScore(new int[]{20,14,21,10}, new int[]{5,7,5}));
        System.out.println("10 == " + ftmds.maxDivScore(new int[]{12}, new int[]{10,16}));
        System.out.println("9 == " + ftmds.maxDivScore(new int[]{69,3,92,14,67,90,31,40,54,63,99,88,28,100,5,72,89,60,90,71}, new int[]{97,16,7,60,6,57,73,84,17,8,77,60,7,74,74,24,52,43,94,48,9,99}));
    }

    public void wordBreak() {
        WordBreak wb = new WordBreak();

        System.out.println("true == " + wb.wordBreak("leetcode", List.of("leet","code")));
        System.out.println("true == " + wb.wordBreak("applepenapple", List.of("apple","pen")));
        System.out.println("false == " + wb.wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
    }

    public void walkingRobotSimulationII() {
        WalkingRobotSimulationII wrsii = new WalkingRobotSimulationII(6,3);
        wrsii.step(2);
        wrsii.step(2);
        System.out.println("[4,0] == " + Arrays.toString(wrsii.getPos()));
        System.out.println("East == " + wrsii.getDir());
        wrsii.step(1);
        wrsii.step(4);
        System.out.println("[1,2] == " + Arrays.toString(wrsii.getPos()));
        System.out.println("West == " + wrsii.getDir());

        wrsii = new WalkingRobotSimulationII(6,3);
        wrsii.step(14);
        System.out.println("South == " + wrsii.getDir());
        wrsii.step(5);
        System.out.println("East == " + wrsii.getDir());
        wrsii.step(1);
        System.out.println("North == " + wrsii.getDir());
        wrsii.step(15);
        System.out.println("North == " + wrsii.getDir());
        wrsii.step(33);
        System.out.println("West == " + wrsii.getDir());
        System.out.println("[0,2] == " + Arrays.toString(wrsii.getPos()));

        wrsii = new WalkingRobotSimulationII(2,2);
        wrsii.step(14);
        System.out.println("North == " + wrsii.getDir());
        wrsii.step(5);
        System.out.println("West == " + wrsii.getDir());
        wrsii.step(1);
        System.out.println("South == " + wrsii.getDir());
        wrsii.step(17);
        System.out.println("East == " + wrsii.getDir());
        wrsii.step(2);
        System.out.println("West == " + wrsii.getDir());
        wrsii.step(12);
        System.out.println("West == " + wrsii.getDir());
        System.out.println("[0,1] == " + Arrays.toString(wrsii.getPos()));

    }

    public void minimizeTheMaximumDifferenceOfPairs() {
        MinimizeTheMaximumDifferenceOfPairs mtmdop = new MinimizeTheMaximumDifferenceOfPairs();

        System.out.println("1 == " + mtmdop.minimizeMax(new int[]{10,1,2,7,1,3}, 2));
        System.out.println("0 == " + mtmdop.minimizeMax(new int[]{4,2,1,2}, 1));
    }

    public void checkIfThereIsAValidPartitionForTheArray() {
        CheckIfThereIsAValidPartitionForTheArray citiavpfta = new CheckIfThereIsAValidPartitionForTheArray();

        System.out.println("true == " + citiavpfta.validPartition(new int[]{4,4,4,5,6}));
        System.out.println("false == " + citiavpfta.validPartition(new int[]{1,1,1,2}));
    }

    public void platesBetweenCandles() {
        PlatesBetweenCandles pbc = new PlatesBetweenCandles();

        System.out.println("[2,3] == " + Arrays.toString(pbc.platesBetweenCandles("**|**|***|", new int[][]{{2,5},{5,9}})));
        System.out.println("9,0,0,0,0] == " + Arrays.toString(pbc.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}})));
    }
}
