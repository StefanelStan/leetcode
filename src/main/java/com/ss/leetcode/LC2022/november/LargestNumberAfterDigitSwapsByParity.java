package com.ss.leetcode.LC2022.november;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumberAfterDigitSwapsByParity {
    // https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity
    public int largestInteger(int num) {
        if (num < 10) {
            return num;
        }
        char[] numDigits = String.valueOf(num).toCharArray();
        PriorityQueue<Character> oddDigits = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Character> evenDigits = new PriorityQueue<>(Comparator.reverseOrder());
        traverseAndSortDigits(numDigits, oddDigits, evenDigits);
        return getLargestInteger(numDigits, oddDigits, evenDigits);
    }

    private void traverseAndSortDigits(char[] digits, PriorityQueue<Character> oddDigits, PriorityQueue<Character> evenDigits) {
        for (char c : digits) {
            if ((c - '0') % 2 == 0) {
                evenDigits.add(c);
            } else {
                oddDigits.add(c);
            }
        }
    }

    private int getLargestInteger(char[] digits, PriorityQueue<Character> oddDigits, PriorityQueue<Character> evenDigits) {
        for(int i = 0; i < digits.length; i++) {
            if ((digits[i] - '0') % 2 == 0) {
                digits[i] = evenDigits.poll();
            } else {
                digits[i] = oddDigits.poll();
            }
        }
        return Integer.parseInt(new String(digits));
    }

    /** Algorithm
     1. Sort the chars of the num: eg: 31828 -> [1,2,3,8,8]
     2. Traverse the chars of num from i = 0 to length -1. Also, use two pointers (highestOddIndex, highestEvenIndex).
        You will use these to remember the last odd/even position that was visited so you can visit from those indices backwards.
     3. If current char at index[i] is even, replace it the highest even digit from the sortedDigits,
        passing the last known highestEvenIndex so you can search from there
     4. Same for Odd index
     5. Return the int value of the string described by the chars.
     */
    public int largestInteger2(int num) {
        if (num < 10) {
            return num;
        }
        char[] numDigits = String.valueOf(num).toCharArray();
        char[] sortedDigits = String.valueOf(num).toCharArray();
        Arrays.sort(sortedDigits);
        int oddIndex = numDigits.length -1;
        int evenIndex = oddIndex;
        boolean isEven;
        for (int i = 0; i < numDigits.length; i++) {
            isEven = (numDigits[i] - '0') % 2 == 0;
            if(isEven) {
                // remember the last evenIndex so you can search from there
                evenIndex = getHighestIndexOf(sortedDigits, evenIndex, isEven);
                numDigits[i] = sortedDigits[evenIndex];
                // remember to decrease the index so you won't add the same one over and over again
                evenIndex--;
            } else {
                oddIndex = getHighestIndexOf(sortedDigits, oddIndex, isEven);
                numDigits[i] = sortedDigits[oddIndex];
                oddIndex--;
            }
        }
        return Integer.parseInt(new String(numDigits));
    }

    private int getHighestIndexOf(char[] numDigits, int from, boolean moduloEquality) {
        while (from >= 0) {
            if (((numDigits[from] - '0') % 2 == 0) == moduloEquality) {
                return from;
            }
            from--;
        }
        return -1;
    }
}
