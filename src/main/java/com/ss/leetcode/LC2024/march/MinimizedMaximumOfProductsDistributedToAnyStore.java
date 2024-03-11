package com.ss.leetcode.LC2024.march;

public class MinimizedMaximumOfProductsDistributedToAnyStore {
    // https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store
    /** Algorithm
        1. Apply binary search to determine if using a ratio would suffice the deliveries
        2. EG: n = 4, quantity = 100.
            -  ratio = 20. This would suffice for 5 (100/20)stores, but we only have 4. Too low ratio
            - ration = 50 => 100/50 => 2 stores. This works, can we make the ratio lower?
        3. Apply binary search to determine the min ratio (1-100000) to use to deliver the quantities.
     */
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1, high = 100000, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (canDeliver(n, quantities, pivot)) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return low;
    }

    private boolean canDeliver(int stores, int[] quantities, int ratio) {
        int qi = 0, deliveredStores = 0;
        while (qi < quantities.length && deliveredStores < stores) {
            deliveredStores += (quantities[qi] / ratio);
            deliveredStores += (quantities[qi] % ratio == 0 ? 0 : 1);
            qi++;
        }
        return deliveredStores <= stores && qi == quantities.length;
    }
}
