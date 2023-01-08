package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.january.MinimumNumberOfArrowsToBurstBalloons;
import com.ss.leetcode.LC2023.january.MinimumRoundsToCompleteAllTasks;
import com.ss.leetcode.LC2023.january.MostFrequentEvenElement;
import com.ss.leetcode.LC2023.january.RearrangeCharactersToMakeTargetString;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

//        start.minimumRoundsToCompleteAllTasks();
//        start.minimumNumberOfArrowsToBurstBalloons();
//        start.rearrangeCharactersToMakeTargetString();
        start.mostFrequentEvenElement();

    }

    public void minimumRoundsToCompleteAllTasks() {
        MinimumRoundsToCompleteAllTasks mrtcat = new MinimumRoundsToCompleteAllTasks();

        System.out.println("4 == " + mrtcat.minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
        System.out.println("-1 == " + mrtcat.minimumRounds(new int[]{2,3,3}));
    }

    public void minimumNumberOfArrowsToBurstBalloons() {
        MinimumNumberOfArrowsToBurstBalloons mnoatbb = new MinimumNumberOfArrowsToBurstBalloons();

        System.out.println("2 == " + mnoatbb.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println("4 == " + mnoatbb.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        System.out.println("2 == " + mnoatbb.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
        System.out.println("2 == " + mnoatbb.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
    }

    public void rearrangeCharactersToMakeTargetString() {
        RearrangeCharactersToMakeTargetString rctmts = new RearrangeCharactersToMakeTargetString();

        System.out.println("2 == " +  rctmts.rearrangeCharacters("ilovecodingonleetcode", "code"));
        System.out.println("1 == " +  rctmts.rearrangeCharacters("abcba", "abc"));
        System.out.println("1 == " +  rctmts.rearrangeCharacters("abbaccaddaeea", "aaaaa"));
        System.out.println("0 == " +  rctmts.rearrangeCharacters("a", "ab"));
        System.out.println("0 == " +  rctmts.rearrangeCharacters("a", "z"));
    }

    public void mostFrequentEvenElement() {
        MostFrequentEvenElement mfee = new MostFrequentEvenElement();

        System.out.println("2 == " + mfee.mostFrequentEven(new int[]{0,1,2,2,4,4,1}));
        System.out.println("4 == " + mfee.mostFrequentEven(new int[]{4,4,4,9,2,4}));
        System.out.println("-1 == " + mfee.mostFrequentEven(new int[]{29,47,21,41,13,37,25,7}));
        System.out.println("0 == " + mfee.mostFrequentEven(new int[]{0,1,2,2,4,4,1,0}));
    }
}
