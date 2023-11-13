package com.ss.leetcode.LC2023.november;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class BusRoutes {
    // https://leetcode.com/problems/bus-routes
    /** Algorithm
        1. Look at the buses: A: [1,2,7] and B: [3,6,7]
            - If you take bus A from any station, you can get off at 7. At 7 you can get into bus B. Vice versa.
            - We observe the station 7 is linking the two buses, thus A <----> B. (undirected graph)
        2. Based on stations, map each station to set of buses and then create a Disjoin Set of busses.
        3. Given 2 stations, s1, s2, they could belong to diff groups of buses: EG: s1 [B1,B2] and s2[B3,B4].
            For each combination s1 x s2, if the two buses are in the same disjoint set, then find out the cost from bx to by.
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        UnionFind uf = new UnionFind(routes.length);
        Set<Integer>[] busHubs = new Set[routes.length];
        int[] minCost = {Integer.MAX_VALUE};
        Map<Integer, Set<Integer>> bussesByBusStop = getBussesByBusStop(routes, uf, busHubs, source, target);
        if (bussesByBusStop == null) {
            return 1;
        }
        findMinBusses(bussesByBusStop, uf, busHubs, minCost, source, target);
        return minCost[0] == Integer.MAX_VALUE ? -1 : minCost[0] + 1;
    }

    private void findMinBusses(Map<Integer, Set<Integer>> bussesByBusStop, UnionFind uf, Set<Integer>[] busHubs, int[] minCost, int source, int destination) {
        int min = Integer.MAX_VALUE;
        Set<Integer> bussesOfSource = bussesByBusStop.get(source);
        Set<Integer> bussesOfDestination = bussesByBusStop.get(destination);
        if (bussesOfSource != null && bussesOfDestination != null) {
            for (int sourceBus : bussesOfSource) {
                for (int destinationBus : bussesOfDestination) {
                    findMinPath(uf, busHubs, minCost, sourceBus, destinationBus);
                }
            }
        }
    }

    private void findMinPath (UnionFind uf, Set<Integer>[] busHubs, int[] minCost, int fromBus, int toBus) {
        if (!uf.areConnected(fromBus, toBus)) {
            return;
        }
        boolean[] visited = new boolean[busHubs.length];
        jumpBusses(busHubs, minCost, fromBus, toBus, visited);
    }

    private void jumpBusses(Set<Integer>[] busHubs, int[] minCost, int currentBus, int targetBus, boolean[] visited) {
        if (currentBus == targetBus) {
            minCost[0] = 0;
            return;
        }
        LinkedList<int[]> nextStops = new LinkedList<>();
        nextStops.add(new int[]{currentBus, 0});
        visited[currentBus] = true;
        int[] head;
        while(!nextStops.isEmpty()) {
            head = nextStops.removeFirst();
            if (busHubs[head[0]] != null) {
                for (int next : busHubs[head[0]]) {
                    if (next == targetBus) {
                        minCost[0] = Math.min(minCost[0], head[1] + 1);
                        return;
                    }
                    if(!visited[next]) {
                        visited[next] = true;
                        nextStops.addLast(new int[]{next, head[1] + 1});
                    }
                }
            }
        }
    }

    private Map<Integer, Set<Integer>> getBussesByBusStop(int[][] routes, UnionFind uf, Set<Integer>[] busHubs, int source, int target) {
        Map<Integer, Set<Integer>> bussesByBusStop = new HashMap<>();
        int foundBoth;
        for (int i = 0; i < routes.length; i++) {
            foundBoth = 0;
            for (int station : routes[i]) {
                foundBoth = (station == source || station == target ? foundBoth + 1 : foundBoth);
                Set<Integer> groups = bussesByBusStop.computeIfAbsent(station, g -> new HashSet<>());
                if (!groups.contains(i)) {
                    for (int existingGroup : groups) {
                        addBusHub(i, existingGroup, busHubs);
                        uf.connect(i, existingGroup);
                    }
                }
                groups.add(i);
                if (foundBoth == 2) {
                    return null;
                }
            }
        }
        return bussesByBusStop;
    }

    private void addBusHub(int bus1, int bus2, Set<Integer>[] busHubs) {
        if (busHubs[bus1] == null) {
            busHubs[bus1] = new HashSet<>();
        }
        if (busHubs[bus2] == null) {
            busHubs[bus2] = new HashSet<>();
        }
        busHubs[bus1].add(bus2);
        busHubs[bus2].add(bus1);
    }

    private static class UnionFind {
        private int[] root;

        public UnionFind(int size) {
            root = new int[size];
            for (int i = 1; i < size; i++) {
                root[i] = i;
            }
        }

        public boolean areConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }

        public void connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                root[root2] = root1;
            }
        }

        private int find(int node) {
            if (root[node] != node) {
                root[node] = find(root[node]);
            }
            return root[node];
        }
    }
}
