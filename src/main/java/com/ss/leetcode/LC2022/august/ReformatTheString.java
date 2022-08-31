package com.ss.leetcode.LC2022.august;

public class ReformatTheString {
    /** Algorithm
     ** note: it is possible to only utilize the same char[] answer to swap and return the String, but this will complicate the logic too much, thus, for clarity, I used two different arrays.
        1. Store digits and letters into two separate char[] of size len/2 (+1 if odd length)
        2. Traverse s and use 2 indexes, digitIndex and letterIndex to store each char into its correct
            index on array of letters or digits.
        3. If at any step the digitIndex or letterIndex overgrows, it means there are more than half
            digits or letters, so return "";
        4. Now you have two buckets: one for chars and one for letters; add then into the target array
            alternatively. Pay attention to start with the longest one first
            eg: [a,b,c], [1,2,3,4]. As we see, 4 digits and 3 chars, so digit has to come first.
     */
    public String reformat(String s) {
        int half = s.length() / 2;
        if (s.length() % 2 == 1) {
            half++;
        }
        char[] digits = new char[half];
        char[] letters = new char[half];
        int dIndex = 0, lIndex = 0;
        for(char c : s.toCharArray()) {
            if (c >= 'a') {
                if(lIndex >= half) {
                    return "";
                } else {
                    letters[lIndex++] = c;
                }
            } else {
                if (dIndex >= half) {
                    return "";
                } else {
                    digits[dIndex++] = c;
                }
            }
        }
        return new String(alternateChars(digits, letters, dIndex, lIndex));
    }

    private char[] alternateChars(char[] digits, char[] letters, int dIndex, int lIndex) {
        // two char[] of same length but one of them might have 1 char less than the other.
        // in this case, we want to start with the longest one first
        char[] first = dIndex >= lIndex ? digits : letters;
        char[] last = lIndex <= dIndex ? letters : digits;
        char[] result = new char[dIndex + lIndex];
        for (int rI = 0, fI = 0, lI = 0; rI < dIndex + lIndex; rI++) {
            // even position? (eg 0) add first/longest chars array, odd position, add the other one
            result[rI] = rI % 2 == 0 ? first[fI++] : last[lI++];
        }
        return result;
    }
}
