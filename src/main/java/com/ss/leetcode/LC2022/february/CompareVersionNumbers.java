package com.ss.leetcode.LC2022.february;

public class CompareVersionNumbers {
    // https://leetcode.com/problems/compare-version-numbers/
    /** Algorithm
        1. Use two pointers i and j to traverse the two strings
        2. Also use two ints (ver1, ver2) to keep track of each number between the dots (.)
        3. while i < str1.length() OR j < str2.length()
            - traverse str1 with i (until the first dot) and use ver1 to multiply the numbers. Same for ver2.
            - if ver1 != ver2, return their comparison
            - else advance i and j (i and j have stopped over the dot (.))
        4. Return 0 by default.
     */
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int versionNumber1, versionNumber2;
        while (i < version1.length() || j < version2.length()) {
            versionNumber1 = versionNumber2 = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                versionNumber1 = versionNumber1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                versionNumber2 = versionNumber2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            if (versionNumber1 != versionNumber2) {
                return Integer.compare(versionNumber1, versionNumber2);
            }
            i++;
            j++;
        }
        return 0;
    }




    public int compareVersion2(String version1, String version2) {
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
