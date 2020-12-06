package com.ss.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FilterRestaurants {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<>();
        if (veganFriendly == 0) {
            list = getListOfNormalRestaurants(restaurants, maxPrice, maxDistance);
        } else if (veganFriendly == 1) {
            list = getListOfVeganOnlyRestaurants(restaurants, maxPrice, maxDistance);
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] restaurant1, int[] restaurant2) {
                if (restaurant1[1] == restaurant2[1]) {
                    return restaurant1[0] < restaurant2[0] ? 1 : -1;
                } else {
                    return restaurant1[1] < restaurant2[1] ? 1 : -1;
                }
            }
        });
        List<Integer> ids = new ArrayList<>();
        for (int[] element : list) {
            ids.add(element[0]);
        }
        return ids;
    }

    private List<int[]> getListOfNormalRestaurants(int[][] restaurants, int maxPrice, int maxDistance) {
        List<int[]> listofRestaurants = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                listofRestaurants.add(restaurant);
            }
        }
        return listofRestaurants;
    }

    private List<int[]> getListOfVeganOnlyRestaurants(int[][] restaurants, int maxPrice, int maxDistance) {
        List<int[]> listofRestaurants = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (restaurant[2] == 1 && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                listofRestaurants.add(restaurant);
            }
        }
        return listofRestaurants;
    }
}
