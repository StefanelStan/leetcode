package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.september.CanConvertStringInKMoves;
import com.ss.leetcode.LC2023.september.ExtraCharactersInAString;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

//        start.extraCharactersInAString();
        start.canConvertStringInKMoves();
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
}
