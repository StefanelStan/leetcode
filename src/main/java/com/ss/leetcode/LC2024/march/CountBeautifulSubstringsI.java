package com.ss.leetcode.LC2024.march;

public class CountBeautifulSubstringsI {
    // https://leetcode.com/problems/count-beautiful-substrings-i
    /** Algorithm
        1. vowels == consonants => means we need to have/inspect EVEN lengths of substrings
        2. If you are at index 0, you need to know how many vowels you have at index 1,3,5,7 etc.
            The substring [0,1] has a length of 2, [0,3] length of 4 and so on
        3. Compute a prefix sum/count of vowels (form left to right)
        4. Loop with i from 0 to n - 2 (including) in steps of 1
            - Loop with j from i+1 to n-1 (including) IN STEPS OF 2
        5. You know the number of vowels prefix[j] - prefix[i-1].
            - The number of consonants is 1 + j - i (length of substring.) - vowels.
            - if consonants == vowels and c * v % k == 0, increment the count
        6. Return the count;
     */
    private static final int[] vowels = new int[26];
    static {
        vowels[0] = vowels['e' - 'a'] = vowels['i' - 'a'] = vowels['o' - 'a'] = vowels['u' - 'a'] = 1;
    }

    public int beautifulSubstrings(String s, int k) {
        int[] vowelCount = getVowelCount(s);
        return countSubstrings(vowelCount, k);
    }

    private int countSubstrings(int[] vowelCount, int k) {
        int vowelsOnLeft, intervalVowels;
        int count = 0;
        for (int i = 0; i < vowelCount.length - 1; i++) {
            vowelsOnLeft = i == 0 ? 0 : vowelCount[i-1];
            for (int j = i + 1; j < vowelCount.length; j += 2) {
                intervalVowels = vowelCount[j] - vowelsOnLeft;
                if (intervalVowels == (1 + j - i) / 2 && intervalVowels * intervalVowels % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private int[] getVowelCount(String s) {
        int[] vowelCount = new int[s.length()];
        vowelCount[0] = vowels[s.charAt(0) - 'a'];
        for (int i = 1; i < s.length(); i++) {
            vowelCount[i] = vowelCount[i - 1] + vowels[s.charAt(i) - 'a'];
        }
        return vowelCount;
    }
}
