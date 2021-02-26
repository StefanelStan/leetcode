package com.ss.leetcode.february;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {
    private final List<Integer> products;
    private int lastZero = -1;

    public ProductOfTheLastKNumbers() {
        //public ProductOfNumbers() {
        products = new ArrayList<>(500);
    }

    public void add(int num) {
        if (num == 0) {
            lastZero = products.size();
            products.add(1);
        } else {
            if (products.isEmpty()) {
                products.add(num);
            } else {
                products.add(products.get(products.size() - 1) * num);
            }
        }
    }

    public int getProduct(int k) {
        if (lastZero >= products.size() - k) {
            return 0;
        }
        if (k == products.size()) {
            return products.get(products.size() - 1);
        }
        int currentProduct = products.get(products.size() - 1);
        int prevProduct = k - 1 < 0 ? 1 : products.get(products.size() - k - 1);
        if (prevProduct == 0) {
            return 0;
        }
        return currentProduct / prevProduct;
    }
}
