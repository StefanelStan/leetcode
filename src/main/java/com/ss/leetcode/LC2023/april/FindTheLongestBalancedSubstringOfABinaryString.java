package com.ss.leetcode.LC2023.april;

public class FindTheLongestBalancedSubstringOfABinaryString {
    // https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string
    /** Algorithm
        1. Traverse the string and check current char, keeping track of number of 1s and 0s so far
        2. As rule states all 1s after 0, this means that a 0 will "reset" the previous known number of 1.
        3. Traverse the string checking each char/digit
        4. If current digit is 0, reset the number of known 1s and increment the number of known 0s
        5. If current digit is 1, increment the number of known 1s.
            Step 4 will take care of resetting the number of 1s each time there is a change in state
        6. At each step, set the longest/maxBalanced to be the max between longestBalanced
            and 2 * Math.min(numberOf1s, numberOf0s).
            - Why ?
            - 00011 3 of 0 and 2 of 1. => valid balanced string of length (2 + 2 - 2 0s and 2 1s).
            - 0011111 2 of 0 and 5 of 1. => valid of length 4 (2 0s and 2 1s).
            The Math.min(1s,0s) will ensure we always pick a correct even length substring
     */
    public int findTheLongestBalancedSubstring(String s) {
        int longestBalanced = 0, numberOfZero = 0, numberOfOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (numberOfOne > 0) {
                    numberOfZero = numberOfOne = 0;
                }
                numberOfZero++;
            } else {
                numberOfOne++;
            }
            longestBalanced = Math.max(longestBalanced, Math.min(numberOfOne, numberOfZero) * 2);
        }
        return longestBalanced;
    }
}
