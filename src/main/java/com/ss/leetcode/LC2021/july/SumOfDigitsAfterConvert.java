package com.ss.leetcode.LC2021.july;

public class SumOfDigitsAfterConvert {
    // https://leetcode.com/contest/weekly-contest-251/problems/sum-of-digits-of-string-after-convert/
    /** Algorithm
        1. For each char, get the order number (1 + char[i] - 'a')).
        2. As this "order number" can be 2 digit, you can apply a digit sum right away.
        3. So indead of transforming "az" into [1,26] and then doing a digitSum(1) + digitSum(26), you can do it in one go
            - so "az" -> digitSum(1) = 1 + digitSum(26) = 8, obtaining 9.
        4. This dual transformation combined the first step of k (k--)
        5. Apply this while k > 1.
     */
    public int getLucky(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += digitSum(1 + (s.charAt(i) - 'a'));
        }
        while (sum > 9 && k > 1) {
            sum = digitSum(sum);
            k--;
        }
        return sum;
    }

    private int digitSum(int number) {
        int tempSum = 0;
        while(number > 0) {
            tempSum += (number % 10);
            number = number / 10;
        }
        return tempSum;
    }


    public int getLucky2(String s, int k) {
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            stb.append(s.charAt(i) - 'a' + 1);
        }
        String digitSum = addDigits(stb.toString());
        if (k == 1) {
            return Integer.parseInt(digitSum);
        } else {
            for (int j = 2; j <=k; j++) {
                digitSum = addDigits(digitSum);
            }
            return Integer.parseInt(digitSum);
        }
    }

    private String addDigits(String toString) {
        int sum = 0;
        for(int i= 0; i < toString.length(); i++) {
            sum += Integer.parseInt(String.valueOf(toString.charAt(i)));
        }
        return String.valueOf(sum);
    }
}
