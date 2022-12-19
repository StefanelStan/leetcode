package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.december.BinaryTreeMaximumPathSum;
import com.ss.leetcode.LC2022.december.BullsAndCows;
import com.ss.leetcode.LC2022.december.FindIfPathExistsInGraph;
import com.ss.leetcode.LC2022.december.FindThePivotInteger;
import com.ss.leetcode.LC2022.december.ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters;
import com.ss.leetcode.shared.TreeNode;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

//        start.replaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters();
//        start.bullsAndCows();
//        start.binaryTreeMaximumPathSum();
//        start.findThePivotInteger();
        start.findIfPathExistsInGraph();
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
}
