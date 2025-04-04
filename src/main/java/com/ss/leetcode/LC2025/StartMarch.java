package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.march.CountDaysWithoutMeetings;
import com.ss.leetcode.LC2025.march.FindMissingAndRepeatedValues;
import com.ss.leetcode.LC2025.march.HouseRobberIV;
import com.ss.leetcode.LC2025.march.MaximumCandiesAllocatedToKChildren;
import java.util.Arrays;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();

//        start.findMissingAndRepeatedValues();
//        start.maximumCandiesAllocatedToKChildren();
//        start.houseRobberIV();
        start.countDaysWithoutMeetings();
    }

    public void findMissingAndRepeatedValues() {
        FindMissingAndRepeatedValues fmarv = new FindMissingAndRepeatedValues();

        System.out.println("[2,4] == " + Arrays.toString(fmarv.findMissingAndRepeatedValues(new int[][]{{1,3},{2,2}})));
        System.out.println("[9,5] == " + Arrays.toString(fmarv.findMissingAndRepeatedValues(new int[][]{{9,1,7},{8,9,2},{3,4,6}})));
    }

    public void maximumCandiesAllocatedToKChildren() {
        MaximumCandiesAllocatedToKChildren mcatkc = new MaximumCandiesAllocatedToKChildren();

        System.out.println("2 = " + mcatkc.maximumCandies(new int[]{5,8,6}, 8));
        System.out.println("0 = " + mcatkc.maximumCandies(new int[]{2,5}, 11));
        System.out.println("16 = " + mcatkc.maximumCandies(new int[]{4,5,6,54,3,2,3,5,67,74,53,32,34}, 17));
        System.out.println("10 = " + mcatkc.maximumCandies(new int[]{4,5,6,54,3,2,3,5,67,74,53,32,34}, 27));
        System.out.println("2 = " + mcatkc.maximumCandies(new int[]{4,5,6,54,3,2,3,5,67,74,53,32,34}, 119));
        System.out.println("53 = " + mcatkc.maximumCandies(new int[]{4,5,6,54,3,2,3,5,67,74,53,32,34}, 4));
    }

    public void houseRobberIV() {
        HouseRobberIV hriv = new HouseRobberIV();

        System.out.println("5 == " + hriv.minCapability(new int[]{2,3,5,9}, 2));
        System.out.println("2 == " + hriv.minCapability(new int[]{2,7,9,3,1}, 2));
        System.out.println("5 == " + hriv.minCapability(new int[]{5,5,5}, 2));
        System.out.println("4 == " + hriv.minCapability(new int[]{4,6,7,5,6,7,9,2,3,4,5,6,1,2,3,4,5,7}, 4));
        System.out.println("7 == " + hriv.minCapability(new int[]{4,6,7,5,6,7,9,2,3,4,5,6,1,2,3,4,5,7}, 9));
        System.out.println("2 == " + hriv.minCapability(new int[]{4,6,7,5,6,7,9,2,3,4,5,6,1,2,3,4,5,7}, 2));
        System.out.println("1 == " + hriv.minCapability(new int[]{4,6,7,5,6,7,9,2,3,4,5,6,1,2,3,4,5,7}, 1));
    }

    public void countDaysWithoutMeetings() {
        CountDaysWithoutMeetings cdwm = new CountDaysWithoutMeetings();

        System.out.println("2 == " + cdwm.countDays(10, new int[][]{{5,7},{1,3},{9,10}}));
        System.out.println("1 == " + cdwm.countDays(5, new int[][]{{2,4},{1,3}}));
        System.out.println("0 == " + cdwm.countDays(6, new int[][]{{1,6}}));
        System.out.println("48 == " + cdwm.countDays(100, new int[][]{{1,6},{5,9},{13,19},{22,28},{14,18},{46,52},{52,57},{68,74},{76,82},{75,77},{99,100}}));
    }
}
