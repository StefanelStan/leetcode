package com.ss.leetcode.LC2025.january;

public class MinimumOperationsToMakeASpecialNumber {
    // https://leetcode.com/problems/minimum-operations-to-make-a-special-number
    /** Algorithm
        1. For your number to be special you need to know if you can have a certain number of digit combinations
            - if your current digit is 0 or 5, then you need to know if you have a 0 (a00 % 25 == 0 / a50 % 25 == 0).
            - if your curr digit is 2 or 7, you need to know if you have a 5 (a25 % 25 == 0 / a75 % 25 == 0)
            - if any of these cases happen, then you need to keep just digits until current index + 1. (eliminate n - (i + 2))
        2. Use a boolean[10] to mark the seen digits. Return if any of the combination above exist
        3. At the end, if you have a 0, then all other digivts can be removed, else you need to remove ALL to end up with 0.
     */
    public int minimumOperations(String num) {
        boolean[] seen = new boolean[10];
        int codePoint;
        for (int i = num.length() - 1; i >= 0; i--) {
            codePoint = num.charAt(i) - '0';
            if (isSpecial(codePoint, seen)) {
                return num.length() - (i + 2);
            }
            seen[codePoint] = true;
        }
        return seen[0] ? num.length() -1 : num.length();
    }

    private boolean isSpecial(int codePoint, boolean[] seen) {
        return switch(codePoint) {
            case 0, 5 -> seen[0];
            case 2, 7 -> seen[5];
            default -> false;
        };
    }
}
