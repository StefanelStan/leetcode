package com.ss.leetcode.september;

import java.util.Arrays;

public class SortCharactersByFrequency {
    /**
     * Algorithm:
     * 1. Count the letters and retain their count and codePoint into a custom Letter[] (count, codePoint)
     * 2  Sort the Letter[] array based on count, preferably on reverseOrder.
     * 3. Create the char[] answer array.
     * 4. Iterate over each sorted entry of Letter[] and populate letter.count into the answer[] with the correct codePoint
     *  eg: Letter[0] -> count10, codePoint 50. So the first 10 positions of answer[] will be filled with 50 + 48 (ascii b)
     */
    // https://leetcode.com/problems/sort-characters-by-frequency/
    public String frequencySort(String s) {
        if(s.length() == 1) {
            return s;
        }
        Letter[] letters = new Letter['z' - '0' + 1];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = new Letter(i);
        }
        // count how many letters for this codepoint there are
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - '0'].count++;
        }
        // sort the array based on how many letters there are
        Arrays.sort(letters, (o1, o2) -> Integer.compare(o2.count, o1.count));
        char[] sorted = new char[s.length()];
        int outerIndex = 0;
        // populate char[]sorted with the codepoint chars from letters[].
        for (int i = 0; i < letters.length && letters[i].count > 0; i++) {
            for (int j = outerIndex; j < outerIndex + letters[i].count; j++) {
                sorted[j] = (char)(letters[i].codePoint + '0');
            }
            outerIndex += letters[i].count;
        }

        return new String(sorted);
    }

    private static class Letter {
        int count;
        int codePoint;
        public Letter(int codePoint) {
            this.codePoint = codePoint;
        }
    }
}
