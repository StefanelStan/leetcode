package com.ss.leetcode.LC2022.september;

import java.util.Arrays;
import java.util.Comparator;

public class SortThePeople {
    // https://leetcode.com/problems/sort-the-people/
    public String[] sortPeople(String[] names, int[] heights) {
        Person[] people = new Person[names.length];
        for (int i = 0; i < names.length; i++) {
            people[i] = new Person(names[i], heights[i]);
        }
        return Arrays.stream(people).sorted(Comparator.comparing(Person::height).reversed()).map(Person::name).toArray(String[]::new);
    }

    private record Person (String name, int height) {}


    /** Algorithm - Slow solution
         1. Use an array[n][2] to mark each height and the position of that person in names array.
         2. Sort the array in reverse order
         3. Traverse it and fetch each person as indicated by [1] array (0 stores the height and 1 stores the index of the person)
         4. Return it.
     */
    public String[] sortPeople2(String[] names, int[] heights) {
        int[][] heightsToPeople = new int[heights.length][2];
        for (int i = 0; i < heights.length; i++) {
            heightsToPeople[i][0] = heights[i];
            heightsToPeople[i][1] = i;
        }
        Arrays.sort(heightsToPeople, (a,b) -> b[0] - a[0]);
        String[] sortedPeople = new String[names.length];
        for (int i = 0; i < heightsToPeople.length; i++) {
            sortedPeople[i] = names[heightsToPeople[i][1]];
        }
        return sortedPeople;
    }

    /** Algorithm - FAST solution
         1. Each person has a unique height so an array of String[100_001] would be ideal to mark each height.
         2. Traverse the heights and for each unique height fill in the String array with its name
         3. Traverse the array from 100_000 to 1 and if it is not null, add it to answer array
         4. Return it.
     */
    public String[] sortPeople3(String[] names, int[] heights) {
        String[] highPeople = new String[100_001];
        for (int i = 0; i < names.length; i++) {
            highPeople[heights[i]] = names[i];
        }
        String[] sortedPeople = new String[names.length];
        int insertIndex = 0;
        for (int i = highPeople.length -1; i>= 1; i--) {
            if (highPeople[i] != null) {
                sortedPeople[insertIndex++] = highPeople[i];
            }
        }
        return sortedPeople;
    }
}
