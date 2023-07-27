package com.ss.leetcode.LC2023.july;

import java.util.Arrays;

public class ExpressiveWords {
    // https://leetcode.com/problems/expressive-words
    /** Algorithm
        1. For increased efficiency, group the letters of s (stretch)
            instead of ccccaabbbbb just use an int[][] to map each char and its count in order:
            [2,4] (c-a = 2), [0,2],[1,5].
            This way we don't need to  iterate over all s multiple times, but over this count.
        2. Iterate over each word and determine if the word is expressive against the stretch (or the mapping)
            - If stretch.length() < word.length(), return false
            - Else, iterate over word with 2 pointers (i, j) that will keep track of start and end of a segment of same letters
                EG: word = "aaaaabc". i will be at 0 and j at 4. This will give you a segment of size 5 of letters a.
            - For each segment of word, check against the next segment inside the stretch mapping.
            word has a segment of size 5 for letter a => [0,5].
        3. Once determined a segment from the word, match it against the next segment of the stretch
            [2,4] != [0,5], so we break and return false for this word.
        4. Return the number of good words.
     */
    public int expressiveWords(String s, String[] words) {
        int[][] sGroups = countCharsGroups(s);
        int count = 0;
        for (String word : words) {
            count += isExpressive(sGroups, s, word) ? 1 : 0;
        }
        return count;
    }

    private boolean isExpressive(int[][] sGroups, String stretch, String word) {
        if (stretch.length() < word.length()) {
            return false;
        }
        int stretchIndex = 0;
        int i = 0, j = 1;
        char iChar = word.charAt(i);
        while(j < word.length()) {
            // if current letter is distinct from segment start, compare the segment that just ended with the next one
            // expected to encounter in the stretch (sGroup)
            if (word.charAt(j) != iChar) {
                if (areMatching(sGroups[stretchIndex], iChar, j - i)) {
                    // if the segments match, reset the new segment start and continue checking letters and setting new segment size
                    stretchIndex++;
                    i = j;
                    iChar = word.charAt(i);
                } else {
                    return false;
                }
            } else {
                j++;
            }
        }
        // check your stretch index to be at the end. Edge cases: stretch = "aaaabb" and word = "a". Stretch index will be at 1
        return stretchIndex + 1 == sGroups.length && areMatching(sGroups[stretchIndex], iChar, (j - i));
    }

    private int[][] countCharsGroups(String s) {
        int[][] count = new int[s.length()][2];
        int countIndex = 0, sIndex = 1;
        char prev = s.charAt(0), current;
        count[countIndex][0] = prev - 'a';
        count[countIndex][1] = 1;
        while(sIndex < s.length()) {
            current = s.charAt(sIndex++);
            if (current == prev) {
                count[countIndex][1]++;
            } else {
                countIndex++;
                count[countIndex][0] = current - 'a';
                count[countIndex][1] = 1;
            }
            prev = current;
        }
        return Arrays.copyOfRange(count, 0, countIndex + 1);
    }

    private boolean areMatching(int[] charAndCount, char ch, int count) {
        return charAndCount[0] == ch - 'a' && (charAndCount[1] == count || (charAndCount[1] >= count && charAndCount[1] >= 3));
    }
}
