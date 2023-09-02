package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.september.ExtraCharactersInAString;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

        start.extraCharactersInAString();
    }

    public void extraCharactersInAString() {
        ExtraCharactersInAString exias = new ExtraCharactersInAString();

        System.out.println("1 == " + exias.minExtraChar("leetscode", new String[]{"leet","code","leetcode"}));
        System.out.println("3 == " + exias.minExtraChar("sayhelloworld", new String[]{"hello","world"}));
    }
}
