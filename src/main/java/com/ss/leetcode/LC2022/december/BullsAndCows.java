package com.ss.leetcode.LC2022.december;

public class BullsAndCows {
    // https://leetcode.com/problems/bulls-and-cows
    /** Algorithm
         1. Traverse the two strings and keep track of the digits count in 2 x int[10]
         2. While traversing, if current secret digit matches guess digit, only increment the
            bulls, but do not mark the digit count. This is because we ignore the bulls.
         3. Traverse both count arrays and return the sum of their mins. (cows)
             EG:
             - If secret has 7 0s and guess has 3 0s, means only the 3 zeroes can be moved around
             - If secret has 3 0s but guess has 7 0s, you can only shuffle and match the 3 0s.
             Thus, only the min between the two is taken in consideration
         4. Return the formatted string containing bulls and cows.
     */
    public String getHint(String secret, String guess) {
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];
        int bulls = 0;
        char sChar, gChar;
        for (int i = 0; i < secret.length(); i++) {
            sChar = secret.charAt(i);
            gChar = guess.charAt(i);
            if (sChar == gChar) {
                bulls++;
            } else {
                secretCount[sChar - '0']++;
                guessCount[gChar - '0']++;
            }
        }
        int cows = 0;
        for (int i = 0; i < secretCount.length; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }
        return new StringBuilder().append(bulls).append('A').append(cows).append('B').toString();
    }
}
