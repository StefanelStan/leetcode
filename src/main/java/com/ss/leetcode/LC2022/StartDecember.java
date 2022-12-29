package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.december.BinaryTreeMaximumPathSum;
import com.ss.leetcode.LC2022.december.BullsAndCows;
import com.ss.leetcode.LC2022.december.CountPairsOfSimilarStrings;
import com.ss.leetcode.LC2022.december.DeleteGreatestValueInEachRow;
import com.ss.leetcode.LC2022.december.FindIfPathExistsInGraph;
import com.ss.leetcode.LC2022.december.FindThePivotInteger;
import com.ss.leetcode.LC2022.december.MaximumBagsWithFullCapacityOfRocks;
import com.ss.leetcode.LC2022.december.MaximumEnemyFortsThatCanBeCaptured;
import com.ss.leetcode.LC2022.december.RemoveLetterToEqualizeFrequency;
import com.ss.leetcode.LC2022.december.RemoveStonesToMinimizeTheTotal;
import com.ss.leetcode.LC2022.december.ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters;
import com.ss.leetcode.LC2022.december.RewardTopKStudents;
import com.ss.leetcode.LC2022.december.ShortestDistanceToTargetStringInACircularArray;
import com.ss.leetcode.LC2022.december.SingleThreadedCPU;
import com.ss.leetcode.shared.TreeNode;
import java.util.Arrays;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

//        start.replaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters();
//        start.bullsAndCows();
//        start.binaryTreeMaximumPathSum();
//        start.findThePivotInteger();
//        start.findIfPathExistsInGraph();
//        start.deleteGreatestValueInEachRow();
//        start.removeLetterToEqualizeFrequency();
//        start.maximumEnemyFortsThatCanBeCaptured();
//        start.shortestDistanceToTargetStringInACircularArray();
//        start.maximumBagsWithFullCapacityOfRocks();
//        start.rewardTopKStudents();
//        start.removeStonesToMinimizeTheTotal();
//        start.singleThreadedCPU();
        start.countPairsOfSimilarStrings();
    }

    public void replaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters() {
        ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters raqmtacrc = new ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters();

        System.out.println("azs == " + raqmtacrc.modifyString("?zs"));
        System.out.println("ubvaw == " + raqmtacrc.modifyString("ubv?w"));
        System.out.println("ab == " + raqmtacrc.modifyString("a?"));
    }

    public void bullsAndCows() {
        BullsAndCows bac = new BullsAndCows();

        System.out.println("1A3B == " + bac.getHint("1807", "7810"));
        System.out.println("1A1B == " + bac.getHint("1123", "1123"));
        System.out.println("13A75B == " + bac.getHint("875397583249587958346276210984132798474987348906413879463875423757642483721943143473494046142094621390876234890753",
            "209347539481573120548158965274852317856384710470132742109640198609123641098246120984621904621986612461204216400124"));
    }

    public void binaryTreeMaximumPathSum() {
        BinaryTreeMaximumPathSum btmps = new BinaryTreeMaximumPathSum();

        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root2 = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println("6 == " + btmps.maxPathSum(root1));
        System.out.println("42 == " + btmps.maxPathSum(root2));
        System.out.println("-3 == " + btmps.maxPathSum(new TreeNode(-3)));
    }

    public void findThePivotInteger() {
        FindThePivotInteger ftpi = new FindThePivotInteger();

        System.out.println("6 == " + ftpi.pivotInteger(8));
        System.out.println("1 == " + ftpi.pivotInteger(1));
        System.out.println("-1 == " + ftpi.pivotInteger(4));
        System.out.println("-1 == " + ftpi.pivotInteger(896));
    }

    public void findIfPathExistsInGraph() {
        FindIfPathExistsInGraph fipeig = new FindIfPathExistsInGraph();

        System.out.println("true == " + fipeig.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
        System.out.println("false == " + fipeig.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
        System.out.println("false == " + fipeig.validPath(5, new int[][]{{0,1},{2,3},{4,1}}, 0, 2));
        System.out.println("true == " + fipeig.validPath(1, new int[][]{{}}, 0, 0));
    }

    public void deleteGreatestValueInEachRow() {
        DeleteGreatestValueInEachRow dgvier = new DeleteGreatestValueInEachRow();

        System.out.println("8 == " + dgvier.deleteGreatestValue(new int[][]{{1,2,4},{3,3,1}}));
        System.out.println("10 == " + dgvier.deleteGreatestValue(new int[][]{{10}}));
        System.out.println("53 == " + dgvier.deleteGreatestValue(new int[][]{{1,2,8,1,4,2,8,9,1,2,4},{1,8,8,5,1,7,8,9,2,1,3}}));
    }

    public void removeLetterToEqualizeFrequency() {
        RemoveLetterToEqualizeFrequency rltef = new RemoveLetterToEqualizeFrequency();

//        System.out.println("true == " + rltef.equalFrequency("abcc"));
//        System.out.println("false == " + rltef.equalFrequency("aabb"));
//        System.out.println("true == " + rltef.equalFrequency("ab"));
//        System.out.println("true == " + rltef.equalFrequency("aa"));
        System.out.println("false == " + rltef.equalFrequency("ddaccb"));
        System.out.println("true == " + rltef.equalFrequency("abcdefgg"));
    }

    public void maximumEnemyFortsThatCanBeCaptured() {
        MaximumEnemyFortsThatCanBeCaptured meftcbc = new MaximumEnemyFortsThatCanBeCaptured();

        System.out.println("4 == " + meftcbc.captureForts(new int[]{1,0,0,-1,0,0,0,0,1}));
        System.out.println("0 == " + meftcbc.captureForts(new int[]{0,0,1,-1}));
    }

    public void shortestDistanceToTargetStringInACircularArray() {
        ShortestDistanceToTargetStringInACircularArray sdttsiaca = new ShortestDistanceToTargetStringInACircularArray();

        System.out.println("1 == " + sdttsiaca.closestTarget(new String[]{"hello","i","am","leetcode","hello"}, "hello", 1));
        System.out.println("1 == " + sdttsiaca.closestTarget(new String[]{"a","b","leetcode"}, "leetcode", 0));
        System.out.println("-1 == " + sdttsiaca.closestTarget(new String[]{"i","eat","leetcode"}, "ate", 0));
        System.out.println("0 == " + sdttsiaca.closestTarget(new String[]{"hello"}, "hello", 0));
    }

    public void maximumBagsWithFullCapacityOfRocks() {
        MaximumBagsWithFullCapacityOfRocks mbwfcor = new MaximumBagsWithFullCapacityOfRocks();

        System.out.println("3 == " + mbwfcor.maximumBags(new int[]{2,3,4,5}, new int[]{1,2,4,4}, 2));
        System.out.println("3 == " + mbwfcor.maximumBags(new int[]{10,2,2}, new int[]{2,2,0}, 100));
        System.out.println("2 == " + mbwfcor.maximumBags(new int[]{10,90}, new int[]{0, 7}, 100));
        System.out.println("1 == " + mbwfcor.maximumBags(new int[]{10,100}, new int[]{0, 7}, 100));
        System.out.println("1 == " + mbwfcor.maximumBags(new int[]{10}, new int[]{9}, 1));
    }

    public void rewardTopKStudents() {
        RewardTopKStudents rtks = new RewardTopKStudents();

        System.out.println("[1,2] == " + rtks.topStudents(new String[]{"smart","brilliant","studious"}, new String[]{"not"}, new String[]{"this student is studious","the student is smart"}, new int[]{1,2}, 2));
        System.out.println("[2,1] == " + rtks.topStudents(new String[]{"smart","brilliant","studious"}, new String[]{"not"}, new String[]{"this student is not studious","the student is smart"}, new int[]{1,2}, 2));
    }

    public void removeStonesToMinimizeTheTotal() {
        RemoveStonesToMinimizeTheTotal rstmtt = new RemoveStonesToMinimizeTheTotal();

        System.out.println("12 == " + rstmtt.minStoneSum(new int[]{5,4,9}, 2));
        System.out.println("12 == " + rstmtt.minStoneSum(new int[]{4,3,6,7}, 3));
    }

    public void singleThreadedCPU() {
        SingleThreadedCPU stcpu = new SingleThreadedCPU();

        System.out.println("[0,2,3,1] == " + Arrays.toString(stcpu.getOrder(new int[][]{{1,2},{2,4},{3,2},{4,1}})));
        System.out.println("[4,3,2,0,1] == " + Arrays.toString(stcpu.getOrder(new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2}})));
        System.out.println("[4,5,3,2,0,1] == " + Arrays.toString(stcpu.getOrder(new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2},{7,2}})));
        System.out.println("[6,1,2,9,4,10,0,11,5,13,3,8,12,7] == " + Arrays.toString(stcpu.getOrder(new int[][]{{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}})));
    }

    public void countPairsOfSimilarStrings() {
        CountPairsOfSimilarStrings cposs = new CountPairsOfSimilarStrings();

        System.out.println("2 == " + cposs.similarPairs(new String[]{"aba","aabb","abcd","bac","aabc"}));
        System.out.println("3 == " + cposs.similarPairs(new String[]{"aabb","ab","ba"}));
        System.out.println("0 == " + cposs.similarPairs(new String[]{"nba","cba","dba"}));
    }
}
