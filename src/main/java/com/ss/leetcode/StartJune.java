package com.ss.leetcode;

import com.ss.leetcode.june.CheckIfWordSumTwoWords;
import com.ss.leetcode.june.ConvertBinaryNumber;
import com.ss.leetcode.june.CountOfMatchesInTournament;
import com.ss.leetcode.june.FindTheHighestAltitude;
import com.ss.leetcode.june.FindingTheUsersActiveMinutes;
import com.ss.leetcode.june.MinimizeMaximumPairSumInArray;
import com.ss.leetcode.june.RemoveOutermostParentheses;
import com.ss.leetcode.june.ReplaceAllDigitsWithCharacters;
import com.ss.leetcode.june.SortingTheSentence;
import com.ss.leetcode.june.ToLowerCase;
import com.ss.leetcode.june.TruncateSentence;
import com.ss.leetcode.june.XOROperationInAnArray;

import java.util.Arrays;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

//        start.checkIfWordEqualsSummationOfTwoWords();
//        start.countOfMatchesInTournament();
//        start.sortingTheSentence();
//        start.convertBinaryNumberInALinkedLisToInteger();
//        start.removeOutermostParentheses();
//        start.toLowerCase();
//        start.truncateSentence();
//        start.xorOperationInAnArray();
//        start.replaceAllDigitsWithCharacters();
//        start.findTheHighestAltitude();
//        start.minimizeMaximumPairSumInArray();
        start.findingTheUsersActiveMinutes();
    }

    public void checkIfWordEqualsSummationOfTwoWords() {
        CheckIfWordSumTwoWords ciwstw = new CheckIfWordSumTwoWords();

        System.out.println("true == " + ciwstw.isSumEqual("acb", "cba", "cdb"));
        System.out.println("false == " + ciwstw.isSumEqual("aaa", "a", "aab"));
        System.out.println("true == " + ciwstw.isSumEqual("aaa", "a", "aaaa"));
    }

    public void countOfMatchesInTournament() {
        CountOfMatchesInTournament comit = new CountOfMatchesInTournament();

        System.out.println("6 == "+ comit.numberOfMatches(7));
        System.out.println("0 == "+ comit.numberOfMatches(1));
        System.out.println("3 == "+ comit.numberOfMatches(4));
        System.out.println("13 == "+ comit.numberOfMatches(14));
    }

    public void sortingTheSentence() {
        SortingTheSentence sts = new SortingTheSentence();

        System.out.println("This is a sentence == " + sts.sortSentence("is2 sentence4 This1 a3"));
        System.out.println("Me Myself and I == " + sts.sortSentence("Myself2 Me1 I4 and3"));
    }

    public void convertBinaryNumberInALinkedLisToInteger() {
        ConvertBinaryNumber cbn = new ConvertBinaryNumber();

        System.out.println("5 == " + cbn.getDecimalValue(ConvertBinaryNumber.ListNode.makeChain(new int[]{1,0,1})));
        System.out.println("0 == " + cbn.getDecimalValue(ConvertBinaryNumber.ListNode.makeChain(new int[]{0})));
        System.out.println("1 == " + cbn.getDecimalValue(ConvertBinaryNumber.ListNode.makeChain(new int[]{1})));
        System.out.println("18880 == " + cbn.getDecimalValue(ConvertBinaryNumber.ListNode.makeChain(new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0})));
        System.out.println("0 == " + cbn.getDecimalValue(ConvertBinaryNumber.ListNode.makeChain(new int[]{0,0})));
    }

    public void removeOutermostParentheses() {
        RemoveOutermostParentheses rop = new RemoveOutermostParentheses();

        System.out.println("()()() == " + rop.removeOuterParentheses("(()())(())"));
        System.out.println("()()()()(()) == " + rop.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(" == " + rop.removeOuterParentheses("()()"));


    }

    public void toLowerCase() {
        ToLowerCase tlc = new ToLowerCase();

        System.out.println("hello == " + tlc.toLowerCase("Hello"));
        System.out.println("here == " + tlc.toLowerCase("here"));
        System.out.println("lovely == " + tlc.toLowerCase("LOVELY"));
    }

    public void truncateSentence() {
        TruncateSentence ts = new TruncateSentence();

        System.out.println("Hello how are you == " + ts.truncateSentence("Hello how are you Contestant", 4));
        System.out.println("What is the solution == " + ts.truncateSentence("What is the solution to this problem", 4));
        System.out.println("chopper is not a tanuki == " + ts.truncateSentence("chopper is not a tanuki", 5));
    }

    public void xorOperationInAnArray() {
        XOROperationInAnArray xoiaa = new XOROperationInAnArray();

        System.out.println("8 == " + xoiaa.xorOperation(5, 0));
        System.out.println("8 == " + xoiaa.xorOperation(4, 3));
        System.out.println("7 == " + xoiaa.xorOperation(1, 7));
        System.out.println("2 == " + xoiaa.xorOperation(10, 5));
    }

    public void replaceAllDigitsWithCharacters() {
        ReplaceAllDigitsWithCharacters radwc = new ReplaceAllDigitsWithCharacters();

        System.out.println("abcdef == " + radwc.replaceDigits("a1c1e1"));
        System.out.println("abbdcfdhe == " + radwc.replaceDigits("a1b2c3d4e"));
    }

    public void findTheHighestAltitude() {
        FindTheHighestAltitude ftha = new FindTheHighestAltitude();

        System.out.println("1 == " + ftha.largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println("0 == " + ftha.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }

    public void minimizeMaximumPairSumInArray() {
        MinimizeMaximumPairSumInArray mmpsia = new MinimizeMaximumPairSumInArray();

        System.out.println("7 == "+mmpsia.minPairSum(new int[]{3,5,2,3}));
        System.out.println("8 == "+mmpsia.minPairSum(new int[]{3,5,4,2,4,6}));
    }

    public void findingTheUsersActiveMinutes() {
        FindingTheUsersActiveMinutes ftuam = new FindingTheUsersActiveMinutes();
        int[][] logs1 = {{0,5}, {1,2}, {0,2}, {0,5}, {1,3}};
        int[][] logs2 = {{1,1}, {2,2}, {2,3}};

        System.out.println("[0,2,0,0,0] == "+ Arrays.toString(ftuam.findingUsersActiveMinutes(logs1, 5)));
        System.out.println("[1,1,0,0] == "+ Arrays.toString(ftuam.findingUsersActiveMinutes(logs2, 4)));
    }
}
