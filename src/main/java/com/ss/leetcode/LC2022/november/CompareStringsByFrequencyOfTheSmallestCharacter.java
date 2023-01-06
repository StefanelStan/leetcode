package com.ss.leetcode.LC2022.november;

public class CompareStringsByFrequencyOfTheSmallestCharacter {
    // https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
    /** Algorithm
         1. The main idea is to find the frequency of each word of words.
             Once you have it, count and store/increment the frequency of ALL into an array[11]
             (max frequency is 10 for 10 chars long word)
             EG: words = ["a","aa","aaa","aaaa"] then frequency[] would look like [0,1,1,1,1,0,0,0,0,0,0].
         2. Do a rolling/cumulative sum from left to right on this array:
            => [0,1,2,3,4,4,4,4,4,4,4]
         3. For each query, calculate the frequency and see how many frequencies are greater than query's frequency.
             You can do this by calling frequency[length -1] (total/Sum) - frequency[query_frequency].
             EG: query frequency is 2. Then frequency[10] - frequency[2] = 4 - 2 => 2.
         4. Return the array matching the answer for each query
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordFrequency = new int[11];
        for (String word : words) {
            wordFrequency[getFrequency(word)]++;
        }
        for (int i = 1; i < wordFrequency.length; i++) {
            wordFrequency[i] += wordFrequency[i-1];
        }

        int[] queryFrequencies = new int[queries.length];
        int queryFrequency;
        for (int i = 0; i < queries.length; i++) {
            queryFrequency = getFrequency(queries[i]);
            queryFrequencies[i] = wordFrequency[wordFrequency.length - 1] - wordFrequency[queryFrequency];
        }
        return queryFrequencies;
    }

    private int getFrequency(String word) {
        char minChar = 'z', currentChar;
        int frequency = 0;

        for (int i = 0; i < word.length(); i++) {
            currentChar = word.charAt(i);
            if (currentChar < minChar) {
                minChar = currentChar;
                frequency = 1;
            } else if (currentChar == minChar) {
                frequency++;
            }
        }
        return frequency;
    }
}
