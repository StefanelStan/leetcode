package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.december.BeautifulTowersI;
import com.ss.leetcode.LC2024.december.CountCompleteSubarraysInAnArray;
import com.ss.leetcode.LC2024.december.LexicographicallySmallestStringAfterOperationsWithConstraint;
import com.ss.leetcode.LC2024.december.MinimizeMalwareSpread;
import com.ss.leetcode.LC2024.december.MinimumLimitOfBallsInABag;
import com.ss.leetcode.LC2024.december.ValidWord;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

//        start.lexicographicallySmallestStringAfterOperationsWithConstraint();
//        start.beautifulTowersI();
//        start.validWord();
//        start.minimizeMalwareSpread();
//        start.countCompleteSubarraysInAnArray();
        start.minimumLimitOfBallsInABag();
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

    public void countCompleteSubarraysInAnArray() {
        CountCompleteSubarraysInAnArray ccsiaa = new CountCompleteSubarraysInAnArray();

        System.out.println("4 == " + ccsiaa.countCompleteSubarrays(new int[]{1,3,1,2,2}));
        System.out.println("10 == " + ccsiaa.countCompleteSubarrays(new int[]{5,5,5,5}));
    }

   public void minimumLimitOfBallsInABag() {
       MinimumLimitOfBallsInABag mlobiab = new MinimumLimitOfBallsInABag();

       System.out.println("3 == " + mlobiab.minimumSize(new int[]{9}, 2));
       System.out.println("2 == " + mlobiab.minimumSize(new int[]{2,4,8,2}, 4));
       System.out.println("4 == " + mlobiab.minimumSize(new int[]{5,4,3,3,4,5,6,7,8}, 7));
       System.out.println("6 == " + mlobiab.minimumSize(new int[]{5,4,3,3,4,5,6,7,8}, 2));
       System.out.println("3 == " + mlobiab.minimumSize(new int[]{5,4,3,3,4,5,6,7,8}, 12));
       System.out.println("8 == " + mlobiab.minimumSize(new int[]{7,6,5,56,6,7,8,9,7,6,5,4,3,2,3,5,67}, 16));
       System.out.println("12 == " + mlobiab.minimumSize(new int[]{7,6,5,56,6,7,8,9,7,6,5,4,3,2,3,5,67}, 9));
       System.out.println("10 == " + mlobiab.minimumSize(new int[]{7,6,5,56,6,7,8,9,7,6,5,4,3,2,3,5,67}, 11));
   }
}
