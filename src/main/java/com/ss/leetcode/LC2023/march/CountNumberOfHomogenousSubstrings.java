package com.ss.leetcode.LC2023.march;

public class CountNumberOfHomogenousSubstrings {
    // https://leetcode.com/problems/count-number-of-homogenous-substrings
    /** Algorithm
        1. Iterate over the chars and count the length of each homogenous substring (nr of consecutive chars)
        2. Once you found such length, determine how many substrings it can form
            eg: "aaaaa" ->
             - 5 substrings of length 1 (index 0,1,2,3,4),
             - 4 of length 2 (0,1), (1,2), (2,3),(3,4)
             - 3 of length 3 (0,1,2), (1,2,3), (2,3,4)
             - 2 of length 4 (0,1,2,3), (1,2,3,4)
             - 1 of length 5 (0,1,2,3,4)
            As we can see, the answer of the sum of first n numbers: n * (n+1) / 2: (5*6) / 2
        3. Determine the length of each homogenous, calculate the number of possible substring and add it
        4. Return the answer modulo.
     */
    public int countHomogenous(String s) {
        long count = 0L;
        long seqLength = 1;
        char prev = s.charAt(0), current;
        for (int i = 1; i < s.length(); i++) {
            current = s.charAt(i);
            if (prev == current) {
                seqLength++;
            } else {
                count += (seqLength * (seqLength + 1)) / 2;
                seqLength = 1;
            }
            prev = current;
        }
        count += (seqLength * (seqLength + 1)) / 2;
        return (int)(count % 1_000_000_007);
    }
}
