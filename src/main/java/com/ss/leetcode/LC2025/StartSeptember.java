package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.september.FindClosestPerson;
import com.ss.leetcode.LC2025.september.FindMostFrequentVowelAndConsonant;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

//        start.findClosestPerson();
        start.findMostFrequentVowelAndConsonant();
    }

    public void findClosestPerson() {
        FindClosestPerson fcp = new FindClosestPerson();

        System.out.println("1 == " + fcp.findClosest(2,7,4));
        System.out.println("2 == " + fcp.findClosest(2,5,6));
        System.out.println("0 == " + fcp.findClosest(1,5,3));
    }

    public void findMostFrequentVowelAndConsonant() {
        FindMostFrequentVowelAndConsonant fmfvac = new FindMostFrequentVowelAndConsonant();

        System.out.println("6 == " + fmfvac.maxFreqSum("successes"));
        System.out.println("3 == " + fmfvac.maxFreqSum("aeiaeia"));
        System.out.println("4 == " + fmfvac.maxFreqSum("aaaa"));
        System.out.println("4 == " + fmfvac.maxFreqSum("aaaai"));
        System.out.println("12 == " + fmfvac.maxFreqSum("asdadaoidsjdasdjwsoicfnsdlcvsadkc"));
        System.out.println("7 == " + fmfvac.maxFreqSum("aeioubbbffffpppppvvvvvv"));
    }
}
