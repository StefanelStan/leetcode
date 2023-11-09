package com.ss.leetcode.LC2023.november;

public class NumberOfSubstringsContainingAllThreeCharacters {
    // https://leetcode.com/problems/number-of-substrings-containing-all-three-characters
    /** Algorithm
        1. Use 2 pointers: left and right and a SubstringWindow object to keep track of
            your chars status: if you have all 3 and how many of each.
        2. Move right pointer until your window has all 3 chars or right reaches s.length()
            - If your window has 3 chars, then all substrings [left, right], [left, right+1]..
            [left, s.length() - 1] will have 3 chars. Add them 1 + s.length() -  right;
        3. Move left to the right (increment) while your window has all 3 chars (so move your left pointer
            until your window is not good anymore)
            - While moving, your current substring might still be valid:
            EG: aaaaaabc.
            - left = 0, right = 7 => 1 substring
            - left = 1, right = 7 => this substring is valid as well!
            - left = 2, right = 7 => valid substring
        4. Stop when right reaches s.length();
     */
    public int numberOfSubstrings(String s) {
        int left = 0, right = 0, totalSubstrings = 0;
        SubstringWindow window = new SubstringWindow();
        while (right < s.length()) {
            while (right < s.length() && !window.hasAllThree()) {
                window.addChar(s.charAt(right));
                right++;
            }
            if (window.hasAllThree()) {
                totalSubstrings += 1 + (s.length() - right);
            }
            while(left < right && window.hasAllThree()) {
                window.removeChar(s.charAt(left));
                if (window.hasAllThree()) {
                    totalSubstrings += 1 + (s.length() - right);
                }
                left++;
            }
        }
        return totalSubstrings;
    }

    private static final class SubstringWindow {
        int[] charCount;
        int presentChars;

        public SubstringWindow() {
            charCount = new int[3];
        }

        public void addChar(char ch) {
            if (charCount[ch - 'a']++ == 0) {
                presentChars++;
            }
        }

        public void removeChar(char ch) {
            if (charCount[ch - 'a']-- == 1) {
                presentChars--;
            }
        }

        public boolean hasAllThree() {
            return presentChars == 3;
        }
    }
}
