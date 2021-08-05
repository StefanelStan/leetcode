package com.ss.leetcode.august;

public class AddBinary {
    // https://leetcode.com/problems/add-binary/
    public String addBinary(String a, String b) {
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
