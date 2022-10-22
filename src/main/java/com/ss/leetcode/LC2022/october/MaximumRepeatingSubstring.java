package com.ss.leetcode.LC2022.october;

public class MaximumRepeatingSubstring {
    // https://leetcode.com/problems/maximum-repeating-substring/
    /** Algorithm
        1. Convert both strings into char[] due to faster access time
        2. Loop over sequence and check if seq[i] == word[0]. If the letters match, then try to determine
            the longest repeating sequence of word starting from that i position
        3. Determining the longest repeating sequence:
            - Loop from current pos until seq.length - word.length in windows of word.length size.
                (No need to go on pos 4/5 if word has length of 3)
            - If at any point there is a mismatch, break the loop and return the number of loops found
     4. Returning nr. of loops found - OPTIMISATION
        - If the number of loop found is < 2, then simply increment i by 1.
         This is a fallback for edge cases where the end of a word is identical with the beginning
         - If nr of loops is >= 2, then we can skip the loop -1 chars, as these have been checked already
         EG: ababcdeab / ab
         i = 0: we have 2 loops, so we can skip at most (loop -1) * word.length chars.
        We should not skip 2 loops because the end of a word can be identical with the beginning of a word
         EG: aaabaaaabaaaba / aaaba
         we have 2 loops at beginning. If we skip the first 10 chars, then we also skip the a from index 10, which is the beginning of another loop sequence that overlaps the end of a sequence.
     */
    public int maxRepeating(String sequence, String word) {
        int maxRepeating = 0, currentLength;
        char[] seqChars = sequence.toCharArray();
        char[] wordChars = word.toCharArray();
        for (int i = 0; i + word.length() <= sequence.length();) {
            if (seqChars[i] == wordChars[0]) {
                currentLength = getCurrentLength(seqChars, wordChars, i);
                maxRepeating = Math.max(maxRepeating, currentLength);
                // if we found more than 1 loop, we can skip (loop - 1) * word.length chars.
                // we should not skip loop * word.length chars because the last loop can be the beginning of next loop, but overlaps it.
                if (currentLength > 1) {
                    i += (currentLength - 1) * word.length() + 1;
                    // else simply increment i by 1
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return maxRepeating;
    }

    private int getCurrentLength(char[] sequence, char[] word, int start) {
        int loops = 0;
        boolean shouldContinue = true;
        // search in windows of word.length size. Break at the first mismatch
        for(int i = start; i <= sequence.length - word.length && shouldContinue; i += word.length) {
            for (int j = 0; j < word.length; j++) {
                if (sequence[i + j] != word[j]) {
                    shouldContinue = false;
                    break;
                }
            }
            // if the loop ended successfully, then we can increment the number of repeatings found
            if (shouldContinue) {
                loops++;
            }
        }
        return loops;
    }
}
