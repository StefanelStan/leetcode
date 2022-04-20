package com.ss.leetcode.LC2021.august;

public class AddBinary {
    // https://leetcode.com/problems/add-binary/
    /** Algorithm
         1. Determine which of the two strings is longer in order to use it to store the result.
         2. Determine a view window between the length of the two strings. EG: a: 110110 b = 101.
            First string has a length of 6 while second has a length of 3.
            Thus, we will add second string to first string from position 2 -> 0 of 2nd string over positions 5->3 of 1st string
         3. After doing this, continue adding the carryOver to the remamining chunk/view of the long string:
            Eg: from position 2 -> 0 (6 - 3 - 1  -> 0). Also remember to carry the carryOver digit (if any).
         4. If the final carryOver is 1, '1' needs to be added in front of longString.
            If carryOver is 0, then return the longString
     */
    public String addBinary(String a, String b) {
        char[] shortString = a.length() < b.length() ?  a.toCharArray() : b.toCharArray();
        char[] longString = a.length() >= b.length() ? a.toCharArray() : b.toCharArray();
        int carryOver = 0, result;
        for (int i = shortString.length -1, j = longString.length -1; i >=0; i--, j--) {
            result = (longString[j] - '0') + (shortString[i] - '0') + carryOver;
            if (result > 1) {
                longString[j] = (char)(result -2 + '0');
                carryOver = 1;
            } else {
                longString[j] = (char)(result + '0');
                carryOver = 0;
            }
        }

        for(int j = longString.length -1 - shortString.length; j >= 0; j--) {
            result = (longString[j] - '0') + carryOver;
            if (result > 1) {
                longString[j] = (char)(result -2 + '0');
                carryOver = 1;
            } else {
                longString[j] = (char)(result + '0');
                carryOver = 0;
            }
        }
        return carryOver == 0 ? new String(longString) : "1" + new String(longString);
    }

    public String addBinary2(String a, String b) {
        String strMin = a.length() < b.length() ? a : b;
        String strMax = a.length() < b.length() ? b : a;
        StringBuilder stb = new StringBuilder();
        boolean carriedOver = false;
        // start adding from the back for a length equal to minStrength, paying attention to a carryover.
        for (int minIndex = strMin.length() -1, maxIndex = strMax.length() - 1; minIndex >=0; minIndex--, maxIndex--) {
            carriedOver = addUpAndReturnCarriedOver(strMin, minIndex, strMax, maxIndex, stb, carriedOver);
        }
        // once done with the shortes string, continue with the longest one, paying attention to carryover
        for (int maxIndex = strMax.length() - strMin.length() -1; maxIndex >= 0; maxIndex--) {
            if(strMax.charAt(maxIndex) == '1' && carriedOver) {
                stb.append('0');
            } else {
                stb.append(carriedOver ? '1' : strMax.charAt(maxIndex));
                carriedOver = false;
            }
        }
        // if we have a carryover, it means we need to add 1 in the front of the new resulting string
        if (carriedOver) {
            stb.append('1');
        }
        // return reverse as we started adding from the back, putting them in the string builder.
        return stb.reverse().toString();
    }

    private boolean addUpAndReturnCarriedOver(String strMin, int min, String strMax, int max, StringBuilder stb, boolean carriedOver) {
        if (strMin.charAt(min) == '1' && strMax.charAt(max) == '1') {
            stb.append(carriedOver ? '1' : '0');
            return true;
        }
        if (strMin.charAt(min) != strMax.charAt(max)) {
            stb.append(carriedOver ? '0' : '1');
            return carriedOver;
        } else {
            stb.append(carriedOver ? '1' : '0');
            return false;
        }
    }
}
