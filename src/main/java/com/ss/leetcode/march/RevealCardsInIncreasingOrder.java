package com.ss.leetcode.march;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevealCardsInIncreasingOrder {
    // https://leetcode.com/problems/reveal-cards-in-increasing-order/solution/
//    public int[] deckRevealedIncreasing(int[] deck) {
//        if (deck.length == 1 ) {
//            return deck;
//        }
//        Arrays.sort(deck);
//        if (deck.length % 2 == 0) {
//            return sortEvenDeck(deck);
//        } else {
//            return sortOddDeck(deck);
//        }
//    }
//
//    private int[] sortEvenDeck(int[] deck) {
//        int[] sortedDeck = new int[deck.length];
//        for (int i = 0, j = 0; i < deck.length; i += 2, j++) {
//            sortedDeck[i] = deck[j];
//        }
//        sortedDeck[1] = deck[deck.length / 2];
//        if (deck.length == 6) {
//            sortedDeck[deck.length /2] = deck[deck.length -1];
//            sortedDeck[deck.length -1] = deck[deck.length -2];
//        } else {
//            sortedDeck[deck.length - 1] = deck[deck.length - 1];
//            for (int i = deck.length / 2 + 1, j = deck.length - 3; i <= deck.length - 2; i++, j -= 2) {
//                sortedDeck[j] = deck[i];
//            }
//        }
//
//        return sortedDeck;
//    }
//
//    private int[] sortOddDeck(int[] deck) {
//        int[] sortedDeck = new int[deck.length];
//        for (int i = 0, j = 0; i < deck.length; i += 2, j++) {
//            sortedDeck[i] = deck[j];
//        }
//        if (deck.length == 5) {
//            sortedDeck[3] = deck[deck.length - 2];
//            sortedDeck[1] = deck[deck.length - 1];
//        } else {
//            sortedDeck[deck.length - 2] = deck[deck.length - 1];
//            for (int i = deck.length / 2 + 1, j = deck.length - 4; i <= deck.length - 2; i++, j -= 2)
//                sortedDeck[j] = deck[i];
//        }
//        return sortedDeck;
//    }

    /**
     * The basic idea is to sort the deck.
     * Begin filling by the tactic: fill one, skip one spot (in case the spot is free) with the numbers from the sorted deck.
     * I tried something similar by skipping/filling every 4 spots
     * https://leetcode.com/problems/reveal-cards-in-increasing-order/discuss/504896/java-solution-without-queue
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int i = 0;
        int j = 0;
        boolean skip = false;
        int[] orderedDeck = new int[deck.length];
        while (i < deck.length) {
            if (orderedDeck[j] != 0) {
                j = (j + 1) % deck.length;
                continue;
            }
            if (skip) {
                skip = false;
            } else {
                orderedDeck[j] = deck[i++];
                skip = true;
            }
            j = (j + 1) % deck.length;
        }
        return orderedDeck;
    }
}


