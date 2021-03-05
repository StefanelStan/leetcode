package com.ss.leetcode.march;

public class QueriesOnAPermutationWithKey {
    public int[] processQueries(int[] queries, int m) {
        if (queries.length == 1) {
            return new int[]{queries[0] -1};
        }
        CircularLinkedList cll = new CircularLinkedList();
        int[] result = new int[queries.length];
        for (int i = 1; i <= m; i++) {
            cll.addNode(i);
        }

        for (int i = 0; i < queries.length; i++) {
            moveElementToFrontOfList(cll, queries[i], result, i);
        }

        return result;
    }

    private void moveElementToFrontOfList(CircularLinkedList cll, int index, int[] result, int i1) {
        CircularLinkedList.Node prevNode = cll.getHead();
        CircularLinkedList.Node nextNode = prevNode.nextNode;
        int position = 0;
        while (nextNode != null) {
            if (nextNode.getValue() == index) {
                prevNode.setNextNode(nextNode.getNextNode());
                if (cll.tail == nextNode) {
                    cll.tail = prevNode;
                }
                nextNode.setNextNode(cll.getHead());
                cll.head = nextNode;
                result[i1] = position +1;
                break;
            } else if (prevNode.getValue() == index) {
                result[i1] = position;
                break;
            }
            position++;
            prevNode = nextNode;
            nextNode = nextNode.getNextNode();
        }
    }

    private static final class CircularLinkedList {

        private Node head = null;
        private Node tail = null;
        private int size;

        public Node addNode(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
            } else {
                tail.nextNode = newNode;
            }

            tail = newNode;
            tail.nextNode = head;
            size++;

            return newNode;
        }

        public Node getHead() {
            return head;
        }

        public int getSize() {
            return size;
        }

        static class Node {
            private final int value;
            private Node nextNode;

            public Node(int value) {
                this.value = value;
            }

            public int getValue() {
                return value;
            }

            public Node getNextNode() {
                return nextNode;
            }

            public void setNextNode(Node nextNode) {
                this.nextNode = nextNode;
            }
        }
    }
}
