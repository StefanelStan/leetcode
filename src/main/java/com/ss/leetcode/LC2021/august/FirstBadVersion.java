package com.ss.leetcode.LC2021.august;

public class FirstBadVersion {
    // https://leetcode.com/problems/first-bad-version
    public int firstBadVersion(int n) {
        int low = 1, high = n, pivot = n;
        boolean isBad = true;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            isBad = isBadVersion(pivot);
            if (isBad) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return isBad ? pivot : pivot + 1;
    }


    private int badVersion;
    public void setBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    private boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public int firstBadVersion2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return (isBadVersion(1) ? 1 : 2);
        }
        // n is max.
        int low = 1, high = n;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (high - low == -1) {
                break;
            }
            if (isBadVersion(pivot)) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }

        boolean lowBadVersion = isBadVersion(low);
        boolean highBadVersion = isBadVersion(high);
        if (low == high) {
            return lowBadVersion ? low : low + 1;
        }
        if (!lowBadVersion && highBadVersion) {
            return high;
        } else {
            return low;
        }
    }
}
