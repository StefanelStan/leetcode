package com.ss.leetcode.march;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DesignBrowserHistory {
    // https://leetcode.com/problems/design-browser-history/
    private final List<String> urls = new ArrayList<>();
    int currentIndex = 0;

    public DesignBrowserHistory(String homepage) {
        urls.add(homepage);
    }

    public void visit(String url) {
        currentIndex++;
        urls.add(currentIndex, url);
        if (currentIndex < urls.size() - 1) {
            ListIterator<String> li = urls.listIterator(currentIndex + 1);
            while (li.hasNext()) {
                li.next();
                li.remove();
            }
        }
    }

    public String back(int steps) {
        if (steps > currentIndex) {
            currentIndex = 0;
        } else {
            currentIndex -= steps;
        }
        return urls.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex += steps;
        if (currentIndex > urls.size() - 1) {
            currentIndex = urls.size() - 1;
        }
        return urls.get(currentIndex);
    }
}
