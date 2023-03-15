package com.ss.leetcode.playground;

public class AddNumerical {

    /**
     *  Algorithm
     *   1. Traverse current string and get the current letter.
     *   2. If current char is a digit, check previous letter. If it is minus, set the multiplication sign to be minus
     *   3. Use a currentSum (segment sum) to add the current digit to the current segment sum
     *      EG: 12 currentSum = 0;
     *      i = 0 => currentSum = 0 * 10 + 1 = 1;
     *      i = 1 => currentSum = 1 * 10 + 2 => 12
     *   4. If current char is NOT a digit, then you might have finished a segment. Add it to the totalSum
     */
    public int sumOfSubStringIntegers(String s) {
        int sum = 0, currentSum = 0, sign = 1;
        char previousChar = 0, currentChar;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                if (previousChar == '-') {
                    sign = -1;
                }
                currentSum = currentSum * 10 + (currentChar - '0');
            } else { // not a digit. Add the currentSum to totalSum in case you have just finished a segment.
                sum += (currentSum * sign);
                currentSum = 0;
                sign = 1;
            }
            previousChar = currentChar;
        }
        sum += (currentSum * sign);
        return sum;
    }
}
