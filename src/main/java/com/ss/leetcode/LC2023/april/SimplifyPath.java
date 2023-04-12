package com.ss.leetcode.LC2023.april;

import java.util.LinkedList;

public class SimplifyPath {
    // https://leetcode.com/problems/simplify-path
    public String simplifyPath(String path) {
        String[] chunks = path.split("/");
        LinkedList<String> fragments = getPathFragments(chunks);
        return simplifyPath(fragments);
    }

    private String simplifyPath(LinkedList<String> fragments) {
        if (fragments.isEmpty()) {
            return "/";
        } else {
            StringBuilder stb = new StringBuilder();
            while(!fragments.isEmpty()) {
                stb.append('/').append(fragments.removeFirst());
            }
            return stb.toString();
        }
    }

    private LinkedList<String> getPathFragments(String[] chunks) {
        LinkedList<String> fragments = new LinkedList<>();
        for (String chunk : chunks) {
            if (chunk.length() > 0) {
                if (chunk.equals("..")) {
                    if (!fragments.isEmpty()) {
                        fragments.removeLast();
                    }
                } else if (!chunk.equals(".")) {
                    fragments.addLast(chunk);
                }
            }
        }
        return fragments;
    }
}
