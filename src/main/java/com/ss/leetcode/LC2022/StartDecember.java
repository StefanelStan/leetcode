package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.december.ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

        start.replaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters();
    }

    public void replaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters() {
        ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters raqmtacrc = new ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters();

        System.out.println("azs == " + raqmtacrc.modifyString("?zs"));
        System.out.println("ubvaw == " + raqmtacrc.modifyString("ubv?w"));
        System.out.println("ab == " + raqmtacrc.modifyString("a?"));
    }
}
