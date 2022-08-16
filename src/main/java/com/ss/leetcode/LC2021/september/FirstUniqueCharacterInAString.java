package com.ss.leetcode.LC2021.september;

public class FirstUniqueCharacterInAString {
    // https://leetcode.com/problems/first-unique-character-in-a-string/
    /** Algorithm
        1. Use a matrix [2][26] to count the chars (a-z) on row0 and their lastIndex on row1
            eg: abbac
            count:  [2,2,1,0....0]
            index:  [3,2,4,0,...0]
        2. Use a min = Integer.MAX_VALUE;
            Traverse the count matrix and if row0/count == 1 then set the min = Min(min, row1[i]/last_index).
            As row1 keeps the lastIndex, we need the minumum, which is the first appearance of that unique char.
        3. If min is still MAX_VALUE, then no unique was found, return -1, else min.
     */
    public int firstUniqChar(String s) {
        int[][] charCount = new int[2][26];
        int i = 0;
        for (char c : s.toCharArray()) {
            charCount[0][c - 'a']++;
            charCount[1][c - 'a'] = i++;
        }
        int minPos = Integer.MAX_VALUE;
        for (int j = 0; j < 26; j++) {
            if (charCount[0][j] == 1) {
                minPos = Math.min(minPos, charCount[1][j]);
            }
        }
        return minPos == Integer.MAX_VALUE ? -1 : minPos;
    }

    public int firstUniqChar2(String s) {
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
