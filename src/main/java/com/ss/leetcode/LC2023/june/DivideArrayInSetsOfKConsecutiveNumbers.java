package com.ss.leetcode.LC2023.june;

import java.util.Arrays;

public class DivideArrayInSetsOfKConsecutiveNumbers {
    // https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers
    /** Algorithm
     1. Fail fast:
     - if nums.length % k != 0 return false (cannot have complete groups of size k)
     - if k == 1, return true (you can have groups of size 1)
     2. You need to map the numbers to their count (how many 1s, how many 2s, how many 3s) etc.
     Sort and count/map the numbers. (1 -> 4, 2 -> 5, 3 -> 2, 4 -> 1 etc)
     3. In a sliding window technique (left, right index), open the window of size k with right pointer.
     If the number from group[right] - number from group[right-1] != 1 (not consecutive), return false
     4. The mapping of group[left] (how many numbers are under that group) will determine the height of the window:
     EG: 1 -> 3, 2 -> 3, 3 -> 1, 4 -> 2 and k = 3.
     The first number is 1 and we have 3 1s. This means that the whole sequence of length k (1,2,3)
     needs to have 3 of each (3 1s, 3 2s and 3 3s) so we can form 3 windows [1,2,3],[1,2,3],[1,2,3]
     But we observe that we only have 1 3 and we need 3 of them. thus, a sequence will be incomplete:
     [1,2,3], [1,2,missing_3] => return false
     5. If we encounter a group that has more elements than the window height (left pointer), the first
     such encounter will need to be the start of next sequence/window
     1->1, 2->1, 3->2, 4->2, 5->1, 6->1 k = 4.
     We observe that 3 has 2 elements, greater than the window height (left pointer is at 1).
     Thus next window must start from position 3.
     [1,2,3,4], [3,4,5,6]
     6. Return true by default, if #4 and #5 have not returned false by now.
     */
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        if (k == 1) {
            return true;
        }
        int[][] groups = getNumberGroups(nums);
        int seqStart = 0, seqIncrease;
        while(seqStart < groups.length) {
            if (seqStart + k > groups.length) {
                return false;
            }
            seqIncrease = seqStart;
            for (int i = seqStart + 1; i < seqStart + k; i++) {
                // if groups are not consecutive OR their size is less than sequence start size/height
                if (groups[i][0] - groups[i-1][0] != 1 || groups[i][1] < groups[seqStart][1]) {
                    return false;
                }
                // if current index has more elements than the current window height, means the first such index
                // will have to be the start of next window
                // EG: 1 -> 2, 2-> 2, 3->4, 4->1 , k = 3.
                // we remove the 2 1s, the 2 2s and the 2 3s, remaining 1 3. This 3 will have to be the start of next
                // sequence
                if (groups[i][1] > groups[seqStart][1] && seqIncrease == seqStart) {
                    seqIncrease = i;
                }
                groups[i][1] -= groups[seqStart][1];
            }
            seqStart = seqStart == seqIncrease ? seqStart + k : seqIncrease;
        }
        return true;
    }

    private int[][] getNumberGroups(int[] nums) {
        Arrays.sort(nums);
        int unique = 0, prev = -1;
        for (int num : nums) {
            if (num != prev) {
                unique++;
            }
            prev = num;
        }
        // [value, count]
        int[][] groups = new int[unique][2];
        int insertIndex = -1;
        prev = -1;
        for (int num : nums) {
            if (num != prev) {
                insertIndex++;
                groups[insertIndex][0] = num;
                groups[insertIndex][1] = 1;
            } else {
                groups[insertIndex][1]++;
            }
            prev = num;
        }
        return groups;
    }
}
