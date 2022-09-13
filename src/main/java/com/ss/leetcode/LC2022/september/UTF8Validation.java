package com.ss.leetcode.LC2022.september;

public class UTF8Validation {
    // https://leetcode.com/problems/utf-8-validation/
    /** Algorithm
        1. Create few helper methods:
            - toBinary(int val) -> returns the binary form of the int of length 8 (appending necessarily 0s)
            - isNBytesSegment(char[] segment) - checks if 1st char is 1 and second is 0
            - getNBytesLength(char[] segment) - tries to read how many significant 1s are in the segment.
            Return the number of significant 1s or -1 there are more than 4 1s (invalid utf-8)
        2. Putting these together, apply these steps
        3. For each int data, get toBinary form.
        4. If first char of binary form is 0, then increment index of data and continue
        5. If not, then get the number of nBytesLength (how many significant 1s)
            - if more than 4 OR the length + index exceeds the data index, then it is invalid. Break the loop, return false;
            - if less or equal to 4, loop from next index to the length of nBytes to check if each segment
              if utf-8 formatted (isNBytesSegment).If one is not formatted, return false;
            - if they are all formatted, increment the data index by nBytesLength.
        6. Return the validation status (should be true if the loop did not break)
     */
    public boolean validUtf8(int[] data) {
        boolean isValid = true;
        int index = 0, nBytesLength;
        while(isValid && index < data.length) {
            char[] binary = toBinary(data[index]);
            if (binary[0] != '0') {
                nBytesLength = getNBytesLength(binary);
                if (nBytesLength <= 0 || nBytesLength + index >= data.length) {
                    isValid = false;
                } else {
                    for (int i = 1; i <= nBytesLength; i++) {
                        isValid = isValid & isNBytesSegment(toBinary(data[index + i]));
                    }
                }
                index += nBytesLength + 1;
            } else {
                index++;
            }
        }
        return isValid;
    }

    private boolean isNBytesSegment(char[] bytes) {
        return bytes[0] == '1' && bytes[1] == '0';
    }


    private char[] toBinary(int value) {
        char[] unformattedBinary = Integer.toString(value, 2).toCharArray();
        char[] formattedBinary = new char[]{'0','0','0','0','0','0','0','0'};
        for (int fi = formattedBinary.length -1, ui = unformattedBinary.length -1; ui >= 0; ui--, fi--) {
            formattedBinary[fi] = unformattedBinary[ui];
        }
        return formattedBinary;
    }

    private int getNBytesLength(char[] bytes) {
        int index = 0;
        while(index < bytes.length && bytes[index] != '0') {
            index++;
        }
        return index <= 4 ? index-1 : -1;
    }
}
