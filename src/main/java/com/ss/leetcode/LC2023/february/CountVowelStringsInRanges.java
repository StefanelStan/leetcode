package com.ss.leetcode.LC2023.february;

public class CountVowelStringsInRanges {
    // https://leetcode.com/problems/count-vowel-strings-in-ranges
    /** Algorithm
        1. As we observe, we can identify this to be a range query problem: the sum of vowel strings between two ranges
        2. Use an int[] count to count how many (rolling sum) vowel strings there are from i to n
            EG: ["aba","bcb","ece","aa","e","p"] => [1,1,2,3,4,4]
        3. For each query, based on the given range [i,j], determine the diff between  count[j] - count[i-1].
            EG: range = [2,4]
            count[1] = 1, count[4] = 4. 4-1 = 3 (ece, aa, e)
        4. Return the query range answer;
     */
    private static boolean[] vowels;
    public int[] vowelStrings(String[] words, int[][] queries) {
        setVowels();
        int[] vowelCount = countVowelStrings(words);
        int[] queryAnswer = new int[queries.length];
        int left, right;
        for(int i = 0; i < queries.length; i++) {
            left = queries[i][0] == 0 ? 0 : vowelCount[queries[i][0] - 1];
            right = vowelCount[queries[i][1]];
            queryAnswer[i] = right -  left;
        }
        return queryAnswer;

    }

    private int[] countVowelStrings(String[] words) {
        int[] vowelCount =  new int[words.length];
        vowelCount[0] = isVowelValid(words[0]) ? 1 : 0;
        for (int i = 1; i < words.length; i++) {
            vowelCount[i] = vowelCount[i-1] + (isVowelValid(words[i]) ? 1 : 0);
        }
        return vowelCount;
    }

    private boolean isVowelValid(String s) {
        return vowels[s.charAt(0) - 'a'] && vowels[s.charAt(s.length() - 1) - 'a'];
    }

    private void setVowels() {
        if (vowels == null) {
            vowels = new boolean[26];
            vowels['a' - 'a'] = true;
            vowels['e' - 'a'] = true;
            vowels['i' - 'a'] = true;
            vowels['o' - 'a'] = true;
            vowels['u' - 'a'] = true;
        }
    }
}
