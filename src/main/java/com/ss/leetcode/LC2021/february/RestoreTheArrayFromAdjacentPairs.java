package com.ss.leetcode.LC2021.february;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreTheArrayFromAdjacentPairs {
    // https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
    // PRO MODE
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] restored = new int[adjacentPairs.length + 1];
        int insertIndex = 0;
        Map<Integer, List<Integer>> neighbours = getNeighbours(adjacentPairs);
        List<Integer> nextNeighbours;
        int nextElement = getFirstElement(neighbours), prevElement = Integer.MAX_VALUE;
        restored[insertIndex++] = nextElement;
        while(insertIndex < restored.length) {
            nextNeighbours = neighbours.get(restored[insertIndex -1]);
            if (!nextNeighbours.isEmpty() && nextNeighbours.get(0) != nextElement && nextNeighbours.get(0) != prevElement) {
                restored[insertIndex++] = nextNeighbours.get(0);
            } else if (nextNeighbours.size() > 1 && nextNeighbours.get(1) != nextElement && nextNeighbours.get(1) != prevElement) {
                restored[insertIndex++] = nextNeighbours.get(1);
            }
            prevElement = nextElement;
            nextElement = restored[insertIndex -1];
        }
        return restored;
    }

    private Map<Integer, List<Integer>> getNeighbours(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> neighbours = new HashMap<>();
        for(int[] pair : adjacentPairs) {
            neighbours.computeIfAbsent(pair[0], i -> new ArrayList<>()).add(pair[1]);
            neighbours.computeIfAbsent(pair[1], i -> new ArrayList<>()).add(pair[0]);
        }
        return neighbours;
    }

    private int getFirstElement(Map<Integer, List<Integer>> neighbours) {
        for(Map.Entry<Integer, List<Integer>> entry : neighbours.entrySet()) {
            if (entry.getValue().size() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }



    // change it with links: link 1 and link 2
    public int[] restoreArray2(int[][] adjacentPairs) {
        final Map<Integer, Neighbours> nodes = new HashMap<>();
        parseNumbersIntoPairs(nodes, adjacentPairs);
        int[] restoredArray = restoreArray(nodes);
        return restoredArray;
    }

    private void parseNumbersIntoPairs(Map<Integer, Neighbours> nodes, int[][] adjacentPairs) {
        for (int[] pair : adjacentPairs) {
            addToNode(nodes, pair[0], pair[1]);
            addToNode(nodes, pair[1], pair[0]);
        }
    }

    private void addToNode(Map<Integer, Neighbours> nodes, int key, int value) {
        Neighbours neighbours = nodes.get(key);
        if (neighbours == null) {
            neighbours = new Neighbours(value);
            nodes.put(key, neighbours);
        } else {
            neighbours.addSecondNeighbour(value);
        }
    }

    private int[] restoreArray(Map<Integer, Neighbours> nodes) {
        int[] array = new int[nodes.size()];
        int head = getHeadNode(nodes);
        int headNext = nodes.get(head).firstNeighbour;
        array[0] = head;
        array[1] = headNext;
        for (int i = 2; i < nodes.size(); i++) {
            Neighbours neighbours = nodes.get(array[i - 1]);
            if (neighbours.firstNeighbour != array[i - 2]) {
                array[i] = neighbours.firstNeighbour;
            } else if(neighbours.hasSecondNeighbour && neighbours.secondNeighbour != array[i -2]) {
                array[i] = neighbours.secondNeighbour;
            }
        }
        return array;
    }

    private int getHeadNode(Map<Integer, Neighbours> nodes) {
        for (Map.Entry<Integer, Neighbours> entry : nodes.entrySet()) {
            if (!entry.getValue().hasSecondNeighbour)
                return entry.getKey();
        }
        throw new RuntimeException("Nodes and pairs do not have a head!");
    }

    private static class Neighbours {
        boolean hasFirstNeighbour;
        boolean hasSecondNeighbour;

        int firstNeighbour;
        int secondNeighbour;

        public Neighbours(int firstNeighbour) {
            this.hasFirstNeighbour = true;
            this.firstNeighbour = firstNeighbour;
        }

        public void addSecondNeighbour(int secondNeighbour) {
            this.hasSecondNeighbour = true;
            this.secondNeighbour = secondNeighbour;
        }
    }

    /**
     * Junk impltementation with doubley linked lists. Not performant as it requires to change the orientation each time
     * there is a matching direction conflict.
     private void parseNumbersIntoPairs(Map<Integer, Node> nodes, int[][] adjacentPairs) {
     for (int[] adjacentPair : adjacentPairs) {
     connectPair(nodes, getOrCreateNode(nodes, adjacentPair[0]), getOrCreateNode(nodes, adjacentPair[1]));
     }
     }

     public void connectPair(Map<Integer, Node> nodes, Node node1, Node node2) {
     if (node1.next == null && node2.previous == null) {
     node1.next = node2;
     node2.previous = node1;
     } else if (node1.previous == null && node2.next == null) {
     node1.previous = node2;
     node2.next = node1;
     } else {
     switchNodeOrientation(nodes, node1);
     connectPair(nodes, node1, node2);
     }
     }

     private Node getOrCreateNode(Map<Integer, Node> nodes, int value) {
     Node n = nodes.get(value);
     if (n == null) {
     n = new Node(value);
     nodes.put(value, n);
     }

     return n;
     }

     private void switchNodeOrientation(Map<Integer, Node> nodes, Node node) {
     if (node.previous == null) {
     swapAllNodesToLeft(nodes, node, node.next);
     } else {
     swapAllNodesToRight(nodes, node, node.previous);
     }
     }

     private void swapAllNodesToRight(Map<Integer, Node> nodes, Node node, Node previousNode) {
     if (node == null || previousNode == null) {
     return;
     }
     node.next = previousNode;
     int moreLeftNode = 0;
     if (previousNode.previous != null) {
     previousNode.previous.next = null;
     moreLeftNode = previousNode.previous.item;
     }

     previousNode.next = null;
     previousNode.previous = node;
     //        node.previous = null;
     if (node.previous != null && node.next.item == node.previous.item) node.previous = null;
     swapAllNodesToRight(nodes, previousNode, nodes.get(moreLeftNode));
     }

     private void swapAllNodesToLeft(Map<Integer, Node> nodes, Node node, Node nextNode) {
     if (node == null || nextNode == null) {
     return;
     }
     node.previous = nextNode;
     int moreRightNode = 0;
     if (nextNode.next != null) {
     moreRightNode = nextNode.next.item;
     nextNode.next.previous = null;
     }
     nextNode.previous = null;
     nextNode.next = node;
     if (node.next != null && node.next.item == node.previous.item) node.next = null;
     swapAllNodesToLeft(nodes, nextNode, nodes.get(moreRightNode));
     }

     private Node getHeadNode(Map<Integer, Node> nodes) {
     for (Node n : nodes.values()) {
     if (n.previous == null) {
     return n;
     }
     }
     throw new RuntimeException("Head node does not exist");
     }


     private static class Node {
     int item;
     Node previous;
     Node next;

     public Node(int item) {
     this.item = item;
     }
     }
     **/
}
