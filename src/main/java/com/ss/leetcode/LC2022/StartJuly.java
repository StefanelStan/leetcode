package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.july.CalculateAmountPaidInTaxes;
import com.ss.leetcode.LC2022.july.Candy;
import com.ss.leetcode.LC2022.july.CheckIfMatrixIsXMatrix;
import com.ss.leetcode.LC2022.july.DecodeTheMessage;
import com.ss.leetcode.LC2022.july.EvaluateBooleanBinaryTree;
import com.ss.leetcode.LC2022.july.FindDuplicateSubtrees;
import com.ss.leetcode.LC2022.july.GreatestEnglishLetterInUpperAndLowerCase;
import com.ss.leetcode.LC2022.july.JumpGameVI;
import com.ss.leetcode.LC2022.july.LongestConsecutiveSequence;
import com.ss.leetcode.LC2022.july.MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts;
import com.ss.leetcode.LC2022.july.MinimumSumOfSquaredDifference;
import com.ss.leetcode.LC2022.july.RemoveDigitFromNumberToMaximizeResult;
import com.ss.leetcode.LC2022.july.SolvingQuestionsWithBrainpower;
import com.ss.leetcode.shared.TreeNode;
import com.sun.source.tree.YieldTree;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

//        start.maximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();
//        start.decodeTheMessage();
//        start.candy();
//        start.longestConsecutiveSequence();
//        start.checkIfMatrixIsXMatrix();
//        start.calculateAmountPaidInTaxes();
//        start.removeDigitFromNumberToMaximizeResult();
//        start.solvingQuestionsWithBrainpower();
//        start.jumpGameVI();
//        start.evaluateBooleanBinaryTree();
//        start.minimumSumOfSquaredDifference();
//        start.findDuplicateSubtrees();
        start.greatestEnglishLetterInUpperAndLowerCase();
    }

    public void maximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts() {
        MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts maoapocahavc = new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();

        System.out.println("4 == " + maoapocahavc.maxArea(5,4, new int[]{1,2,4}, new int[]{1,3}));
        System.out.println("6 == " + maoapocahavc.maxArea(5,4, new int[]{3,1}, new int[]{1}));
        System.out.println("9 == " + maoapocahavc.maxArea(5,4, new int[]{3}, new int[]{3}));
        System.out.println("321374711 == " + maoapocahavc.maxArea(10000000,10000000, new int[]{5,500000}, new int[]{239,597124}));
    }

    public void decodeTheMessage() {
        DecodeTheMessage dtm = new DecodeTheMessage();

        System.out.println("this is a secret == " + dtm.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println("the five boxing wizards jump quickly == " + dtm.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }

    public void candy() {
        Candy c = new Candy();

        System.out.println("5 == " + c.candy(new int[]{1,0,2}));
        System.out.println("4 == " + c.candy(new int[]{1,2,2}));
        System.out.println("12 == " + c.candy(new int[]{29,51,87,87,72,12}));
    }

    public void longestConsecutiveSequence() {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

        System.out.println("4 == "+ lcs.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println("9 == "+ lcs.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println("0 == "+ lcs.longestConsecutive(new int[0]));
    }

    public void checkIfMatrixIsXMatrix() {
        CheckIfMatrixIsXMatrix cimixm = new CheckIfMatrixIsXMatrix();

        System.out.println("true == " + cimixm.checkXMatrix(new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}}));
        System.out.println("false == " + cimixm.checkXMatrix(new int[][]{{5,7,0},{0,3,1},{0,5,0}}));
    }

    public void calculateAmountPaidInTaxes() {
        CalculateAmountPaidInTaxes capit = new CalculateAmountPaidInTaxes();

        System.out.println("2.65000 == " + capit.calculateTax(new int[][]{{3,50},{7,10},{12,25}}, 10));
        System.out.println("0.25000 == " + capit.calculateTax(new int[][]{{1,0},{4,25},{5,50}}, 2));
        System.out.println("0.00000 == " + capit.calculateTax(new int[][]{{2,50}}, 0));
    }

    public void removeDigitFromNumberToMaximizeResult() {
        RemoveDigitFromNumberToMaximizeResult rdfntmr = new RemoveDigitFromNumberToMaximizeResult();

        System.out.println("12 == " + rdfntmr.removeDigit("123", '3'));
        System.out.println("231 == " + rdfntmr.removeDigit("1231", '1'));
        System.out.println("51 == " + rdfntmr.removeDigit("551", '5'));
        System.out.println("51 == " + rdfntmr.removeDigit("551", '5'));
        System.out.println("361955234 == " + rdfntmr.removeDigit("3619552534", '5'));
        System.out.println("7319 == " + rdfntmr.removeDigit("73197", '7'));
        System.out.println("782198816375484682 == " + rdfntmr.removeDigit("7821988163754846982", '9'));
    }

    public void solvingQuestionsWithBrainpower() {
        SolvingQuestionsWithBrainpower sqwb = new SolvingQuestionsWithBrainpower();

        System.out.println("5 == " + sqwb.mostPoints(new int[][]{{3,2},{4,3},{4,4},{2,5}}));
        System.out.println("7 == " + sqwb.mostPoints(new int[][]{{1,1},{2,2},{3,3},{4,4},{5,5}}));
        System.out.println("7 == " + sqwb.mostPoints(new int[][]{{3,2},{4,1},{4,5},{2,5},{3,1}}));
    }

    public void jumpGameVI() {
        JumpGameVI jgvi = new JumpGameVI();

        System.out.println("7 == " + jgvi.maxResult(new int[]{1,-1,-2,4,-7,3}, 2));
        System.out.println("17 == " + jgvi.maxResult(new int[]{10,-5,-2,4,0,3}, 3));
        System.out.println("0 == " + jgvi.maxResult(new int[]{1,-5,-20,4,-1,3,-6,-3}, 2));
        System.out.println("28 == " + jgvi.maxResult(new int[]{6,4,2,7,-1,-5,-3,-8,-4,-4,-6,-1,5,-3,8,-8,3}, 3));
        System.out.println("28 == " + jgvi.maxResult(new int[]{6,4,2,7,-1,-5,-3,-8,-4,-4,-6,-1,5,-3,8,-8,3}, 3));
    }

    public void evaluateBooleanBinaryTree() {
        EvaluateBooleanBinaryTree ebbt = new EvaluateBooleanBinaryTree();

        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3, new TreeNode(0), new TreeNode(1)));

        System.out.println("true == " + ebbt.evaluateTree(root1));
        System.out.println("false == " + ebbt.evaluateTree(new TreeNode(0)));
    }

    public void minimumSumOfSquaredDifference() {
        MinimumSumOfSquaredDifference msosd = new MinimumSumOfSquaredDifference();

        System.out.println("579 == " + msosd.minSumSquareDiff(new int[]{1,2,3,4}, new int[]{2,10,20,19}, 0,0));
        System.out.println("43 == " + msosd.minSumSquareDiff(new int[]{1,4,10,12}, new int[]{5,8,6,9}, 1,1));
        System.out.println("27 == " + msosd.minSumSquareDiff(new int[]{7,11,4,19,11,5,6,1,8}, new int[]{4,7,6,16,12,9,10,2,10}, 3,6));
        System.out.println("0 == " + msosd.minSumSquareDiff(new int[]{1,4,10,12}, new int[]{5,8,6,9}, 10, 5));
        System.out.println("985 == " + msosd.minSumSquareDiff(new int[]{19,18,19,18,18,19,19}, new int[]{1,0,1,0,0,1,1}, 10, 33));
        System.out.println("17 == " + msosd.minSumSquareDiff(new int[]{18,4,8,19,13,8}, new int[]{18,11,8,2,13,15}, 16, 8));
    }

    public void findDuplicateSubtrees() {
        FindDuplicateSubtrees fds = new FindDuplicateSubtrees();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(1));
        TreeNode root3 = new TreeNode(2, new TreeNode(2, new TreeNode(3), null), new TreeNode(2, new TreeNode(3), null));
        TreeNode root4 = new TreeNode(1, new TreeNode(2, new TreeNode(0, new TreeNode(0), new TreeNode(0)), null),
            new TreeNode(2, null, new TreeNode(0, new TreeNode(0), new TreeNode(0))));

        TreeNode root5 = new TreeNode(0, null,
            new TreeNode(0,
                new TreeNode(4,
                    new TreeNode(1,
                        new TreeNode(4,
                            new TreeNode(7,
                                new TreeNode(7,
                                    new TreeNode(9, new TreeNode(4), new TreeNode(4)),
                                    new TreeNode(8, new TreeNode(7), new TreeNode(7))),
                                new TreeNode(7,
                                    new TreeNode(1, null, new TreeNode(1)),
                                    new TreeNode(7, new TreeNode(5), new TreeNode(6)))),
                            new TreeNode(4)),
                        new TreeNode(0,
                            new TreeNode(1,
                                new TreeNode(0,
                                    new TreeNode(7, new TreeNode(2), new TreeNode(7)),
                                    new TreeNode(7, new TreeNode(3), null)),
                                new TreeNode(2,
                                    new TreeNode(2, new TreeNode(9), new TreeNode(1)),
                                    new TreeNode(6, null, new TreeNode(2)))),
                            new TreeNode(6,
                                new TreeNode(5, null, new TreeNode(7, new TreeNode(4), new TreeNode(4))),
                                new TreeNode(5, null, new TreeNode(4, new TreeNode(8), null))))),
                    new TreeNode(2,
                        new TreeNode(4,
                            null,
                            new TreeNode(1,
                                new TreeNode(9,
                                    new TreeNode(6, null, new TreeNode(7)),
                                    new TreeNode(4, null, new TreeNode(6))),
                                new TreeNode(3,
                                    new TreeNode(6, null, new TreeNode(7)),
                                    null))),
                        new TreeNode(3,
                            new TreeNode(0,
                                new TreeNode(3, null, new TreeNode(9, new TreeNode(4), new TreeNode(3))),
                                null),
                            null))),
                new TreeNode(9, null,
                    new TreeNode(4, new TreeNode(5),
                        new TreeNode(5,
                            new TreeNode(2,
                                new TreeNode(7, new TreeNode(1, new TreeNode(5), new TreeNode(8)), null),
                                new TreeNode(6)),
                            new TreeNode(8,
                                new TreeNode(6, new TreeNode(2, new TreeNode(4), new TreeNode(8)), null),
                                new TreeNode(7,
                                    new TreeNode(9, new TreeNode(3), new TreeNode(5)),
                                    new TreeNode(1, new TreeNode(5), null))))))));

        TreeNode root6 = new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0))))))))))))))))))))))))))))))))))))))))));
        System.out.println("[[2,4], 4] == " + fds.findDuplicateSubtrees(root1));
        System.out.println("[[1]] == " + fds.findDuplicateSubtrees(root2));
        System.out.println("[[2,3],[3]] == " + fds.findDuplicateSubtrees(root3));
        System.out.println("[[0,0,0],[0]] == " + fds.findDuplicateSubtrees(root4));
        System.out.println("[[6],[6,null,7],[2],[7],[1],[4],[8],[3],[5]] == " + fds.findDuplicateSubtrees(root5));
        System.out.println("9 == " + fds.findDuplicateSubtrees(root5).size());
        System.out.println("0 == " + fds.findDuplicateSubtrees(root6).size());
    }

    public void greatestEnglishLetterInUpperAndLowerCase() {
        GreatestEnglishLetterInUpperAndLowerCase geliualc = new GreatestEnglishLetterInUpperAndLowerCase();

        System.out.println("E == " + geliualc.greatestLetter("lEeTcOdE"));
        System.out.println("R == " + geliualc.greatestLetter("arRAzFif"));
        System.out.println(" == " + geliualc.greatestLetter("AbCdEfGhIjK"));
    }
}
