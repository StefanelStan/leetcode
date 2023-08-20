package com.ss.leetcode.LC2023.august;

public class CountBinarySubstrings {
    // https://leetcode.com/problems/count-binary-substrings
    /** Algorithm
        1. Traverse the string and keep track of number of 0s and 1s.
        2. If current char == prev char, then increment number of 0s/1s (depending on char)
        3. If current != prev, then set the number of 0s/1s to 1 (depending) (the count resets after each char change)
        4. In order to count the substrings, you need to check if the opposite number of chars >= current char number.
            If your current char is 0, then your opposite chars are 1. Is number of 1s >= number of 0s?
            If yes, then increment number of substrings. This way you will avoid adding the same substring twice.
            - EG: 0001111
            - i = 3: numberOfZero = 3, numberOfOne = 1;
                - currentCharCount = 1, oppositeCharCount = 3. 3 >= 1 = > totalSubstrings++; (substirng 01)
            - i = 4; numberOfZero = 3, numberOfOne =2;
                - currentCharCount = 2, oppositeCharCount = 3. 3 >= 2 = > totalSubstrings++; (substirng 0011)
            - i  = 5; numberOfZero = 3, numberOfOne = 3
                - currentCharCount = 3, oppositeCharCount = 3. 3 >= 2 = > totalSubstrings++; (substirng 000111)
            - i = 6:  numberOfZero = 3, numberOfOne = 4
                - currentCharCount = 4, oppositeCharCount = 3. 3 IS NOT >= 4 = > totalSubstrings do not increase.
     */
    public int countBinarySubstrings(String s) {
        int totalSubstrings = 0;
        int zeroCount = 0, oneCount = 0, oppositeSignCount = 0, currentSignCount = 0;
        char prev = 0, current;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (current == '0') {
                zeroCount = prev == current ? zeroCount + 1 : 1;
                currentSignCount = zeroCount;
                oppositeSignCount = oneCount;
            } else {
                oneCount = prev == current ? oneCount + 1 : 1;
                currentSignCount = oneCount;
                oppositeSignCount = zeroCount;
            }
            if (oppositeSignCount >= currentSignCount) {
                totalSubstrings++;
            }
            prev = current;
        }
        return totalSubstrings;
    }
}
