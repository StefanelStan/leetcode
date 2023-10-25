package com.ss.leetcode.LC2023.october;

public class CheckIfStringsCanBeMadeEqualWithOperationsII {
    // https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii
    /** Algorithm
        1. Looking at the rule that chars can be swapped ONLY if their index diff is even means that a char at index 1
            can only be swapped with another char at index 3,5,7 etc
        2. Same goes for positive indices: a char at index 4 can only be swapped with a char at index 0,2,6,8 etc.
        3. Looking at this rule, we understand that the index parity of s1 must match the index parity of s2
        4. Use an int[26][2] ([0] - even index, [1] - odd index)to map the parity of each digit on the s1
            - eg: "aabaacda" -> a is on index [0,4] - odd and [1,3,7] so parity[0] = {2,3} (2 even and 3 odd)
            - parity[1] (b) : {1,0} as b is present only at index 2
        5. Get the parity arrays of both strings and compare.
        6. For each letter, the even and odd values of string1 muct match the even/odd values of string2.
            If they do not match, return false. True otherwise.
     */
    public boolean checkStrings(String s1, String s2) {
        int[][] evenOddIndexCount = getEvenOddIndexCount(s1, s2);
        for (int[] count : evenOddIndexCount) {
            if (count[0] != count[2] || count[1] != count[3]) {
                return false;
            }
        }
        return true;
    }

    private int[][] getEvenOddIndexCount(String s1, String s2) {
        // [0,1] - even/Odd for string1, [2,3] - evenOdd for string2
        int[][] evenOddIndexCount = new int[26][4];
        int parityInsertColumn;
        for (int i = 0; i < s1.length(); i++) {
            parityInsertColumn = i % 2;
            evenOddIndexCount[s1.charAt(i) - 'a'][parityInsertColumn]++;
            evenOddIndexCount[s2.charAt(i) - 'a'][parityInsertColumn + 2]++;
        }
        return evenOddIndexCount;
    }
}
