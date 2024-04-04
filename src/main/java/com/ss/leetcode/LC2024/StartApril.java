package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.april.GroupsOfStrings;
import com.ss.leetcode.LC2024.april.MaximumMatchingOfPlayersWithTrainers;

public class StartApril {
    public static void main(String[] args) {
        StartApril start = new StartApril();

//        start.maximumMatchingOfPlayersWithTrainers();
        start.groupsOfStrings();
    }

    public void maximumMatchingOfPlayersWithTrainers() {
        MaximumMatchingOfPlayersWithTrainers mmopwt = new MaximumMatchingOfPlayersWithTrainers();

        System.out.println("2 == " +  mmopwt.matchPlayersAndTrainers(new int[]{4,7,9}, new int[]{8,2,5,8}));
        System.out.println("1 == " +  mmopwt.matchPlayersAndTrainers(new int[]{1,1,1}, new int[]{10}));
        System.out.println("12 == " +  mmopwt.matchPlayersAndTrainers(new int[]{4,3,2,3,4,5,6,7,6,5,4,54,6,76}, new int[]{2,3,4,5,6,5,45,3,4,4,5,6,7,8,9}));
        System.out.println("0 == " +  mmopwt.matchPlayersAndTrainers(new int[]{7}, new int[]{5}));
        System.out.println("16 == " +  mmopwt.matchPlayersAndTrainers(new int[]{6,7,8,7,6,5,6,7,8,9,8,8,76,6,5,4}, new int[]{5,4,5,6,7,6,5,4,1,3,32,2,1,2,3,4,5,65,6,76,8,9,9,8,7,5,5,34}));
    }

    public void groupsOfStrings() {
        GroupsOfStrings gos = new GroupsOfStrings();

        System.out.println("[2,3] == " + gos.groupStrings(new String[]{"a","b","ab","cde"}));
        System.out.println("[1,3] == " + gos.groupStrings(new String[]{"a","ab","abc"}));
    }
}
