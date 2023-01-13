package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.january.LongestPathWithDifferentAdjacentCharacters;
import com.ss.leetcode.LC2023.january.MinimumNumberOfArrowsToBurstBalloons;
import com.ss.leetcode.LC2023.january.MinimumRoundsToCompleteAllTasks;
import com.ss.leetcode.LC2023.january.MostFrequentEvenElement;
import com.ss.leetcode.LC2023.january.NumberOfNodesInTheSubTreeWithTheSameLabel;
import com.ss.leetcode.LC2023.january.RearrangeCharactersToMakeTargetString;
import java.util.Arrays;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

//        start.minimumRoundsToCompleteAllTasks();
//        start.minimumNumberOfArrowsToBurstBalloons();
//        start.rearrangeCharactersToMakeTargetString();
//        start.mostFrequentEvenElement();
//        start.numberOfNodesInTheSubTreeWithTheSameLabel();
        start.longestPathWithDifferentAdjacentCharacters();
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

    public void numberOfNodesInTheSubTreeWithTheSameLabel() {
        NumberOfNodesInTheSubTreeWithTheSameLabel nonitstwtsl = new NumberOfNodesInTheSubTreeWithTheSameLabel();

        System.out.println("[2,1,1,1,1,1,1] == " + Arrays.toString(nonitstwtsl.countSubTrees(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, "abaedcd")));
        System.out.println("[4,2,1,1] == " + Arrays.toString(nonitstwtsl.countSubTrees(4, new int[][]{{0,1},{1,2},{0,3}}, "bbbb")));
        System.out.println("[3,2,1,1,1] == " + Arrays.toString(nonitstwtsl.countSubTrees(5, new int[][]{{0,1},{0,2},{1,3},{0,4}}, "aabab")));
    }

    public void longestPathWithDifferentAdjacentCharacters() {
        LongestPathWithDifferentAdjacentCharacters lpwdac = new LongestPathWithDifferentAdjacentCharacters();

        System.out.println("3 == " + lpwdac.longestPath(new int[]{-1,0,0,1,1,2}, "abacbe"));
        System.out.println("3 == " + lpwdac.longestPath(new int[]{-1,0,0,0}, "aabc"));
        System.out.println("17 == " + lpwdac.longestPath(new int[]{-1,137,65,60,73,138,81,17,45,163,
                145,99,29,162,19,20,132,132,13,60,21,18,155,65,13,163,125,102,96,60,50,101,100,86,
                162,42,162,94,21,56,45,56,13,23,101,76,57,89,4,161,16,139,29,60,44,127,19,68,71,55,
                13,36,148,129,75,41,107,91,52,42,93,85,125,89,132,13,141,21,152,21,79,160,130,103,
                46,65,71,33,129,0,19,148,65,125,41,38,104,115,130,164,138,108,65,31,13,60,29,116,26,
                58,118,10,138,14,28,91,60,47,2,149,99,28,154,71,96,60,106,79,129,83,42,102,34,41,55,
                31,154,26,34,127,42,133,113,125,113,13,54,132,13,56,13,42,102,135,130,75,25,80,159,39,29,41,89,85,19},
            "ajunvefrdrpgxltugqqrwisyfwwtldxjgaxsbbkhvuqeoigqssefoyngykgtthpzvsxgxrqedntvsjcpdnupvqtroxmbpsdwoswxfarnixkvcimzgvrevxnxtkkovwxcjmtgqrrsqyshxbfxptuvqrytctujnzzydhpal"));
    }
}
