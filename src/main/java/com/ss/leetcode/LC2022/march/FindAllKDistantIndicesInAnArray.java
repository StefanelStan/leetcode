package com.ss.leetcode.LC2022.march;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {
    // https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
    /** Algorithm eg; [3,4,9,1,3,9,5] key =9, k =1
         1. Traverse the array and store the positions of each key. keyPos = [2,5]
         2. Iterate over the array again and for each index i, find the shorest distance to the closest keyIndex in keyPos
         3. As this is an iterative process, i will go from 0 to n, and so will keyPos index will go from 0 to m.
         Thus, if we know that the keyPos index is 0, we will only look & compare against keyPos[1], returning the
         min abs between (i-keyPos[0] and i-keyPos[1]).
         If the 2nd one is closest, then the keyPos gets adjusted accordingly.
         EG: i = 0 => closest key can be abs (0-2) and abs(0-5). as it's first one, keyPos stays the same
         i = 4 => abs(4-2) and abs(4-5). As the 2nd one is closest, keyPos moves to the next pos [1].
         4. Operate the logic of #3 for each index of nums. If the closest distance <=k, add it to answer.
     */
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyPositions = new ArrayList<>();
        List<Integer> kDistantIndices = new ArrayList<>();
        int[] keyPosIndex = {0};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyPositions.add(i);
            }
        }
        if (!keyPositions.isEmpty()) {
            for (int i = 0; i < nums.length; i++) {
                if (getClosestDistance(i, keyPositions, keyPosIndex) <= k) {
                    kDistantIndices.add(i);
                }
            }
        }
        return kDistantIndices;
    }

    private int getClosestDistance(int i, List<Integer> keyPositions, int[] keyPosIndex) {
        // if the current key index is at the end of list of key positions, return immediately
        if (keyPosIndex[0] == keyPositions.size() -1) {
            return Math.abs(i - keyPositions.get(keyPosIndex[0]));
        }
        // compare current keyIndex with nextOne. Adjust it if next one is closest.
        if (Math.abs(i - keyPositions.get(keyPosIndex[0])) >= Math.abs(i - keyPositions.get(keyPosIndex[0] + 1))) {
            keyPosIndex[0]++;
        }
        return Math.abs(i - keyPositions.get(keyPosIndex[0]));
    }
}
