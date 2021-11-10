package com.ss.leetcode.november;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<CommonRestaurant> restaurants = new ArrayList<>();
        Map<String, Integer> interests = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            interests.put(list1[i], i);
        }
        Integer rest;
        for (int i = 0; i < list2.length; i++) {
            rest = interests.get(list2[i]);
            if (rest != null) {
                if (restaurants.isEmpty()) {
                    restaurants.add(new CommonRestaurant(list2[i], i + rest));
                } else {
                    if (restaurants.get(restaurants.size() - 1).interest > i + rest) {
                        restaurants.clear();
                        restaurants.add(new CommonRestaurant(list2[i], i + rest));
                    } else if (restaurants.get(restaurants.size() - 1).interest == i + rest) {
                        restaurants.add(new CommonRestaurant(list2[i], i + rest));
                    }
                }
            }
        }
        if (restaurants.isEmpty()) {
            return new String[0];
        }
        String[] commons =  new String[restaurants.size()];
        for (int i = 0; i < restaurants.size(); i++) {
            commons[i] = restaurants.get(i).restaurant;
        }
        return commons;
    }

    private static class CommonRestaurant {
        String restaurant;
        int interest;

        public CommonRestaurant(String restaurant, int interest) {
            this.restaurant = restaurant;
            this.interest = interest;
        }
    }
}
