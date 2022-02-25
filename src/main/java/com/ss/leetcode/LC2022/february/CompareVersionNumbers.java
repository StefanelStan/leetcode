package com.ss.leetcode.LC2022.february;

public class CompareVersionNumbers {
    // https://leetcode.com/problems/compare-version-numbers/
    public int compareVersion(String version1, String version2) {
        if (version1.length() == 1 && version2.length() == 1) {
            return Integer.compare(Integer.parseInt(version1), Integer.parseInt(version2));
        }
        int result = 0;
        int indexV1 = 0, indexV2 = 0;
        int rev1 = 0, rev2 = 0;
        while (indexV1 < version1.length() || indexV2 < version2.length()) {
            while(indexV1 < version1.length() && version1.charAt(indexV1) != '.') {
                rev1 = rev1 * 10 + version1.charAt(indexV1) - '0';
                indexV1++;
            }
            while(indexV2 < version2.length() && version2.charAt(indexV2) != '.') {
                rev2 = rev2 * 10 + version2.charAt(indexV2) - '0';
                indexV2++;
            }

            if (0 !=  (result = Integer.compare(rev1, rev2))) {
                break;
            }
            indexV1++;
            indexV2++;
            rev1 = 0;
            rev2 = 0;
        }
        return result;
    }
}
