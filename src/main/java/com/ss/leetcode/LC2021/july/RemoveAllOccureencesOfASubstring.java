package com.ss.leetcode.LC2021.july;

public class RemoveAllOccureencesOfASubstring {
    // https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
    public String removeOccurrences(String s, String part) {
        if (s.length() < part.length()) {
            return s;
        }
        CListNode head = generateCLinkedList(s);
        CListNode newHead = removeOccurrences(head, part);
        return buildString(newHead);
    }

    private CListNode generateCLinkedList(String s) {
        CListNode head = new CListNode(s.charAt(0));
        CListNode current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new CListNode(s.charAt(i));
            current = current.next;
        }
        return head;
    }

    private CListNode removeOccurrences(CListNode head, String part) {
        CListNode dummyHead = new CListNode('z', head);
        CListNode currentNode = head;
        CListNode previous = dummyHead;
        while(currentNode != null) {
            if (currentNode.val == part.charAt(0)) {
                PartSearchResult psr = getPartSearchResult(currentNode, part);
                if (psr.isSuccessful) {
                    previous.next = psr.endNode;
                    return removeOccurrences(dummyHead.next, part);
                }
            }
            previous = currentNode;
            currentNode = currentNode.next;
        }
        return dummyHead.next;
    }

    private PartSearchResult getPartSearchResult(CListNode startNode, String part) {
        CListNode currentNode = startNode;
        int searchedNodes = 0;
        for (int i = 0; i < part.length() && currentNode != null; i++, searchedNodes++) {
            if (part.charAt(i) != currentNode.val) {
                return new PartSearchResult(false, null);
            }
            currentNode = currentNode.next;
        }
        if (searchedNodes == part.length()) {
            return new PartSearchResult(true, currentNode);
        } else {
            return new PartSearchResult(false);
        }
    }

    private String buildString(CListNode head) {
        StringBuilder stb = new StringBuilder();
        CListNode current = head;
        while (current != null) {
            stb.append(current.val);
            current = current.next;
        }
        return stb.toString();
    }

    private static class CListNode {
        char val;
        CListNode next;

        public CListNode(char val) {
            this.val = val;
        }

        public CListNode(char val, CListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static class PartSearchResult {
        boolean isSuccessful;
        CListNode endNode;

        public PartSearchResult(boolean isSuccessful) {
            this.isSuccessful = isSuccessful;
        }

        public PartSearchResult(boolean isSuccessful, CListNode endNode) {
            this.isSuccessful = isSuccessful;
            this.endNode = endNode;
        }
    }

    // much faster, easier but ..dumber!
    public String removeOccurrences2(String s, String part) {
        while(true) {
            int index = s.indexOf(part);
            if (index < 0) {
                break;
            }
            s = s.substring(0, index) + s.substring(index + part.length());
        }
        return s;
    }
}
