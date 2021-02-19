package com.ss.leetcode.february;

import java.util.HashMap;
import java.util.Map;

public class ApplyDiscountEveryNOrders {
    // https://leetcode.com/problems/apply-discount-every-n-orders/
    private final Map<Integer, Integer> productsAndPrices = new HashMap<>();
    private final int nthCustomer;
    private final int discount;
    private int numberOfCustomers;

    public ApplyDiscountEveryNOrders(int n, int discount, int[] products, int[] prices) {
    // public Cashier(int n, int discount, int[] products, int[] prices) {
        this.nthCustomer = n;
        this.discount = discount;
        for(int i = 0; i < products.length; i++) {
            productsAndPrices.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        numberOfCustomers++;
        double bill = 0.0;
        for(int i = 0; i < product.length; i++) {
            bill += amount[i] * productsAndPrices.get(product[i]);
        }
        if (numberOfCustomers == nthCustomer) {
            bill -= (discount * bill) / 100;
            numberOfCustomers = 0;
        }
        return bill;
    }
}
