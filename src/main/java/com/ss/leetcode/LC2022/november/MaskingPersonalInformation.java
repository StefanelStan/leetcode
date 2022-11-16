package com.ss.leetcode.LC2022.november;

public class MaskingPersonalInformation {
    // https://leetcode.com/problems/masking-personal-information
    /** Algorithm
         1. Have two methods that will deal with phone number of email
         2. Email method
            - traverse from left to right and detect where @ index is.
            - Declare a StringBuilder of size 7 + length - index + 1.
            - append lowercase first char, 5 x *, lowercase index -1
            - append the rest from index until the end
         3. Phone number method :for efficiency and logic, traverse backwards and add the digits in
            A stirngBuilder in reverse order. At the end just reverse the builder and return it
         4. Have a method that will deal with localNumber and one to deal with countryCode
         5. localNumber: as improvement, make this method return the last index operated on, so you can use it further on countryCode
            - start from the back and add the digits. If StringBuilder has a length of 4 or 8, add the - sign
            - if your current char is digit and length < 4, add the digit, else add the * sign
         6. CountryCode: declare and return a stringbuilder that will hold the country code
            - continue from the localNumber index.
            - if your current char is a digit, add * sign.
            - at the end, if your stringbuilder is not empty, add the + sign
         7. If the countryCode is not empty, add - and countryCode at the localNumber stringBuilder
         8. Return the reverse.
     */
    public String maskPII(String s) {
        char[] chars = s.toCharArray();
        if (Character.isLetter(chars[0])) {
            return maskEmail(chars);
        } else {
            return maskPhoneNumber(chars);
        }
    }

    private String maskEmail(char[] chars) {
        int atIndex = 0;
        while(chars[atIndex] != '@') {
            atIndex++;
        }
        StringBuilder stb = new StringBuilder(7 + chars.length - atIndex + 1);
        stb.append(toLowerCase(chars[0]));
        stb.append("*****");
        stb.append(toLowerCase(chars[atIndex - 1]));
        stb.append('@');
        while(++atIndex < chars.length) {
            stb.append(toLowerCase(chars[atIndex]));
        }
        return stb.toString();
    }

    private String maskPhoneNumber(char[] chars) {
        StringBuilder stb = new StringBuilder();
        int localNumberIndex = appendLocalNumber(stb, chars);
        String cc = getCountryCode(chars, localNumberIndex);
        if (cc.length() > 0) {
            stb.append('-');
            stb.append(cc);
        }
        return stb.reverse().toString();
    }

    private int appendLocalNumber(StringBuilder stb, char[] chars) {
        int index = chars.length - 1;
        while(stb.length() != 12) {
            if (stb.length() == 4 || stb.length() == 8) {
                stb.append('-');
            }
            if (chars[index] >= '0' && chars[index] <= '9') {
                stb.append(stb.length() > 4 ? '*' : chars[index]);
            }
            index--;
        }
        return index;
    }

    private String getCountryCode(char[] chars, int end) {
        StringBuilder stb = new StringBuilder();
        while(end >= 0) {
            if (chars[end] >= '0' && chars[end] <= '9') {
                stb.append('*');
            }
            end--;
        }
        if(!stb.isEmpty()) {
            stb.append('+');
        }
        return stb.toString();
    }

    private char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char)(ch + 32);
        } else {
            return ch;
        }
    }
}
