package com.ss.leetcode.LC2021.july;

public class ThreeEqualParts {
    // https://leetcode.com/problems/three-equal-parts/
    /** Algorithm
        1. We need to focus on number of 1s. The 3 segments must have the same number of 1s.
            - Count number of 1s. If the count is not divisible by 3, return [-1,-1]
        2. If the count if 0, [0,0...0] then just return an array[0, n-1] as you can pick the
            first and last elements : [0], [00.00], [0].
        3. Else you might have a partition
        4. Focus on finding the beginning and the end of each partition that starts and ends with an 1
            - EG: [0,0,1,0,1,0,1,0,1,0,1,0,1,0,0]
            - partition1: [2,4], partition2: [6,8], partition3: [10,12].
        4. We observe that there are 2 extra 0s after the end of last partition,
            thus, all partitions must be "extended" to make room for 2 extra 0s.
            thus, the partition1 needs to be [2,6] (4+2) , partition2: [6,10]
        5. We observe that extending partition 1 will overlap the start of partition2; thus we
            cannot partition, return [-1, -1]
        6. Supposing we have [0,0,1,0,1,0,1,0,1,0,1,0,1,0] -> just 1 extra 0 after the last 1
            - point i,j,k at the start of each partition and check if they match EXACTLY.
            - if no, return [-1,-1]
            - if yes, return [endOfPartition1 + extraZero, endOfPartition2 + extraZero +1]
     */
    public int[] threeEqualParts(int[] arr) {
        int oneCount = 0;
        for (int num : arr) {
            oneCount += num;
        }
        if (oneCount == 0) {
            return new int[]{0, arr.length -1};
        } else if (oneCount % 3 != 0) {
            return new int[]{-1, -1};
        }
        // it is possible here
        return findParts(oneCount, arr);
    }

    private int[] findParts(int oneCount, int[] arr) {
        int firstStart = -1, firstStop = -1;
        int secondStart = -1, secondStop = -1;
        int thirdStart = -1, thirdStop = -1;
        int endoffset, countOfOne = 0, oneThird = oneCount / 3;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                countOfOne++;
                if (countOfOne <= oneThird) {
                    firstStart = firstStart == -1 ? i : firstStart;
                    firstStop = i;
                } else if (countOfOne >= oneThird + 1 && countOfOne <= oneThird * 2) {
                    secondStart = secondStart == -1 ? i : secondStart;
                    secondStop = i;
                } else {
                    thirdStart = thirdStart == -1 ? i : thirdStart;
                    thirdStop = i;
                }
            }
        }
        endoffset = (arr.length - 1 - thirdStop);
        if (firstStop + endoffset >= secondStart || secondStop + endoffset >= thirdStart) {
            return new int[]{-1, -1};
        }
        for (int i = firstStart, j = secondStart, k = thirdStart; k < arr.length; i++, j++, k++) {
            if (arr[i] != arr[j] || arr[j] != arr[k]) {
                return new int[]{-1, -1};
            }
        }
        return new int[]{firstStop + endoffset, secondStop + endoffset + 1};
    }


    public int[] threeEqualParts2(int[] arr) {
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

    public int[] threeEqualParts3(int[] arr) {
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
