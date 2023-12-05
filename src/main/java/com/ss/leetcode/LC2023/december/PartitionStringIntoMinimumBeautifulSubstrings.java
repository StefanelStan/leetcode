package com.ss.leetcode.LC2023.december;

public class PartitionStringIntoMinimumBeautifulSubstrings {
    // https://leetcode.com/problems/partition-string-into-minimum-beautiful-substrings
    /** Algorithm
        1. Use an Integer[] minBuilds to cache and count the minBuilds of powerOfFive for each index
        2. Use a recursive function that will start from given index until the end and will add each binary digit to the binaryIntNumber.
            - If binaryIntNumber is power of five, then try to see how many builds can be made past the current index
            - If the returned result is >= 0, then you have a positive sum. Determine its min.
            - If the returned if negative, then you can't build any power of 5 from that starting index.
        3. Return minBuilds[0].
     */
    public int minimumBeautifulSubstrings(String s) {
        Integer[] minBuilds = new Integer[s.length()];
        return findMinBeauty(0, s.toCharArray(), minBuilds);
    }

    private int findMinBeauty(int index, char[] digits, Integer[] minBuilds) {
        if (index >= digits.length) {
            return 0;
        }
        if (minBuilds[index] == null) {
            if (digits[index] == '0') {
                minBuilds[index] = -1;
            } else {
                minBuilds[index] = findMinBuildsFromIndex(index, digits, minBuilds);
            }
        }
        return minBuilds[index];
    }

    private int findMinBuildsFromIndex(int index, char[] digits, Integer[] minBuilds) {
        int binaryNumber = 0, min = 100, candidateBuild = -1;
        for (int i = index; i < digits.length; i++) {
            binaryNumber = binaryNumber * 2 + (digits[i] - '0');
            if (isPowerOfFive(binaryNumber)) {
                candidateBuild = findMinBeauty(i + 1, digits, minBuilds);
                if (candidateBuild >= 0) {
                    min = Math.min(min, 1 + candidateBuild);
                }
            }
        }
        return min == 100 ? -1 : min;
    }

    private boolean isPowerOfFive(int num) {
        int modulo = 0;
        while (modulo == 0 && num > 1) {
            modulo = num % 5;
            num = num / 5;
        }
        return num == 1 && modulo == 0;
    }
}
