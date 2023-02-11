package com.ss.leetcode.LC2023.february;

public class ReconstructOriginalDigitsFromEnglish {
    // https://leetcode.com/problems/reconstruct-original-digits-from-english
    /** Algorithm
        1. Count the letters of the String into an int[26] (a - 'a').
        2. In the given exclusion based order, count and deduct the minimum chars required to build the digits
            0 (zero), 6 (six), 2,8,3,4,1,5,7,9.
            In this order, eliminating the min z will also eliminate the e, r and o that belong to 0
            Eliminating the x will also eliminate the i and s that belong to 6
            Eliminating the w will also eliminate the t and o belonging to 2
         3. Repeat step 2 for the given order and mark how many 0,6,... you can build.
         4. Traverse the result int[10] and append 0,1,2 as per the count
         5. Return the String
     */
    private static final Nr[] numbers = {new Nr("zero", 0), new Nr("six", 6), new Nr("two", 2),
        new Nr("eight", 8),new Nr("three", 3), new Nr("four", 4), new Nr("one", 1),
        new Nr("five", 5), new Nr("seven", 7), new Nr("nine", 9)};
    public String originalDigits(String s) {
        int[] letterCount = countLetters(s);
        int[] digitCount = new int[10];
        for (Nr number : numbers) {
            countDigit(number, letterCount, digitCount);
        }
        return buildString(digitCount);
    }

    private int[] countLetters (String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }

    private void countDigit(Nr number, int[] letterCount, int[] digitCount) {
        int minTimes = Integer.MAX_VALUE;
        for (char ch : number.number) {
            minTimes = Math.min(minTimes, letterCount[ch - 'a']);
        }
        if (minTimes > 0) {
            for (char ch : number.number) {
                letterCount[ch - 'a'] -= minTimes;
            }
            digitCount[number.value] = minTimes;
        }
    }

    private String buildString(int[] digitCount) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < digitCount.length; i++) {
            if (digitCount[i] > 0) {
                while (digitCount[i]-- > 0) {
                    stb.append((char)(i + '0'));
                }
            }
        }
        return stb.toString();
    }

    private static class Nr {
        private char[] number;
        private int value;

        public Nr(String number, int value) {
            this.number = number.toCharArray();
            this.value = value;
        }
    }
}
