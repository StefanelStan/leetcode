package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.july.BuildAMatrixWithConditions;
import com.ss.leetcode.LC2024.july.CrawlerLogFolder;
import com.ss.leetcode.LC2024.july.FindOccurrencesOfAnElementInAnArray;
import com.ss.leetcode.LC2024.july.FindTheWinnerOfTheCircularGame;
import com.ss.leetcode.LC2024.july.FindValidMatrixGivenRowAndColumnSums;
import com.ss.leetcode.LC2024.july.MinimumCostToConvertStringI;
import com.ss.leetcode.LC2024.july.MinimumNumberOfIncrementsOnSubarraysToFormATargetArray;
import com.ss.leetcode.LC2024.july.PartitionArraySuchThatMaximumDifferenceIsK;
import com.ss.leetcode.LC2024.july.RobotCollisions;
import java.util.Arrays;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

//        start.findTheWinnerOfTheCircularGame();
//        start.crawlerLogFolder();
//        start.robotCollisions();
//        start.findValidMatrixGivenRowAndColumnSums();
//        start.buildAMatrixWithConditions();
//        start.findOccurrencesOfAnElementInAnArray();
//        start.partitionArraySuchThatMaximumDifferenceIsK();
//        start.minimumNumberOfIncrementsOnSubarraysToFormATargetArray();
        start.minimumCostToConvertStringI();
    }

    public void findTheWinnerOfTheCircularGame() {
        FindTheWinnerOfTheCircularGame ftwotcg = new FindTheWinnerOfTheCircularGame();

        System.out.println("3 == " + ftwotcg.findTheWinner(5, 2));
        System.out.println("1 == " + ftwotcg.findTheWinner(6, 5));
        System.out.println("1 == " + ftwotcg.findTheWinner(1, 1));
    }

    public void crawlerLogFolder() {
        CrawlerLogFolder clf = new CrawlerLogFolder();

        System.out.println("2 == " + clf.minOperations(new String[]{"d1/","d2/","../","d21/","./"}));
        System.out.println("3 == " + clf.minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
        System.out.println("0 == " + clf.minOperations(new String[]{"d1/","../","../","../"}));
    }

    public void robotCollisions() {
        RobotCollisions rc = new RobotCollisions();

        System.out.println("[2,17,9,15,10] == " + rc.survivedRobotsHealths(new int[]{5,4,3,2,1}, new int[]{2,17,9,15,10}, "RRRRR"));
        System.out.println("[14] == " + rc.survivedRobotsHealths(new int[]{3,5,2,6}, new int[]{10,10,15,12}, "RLRL"));
        System.out.println("[] == " + rc.survivedRobotsHealths(new int[]{1,2,5,6}, new int[]{10,10,11,11}, "RLRL"));
    }

    public void findValidMatrixGivenRowAndColumnSums() {
        FindValidMatrixGivenRowAndColumnSums fvmgracs = new FindValidMatrixGivenRowAndColumnSums();

        System.out.println("[[3,0],[1,7]] == " + Arrays.deepToString(fvmgracs.restoreMatrix(new int[]{3,8}, new int[]{4,7})));
        System.out.println("[[0,5,0],[6,1,0],[2,0,8]] == " + Arrays.deepToString(fvmgracs.restoreMatrix(new int[]{5,7,0}, new int[]{8,6,8})));

    }

    public void buildAMatrixWithConditions() {
        BuildAMatrixWithConditions bamwc = new BuildAMatrixWithConditions();

        System.out.println("[[3,0,0],[0,0,1],[0,2,0]] == " + Arrays.deepToString(bamwc.buildMatrix(3, new int[][]{{1,2},{3,2}},new int[][]{{2,1},{3,2}})));
        System.out.println("[[]] == " + Arrays.deepToString(bamwc.buildMatrix(3, new int[][]{{1,2},{2,3},{3,1},{3,2}},new int[][]{{2,1}})));
        System.out.println("[[]] == " + Arrays.deepToString(bamwc.buildMatrix(9, new int[][]{{1,2}},new int[][]{{8,9}})));
        System.out.println("[[8,0,0,0,0,0,0,0],[0,0,0,0,0,0,7,0],[0,6,0,0,0,0,0,0],[0,0,5,0,0,0,0,0],[0,0,0,4,0,0,0,0],[0,0,0,0,0,3,0,0],[0,0,0,0,0,0,0,1],[0,0,0,0,2,0,0,0]] == " + Arrays.deepToString(bamwc.buildMatrix(8, new int[][]{{1,2}},new int[][]{{5,7},{2,7},{4,3},{6,7},{4,3},{2,3},{6,2}})));
    }

    public void findOccurrencesOfAnElementInAnArray() {
        FindOccurrencesOfAnElementInAnArray fooaeiaa = new FindOccurrencesOfAnElementInAnArray();

        System.out.println("[0,-1,2,-1] == " + Arrays.toString(fooaeiaa.occurrencesOfElement(new int[]{1,3,1,7}, new int[]{1,3,2,4}, 1)));
        System.out.println("[-1] == " + Arrays.toString(fooaeiaa.occurrencesOfElement(new int[]{1,2,3}, new int[]{10}, 5)));
    }

    public void partitionArraySuchThatMaximumDifferenceIsK() {
        PartitionArraySuchThatMaximumDifferenceIsK pastmdik = new PartitionArraySuchThatMaximumDifferenceIsK();

        System.out.println("2 == " + pastmdik.partitionArray(new int[]{3,6,1,2,5}, 2));
        System.out.println("2 == " + pastmdik.partitionArray(new int[]{1,2,3}, 1));
    }

    public void minimumNumberOfIncrementsOnSubarraysToFormATargetArray() {
        MinimumNumberOfIncrementsOnSubarraysToFormATargetArray mnoiostfata = new MinimumNumberOfIncrementsOnSubarraysToFormATargetArray();

        System.out.println("3 == " + mnoiostfata.minNumberOperations(new int[]{1,2,3,2,1}));
        System.out.println("4 == " + mnoiostfata.minNumberOperations(new int[]{3,1,1,2}));
        System.out.println("7 == " + mnoiostfata.minNumberOperations(new int[]{3,1,5,4,2}));
        System.out.println("5 == " + mnoiostfata.minNumberOperations(new int[]{5,4,3,2,1}));
        System.out.println("145 == " + mnoiostfata.minNumberOperations(new int[]{2,3,1,2,3,4,5,6,7,8,7,6,5,6,7,8,7,6,5,4,3,23,1,1,2,3,4,5,6,7,7,7,5,4,3,32,2,1,2,3,3,5,6,7,78}));
    }

    public void minimumCostToConvertStringI() {
        MinimumCostToConvertStringI mctcsi = new MinimumCostToConvertStringI();

        System.out.println("28 == " + mctcsi.minimumCost("abcd", "acbe", new char[]{'a','b','c','c','e','d'}, new char[]{'b','c','b','e','b','e'}, new int[]{2,5,5,1,2,20}));
        System.out.println("12 == " + mctcsi.minimumCost("aaaa", "bbbb", new char[]{'a','c'}, new char[]{'c','b'}, new int[]{1,2}));
        System.out.println("-1 == " + mctcsi.minimumCost("abcd", "abce", new char[]{'a'}, new char[]{'e'}, new int[]{10000}));
        System.out.println("39 == " + mctcsi.minimumCost("aaadbdcdac", "cdbabaddba", new char[]{'a','c','b','d','b','a','c'}, new char[]{'c','a','d','b','c','b','d'}, new int[]{7,2,1,3,6,1,7}));
        System.out.println("-1 == " + mctcsi.minimumCost("aabbddccbc", "abbbaabaca", new char[]{'a','b','c','b','a','d'}, new char[]{'d','c','b','d','b','b'}, new int[]{3,8,7,6,7,10}));
    }
}
