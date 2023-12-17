package com.ss.leetcode.LC2023.december;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignAFoodRatingSystem {
    // https://leetcode.com/problems/design-a-food-rating-system
    /** Algorithm
        1. Create an object FoodItem(food, cuisine, rating)
        2. Use 1 map<String, FoodItem> foodItems that maps the food names to the food objects
        3. Use 2 map<String, TreeSet<FoodItem>> cuisineMap that will group the food by cuisine and will also
            sort  them by comparator.
        4. As we need the items sorted ASC by rating and DESC by foodName, the comparator will compare rating
            (a,b) and then b.foodName.compareTo(a.foodName).
        5. changeRating
            - get the food item from foodItems by foodName
            - remove the item from the cuisineMap
            - update the rating
            - put the item back in the cuisineMap
        6. highestRated
            - return the last entry of TreeSet returned by cuisineMap.get(cuisine).
     */
    private Map<String, FoodItem> foodItems;
    private Map<String, TreeSet<FoodItem>> cuisineMap;
    public DesignAFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        foodItems = new HashMap<>();
        cuisineMap = new HashMap<>();
        populateFood(foods, cuisines, ratings);
    }

    public void changeRating(String food, int newRating) {
        FoodItem item = foodItems.get(food);
        TreeSet<FoodItem> items = cuisineMap.get(item.cuisine);
        // treeset uses comparator to find item. Remove it before updating value
        items.remove(item);
        item.rating = newRating;
        items.add(item);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).last().food;
    }

    private void populateFood(String[] foods, String[] cuisines, int[] ratings) {
        Comparator<FoodItem> foodComparator = Comparator.comparingInt(FoodItem::getRating).thenComparing(f -> f.food, Comparator.reverseOrder());
        for (int i = 0; i < foods.length; i++) {
            FoodItem foodItem = new FoodItem(foods[i], cuisines[i], ratings[i]);
            foodItems.put(foods[i], foodItem);
            cuisineMap.computeIfAbsent(cuisines[i], k -> new TreeSet<>(foodComparator)).add(foodItem);
        }
    }

    private static class FoodItem {
        String food;
        String cuisine;
        int rating;
        public FoodItem(String food, String cuisine, int rating) {
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        public int getRating() {
            return rating;
        }
    }
}
