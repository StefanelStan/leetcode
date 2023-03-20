package com.ss.leetcode.LC2021.december;

public class CanPlaceFlowers {
    // https://leetcode.com/problems/can-place-flowers/
    /** Algorithm
     *  1. Starting from last position, check if n and n-1 are 0, if yes, plant a flower on n.
     *  2. Iterate from n-1 to 1 and if left == middle == right == 0, plant a flower in middle.
     *  3. If plants[0] == plants[1] == 0, plant a flower at index 0.
     *  4. Return the number of planted flowers. This number must by >= given number.
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        return countNumberOfFlowers(flowerbed) >= n;
    }

    private int countNumberOfFlowers(int[] flowerbed) {
        int possibleToPlant = 0;
        int n = flowerbed.length;
        if (n == 1) {
            return 1 - flowerbed[0];
        }
        if (flowerbed[n-1] == 0 && flowerbed[n-2] == 0) {
            flowerbed[n-1] = 1;
            possibleToPlant++;
        }
        for (int j = n -2; j >= 1; j--) {
            if (flowerbed[j+1] == 0 && flowerbed[j] == 0 && flowerbed[j-1] == 0) {
                flowerbed[j] = 1;
                possibleToPlant++;
            }
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            possibleToPlant++;
        }
        return possibleToPlant;
    }

    // Too Complicated Logic
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 0) {
            return false;
        }
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            return n == 1;
        }
        if (flowerbed.length == 2) {
            if (flowerbed[0] == 1 || flowerbed[1] == 1) {
                return false;
            } else {
                return n == 1;
            }
        }
        boolean underFlower = true;
        int firstFlower = 0;
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 1 && underFlower) {
                underFlower = false;
                if (firstFlower == 0 && i >= 2) {
                    n -= (i /2);
                } else if (i - firstFlower >= 3) {
                    n -= (( i - 1 - firstFlower) / 2);
                }
            } else if (!underFlower) {
                underFlower = true;
                firstFlower = i;
            }
        }

        if (underFlower && flowerbed.length - firstFlower >= 2) {
            if (firstFlower == 0) {
                n -= ((flowerbed.length + 1) /2) ;
            } else
                n -= (( flowerbed.length - firstFlower) / 2);
        }
        return n <= 0;
    }
}
