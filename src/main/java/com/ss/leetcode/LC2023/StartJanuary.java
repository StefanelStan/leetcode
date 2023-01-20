package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.january.CountTheDigitsThatDivideANumber;
import com.ss.leetcode.LC2023.january.DifferenceBetweenElementSumAndDigitSumOfAnArray;
import com.ss.leetcode.LC2023.january.FlipStringToMonotoneIncreasing;
import com.ss.leetcode.LC2023.january.LexicographicallySmallestEquivalentString;
import com.ss.leetcode.LC2023.january.LongestPathWithDifferentAdjacentCharacters;
import com.ss.leetcode.LC2023.january.MaximumCountOfPositiveIntegerAndNegativeInteger;
import com.ss.leetcode.LC2023.january.MaximumSumCircularSubarray;
import com.ss.leetcode.LC2023.january.MinimumNumberOfArrowsToBurstBalloons;
import com.ss.leetcode.LC2023.january.MinimumRoundsToCompleteAllTasks;
import com.ss.leetcode.LC2023.january.MostFrequentEvenElement;
import com.ss.leetcode.LC2023.january.NumberOfNodesInTheSubTreeWithTheSameLabel;
import com.ss.leetcode.LC2023.january.RearrangeCharactersToMakeTargetString;
import com.ss.leetcode.LC2023.january.SubarraySumsDivisibleByK;
import java.util.Arrays;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

//        start.minimumRoundsToCompleteAllTasks();
//        start.minimumNumberOfArrowsToBurstBalloons();
//        start.rearrangeCharactersToMakeTargetString();
//        start.mostFrequentEvenElement();
//        start.numberOfNodesInTheSubTreeWithTheSameLabel();
//        start.longestPathWithDifferentAdjacentCharacters();
//        start.lexicographicallySmallestEquivalentString();
//        start.flipStringToMonotoneIncreasing();
//        start.maximumSumCircularSubarray();
//        start.subarraySumsDivisibleByK();
//        start.differenceBetweenElementSumAndDigitSumOfAnArray();
//        start.maximumCountOfPositiveIntegerAndNegativeInteger();
        start.countTheDigitsThatDivideANumber();
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

    public void lexicographicallySmallestEquivalentString() {
        LexicographicallySmallestEquivalentString lses = new LexicographicallySmallestEquivalentString();

        System.out.println("makkek == " + lses.smallestEquivalentString("parker", "morris", "parser"));
        System.out.println("hdld == " + lses.smallestEquivalentString("hello", "world", "hold"));
        System.out.println("hdld == " + lses.smallestEquivalentString("leetcode", "programs", "sourcecode"));
        System.out.println("sanaazzwalakarauaannakpzaqjmjmaokraauqaayalpsapzao == " + lses.smallestEquivalentString("dccaccbdafgeabeeghbigbhicggfbhiccfgbechdicbhdcgahi", "igfcigeciahdafgegfbeddhgbacaeehcdiehiifgbhhehhccde", "sanfbzzwblekirguignnfkpzgqjmjmfokrdfuqbgyflpsfpzbo"));
        System.out.println("aqppaaaaaaaaannaaaztqoqapaayzaaqasyaawyaaaoaaaruay == " + lses.smallestEquivalentString("gicimlheddadmbmhiimakmhgklliljllfgjegamichefljcdef", "jgjbjkhkliegkfdcbfcdgmeadlkgcdfkcjdmmcgliegijgjimj", "lqppdcmgachdannbaeztqoqfpimyzcdqksykgwymceogkgruey"));
        System.out.println("ttusuaaraaasswaaaaxaxaaaaayaaaaaatwwaaaaaataaaaaru == " + lses.smallestEquivalentString("opecenadojbodihfgmpijpfocomhcncicefpohkibjckijghii", "ndlbhpaeppgekfhnjnmmplmdoifdhbglmedpjgleofgnahglbe", "ttusuhhrabgsswpaapxoxdanchyccmpjitwwmfioedtbiggfru"));
    }

    public void flipStringToMonotoneIncreasing() {
        FlipStringToMonotoneIncreasing fstmi = new FlipStringToMonotoneIncreasing();

        System.out.println("1 == " + fstmi.minFlipsMonoIncr("00110"));
        System.out.println("2 == " + fstmi.minFlipsMonoIncr("010110"));
        System.out.println("2 == " + fstmi.minFlipsMonoIncr("00011000"));
        System.out.println("0 == " + fstmi.minFlipsMonoIncr("11"));
        System.out.println("0 == " + fstmi.minFlipsMonoIncr("01"));
        System.out.println("0 == " + fstmi.minFlipsMonoIncr("0"));
        System.out.println("3 == " + fstmi.minFlipsMonoIncr("0101100011"));
    }

    public void maximumSumCircularSubarray() {
        MaximumSumCircularSubarray mscs = new MaximumSumCircularSubarray();

        System.out.println("3 == " + mscs.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println("10 == " + mscs.maxSubarraySumCircular(new int[]{5,-3,5}));
        System.out.println("-2 == " + mscs.maxSubarraySumCircular(new int[]{-3,-2,-3}));
        System.out.println("16 == " + mscs.maxSubarraySumCircular(new int[]{4,5,0,-2,6,3,2,3,4,5,6,7,8,9,7,6,5,4,3,2,1,2,3,4,5,6,7,8,7,67,5,54,54,4,4,3,4,4,3,32,2,23,4,5,6,4,-8,5,-4,5,65,67,78,-4,-6,-8,3,2,-23,-3,-17,-3,1}));
        System.out.println("17 == " + mscs.maxSubarraySumCircular(new int[]{5,-3,-2,-3,0,1,2,3,4,0,-5,4,3,-4,-3,-10,-13,7,5}));
        System.out.println("3 == " + mscs.maxSubarraySumCircular(new int[]{3,-2,-3}));
    }

    public void subarraySumsDivisibleByK() {
        SubarraySumsDivisibleByK ssdbk = new SubarraySumsDivisibleByK();

        System.out.println("7 == " + ssdbk.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 7));
        System.out.println("0 == " + ssdbk.subarraysDivByK(new int[]{5}, 9));
    }

    public void differenceBetweenElementSumAndDigitSumOfAnArray() {
        DifferenceBetweenElementSumAndDigitSumOfAnArray dbesadsoaa = new DifferenceBetweenElementSumAndDigitSumOfAnArray();

        System.out.println("9 == " + dbesadsoaa.differenceOfSum(new int[]{1,15,6,3}));
        System.out.println("0 == " + dbesadsoaa.differenceOfSum(new int[]{1,2,3,4}));
        System.out.println("0 == " + dbesadsoaa.differenceOfSum(new int[]{5}));
        System.out.println("3402 == " + dbesadsoaa.differenceOfSum(new int[]{10,15,6,3,6,5,3,2,4,5,6,7,1,2,3,4,5,6,700,8,9,8,7,6,5,4,3,2000,1,5,6,700}));
    }

    public void maximumCountOfPositiveIntegerAndNegativeInteger() {
        MaximumCountOfPositiveIntegerAndNegativeInteger mcopiani = new MaximumCountOfPositiveIntegerAndNegativeInteger();

        System.out.println("3 == " + mcopiani.maximumCount(new int[]{-2,-1,-1,1,2,3}));
        System.out.println("3 == " + mcopiani.maximumCount(new int[]{-3,-2,-1,0,0,1,2}));
        System.out.println("4 == " + mcopiani.maximumCount(new int[]{5,20,66,1314}));
        System.out.println("4 == " + mcopiani.maximumCount(new int[]{5,20,66,1314}));
        System.out.println("4 == " + mcopiani.maximumCount(new int[]{-2,-2,-2,-1,0,0,0,0,0,0}));
        System.out.println("3 == " + mcopiani.maximumCount(new int[]{0,1,2,3}));
    }

    public void countTheDigitsThatDivideANumber() {
        CountTheDigitsThatDivideANumber ctdtdan = new CountTheDigitsThatDivideANumber();

        System.out.println("1 == " + ctdtdan.countDigits(7));
        System.out.println("2 == " + ctdtdan.countDigits(121));
        System.out.println("4 == " + ctdtdan.countDigits(1248));
        System.out.println("4 == " + ctdtdan.countDigits(1248));
        System.out.println("1 == " + ctdtdan.countDigits(534534521));
        System.out.println("4 == " + ctdtdan.countDigits(222221111));
    }
}
