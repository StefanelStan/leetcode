package com.ss.leetcode.LC2021.january;

import java.util.concurrent.CompletableFuture;

public class LongestTurbulentSubarray {
    // https://leetcode.com/problems/longest-turbulent-subarray/
    public int maxTurbulenceSize(int[] arr) {
        try {
            CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> getRuleOneMaxTurbulent(arr));
            CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> getRuleTwoMaxTurbulent(arr));

            CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);

            combinedFuture.get();
            return Math.max(future1.get(), future2.get()) + 1;
        } catch (Exception e) {
            return -1;
        }
    }

    private Integer getRuleOneMaxTurbulent(int[] arr) {
        int max = 0;
        boolean isTurbulentMode = false;
        int currentLength = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 1) {
                if (arr[i] > arr[i + 1]) {
                    if (!isTurbulentMode) {
                        isTurbulentMode = true;
                    }
                    currentLength++;
                } else {
                    isTurbulentMode = false;
                    max = Math.max(max, currentLength);
                    currentLength = 0;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    if (!isTurbulentMode) {
                        isTurbulentMode = true;
                    }
                    currentLength++;
                } else {
                    isTurbulentMode = false;
                    max = Math.max(max, currentLength);
                    currentLength = 0;
                }
            }
        }
        return Math.max(max, currentLength);
    }

    private Integer getRuleTwoMaxTurbulent(int[] arr) {
        int max = 0;
        boolean isTurbulentMode = false;
        int currentLength = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 1) {
                if (arr[i] < arr[i + 1]) {
                    if (!isTurbulentMode) {
                        isTurbulentMode = true;
                    }
                    currentLength++;
                } else {
                    isTurbulentMode = false;
                    max = Math.max(max, currentLength);
                    currentLength = 0;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    if (!isTurbulentMode) {
                        isTurbulentMode = true;
                    }
                    currentLength++;
                } else {
                    isTurbulentMode = false;
                    max = Math.max(max, currentLength);
                    currentLength = 0;
                }
            }
        }
        return Math.max(max, currentLength);
    }
}
