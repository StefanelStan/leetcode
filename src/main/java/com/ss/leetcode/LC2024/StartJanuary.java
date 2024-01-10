package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.january.AdvantageShuffle;
import com.ss.leetcode.LC2024.january.CountGoodMeals;
import com.ss.leetcode.LC2024.january.FurthestPointFromOrigin;
import com.ss.leetcode.LC2024.january.MinimumIndexOfAValidSplit;
import com.ss.leetcode.LC2024.january.MinimumNumberOfOperationsToMakeArrayEmpty;
import com.ss.leetcode.LC2024.january.MinimumPathCostInAGrid;
import com.ss.leetcode.LC2024.january.ReplaceElementsInAnArray;
import java.util.Arrays;
import java.util.List;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

//        start.replaceElementsInAnArray();
//        start.minimumNumberOfOperationsToMakeArrayEmpty();
//        start.advantageShuffle();
//        start.minimumIndexOfAValidSplit();
//        start.countGoodMeals();
//        start.furthestPointFromOrigin();
        start.minimumPathCostInAGrid();
    }

    public void replaceElementsInAnArray() {
        ReplaceElementsInAnArray reiaa = new ReplaceElementsInAnArray();

        System.out.println("[3,2,7,1] == " + Arrays.toString(reiaa.arrayChange(new int[]{1,2,4,6}, new int[][]{{1,3},{4,7},{6,1}})));
        System.out.println("[2,1] == " + Arrays.toString(reiaa.arrayChange(new int[]{1,2}, new int[][]{{1,3},{2,1},{3,2}})));
    }

    public void minimumNumberOfOperationsToMakeArrayEmpty() {
        MinimumNumberOfOperationsToMakeArrayEmpty mnootmae = new MinimumNumberOfOperationsToMakeArrayEmpty();

        System.out.println("4 == " + mnootmae.minOperations(new int[]{2,3,3,2,2,4,2,3,4}));
        System.out.println("-1 == " + mnootmae.minOperations(new int[]{2,1,2,2,3,3}));
    }

    public void advantageShuffle() {
        AdvantageShuffle as = new AdvantageShuffle();

        System.out.println("[2,11,7,15] == " + Arrays.toString(as.advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11})));
        System.out.println("[24,32,8,12] == " + Arrays.toString(as.advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11})));
    }

    public void minimumIndexOfAValidSplit() {
        MinimumIndexOfAValidSplit mioavs = new MinimumIndexOfAValidSplit();

        System.out.println("2 == " + mioavs.minimumIndex(List.of(1,2,2,2)));
        System.out.println("4 == " + mioavs.minimumIndex(List.of(2,1,3,1,1,1,7,1,2,1)));
        System.out.println("-1 == " + mioavs.minimumIndex(List.of(3,3,3,3,7,2,2)));
    }

    public void countGoodMeals() {
        CountGoodMeals cgm = new CountGoodMeals();

        System.out.println("4 == " + cgm.countPairs(new int[]{1,3,5,7,9}));
        System.out.println("15 == " + cgm.countPairs(new int[]{1,1,1,3,3,3,7}));
    }

    public void furthestPointFromOrigin() {
        FurthestPointFromOrigin fpfo = new FurthestPointFromOrigin();

        System.out.println("3 == " + fpfo.furthestDistanceFromOrigin("L_RL__R"));
        System.out.println("5 == " + fpfo.furthestDistanceFromOrigin("_R__LL_"));
        System.out.println("7 == " + fpfo.furthestDistanceFromOrigin("_______"));
    }

    public void minimumPathCostInAGrid() {
        MinimumPathCostInAGrid mpciag = new MinimumPathCostInAGrid();

        System.out.println("17 == " + mpciag.minPathCost(new int[][]{{5,3},{4,0},{2,1}}, new int[][]{{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}}));
        System.out.println("6 == " + mpciag.minPathCost(new int[][]{{5,1,2},{4,0,3}}, new int[][]{{12,10,15},{20,23,8},{21,7,1},{8,1,13},{9,10,25},{5,3,2}}));
    }
}
