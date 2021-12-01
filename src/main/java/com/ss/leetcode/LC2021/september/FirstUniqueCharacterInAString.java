package com.ss.leetcode.LC2021.september;

public class FirstUniqueCharacterInAString {
    // https://leetcode.com/problems/first-unique-character-in-a-string/
    public int firstUniqChar(String s) {
        int[][] charCounter = new int[26][2];
        for (int[] count : charCounter) {
            count[1] = s.length() + 1;
        }
        int chrIndex;
        for (int i = 0; i < s.length(); i++) {
            chrIndex = s.charAt(i) - 'a';
            charCounter[chrIndex][0]++;
            charCounter[chrIndex][1] = Math.min(i, charCounter[chrIndex][1]);
        }
        int firstUnique = s.length();
        for (int[] count : charCounter) {
            if (count[0] == 1) {
                firstUnique = Math.min(count[1], firstUnique);
            }
        }
        return firstUnique == s.length() ? -1 : firstUnique;
    }
}
