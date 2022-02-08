package com.ss.leetcode.LC2021.october;

public class AddDigits {
    // https://leetcode.com/problems/add-digits/
    public int addDigits(int num) {
        while(num > 9) {
            num = getSumOfDigits(num);
        }
        return num;
    }

    private int getSumOfDigits(int n) {
        int sum = 0;

        while(n > 0) {
            sum += n % 10;
            n = n/10;
        }
        return sum;
    }

    public int addDigits2(int num) {
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
