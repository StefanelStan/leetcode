package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.january.CoordinateWithMaximumNetworkQuality;
import com.ss.leetcode.LC2025.january.FindTheLexicographicallyLargestStringFromTheBoxI;
import com.ss.leetcode.LC2025.january.FlowerPlantingWithNoAdjacent;
import com.ss.leetcode.LC2025.january.MaximumTotalRewardUsingOperationsI;
import java.util.Arrays;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

//        start.findTheLexicographicallyLargestStringFromTheBoxI();
//        start.maximumTotalRewardUsingOperationsI();
//        start.flowerPlantingWithNoAdjacent();
        start.coordinateWithMaximumNetworkQuality();
    }

    public void findTheLexicographicallyLargestStringFromTheBoxI() {
        FindTheLexicographicallyLargestStringFromTheBoxI ftllsftbi = new FindTheLexicographicallyLargestStringFromTheBoxI();

        System.out.println("dbc == " + ftllsftbi.answerString("dbca", 2));
        System.out.println("g == " + ftllsftbi.answerString("gggg", 4));
    }

    public void maximumTotalRewardUsingOperationsI() {
        MaximumTotalRewardUsingOperationsI mtruoi = new MaximumTotalRewardUsingOperationsI();

        System.out.println("4 == " + mtruoi.maxTotalReward(new int[]{1,1,3,3}));
        System.out.println("11 == " + mtruoi.maxTotalReward(new int[]{1,6,4,3,2}));
        System.out.println("17 == " + mtruoi.maxTotalReward(new int[]{5,6,7,8,4,3,2,1,2,3,4,5,6,7,8,9,8,7,6,5,4,2}));
        System.out.println("3996 == " + mtruoi.maxTotalReward(new int[]{453,129, 2000, 2000, 2000, 1872, 134, 231,654,235,123,876,345,765,678,234,216,1}));
        System.out.println("7 == " + mtruoi.maxTotalReward(new int[]{7}));
        System.out.println("7 == " + mtruoi.maxTotalReward(new int[]{7,7,7}));
    }

    public void flowerPlantingWithNoAdjacent() {
        FlowerPlantingWithNoAdjacent flwna = new FlowerPlantingWithNoAdjacent();

        System.out.println("[1,2,3] == " + Arrays.toString(flwna.gardenNoAdj(3, new int[][]{{1,2},{2,3},{3,1}})));
        System.out.println("[1,2,1,2] == " + Arrays.toString(flwna.gardenNoAdj(4, new int[][]{{1,2},{4,3}})));
        System.out.println("[1,2,3,4] == " + Arrays.toString(flwna.gardenNoAdj(4, new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}})));
        System.out.println("[1,2,1,1,2,2,3] == " + Arrays.toString(flwna.gardenNoAdj(7, new int[][]{{1,5},{2,1},{1,6},{2,4},{3,2},{4,7},{6,7}})));
    }

    public void coordinateWithMaximumNetworkQuality() {
        CoordinateWithMaximumNetworkQuality cwmnq = new CoordinateWithMaximumNetworkQuality();

        System.out.println("[2,1] == " + Arrays.toString(cwmnq.bestCoordinate(new int[][]{{1,2,5},{2,1,7},{3,1,9}}, 2)));
        System.out.println("[23,11] == " + Arrays.toString(cwmnq.bestCoordinate(new int[][]{{23,11,21}}, 9)));
        System.out.println("[1,2] == " + Arrays.toString(cwmnq.bestCoordinate(new int[][]{{1,2,13},{2,1,7},{0,1,9}}, 2)));
        System.out.println("[2,5] == " + Arrays.toString(cwmnq.bestCoordinate(new int[][]{{2,5,10},{10,5,10}}, 5)));
        System.out.println("[1,6] == " + Arrays.toString(cwmnq.bestCoordinate(new int[][]{{30,34,31},{10,44,24},{14,28,23},{50,38,1},{40,13,6},{16,27,9},{2,22,23},{1,6,41},{34,22,40},{40,10,11}},20)));
        System.out.println("[1,6] == " + Arrays.toString(cwmnq.bestCoordinate(new int[][]{{30,34,31},{10,44,24},{16,27,9},{2,22,23},{1,6,41},{34,22,40},{40,10,11}},20)));
    }
}
