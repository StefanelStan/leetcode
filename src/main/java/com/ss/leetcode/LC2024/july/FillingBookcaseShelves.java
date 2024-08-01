package com.ss.leetcode.LC2024.july;

public class FillingBookcaseShelves {
    // https://leetcode.com/problems/filling-bookcase-shelves
    /** Algorithm
        1. Starting with book 2, you have to chose if you can put it on same shelf as book1 OR you should put in on next shelf.
        2. Use a cache[books][shelfWidth + 1] to compute and calculate the best (min heights) for each book, given the exixting/trail
            of height and width of current shelf.
        3. Return cache[0][0].
     */
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[][] shelves = new int[books.length][shelfWidth + 1];
        return putOnShelves(0, books, 0, 0, shelfWidth, shelves);
    }

    private int putOnShelves(int index, int[][] books, int currWidth, int heighest, int shelfWidth, int[][] shelves) {
        if (index == books.length) {
            return heighest;
        }
        if (shelves[index][currWidth] == 0) {
            shelves[index][currWidth] = Integer.MAX_VALUE;
            // can put on current shelf ?
            if (currWidth + books[index][0] <= shelfWidth) {
                if (currWidth + books[index][0] == shelfWidth) {
                    shelves[index][currWidth] = Math.max(heighest, books[index][1]) + putOnShelves(index + 1, books, 0, 0, shelfWidth, shelves);
                } else {
                    shelves[index][currWidth] = putOnShelves(index + 1, books, currWidth + books[index][0], Math.max(heighest, books[index][1]), shelfWidth, shelves);
                }
            }
            // finish current shelf and go 0 on next
            if (currWidth > 0) {
                shelves[index][currWidth] = Math.min(shelves[index][currWidth], heighest + putOnShelves(index, books, 0, 0, shelfWidth, shelves));
            }
        }
        return shelves[index][currWidth];
    }
}
