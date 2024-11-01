package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.november.CountAlternatingSubarrays;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

        start.countAlternatingSubarrays();
    }

    public void countAlternatingSubarrays() {
        CountAlternatingSubarrays cas = new CountAlternatingSubarrays();

        System.out.println("5 == " + cas.countAlternatingSubarrays(new int[]{0,1,1,1}));
        System.out.println("10 == " + cas.countAlternatingSubarrays(new int[]{1,0,1,0}));
        System.out.println("1 == " + cas.countAlternatingSubarrays(new int[]{1}));
        System.out.println("3 == " + cas.countAlternatingSubarrays(new int[]{0,1}));
        System.out.println("2 == " + cas.countAlternatingSubarrays(new int[]{1,1}));
        System.out.println("5 == " + cas.countAlternatingSubarrays(new int[]{0,0,1,1}));
        System.out.println("129 == " + cas.countAlternatingSubarrays(new int[]{0,1,1,1,1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0}));
        System.out.println("71 == " + cas.countAlternatingSubarrays(new int[]{0,0,0,0,0,1,0,0,0,1,0,1,0,1,1,0,0,1,0,1,0,1,0,1}));
    }
}
