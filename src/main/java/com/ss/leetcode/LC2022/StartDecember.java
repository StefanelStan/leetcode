package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.december.BullsAndCows;
import com.ss.leetcode.LC2022.december.ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

//        start.replaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters();
        start.bullsAndCows();
    }

    public void replaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters() {
        ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters raqmtacrc = new ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters();

        System.out.println("azs == " + raqmtacrc.modifyString("?zs"));
        System.out.println("ubvaw == " + raqmtacrc.modifyString("ubv?w"));
        System.out.println("ab == " + raqmtacrc.modifyString("a?"));
    }

    public void bullsAndCows() {
        BullsAndCows bac = new BullsAndCows();

        System.out.println("1A3B == " + bac.getHint("1807", "7810"));
        System.out.println("1A1B == " + bac.getHint("1123", "1123"));
        System.out.println("13A75B == " + bac.getHint("875397583249587958346276210984132798474987348906413879463875423757642483721943143473494046142094621390876234890753",
            "209347539481573120548158965274852317856384710470132742109640198609123641098246120984621904621986612461204216400124"));
    }
}
