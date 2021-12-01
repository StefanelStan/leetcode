package com.ss.leetcode.LC2021.september;

import java.util.Arrays;

public class ReformatPhoneNumber {
    // https://leetcode.com/problems/reformat-phone-number/
    public String reformatNumber(String number) {
        char[] charsOnly = new char[number.length()];
        int index = 0;
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                charsOnly[index++] = number.charAt(i);
            }
        }
        if (index <= 3) {
            return new String(Arrays.copyOf(charsOnly, index));
        }

        char[] phoneNumber = new char[index * 2];
        int remainder = index % 3;
        int stopIndex = switch (remainder) {
            case 0 -> index;
            case 2 -> index - 2;
            default -> index - 4 < 3 ? 0 : index - 4;
        };
        int phoneIndex = 0, charIndex =0;
        while (charIndex < stopIndex) {
            phoneNumber[phoneIndex] = charsOnly[charIndex];
            phoneNumber[phoneIndex + 1] = charsOnly[charIndex + 1];
            phoneNumber[phoneIndex + 2] = charsOnly[charIndex + 2];
            phoneNumber[phoneIndex + 3] = '-';
            phoneIndex += 4;
            charIndex += 3;
        }
        while (charIndex < index) {
            phoneNumber[phoneIndex] = charsOnly[charIndex];
            phoneNumber[phoneIndex+1] = charsOnly[charIndex+1];
            phoneNumber[phoneIndex+2] = '-';
            phoneIndex += 3;
            charIndex += 2;
        }

        return new String(Arrays.copyOf(phoneNumber, phoneIndex -1));
    }
}
