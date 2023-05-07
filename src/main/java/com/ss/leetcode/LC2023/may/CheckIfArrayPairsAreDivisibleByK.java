package com.ss.leetcode.LC2023.may;

public class CheckIfArrayPairsAreDivisibleByK {
    // https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k
    public boolean canArrange(int[] arr, int k) {
        int[] negativeModulo = new int[k];
        int[] positiveModulo = new int[k];
        calculateModulo(arr, k, negativeModulo, positiveModulo);
        return canPair(k, negativeModulo, positiveModulo);
    }

    private boolean canPair(int k, int[] negativeModulo, int[] positiveModulo) {
        if (positiveModulo[0] % 2 != 0) {
            return false;
        }
        boolean canArrange = true;
        for (int i = 1; i < k && canArrange; i++) {
            canArrange = findPair(i, k - i, negativeModulo, positiveModulo)
                && findPair(i, k - i, positiveModulo, negativeModulo);
        }
        return canArrange;
    }

    private boolean findPair(int i, int j, int[] modulo1, int[] modulo2) {
        if (modulo1[i] == 0) {
            return true;
        }
        int minToRemove = Math.min(modulo1[i], modulo1[j]);
        modulo1[i] -= minToRemove;
        modulo1[j] -= minToRemove;
        minToRemove = Math.min(modulo1[i], modulo2[i]);
        modulo1[i] -= minToRemove;
        modulo2[i] -= minToRemove;
        return modulo1[i] == 0;
    }

    private void calculateModulo(int[] arr, int k, int[] negativeModulo, int[] positiveModulo) {
        int modulo;
        for (int num : arr) {
            modulo = num % k;
            if (modulo < 0) {
                negativeModulo[-modulo]++;
            } else {
                positiveModulo[modulo]++;
            }
        }
    }
}
