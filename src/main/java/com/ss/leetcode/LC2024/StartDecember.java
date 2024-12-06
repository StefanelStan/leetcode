package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.december.BeautifulTowersI;
import com.ss.leetcode.LC2024.december.LexicographicallySmallestStringAfterOperationsWithConstraint;
import com.ss.leetcode.LC2024.december.MinimizeMalwareSpread;
import com.ss.leetcode.LC2024.december.ValidWord;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

//        start.lexicographicallySmallestStringAfterOperationsWithConstraint();
//        start.beautifulTowersI();
//        start.validWord();
        start.minimizeMalwareSpread();
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

    public void beautifulTowersI() {
        BeautifulTowersI bti = new BeautifulTowersI();

        System.out.println("13 == " + bti.maximumSumOfHeights(new int[]{5,3,4,1,1}));
        System.out.println("22 == " + bti.maximumSumOfHeights(new int[]{6,5,3,9,2,7}));
        System.out.println("18 == " + bti.maximumSumOfHeights(new int[]{3,2,5,5,2,3}));
    }

    public void validWord() {
        ValidWord vw = new ValidWord();

        System.out.println("true == " + vw.isValid("234Adas"));
        System.out.println("false == " + vw.isValid("b3"));
        System.out.println("false == " + vw.isValid("a3$e"));
    }

    public void minimizeMalwareSpread() {
        MinimizeMalwareSpread mms = new MinimizeMalwareSpread();

        System.out.println("0 == " + mms.minMalwareSpread(new int[][]{{1,1,0},{1,1,0},{0,0,1}}, new int[]{0,1}));
        System.out.println("0 == " + mms.minMalwareSpread(new int[][]{{1,0,0},{0,1,0},{0,0,1}}, new int[]{0,2}));
        System.out.println("1 == " + mms.minMalwareSpread(new int[][]{{1,1,1},{1,1,1},{1,1,1}}, new int[]{1,2}));
    }
}
