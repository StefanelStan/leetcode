package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.march.MaxDifferenceYouCanGetFromChangingAnInteger;
import com.ss.leetcode.LC2023.march.MinimumFlipsToMakeAORBEqualToC;
import com.ss.leetcode.LC2023.march.MinimumNumberOfDaysToMakeMBouquets;
import com.ss.leetcode.LC2023.march.SortAnArray;
import java.util.Arrays;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();

//        start.sortAnArray();
//        start.maxDifferenceYouCanGetFromChangingAnInteger();
//        start.minimumFlipsToMakeAORBEqualToC();
        start.minimumNumberOfDaysToMakeMBouquets();
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
}
