package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.june.MaximumDifferenceBetweenEvenAndOddFrequencyI;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

        start.maximumDifferenceBetweenEvenAndOddFrequencyI();
    }

    public void maximumDifferenceBetweenEvenAndOddFrequencyI() {
        MaximumDifferenceBetweenEvenAndOddFrequencyI mdbeaofi = new MaximumDifferenceBetweenEvenAndOddFrequencyI();

        System.out.println("3 == " + mdbeaofi.maxDifference("aaaaabbc"));
        System.out.println("1 == " + mdbeaofi.maxDifference("abcabcab"));
        System.out.println("5 == " + mdbeaofi.maxDifference("sdfsdafsdfsdfdgghgrshgrfhsghgfhsgdfgdf"));
        System.out.println("1 == " + mdbeaofi.maxDifference("fsgdfgadsffdgdfsgdfsl"));
        System.out.println("3 == " + mdbeaofi.maxDifference("fudgahfsdfosdijgfofdnhfyerhbiweuds"));
    }
}
