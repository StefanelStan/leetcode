package com.ss.leetcode.LC2023.january;

public class CountTheDigitsThatDivideANumber {
    // https://leetcode.com/problems/count-the-digits-that-divide-a-number
    /** Algorithm
        1. Create a copy of that num, numCopy that will be used to divide by 10 in order to get the digits of num
        2. In a loop while numCopy > 0, get last digit of numCopy (numCopy % 10) and check if it divides num.
           If yes, increment the answer;
        3. On each iteration, divide the numCopy to 10 to simulate the elimination of last digit.
     */
    public int countDigits(int num) {
        int totalDigits = 0;
        int copy = num;
        while (copy > 0) {
            if (num % (copy % 10) == 0) {
                totalDigits++;
            }
            copy = copy / 10;
        }
        return totalDigits;
    }
}
