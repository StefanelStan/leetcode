package com.ss.leetcode.LC2021.july;

public class ThreeEqualParts {
    // https://leetcode.com/problems/three-equal-parts/
    public int[] threeEqualParts(int[] arr) {
        int count1s = 0;
        for (int number : arr) {
            if (number == 1) {
                count1s++;
            }
        }

        if (count1s % 3 != 0) {
            return new int[] { -1, -1 };
        }

        if (count1s == 0) {
            return new int[]{0, arr.length -1};
        }

        int index1 = 0, index2 = 0, index3 = 0;
        int track1 = 0;
        int third = count1s / 3;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                track1++;
                if (track1 == 1) {
                    index1 = i;
                } else if (track1 == third + 1) {
                    index2 = i;
                } else if (track1 == 2 * third + 1) {
                    index3 = i;
                }
            }
        }

        for (; index3 < arr.length; index1++, index2++, index3++) {
            if (arr[index1] != arr[index2] || arr[index2] != arr[index3]) {
                return new int[] { -1, -1 };
            }
        }
        return new int[] { index1 - 1, index2 };
    }

    public int[] threeEqualParts2(int[] arr) {
        for (int i = arr.length - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                int comparatorValue = compareArrays(arr, j, i - 1, i, arr.length - 1);
                if (comparatorValue == 1) {
                    break;
                }
                if (comparatorValue == 0 && 0 == compareArrays(arr, 0, j - 1, i, arr.length - 1)) {
                    return new int[] { j-1, i };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    private int compareArrays(int[] array, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        // if the two arrays are equal, the maxArray will be right. and min will be left.
        int leftLength = leftEnd - leftStart;
        int rightLength = rightEnd - rightStart;
        int difference = Math.abs(leftLength - rightLength);
        int startPoint = (leftLength > rightLength ? leftStart : rightStart);

        /* short circuit: compare the longest from the beginning. if 1, return the result
           0 0 1 | 1 0 0 1
                   1 0 1 0
         */ // diff is 3!
        for (int i = startPoint; i < startPoint + difference; i++) {
            if (array[i] == 1) {
                return i <= leftEnd ? 1 : -1;
            }
        }

        /* else compare the two arrays from the common chunk
            0 0 0 | 1 0 0 1 | 1 1 0 0
                  | 1 1 0 0
         */
        int shortI = startPoint == leftStart ? rightStart : leftStart;
        int longI = startPoint == leftStart ? leftStart + difference : rightStart + difference;
        for (int i = 0; i <= Math.min(leftLength, rightLength); i++) {
            if (array[i + shortI] > array[i + longI]) {
                return (i + shortI <= leftEnd ? 1 : -1);
            }
            if (array[i + shortI] < array[i + longI]) {
                return (i + longI <= leftEnd ? 1 : -1);
            }
        }
        return 0;
    }
}
