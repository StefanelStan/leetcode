package com.ss.leetcode.july;

public class LargestNumberAfterMutatingSubstring {
    // https://leetcode.com/contest/weekly-contest-251/problems/largest-number-after-mutating-substring/
    public String maximumNumber(String num, int[] change) {
        char[] result = new char[num.length()];
        boolean mutatedOnce = false, mutating = false;
        for (int i = 0; i < num.length(); i++) {
            int numValue = Integer.parseInt(String.valueOf(num.charAt(i)));
            if (!mutatedOnce) {
                if (numValue < change[numValue]) {
                    mutating = true;
                    result[i] = Character.forDigit(change[numValue], 10);
                } else {
                    if(numValue == change[numValue]) {
                        result[i] = num.charAt(i);
                    } else if (mutating) {
                        mutatedOnce = true;
                    }
                    result[i] = num.charAt(i);
                }
            } else {
                result[i] = num.charAt(i);
            }
        }
        return new String(result);
    }

}
