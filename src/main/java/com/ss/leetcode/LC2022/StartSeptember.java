package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.september.AmountOfTimeForBinaryTreeToBeInfected;
import com.ss.leetcode.LC2022.september.BagOfTokens;
import com.ss.leetcode.LC2022.september.CheckDistancesBetweenSameLetters;
import com.ss.leetcode.LC2022.september.ConstructStringFromBinaryTree;
import com.ss.leetcode.LC2022.september.FindKClosestElements;
import com.ss.leetcode.LC2022.september.FindSubarraysWithEqualSum;
import com.ss.leetcode.LC2022.september.LongestSubsequenceWithLimitedSum;
import com.ss.leetcode.LC2022.september.MaximumNumberOfRobotsWithinBudget;
import com.ss.leetcode.LC2022.september.MaximumPerformanceOfATeam;
import com.ss.leetcode.LC2022.september.MinimumAmountOfTimeToCollectGarbage;
import com.ss.leetcode.LC2022.september.NumberOfGoodWaysToSplitAString;
import com.ss.leetcode.LC2022.september.NumbersWithSameConsecutiveDifferences;
import com.ss.leetcode.LC2022.september.SmallestEvenMultiple;
import com.ss.leetcode.LC2022.september.SortThePeople;
import com.ss.leetcode.LC2022.september.StrictlyPalindromicNumber;
import com.ss.leetcode.LC2022.september.TheNumberOfWeakCharactersInTheGame;
import com.ss.leetcode.LC2022.september.UTF8Validation;
import com.ss.leetcode.shared.TreeNode;
import java.util.Arrays;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

//        start.amountOfTimeForBinaryTreeToBeInfected();
//        start.longestSubsequenceWithLimitedSum();
//        start.findSubarraysWithEqualSum();
//        start.strictlyPalindromicNumber();
//        start.maximumNumberOfRobotsWithinBudget();
//        start.numbersWithSameConsecutiveDifferences();
//        start.constructStringFromBinaryTree();
//        start.theNumberOfWeakCharactersInTheGame();
//        start.minimumAmountOfTimeToCollectGarbage();
//        start.maximumPerformanceOfATeam();
//        start.numberOfGoodWaysToSplitAString();
//        start.bagOfTokens();
//        start.uft8Validation();
//        start.smallestEvenMultiple();
//        start.checkDistancesBetweenSameLetters();
//        start.sortThePeople();
        start.findKClosestElements();
    }

    public void amountOfTimeForBinaryTreeToBeInfected() {
        AmountOfTimeForBinaryTreeToBeInfected aotfbttbi = new AmountOfTimeForBinaryTreeToBeInfected();

        TreeNode root1 = new TreeNode(1, new TreeNode(5, null, new TreeNode(4, new TreeNode(9), new TreeNode(2))),
            new TreeNode(3, new TreeNode(10), new TreeNode(6)));
        TreeNode root2 = new TreeNode(1);

        System.out.println("4 == " + aotfbttbi.amountOfTime(root1, 3));
        System.out.println("0 == " + aotfbttbi.amountOfTime(root2, 1));
    }

    public void longestSubsequenceWithLimitedSum() {
        LongestSubsequenceWithLimitedSum lswls = new LongestSubsequenceWithLimitedSum();

        System.out.println("[2,3,4] == " + Arrays.toString(lswls.answerQueries(new int[]{4,5,2,1}, new int[]{3,10,21})));
        System.out.println("[0] == " + Arrays.toString(lswls.answerQueries(new int[]{2,3,4,5}, new int[]{1})));
        System.out.println("[2,2,1,1,2,3,3] == " + Arrays.toString(lswls.answerQueries(new int[]{736411,184882,914641,37925,214915}, new int[]{331244,273144,118983,118252,305688,718089,665450})));
        System.out.println("[0,2,0,1,2] == " + Arrays.toString(lswls.answerQueries(new int[]{76478,102343,247573,477461,430399,260435,250631,785081,904724,392720}, new int[]{63736,339518,37262,108251,216825})));
        System.out.println("[0,2,0,1,2] == " + Arrays.toString(lswls.answerQueries(new int[]{573210,20594,196301}, new int[]{880897,461149,301768,510087,572628,544429,141852,870779,156572})));
        System.out.println("[1,1,1,2] == " + Arrays.toString(lswls.answerQueries(new int[]{1,2,3,4}, new int[]{1,2,2,3})));
        System.out.println("[7,17,22,11,7,1,2,3,4,11,11,11,8,8,11,11,11,13,16,17] == " +
            Arrays.toString(lswls.answerQueries(new int[]{4,2,1,1,3,4,5,4,3,2,1,2,3,4,4,3,2,1,3,4,5,6},
                new int[]{11,45,98,23,11,1,2,3,4,22,22,21,12,12,21,22,23,30,40,45})));
    }

    public void findSubarraysWithEqualSum() {
        FindSubarraysWithEqualSum fswes = new FindSubarraysWithEqualSum();

        System.out.println("true == " + fswes.findSubarrays(new int[]{4,2,4}));
        System.out.println("false == " + fswes.findSubarrays(new int[]{1,2,3,4,5}));
        System.out.println("true == " + fswes.findSubarrays(new int[]{0,0,0}));
    }

    public void strictlyPalindromicNumber() {
        StrictlyPalindromicNumber spn = new StrictlyPalindromicNumber();

        System.out.println("false == " + spn.isStrictlyPalindromic(9));
        System.out.println("false == " + spn.isStrictlyPalindromic(4));
        System.out.println("true == " + spn.isStrictlyPalindromic(5));
    }

    public void maximumNumberOfRobotsWithinBudget() {
        MaximumNumberOfRobotsWithinBudget mnofwb = new MaximumNumberOfRobotsWithinBudget();

        System.out.println("3 == " + mnofwb.maximumRobots(new int[]{3,6,1,3,4}, new int[]{2,1,3,4,5}, 25));
        System.out.println("0 == " + mnofwb.maximumRobots(new int[]{11,12,19}, new int[]{10,8,7}, 19));
        System.out.println("1 == " + mnofwb.maximumRobots(new int[]{100000}, new int[]{100000}, 1000000000000000L));
    }

    public void numbersWithSameConsecutiveDifferences() {
        NumbersWithSameConsecutiveDifferences nwscd = new NumbersWithSameConsecutiveDifferences();

        System.out.println("[181,292,707,818,929] == " + Arrays.toString(nwscd.numsSameConsecDiff(3,7)));
        System.out.println("[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98] == " + Arrays.toString(nwscd.numsSameConsecDiff(2,1)));
        System.out.println("[11,22,33,44,55,66,77,88,99] == " + Arrays.toString(nwscd.numsSameConsecDiff(2,0)));
    }

    public void constructStringFromBinaryTree() {
        ConstructStringFromBinaryTree csfbt = new ConstructStringFromBinaryTree();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        TreeNode root3 = new TreeNode(1);

        System.out.println("1(2(4))(3) == " + csfbt.tree2str(root1));
        System.out.println("1(2()(4))(3) == " + csfbt.tree2str(root2));
        System.out.println("1 == " + csfbt.tree2str(root3));
    }

    public void theNumberOfWeakCharactersInTheGame() {
        TheNumberOfWeakCharactersInTheGame tnowcitg = new TheNumberOfWeakCharactersInTheGame();

        System.out.println("0 == " + tnowcitg.numberOfWeakCharacters(new int[][]{{5,5},{6,3},{3,6}}));
        System.out.println("1 == " + tnowcitg.numberOfWeakCharacters(new int[][]{{2,2},{3,3}}));
        System.out.println("1 == " + tnowcitg.numberOfWeakCharacters(new int[][]{{1,5},{10,4},{4,3}}));
    }

    public void minimumAmountOfTimeToCollectGarbage() {
        MinimumAmountOfTimeToCollectGarbage maoftcg = new MinimumAmountOfTimeToCollectGarbage();

        System.out.println("21 == " + maoftcg.garbageCollection(new String[]{"G","P","GP","GG"}, new int[]{2,4,3}));
        System.out.println("37 == " + maoftcg.garbageCollection(new String[]{"MMM","PGM","GP"}, new int[]{3,10}));
    }

    public void maximumPerformanceOfATeam() {
        MaximumPerformanceOfATeam mpoat = new MaximumPerformanceOfATeam();

        System.out.println("60 == " + mpoat.maxPerformance(6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 2));
        System.out.println("68 == " + mpoat.maxPerformance(6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 3));
        System.out.println("72 == " + mpoat.maxPerformance(6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 4));
    }

    public void numberOfGoodWaysToSplitAString() {
        NumberOfGoodWaysToSplitAString nogwtsas = new NumberOfGoodWaysToSplitAString();

        System.out.println("2 == " + nogwtsas.numSplits("aacaba"));
        System.out.println("1 == " + nogwtsas.numSplits("abcd"));
        System.out.println("0 == " + nogwtsas.numSplits("a"));
        System.out.println("2 == " + nogwtsas.numSplits("ghgvbsrfhvgsdghgytklmutibjedwcgferyhbrvtgd"));
    }

    public void bagOfTokens() {
        BagOfTokens bot = new BagOfTokens();

        System.out.println("0 == " + bot.bagOfTokensScore(new int[]{100}, 50));
        System.out.println("1 == " + bot.bagOfTokensScore(new int[]{100,200}, 150));
        System.out.println("2 == " + bot.bagOfTokensScore(new int[]{100,200,300,400}, 200));
        System.out.println("14 == " + bot.bagOfTokensScore(new int[]{5,6,7,3,4,2,5,6,7,5,4,3,2,1,4,5,6,7,8,9,5,4,3,0,6,5,0,3,1,4,5,0,8,7,6,5}, 8));
    }

    public void uft8Validation() {
        UTF8Validation utf8v = new UTF8Validation();

        System.out.println("true == " + utf8v.validUtf8(new int[]{197, 130, 1}));
        System.out.println("false == " + utf8v.validUtf8(new int[]{235,140,4}));
        System.out.println("true == " + utf8v.validUtf8(new int[]{11,34,16}));
        System.out.println("true == " + utf8v.validUtf8(new int[]{255}));
    }

    public void smallestEvenMultiple() {
        SmallestEvenMultiple sem = new SmallestEvenMultiple();

        System.out.println("10 == " + sem.smallestEvenMultiple(5));
        System.out.println("6 == " + sem.smallestEvenMultiple(6));
    }

    public void checkDistancesBetweenSameLetters() {
        CheckDistancesBetweenSameLetters cdbsl = new CheckDistancesBetweenSameLetters();

        System.out.println("true ==  " + cdbsl.checkDistances("abaccb", new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        System.out.println("false ==  " + cdbsl.checkDistances("aa", new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }

    public void sortThePeople() {
        SortThePeople stp = new SortThePeople();

        System.out.println("[Mary, Emma, John] == " + Arrays.toString(stp.sortPeople(new String[]{"Mary","John","Emma"}, new int[]{180, 165, 170})));
        System.out.println("[Bob, Alice, Bob] == " + Arrays.toString(stp.sortPeople(new String[]{"Alice","Bob","Bob"}, new int[]{155, 185, 150})));
    }

    public void findKClosestElements() {
        FindKClosestElements fkce = new FindKClosestElements();

        System.out.println("[1,2,3,4] == " + fkce.findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
        System.out.println("[1,2,3,4] == " + fkce.findClosestElements(new int[]{1,2,3,4,6}, 4, -1));
        System.out.println("[3,3,4] == " + fkce.findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5));
    }
}
