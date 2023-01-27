package com.ss.leetcode.LC2023.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheapestFlightsWithinKStops {
    // https://leetcode.com/problems/cheapest-flights-within-k-stops
    // BELLMAN FORD
    // https://leetcode.com/problems/cheapest-flights-within-k-stops/solutions/2825208/cheapest-flights-within-k-stops/?orderBy=newest_to_oldest
    // https://www.youtube.com/watch?v=lyw4FaxrwHg
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Distance from source to all other nodes.
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Run only K+1 times since we want shortest distance in K hops
        for (int i = 0; i <= k; i++) {
            // Create a copy of dist vector.
            int[] temp = Arrays.copyOf(dist, n);
            for (int[] flight : flights) {
                if (dist[flight[0]] != Integer.MAX_VALUE) {
                    temp[flight[1]] = Math.min(temp[flight[1]], dist[flight[0]] + flight[2]);
                }
            }
            // Copy the temp vector into dist.
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }



    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        Node[] cities = buildFlightGraph(n, flights);
        boolean[] visited = new boolean[n+1];
        int[] lowestCost = {Integer.MAX_VALUE};
        traverseGraph(cities[src], cities, 0, 0, dst, k + 1, visited, lowestCost);
        return lowestCost[0] == Integer.MAX_VALUE ? -1 : lowestCost[0];
    }

    private Node[] buildFlightGraph(int n, int[][] flights) {
        Node[] cities = new Node[n+1];
        for (int[] flight : flights) {
            if (cities[flight[0]] == null) {
                cities[flight[0]] = new Node(flight[0]);
            }
            if (cities[flight[1]] == null) {
                cities[flight[1]] = new Node(flight[1]);
            }
            cities[flight[0]].addDestination(flight[1], flight[2]);
        }
        return cities;
    }

    private void traverseGraph(Node city, Node[] cities, int stepsSoFar, int costSoFar, int dest, int maxSteps, boolean[] visited, int[] lowestCost) {
        if (city != null && stepsSoFar <= maxSteps && !visited[city.cityNumber]) {
            visited[city.cityNumber] = true;
            if (city.cityNumber == dest) {
                lowestCost[0] = Math.min(lowestCost[0], costSoFar);
            } else {
                for (int[] destination : city.destinations) {
                    if (!visited[destination[0]]) {
                        traverseGraph(cities[destination[0]], cities, stepsSoFar + 1, costSoFar + destination[1], dest, maxSteps, visited, lowestCost);
                        visited[destination[0]] = false;
                    }
                }
            }
        }
    }


    private static class Node {
        int cityNumber;
        List<int[]> destinations;

        public Node(int cityNumber) {
            this.cityNumber = cityNumber;
            this.destinations = new ArrayList<>();
        }

        public void addDestination(int to, int cost) {
            destinations.add(new int[]{to, cost});
        }
    }
}
