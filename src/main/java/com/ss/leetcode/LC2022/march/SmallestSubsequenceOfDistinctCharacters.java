package com.ss.leetcode.LC2022.march;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class SmallestSubsequenceOfDistinctCharacters {
    // https://leetcode.com/problems/remove-duplicate-letters/
    // https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
    // Not working completely correctly
    public String smallestSubsequence(String s) {
        Map<Character, CharacterNode> mapOfNodes = new HashMap<>();
        CharacterNode head, currentNode;
        char current = s.charAt(s.length() - 1);
        head = new CharacterNode(current);
        mapOfNodes.put(current, head);
        for (int i = s.length() - 2; i>= 0; i--) {
            current = s.charAt(i);
            if (!mapOfNodes.containsKey(current)) {
                currentNode = new CharacterNode(current);
                currentNode.next = head;
                head.previous = currentNode;
                head = currentNode;
                mapOfNodes.put(current, currentNode);
            } else if (current < head.value) {
                currentNode = mapOfNodes.get(current);
                // break the links
                currentNode.previous.next = currentNode.next;
                if (currentNode.next != null) {
                    currentNode.next.previous = currentNode.previous;
                }
                // adjust head
                head.previous = currentNode;
                currentNode.next = head;
                currentNode.previous = null;
                head = currentNode;
            }
        }
        StringBuilder stb = new StringBuilder(mapOfNodes.size());
        while (head != null) {
            stb.append(head.value);
            head = head.next;
        }
        return stb.toString();
    }

    private static class CharacterNode {
        char value;
        CharacterNode previous;
        CharacterNode next;

        public CharacterNode(char value) {
            this.value = value;
        }
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
