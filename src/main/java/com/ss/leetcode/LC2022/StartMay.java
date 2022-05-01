package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.may.LatestTimeByReplacingHiddenDigits;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();

        start.latestTimeByReplacingHiddenDigits();
    }

    public void latestTimeByReplacingHiddenDigits() {
        LatestTimeByReplacingHiddenDigits ltbrhd = new LatestTimeByReplacingHiddenDigits();

        System.out.println("23:50 == " + ltbrhd.maximumTime("2?:?0"));
        System.out.println("09:39 == " + ltbrhd.maximumTime("0?:3?"));
        System.out.println("19:22 == " + ltbrhd.maximumTime("1?:22"));
    }
}
