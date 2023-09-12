package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.september.CanConvertStringInKMoves;
import com.ss.leetcode.LC2023.september.DesignTwitter;
import com.ss.leetcode.LC2023.september.ExtraCharactersInAString;
import com.ss.leetcode.LC2023.september.ImplementMagicDictionary;
import com.ss.leetcode.LC2023.september.LongestHappyString;
import com.ss.leetcode.LC2023.september.MaximumNonNegativeProductInAMatrix;
import com.ss.leetcode.LC2023.september.SentenceSimilarityIII;
import com.ss.leetcode.LC2023.september.SumOfSubarrayRanges;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

//        start.extraCharactersInAString();
//        start.canConvertStringInKMoves();
//        start.implementMagicDictionary();
//        start.longestHappyString();
//        start.sentenceSimilarityIII();
//        start.maximumNonNegativeProductInAMatrix();
//        start.designTwitter();
        start.sumOfSubarrayRanges();
    }

    public void extraCharactersInAString() {
        ExtraCharactersInAString exias = new ExtraCharactersInAString();

        System.out.println("1 == " + exias.minExtraChar("leetscode", new String[]{"leet","code","leetcode"}));
        System.out.println("3 == " + exias.minExtraChar("sayhelloworld", new String[]{"hello","world"}));
    }

    public void canConvertStringInKMoves() {
        CanConvertStringInKMoves ccsikm = new CanConvertStringInKMoves();

        System.out.println("true == " + ccsikm.canConvertString("input", "ouput", 9));
        System.out.println("false == " + ccsikm.canConvertString("abc", "bcd", 10));
        System.out.println("true == " + ccsikm.canConvertString("aab", "bbb", 27));
        System.out.println("false == " + ccsikm.canConvertString("abc", "abcd", 1000));
    }

    public void implementMagicDictionary() {
        ImplementMagicDictionary imd = new ImplementMagicDictionary();

        imd.buildDict(new String[]{"hello", "leetcode"});
        System.out.println("false == " + imd.search("hello"));
        System.out.println("true == " + imd.search("hhllo"));
        System.out.println("false == " + imd.search("hell"));
        System.out.println("false == " + imd.search("leetcoded"));
    }

    public void longestHappyString() {
        LongestHappyString lhs = new LongestHappyString();

        System.out.println("ccaccbcc == " + lhs.longestDiverseString(1,1,7));
        System.out.println("aabaa == " + lhs.longestDiverseString(7,1,0));
        System.out.println("aabaacaa == " + lhs.longestDiverseString(6,1,1));
    }

    public void sentenceSimilarityIII() {
        SentenceSimilarityIII ssiii = new SentenceSimilarityIII();

        System.out.println("true == " + ssiii.areSentencesSimilar("My name is Haley", "My Haley"));
        System.out.println("false == " + ssiii.areSentencesSimilar("of", "A lot of words"));
        System.out.println("true == " + ssiii.areSentencesSimilar("Eating right now", "Eating"));
        System.out.println("true == " + ssiii.areSentencesSimilar("A A AAa", "A AAa"));
        System.out.println("true == " + ssiii.areSentencesSimilar("A B C D B B", "A B B"));
    }

    public void maximumNonNegativeProductInAMatrix() {
        MaximumNonNegativeProductInAMatrix mnnpiam = new MaximumNonNegativeProductInAMatrix();

        System.out.println("-1 == " + mnnpiam.maxProductPath(new int[][]{{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}}));
        System.out.println("8 == " + mnnpiam.maxProductPath(new int[][]{{1,-2,1},{1,-2,1},{3,-4,1}}));
        System.out.println("0 == " + mnnpiam.maxProductPath(new int[][]{{1,3},{0,-4}}));

    }

    public void designTwitter() {
        DesignTwitter dt = new DesignTwitter();

        dt.postTweet(1, 5);
        System.out.println("[5] == " + dt.getNewsFeed(1));
        dt.follow(1, 2);
        dt.postTweet(2, 6);
        System.out.println("[6,5] == " + dt.getNewsFeed(1));
        dt.unfollow(1, 2);
        System.out.println("[5] == " + dt.getNewsFeed(1));

        dt = new DesignTwitter();
        dt.postTweet(1, 5);
        System.out.println("[5] == " + dt.getNewsFeed(1));
        dt.follow(1, 2);
        dt.postTweet(2, 6);
        dt.postTweet(2, 7);
        dt.postTweet(2, 9);
        dt.postTweet(2, 8);
        dt.postTweet(2, 10);
        dt.postTweet(2, 12);
        dt.postTweet(2, 11);
        dt.postTweet(2, 14);
        dt.postTweet(2, 16);
        dt.postTweet(2, 15);
        dt.postTweet(2, 13);
        dt.postTweet(2, 17);

        System.out.println("[17,13,15,16,14,11,12,10,8,9] == " + dt.getNewsFeed(1));
        dt.unfollow(1, 2);
        System.out.println("[5] == " + dt.getNewsFeed(1));
        System.out.println("[17,13,15,16,14,11,12,10,8,9] == " + dt.getNewsFeed(2));
    }

    public void sumOfSubarrayRanges() {
        SumOfSubarrayRanges sosr = new SumOfSubarrayRanges();

        System.out.println("4 == " + sosr.subArrayRanges(new int[]{1,2,3}));
        System.out.println("4 == " + sosr.subArrayRanges(new int[]{1,3,3}));
        System.out.println("59 == " + sosr.subArrayRanges(new int[]{4,-2,-3,4,1}));
    }
}
