package com.ss.leetcode.LC2021.december;

public class CanPlaceFlowers {
    // https://leetcode.com/problems/can-place-flowers/
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
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
