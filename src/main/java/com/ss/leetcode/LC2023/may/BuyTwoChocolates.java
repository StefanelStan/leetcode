package com.ss.leetcode.LC2023.may;

public class BuyTwoChocolates {
    // https://leetcode.com/problems/buy-two-chocolates
    /** Algorithm
        1. Get the cheapest and second-cheapest chocolates
        2. If their total price > money, return money, else money - theirSum
     */
    public int buyChoco(int[] prices, int money) {
        int cheapest = Integer.MAX_VALUE, secondCheapest = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price <= cheapest) {
                secondCheapest = cheapest;
                cheapest = price;
            } else if (price < secondCheapest) {
                secondCheapest = price;
            }
        }
        return cheapest + secondCheapest > money ? money : money - (cheapest + secondCheapest);
    }
}
