package com.ss.leetcode.LC2022.may;

public class FindTheKBeautyOfANumber {
    //https://leetcode.com/contest/biweekly-contest-78/problems/find-the-k-beauty-of-a-number/
    public int divisorSubstrings(int num, int k) {
        int beautyValue = 0;
        String numStr = String.valueOf(num);
        int tmp = 0;
        for(int i = 0; i + k <= numStr.length(); i++) {
            tmp = Integer.parseInt(numStr.substring(i, i+k));
            if (tmp != 0 && num % tmp == 0) {
                beautyValue++;
            }
        }
        return beautyValue;
    }
}
