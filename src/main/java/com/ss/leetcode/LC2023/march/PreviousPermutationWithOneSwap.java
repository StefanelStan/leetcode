package com.ss.leetcode.LC2023.march;

import java.util.PriorityQueue;

public class PreviousPermutationWithOneSwap {
    // https://leetcode.com/problems/previous-permutation-with-one-swap
    public int[] prevPermOpt1(int[] arr) {
        // traverse from the back and for each i find the highest lowest element in array
        for (int i = arr.length -2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                int maxLowerPos = i+1;
                for (int k = i+1; k < arr.length; k++) {
                    if (arr[k] < arr[i] && arr[k] > arr[maxLowerPos]) {
                        maxLowerPos = k;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[maxLowerPos];
                arr[maxLowerPos] = temp;
                break;
            }
        }
        return arr;
    }

    public int[] prevPermOpt12(int[] arr) {
        // traverse from the back and for each i find the highest lowest element in array
        PriorityQueue<int[]> lowestNums = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        lowestNums.add(new int[]{arr[arr.length -1], arr.length -1});
        for (int i = arr.length -2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                int highestLowest = getHighestLowest(lowestNums, arr[i]);
                if(highestLowest != -1) {
                    int temp = arr[i];
                    arr[i] = arr[highestLowest];
                    arr[highestLowest] = temp;
                    break;
                }
            }
            lowestNums.add(new int[]{arr[i], i});
        }
        return arr;
    }

    private int getHighestLowest(PriorityQueue<int[]> lowestNums, int num) {
        int[] highestLowest = {-1,-1};
        while(!lowestNums.isEmpty() && lowestNums.peek()[0] < num) {
            highestLowest = lowestNums.poll();
        }
        return highestLowest[1];
    }

    public int[] prevPermOpt13(int[] arr) {
        // traverse from the back and for each i find the highest lowest element in array
        int[] lastNums = new int[10_001];
        lastNums[arr[arr.length -1]] = arr.length -1;
        for (int i = arr.length -2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                int highestLowest = getHighestLowest(lastNums, arr[i]);
                if(highestLowest != -1) {
                    int temp = arr[i];
                    arr[i] = arr[highestLowest];
                    arr[highestLowest] = temp;
                    break;
                }
            }
            lastNums[arr[i]] = i;
        }
        return arr;
    }

    private int getHighestLowest(int[] lastNums, int num) {
        for (int i = num -1; i>=0; i--) {
            if (lastNums[i] > 0) {
                return lastNums[i];
            }
        }
        return -1;
    }


}
