package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.july.TotalDistanceTraveled;
import com.ss.leetcode.LC2023.july.UniqueSubstringsInWraparoundString;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

//        start.uniqueSubstringsInWraparoundString();
        start.totalDistanceTraveled();
    }

    public void uniqueSubstringsInWraparoundString() {
        UniqueSubstringsInWraparoundString usiws = new UniqueSubstringsInWraparoundString();

        System.out.println("1 == " + usiws.findSubstringInWraproundString("a"));
        System.out.println("2 == " + usiws.findSubstringInWraproundString("cac"));
        System.out.println("6 == " + usiws.findSubstringInWraproundString("zab"));
    }

    public void totalDistanceTraveled() {
        TotalDistanceTraveled tdt = new TotalDistanceTraveled();

        System.out.println("60 == " + tdt.distanceTraveled(5, 10));
        System.out.println("10 == " + tdt.distanceTraveled(1, 2));
        System.out.println("820 == " + tdt.distanceTraveled(70, 12));
    }
}
