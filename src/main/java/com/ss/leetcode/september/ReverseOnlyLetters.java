package com.ss.leetcode.september;

public class ReverseOnlyLetters {
    // https://leetcode.com/problems/reverse-only-letters/
    public String reverseOnlyLetters(String s) {
        char[] reverse = new char[s.length()];
        int low = 0, high = s.length() -1;
        while (low <= high) {
            while(low <= high) {
                if (!isLetter(s.charAt(low))) {
                    reverse[low] = s.charAt(low);
                    low++;
                } else {
                    break;
                }
            }
            while(low <= high) {
                if (!isLetter(s.charAt(high))) {
                    reverse[high] = s.charAt(high);
                    high--;
                } else {
                    break;
                }
            }

            if(low <= high) {
                reverse[low] = s.charAt(high);
                reverse[high] = s.charAt(low);
                low++;
                high--;
            }
        }

        return new String(reverse);
    }

    private boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}
