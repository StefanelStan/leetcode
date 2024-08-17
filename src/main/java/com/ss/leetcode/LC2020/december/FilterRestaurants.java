package com.ss.leetcode.LC2020.december;

import java.util.ArrayList;
import java.util.List;

public class FilterRestaurants {
    // https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> restaurantIndexes = new ArrayList<>();
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i][2] >= veganFriendly && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                restaurantIndexes.add(i);
            }
        }
        restaurantIndexes.sort((a, b) -> restaurants[b][1] == restaurants[a][1]
            ? Integer.compare(restaurants[b][0], restaurants[a][0])
            : Integer.compare(restaurants[b][1], restaurants[a][1]));
        List<Integer> ids = new ArrayList<>(restaurantIndexes.size());
        for (int index : restaurantIndexes) {
            ids.add(restaurants[index][0]);
        }
        return ids;
    }


    public List<Integer> filterRestaurants2(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<>();
        if (veganFriendly == 0) {
            list = getListOfNormalRestaurants(restaurants, maxPrice, maxDistance);
        } else if (veganFriendly == 1) {
            list = getListOfVeganOnlyRestaurants(restaurants, maxPrice, maxDistance);
        }
        list.sort((restaurant1, restaurant2) -> {
            if (restaurant1[1] == restaurant2[1]) {
                return restaurant1[0] < restaurant2[0] ? 1 : -1;
            } else {
                return restaurant1[1] < restaurant2[1] ? 1 : -1;
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
