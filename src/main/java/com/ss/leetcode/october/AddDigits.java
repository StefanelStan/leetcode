package com.ss.leetcode.october;

public class AddDigits {
    // https://leetcode.com/problems/add-digits/
    public int addDigits(int num) {
        int partNum = 0;
        while (num > 0) {
            partNum += num % 10;
            num /= 10;
            if (num == 0) {
                if (partNum > 9) {
                    num = partNum;
                    partNum = 0;
                } else {
                    break;
                }
            }
        }
        return partNum;
    }
}
