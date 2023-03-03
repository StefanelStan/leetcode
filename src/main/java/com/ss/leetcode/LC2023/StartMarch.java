package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.march.MaxDifferenceYouCanGetFromChangingAnInteger;
import com.ss.leetcode.LC2023.march.MinimumAmountOfTimeToFillCups;
import com.ss.leetcode.LC2023.march.MinimumFlipsToMakeAORBEqualToC;
import com.ss.leetcode.LC2023.march.MinimumNumberOfDaysToMakeMBouquets;
import com.ss.leetcode.LC2023.march.MinimumOperationsToMakeArrayEqualII;
import com.ss.leetcode.LC2023.march.PartitionStringIntoSubstringsWithValuesAtMostK;
import com.ss.leetcode.LC2023.march.SmallestNumberInInfiniteSet;
import com.ss.leetcode.LC2023.march.SortAnArray;
import java.util.Arrays;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();

//        start.sortAnArray();
//        start.maxDifferenceYouCanGetFromChangingAnInteger();
//        start.minimumFlipsToMakeAORBEqualToC();
//        start.minimumNumberOfDaysToMakeMBouquets();
//        start.partitionStringIntoSubstringsWithValuesAtMostK();
//        start.minimumOperationsToMakeArrayEqualII();
//        start.minimumAmountOfTimeToFillCups();
        start.smallestNumberInInfiniteSet();
    }

    public void sortAnArray() {
        SortAnArray saa = new SortAnArray();

        System.out.println("[1,2,3,5] == " + Arrays.toString(saa.sortArray(new int[]{5,2,3,1})));
        System.out.println("[0,0,1,1,2,5] == " + Arrays.toString(saa.sortArray(new int[]{5,1,1,2,0,0})));
    }

    public void maxDifferenceYouCanGetFromChangingAnInteger() {
        MaxDifferenceYouCanGetFromChangingAnInteger mdycgfcai = new MaxDifferenceYouCanGetFromChangingAnInteger();

        System.out.println("888 == " + mdycgfcai.maxDiff(555));
        System.out.println("8 == " + mdycgfcai.maxDiff(9));
    }

    public void minimumFlipsToMakeAORBEqualToC() {
        MinimumFlipsToMakeAORBEqualToC mftmaobetc = new MinimumFlipsToMakeAORBEqualToC();

        System.out.println("3 == " + mftmaobetc.minFlips(2,6,5));
        System.out.println("1 == " + mftmaobetc.minFlips(4,2,7));
        System.out.println("0 == " + mftmaobetc.minFlips(1,2,3));
    }

    public void minimumNumberOfDaysToMakeMBouquets() {
        MinimumNumberOfDaysToMakeMBouquets mnodtmmb = new MinimumNumberOfDaysToMakeMBouquets();

        System.out.println("3 == " + mnodtmmb.minDays(new int[]{1,10,3,10,2}, 3, 1));
        System.out.println("-1 == " + mnodtmmb.minDays(new int[]{1,10,3,10,2}, 3, 2));
        System.out.println("12 == " + mnodtmmb.minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));
    }

    public void partitionStringIntoSubstringsWithValuesAtMostK() {
        PartitionStringIntoSubstringsWithValuesAtMostK psiswvamk = new PartitionStringIntoSubstringsWithValuesAtMostK();
        System.out.println("4 == " + psiswvamk.minimumPartition("165462", 60));
        System.out.println("-1 == " + psiswvamk.minimumPartition("238182", 5));
        System.out.println("9 == " + psiswvamk.minimumPartition("26157345257163988868117846274721761212579599849281498323426933956822333959", 784955370));
    }

    public void minimumOperationsToMakeArrayEqualII() {
        MinimumOperationsToMakeArrayEqualII motmaeii = new MinimumOperationsToMakeArrayEqualII();

        System.out.println("2 == " + motmaeii.minOperations(new int[]{4,3,1,4}, new int[]{1,3,7,1}, 3));
        System.out.println("2 == " + motmaeii.minOperations(new int[]{3,8,5,2}, new int[]{2,4,1,6}, 1));
        System.out.println("-1 == " + motmaeii.minOperations(new int[]{4,3,1,4}, new int[]{1,3,7,1}, 0));
        System.out.println("0 == " + motmaeii.minOperations(new int[]{1,3,7,1}, new int[]{1,3,7,1}, 0));
        System.out.println("-1 == " + motmaeii.minOperations(new int[]{5,2,11,4,9}, new int[]{1,2,3,4,5}, 4));
        System.out.println("2 == " + motmaeii.minOperations(new int[]{5,2,5,4,9}, new int[]{1,2,13,4,5}, 4));
    }

    public void minimumAmountOfTimeToFillCups() {
        MinimumAmountOfTimeToFillCups maoftfc = new MinimumAmountOfTimeToFillCups();

        System.out.println("4 == " + maoftfc.fillCups(new int[]{1,4,2}));
        System.out.println("7 == " + maoftfc.fillCups(new int[]{5,4,4}));
        System.out.println("5 == " + maoftfc.fillCups(new int[]{5,0,0}));
    }

    public void smallestNumberInInfiniteSet() {
        SmallestNumberInInfiniteSet sniis = new SmallestNumberInInfiniteSet();

        sniis.addBack(2);
        System.out.println("1 == " + sniis.popSmallest());
        System.out.println("2 == " + sniis.popSmallest());
        System.out.println("3 == " + sniis.popSmallest());
        sniis.addBack(1);
        System.out.println("1 == " + sniis.popSmallest());
        System.out.println("4 == " + sniis.popSmallest());
        System.out.println("5 == " + sniis.popSmallest());
    }
}