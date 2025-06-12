package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.june.MaximumDifferenceBetweenAdjacentElementsInACircularArray;
import com.ss.leetcode.LC2025.june.MaximumDifferenceBetweenEvenAndOddFrequencyI;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

//        start.maximumDifferenceBetweenEvenAndOddFrequencyI();
        start.maximumDifferenceBetweenAdjacentElementsInACircularArray();
    }

    public void maximumDifferenceBetweenEvenAndOddFrequencyI() {
        MaximumDifferenceBetweenEvenAndOddFrequencyI mdbeaofi = new MaximumDifferenceBetweenEvenAndOddFrequencyI();

        System.out.println("3 == " + mdbeaofi.maxDifference("aaaaabbc"));
        System.out.println("1 == " + mdbeaofi.maxDifference("abcabcab"));
        System.out.println("5 == " + mdbeaofi.maxDifference("sdfsdafsdfsdfdgghgrshgrfhsghgfhsgdfgdf"));
        System.out.println("1 == " + mdbeaofi.maxDifference("fsgdfgadsffdgdfsgdfsl"));
        System.out.println("3 == " + mdbeaofi.maxDifference("fudgahfsdfosdijgfofdnhfyerhbiweuds"));
    }

    public void maximumDifferenceBetweenAdjacentElementsInACircularArray() {
        MaximumDifferenceBetweenAdjacentElementsInACircularArray mdbaeiaca = new MaximumDifferenceBetweenAdjacentElementsInACircularArray();

        System.out.println("3 == " + mdbaeiaca.maxAdjacentDistance(new int[]{1,2,4}));
        System.out.println("5 == " + mdbaeiaca.maxAdjacentDistance(new int[]{-5,-10,-5}));
        System.out.println("4 == " + mdbaeiaca.maxAdjacentDistance(new int[]{5,1}));
        System.out.println("7 == " + mdbaeiaca.maxAdjacentDistance(new int[]{0,1,-2,-5,-3,4,7,3,4,5,6,7,3}));
        System.out.println("81 == " + mdbaeiaca.maxAdjacentDistance(new int[]{4,3,4,5,67,5,4,3,54,67,8,87,6,5,3,2,45}));
    }
}
