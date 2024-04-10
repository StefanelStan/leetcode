package com.ss.leetcode.LC2024.april;

public class AccountBalanceAfterRoundedPurchase {
    // https://leetcode.com/problems/account-balance-after-rounded-purchase
    /** Algorithm
        1. Determine the closest multiple of ten : div =  amount / 10
        2. Determine the modulo of 10. If mod < 5, it will be rounded down to 0, else rounded up to extra 10
        3. Your amount to 100 - (div * 10 + (mod < 5 ? 0 : 10));
     */
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int div = purchaseAmount / 10;
        int mod = purchaseAmount % 10;
        return 100 - (div * 10 + (mod < 5 ? 0 : 10));
    }
}
