package com.ss.leetcode.LC2021.may;

public class DecompressRunLengthEncodedList {
    // https://leetcode.com/problems/decompress-run-length-encoded-list/
    public int[] decompressRLElist(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i+=2) {
            size += nums[i];
        }
        int[] response = new int[size];
        int index = 0;
        for (int i = 0; i < nums.length; i+=2) {
            for (int j = index; j < index + nums[i]; j++) {
                response[j] = nums[i+1];
            }
            index += nums[i];
        }
        return response;
    }
}
