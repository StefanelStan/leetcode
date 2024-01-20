package com.ss.leetcode.LC2024.january;

public class MinimumNumberOfFrogsCroaking {
    // https://leetcode.com/problems/minimum-number-of-frogs-croaking
    /** Algorithm
        1. In order for a frog to sing "r" there needs to be at least 1 active frog that just sang "c"
            - In order to have a frog singing "k" you need to have at least 1 active frog that sang "a"
        2. Use an int['r' + 1] to keep track of each letter count.
        3. Traverse string and
            - if current letter is 'c' then you will have 1 more active frog. Increment frog[c] and activeFrogs
            - if current letter is 'k' then you will have 1 less active frog. Decrement activeFrogs
            - for letters [r,o,a,k] you need to have at least 1 active precursor frog (as explained #1) for a song to occur.
                If such does not exist, return -1 from fucntion immediately
            - Decrement precursorFrog and increment current song frog
            - EG: 'o' -> activeFrog[r]-- ; activeFrom[o]++;
     */
    private static final char[] prevLetters = {'o',0,0,0,0,0,0,0,0,0,'a',0,0,0,'r',0,0,'c'};
    public int minNumberOfFrogs(String croakOfFrogs) {
        int maxActiveFrogs = 0, activeFrogs = 0, newFrogStatus = 0;
        int[] frogQueue = new int[26];
        for (int i = 0; i < croakOfFrogs.length() && newFrogStatus != -2; i++) {
            newFrogStatus = findFrog(croakOfFrogs.charAt(i), frogQueue);
            activeFrogs += newFrogStatus;
            maxActiveFrogs = Math.max(maxActiveFrogs, activeFrogs);
        }
        return newFrogStatus == -2 || activeFrogs > 0 ? -1 : maxActiveFrogs;
    }

    private int findFrog(char letter, int[] frogQueue) {
        if (letter == 'c') {
            frogQueue['c' - 'a']++;
            return 1;
        } else {
            char prevLetter = prevLetters[letter - 'a'];
            if (frogQueue[prevLetter - 'a'] == 0) {
                return -2;
            }
            frogQueue[prevLetter - 'a']--;
            if (letter != 'k') {
                frogQueue[letter - 'a']++;
                return 0;
            } else {
                return -1;
            }
        }
    }
}
