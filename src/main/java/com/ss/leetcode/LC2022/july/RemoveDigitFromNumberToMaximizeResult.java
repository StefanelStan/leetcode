package com.ss.leetcode.LC2022.july;

public class RemoveDigitFromNumberToMaximizeResult {
    // https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
    /** Algorithm/Theory
     Theory:
         - Right from beginning, traverse the string and inspect each digit. If it matches the given digit, check its immediate neighbour.
         - Ignore the next neighbour if it's the same given digit. 552 5 : removing first 5 will give 52, same as removing 2nd 5.
         Thus, the revevant digit is the next different neighbour digit.
         1. The best outcome is when you find the first an immediate digit higher than the given one.
         EG: "7462782791" "7".
         In this case, we can see that if we remove 2nd 7, the next digit 8 is greater and this will give the max possible number.
         If such situation is encountered, substring it and return it immediately
         2. However, there might be cases when no such higher digit is found, and all the remaing immediate digits are lesser or equal.
         In this case, removing any digit will cause a smaller number, as the digit will be replaced by a smaller one
         EG: "7462752761", "7"
         As we can see, all immediate digits of 7 are 4,5,6. All of them are smaller and will cause a decrease of number.
         Mathematically, we can to remove the last encountered 1,
     Algorithm:
         1. Traverse the string and keep an index of last position where given digit is encountered.
         2. If current digit == givenDigit and next one is greater than diven digit, you found the answer. Substring it.
         3. If not returned from #1 & #2, check if lastIndex has been set. If not, it means only the last char is the digit, so substring
         from 0 to n-1.
         4. If not returned from #3, it means we need to substring from 0 to lastPoistion + lastPosition +1,
         so bascially substringing the last position of the digit.
     */
    public String removeDigit(String number, char digit) {
        int last = -1;
        char[] chrs = number.toCharArray();
        for (int i = 0; i < chrs.length - 1; i++) {
            if (chrs[i] == digit) {
                last = i;
                if (chrs[i + 1] > digit) {
                    return number.substring(0, i) + number.substring(i + 1);
                }
            }
        }
        // if nothing found, the last one is to be removed
        if (last == -1) {
            return number.substring(0, chrs.length -1);
        }
        if (chrs[chrs.length -1] == digit) {
            last = chrs.length - 1;
        }
        return number.substring(0, last) + number.substring(last + 1);
    }
}
