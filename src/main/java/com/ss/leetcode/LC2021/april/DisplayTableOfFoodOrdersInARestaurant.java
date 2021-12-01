package com.ss.leetcode.LC2021.april;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DisplayTableOfFoodOrdersInARestaurant {
    // https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> food = new TreeSet<>();
        Map<Integer, Map<String, Integer>> table = addOrdersToTable(orders, food);
        return getDisplayedTable(table, food);
    }

    private Map<Integer, Map<String, Integer>> addOrdersToTable(List<List<String>> orders, Set<String> food) {
        Map<Integer, Map<String, Integer>> table = new TreeMap<>();
        for (List<String> order : orders) {
            food.add(order.get(2));
            int tableNumber =  Integer.parseInt(order.get(1));
            Map<String, Integer> tableFoodOder = table.get(tableNumber);
            if (tableFoodOder == null) {
                tableFoodOder = new HashMap<>();
                tableFoodOder.put(order.get(2), 1);
                table.put(tableNumber, tableFoodOder);
            } else {
                tableFoodOder.merge(order.get(2), 1, Integer::sum);
            }
        }
        return table;
    }

    private List<List<String>> getDisplayedTable(Map<Integer, Map<String, Integer>> orders, Set<String> food) {
        final List<List<String>> displayedTable = new LinkedList<>();
        displayedTable.add(getTableHeader(food));
        orders.forEach((key, value) -> {
            final List<String> row = new LinkedList<>();
            row.add(key.toString());
            food.forEach(existentFood -> row.add(orders.get(key).getOrDefault(existentFood, 0).toString()));
            displayedTable.add(row);
        });
        return displayedTable;
    }

    private List<String> getTableHeader(Set<String> food) {
        List<String> header = new LinkedList<>();
        header.add("Table");
        header.addAll(food);
        return header;
    }
}
