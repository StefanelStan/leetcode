package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.september.CanConvertStringInKMoves;
import com.ss.leetcode.LC2023.september.ExtraCharactersInAString;
import com.ss.leetcode.LC2023.september.ImplementMagicDictionary;
import com.ss.leetcode.LC2023.september.LongestHappyString;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

//        start.extraCharactersInAString();
//        start.canConvertStringInKMoves();
//        start.implementMagicDictionary();
        start.longestHappyString();
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
}
