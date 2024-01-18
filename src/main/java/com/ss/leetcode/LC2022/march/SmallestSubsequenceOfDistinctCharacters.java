package com.ss.leetcode.LC2022.march;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class SmallestSubsequenceOfDistinctCharacters {
    // https://leetcode.com/problems/remove-duplicate-letters/
    // https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
    /** Algorithm
        1. Use an int[26] last to get last pos for each char and a boolean[26] used to mark if a letter is present/used
        2. Use a StringBuilder stb to append chars
        3. From i = 0 to n -1
        4. If currentChar is used, skip
        5. Else, if currentChar < lastFromBuilder and lastPos[lastFromBuilder] > i (last char from builder exists somewhere at the end of the string), then remove that from builder.
        6. Remove chars until builder is empty or last from builder < currentChar
        7. Append to builder and mark used[currentChar] = true
     */
    public String smallestSubsequence(String s) {
        char[] chars = s.toCharArray();
        int[] lastPos = getLastPos(chars);
        StringBuilder stb = new StringBuilder();
        boolean[] used = new boolean[26];
        int codePoint;
        for(int i = 0; i < s.length(); i++) {
            codePoint = chars[i] - 'a';
            if (!used[codePoint]) {
                while(!stb.isEmpty() && stb.charAt(stb.length() -1) > chars[i] && lastPos[stb.charAt(stb.length() -1) - 'a'] > i) {
                    used[stb.charAt(stb.length() -1) - 'a'] = false;
                    stb.setLength(stb.length() - 1);
                }
                stb.append(chars[i]);
                used[codePoint] = true;
            }
        }
        return stb.toString();
    }

    private int[] getLastPos(char[] chars) {
        int[] lastPos = new int[26];
        for (int i = 0; i < chars.length; i++) {
            lastPos[chars[i] - 'a'] = i;
        }
        return lastPos;
    }



    // not working ....
    public String smallestSubsequence2(String s) {
        LinkedHashSet<Character> chars = new LinkedHashSet<>();
        char lastElement = 0, ch;
        for (int i = s.length() - 1; i >= 0; i--) {
            ch = s.charAt(i);
            if (!chars.contains(ch)) {
                chars.add(ch);
                lastElement = ch;
            } else if (ch < lastElement) {
                chars.remove(ch);
                chars.add(ch);
                lastElement = ch;
            }
        }

        StringBuilder stb = new StringBuilder(chars.size());
        chars.forEach(stb::append);
        return stb.reverse().toString();
    }

    public String smallestSubsequence3(String s) {
        if (s.length() < 2) {
            return s;
        }
        DoublyLinkedNode[] nodes = new DoublyLinkedNode[26];
        DoublyLinkedNode head = new DoublyLinkedNode(s.charAt(s.length() -1));
        nodes[s.charAt(s.length() -1) - 'a'] =  head;
        int codePoint, size = 1;
        char ch;
        DoublyLinkedNode newNode;
        for (int i = s.length() -2; i >= 0; i--) {
            ch = s.charAt(i);
            codePoint = ch - 'a';
            if (nodes[codePoint] == null) {
                newNode = new DoublyLinkedNode(ch);
                head.prev = newNode;
                newNode.next = head;
                nodes[codePoint] = newNode;
                head = newNode;
                size++;
            } else if (ch  < head.val) {
                // brake the links by binding prev to next;
                nodes[codePoint].prev.next = nodes[codePoint].next;
                if (nodes[codePoint].next != null) {
                    nodes[codePoint].next.prev = nodes[codePoint].prev.next;
                }
                nodes[codePoint].prev =  null;
                nodes[codePoint].next = head;
                head.prev = nodes[codePoint];
                head = nodes[codePoint];
            }
        }
        char[] answer = new char[size];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = head.val;
            head = head.next;
        }
        return new String(answer);
    }

    private static class DoublyLinkedNode {
        char val;
        DoublyLinkedNode prev;
        DoublyLinkedNode next;
        public DoublyLinkedNode(char val) {
            this.val = val;
        }
    }
}
