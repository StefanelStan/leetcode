package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.august.ClearDigits;
import com.ss.leetcode.LC2024.august.ConstructStringWithMinimumCost;
import com.ss.leetcode.LC2024.august.CountNumberOfMaximumBitwiseORSubsets;
import com.ss.leetcode.LC2024.august.DistributeElementsIntoTwoArraysI;
import com.ss.leetcode.LC2024.august.FindKthSmallestPairDistance;
import com.ss.leetcode.LC2024.august.FindTheIntegerAddedToArrayI;
import com.ss.leetcode.LC2024.august.FindTheMinimumAreaToCoverAllOnesI;
import com.ss.leetcode.LC2024.august.FindTheSumOfEncryptedIntegers;
import com.ss.leetcode.LC2024.august.GenerateBinaryStringsWithoutAdjacentZeros;
import com.ss.leetcode.LC2024.august.IntegerToEnglishWords;
import com.ss.leetcode.LC2024.august.MaximumDistanceInArrays;
import com.ss.leetcode.LC2024.august.MaximumNumberOfPointsWithCost;
import com.ss.leetcode.LC2024.august.MinimumNumberOfDaysToDisconnectIsland;
import com.ss.leetcode.LC2024.august.OnlineElection;
import com.ss.leetcode.LC2024.august.RegionsCutBySlashes;
import com.ss.leetcode.LC2024.august.SpiralMatrixIII;
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
        start.maximumNumberOfPointsWithCost();
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
}
