package com.ss.leetcode.LC2021.february;

import java.util.LinkedList;
import java.util.List;

public class SelfDividingNumbers {
    // https://leetcode.com/problems/self-dividing-numbers/
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDividingNumbers = new LinkedList<>();
        while(left <= right) {
            if(isSelfDividingNumber(left)) {
                selfDividingNumbers.add(left);
            }
            left++;
        }
        return selfDividingNumbers;
    }

    private boolean isSelfDividingNumber(int number) {
        int[] digits = String.valueOf(number).chars().map(Character::getNumericValue).toArray();
        for(int digit : digits) {
            if (digit == 0 || number % digit != 0) {
                return false;
            }
        }
        return true;
    }
}
