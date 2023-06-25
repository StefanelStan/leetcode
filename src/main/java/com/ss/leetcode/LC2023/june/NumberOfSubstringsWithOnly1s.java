package com.ss.leetcode.LC2023.june;

public class NumberOfSubstringsWithOnly1s {
    // https://leetcode.com/problems/number-of-substrings-with-only-1s
    /** Algorithm
        1. Determine the length of each continuous 1 segment. Once you have it (eg:next char is 0)
            calculate the natural sum of 1 ..l of that segment.
            EG: 111 can form 1 segment of 3 1s, 2 segments of 2 and 3 segments of 1 => 1 + 2 + 3.
            Thus, l * (l+1) / 2. As an optimization, you can actually add each step (1,2,3) to
            the total length while traversing the string
        2. Traverse s and keep track of the lengths of a continuous 1s segment.
        3. If current char is 0, reset length to 0, else incremenent it
        4. After each char, add the current length to the totalLength
            EG: "111"
            i = 0 => total += 1;
            i = 1 => total += 2;
            i = 2 => total += 3
            => total = 6. (3 segments of 1, 2 of 2 and 1 of 3 elements)
     */
    public int numSub(String s) {
        long total = 0L;
        int sequenceLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sequenceLength++;
            } else {
                sequenceLength = 0;
            }
            total += sequenceLength;
        }
        return  (int)(total % 1_000_000_007);
    }
}
