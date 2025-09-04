package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.september.FindClosestPerson;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

        start.findClosestPerson();
    }

    public void findClosestPerson() {
        FindClosestPerson fcp = new FindClosestPerson();

        System.out.println("1 == " + fcp.findClosest(2,7,4));
        System.out.println("2 == " + fcp.findClosest(2,5,6));
        System.out.println("0 == " + fcp.findClosest(1,5,3));
    }
}
