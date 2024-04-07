package com.ss.leetcode.LC2024.april;

import java.util.LinkedList;

public class ValidParenthesisString {
    // https://leetcode.com/problems/valid-parenthesis-string
    /** Algorithm
        1. Traverse and get a LinkedList of star indices AND one LL of indices of unclosable parentheses EG: ((, )), ))((
        2. Starting from back of unclosable, remove last item
            - if item is (, then this needs to be matched with the last or latest index of stars (removeLast).
              If the index of lastStar < this index,  (eg: last star = 3, last ( = 5, then this cannot be closed with a star
            - if item is ), then remove stars from tbe back until you reach a star with index < that index.
              If such index cannot be found, return false.
        3. Return true if unclosable has been emptied.
     */
    public boolean checkValidString(String s) {
        LinkedList<Integer> stars = new LinkedList<>();
        LinkedList<Integer> openAndClose = new LinkedList<>();
        traverseString(s, stars, openAndClose);
        return openAndClose.isEmpty() || isValid(s, stars, openAndClose);
    }

    private boolean isValid(String s, LinkedList<Integer> stars, LinkedList<Integer> openAndClose) {
        int listItem;
        boolean isClosed = true;
        char listItemChar;
        while (!openAndClose.isEmpty() && !stars.isEmpty() && isClosed) {
            listItem = openAndClose.removeLast();
            listItemChar = s.charAt(listItem);
            if (listItemChar == '(') {
                isClosed = listItem < stars.removeLast();
            } else {
                isClosed = closeClosingParentheses(listItem, stars);
            }
        }
        return openAndClose.isEmpty() && isClosed;
    }

    private boolean closeClosingParentheses(int index, LinkedList<Integer> stars) {
        while (!stars.isEmpty() && stars.peekLast() > index) {
            stars.removeLast();
        }
        if (stars.isEmpty()) {
            return false;
        }
        stars.removeLast();
        return true;
    }

    private void traverseString(String s, LinkedList<Integer> stars, LinkedList<Integer> openAndClose) {
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '*') {
                stars.addLast(i);
            } else if (ch == '(') {
                openAndClose.addLast(i);
            } else {
                if (!openAndClose.isEmpty() && s.charAt(openAndClose.peekLast()) == '(') {
                    openAndClose.removeLast();
                } else {
                    openAndClose.addLast(i);
                }
            }
        }
    }
}
