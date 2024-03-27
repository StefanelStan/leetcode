package com.ss.leetcode.LC2022.april;

public class SubarrayProductLessThanK {
    // https://leetcode.com/problems/subarray-product-less-than-k/
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int total = 0, product = 1;
        int left = 0, right = 0;
        while (right < nums.length) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product = product / nums[left];
                left++;
            }
            total += 1 + right - left;
            right++;
        }
        return total;
    }


    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int subarrays =0;
        if (k != 0) {
            subarrays = countSubarrays(nums, k);
        }
        return subarrays;
    }

    private int countSubarrays(int[] nums, int k) {
        int left = 0, right = 0;
        int[] partialProduct = {1};
        int subarrays = 0;
        while(left < nums.length) {
            right = getRight(nums, partialProduct, k, right);
            if (right >= nums.length -1) {
                subarrays += getSumOf(nums.length - left);
                break;
            }
            if (right > left || (right == left && nums[right] <= k)) {
                subarrays += (right - left + 1);
            }
            if (left >= right) {
                left++;
                right = left;
                partialProduct[0] = 1;
            } else {
                partialProduct[0] = partialProduct[0] / nums[left];
                left++;
                right = Math.min(right +1, nums.length -1);
            }
        }
        return subarrays;
    }

    private int getRight(int[] nums, int[] partialProduct, int k, int startRight) {
        while(startRight < nums.length) {
            partialProduct[0] *= nums[startRight];
            if (partialProduct[0] >= k) {
                partialProduct[0] = partialProduct[0] / nums[startRight];
                return startRight -1;
            }
            startRight++;
        }
        return Math.min(startRight, nums.length -1);
    }

    private int getSumOf(int n) {
       int sum = (1 + n) * (n/2);
       if (n % 2 == 1) {
           sum += (n + 1) / 2;
       }
       return sum;
    }
}
