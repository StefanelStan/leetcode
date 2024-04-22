package com.ss.leetcode.LC2024.april;

import java.util.LinkedList;

public class OpenTheLock {
    //
    /** Algorithm
        1. Looking at the number 123, we see 6 possibilities: [023, 223] (turn left/right on 1st digit),
            [113,133]  -turn left/right the 2nd digit, [122,124] - turn right the 3rd digit.
        2. Actually, these are connections in a GRAPH. If the result is NOT a deadend, then we can draw an edge between these two nodes.
        3. We observe that we can BFS from destination (0,0,0,0) (starting point) to target, stopping when we hit target OR there are no more nodes to visit.
        4. Starting from source (0,0,0,0), shift each digit to the right and to the left.
        5. Shifting:
            EG: 1234 -> to shift 1st digit to the right: we ad 1000, to shift LEFT we deduct 1000 (or add -1000)
        6. In a loop (1, 10, 100, 1000) shift each digit add add it to the linkedList/queue to visit (if not blocked or visited)
     */
    public int openLock(String[] deadends, String target) {
        boolean[] blocked = new boolean[10000];
        for (String deadend : deadends) {
            blocked[Integer.parseInt(deadend)] = true;
        }
        return blocked[0] ? -1 : visitNodes(new boolean[10000], blocked, Integer.parseInt(target));
    }

    private int visitNodes(boolean[] visited, boolean[] blocked, int target) {
        int minSteps = Integer.MAX_VALUE;
        int size = 0, currentNode, steps = 0;
        LinkedList<Integer> nodes = new LinkedList<>();
        visited[0] = true;
        nodes.add(0);
        while (!nodes.isEmpty()) {
            size = nodes.size();
            while (size > 0) {
                currentNode = nodes.removeFirst();
                size--;
                if (currentNode == target) {
                    return steps;
                }
                addAllNeighbours(currentNode, visited, blocked, nodes);
            }
            steps++;
        }
        return -1;
    }

    private void addAllNeighbours(int from, boolean[] visited, boolean[] blocked, LinkedList<Integer> nodes) {
        int copyFrom = from, mod, upperBonus, lowerBonus;
        for (int units = 1; units <= 1000; units *= 10) {
            mod = copyFrom % 10;
            upperBonus = mod < 9 ? units : (-9 * units); // (UP: 9 becomes 0 so we need to deduct 9 * units (10s, 100s, 1000s))
            lowerBonus = mod > 0 ? -units : (9 * units); // (DOWN: 0 becomes 9 so we need to add 9 * units: 10s,100s, 1000s)
            copyFrom = copyFrom / 10;
            if (!visited[from + upperBonus] && !blocked[from + upperBonus]) {
                nodes.addLast(from + upperBonus);
                visited[from + upperBonus] = true;
            }
            if (!visited[from + lowerBonus] && !blocked[from + lowerBonus]) {
                nodes.addLast(from + lowerBonus);
                visited[from + lowerBonus] = true;
            }
        }
    }
}
