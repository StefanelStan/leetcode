package com.ss.leetcode.LC2025.august;

public class FruitsIntoBasketsII {
    // https://leetcode.com/problems/fruits-into-baskets-ii
    /** Algorithm
        1. Set Unplaced Fruits to n
        2. For each fruit
            - Loop with i from 0 to n-1 over baskets and if basket size is >= current fruit, set basket to 0  and decrement unplaced fruits
        3. Return unplaced fruits
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = fruits.length;
        for (int fruit : fruits) {
            for (int i = 0; i < baskets.length; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    unplaced--;
                    break;
                }
            }
        }
        return unplaced;
    }
}
