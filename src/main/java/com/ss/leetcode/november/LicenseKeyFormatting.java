package com.ss.leetcode.november;

public class LicenseKeyFormatting {
    // https://leetcode.com/problems/license-key-formatting/
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder stb = new StringBuilder();
        int kCount = 0;
        for (int i = s.length() -1; i>= 0; i--) {
            if (s.charAt(i) != '-') {
                stb.append(Character.toUpperCase(s.charAt(i)));
                kCount++;
                if (kCount == k) {
                    kCount = 0;
                    stb.append('-');
                }
            }
        }
        if (stb.length() > 0 && stb.charAt(stb.length() -1) == '-') {
            stb.deleteCharAt(stb.length() -1);
        }
        return stb.reverse().toString();
    }
}
