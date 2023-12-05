package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.december.PartitionStringIntoMinimumBeautifulSubstrings;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

        start.partitionStringIntoMinimumBeautifulSubstrings();
    }

    public void partitionStringIntoMinimumBeautifulSubstrings() {
        PartitionStringIntoMinimumBeautifulSubstrings psimbs = new PartitionStringIntoMinimumBeautifulSubstrings();

//        System.out.println("2 == " + psimbs.minimumBeautifulSubstrings("1011"));
//        System.out.println("3 == " + psimbs.minimumBeautifulSubstrings("111"));
//        System.out.println("-1 == " + psimbs.minimumBeautifulSubstrings("0"));
//        System.out.println("2 == " + psimbs.minimumBeautifulSubstrings("1100001101011"));
        System.out.println("3 == " + psimbs.minimumBeautifulSubstrings("100111000110111"));
    }
}
