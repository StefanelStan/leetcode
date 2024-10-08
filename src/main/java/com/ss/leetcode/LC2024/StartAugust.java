package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.august.ApplyDiscountToPrices;
import com.ss.leetcode.LC2024.august.ClearDigits;
import com.ss.leetcode.LC2024.august.ConstructStringWithMinimumCost;
import com.ss.leetcode.LC2024.august.CountNumberOfMaximumBitwiseORSubsets;
import com.ss.leetcode.LC2024.august.DistributeElementsIntoTwoArraysI;
import com.ss.leetcode.LC2024.august.FindKthSmallestPairDistance;
import com.ss.leetcode.LC2024.august.FindLongestSpecialSubstringThatOccursThriceI;
import com.ss.leetcode.LC2024.august.FindLongestSpecialSubstringThatOccursThriceII;
import com.ss.leetcode.LC2024.august.FindTheIntegerAddedToArrayI;
import com.ss.leetcode.LC2024.august.FindTheMinimumAreaToCoverAllOnesI;
import com.ss.leetcode.LC2024.august.FindThePeaks;
import com.ss.leetcode.LC2024.august.FindTheSumOfEncryptedIntegers;
import com.ss.leetcode.LC2024.august.FractionAdditionAndSubtraction;
import com.ss.leetcode.LC2024.august.GenerateBinaryStringsWithoutAdjacentZeros;
import com.ss.leetcode.LC2024.august.InsertGreatestCommonDivisorsInLinkedList;
import com.ss.leetcode.LC2024.august.IntegerToEnglishWords;
import com.ss.leetcode.LC2024.august.MaximumDistanceInArrays;
import com.ss.leetcode.LC2024.august.MaximumNumberOfPointsWithCost;
import com.ss.leetcode.LC2024.august.MinimumNumberOfDaysToDisconnectIsland;
import com.ss.leetcode.LC2024.august.OnlineElection;
import com.ss.leetcode.LC2024.august.PermutationDifferenceBetweenTwoStrings;
import com.ss.leetcode.LC2024.august.RegionsCutBySlashes;
import com.ss.leetcode.LC2024.august.SmallestMissingIntegerGreaterThanSequentialPrefixSum;
import com.ss.leetcode.LC2024.august.SpiralMatrixIII;
import com.ss.leetcode.shared.ListNode;
import java.util.Arrays;
import java.util.List;

public class StartAugust {
    public static void main(String[] args) {
        StartAugust start = new StartAugust();

//        start.findTheMinimumAreaToCoverAllOnesI();
//        start.distributeElementsIntoTwoArraysI();
//        start.clearDigits();
//        start.findTheSumOfEncryptedIntegers();
//        start.integerToEnglishWords();
//        start.spiralMatrixIII();
//        start.generateBinaryStringsWithoutAdjacentZeros();
//        start.regionsCutBySlashes();
//        start.countNumberOfMaximumBitwiseORSubsets();
//        start.minimumNumberOfDaysToDisconnectIsland();
//        start.findTheIntegerAddedToArrayI();
//        start.constructStringWithMinimumCost();
//        start.onlineElection();
//        start.findKthSmallestPairDistance();
//        start.maximumDistanceInArrays();
//        start.maximumNumberOfPointsWithCost();
//        start.smallestMissingIntegerGreaterThanSequentialPrefixSum();
//        start.findLongestSpecialSubstringThatOccursThriceII();
//        start.findLongestSpecialSubstringThatOccursThriceI();
//        start.applyDiscountToPrices();
//        start.fractionAdditionAndSubtraction();
//        start.findThePeaks();
//        start.insertGreatestCommonDivisorsInLinkedList();
        start.permutationDifferenceBetweenTwoStrings();
    }

    public void findTheMinimumAreaToCoverAllOnesI() {
        FindTheMinimumAreaToCoverAllOnesI ftmatcaoi = new FindTheMinimumAreaToCoverAllOnesI();

        System.out.println("6 == " + ftmatcaoi.minimumArea(new int[][]{{0,1,0}, {1,0,1}}));
        System.out.println("1 == " + ftmatcaoi.minimumArea(new int[][]{{1,0}, {0,0}}));
    }

    public void distributeElementsIntoTwoArraysI() {
        DistributeElementsIntoTwoArraysI deitai = new DistributeElementsIntoTwoArraysI();

        System.out.println("[2,3,1] == " + Arrays.toString(deitai.resultArray(new int[]{2,1,3})));
        System.out.println("[5,3,4,8] == " + Arrays.toString(deitai.resultArray(new int[]{5,4,3,8})));
    }

    public void clearDigits() {
        ClearDigits cd = new ClearDigits();

        System.out.println("abc == " + cd.clearDigits("abc"));
        System.out.println(" == " + cd.clearDigits("cb34"));
    }

    public void findTheSumOfEncryptedIntegers() {
        FindTheSumOfEncryptedIntegers ftsoei = new FindTheSumOfEncryptedIntegers();

        System.out.println("6 == " + ftsoei.sumOfEncryptedInt(new int[]{1,2,3}));
        System.out.println("66 == " + ftsoei.sumOfEncryptedInt(new int[]{10,21,33}));
    }

    public void integerToEnglishWords() {
        IntegerToEnglishWords itew = new IntegerToEnglishWords();

        System.out.println("One Hundred Twenty Three == " + itew.numberToWords(123));
        System.out.println("Twelve Thousand Three Hundred Forty Five == " + itew.numberToWords(12345));
        System.out.println("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven == " + itew.numberToWords(1234567));
        System.out.println("Two Billion One Hundred Twelve Million One Hundred Twenty Three Thousand Four Hundred Fifty Four == " + itew.numberToWords(2112123454));
        System.out.println("One Billion One == " + itew.numberToWords(1000000001));
        System.out.println("One Billion One Million One Thousand One == " + itew.numberToWords(1001001001));
        System.out.println("One Hundred Nine == " + itew.numberToWords(109));
    }

    public void spiralMatrixIII() {
        SpiralMatrixIII smiii = new SpiralMatrixIII();

        System.out.println("[[0,0],[0,1],[0,2],[0,3]] == " + Arrays.deepToString(smiii.spiralMatrixIII(1,4,0,0)));
        System.out.println("[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]] == " + Arrays.deepToString(smiii.spiralMatrixIII(5,6,1,4)));
    }

    public void generateBinaryStringsWithoutAdjacentZeros() {
        GenerateBinaryStringsWithoutAdjacentZeros gbswaz = new GenerateBinaryStringsWithoutAdjacentZeros();

        System.out.println("[010,011,101,110,111] == " + gbswaz.validStrings(3));
        System.out.println("[0,1] == " + gbswaz.validStrings(1));
    }

    public void regionsCutBySlashes() {
        RegionsCutBySlashes rcbs = new RegionsCutBySlashes();

        System.out.println("2 == " + rcbs.regionsBySlashes(new String[]{" /","/ "}));
        System.out.println("1 == " + rcbs.regionsBySlashes(new String[]{" /","  "}));
        System.out.println("5 == " + rcbs.regionsBySlashes(new String[]{"/\\","\\/"}));
        System.out.println("12 == " + rcbs.regionsBySlashes(new String[]{"/\\/\\", "\\/\\/", "/\\/\\", "\\/\\\\"}));
        System.out.println("1 == " + rcbs.regionsBySlashes(new String[]{"   ", "   ", "   "}));
        System.out.println("4 == " + rcbs.regionsBySlashes(new String[]{" /\\"," \\/","\\  "}));
    }

    public void countNumberOfMaximumBitwiseORSubsets() {
        CountNumberOfMaximumBitwiseORSubsets cnombos = new CountNumberOfMaximumBitwiseORSubsets();
        System.out.println("2 == " + cnombos.countMaxOrSubsets(new int[]{3, 1}));
        System.out.println("7 == " + cnombos.countMaxOrSubsets(new int[]{2,2,2}));
        System.out.println("6 == " + cnombos.countMaxOrSubsets(new int[]{3,2,1,5}));
        System.out.println("65535 == " + cnombos.countMaxOrSubsets(new int[]{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}));
        System.out.println("65535 == " + cnombos.countMaxOrSubsets(new int[]{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}));
    }

    public void minimumNumberOfDaysToDisconnectIsland() {
        MinimumNumberOfDaysToDisconnectIsland mnodtdi = new MinimumNumberOfDaysToDisconnectIsland();

        System.out.println("2 == " + mnodtdi.minDays(new int[][]{{0,1,1,0},{0,1,1,0},{0,0,0,0}}));
        System.out.println("1 == " + mnodtdi.minDays(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println("2 == " + mnodtdi.minDays(new int[][]{{1,1,1},{1,1,1},{1,1,1}}));
        System.out.println("0 == " + mnodtdi.minDays(new int[][]{{0,1},{1,0}}));
        System.out.println("0 == " + mnodtdi.minDays(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
        System.out.println("2 == " + mnodtdi.minDays(new int[][]{{1,1,0,1,1},{1,1,1,1,1},{1,1,0,1,1},{1,1,1,1,1}}));
        System.out.println("1 == " + mnodtdi.minDays(new int[][]{{0,0,1,1,1,1,0,1},{1,1,1,1,0,1,1,1},{0,1,1,1,0,0,1,1},{1,1,0,1,1,1,1,1},{1,1,1,1,1,0,0,0}}));
        System.out.println("1 == " + mnodtdi.minDays(new int[][]{{0,1,1},{1,1,1},{1,1,0}}));
    }

    public void findTheIntegerAddedToArrayI() {
        FindTheIntegerAddedToArrayI ftiatai = new FindTheIntegerAddedToArrayI();

        System.out.println("3 == " + ftiatai.addedInteger(new int[]{2,6,4}, new int[]{9,7,5}));
        System.out.println("-5 == " + ftiatai.addedInteger(new int[]{10}, new int[]{5}));
        System.out.println("0 == " + ftiatai.addedInteger(new int[]{1,1,1,1}, new int[]{1,1,1,1}));
    }

    public void constructStringWithMinimumCost() {
        ConstructStringWithMinimumCost cswmc = new ConstructStringWithMinimumCost();

        System.out.println("7 == " + cswmc.minimumCost("abcdef", new String[]{"abdef","abc","d","def","ef"}, new int[]{100,1,1,10,5}));
        System.out.println("-1 == " + cswmc.minimumCost("aaaa", new String[]{"z","zz","zzz"}, new int[]{1,10,100}));
        System.out.println("16 == " + cswmc.minimumCost("sgsipzma", new String[]{"s","s","g","ipzma"}, new int[]{3,3,3,7}));
        System.out.println("1 == " + cswmc.minimumCost("r", new String[]{"r","r","r","r"}, new int[]{1,6,3,3}));
    }

    public void onlineElection() {
        OnlineElection oe = new OnlineElection(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});

        System.out.println("0 == " + oe.q(3));
        System.out.println("1 == " + oe.q(12));
        System.out.println("1 == " + oe.q(25));
        System.out.println("0 == " + oe.q(15));
        System.out.println("0 == " + oe.q(24));
        System.out.println("1 == " + oe.q(8));
    }

    public void findKthSmallestPairDistance(){
        FindKthSmallestPairDistance fkspd = new FindKthSmallestPairDistance();

        System.out.println("0 == " + fkspd.smallestDistancePair(new int[]{1,3,1}, 1));
        System.out.println("0 == " + fkspd.smallestDistancePair(new int[]{1,1,1}, 2));
        System.out.println("5 == " + fkspd.smallestDistancePair(new int[]{1,6,1}, 3));
    }

    public void maximumDistanceInArrays() {
        MaximumDistanceInArrays mdia = new MaximumDistanceInArrays();

        System.out.println("4 == " + mdia.maxDistance(List.of(List.of(1,2,3),List.of(4,5), List.of(1,2,3))));
        System.out.println("0 == " + mdia.maxDistance(List.of(List.of(1), List.of(1))));
        System.out.println("4 == " + mdia.maxDistance(List.of(List.of(1,4), List.of(0,5))));
    }

    public void maximumNumberOfPointsWithCost() {
        MaximumNumberOfPointsWithCost mnopwc = new MaximumNumberOfPointsWithCost();

        System.out.println("9 == " + mnopwc.maxPoints(new int[][]{{1,2,3},{1,5,1},{3,1,1}}));
        System.out.println("11 == " + mnopwc.maxPoints(new int[][]{{1,5},{2,3},{4,2}}));
    }

    public void smallestMissingIntegerGreaterThanSequentialPrefixSum() {
        SmallestMissingIntegerGreaterThanSequentialPrefixSum smigtsps = new SmallestMissingIntegerGreaterThanSequentialPrefixSum();

        System.out.println("6 == " + smigtsps.missingInteger(new int[]{1,2,3,2,5}));
        System.out.println("15 == " + smigtsps.missingInteger(new int[]{3,4,5,1,12,14,13}));
        System.out.println("297 == " + smigtsps.missingInteger(new int[]{29,30,31,32,33,34,35,36,37}));
        System.out.println("47 == " + smigtsps.missingInteger(new int[]{46,8,2,4,1,4,10,2,4,10,2,5,7,3,1}));
        System.out.println("38 == " + smigtsps.missingInteger(new int[]{37,1,2,9,5,8,5,2,9,4}));
    }

    public void findLongestSpecialSubstringThatOccursThriceII() {
        FindLongestSpecialSubstringThatOccursThriceII flsstotii = new FindLongestSpecialSubstringThatOccursThriceII();

        System.out.println("-1 == " + flsstotii.maximumLength("abcdefghijaoipp"));
        System.out.println("1 == " + flsstotii.maximumLength("abcdefjkhgffrsrgtyuikjhgfdtrdyujhgfdrtyuilkjhmgfyjuikjhgfdseaw"));
        System.out.println("1 == " + flsstotii.maximumLength("abpoiuytrtyujkjhgfgnbvcsertyujhgfdcfghygtfdcasdfghgewaertyuikjhgfdba"));
        System.out.println("2 == " + flsstotii.maximumLength("aaabcaaufjdskfsaa"));
        System.out.println("16 == " + flsstotii.maximumLength("aaaaaaaaaaaaaaaaaa"));
        System.out.println("1 == " + flsstotii.maximumLength("kfsjdfsdhfsiufhsufhufhufhdhfuhdufhfhhuhuxhcssdhdhshsudsdojsdsjdjsdjsdjjddfosfofmdscndsfussduyhfisufhniufhncusashvbusfbshdjbvhdskjbfnusbdkfwbefiuefncjuhvneia"));
        System.out.println("1 == " + flsstotii.maximumLength("safsdfdsfkdoirjfeiurvnbeuribvnecwiuhneoiuhnsiu"));
        System.out.println("5 == " + flsstotii.maximumLength("abbbbbggggggyyyggggg"));
    }

    public void findLongestSpecialSubstringThatOccursThriceI() {
        FindLongestSpecialSubstringThatOccursThriceI flsstoti = new FindLongestSpecialSubstringThatOccursThriceI();

        System.out.println("-1 == " + flsstoti.maximumLength("abcdefghijaoipp"));
        System.out.println("1 == " + flsstoti.maximumLength("abcdefjkhgffrsrgtyuikjhgfdtrdyujhgfdrtyuilkjhmgfyjuikjhgfdseaw"));
        System.out.println("1 == " + flsstoti.maximumLength("abpoiuytrtyujkjhgfgnbvcsertyujhgfdcfghygtfdcasdfghgewaertyuikjhgfdba"));
        System.out.println("2 == " + flsstoti.maximumLength("aaabcaaufjdskfsaa"));
        System.out.println("16 == " + flsstoti.maximumLength("aaaaaaaaaaaaaaaaaa"));
        System.out.println("1 == " + flsstoti.maximumLength("kfsjdfsdhfsiufhsufhufhufhdhfuhdufhfhhuhuxhcssdhdhshsudsdojsdsjdjsdjsdjjddfosfofmdscndsfussduyhfisufhniufhncusashvbusfbshdjbvhdskjbfnusbdkfwbefiuefncjuhvneia"));
        System.out.println("1 == " + flsstoti.maximumLength("safsdfdsfkdoirjfeiurvnbeuribvnecwiuhneoiuhnsiu"));
        System.out.println("5 == " + flsstoti.maximumLength("abbbbbggggggyyyggggg"));
    }

    public void applyDiscountToPrices() {
        ApplyDiscountToPrices adtp = new ApplyDiscountToPrices();

        System.out.println("there are $0.50 $1.00 and 5$ candies in the shop == " + adtp.discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
        System.out.println("1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$ == " + adtp.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
    }

    public void fractionAdditionAndSubtraction() {
        FractionAdditionAndSubtraction faas = new FractionAdditionAndSubtraction();

        System.out.println("0/1 == " + faas.fractionAddition("-1/2+1/2"));
        System.out.println("1/3 == " + faas.fractionAddition("-1/2+1/2+1/3"));
        System.out.println("-1/6 == " + faas.fractionAddition("1/3-1/2"));
        System.out.println("68/15 == " + faas.fractionAddition("7/3+5/2-3/10"));
    }

    public void findThePeaks() {
        FindThePeaks ftp = new FindThePeaks();

        System.out.println("[] == " + ftp.findPeaks(new int[]{2,4,4}));
        System.out.println("[1,3] == " + ftp.findPeaks(new int[]{1,4,3,8,5}));
        System.out.println("[] == " + ftp.findPeaks(new int[]{1,2,3}));
        System.out.println("[1,3,5,7,11,13,15,17,19,24,30,41] == " + ftp.findPeaks(new int[]{1,2,1,2,1,2,1,2,1,1,1,2,1,2,1,2,1,2,1,2,1,3,4,4,5,4,3,4,5,7,8,7,7,6,5,4,3,3,4,5,6,7,6,5,4,3,2}));
    }

    public void insertGreatestCommonDivisorsInLinkedList() {
        InsertGreatestCommonDivisorsInLinkedList igcdill = new InsertGreatestCommonDivisorsInLinkedList();

        System.out.println("[18,6,6,2,10,1,3] == " + igcdill.insertGreatestCommonDivisors(ListNode.makeChain(new int[]{18,6,10,3})).getAsList());
        System.out.println("[7] == " + igcdill.insertGreatestCommonDivisors(ListNode.makeChain(new int[]{7})).getAsList());
    }

    public void permutationDifferenceBetweenTwoStrings() {
        PermutationDifferenceBetweenTwoStrings pdbts = new PermutationDifferenceBetweenTwoStrings();

        System.out.println("2 == " + pdbts.findPermutationDifference("abc", "bac"));
        System.out.println("12 == " + pdbts.findPermutationDifference("abcde", "edbac"));
    }
}
