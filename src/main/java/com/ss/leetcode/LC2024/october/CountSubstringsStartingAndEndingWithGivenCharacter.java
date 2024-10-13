package com.ss.leetcode.LC2024.october;

public class CountSubstringsStartingAndEndingWithGivenCharacter {
    // https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character
    /** Algorithm
        1. Supposing you have the chars c1, c2, c3, c4, c5 that match the given character from a string.
            - c1 will make 1 subtring of length 1 (c1 itself), 1 substring of length 2 (c1-c2), 1 sinstring of length 3 (c1-c3),
                .. and 1 subtr of length 5(c1-c5). (5 in total)
            - c2 will make 1 subs lf length 2 (c2-c3), 1 length 3 and 1 length 4. => 4 in total
            - c3 -> 3 in total
            - c5 -> 1 in total
        2. We observe the answer is 5 + 4 + 3+ 2+ 1 = sum of first 5 numbers (n * (n+1) / 2).
        3. Count the occurances of given char and find the sum of first count numbers.
     */
    public long countSubstrings(String s, char c) {
        int chars = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c){
                chars++;
            }
        }
        return (long)chars * (chars+1) / 2;
    }
}
