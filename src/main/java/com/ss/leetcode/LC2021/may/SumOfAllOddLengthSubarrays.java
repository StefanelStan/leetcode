package com.ss.leetcode.LC2021.may;

public class SumOfAllOddLengthSubarrays {
    // https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
    public int sumOddLengthSubarrays(int[] arr) {
        int[] sumFromLeft = new int[arr.length];
        int[] sumFromRight = new int[arr.length];
        sumFromLeft[0] = arr[0];
        sumFromRight[arr.length -1] = arr[arr.length -1];
        for (int i = 1, j = arr.length - 2; i < arr.length; i++, j--) {
            sumFromLeft[i] = sumFromLeft[i-1] + arr[i];
            sumFromRight[j] = sumFromRight[j+1] + arr[j];
        }

        int sum = sumFromRight[0];
        int currentJump = 3;
        while (currentJump < arr.length) {
            sum += sumFromLeft[currentJump-1];
            for (int i = 1; i + currentJump <= arr.length;  i++) {
                sum += sumFromRight[0] - (sumFromLeft[i-1] + (i + currentJump == arr.length ? 0 : sumFromRight[i + currentJump]));
            }
            currentJump += 2;
        }
        if (currentJump == arr.length) {
            sum+= sumFromRight[0];
        }
        return sum;
    }
}
