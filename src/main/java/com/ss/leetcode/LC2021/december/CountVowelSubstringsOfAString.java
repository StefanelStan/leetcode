package com.ss.leetcode.LC2021.december;

public class CountVowelSubstringsOfAString {
    // https://leetcode.com/problems/count-vowel-substrings-of-a-string/
    private static boolean[] vowels;
    // NOT DONE
    public CountVowelSubstringsOfAString() {
        if (vowels == null) {
            vowels = new boolean[26];
            vowels['a' - 'a'] = true;
            vowels['e' - 'a'] = true;
            vowels['i' - 'a'] = true;
            vowels['o' - 'a'] = true;
            vowels['u' - 'a'] = true;
        }
    }

    public int countVowelSubstrings(String word) {
        boolean overSubstring = false;
        int[] foundVowels = new int[26];
        int codePoint, vowelCount = 0, vowelSubstrings = 0, substringStart = 0, firstComplete = 0, leftVowels = 0;
        for (int i = 0; i < word.length(); i++) {
            codePoint = word.charAt(i) - 'a';
            if (vowels[codePoint]) {
                if (!overSubstring) {
                    overSubstring = true;
                    substringStart = i;
                    leftVowels = 0;
                    foundVowels = new int[26];
                }
                if (foundVowels[codePoint]++ == 0) {
                    vowelCount++;
                }
                if (vowelCount == 5) {
                    if(firstComplete == 0) {
                        firstComplete = i;
                    }
                }
            } else if(overSubstring) {
                overSubstring = false;
                if (vowelCount >= 5) {
                    vowelSubstrings += getVowelSubstring(word, substringStart, firstComplete, i -1);
                }
                vowelCount = 0;
                substringStart = i;
                firstComplete = 0;
                leftVowels = 0;
                foundVowels = new int[26];
            }
        }

        if (vowelCount == 5) {
            vowelSubstrings += getVowelSubstring(word, substringStart, firstComplete, word.length() -1);
        }
        return vowelSubstrings;
    }

    private int getVowelSubstring(String word, int substringStart, int firstComplete, int end) {
        int total = 0;
        int[] vowelCount = new int[26];
        int vowels = 5;
        int left = firstComplete, right = firstComplete;
        int ch;
        for (; left <= firstComplete; left--) {
            ch = word.charAt(left) - 'a';
            if (vowelCount[ch]++ == 0) {
                vowels++;
            }
            if (vowels == 5) {
                total += (Math.max(1, left - substringStart) * Math.max(1, end - firstComplete));
                break;
            }
        }
        while (firstComplete <= end) {
            vowelCount[word.charAt(left) - 'a']--;
            left++;
            vowels--;
            while(vowels != 5) {
                firstComplete++;
                if (vowelCount[word.charAt(firstComplete)]++ == 0) {
                    vowels++;
                }
            }

            firstComplete++;
        }

        return total;
    }


    private int getBackwardsCount(String word, int start, int firstComplete, int[] foundVowels) {
        int left = 1;
        for (int i = start; i <= firstComplete - 5; i++) {
            if (foundVowels[word.charAt(i) - 'a'] == 1) {
                break;
            } else {
                foundVowels[word.charAt(i) - 'a']--;
                left++;
            }
        }
        return  left;
    }
}
