package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.may.MaximumNumberOfGroupsEnteringACompetition;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();

        start.maximumNumberOfGroupsEnteringACompetition();
    }

    public void maximumNumberOfGroupsEnteringACompetition() {
        MaximumNumberOfGroupsEnteringACompetition mnogeac = new MaximumNumberOfGroupsEnteringACompetition();

        System.out.println("3 == " + mnogeac.maximumGroups(new int[]{10,6,12,7,3,5}));
        System.out.println("1 == " + mnogeac.maximumGroups(new int[]{8,8}));
        System.out.println("8 == " + mnogeac.maximumGroups(new int[]{4,3,2,3,43,5,56,76,78,8,7,6,56,5,34,23,34,4,5,6,7,88,7,6,5,45,3,3,76,4,5,6,7,8,87,7,6,5,4,3,4,5,6}));
        System.out.println("3 == " + mnogeac.maximumGroups(new int[]{1,1,1,1,1,1,1,1,1}));
        System.out.println("6 == " + mnogeac.maximumGroups(new int[]{1,6,5,4,3,2,3,4,5,4,3,1,2,3,4,2,100,1000,10000,20000,30000}));
        System.out.println("1 == " + mnogeac.maximumGroups(new int[]{1}));
        System.out.println("1 == " + mnogeac.maximumGroups(new int[]{7}));
    }
}
