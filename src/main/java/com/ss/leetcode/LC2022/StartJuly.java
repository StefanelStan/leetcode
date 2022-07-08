package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.july.CalculateAmountPaidInTaxes;
import com.ss.leetcode.LC2022.july.Candy;
import com.ss.leetcode.LC2022.july.CheckIfMatrixIsXMatrix;
import com.ss.leetcode.LC2022.july.DecodeTheMessage;
import com.ss.leetcode.LC2022.july.LongestConsecutiveSequence;
import com.ss.leetcode.LC2022.july.MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts;
import com.ss.leetcode.LC2022.july.RemoveDigitFromNumberToMaximizeResult;
import com.ss.leetcode.LC2022.july.SolvingQuestionsWithBrainpower;

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
        start.solvingQuestionsWithBrainpower();
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
}
