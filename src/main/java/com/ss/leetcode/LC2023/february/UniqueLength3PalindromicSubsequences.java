package com.ss.leetcode.LC2023.february;

public class UniqueLength3PalindromicSubsequences {
    // https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
    /** Algorithm
         1. Get the last indices of each character in the string in an int[26] lastIndices;
            "ceabc" -> [2,3,4,0,1];
         2. Starting with i = 0 ..n-2 and j = i+1..n-1, we need to know if there is another character matching
            i that is AFTER index j. We know this from lastIndices.
             EX: i = 0;
             j = 1: c, e -> is there another c after index 1 ? yes: lastIndices[c] = 4. We have a palindrome cec
             j = 2: c, a -> any character c after index 2 ? yes, at index 4: we have a palindrome cac
             j = 3: c, b -> any character c after index 2? yes: we have another palindrime cbc
             i = 1  We should skip this point because we see lastIdnex[e] == i (1), so no palindrome can be formed (only 1 single char)
             i = 2  We should skip this point because we see lastIdnex[a] == i (2), so no palindrome can be formed (only 1 single char)
         3. While doing this, use a boolean[26][27] to mark any combinations done by characters:
            eg: "aaaaa": as we have done "aaa" we should mark [0][0] = true.
         4. For high optimization, the 27th column is used to mark if the letter has been checked.
             EX: "aeaeat"
             on i = 0 we check a as head of palindrome, so we should not check a again when we reach i = 2 onwards
             on i = 1 we check e as head of palindrome, so we should not check e again when we reach i = 3 onwards
         5. If letter a was checked for palindromes, then mark [0][27] true. There is no point in checking the same letter twice as
            head of palindrome.
     */
    public int countPalindromicSubsequence(String s) {
        int count = 0;
        boolean[][] doneCombinations = new boolean[26][27];
        char[] chrs = s.toCharArray();
        int[] lastIndices = getLastIndices(chrs);
        for (int i = 0; i < chrs.length - 2; i++) {
            for (int j = i + 1; j < chrs.length - 1 && lastIndices[chrs[i] - 'a'] > i && !doneCombinations[chrs[i] -'a'][26]; j++) {
                if (!doneCombinations[chrs[i] -'a'][chrs[j] - 'a']) {
                    doneCombinations[chrs[i] -'a'][chrs[j] - 'a'] = true;
                    if (lastIndices[chrs[i] - 'a'] > j) {
                        count++;
                    }
                }
            }
            doneCombinations[chrs[i] -'a'][26] = true;
        }
        return count;
    }

    private int[] getLastIndices(char[] chrs) {
        int[] lastIndices = new int[26];
        for (int i = 0; i < chrs.length; i++) {
            lastIndices[chrs[i] - 'a'] = i;
        }
        return lastIndices;
    }
}
