package com.ss.leetcode.LC2021.november;

public class SimpleBankSystem {
    // https://leetcode.com/problems/simple-bank-system/
    private long[] balance;
    public SimpleBankSystem(long[] balance) {
        this.balance = new long[balance.length];
        System.arraycopy(balance, 0, this.balance, 0, balance.length);
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > balance.length || account2 > balance.length) {
            return false;
        }
        return withdraw(account1, money) && deposit(account2, money);
    }

    public boolean deposit(int account, long money) {
        if (account > balance.length) {
            return false;
        }
        balance[account -1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > balance.length || balance[account-1] < money) {
            return false;
        }
        balance[account -1] -= money;
        return true;
    }
}
