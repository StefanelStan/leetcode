package com.ss.leetcode.LC2022.october;

public class OddStringDifference {
    // https://leetcode.com/problems/odd-string-difference/
    /** Algorithm
         1. We could use a brute method to return an int[] diffs for each word and compare multiple ints[] between them, but this would allocate memory for no reason
         2. Instead, count the differences into a single int[] diffs.
            "aba" => [1, -1].
         3. Generate this single diff array for the very first word.
         4. In a loop from 2nd word to last one:
         5. If next word has the same diff for each pair of letters, mark a boolean flag asduplicated found = true;
             This way, we know 100% which is the duplication "fingerprint" of diff array.
             Next word that has a different diff must be the unique one.
         6. If you have a mismatch but your duplicate flag is not yet set, you must be in the scenario
             where i = 1 and your array is
             [unique, duplicated, duplicated...] or [duplicated, unique, duplicated...]
             - Check the next word (index 2). If next word matches current one, it means index -1 (1-1 = 0) is
             your unique. [unique, duplicated, duplicated...]
             - If next word is different that current one, it means the current one is the unique one
             [duplicated, unique, duplicated...].
     */
    public String oddString(String[] words) {
        int[] diffs = getDiff(words[0].toCharArray());
        boolean duplicatedFound = false;
        for (int i = 1; i < words.length; i++) {
            char[] chrs = words[i].toCharArray();
            for(int j = 0; j < chrs.length - 1; j++) {
                if (diffs[j] != chrs[j+1] - chrs[j]) {
                    if (duplicatedFound) {
                        return words[i];
                    } else {
                        return words[i + getOddWord(chrs, words[i+1].toCharArray())];
                    }
                }
            }
            duplicatedFound = true;
        }
        return "";
    }

    private int[] getDiff(char[] chrs) {
        int[] diffs = new int[chrs.length - 1];
        for(int i = 0; i < chrs.length - 1; i++) {
            diffs[i] = chrs[i+1] - chrs[i];
        }
        return diffs;
    }

    // Check the two words. If thay match, it means they are duplicated and currentIndex -1 is the unique one.
    // If they do not match, it means your current one (currentIndex + 0) is the unique one.
    private int getOddWord(char[] word1, char[] word2) {
        for (int i = 0; i < word1.length -1; i++) {
            if (word1[i+1] - word1[i] != word2[i+1] - word2[i]) {
                return 0;
            }
        }
        return -1;
    }
}
