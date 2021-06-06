package com.ss.leetcode;

import com.ss.leetcode.june.CheckIfWordSumTwoWords;
import com.ss.leetcode.june.CountOfMatchesInTournament;
import com.ss.leetcode.june.SortingTheSentence;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

//        start.checkIfWordEqualsSummationOfTwoWords();
//        start.countOfMatchesInTournament();
        start.sortingTheSentence();
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

}
