package com.ss.leetcode.LC2023.november;

public class FindTheLongestSemiRepetitiveSubstring {
    // https://leetcode.com/problems/find-the-longest-semi-repetitive-substring
    /** Algorithm
        1. Traverse the string and keep 2 pointers: start for the start of a semi-repetitive window
            and firstRepetitive - the left index of a repetitive pair of digits
        2. We are allowed to have 1 repetitive pair in string, so we could have smth like "23123345"
            - start will be 0, firstRepetitive = 4, the left index of pair [3,3]
        3. When we encounter another repetitive pair and we already have 1 pair (firstRepetitive != -1)
            then we need to shift the start of the window to the next index of firstRepetitive
            - EG: "231233456778"
            - at index 9 : start = 0, firstRepetitive = 4 (the pair [3,3]). Window length = 1 + 9 - 0 =10.
            - at index 10: we encounter the 2nd 7, so we have another pair. However, our index firstRepetitive is @ 4.
            - thus, we need to exclude it, so we move the left edge of the window on index 5.
            - start = 5. Now, the firstRepetitive is shifted at index 9, as index [9,10] form up our new pair
            inside the window.
        5. With each step, retain the longest window size.
     */
    public int longestSemiRepetitiveSubstring(String s) {
        int start = 0, firstRepetitive = -1, longest = 1;
        char prevChar = 0, currentChar;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (currentChar == prevChar) {
                if (firstRepetitive == -1) {
                    firstRepetitive = i - 1;
                } else {
                    start = firstRepetitive + 1;
                    firstRepetitive = i - 1;
                }
            }
            prevChar = currentChar;
            longest = Math.max(longest, 1 + i - start);
        }
        return longest;
    }
}
