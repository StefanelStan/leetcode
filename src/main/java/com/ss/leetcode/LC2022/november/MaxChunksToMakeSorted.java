package com.ss.leetcode.LC2022.november;

public class MaxChunksToMakeSorted {
    // https://leetcode.com/problems/max-chunks-to-make-sorted
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0, maxSoFar = -1;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            if (maxSoFar == i) {
                chunks++;
            }
        }
        return chunks;
    }

    /** Algorithm
         [0,1,4,2,3,5]
        1. Loop from i 0 to n and check:
        - If the current element is equal to its index index, then it can be a solo fragment (0,1) => 2 solo fragments of size 1
        - If not, then check where that element sits:
        - i = 2: 2 sits at position [3] so we need to loop till there
        - i = 3: 3 sits at pos[4], so we need to loop till there
        - i = 4; 4 sits at pos[2], which we have already passed. So
        -  from index[2] until index[4] we have elements that are all situated on the left or equal to position[4]. This makes a segment.
        - i = 5. at 5 we have 5, it's already sorted so a solo segment of 1.
      2. So we have a total of 4 segments of size 1,1,3,1
     */
    public int maxChunksToSorted2(int[] arr) {
        int maxChunks = 0;
        int[] pos =  new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pos[arr[i]] = i;
        }
        for (int i = 0; i < arr.length;) {
            if (arr[i] == i) {
                i++;
            } else {
                i = getNextWholeChunkSize(arr, pos, i) + 1;
            }
            maxChunks++;
        }
        return maxChunks;
    }

    private int getNextWholeChunkSize(int[] arr, int[] pos, int i) {
        int maxLength = i+1;
        for (int k = i; k <= maxLength; k++) {
            maxLength = Math.max(pos[k], maxLength);
        }
        return maxLength;
    }
}
