package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.december.LexicographicallySmallestStringAfterOperationsWithConstraint;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

        start.lexicographicallySmallestStringAfterOperationsWithConstraint();
    }

    public void lexicographicallySmallestStringAfterOperationsWithConstraint() {
        LexicographicallySmallestStringAfterOperationsWithConstraint lssaowc = new LexicographicallySmallestStringAfterOperationsWithConstraint();

        System.out.println("aaaz == " + lssaowc.getSmallestString("zbbz", 3));
        System.out.println("aawcd == " + lssaowc.getSmallestString("xaxcd", 4));
        System.out.println("lol == " + lssaowc.getSmallestString("lol", 0));
        System.out.println("aaaaaaaaaaaaaaaaaaaaajdsjdsds == " + lssaowc.getSmallestString("skhfadsfuhdskfdsfhsdfjdsjdsds", 124));
        System.out.println("aaaaaaaaaaaaa == " + lssaowc.getSmallestString("yhgffddsgfdgd", 74));
        System.out.println("addsguasuhisdhgfsdjf == " + lssaowc.getSmallestString("gldsguasuhisdhgfsdjf", 14));
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab == " + lssaowc.getSmallestString("dsfdhyjjghgfhgfhsgregtyjthgglierjf", 217));
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa == " + lssaowc.getSmallestString("fdgfdhgsregtrhrtsghtrghrrt", 631));
    }
}
