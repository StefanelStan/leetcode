package com.ss.leetcode.LC2021.september;

public class SlowestKey {
    // https://leetcode.com/problems/slowest-key/
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] totalTimes = new int[26];
        totalTimes[keysPressed.charAt(0) - 'a'] = releaseTimes[0];
        int maxChar = keysPressed.charAt(0) - 'a', maxTimes = releaseTimes[0], currentChar = 0;

        for (int i = 1; i < keysPressed.length(); i++) {
            currentChar = keysPressed.charAt(i) - 'a';
            totalTimes[currentChar] = Math.max(totalTimes[currentChar], releaseTimes[i] - releaseTimes[i-1]);
            if (totalTimes[currentChar] == maxTimes) {
                maxTimes = totalTimes[currentChar];
                maxChar = Math.max(maxChar, currentChar);
            } else if (totalTimes[currentChar] > maxTimes) {
                maxTimes = totalTimes[currentChar];
                maxChar = currentChar;
            }
        }
        return (char)(maxChar + 'a');
    }
}
